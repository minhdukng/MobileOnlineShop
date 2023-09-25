/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.ProductDetailDAO;
import dao.ProductVariantDAO;
import dao.SaleDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Color;
import model.Product;
import model.ProductImage;
import model.ProductVariant;
import model.Sale;
import model.Storage;
import utilities.Helper;

/**
 *
 * @author kienk
 */
public class ProductDetailController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductDetail</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductDetail at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        ProductDetailDAO pDao = new ProductDetailDAO();
        ProductVariantDAO pvd = new ProductVariantDAO();
        SaleDAO sd = new SaleDAO();
        String productName = request.getParameter("productName");
        Product product = pDao.getProductbyName(productName);
        String colorName = request.getParameter("colorName");
        String storageId = request.getParameter("storageId");
        Storage s = pDao.getStoragebyId(request.getParameter("storageId"));
        String storageSize = "";
        if (s != null){
            storageSize = s.getStorageSize();
        }
        int temp = pDao.getColorIdByName(colorName);
        List<ProductImage> pImageList;
        if (temp == 0){
            pImageList = pDao.getProductImage(product.getId(), "");
        }else{
            String colorId = temp + "";
            pImageList = pDao.getProductImage(product.getId(), colorId);
            request.setAttribute("colorName", colorName);
        }
        if (s != null && temp != 0){
            ProductVariant pv = pvd.getProductVariant(temp + "", product.getId() + "", s.getId() + "");
            Sale sale = sd.getSaleById(pv.getSaleId());
            float price = pv.getVariantPrice() - (pv.getVariantPrice()*sale.getPercent())/100;
            request.setAttribute("variant", pv);
            request.setAttribute("priceSale", price);
        }
        List<Color> colorList = pDao.getColorListById(product.getId());
        List<Storage> storage = pDao.getStorageListById(product.getId());
        String productDescription = product.getDescription();
        String[] description = Helper.splitText(productDescription, "/");
        request.setAttribute("storageId", storageId);
        request.setAttribute("colorName", colorName);
        request.setAttribute("storage", storage);
        request.setAttribute("product", product);
        request.setAttribute("color", colorList);
        request.setAttribute("image", pImageList);
        request.setAttribute("productName", productName);
        request.setAttribute("storageSize", storageSize);
        request.setAttribute("description", description);
        request.getRequestDispatcher("screens/productDetail.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
