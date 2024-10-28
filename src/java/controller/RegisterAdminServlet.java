package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.regex.Pattern;


@WebServlet(name="RegisterAdminServlet", urlPatterns={"/registerAdmin"})
public class RegisterAdminServlet extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterServlet at " + request.getContextPath () + "</h1>");
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

        String ten = request.getParameter("ten");
        String madmin = request.getParameter("madmin");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        
        String specialCharacters = "[!@#$%^&*(),.?\":{}|<>]";
        
        if (username == null || username.trim().isEmpty() || Pattern.matches(specialCharacters, username)) {
            request.setAttribute("error", "Ten tai khoan khong hop le");
            request.getRequestDispatcher("registerAdmin.jsp").forward(request, response);
            return;
        }
        
        if (password == null || password.trim().isEmpty() || Pattern.matches(specialCharacters, password)) {
            request.setAttribute("error", "Mat khau khong hop le");
            request.getRequestDispatcher("registerAdmin.jsp").forward(request, response);
            return;
        }

        if (!password.equals(confirmPassword)) {
            
            request.setAttribute("error", "Xac nhan mat khau khong khop.");
            request.getRequestDispatcher("registerAdmin.jsp").forward(request, response);
            return;
        }

        DAO userDao = new DAO();
        if (userDao.doesAdminUsernameExist(username)) {
            // Redirect với thông báo lỗi
            request.setAttribute("error", "Tai khoan da ton tai!");
            request.getRequestDispatcher("registerAdmin.jsp").forward(request, response);
            return;
        }

        userDao.registerAdmin(username, password, madmin, ten);

        response.sendRedirect("loginAdmin.jsp");
}

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
