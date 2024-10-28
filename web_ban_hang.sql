use web_ban_hang;

CREATE TABLE user (
    ten VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    diachi VARCHAR(255) NOT NULL,
    sdt VARCHAR(255) NOT NULL,
    role ENUM('admin', 'user') NOT NULL DEFAULT 'user',
    balance INT NOT NULL DEFAULT 0,
    username VARCHAR(255) NOT NULL PRIMARY KEY ,
    password VARCHAR(255) NOT NULL
);
ALTER TABLE user MODIFY balance INT NOT NULL DEFAULT 0;

INSERT INTO user (ten, email, diachi, sdt, username, password)  VALUES ('vi1', 'vi1@gmail.com', 'HN', '0123456789', 'vi1', '1');
INSERT INTO user (ten, email, diachi, sdt, role, username, password)  VALUES ('admin', 'admin@gmail.com', 'HN', '0123456789', 'admin', 'admin1', '1');
select * from user;
delete from user where username = 'vi1';


CREATE TABLE san_pham (
    ma VARCHAR(255) NOT NULL PRIMARY KEY,
    ten VARCHAR(255) NOT NULL,
    gia long NOT NULL,
    trangthai VARCHAR(50) NOT NULL,
    loai VARCHAR(50) NOT NULL,
    anh VARCHAR(255) NOT NULL
);
ALTER TABLE san_pham MODIFY gia VARCHAR(255) NOT NULL;

INSERT INTO san_pham (ma, ten, gia, trangthai, loai, anh) VALUES ('sss7', 'Sam sung S7', '4000000', 'Hết hàng', 'Điện thoại thông minh', '1031346636186286968225178_amsung_s7_edge_blue_coral_4.170.130.jpg');
INSERT INTO san_pham (ma, ten, gia, trangthai, loai, anh) VALUES ('snxp', 'Sony Xperia', '10000000', 'Còn hàng', 'Điện thoại thông minh', '1014592sony_xperia_xa_chinh_hang_mau_vang_chanh_300x300_600x600.170.130.jpg');
INSERT INTO san_pham (ma, ten, gia, trangthai, loai, anh) VALUES ('opn', 'Oppo Neo', '9500000', 'Còn hàng', 'Điện thoại thông minh', '1337873oppo_neo_7.170.130.jpg');
INSERT INTO san_pham (ma, ten, gia, trangthai, loai, anh) VALUES ('ip15', 'Iphone 15', '30000000', 'Còn hàng', 'Điện thoại thông minh', 'iphone15.png');
INSERT INTO san_pham (ma, ten, gia, trangthai, loai, anh) VALUES ('ip13', 'Iphone 13', '15000000', 'Còn hàng', 'Điện thoại thông minh', 'iphone13.png');

INSERT INTO san_pham (ma, ten, gia, trangthai, loai, anh) VALUES ('nk130', 'Nokia 130', '450000', 'Còn hàng', 'Điện thoại di động', '0454253nokia130_nowatermark_300x300.170.130.jpg');
INSERT INTO san_pham (ma, ten, gia, trangthai, loai, anh) VALUES ('Mb', 'Mobell', '500000', 'Còn hàng', 'Điện thoại di động', '3959699c105ac8d_93be_48b2_9937_6c7f084fe734.170.130.jpg');
INSERT INTO san_pham (ma, ten, gia, trangthai, loai, anh) VALUES ('HTM8', 'HTC M8', '5500000', 'Còn hàng', 'Điện thoại thông minh', '0640044htc_10_r.170.130.jpg');
INSERT INTO san_pham (ma, ten, gia, trangthai, loai, anh) VALUES ('Az3m', 'Asus zenphone 3 max', '4500000', 'Còn hàng', 'Điện thoại thông minh', '2333583asus_zenfone_2_1.170.130.jpg');
INSERT INTO san_pham (ma, ten, gia, trangthai, loai, anh) VALUES ('snxp1', 'Sony Xperia', '6500000', 'Còn hàng', 'Điện thoại thông minh', '0743630sony_xperia_xa_500x554.170.130.jpg');


