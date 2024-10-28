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
import model.user;

@WebServlet(name="UpdateUserServlet", urlPatterns={"/updateUser"})
public class UpdateUserServlet extends HttpServlet {
   
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateUserServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateUserServlet at " + request.getContextPath () + "</h1>");
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
        DAO dao = new DAO();
        user sp = dao.getUserByUsername(username);
        request.setAttribute("user", sp);
        request.getRequestDispatcher("updateUser.jsp").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || (session.getAttribute("username") == null && session.getAttribute("role") == null)) {
            response.sendRedirect("login.jsp");
            return;
        }
        String ten = request.getParameter("ten");
        String email = request.getParameter("email");
        String diachi = request.getParameter("diachi");
        String sdt = request.getParameter("sdt");
        String role = request.getParameter("role");
        String balance1 = request.getParameter("balance");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int balance = Integer.parseInt(balance1);

        user sp = new user(ten, email, diachi, sdt, role, balance, username, password);
        DAO dao = new DAO();
        dao.updateUser(sp);

        response.sendRedirect("listUser");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
