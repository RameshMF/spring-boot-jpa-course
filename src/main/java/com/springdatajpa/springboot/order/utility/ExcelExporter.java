package com.springdatajpa.springboot.order.utility;

import com.michaels.mik.order.entity.Order;
import com.michaels.mik.order.entity.OrderStatus;
import com.michaels.mik.shared.exception.BadRequestException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static org.apache.poi.ss.util.CellUtil.createCell;

public class ExcelExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private Order order;
    private List<Order> orders;

    public ExcelExporter(Order order) {
        this.order = order;
        workbook = new XSSFWorkbook();
    }

    public ExcelExporter(List<Order> orders) {
        this.orders = orders;
        workbook = new XSSFWorkbook();
    }

    private void writeHeaderLine() {
        sheet = workbook.createSheet("singleOrder");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "Order Status", style);
        createCell(row, 1, "Order Date", style);
        createCell(row, 2, "Order Number", style);
        createCell(row, 3, "Customer Name", style);
        createCell(row, 4, "Subtotal", style);
        createCell(row, 5, "Discount", style);
        createCell(row, 6, "Tax", style);
        createCell(row, 7,"Shipping Fee", style);
        createCell(row, 8, "Total Price", style);
    }

    //todo: Temp use. Whether merge with writeOrdersDataLines or not depends on if sorting rules are needed for bulk export.
    // Currently waiting for UX response
    private void writeSingleOrderDataLine() {
        int rowCount = 1;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(12);
        style.setFont(font);

        Row row = sheet.createRow(rowCount);
        int columnCount = 0;

        createCell(row, columnCount++, OrderStatus.getEnumFromValue(order.getStatus()).toString(), style);
        createCell(row, columnCount++, order.getCreatedTime().toString(), style);
        createCell(row, columnCount++, order.getOrderNumber(), style);
        createCell(row, columnCount++, order.getFirstName() + " " + order.getLastName(), style);
        createCell(row, columnCount++, order.getItemsSubtotal().toString(), style);
        createCell(row, columnCount++, order.getTotalDiscount().toString(), style);
        createCell(row, columnCount++, order.getEstimatedTax().toString(), style);
        createCell(row, columnCount++, order.getShippingHandlingCharge().toString(), style);
        createCell(row, columnCount++, order.getGrandTotalCollected().toString(), style);
    }

    //todo: Temp use. Whether merge with writeSingleOrderDataLine or not depends on if sorting rules are needed for bulk export
    // Currently waiting for UX response
    public void writeOrdersDataLines() {
        int rowCount = 1;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(12);
        style.setFont(font);

        for (Order singleOrder: orders) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, OrderStatus.getEnumFromValue(singleOrder.getStatus()).toString(), style);
            createCell(row, columnCount++, singleOrder.getCreatedTime().toString(), style);
            createCell(row, columnCount++, singleOrder.getOrderNumber(), style);
            createCell(row, columnCount++, singleOrder.getFirstName() + " " + singleOrder.getLastName(), style);
            createCell(row, columnCount++, singleOrder.getItemsSubtotal().toString(), style);
            createCell(row, columnCount++, singleOrder.getTotalDiscount().toString(), style);
            createCell(row, columnCount++, singleOrder.getEstimatedTax().toString(), style);
            createCell(row, columnCount++, singleOrder.getShippingHandlingCharge().toString(), style);
            createCell(row, columnCount++, singleOrder.getGrandTotalCollected().toString(), style);
        }
    }

    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        if (order != null && orders == null) {
            writeSingleOrderDataLine();
        } else {
            writeOrdersDataLines();
        }

        ServletOutputStream outputStream = response.getOutputStream();
        try {
            workbook.write(outputStream);
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        } finally {
            workbook.close();
            outputStream.close();
        }
    }
}
