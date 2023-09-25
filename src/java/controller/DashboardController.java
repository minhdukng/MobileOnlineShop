/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ColorDAO;
import dao.OrderDAO;
import dao.OrderDetailDAO;
import dao.ProductDAO;
import dao.ProductVariantDAO;
import dao.StorageDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.ProductVariant;

/**
 *
 * @author 84834
 */
public class DashboardController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderDAO orderDao = new OrderDAO();
        OrderDetailDAO detailDao = new OrderDetailDAO();
        ProductVariantDAO variantDao = new ProductVariantDAO();
        StorageDAO stoDao = new StorageDAO();
        ColorDAO colorDao = new ColorDAO();
        ProductDAO productDao = new ProductDAO();

        LocalDate date = LocalDate.now();
        Month month = date.getMonth();
        int year = date.getYear();
        float totalMonth = orderDao.TotalPriceMonth(year, month);
        float totalYear = orderDao.TotalPriceYear(year);

        HashMap<Integer, String> storageMap = (HashMap<Integer, String>) stoDao.getHashMapStorage();
        HashMap<Integer, String> colorMap = (HashMap<Integer, String>) colorDao.getHashMapColor();
        HashMap<Integer, String> productMap = (HashMap<Integer, String>) productDao.getHashMapProduct();

        int hot_id = detailDao.getHotProductID();
        ProductVariant hot_product = variantDao.getProductVariantByID(hot_id);
        List<String> hot = new ArrayList<>();
        if (hot_id != 0) {
            hot.add(productMap.get(hot_product.getProductId()));
            hot.add(colorMap.get(hot_product.getColorId()));
            hot.add(storageMap.get(hot_product.getStorageId()));
            hot.add(String.valueOf(hot_product.getVariantPrice()));
            hot.add(String.valueOf(hot_product.getQuantity()));
        } else {
            hot.add(" ");
            hot.add(" ");
            hot.add(" ");
            hot.add(" ");
            hot.add(" ");
        }

        ProductVariant cold_product = variantDao.getColdProductVariant();
        List<String> cold = new ArrayList<>();
        if (cold_product != null) {
            cold.add(productMap.get(cold_product.getProductId()));
            cold.add(colorMap.get(cold_product.getColorId()));
            cold.add(storageMap.get(cold_product.getStorageId()));
            cold.add(String.valueOf(cold_product.getVariantPrice()));
            cold.add(String.valueOf(cold_product.getQuantity()));
        } else {
            cold.add(" ");
            cold.add(" ");
            cold.add(" ");
            cold.add(" ");
            cold.add(" ");
        }
        req.setAttribute("month", totalMonth);
        req.setAttribute("year", totalYear);
        req.setAttribute("hot", hot);
        req.setAttribute("cold", cold);

        req.getRequestDispatcher("/screens/Admin_Dashboard.jsp").forward(req, resp);
    }

}