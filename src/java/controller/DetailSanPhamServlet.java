package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.comment;
import model.san_pham;

@WebServlet(name = "DetailSanPhamServlet", urlPatterns = {"/detailSanPham"})
public class DetailSanPhamServlet extends HttpServlet {
    private DAO dao;
    public void init() {
        dao = new DAO();
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DetailSanPhamServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DetailSanPhamServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        init();
        String ma = request.getParameter("ma");
        String username = (String) request.getSession().getAttribute("username");

        san_pham product = dao.getSan_phamByMa(ma);
        List<comment> comments = dao.getCommentByMa(ma);
        boolean hasPaid = false;
        if (username != null) {
            hasPaid = dao.hasUserPaidForProduct(username, ma); 
        }
        request.setAttribute("product", product);
        request.setAttribute("comments", comments);
        request.setAttribute("hasPaid", hasPaid);
        request.getRequestDispatcher("detailSanPham.jsp").forward(request, response);
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
