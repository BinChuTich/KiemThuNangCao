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
 * @author phans
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
        System.out.println("Kiểm tra thêm đối tượng Tài sản thành công ");
        TaiSan ts = new TaiSan("id1", "ma 1", "hung", 220, 2220);
        TaiSanRepositoryImpl instance = new TaiSanRepositoryImpl();
        // Thực hiện

        boolean result = instance.add(ts);
        // SS kêt quả
        assertFalse("Thêm Thành công", result);
    }

    @Test
    public void testAdd_Failure_InsufficientInformation1() {
        System.out.println("Kiểm thử thêm đối tượng thất bại khi điền thiếu thông tin!");

        TaiSan ts = new TaiSan();

        TaiSanRepositoryImpl instance = new TaiSanRepositoryImpl();

        boolean result = instance.add(ts);

        assertTrue("Thêm không thành công khi điền thiếu thông tin", result);
    }

    @Test
    public void testAdd_Failure_MissingTenTs() {

        System.out.println("Ktra them đối tượng Tài Sản thất bại khi thiếu Tên ts");

        TaiSan ts = new TaiSan();
        ts.setMa("ma2");
        ts.setGia(20000);
        ts.setSoLuong(20);

        TaiSanRepositoryImpl instance = new TaiSanRepositoryImpl();

        boolean result = instance.add(ts);

        assertTrue("Thêm Thất Bại Khi Thiếu Tên ts", result);

    }

    @Test
    public void testAdd_Failure_MissingGia() {

        System.out.println("Kiểm tra thêm đối tượng Tài sản thất bại khi thiếu giá ");

        TaiSan ts = new TaiSan();

        ts.setMa("ma2");
        ts.setTen("Hung");
        ts.setSoLuong(20);

        TaiSanRepositoryImpl instance = new TaiSanRepositoryImpl();

        boolean result = instance.add(ts);

        assertTrue("Thêm thất Bại khi thiếu giá", result);
    }

    @Test
    public void testAdd_Failure_MissingSoLuong() {
        System.out.println("Kiểm tra thêm đối tượng TaiSan thất bại khi thiếu Số lượng");

        TaiSan ts = new TaiSan();
        ts.setMa("ma2");
        ts.setTen("Hunngg");
        ts.setGia(2000);

        TaiSanRepositoryImpl instance = new TaiSanRepositoryImpl();
        boolean result = instance.add(ts);
        assertTrue("Thêm thất bại khi thiếu Số lượng", result);
    }

    @Test
    public void testUpdate_Successful() {
        System.out.println("Kiểm tra sửa đối tượng TaiSan thành công");

        TaiSan ts = new TaiSan("id3", "ma2", "Hungdzvc", 220, 20);

        String id = "1";
        TaiSanRepositoryImpl instance = new TaiSanRepositoryImpl();
        boolean result = instance.update(ts, id);
        assertFalse("Sửa Thành Công ", result);

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
        ts.setMa("ma3");
        ts.setGia(2000);
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
        ts.setMa("ma5");
        ts.setTen("Hung");
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
        ts.setMa("ma3");
        ts.setTen("Hungdx");
        ts.setGia(2220);

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

    /**
     * Test of getAll method, of class TaiSanRepositoryImpl.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        TaiSanRepositoryImpl instance = new TaiSanRepositoryImpl();
        List<TaiSan> expResult = null;
        List<TaiSan> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class TaiSanRepositoryImpl.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        TaiSan ts = null;
        TaiSanRepositoryImpl instance = new TaiSanRepositoryImpl();
        boolean expResult = false;
        boolean result = instance.add(ts);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class TaiSanRepositoryImpl.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        TaiSan ts = null;
        String id = "";
        TaiSanRepositoryImpl instance = new TaiSanRepositoryImpl();
        boolean expResult = false;
        boolean result = instance.update(ts, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class TaiSanRepositoryImpl.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        String id = "";
        TaiSanRepositoryImpl instance = new TaiSanRepositoryImpl();
        boolean expResult = false;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListMa method, of class TaiSanRepositoryImpl.
     */
    @Test
    public void testGetListMa() {
        System.out.println("getListMa");
        TaiSanRepositoryImpl instance = new TaiSanRepositoryImpl();
        List<String> expResult = null;
        List<String> result = instance.getListMa();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
