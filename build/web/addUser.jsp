<!DOCTYPE html>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.san_pham" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="jakarta.servlet.http.*, jakarta.servlet.*, java.io.*" %>
<%
    String role = (String) session.getAttribute("role");
    String username = (String) session.getAttribute("username");
%>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Dang Hung Vi-Web ban dien thoai</title>
        <link rel="stylesheet" href="index.css">
        <style>
            form {
                width: 50%;
                margin: 20px auto;
                padding: 20px;
                border: 1px solid #ccc;
                border-radius: 5px;
                background-color: #f9f9f9;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            h2 {
                text-align: center;
                margin-bottom: 20px;
            }

            form input[type="text"] {
                width: calc(100% - 20px);
                padding: 10px;
                margin-bottom: 10px;
                border: 1px solid #ccc;
                border-radius: 3px;
                box-sizing: border-box;
            }

            form input[type="submit"] {
                width: calc(100% - 20px);
                padding: 10px;
                background-color: #4CAF50;
                color: white;
                border: none;
                border-radius: 3px;
                cursor: pointer;
                transition: background-color 0.3s;
                box-sizing: border-box;
            }

            form input[type="submit"]:hover {
                background-color: #45a049;
            }

            form p {
                margin-bottom: 10px;
            }
        </style>
    </head>
    <body>
        <div class="logo_header">
            <img src="<%= request.getContextPath() %>/image/logodienthoaididong_02.jpg" alt="" width="60%">
        </div>
        <div class="menu_header">
            <a href="<%= request.getContextPath() %>/sanPhamAdmin">Home</a>
            <c:if test="${not empty sessionScope.username and sessionScope.role == 'admin'}">
                <a href="#">Tài khoản: ${sessionScope.username}</a>
            </c:if>
            <c:if test="${not empty sessionScope.username and sessionScope.role == 'admin'}">
                <a href="logout">Đăng xuất</a>
            </c:if>
            <c:if test="${empty sessionScope.username or sessionScope.role != 'admin'}">
                <a href="login.jsp">Đăng nhập</a>
            </c:if>
            <c:if test="${not empty sessionScope.username and sessionScope.role == 'admin'}">
                <a href="listSanPham">Quản lý Sản Phẩm</a>
            </c:if>
            <c:if test="${not empty sessionScope.username and sessionScope.role == 'admin'}">
                <a href="listUser">Quản lý Người dùng</a>
            </c:if>
            <c:if test="${not empty sessionScope.username and sessionScope.role == 'admin'}">
                <a href="orderSanPhamAdmin">Đơn đặt hàng</a>
            </c:if>

            <a href="#lienhe">Liên hệ</a>
        </div>
        <c:if test="${not empty sessionScope.username and sessionScope.role == 'admin'}">
            <div class="sanpham">
                <h2>Thêm người dùng mới</h2>
                <c:if test="${not empty errorMessage}">
                    <p style="color: red;">${errorMessage}</p>
                </c:if>
                <form action="addUser" method="post">
                    Tên: <input type="text" name="ten"><br>
                    Email: <input type="text" name="email"><br>
                    Địa chỉ: <input type="text" name="diachi"><br>
                    Số điện thoại: <input type="text" name="sdt"><br>
                    Role: <input type="text" name="role"><br>
                    Balance: <input type="text" name="balance"><br>
                    Username: <input type="text" name="username"><br>
                    Password: <input type="text" name="password"><br>
                    <input type="submit" value="Thêm">
                </form>
            </div>
        </c:if>
        <hr>
        <div class="info_CH" id="lienhe">

            <div class="info hotro">
                <p class="tieude">HỖ TRỢ DỊCH VỤ</p>
                <div class="thong_tin">
                    <p>
                        Tổng đài hỗ trợ: 19001010
                    </p>
                    <p>TP Hà Nội(04): 73012345</p>
                    <p>TP HCM(08): 73012345</p>
                    <p>Chăm sóc Khách hàng và giải đáp</p>
                    <p>Tư vấn và mua hàng online</p>
                </div>
            </div>
            <div class="info hotro">
                <p class="tieude">HỆ THỐNG CỬA HÀNG</p>
                <div class="thong_tin">
                    <p>
                        Liên hệ với chúng tôi
                    </p>
                    <p>235 Trần Thái Tông, Hà Nội</p>
                    <p>Quy định về bảo hành đổi trả</p>
                    <p>Hỗ trợ thanh toán online</p>
                </div>
            </div>
            <div class="info hotro">
                <p class="tieude">THANH TOÁN</p>
                <div class="thong_tin">
                    <p>
                        Liên hệ với chúng tôi
                    </p>
                    <p>235 Trần Thái Tông, Hà Nội</p>
                    <p>Quy định về bảo hành đổi trả</p>
                    <p>Hỗ trợ thanh toán online</p>
                </div>
            </div>
        </div>
    </body>
</html>
