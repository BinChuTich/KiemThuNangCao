/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Repositories.Impl;

import DomainModel.KhachHang;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thuan
 */
public class KhachHangRepositoryImplTest {
    
    public KhachHangRepositoryImplTest() {
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

    /**
     * Test of getAll method, of class KhachHangRepositoryImpl.
     */
    @Test
    public void testGetAll() {
        System.out.println("pass");
        KhachHangRepositoryImpl instance = new KhachHangRepositoryImpl();
//        List<KhachHang> expResult = null;
        List<KhachHang> result = instance.getAll();
//        assertEquals(expResult, result);
        assertNotNull("Danh sách khách hàng không được null",result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getListMa method, of class KhachHangRepositoryImpl.
     */
    @Test
    public void testGetListMa() {
        System.out.println("getListMa");
        KhachHangRepositoryImpl instance = new KhachHangRepositoryImpl();
//        List<String> expResult = null;
        List<String> result = instance.getListMa();
//        assertEquals(expResult, result);
        assertNotNull("Danh sách mã khách hàng không được để trống",result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class KhachHangRepositoryImpl.
     */
    @Test
    public void testAdd() {
        System.out.println("thêm khi không điền không đủ thông tin");
        KhachHang kh = new KhachHang();
        KhachHangRepositoryImpl instance = new KhachHangRepositoryImpl();
//        boolean expResult = false;
        boolean result = instance.add(kh);
//        assertEquals(expResult, result);
        assertTrue("Thêm khách hàng không thành công" , result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class KhachHangRepositoryImpl.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        KhachHang kh = new KhachHang();
        String id = "123";
        KhachHangRepositoryImpl instance = new KhachHangRepositoryImpl();
//        boolean expResult = false;
        boolean result = instance.update(kh, id);
//        assertEquals(expResult, result);
        assertTrue("Cập nhật khách hàng không thành công", result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class KhachHangRepositoryImpl.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        KhachHang kh = new KhachHang();
        String id = "123";
        KhachHangRepositoryImpl instance = new KhachHangRepositoryImpl();
//        boolean expResult = false;
        boolean result = instance.delete(id);
//        assertEquals(expResult, result);
        assertTrue("Xóa khách hàng không thành công", result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of addNhanh method, of class KhachHangRepositoryImpl.
     */
    @Test
    public void testAddNhanh() {
        System.out.println("addNhanh");
        KhachHang kh = new KhachHang();
        KhachHangRepositoryImpl instance = new KhachHangRepositoryImpl();
//        boolean expResult = false;
        boolean result = instance.addNhanh(kh);
//        assertEquals(expResult, result);
        assertTrue("Thêm nhanh khách hàng không thành công", result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    @Test
    public void addKH(){
        UUID id = UUID.randomUUID();
        System.out.println("thêm khi điền đủ thông tim");
        KhachHang kh = new KhachHang(String.valueOf(id), "KH01", "Thuan", "030203000818",new Date("2002/02/02"), "thuan@gmail.com", "0966580403", true, "Hải Dương");
        KhachHangRepositoryImpl instance = new KhachHangRepositoryImpl();
        boolean result = instance.add(kh);
        assertFalse("Thêm thành công", result);
    }
    @Test
    public void addTrongMKH(){
        System.out.println("Kiểm tra thêm đối tượng khi thiếu mã khách hàng");
        UUID id = UUID.randomUUID();
        KhachHang kh = new KhachHang();
        kh.setId(String.valueOf(id));
        kh.setTen("Thuan");
        kh.setCccd("030203000818");
        kh.setNgSinh(new Date("2002/02/02"));
        kh.setEmail("thuan@gmail.com");
        kh.setSdt("0966580403");
        kh.setGioiTinh(true);
        kh.setDiaChi("Hải Dương");
        KhachHangRepositoryImpl instance = new KhachHangRepositoryImpl();
        boolean result = instance.add(kh);
        assertTrue("Thêm thất bại thiếu mã khách hàng", result);
    }
    @Test
    public void addTrongCCCD(){
        System.out.println("Kiểm tra thêm đối tượng khi thiếu căn cước công dân");
        UUID id = UUID.randomUUID();
        KhachHang kh = new KhachHang();
        kh.setId(String.valueOf(id));
        kh.setTen("Thuan");
        kh.setMa("KH01");
//        kh.setCccd("030203000818");
        kh.setNgSinh(new Date("2002/02/02"));
        kh.setEmail("thuan@gmail.com");
        kh.setSdt("0966580403");
        kh.setGioiTinh(true);
        kh.setDiaChi("Hải Dương");
        KhachHangRepositoryImpl instance = new KhachHangRepositoryImpl();
        boolean result = instance.add(kh);
        assertTrue("Thêm thất bại thiếu căn cước công dân", result);
    }
    @Test
    public void addTrongNgaySinh(){
        System.out.println("Kiểm tra thêm đối tượng khi không truyền vào ngày sinh thiếu ngày sinh");
        UUID id = UUID.randomUUID();
        KhachHang kh = new KhachHang();
        kh.setId(String.valueOf(id));
        kh.setTen("Thuan");
        kh.setMa("KH01");
        kh.setCccd("030203000818");
//        kh.setNgSinh(new Date("2002/02/02"));
        kh.setEmail("thuan@gmail.com");
        kh.setSdt("0966580403");
        kh.setGioiTinh(true);
        kh.setDiaChi("Hải Dương");
        KhachHangRepositoryImpl instance = new KhachHangRepositoryImpl();
        boolean result = instance.add(kh);
        assertTrue("Thêm thất bại thiếu ngày sinh", result);
    }
    
}
