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

@WebServlet(name="RegisterServlet", urlPatterns={"/register"})
public class RegisterServlet extends HttpServlet {
   
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
        String email = request.getParameter("email");
        String diachi = request.getParameter("diachi");
        String sdt = request.getParameter("sdt");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        
        String specialCharacters = "[!@#$%^&*(),.?\":{}|<>]";
        
        if (username == null || username.trim().isEmpty() || Pattern.matches(specialCharacters, username)) {
            request.setAttribute("error", "Ten tai khoan khong hop le");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }
        
        if (password == null || password.trim().isEmpty() || Pattern.matches(specialCharacters, password)) {
            request.setAttribute("error", "Mat khau khong hop le");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        if (!password.equals(confirmPassword)) {
            request.setAttribute("error", "Xac nhan mat khau khong khop.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        DAO userDao = new DAO();
        if (userDao.doesUsernameExist(username)) {
            request.setAttribute("error", "Tai khoan da ton tai!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }
        userDao.registerUser(ten, email, diachi, sdt, username, password);
        response.sendRedirect("login.jsp");
        
    
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
