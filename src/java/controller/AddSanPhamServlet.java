package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import model.san_pham;

@WebServlet(name = "AddSanPhamServlet", urlPatterns = {"/addSanPham"})
@MultipartConfig
public class AddSanPhamServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddSanPhamServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddSanPhamServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || (session.getAttribute("username") == null && session.getAttribute("role") == null)) {
            response.sendRedirect("login.jsp");
            return;
        }
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String gia = request.getParameter("gia");
        String trangthai = request.getParameter("trangthai");
        String loai = request.getParameter("loai");

        Part part = request.getPart("anh");
        String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
        String uploadPath = getServletContext().getRealPath("") + File.separator + "image" + File.separator + fileName;

        // Create upload directory if it doesn't exist
        File uploadDir = new File(getServletContext().getRealPath("") + File.separator + "image");
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        // Ensure the file name is unique by appending a timestamp if the file already exists
        while (Files.exists(Paths.get(uploadPath))) {
            fileName = System.currentTimeMillis() + "_" + fileName;
            uploadPath = getServletContext().getRealPath("") + File.separator + "image" + File.separator + fileName;
        }

        // Save the file to the server
        try (InputStream inputStream = part.getInputStream()) {
            Files.copy(inputStream, Paths.get(uploadPath), StandardCopyOption.REPLACE_EXISTING);
        }

        DAO dao = new DAO();

        if (dao.isMaExist(ma)) {
            request.setAttribute("errorMessage", "Sản phẩm đã tồn tại.");
            request.getRequestDispatcher("addSanPham.jsp").forward(request, response);
        } else {
            san_pham sp = new san_pham(ma, ten, gia, trangthai, loai, fileName);
            dao.addSan_pham(sp);
            response.sendRedirect("listSanPham");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
