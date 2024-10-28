<!DOCTYPE html>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.san_pham" %>
<%@ page import="model.comment" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="jakarta.servlet.http.*, jakarta.servlet.*, java.io.*" %>
<%
    String username = (String) session.getAttribute("username");
%>

<html>

    <head>
        <meta charset="UTF-8">
        <title>Dang Hung Vi-Web ban dien thoai</title>
        <link rel="stylesheet" href="index.css">
        <style>
            .sanpham.chitiet {
                width: 50%;
                margin: 0 auto;
                border: 1px solid #ddd;
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            .sanpham.chitiet h2 {
                background-color: #FF4500;
                color: white;
                text-align: center;
                padding: 10px 0;
                border-radius: 10px 10px 0 0;
            }

            .spham1 {
                text-align: center;
            }

            .spham1 img {
                max-width: 100%;
                height: auto;
                border-radius: 10px;
            }

            .trang_thai {
                background-color: #00FF7F;
                color: white;
                padding: 5px;
                border-radius: 5px;
                margin: 10px auto;
                display: inline-block;
                text-align: center;
            }

            .ten_may, .loai_may, .gia_may {
                font-size: 18px;
                margin: 10px 0;
            }

            form {
                margin-top: 20px;
            }

            form input[type="submit"] {
                background-color: #FF4500;
                color: white;
                padding: 10px 20px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                font-size: 16px;
            }

            form input[type="submit"]:hover {
                background-color: #e03d00;
            }
            .sanpham.binhluan, .sanpham.themcomment {
                width: 50%;
                margin: 20px auto;
                border: 1px solid #ddd;
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            .sanpham.binhluan h2, .sanpham.themcomment h2 {
                background-color: #FF4500;
                color: white;
                text-align: center;
                padding: 10px 0;
                border-radius: 10px 10px 0 0;
            }

            .comment {
                margin: 10px 0;
                padding: 10px;
                border-bottom: 1px solid #ddd;
            }

            .comment span {
                display: block;
            }

            .comment small {
                color: #999;
            }

            .comment strong {
                color: #333;
            }

            form {
                text-align: center;
                margin-top: 20px;
            }

            form textarea {
                width: 100%;
                padding: 10px;
                border-radius: 5px;
                border: 1px solid #ddd;
                resize: vertical;
            }

            form input[type="submit"] {
                background-color: #FF4500;
                color: white;
                padding: 10px 20px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                font-size: 16px;
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
        <div class="sanpham chitiet">
            <h2>Chi tiết sản phẩm</h2>
            <div class="spham1">
                <img src="<%= request.getContextPath() %>/image/${product.anh}" alt="" class="sp">
                <br>
                <p class="trang_thai">${product.trangthai}</p>
                <p class="ten_may">${product.ten}</p>
                <p class="loai_may">Loại: ${product.loai}</p>
                <p class="gia_may">Giá bán: ${product.gia}</p>
                <c:if test="${not empty sessionScope.username}">
                    <c:if test="${product.trangthai == 'Còn hàng'}">
                        <form action="<%= request.getContextPath() %>/addToCart" method="POST">
                            <input type="hidden" name="ma" value="${product.ma}">
                            <input type="hidden" name="gia" value="${product.gia}">
                            <input type="submit" value="Thêm vào giỏ hàng">
                        </form>
                    </c:if>
                </c:if>

            </div>

        </div>
        <div class="sanpham binhluan">
            <h2>Bình luận</h2>
            <c:forEach var="comment" items="${comments}">
                <div class="comment">
                    <span><small>${comment.thoigian}</small></span>
                    <span><strong><c:out value="${comment.username}"/></strong>: <c:out value="${comment.binhluan}"/></span>
                    <c:if test="${sessionScope.username == comment.username}">
                        <form action="deleteComment" method="POST" style="display:inline;">
                            <input type="hidden" name="ma" value="${comment.ma}">
                            <input type="hidden" name="thoigian" value="${comment.thoigian}">
                            <input type="submit" value="Xóa" style="background-color:red;color:white;border:none;border-radius:5px;cursor:pointer;padding:5px 10px;">
                        </form>
                    </c:if>
                </div>

            </c:forEach>
        </div>
        <div class="sanpham themcomment">
            <c:if test="${not empty sessionScope.username}">
                <c:if test="${hasPaid}">
                    <h2>Thêm bình luận</h2>
                    <form action="<%= request.getContextPath() %>/addComment" method="POST">
                        <input type="hidden" name="ma" value="${product.ma}">
                        <textarea name="binhluan" rows="4" cols="50" required></textarea><br>
                        <input type="submit" value="Thêm bình luận">
                    </form>
                </c:if>
            </c:if>
        </div>
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
