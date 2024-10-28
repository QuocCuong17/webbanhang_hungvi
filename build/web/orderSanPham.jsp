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
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Dang Hung Vi - Web bán điện thoại</title>
        <link rel="stylesheet" href="index.css">
    </head>
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

    </style>
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
                Số dư: <%= request.getAttribute("balance") %> VND
            </h3>
            <h2>Đơn đặt hàng</h2>
            <c:if test="${not empty orderItems}">
                <table border = 1>
                    <thead>
                        <tr>
                            <th>Người dùng</th>
                            <th>Thời gian đặt hàng</th>
                            <th>Mã Sản phẩm</th>
                            <th>Giá Sản phẩm</th>
                            <th>Trạng thái</th>
                            <th>Xử lý thanh toán</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="item" items="${orderItems}">
                            <tr>
                                <td>${item.username}</td>
                                <td>${item.thoigian}</td>
                                <td>${item.ma}</td>
                                <td>${item.gia}</td>
                                <td>${item.trangthai}</td>
                                <td>
                                    <c:if test="${item.trangthai == 'Chưa thanh toán'}">
                                        <a href="thanhToan?username=${item.username}&ma=${item.ma}&thoigian=${item.thoigian}&trangthai=${item.trangthai}&gia=${item.gia}">Xử lý</a>
                                        <a href="huyDon?username=${item.username}&ma=${item.ma}&thoigian=${item.thoigian}&trangthai=${item.trangthai}&gia=${item.gia}">Hủy đơn</a>
                                    </c:if>
                                    <c:if test="${item.trangthai == 'Đã thanh toán'}">
                                        <span style="color: gray;">Đã xử lý</span>
                                    </c:if>
                                    <c:if test="${item.trangthai == 'Đã hủy đơn'}">
                                        <span style="color: gray;">Đã hủy đơn</span>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </c:if>
        <c:if test="${not empty sessionScope.username and sessionScope.role == 'admin'}">
            <c:if test="${empty orderItems}">
                <p>Không có đơn hàng nào!</p>
            </c:if>
        </c:if>
        <hr>
        <div class="info_CH" id="lienhe">
            <div class="info hotro">
                <p class="tieude">HỖ TRỢ DỊCH VỤ</p>
                <div class="thong_tin">
                    <p>Tổng đài hỗ trợ: 19001010</p>
                    <p>TP Hà Nội(04): 73012345</p>
                    <p>TP HCM(08): 73012345</p>
                    <p>Chăm sóc Khách hàng và giải đáp</p>
                    <p>Tư vấn và mua hàng online</p>
                </div>
            </div>
            <div class="info hotro">
                <p class="tieude">HỆ THỐNG CỬA HÀNG</p>
                <div class="thong_tin">
                    <p>Liên hệ với chúng tôi</p>
                    <p>235 Trần Thái Tông, Hà Nội</p>
                    <p>Quy định về bảo hành đổi trả</p>
                    <p>Hỗ trợ thanh toán online</p>
                </div>
            </div>
            <div class="info hotro">
                <p class="tieude">THANH TOÁN</p>
                <div class="thong_tin">
                    <p>Liên hệ với chúng tôi</p>
                    <p>235 Trần Thái Tông, Hà Nội</p>
                    <p>Quy định về bảo hành đổi trả</p>
                    <p>Hỗ trợ thanh toán online</p>
                </div>
            </div>
        </div>
    </body>
</html>
