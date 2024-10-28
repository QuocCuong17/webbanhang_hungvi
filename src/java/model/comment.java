
package model;


public class comment {
    private String username, binhluan, thoigian, ma;

    public comment(String username, String binhluan, String thoigian, String ma) {
        this.username = username;
        this.binhluan = binhluan;
        this.thoigian = thoigian;
        this.ma = ma;
    }

    public comment() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBinhluan() {
        return binhluan;
    }

    public void setBinhluan(String binhluan) {
        this.binhluan = binhluan;
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
