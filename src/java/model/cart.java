
package model;

public class cart {
    private String username, thoigian, ma;
    int gia;

    public cart() {
    }

    
    public cart(String username, String thoigian, String ma, int gia) {
        this.username = username;
        this.thoigian = thoigian;
        this.ma = ma;
        this.gia = gia;
    }

    public String getUsername() {
        return username;
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

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    
    
}
