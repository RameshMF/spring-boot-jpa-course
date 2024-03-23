package com.springdatajpa.springboot.order.service;

import com.michaels.mik.order.contant.OrderContant;
import com.michaels.mik.order.entity.Order;
import com.michaels.mik.order.repository.OrderRepository;
import com.michaels.mik.shared.common.BusinessCode;
import com.michaels.mik.shared.exception.ServiceUnavailableException;
import com.michaels.mik.shared.remote.properties.MohProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;


@Service
public class OrderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderRepository orderRepository;

    @Resource
    private HttpServletResponse response;

    private final MohProperties mohProperties;
    private final RestTemplate restTemplate;


    public OrderService(MohProperties mohProperties, RestTemplate restTemplate) {
        this.mohProperties = mohProperties;
        this.restTemplate = restTemplate;
    }


    public void exportOrderDetails(String orderNumber) throws IOException {
        UriComponents url = UriComponentsBuilder.newInstance()
                .scheme(mohProperties.getApiSchema())
                .host(mohProperties.getApiHost())
                .path(mohProperties.getEaExportSellerOrderNumbersList())
                .queryParam("orderNumber", orderNumber)
                .queryParam("channel", OrderContant.HANDMADE_THREE)
                .build();
        byte[] result;
        OutputStream outputStream = response.getOutputStream();
        try {
            result = restTemplate.getForObject(url.toUriString(), byte[].class);
            response.setContentType(OrderContant.APPLICATION_VND_MS_EXCEL);
            response.setCharacterEncoding(OrderContant.UTF_8);
            if (result != null) {
                outputStream.write(result);
                outputStream.flush();
            }
        } catch (Exception e) {
            LOGGER.error("exportOrderDetails orderNumber:{} e", orderNumber, e);
            throw new ServiceUnavailableException(BusinessCode.MIK_SERVICE_FAILED, e.getMessage());
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    public List<Order> exportAllOrdersDetails(Long storeId) {
        return orderRepository.findAllByStoreId(storeId);
    }

}
