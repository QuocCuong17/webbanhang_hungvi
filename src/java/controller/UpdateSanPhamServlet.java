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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import model.san_pham;

@WebServlet(name = "UpdateSanPhamServlet", urlPatterns = {"/updateSanPham"})
@MultipartConfig
public class UpdateSanPhamServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateSanPhamServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateSanPhamServlet at " + request.getContextPath() + "</h1>");
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
        String ma = request.getParameter("ma");
        DAO dao = new DAO();
        san_pham sp = dao.getSan_phamByMa(ma);
        request.setAttribute("sanPham", sp);
        request.getRequestDispatcher("updateSanPham.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("loginAdmin.jsp");
            return;
        }
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String gia = request.getParameter("gia");
        String trangthai = request.getParameter("trangthai");
        String loai = request.getParameter("loai");
        String anhCu = request.getParameter("anhCu");

        Part part = request.getPart("anh");
        String fileName = null;

        if (part != null && part.getSize() > 0) {
            fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
            String uploadPath = getServletContext().getRealPath("") + File.separator + "image" + File.separator + fileName;

            // Kiểm tra và tạo thư mục nếu chưa tồn tại
            File uploadDir = new File(getServletContext().getRealPath("") + File.separator + "image");
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            // Xử lý trường hợp trùng tên file
            Path uploadFilePath = Paths.get(uploadPath);
            while (Files.exists(uploadFilePath)) {
                fileName = System.currentTimeMillis() + "_" + fileName;
                uploadPath = getServletContext().getRealPath("") + File.separator + "image" + File.separator + fileName;
                uploadFilePath = Paths.get(uploadPath);
            }

            try (InputStream inputStream = part.getInputStream()) {
                Files.copy(inputStream, uploadFilePath, StandardCopyOption.REPLACE_EXISTING);
            }
        } else {
            fileName = anhCu; // Nếu không có ảnh mới, giữ lại ảnh cũ
        }

        san_pham sp = new san_pham(ma, ten, gia, trangthai, loai, fileName);
        DAO dao = new DAO();
        dao.updateSan_pham(sp);

        response.sendRedirect("listSanPham");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
