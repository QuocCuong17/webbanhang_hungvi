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
        <script type="text/javascript">
            function doDelete(username) {
                if (confirm("Bạn có chắc muốn xóa người dùng này không?")) {
                    window.location = "deleteUser?username=" + username;
                }
            }
        </script>
        <style>
            table {
                border-collapse: collapse;
                margin-bottom: 20px;
            }

            table, th, td {
                border: 1px solid #ddd;
            }

            th, td {
                padding: 10px;
                text-align: center;
            }

            th {
                background-color: #f2f2f2;
            }

            tr:nth-child(even) {
                background-color: #f9f9f9;
            }

            tr:hover {
                background-color: #f2f2f2;
            }

            td a {
                display: inline-block;
                margin-right: 5px;
                padding: 5px 10px;
                text-decoration: none;
                color: #333;
                border: 1px solid #ccc;
                border-radius: 3px;
            }

            td a:hover {
                background-color: #4CAF50;
                color: white;
                border-color: #4CAF50;
            }
            h3 a {
                display: inline-block;
                background-color: #FF4500;
                color: white;
                padding: 10px 20px;
                text-align: center;
                text-decoration: none;
                border-radius: 5px;
                font-size: 16px;
                transition: background-color 0.3s ease;
            }

            h3 a:hover {
                background-color: #e03d00;
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
            <h3>
                <a href="addUser.jsp">Thêm người dùng mới</a>
            </h3>
            <table border = 1 style="margin-left: 20px">
                <thead>
                    <tr>
                        <th>HỌ VÀ TÊN</th>
                        <th>EMAIL</th>
                        <th>ĐỊA CHỈ</th>
                        <th>SỐ ĐIỆN THOẠI</th>
                        <th>ROLE</th>
                        <th>BALANCE</th>
                        <th>USERNAME</th>
                        <th>PASSWORD</th>
                        <th>CHỨC NĂNG</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="u" items="${user}">
                        <tr>
                            <td>${u.ten}</td>
                            <td>${u.email}</td>
                            <td>${u.diachi}</td>
                            <td>${u.sdt}</td>
                            <td>${u.role}</td>
                            <td>${u.balance}</td>
                            <td>${u.username}</td>
                            <td>${u.password}</td>
                            <td>
                                <a href="updateUser?username=${u.username}">Sửa</a>
                                <a href="#" onclick="doDelete('${u.username}')">Xóa</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>

            </table>
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
