<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%
    String username = (String) session.getAttribute("username");
    String role = (String) session.getAttribute("role");
    Integer balance = (Integer) request.getAttribute("balance");
%>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Dang Hung Vi - Web bán điện thoại</title>
        <link rel="stylesheet" href="index.css">
        <script type="text/javascript">
            function doDelete(username, ma, thoigian) {
                if (confirm("Bạn có chắc muốn xóa sản phẩm này không?")) {
                    window.location = "removeFromCart?username=" + username + "&ma=" + ma + "&thoigian=" + thoigian;
                }
            }

            function showError(message) {
                alert(message);
            }

            function placeOrder(username, ma, thoigian, gia) {
                var balance = <%= balance %>;
                if (balance >= gia) {
                    window.location = "order?username=" + username + "&ma=" + ma + "&thoigian=" + thoigian + "&gia=" + gia;
                } else {
                    showError("Không thể đặt hàng, số dư của bạn không đủ.");
                }
            }
        </script>
        <style>
            table {
                width: 100%;
                border-collapse: collapse;
                margin-bottom: 20px;
            }

            table, th, td {
                border: 1px solid #ddd;
            }

            th, td {
                padding: 8px;
                text-align: left;
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
                padding: 3px 6px;
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
    </head>
    <body>
        <div class="logo_header">
            <img src="<%= request.getContextPath() %>/image/logodienthoaididong_02.jpg" alt="" width="60%">
        </div>
        <div class="menu_header">
            <a href="<%= request.getContextPath() %>/sanPham">Home</a>
            <form action="searchSanpham" method="get">
                <input type="text" name="searchQuery" placeholder="Tìm kiếm sản phẩm..." />
                <input type="submit" value="Tìm kiếm" />
            </form>  
            <c:if test="${not empty sessionScope.username and sessionScope.role == 'user'}">
                <a href="#">Tài khoản: ${sessionScope.username}</a>
            </c:if>
            <c:if test="${not empty sessionScope.username and sessionScope.role == 'user'}">
                <a href="logout">Đăng xuất</a>
            </c:if>
            <c:if test="${empty sessionScope.username or sessionScope.role != 'user'}">
                <a href="login.jsp">Đăng nhập</a>
            </c:if>
            <c:if test="${not empty sessionScope.username and sessionScope.role == 'user'}">
                <a href="cart">Giỏ hàng</a>
            </c:if>
            <a href="#lienhe">Liên hệ</a>
        </div>
        <c:if test="${not empty sessionScope.username and sessionScope.role == 'user'}">
            <h3>
                Số dư: <%= balance %> VND
            </h3>
            <h2>Giỏ hàng</h2>
            <c:if test="${not empty cartItems}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>Người dùng</th>
                            <th>Thời gian</th>
                            <th>Mã Sản phẩm</th>
                            <th>Giá</th>
                            <th>Tùy chọn</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="item" items="${cartItems}">
                            <tr>
                                <td>${item.username}</td>
                                <td>${item.thoigian}</td>
                                <td>${item.ma}</td>
                                <td>${item.gia}</td>
                                <td>
                                    <a href="#" onclick="placeOrder('${item.username}', '${item.ma}', '${item.thoigian}', ${item.gia})">Đặt hàng</a>
                                    <a href="#" onclick="doDelete('${item.username}', '${item.ma}', '${item.thoigian}')">Xóa</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <c:if test="${empty cartItems}">
                <p>Giỏ hàng của bạn rỗng</p>
            </c:if>
            <h2>Đơn đặt hàng</h2>
            <c:if test="${not empty orderItems}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>Người dùng</th>
                            <th>Thời gian đặt hàng</th>
                            <th>Mã Sản phẩm</th>
                            <th>Giá</th>
                            <th>Trạng thái</th>
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
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <c:if test="${empty orderItems}">
                <p>Bạn chưa có đơn hàng nào</p>
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
