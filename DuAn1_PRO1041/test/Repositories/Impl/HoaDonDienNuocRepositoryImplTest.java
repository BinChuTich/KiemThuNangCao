/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Repositories.Impl;

import DomainModel.HoaDonDienNuoc;
import ViewModel.HoaDonDienNuocViewModel;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class HoaDonDienNuocRepositoryImplTest {
    private HoaDonDienNuocViewModelRepositoryImpl repo;
    private HoaDonDienNuoc hddnModel = new HoaDonDienNuoc();
    List<HoaDonDienNuoc> dss;
    public HoaDonDienNuocRepositoryImplTest() {
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
     * Test of them method, of class HoaDonDienNuocRepositoryImpl.
     */
    @Test
    public void testThem() {
        System.out.println("them");
        HoaDonDienNuoc hddn = null;
        HoaDonDienNuocRepositoryImpl instance = new HoaDonDienNuocRepositoryImpl();
        boolean expResult = false;
        boolean result = instance.them(hddn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sua method, of class HoaDonDienNuocRepositoryImpl.
     */
    @Test
    public void testSua() {
        System.out.println("sua");
        String ma = "";
        HoaDonDienNuoc hddn = null;
        HoaDonDienNuocRepositoryImpl instance = new HoaDonDienNuocRepositoryImpl();
        boolean expResult = false;
        boolean result = instance.sua(ma, hddn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of xoa method, of class HoaDonDienNuocRepositoryImpl.
     */
    @Test
    public void testXoa() {
        System.out.println("xoa");
        String ma = "";
        HoaDonDienNuocRepositoryImpl instance = new HoaDonDienNuocRepositoryImpl();
        boolean expResult = false;
        boolean result = instance.xoa(ma);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class HoaDonDienNuocRepositoryImpl.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        HoaDonDienNuocRepositoryImpl instance = new HoaDonDienNuocRepositoryImpl();
        List<HoaDonDienNuoc> expResult = null;
        List<HoaDonDienNuoc> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    @Test
    public void testDanhSachHoaDonDienNuoc(){
            List<HoaDonDienNuocViewModel> ds = repo.danhSachHoaDonDienNuoc();
            assertNotNull(ds);
            assertFalse(ds.isEmpty());
    }
    @Test
    public void testTimTheoTen(){
        List<HoaDonDienNuocViewModel> ds = repo.timTheoTen("PH122");
        assertNotNull(ds);
        assertFalse(ds.isEmpty());
    }
    @Test
    public void testDanhSachPhong(){
        List<HoaDonDienNuocViewModel> ds = repo.timTheoTen("PH122");
        assertNotNull(ds);
        assertFalse(ds.isEmpty());
    }
    @Test
    public void testGetMaPhong(){
        String expectedId = "someId";
        String actualId = repo.getIDByPhong("PH122");
        assertNotNull(actualId);
        assertEquals(expectedId, actualId);
    }
    @Test
    public void testGetPhongByID() {
        String validId = "someValidId";
        String expectedPhong = "someExpeectedPhong";
        String actualPhong = repo.getPhongByID(validId);
        assertNotNull(actualPhong);
        assertEquals(expectedPhong, actualPhong);
    }
    @Test
    public void testDanhSachKhachHang() {
        List<String> ds = repo.danhSachKhachHang();
        
        assertNotNull(ds);
        assertFalse(ds.isEmpty());
    }
    
    @Test
    public void testGetIDByKH() {
        String id = repo.getIDByKH("Thuan");
        assertNotNull(id);
    }
    @Test
    public void testGetKHByID() {
        String tenKH = repo.getKHByID("55759BA9-6737-47B5-8712-565B2E5F6FBD");
        assertNotNull(tenKH);
    }
    @Test
    public void testGetGiaDien() {
        String giaDien = repo.getGiaDien("1500");
        assertNotNull(giaDien);
    }
    @Test
    public void testGetGiaNuoc() {
        String giaNuoc = repo.getGiaNuoc("1200");
        assertNotNull(giaNuoc);
    }
    
    @Test
    public void testGetIDByHD() {
        String idHD = repo.getIDByHD("PH1123");
        assertNotNull(idHD);
    }
    
    //Thêm
    @Test
    public void TestThemAll(){
        hddnModel.setId("PH1123");
        hddnModel.setMa("PH122");
        hddnModel.setSoDien(3500);
        hddnModel.setSoNuoc(12000);
        hddnModel.setTongTien(200000);
        hddnModel.setTienThieu(30000);
        hddnModel.setNgayTao(new Date("2023/12/12"));
        hddnModel.setTrangThai(true);
        HoaDonDienNuocRepositoryImpl istance = new HoaDonDienNuocRepositoryImpl();
        boolean result = istance.them(hddnModel);
        assertFalse("Them hoa don dien nuoc khong thanh cong", result);
    }
    @Test
    public void TestNullId(){
//        hddnModel.setId("PH1123");
        hddnModel.setMa("PH122");
        hddnModel.setSoDien(3500);
        hddnModel.setSoNuoc(12000);
        hddnModel.setTongTien(200000);
        hddnModel.setTienThieu(30000);
        hddnModel.setNgayTao(new Date("2023/12/12"));
        hddnModel.setTrangThai(true);
        HoaDonDienNuocRepositoryImpl istance = new HoaDonDienNuocRepositoryImpl();
        boolean result = istance.them(hddnModel);
        assertFalse("Them hoa don dien nuoc khong thanh cong", result);
    }
    @Test
    public void TestNullMa(){
        hddnModel.setId("PH1123");
//        hddnModel.setMa("PH122");
        hddnModel.setSoDien(3500);
        hddnModel.setSoNuoc(12000);
        hddnModel.setTongTien(200000);
        hddnModel.setTienThieu(30000);
        hddnModel.setNgayTao(new Date("2023/12/12"));
        hddnModel.setTrangThai(true);
        HoaDonDienNuocRepositoryImpl istance = new HoaDonDienNuocRepositoryImpl();
        boolean result = istance.them(hddnModel);
        assertFalse("Them hoa don dien nuoc khong thanh cong", result);
    }
    @Test
    public void TestNullSoDien(){
        hddnModel.setId("PH1123");
        hddnModel.setMa("PH122");
//        hddnModel.setSoDien(3500);
        hddnModel.setSoNuoc(12000);
        hddnModel.setTongTien(200000);
        hddnModel.setTienThieu(30000);
        hddnModel.setNgayTao(new Date("2023/12/12"));
        hddnModel.setTrangThai(true);
        HoaDonDienNuocRepositoryImpl istance = new HoaDonDienNuocRepositoryImpl();
        boolean result = istance.them(hddnModel);
        assertFalse("Them hoa don dien nuoc khong thanh cong", result);
    }
    @Test
    public void TestNullSoNuoc(){
        hddnModel.setId("PH1123");
        hddnModel.setMa("PH122");
        hddnModel.setSoDien(3500);
//        hddnModel.setSoNuoc(12000);
        hddnModel.setTongTien(200000);
        hddnModel.setTienThieu(30000);
        hddnModel.setNgayTao(new Date("2023/12/12"));
        hddnModel.setTrangThai(true);
        HoaDonDienNuocRepositoryImpl istance = new HoaDonDienNuocRepositoryImpl();
        boolean result = istance.them(hddnModel);
        assertFalse("Them hoa don dien nuoc khong thanh cong", result);
    }
    @Test
    public void TestNullNgayTao(){
        hddnModel.setId("PH1123");
        hddnModel.setMa("PH122");
        hddnModel.setSoDien(3500);
        hddnModel.setSoNuoc(12000);
        hddnModel.setTongTien(200000);
        hddnModel.setTienThieu(30000);
//        hddnModel.setNgayTao(new Date("2023/12/12"));
        hddnModel.setTrangThai(true);
        HoaDonDienNuocRepositoryImpl istance = new HoaDonDienNuocRepositoryImpl();
        boolean result = istance.them(hddnModel);
        assertFalse("Them hoa don dien nuoc khong thanh cong", result);
    }
    @Test
    public void TestSoDienAm(){
        hddnModel.setId("PH1123");
        hddnModel.setMa("PH122");
        hddnModel.setSoDien(-3500);
        hddnModel.setSoNuoc(12000);
        hddnModel.setTongTien(200000);
        hddnModel.setTienThieu(30000);
        hddnModel.setNgayTao(new Date("2023/12/12"));
        hddnModel.setTrangThai(true);
        HoaDonDienNuocRepositoryImpl istance = new HoaDonDienNuocRepositoryImpl();
        boolean result = istance.them(hddnModel);
        assertFalse("Them hoa don dien nuoc khong thanh cong", result);
    }
    @Test
    public void TestSoNuocAm(){
        hddnModel.setId("PH1123");
        hddnModel.setMa("PH122");
        hddnModel.setSoDien(3500);
        hddnModel.setSoNuoc(-12000);
        hddnModel.setTongTien(200000);
        hddnModel.setTienThieu(30000);
        hddnModel.setNgayTao(new Date("2023/12/12"));
        hddnModel.setTrangThai(true);
        HoaDonDienNuocRepositoryImpl istance = new HoaDonDienNuocRepositoryImpl();
        boolean result = istance.them(hddnModel);
        assertFalse("Them hoa don dien nuoc khong thanh cong", result);
    }
    
    
    
    //Sửa
    @Test
    public void TestSuaByMa(){
        hddnModel.setId("HD99");
        hddnModel.setMa("HDN789");
        hddnModel.setSoDien(200);
        hddnModel.setSoNuoc(5600);
        hddnModel.setTongTien(90000);
        hddnModel.setTienThieu(20000);
        hddnModel.setNgayTao(new Date("2023/10/10"));
        hddnModel.setTrangThai(true);
        HoaDonDienNuocRepositoryImpl istance = new HoaDonDienNuocRepositoryImpl();
        boolean result = istance.sua("PH122", hddnModel);
        assertFalse("Sửa hoa don dien nuoc khong thanh cong", result);
    }
    @Test
    public void TestSuaByMaNullSoDien(){
        hddnModel.setId("HD99");
        hddnModel.setMa("HDN789");
//        hddnModel.setSoDien(200);
        hddnModel.setSoNuoc(5600);
        hddnModel.setTongTien(90000);
        hddnModel.setTienThieu(20000);
        hddnModel.setNgayTao(new Date("2023/10/10"));
        hddnModel.setTrangThai(true);
        HoaDonDienNuocRepositoryImpl istance = new HoaDonDienNuocRepositoryImpl();
        boolean result = istance.sua("PH122", hddnModel);
        assertFalse("Sửa hoa don dien nuoc khong thanh cong", result);
    }
    @Test
    public void TestSuaByMaNullSoNuoc(){
        hddnModel.setId("HD99");
        hddnModel.setMa("HDN789");
        hddnModel.setSoDien(200);
//        hddnModel.setSoNuoc(5600);
        hddnModel.setTongTien(90000);
        hddnModel.setTienThieu(20000);
        hddnModel.setNgayTao(new Date("2023/10/10"));
        hddnModel.setTrangThai(true);
        HoaDonDienNuocRepositoryImpl istance = new HoaDonDienNuocRepositoryImpl();
        boolean result = istance.sua("PH122", hddnModel);
        assertFalse("Sửa hoa don dien nuoc khong thanh cong", result);
    }
    @Test
    public void TestSuaByMaNullNgayTao(){
        hddnModel.setId("HD99");
        hddnModel.setMa("HDN789");
        hddnModel.setSoDien(200);
        hddnModel.setSoNuoc(5600);
        hddnModel.setTongTien(90000);
        hddnModel.setTienThieu(20000);
//        hddnModel.setNgayTao(new Date("2023/10/10"));
        hddnModel.setTrangThai(true);
        HoaDonDienNuocRepositoryImpl istance = new HoaDonDienNuocRepositoryImpl();
        boolean result = istance.sua("PH122", hddnModel);
        assertFalse("Sửa hoa don dien nuoc khong thanh cong", result);
    }
    
    //Xoa theo ma da update
    @Test
    public void TestXoaByMa(){
        HoaDonDienNuocRepositoryImpl istance = new HoaDonDienNuocRepositoryImpl();
        boolean result = istance.xoa("HDN789");
        assertFalse("Xoá hoa don dien nuoc khong thanh cong", result);
    }
       
}
