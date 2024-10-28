
package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name="ThanhToanServlet", urlPatterns={"/thanhToan"})
public class ThanhToanServlet extends HttpServlet {
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ThanhToanServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ThanhToanServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || (session.getAttribute("username") == null && session.getAttribute("role") == null)) {
            response.sendRedirect("login.jsp");
            return;
        }
        String username = request.getParameter("username");
        String ma = request.getParameter("ma");
        String thoigian = request.getParameter("thoigian");
        String trangthai = request.getParameter("trangthai");
        int gia = Integer.parseInt(request.getParameter("gia"));

        DAO dao = new DAO();
        
        dao.updatePaymentStatus(username, ma, thoigian, trangthai);
        dao.updateUserBalance(username, gia);
        dao.updateAdminBalance((String)session.getAttribute("username"), gia);

        response.sendRedirect("orderSanPhamAdmin");
    } 

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
