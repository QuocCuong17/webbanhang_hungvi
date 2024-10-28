
package model;

public class admin {
    public String username, password, madmin, ten;

    public admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public admin(String username, String password, String madmin, String ten) {
        this.username = username;
        this.password = password;
        this.madmin = madmin;
        this.ten = ten;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
    

    public admin(String username, String password, String madmin) {
        this.username = username;
        this.password = password;
        this.madmin = madmin;
    }

    public String getMadmin() {
        return madmin;
    }

    public void setMadmin(String madmin) {
        this.madmin = madmin;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
