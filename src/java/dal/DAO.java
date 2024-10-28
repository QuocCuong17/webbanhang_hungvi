package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.OrderItem;
import model.admin;
import model.cart;
import model.comment;
import model.san_pham;
import model.user;

public class DAO extends DBContext {

    public List<san_pham> getDien_thoai_thong_minh() {
        List<san_pham> dt = new ArrayList<>();
        String sql = "SELECT * FROM san_pham WHERE loai = 'Điện thoại thông minh'";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                san_pham d = new san_pham();
                d.setMa(rs.getString("ma"));
                d.setTen(rs.getString("ten"));
                d.setGia(rs.getString("gia"));
                d.setTrangthai(rs.getString("trangthai"));
                d.setLoai(rs.getString("loai"));
                d.setAnh(rs.getString("anh"));
                dt.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return dt;
    }

    public List<san_pham> getDien_thoai_di_dong() {
        List<san_pham> dt = new ArrayList<>();
        String sql = "SELECT * FROM san_pham WHERE loai = 'Điện thoại di động'";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                san_pham d = new san_pham();
                d.setMa(rs.getString("ma"));
                d.setTen(rs.getString("ten"));
                d.setGia(rs.getString("gia"));
                d.setTrangthai(rs.getString("trangthai"));
                d.setLoai(rs.getString("loai"));
                d.setAnh(rs.getString("anh"));
                dt.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return dt;
    }

    public List<san_pham> getPhu_kien() {
        List<san_pham> pk = new ArrayList<>();
        String sql = "SELECT * FROM san_pham WHERE loai = 'Phụ kiện'";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                san_pham p = new san_pham();
                p.setMa(rs.getString("ma"));
                p.setTen(rs.getString("ten"));
                p.setGia(rs.getString("gia"));
                p.setTrangthai(rs.getString("trangthai"));
                p.setLoai(rs.getString("loai"));
                p.setAnh(rs.getString("anh"));
                pk.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return pk;
    }

    public List<san_pham> getMay_tinh_bang() {
        List<san_pham> mtb = new ArrayList<>();
        String sql = "SELECT * FROM san_pham WHERE loai = 'Máy tính bảng'";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                san_pham m = new san_pham();
                m.setMa(rs.getString("ma"));
                m.setTen(rs.getString("ten"));
                m.setGia(rs.getString("gia"));
                m.setTrangthai(rs.getString("trangthai"));
                m.setLoai(rs.getString("loai"));
                m.setAnh(rs.getString("anh"));
                mtb.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return mtb;
    }

    public List<san_pham> getMieng_dan_cuong_luc() {
        List<san_pham> mdcl = new ArrayList<>();
        String sql = "SELECT * FROM san_pham WHERE loai = 'Miếng dán cường lực'";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                san_pham m = new san_pham();
                m.setMa(rs.getString("ma"));
                m.setTen(rs.getString("ten"));
                m.setGia(rs.getString("gia"));
                m.setTrangthai(rs.getString("trangthai"));
                m.setLoai(rs.getString("loai"));
                m.setAnh(rs.getString("anh"));
                mdcl.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return mdcl;
    }

