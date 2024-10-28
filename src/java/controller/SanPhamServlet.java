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
import model.san_pham;

@WebServlet({"/sanPham"})
public class SanPhamServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SanPhamServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SanPhamServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO dao = new DAO();
        List<san_pham> dienthoaithongminhList = dao.getDien_thoai_thong_minh();
        List<san_pham> dienthoaididongList = dao.getDien_thoai_di_dong();
        List<san_pham> phukienList = dao.getPhu_kien();
        List<san_pham> maytinhbangList = dao.getMay_tinh_bang();
        List<san_pham> miengdancuonglucList = dao.getMieng_dan_cuong_luc();

        request.setAttribute("dienthoaithongminhList", dienthoaithongminhList);
        request.setAttribute("dienthoaididongList", dienthoaididongList);
        request.setAttribute("phukienList", phukienList);
        request.setAttribute("maytinhbangList", maytinhbangList);
        request.setAttribute("miengdancuonglucList", miengdancuonglucList);

        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
