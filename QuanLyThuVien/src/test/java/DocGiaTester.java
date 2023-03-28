
import com.vttanh.pojo.DocGia;
import com.vttanh.services.JdbcUtils;
import com.vttanh.services.ThongTin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class DocGiaTester {
    private static Connection conn ;
    private static ThongTin dg;
    
//    static {
//        try {
//            conn = JdbcUtils.getConn();
//        } catch (SQLException ex) {
//            Logger.getLogger(QuestionTester.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
    @BeforeAll
    public static void beforeAll() {
        try {
            conn = JdbcUtils.getConn();
        } catch (SQLException ex) {
            Logger.getLogger(DocGiaTester.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        dg = new ThongTin();
    }
    
    @AfterAll
    public static void afterAll() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DocGiaTester.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Test
    public void testThemThanhCong() {
        DocGia docGia = new DocGia("Huyền", LocalDate.of(2002, 9, 21), "Nữ", "2051050172huyen2ou.edu.vn", "0386858149", "491 Nguyễn Văn Công", 1, 1);
       
        try {
            boolean actual = dg.ThemThongTin(docGia);
            Assertions.assertTrue(actual);
            
            PreparedStatement stm = conn.prepareCall("SELECT * FROM sach WHERE id=?");
            stm.setInt(1, docGia.getId());
            
            ResultSet rs = stm.executeQuery();
            Assertions.assertNotNull(rs.next());
            Assertions.assertEquals("Huyền", rs.getString("HoTen"));
             Assertions.assertEquals(LocalDate.of(2002, 9, 21), rs.getDate("NgaySinh"));
            Assertions.assertEquals("Nữ", rs.getString("GioiTinh"));
            Assertions.assertEquals("2051050172huyen2ou.edu.vn", rs.getString("Email"));
            Assertions.assertEquals("0386858149", rs.getString("SoDienThoai"));
            Assertions.assertEquals("491 Nguyễn Văn Công", rs.getString("DiaChi"));
            Assertions.assertEquals(1, rs.getInt("DoiTuong"));
            Assertions.assertEquals(1, rs.getInt("BoPhan"));
        } catch (SQLException ex) {
            Logger.getLogger(DocGiaTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testTenDGKhongNull() {
        try {
            List<DocGia> t = dg.xemThongTinDocGia(null);
            long k = t.stream().filter(c -> c.getTen() == null).count();
            Assertions.assertFalse(k > 0);
        } catch (SQLException ex) {
            Logger.getLogger(SachTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testGioiTinhDGKhongNull() {
        try {
            List<DocGia> gt = dg.xemThongTinDocGia(null);
            long k = gt.stream().filter(c -> c.getGT() == null).count();
            Assertions.assertFalse(k > 0);
        } catch (SQLException ex) {
            Logger.getLogger(SachTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testNgaySinhDGKhongNull() {
        try {
            List<DocGia> ns = dg.xemThongTinDocGia(null);
            long k = ns.stream().filter(c -> c.getNgaySinh() == null).count();
            Assertions.assertFalse(k > 0);
        } catch (SQLException ex) {
            Logger.getLogger(SachTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testEmailDGKhongNull() {
        try {
            List<DocGia> e = dg.xemThongTinDocGia(null);
            long k = e.stream().filter(c -> c.getEmail() == null).count();
            Assertions.assertFalse(k > 0);
        } catch (SQLException ex) {
            Logger.getLogger(SachTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     @Test
    public void testDiaChiDGKhongNull() {
        try {
            List<DocGia> dc = dg.xemThongTinDocGia(null);
            long k = dc.stream().filter(c -> c.getDiaChi() == null).count();
            Assertions.assertFalse(k > 0);
        } catch (SQLException ex) {
            Logger.getLogger(SachTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testSDTDGKhongTrung() {
        try {
            List<DocGia> t = dg.xemThongTinDocGia(null);
            List<String> sdt= t.stream().flatMap(c -> Stream.of(c.getSDT())).collect(Collectors.toList());
            Set<String> testSDT = new HashSet<>(sdt);
            Assertions.assertEquals(sdt.size(), testSDT.size());
        } catch (SQLException ex) {
            Logger.getLogger(SachTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     @Test
    public void testEmailDGKhongTrung() {
        try {
            List<DocGia> t = dg.xemThongTinDocGia(null);
            List<String> email= t.stream().flatMap(c -> Stream.of(c.getEmail())).collect(Collectors.toList());
            Set<String> testEmail = new HashSet<>(email);
            Assertions.assertEquals(email.size(), testEmail.size());
        } catch (SQLException ex) {
            Logger.getLogger(SachTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
