package model;

public class san_pham {
    private String ma, ten, gia, trangthai, loai, anh;

    public san_pham() {
    }

    public san_pham(String ma, String ten, String gia, String trangthai, String loai, String anh) {
        this.ten = ten;
        this.gia = gia;
        this.trangthai = trangthai;
        this.loai = loai;
        this.anh = anh;
        this.ma = ma;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }
    
}
