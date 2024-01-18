/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Repositories.Impl;

import DomainModel.TaiSan;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Chien Duong
 */
public class TaiSanRepositoryImplTest {
    
    public TaiSanRepositoryImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAdd_Successful() {
        System.out.println("Kiểm tra thêm đối tượng TaiSan thành công");

        // Tạo đối tượng TaiSan với đầy đủ thông tin
        TaiSan ts = new TaiSan("id1","ma1", "abc", 20000, 20);

        TaiSanRepositoryImpl instance = new TaiSanRepositoryImpl();

        // Thực hiện
        boolean result = instance.add(ts);

        // So sánh kết quả
        assertFalse("Thêm  thành công", result);
    }

    // Các phương thức kiểm thử khác tương tự...

    @Test
    public void testAdd_Failure_InsufficientInformation1() {
        System.out.println("Kiểm tra thêm đối tượng TaiSan thất bại khi điền không đủ thông tin");

        TaiSan ts = new TaiSan();
        
        TaiSanRepositoryImpl instance = new TaiSanRepositoryImpl();

        boolean result = instance.add(ts);

        assertTrue("Thêm không thành công khi điền không đủ thông tin", result);
    }

 
    @Test
    public void testAdd_Failure_MissingTenTs() {
        System.out.println("Kiểm tra thêm đối tượng TaiSan thất bại khi thiếu Tên Ts");


        TaiSan ts = new TaiSan();
        ts.setMa("ma4");
        ts.setGia(20000);
        ts.setSoLuong(20);

        TaiSanRepositoryImpl instance = new TaiSanRepositoryImpl();

        boolean result = instance.add(ts);

        assertTrue("Thêm Thất bại  khi thiếu Tên Ts", result);
    }


    @Test
    public void testAdd_Failure_MissingGia() {
        System.out.println("Kiểm tra thêm đối tượng TaiSan thất bại khi thiếu Giá");

        TaiSan ts = new TaiSan();
        ts.setMa("ma3");
        ts.setTen("hoang");
        ts.setSoLuong(20);

        TaiSanRepositoryImpl instance = new TaiSanRepositoryImpl();

        boolean result = instance.add(ts);

        assertTrue("Thêm thất bại khi thiếu Giá", result);
    }

    @Test
    public void testAdd_Failure_MissingSoLuong() {
        System.out.println("Kiểm tra thêm đối tượng TaiSan thất bại khi thiếu Số lượng");

        TaiSan ts = new TaiSan();
        ts.setMa("ma2");
        ts.setTen("abc");
        ts.setGia(20000);

        TaiSanRepositoryImpl instance = new TaiSanRepositoryImpl();

        boolean result = instance.add(ts);

        assertTrue("Thêm thất bại khi thiếu Số lượng", result);
    }

    @Test
    public void testUpdate_Successful() {
        System.out.println("Kiểm tra sửa đối tượng TaiSan thành công");

        TaiSan ts = new TaiSan("id5","ma5", "chien", 20000, 20);

        String id = "1";

        TaiSanRepositoryImpl instance = new TaiSanRepositoryImpl();

        boolean result = instance.update(ts, id);

        assertFalse("Sửa thành công", result);
    }
      @Test
    public void testUpdate_Failure_InsufficientInformation1() {
        System.out.println("Kiểm tra sửa đối tượng TaiSan không thành công khi điền không đủ thông tin");

        TaiSan ts = new TaiSan();

        String id = "1";

        TaiSanRepositoryImpl instance = new TaiSanRepositoryImpl();
        boolean result = instance.update(ts, id);

        assertTrue("Sửa không thành công khi điền không đủ thông tin", result);
    }

    @Test
    public void testUpdate_Failure_MissingTenTs() {
        System.out.println("Kiểm tra sửa đối tượng TaiSan không thành công khi thiếu Tên Ts");

        TaiSan ts = new TaiSan();
        ts.setMa("ma6");
        ts.setGia(20000);
        ts.setSoLuong(20);

        String id = "1";
   
        TaiSanRepositoryImpl instance = new TaiSanRepositoryImpl();

        boolean result = instance.update(ts, id);

        assertTrue("Sửa thất bại khi thiếu Tên Ts", result);
    }

    @Test
    public void testUpdate_Failure_MissingGia() {
        System.out.println("Kiểm tra sửa đối tượng TaiSan không thành công khi thiếu Giá");

        TaiSan ts = new TaiSan();
        ts.setMa("ma7");
        ts.setTen("abc");
        ts.setSoLuong(20);

        String id = "1";

        TaiSanRepositoryImpl instance = new TaiSanRepositoryImpl();

        boolean result = instance.update(ts, id);

        assertTrue("Sửa thất bại khi thiếu Giá", result);
    }

    
    @Test
    public void testUpdate_Failure_MissingSoLuong() {
        System.out.println("Kiểm tra sửa đối tượng TaiSan không thành công khi thiếu Số lượng");

        TaiSan ts = new TaiSan();
        ts.setMa("ma7");
        ts.setTen("abc");
        ts.setGia(20000);

        String id = "1";

        TaiSanRepositoryImpl instance = new TaiSanRepositoryImpl();

        boolean result = instance.update(ts, id);

        assertTrue("Sửa thất bại khi thiếu Số lượng", result);
    }

 
    
 @Test
public void testDelete_Successful() {
    // Kiểm tra xóa đối tượng TaiSan thành công
    System.out.println("Kiểm tra xóa đối tượng TaiSan thành công");

    // Tạo đối tượng TaiSan để thêm vào repository
    TaiSan ts = new TaiSan("id1", "ma1", "abc", 20000, 20);

    TaiSanRepositoryImpl instance = new TaiSanRepositoryImpl();
    
    // Thêm đối tượng vào repository để sau đó kiểm tra xóa
    instance.add(ts);

    // Lấy id của đối tượng để xóa
    String idToDelete = ts.getId();

    // Thực hiện xóa
    boolean result = instance.delete(idToDelete);

    assertFalse("Xóa không thành công", result);
}
@Test
 public void testDelete_Failure_MissingId() {
    // Kiểm tra xóa đối tượng TaiSan thất bại khi không chọn thông tin
    System.out.println("Kiểm tra xóa đối tượng TaiSan thất bại khi không chọn thông tin");

    TaiSanRepositoryImpl instance = new TaiSanRepositoryImpl();

    // Lấy một id không tồn tại để xóa
    String nonExistingId = "nonexistent";

    // Thực hiện xóa
    boolean result = instance.delete(nonExistingId);

    assertTrue("Xóa  thất bại khi không chọn thông tin", result);
}

    
}