INSERT INTO san_pham (ma, ten, gia, trangthai, loai, anh) VALUES ('gca', 'Gậy chụp ảnh', '120000', 'Còn hàng', 'Phụ kiện', 'gaychup.jpg');
INSERT INTO san_pham (ma, ten, gia, trangthai, loai, anh) VALUES ('oldt', 'Ốp lưng điện thoại', '150000', 'Hết hàng', 'Phụ kiện', 'oplung.jpg');
INSERT INTO san_pham (ma, ten, gia, trangthai, loai, anh) VALUES ('pdt', 'Pin điện thoại', '400000', 'Còn hàng', 'Phụ kiện', 'pin.jpg');
INSERT INTO san_pham (ma, ten, gia, trangthai, loai, anh) VALUES ('skdss', 'Sạc không dây SS', '300000', 'Còn hàng', 'Phụ kiện', 'Sackoday.jpg');


INSERT INTO san_pham (ma, ten, gia, trangthai, loai, anh) VALUES ('ipmn4', 'Ipad mini 4', '12500000', 'Còn hàng', 'Máy tính bảng', 'ipad-mini-4-wifi-cellular-64gb-2-400x460.png');
INSERT INTO san_pham (ma, ten, gia, trangthai, loai, anh) VALUES ('ssgt', 'Samsung Galaxy Tab', '7500000', 'Còn hàng', 'Máy tính bảng', 'samsung-galaxy-tab-a-101-2016-4003-400x460.png');
INSERT INTO san_pham (ma, ten, gia, trangthai, loai, anh) VALUES ('acic', 'Acer Iconia', '3500000', 'Còn hàng', 'Máy tính bảng', 'acer-iconia-talk-s-a1-734-400a-400x460.png');
INSERT INTO san_pham (ma, ten, gia, trangthai, loai, anh) VALUES ('hwme', 'Huawei Mediapad', '4500000', 'Còn hàng', 'Máy tính bảng', 'huawei-mediapad-t2-7-pro-400-400x460.png');


INSERT INTO san_pham (ma, ten, gia, trangthai, loai, anh) VALUES ('clip15pro', 'Kính cường lực Iphone 15 Pro', '500000', 'Còn hàng', 'Miếng dán cường lực', 'kinhcuongluciphone15pro.jpg');
INSERT INTO san_pham (ma, ten, gia, trangthai, loai, anh) VALUES ('clip7p', 'Kính cường lực Iphone 7 Plus', '200000', 'Còn hàng', 'Miếng dán cường lực', 'dan-5d-full-iphone7-plus.jpg');
INSERT INTO san_pham (ma, ten, gia, trangthai, loai, anh) VALUES ('cloppo', 'Kính cường lực Oppo', '100000', 'Còn hàng', 'Miếng dán cường lực', 'mieng-dan-cuong-luc-oppo-a52-a53-a54-a55-ppf-uv-gia-re-tot-nhat.jpg');
INSERT INTO san_pham (ma, ten, gia, trangthai, loai, anh) VALUES ('cllp', 'Kính cường lực Lenovo Pad Pro', '200000', 'Còn hàng', 'Miếng dán cường lực', 'mieng-dan-cuong-luc-lenovo-pad-pro-2.jpg');

select * from san_pham;

CREATE TABLE comment (
    username VARCHAR(255) NOT NULL,
    binhluan VARCHAR(255) NOT NULL,
    thoigian VARCHAR(255) NOT NULL,
    ma VARCHAR(50) NOT NULL,
    FOREIGN KEY (username) REFERENCES user(username),
    FOREIGN KEY (ma) REFERENCES san_pham(ma)
);
select * from comment;

CREATE TABLE cart (
    username VARCHAR(255) NOT NULL,
    thoigian VARCHAR(255) NOT NULL,
    ma VARCHAR(50) NOT NULL,
    gia int NOT NULL,
    FOREIGN KEY (ma) REFERENCES san_pham(ma),
    FOREIGN KEY (username) REFERENCES user(username)
);

select * from cart;


CREATE TABLE orders (
    username VARCHAR(255) NOT NULL,
    thoigian VARCHAR(255) NOT NULL,
    ma VARCHAR(50) NOT NULL,
    gia long NOT NULL,
    trangthai VARCHAR(255) NOT NULL,
    FOREIGN KEY (ma) REFERENCES san_pham(ma),
    FOREIGN KEY (username) REFERENCES user(username)
);
ALTER TABLE orders MODIFY gia INT NOT NULL;
select * from orders;
delete from orders where username = 'vi1';

