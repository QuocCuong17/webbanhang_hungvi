<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Dang Hung Vi-Web ban dien thoai</title>
        <link rel="stylesheet" href="index.css">
        <style>
            form {
                max-width: 400px;
                margin: 0 auto;
                background: #ffffff;
                padding: 30px;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            form h4 {
                text-align: center;
                margin-bottom: 20px;
            }

            form label {
                display: block;
                margin-bottom: 8px;
                font-weight: bold;
            }

            form input[type="text"],
            form input[type="password"],
            form button {
                width: calc(100% - 20px);
                padding: 10px;
                margin-bottom: 15px;
                border: 1px solid #ccc;
                border-radius: 3px;
                font-size: 16px;
            }

            form button {
                background-color: #4CAF50;
                color: white;
                border: none;
                cursor: pointer;
                font-size: 16px;
            }

            form button:hover {
                background-color: #45a049;
            }

            p.error {
                color: red;
                font-size: 14px;
                margin-top: 10px;
            }

            p.loginbtClick {
                text-align: center;
                margin-top: 10px;
            }
        </style>
    </head>
    <body style="background-color: #fff;">
        <div class="logo_header">
            <img src="<%= request.getContextPath() %>/image/logodienthoaididong_02.jpg" alt="" width="60%">
        </div>
        <div class="menu_header">
            <a href="<%= request.getContextPath() %>/sanPham">Home</a>
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
        <main>
            <section>
                <h2>ĐĂNG KÝ TÀI KHOẢN MỚI</h2>
                <form action="register" method="post">
                    <label for="ten">HỌ VÀ TÊN</label>
                    <input type="text" id="ten" name="ten" required>
                    <br>
                    <label for="email">EMAIL</label>
                    <input type="text" id="email" name="email" required>
                    <br>
                    <label for="diachi">ĐỊA CHỈ</label>
                    <input type="text" id="diachi" name="diachi" required>
                    <br>
                    <label for="sdt">SỐ ĐIỆN THOẠI</label>
                    <input type="text" id="sdt" name="sdt" required>
                    <br>
                    <label for="username">TÊN ĐĂNG NHẬP</label>
                    <input type="text" id="username" name="username" required>
                    <br>
                    <label for="password">MẬT KHẨU</label>
                    <input type="password" id="password" name="password" required>
                    <br>
                    <label for="confirmPassword">XÁC NHẬN MẬT KHẨU</label>
                    <input type="password" id="confirmPassword" name="confirmPassword" required>
                    <br>
                    <button type="submit">ĐĂNG KÝ</button>
                </form>
                <p><a href="login.jsp" class="loginbtClick">Đã có tài khoản? Đăng nhập</a></p>
                <p class="error">
                    <% String error = (String) request.getAttribute("error"); 
                       if (error != null) { 
                           out.println(error); 
                       } 
                    %>
                </p>
            </section>
        </main>
        <hr style="margin-top: 35px; height: 2px; background-color: black;">
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
