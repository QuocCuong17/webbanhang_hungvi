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
        <div class="muc_luc">
            <div class="loai_hang">
                <div class="col col1">
                    <div class="loai phone">
                        <img class="icon_loai" src="<%= request.getContextPath() %>/image/icon/dt.png" alt="">
                        <a href="#banchay"><p>Điện thoại Smart phone</p></a>
                    </div>
                    <div class="loai cuong_luc">
                        <img class="icon_loai" src="<%= request.getContextPath() %>/image/icon/cuongluc.jgp.jpg" alt="">
                        <a href="#cuongluc"><p>Miếng dán cường lực</p></a>
                    </div>
                    <div class="loai pk">
                        <img src="<%= request.getContextPath() %>/image/icon/phukien.png" alt="" class="icon_loai">
                        <a href="#phukien"><p>Phụ kiện</p></a>
                    </div>
                </div>
                <div class="col col2">
                    <div class="loai mtb">
                        <img src="<%= request.getContextPath() %>/image/icon/mtb.jpg" alt="" class="icon_loai">
                        <a href="#maytinhbang"><p>Máy tính bảng</p></a>
                    </div>
                    <div class="loai ud">
                        <img src="<%= request.getContextPath() %>/image/icon/ungdung.jgp.jpg" alt="" class="icon_loai">
                        <a href="#phothong"><p>Ứng dụng di dộng</p></a>
                    </div>
                    <div class="loai km">
                        <img src="<%= request.getContextPath() %>/image/icon/khuyenmai.jgp.jpg" alt="" class="icon_loai">
                        <p>Khuyến mãi</p>
                    </div>
                </div>
            </div>
            <div class="logo_tuongtrung">

            </div>
        </div>
        <c:if test="${not empty sanPham1}">
            <h2>DANH SÁCH TÌM KIẾM</h2>
            <div class="sanpham">
                <div class="dssanpham">
                    <%
                        List<san_pham> sanPham1 = (List<san_pham>) request.getAttribute("sanPham1");
                        if (sanPham1 != null) {
                            for (san_pham sp : sanPham1) {
                    %>
                    <div class="spham">
                        <img src="<%= request.getContextPath() %>/image/<%= sp.getAnh() %>" alt="" class="sp">
                        <p class="trang_thai"><%= sp.getTrangthai() %></p>
                        <p class="ten_may"><%= sp.getTen() %></p>
                        <p class="gia">Giá bán: <%= sp.getGia() %></p>
                        <form action="<%= request.getContextPath() %>/detailSanPham" method="GET">
                            <input type="hidden" name="ma" value="<%= sp.getMa() %>">
                            <button type="submit">Xem chi tiết</button>
                        </form>
                    </div>
                    <% }
                        }
                    %>
                </div>
            </div>

        </c:if>
        <c:if test="${empty sanPham1}">
            <div class="sanpham banchay" id="banchay">
                <h2>ĐIỆN THOẠI THÔNG MINH</h2>
                <div class="dssanpham">
                    <%
                        List<san_pham> dienthoaithongminhList = (List<san_pham>) request.getAttribute("dienthoaithongminhList");
                        if (dienthoaithongminhList != null) {
                            for (san_pham dienThoai : dienthoaithongminhList) {
                    %>
                    <div class="spham">
                        <img src="<%= request.getContextPath() %>/image/<%= dienThoai.getAnh() %>" alt="" class="sp">
                        <p class="trang_thai"><%= dienThoai.getTrangthai() %></p>
                        <p class="ten_may"><%= dienThoai.getTen() %></p>
                        <p class="gia">Giá bán: <%= dienThoai.getGia() %></p>
                        <form action="<%= request.getContextPath() %>/detailSanPham" method="GET">
                            <input type="hidden" name="ma" value="<%= dienThoai.getMa() %>">
                            <button type="submit">Xem chi tiết</button>
                        </form>
                    </div>
                    <% }
                        }
                    %>
                </div>
            </div>

            <div class="sanpham phothong" id="phothong">
                <h2>ĐIỆN THOẠI DI ĐỘNG</h2>
                <div class="dssanpham">
                    <%
                        List<san_pham> dienthoaididongList = (List<san_pham>) request.getAttribute("dienthoaididongList");
                        if (dienthoaididongList != null) {
                            for (san_pham dienThoai : dienthoaididongList) {
                    %>
                    <div class="spham">
                        <img src="<%= request.getContextPath() %>/image/<%= dienThoai.getAnh() %>" alt="" class="sp">
                        <p class="trang_thai"><%= dienThoai.getTrangthai() %></p>
                        <p class="ten_may"><%= dienThoai.getTen() %></p>
                        <p class="gia">Giá bán: <%= dienThoai.getGia() %></p>
                        <form action="<%= request.getContextPath() %>/detailSanPham" method="GET">
                            <input type="hidden" name="ma" value="<%= dienThoai.getMa() %>">
                            <button type="submit">Xem chi tiết</button>
                        </form>
                    </div>
                    <% }
                        }
                    %>
                </div>
            </div>

            <div class="sanpham phukien" id="phukien">
                <h2>PHỤ KIỆN</h2>
                <div class="dssanpham">
                    <%
                        List<san_pham> phukienList = (List<san_pham>) request.getAttribute("phukienList");
                        if (phukienList != null) {
                            for (san_pham phuKien : phukienList) {
                    %>
                    <div class="spham">
                        <img src="<%= request.getContextPath() %>/image/<%= phuKien.getAnh() %>" alt="" class="sp">
                        <p class="trang_thai"><%= phuKien.getTrangthai() %></p>
                        <p class="ten_may"><%= phuKien.getTen() %></p>
                        <p class="gia">Giá bán: <%= phuKien.getGia() %></p>
                        <form action="<%= request.getContextPath() %>/detailSanPham" method="GET">
                            <input type="hidden" name="ma" value="<%= phuKien.getMa() %>">
                            <button type="submit">Xem chi tiết</button>
                        </form>
                    </div>
                    <% }
                        }
                    %>
                </div>
            </div>
            <div class="sanpham mtbang" id="maytinhbang">
                <h2>MÁY TÍNH BẢNG</h2>
                <div class="dssanpham">
                    <%
                        List<san_pham> maytinhbangList = (List<san_pham>) request.getAttribute("maytinhbangList");
                        if (maytinhbangList != null) {
                            for (san_pham mayTinhBang : maytinhbangList) {
                    %>
                    <div class="spham">
                        <img src="<%= request.getContextPath() %>/image/<%= mayTinhBang.getAnh() %>" alt="" class="sp">
                        <p class="trang_thai"><%= mayTinhBang.getTrangthai() %></p>
                        <p class="ten_may"><%= mayTinhBang.getTen() %></p>
                        <p class="gia">Giá bán: <%= mayTinhBang.getGia() %></p>
                        <form action="<%= request.getContextPath() %>/detailSanPham" method="GET">
                            <input type="hidden" name="ma" value="<%= mayTinhBang.getMa() %>">
                            <button type="submit">Xem chi tiết</button>
                        </form>
                    </div>
                    <% }
                        }
                    %>
                </div>
            </div>

            <div class="sanpham mdcluc" id="cuongluc">    
                <h2>MIẾNG DÁN CƯỜNG LỰC</h2>
                <div class="dssanpham">
                    <%
                        List<san_pham> miengdancuonglucList = (List<san_pham>) request.getAttribute("miengdancuonglucList");
                        if (miengdancuonglucList != null) {
                            for (san_pham miengDanCuongLuc : miengdancuonglucList) {
                    %>
                    <div class="spham">
                        <img src="<%= request.getContextPath() %>/image/<%= miengDanCuongLuc.getAnh() %>" alt="" class="sp">
                        <p class="trang_thai"><%= miengDanCuongLuc.getTrangthai() %></p>
                        <p class="ten_may"><%= miengDanCuongLuc.getTen() %></p>
                        <p class="gia">Giá bán: <%= miengDanCuongLuc.getGia() %></p>
                        <form action="<%= request.getContextPath() %>/detailSanPham" method="GET">
                            <input type="hidden" name="ma" value="<%= miengDanCuongLuc.getMa() %>">
                            <button type="submit">Xem chi tiết</button>
                        </form>
                    </div>
                    <% }
                        }
                    %>
                </div>
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
