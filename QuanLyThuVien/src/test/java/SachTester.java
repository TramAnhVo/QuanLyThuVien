
import com.vttanh.pojo.Sach;
import com.vttanh.pojo.TheLoai;
import com.vttanh.services.JdbcUtils;
import com.vttanh.services.SachService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class SachTester {
    private static Connection conn ;
    private static SachService s;
    
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
            Logger.getLogger(SachTester.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        s = new SachService();
    }
    
    @AfterAll
    public static void afterAll() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(SachTester.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Test
    public void testThemThanhCong() {
        Sach sach = new Sach("Doremon", "Hoạt Hình", "1987", "97", 1);
       
        try {
            boolean actual = s.themSach(sach);
            Assertions.assertTrue(actual);
            
            PreparedStatement stm = conn.prepareCall("SELECT * FROM sach WHERE id=?");
            stm.setInt(1, sach.getId());
            
            ResultSet rs = stm.executeQuery();
            Assertions.assertNotNull(rs.next());
            Assertions.assertEquals("Doremon", rs.getString("Ten"));
            Assertions.assertEquals("Hoạt Hình", rs.getString("MoTa"));
            Assertions.assertEquals("1987", rs.getString("NXB"));
            Assertions.assertEquals("97", rs.getString("SoLuong"));
            Assertions.assertEquals(1, rs.getInt("id_theloai"));
        } catch (SQLException ex) {
            Logger.getLogger(SachTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    @Test
//    public void testTenSachKhongNull() {
//        try {
//            List<Sach> t = s.getSach();
//            long k = t.stream().filter(c -> c.getTen()== null).count();
//            Assertions.assertFalse(k > 0);
//        } catch (SQLException ex) {
//            Logger.getLogger(SachTester.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    @Test
//    public void testTenSachKhongTrung() {
//        try {
//            List<Sach> t = s.getSach();
//            
//            List<String> ten = t.stream().flatMap(c -> Stream.of(c. getTen())).collect(Collectors.toList());
//            Set<String> testNames = new HashSet<>(ten);
//            Assertions.assertEquals(ten.size(), testNames.size());
//        } catch (SQLException ex) {
//            Logger.getLogger(SachTester.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
 
//    @Test
//    public void testSearch() {
//        try {
//            List<Question> questions = s.getQuestions("you");
//            Assertions.assertEquals(3, questions.size());
//            for (Question q: questions)
//                Assertions.assertTrue(q.getContent().toLowerCase().contains("you"));
//        } catch (SQLException ex) {
//            Logger.getLogger(SachTester.class.getName()).log(Level.SEVERE, null, ex);
//        }
//       
//    }
//    
//    @Test
//    public void testDelete() {
//        String id = "62c27e6f-fef3-4bb8-8ea4-46dba746e37b";
//        // backup database
//        // fixtures
//        try {
//            boolean actual = s.deleteQuestion(id);
//            Assertions.assertTrue(actual);
//            
//            PreparedStatement stm = conn.prepareCall("SELECT * FROM question WHERE id=?");
//            stm.setString(1, id);
//            
//            ResultSet rs = stm.executeQuery();
//            Assertions.assertFalse(rs.next());
//            
//            stm = conn.prepareCall("SELECT * FROM choice WHERE question_id=?");
//            stm.setString(1, id);
//            rs = stm.executeQuery();
//            Assertions.assertFalse(rs.next());
//        } catch (SQLException ex) {
//            Logger.getLogger(SachTester.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
//    }
}