    public user authenticate(String username, String password) {
        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String role = rs.getString("role"); // Lấy vai trò từ cơ sở dữ liệu
                return new user(
                        rs.getString("ten"),
                        rs.getString("email"),
                        rs.getString("diachi"),
                        rs.getString("sdt"),
                        role, // Truyền vai trò từ cơ sở dữ liệu vào đối tượng user
                        rs.getInt("balance"),
                        rs.getString("username"),
                        rs.getString("password")
                );
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public boolean doesUsernameExist(String username) {
        String sql = "SELECT COUNT(*) FROM user WHERE username = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void registerUser(String ten, String email, String diachi, String sdt, String username, String password) {
        String sql = "INSERT INTO user (ten, email, diachi, sdt, username, password) VALUES (?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, ten);
            st.setString(2, email);
            st.setString(3, diachi);
            st.setString(4, sdt);
            st.setString(5, username);
            st.setString(6, password);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public admin authenticateAdmin(String username, String password) {
        String sql = "SELECT * FROM admin WHERE username = ? AND password = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new admin(rs.getString("username"), rs.getString("password"),
                        rs.getString("madmin"), rs.getString("ten"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public boolean doesAdminUsernameExist(String username) {
        String sql = "SELECT COUNT(*) FROM admin WHERE username = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void registerAdmin(String username, String password, String madmin, String ten) {
        String sql = "INSERT INTO admin (madmin, ten, username, password) VALUES (?, ?, ?, ?);";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, madmin);
            st.setString(2, ten);
            st.setString(3, username);
            st.setString(4, password);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<san_pham> getAllSan_pham() {
        List<san_pham> tl = new ArrayList<>();
        String sql = "SELECT * FROM san_pham";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                san_pham t = new san_pham();
                t.setMa(rs.getString("ma"));
                t.setTen(rs.getString("ten"));
                t.setGia(rs.getString("gia"));
                t.setTrangthai(rs.getString("trangthai"));
                t.setLoai(rs.getString("loai"));
                t.setAnh(rs.getString("anh"));
                tl.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return tl;
    }

    public san_pham getSan_phamByMa(String ma) {
        san_pham sp = null;
        try {
            String sql = "SELECT * FROM san_pham WHERE ma = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                sp = new san_pham(rs.getString("ma"), rs.getString("ten"), rs.getString("gia"),
                        rs.getString("trangthai"), rs.getString("loai"), rs.getString("anh"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sp;
    }

    public boolean isMaExist(String ma) {
        String sql = "SELECT COUNT(*) FROM san_pham WHERE ma = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, ma);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isUsernameExist(String username) {
        String sql = "SELECT COUNT(*) FROM user WHERE username = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void addSan_pham(san_pham sp) {
        if (isMaExist(sp.getMa())) {
//            System.out.println("Sản phẩm đã tồn tại!");
            return;
        }
        String sql = "INSERT INTO san_pham (ma, ten, gia, trangthai, loai, anh) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, sp.getMa());
            statement.setString(2, sp.getTen());
            statement.setString(3, sp.getGia());
            statement.setString(4, sp.getTrangthai());
            statement.setString(5, sp.getLoai());
            statement.setString(6, sp.getAnh());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSan_pham(san_pham sv) {
        try {
            String sql = "UPDATE san_pham SET ten = ?, gia = ?, trangthai = ?, loai = ?, anh = ? WHERE ma = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, sv.getTen());
            ps.setString(2, sv.getGia());
            ps.setString(3, sv.getTrangthai());
            ps.setString(4, sv.getLoai());
            ps.setString(5, sv.getAnh());
            ps.setString(6, sv.getMa());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSan_pham(String ma) {
        try {
            deleteCommentsByProductId(ma);
            String sql = "DELETE FROM san_pham WHERE ma = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, ma);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<user> getAllUser() {
        List<user> tl = new ArrayList<>();
        String sql = "SELECT * FROM user";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                user t = new user();
                t.setTen(rs.getString("ten"));
                t.setEmail(rs.getString("email"));
                t.setDiachi(rs.getString("diachi"));
                t.setSdt(rs.getString("sdt"));
                t.setRole(rs.getString("role"));
                t.setBalance(rs.getInt("balance"));
                t.setUsername(rs.getString("username"));
                t.setPassword(rs.getString("password"));
                tl.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return tl;
    }

    public void addUser(user sp) {
        if (doesUsernameExist(sp.getUsername())) {
            return;
        }
        String sql = "INSERT INTO user (ten, email, diachi, sdt, role, balance, username, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, sp.getTen());
            statement.setString(2, sp.getEmail());
            statement.setString(3, sp.getDiachi());
            statement.setString(4, sp.getSdt());
            statement.setString(5, sp.getRole());
            statement.setInt(6, sp.getBalance());
            statement.setString(7, sp.getUsername());
            statement.setString(8, sp.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(user sp) {
        try {
            String sql = "UPDATE user SET ten = ?, email = ?, diachi = ?, sdt = ?, role = ?, balance = ?, password = ? WHERE username = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, sp.getTen());
            ps.setString(2, sp.getEmail());
            ps.setString(3, sp.getDiachi());
            ps.setString(4, sp.getSdt());
            ps.setString(5, sp.getRole());
            ps.setInt(6, sp.getBalance());
            ps.setString(7, sp.getPassword());
            ps.setString(8, sp.getUsername());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // xoa user
    public void deleteUser(String username) {
        try {
            deleteCartByUsername(username);
            deleteCommentsByUsername(username);
            String sql = "DELETE FROM user WHERE username = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCommentsByUsername(String username) {
        String sql = "DELETE FROM comment WHERE username = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get user bằng username
    public user getUserByUsername(String username) {
        user sp = null;
        try {
            String sql = "SELECT * FROM user WHERE username = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                sp = new user(
                        rs.getString("ten"),
                        rs.getString("email"),
                        rs.getString("diachi"),
                        rs.getString("sdt"),
                        rs.getString("role"), // Lấy giá trị role từ cơ sở dữ liệu
                        rs.getInt("balance"),
                        rs.getString("username"),
                        rs.getString("password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sp;
    }

    // Get comment của user về sản phẩm
    public List<comment> getCommentByMa(String ma) {
        List<comment> sp = new ArrayList<>();;
        try {
            String sql = "SELECT * FROM comment WHERE ma = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                comment t = new comment();
                t.setUsername(rs.getString("username"));
                t.setBinhluan(rs.getString("binhluan"));
                t.setThoigian(rs.getString("thoigian"));
                t.setMa(rs.getString("ma"));
                sp.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sp;
    }

    // Thêm comment về sản phẩm
    public void addComment(String username, String binhluan, String ma) {
        String sql = "INSERT INTO comment (username, binhluan, thoigian, ma) VALUES (?, ?, NOW(), ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, binhluan);
            statement.setString(3, ma);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addToCart(String username, String ma, int gia) {
        String sql = "INSERT INTO cart (username, thoigian, ma, gia) VALUES (?, NOW(), ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, ma);
            statement.setInt(3, gia);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<cart> getCartItems(String username) {
        List<cart> sp = new ArrayList<>();
        try {
            String sql = "SELECT * FROM cart WHERE username = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cart t = new cart();
                t.setUsername(rs.getString("username"));
                t.setThoigian(rs.getString("thoigian"));
                t.setMa(rs.getString("ma"));
                t.setGia(rs.getInt("gia"));
                sp.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sp;
    }

    public void removeFromCart(String username, String thoigian, String ma) {
        String sql = "DELETE FROM cart WHERE username = ? AND thoigian = ? AND ma = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, thoigian);
            statement.setString(3, ma);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void orderProduct(String username, String ma, String thoigian, int gia) {
        String sql = "INSERT INTO orders (username, ma, thoigian, trangthai, gia) "
                + "SELECT ?, ?, ?, 'Chưa thanh toán', ? FROM cart WHERE username = ? AND ma = ? AND thoigian = ? AND gia = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, ma);
            statement.setString(3, thoigian);
            statement.setInt(4, gia);
            statement.setString(5, username);
            statement.setString(6, ma);
            statement.setString(7, thoigian);
            statement.setInt(8, gia);
            statement.executeUpdate();

            removeFromCart(username, thoigian, ma);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCommentsByProductId(String ma) {
        String sql = "DELETE FROM comment WHERE ma = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, ma);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<OrderItem> getOrderItems(String username) {
        List<OrderItem> orderItems = new ArrayList<>();
        String sql = "SELECT * FROM orders WHERE username = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                OrderItem item = new OrderItem();
                item.setUsername(rs.getString("username"));
                item.setThoigian(rs.getString("thoigian"));
                item.setMa(rs.getString("ma"));
                item.setTrangthai(rs.getString("trangthai"));
                item.setGia(rs.getInt("gia"));
                orderItems.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderItems;
    }

    public List<OrderItem> getAllOrderItems() {
        List<OrderItem> orderItems = new ArrayList<>();
        String sql = "SELECT * FROM orders";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                OrderItem item = new OrderItem();
                item.setUsername(rs.getString("username"));
                item.setThoigian(rs.getString("thoigian"));
                item.setMa(rs.getString("ma"));
                item.setTrangthai(rs.getString("trangthai"));
                item.setGia(rs.getInt("gia"));
                orderItems.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderItems;
    }

    public List<san_pham> searchSanPhamByTen(String ten) {
        List<san_pham> sanPhamList = new ArrayList<>();
        try {
            String query = "SELECT * FROM san_pham WHERE ten LIKE ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "%" + ten + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                san_pham sp = new san_pham();
                sp.setMa(rs.getString("ma"));
                sp.setTen(rs.getString("ten"));
                sp.setGia(rs.getString("gia"));
                sp.setTrangthai(rs.getString("trangthai"));
                sp.setLoai(rs.getString("loai"));
                sp.setAnh(rs.getString("anh"));
                sanPhamList.add(sp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sanPhamList;
    }

    public void updatePaymentStatus(String username, String ma, String thoigian, String trangthai) {
        String sql = "UPDATE orders SET trangthai = ? WHERE username = ? AND ma = ? AND thoigian = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "Đã thanh toán");
            statement.setString(2, username);
            statement.setString(3, ma);
            statement.setString(4, thoigian);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Hủy đơn
    public void cancelOrder(String username, String ma, String thoigian, String trangthai) {
        String sql = "UPDATE orders SET trangthai = 'Đã hủy đơn' WHERE username = ? AND ma = ? AND thoigian = ? AND trangthai = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, ma);
            ps.setString(3, thoigian);
            ps.setString(4, trangthai);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean hasUserPaidForProduct(String username, String ma) {
        String sql = "SELECT * FROM orders WHERE username = ? AND ma = ? AND trangthai = 'Đã thanh toán'";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, ma);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void deleteComment(String username, String thoigian, String ma) {
        String sql = "DELETE FROM comment WHERE username = ? AND thoigian = ? AND ma = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, thoigian);
            statement.setString(3, ma);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isUserPaid(String username) {
        String sql = "SELECT COUNT(*) FROM orders WHERE username = ? AND trangthai != 'Đã thanh toán'";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) == 0; // No unpaid orders
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void deleteCartByUsername(String username) {
        String sql = "DELETE FROM cart WHERE username = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getUserBalance(String username) {
        int balance = 0;
        String sql = "SELECT balance FROM user WHERE username = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                balance = rs.getInt("balance");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return balance;
    }

    public boolean updateUserBalance(String username, int balanceChange) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Lấy số dư hiện tại của người dùng
            String query = "SELECT balance FROM user WHERE username = ?";
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();

            int currentBalance = 0;
            if (rs.next()) {
                currentBalance = rs.getInt("balance");
            }

            // Kiểm tra xem có đủ số dư để trừ không
            if (currentBalance >= balanceChange) {
                // Cập nhật số dư của người dùng
                String updateQuery = "UPDATE user SET balance = balance - ? WHERE username = ?";
                ps = connection.prepareStatement(updateQuery);
                ps.setInt(1, balanceChange);
                ps.setString(2, username);
                int rowsUpdated = ps.executeUpdate();

                return rowsUpdated > 0;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateAdminBalance(String username, int balance) {
        String sql = "UPDATE user SET balance = balance + ? WHERE username = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, balance);
            ps.setString(2, username);
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
