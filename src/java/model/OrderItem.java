package model;

public class OrderItem {

    private String username, thoigian, ma, trangthai;
    int gia;

    public OrderItem() {
    }

    public OrderItem(String username, String thoigian, String ma, String trangthai, int gia) {
        this.username = username;
        this.thoigian = thoigian;
        this.ma = ma;
        this.trangthai = trangthai;
        this.gia = gia;
    }

    public String getUsername() {
        return username;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getThoigian() {
        return thoigian;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

}
