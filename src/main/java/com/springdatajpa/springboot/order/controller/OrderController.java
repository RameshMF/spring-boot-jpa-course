package com.springdatajpa.springboot.order.controller;

import com.michaels.mik.order.entity.Order;
import com.michaels.mik.order.service.OrderService;
import com.michaels.mik.order.utility.ExcelExporter;
import com.michaels.mik.shared.common.BusinessCode;
import com.michaels.mik.shared.exception.MikException;
import com.michaels.mik.shared.exception.NotFoundException;
import com.michaels.security.annotation.RequireAuth;
import com.michaels.security.auth.AuthContext;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/order")
@Tag(
        name = "Order Controller",
        description = "Contains endpoints for seller order management"
)
public class OrderController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
    private final OrderService service;

    @Autowired
    public OrderController(final OrderService service){
        this.service = service;
    }

    @Operation(security = @SecurityRequirement(name = "bearerAuth"), summary = "export an excel file including details of that single order record")
    @GetMapping(path = "/export/single")
    @RequireAuth
    @Deprecated
    public void exportSingleToExcel(@RequestParam final String orderNumber) throws IOException {
        service.exportOrderDetails(orderNumber);
    }

    //todo: currently (04/29) no response from UX, so the export all orders means without any timeframe filter nor status filter.
    @Operation(security = @SecurityRequirement(name = "bearerAuth"), summary = "export an excel file including details of all orders")
    @GetMapping(path = "/export/allOrders")
    @RequireAuth
    public void exportAllToExcel(HttpServletResponse response) throws IOException {
        LOGGER.debug(this.getClass().getSimpleName() + ".exportAllOrders start");

        AuthContext authContext = AuthContext.get();
        if (Objects.isNull(authContext.getSellerStoreId())) {

            throw new MikException(BusinessCode.MIK_UNAUTHORIZED_ACCESS.getMessage());

        }

        List<Order> orders = service.exportAllOrdersDetails(authContext.getSellerStoreId());
        if (orders == null) {
            throw new NotFoundException("No order data is found");
        }

        response.setContentType("application/vnd.ms-excel");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=orders_all.xlsx";
        response.setHeader(headerKey, headerValue);
        ExcelExporter excelExporter = new ExcelExporter(orders);
        excelExporter.export(response);

        LOGGER.debug(this.getClass().getSimpleName() + ".exportAllOrders end");
    }
}




