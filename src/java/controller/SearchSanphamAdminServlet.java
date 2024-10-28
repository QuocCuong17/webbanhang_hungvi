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
import java.util.List;
import model.san_pham;

@WebServlet(name = "SearchSanphamAdminServlet", urlPatterns = {"/searchSanphamAdmin"})
public class SearchSanphamAdminServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SearchSinhvienServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchSinhvienServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("loginAdmin.jsp");
            return;
        }
        String searchQuery = request.getParameter("searchQuery");
        DAO sanPhamDAO = new DAO();
        List<san_pham> result = sanPhamDAO.searchSanPhamByTen(searchQuery);
        List<san_pham> allSanPham = sanPhamDAO.getAllSan_pham();
        request.setAttribute("sanPham1", result);
        request.setAttribute("sanPham", allSanPham);
        request.getRequestDispatcher("listSanpham.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
