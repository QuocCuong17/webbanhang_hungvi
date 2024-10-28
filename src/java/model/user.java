
package model;
public class user {
    public String ten, email, diachi, sdt, role, username, password;
    int balance;

    public user() {
    }

    public user(String ten, String email, String diachi, String sdt, String role, int balance,  String username, String password) {
        this.ten = ten;
        this.email = email;
        this.diachi = diachi;
        this.sdt = sdt;
        this.username = username;
        this.password = password;
        this.role = role;
        this.balance = balance;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    
    
}
