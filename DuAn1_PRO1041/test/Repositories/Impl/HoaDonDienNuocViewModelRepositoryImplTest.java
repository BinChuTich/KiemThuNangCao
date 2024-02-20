/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Repositories.Impl;

import ViewModel.HoaDonDienNuocViewModel;
import ViewModel.PhongTroHDViewModel;
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
public class HoaDonDienNuocViewModelRepositoryImplTest {
    
    private HoaDonDienNuocViewModelRepositoryImpl repository;
    List<HoaDonDienNuocViewModel> danhSach;
    
    public HoaDonDienNuocViewModelRepositoryImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        //repository = new HoaDonDienNuocViewModelRepositoryImpl();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of danhSachHoaDonDienNuoc method, of class HoaDonDienNuocViewModelRepositoryImpl.
     */
    @Test
    public void testDanhSachHoaDonDienNuoc() {
        danhSach = repository.danhSachHoaDonDienNuoc();
        assertNotNull(danhSach);
        assertFalse(danhSach.isEmpty());
    }
    /**
     * Test of timTheoTen method, of class HoaDonDienNuocViewModelRepositoryImpl.
     */
    @Test
    public void testTimTheoTen() {
        danhSach = repository.timTheoTen("A101");
        assertNotNull(danhSach);
        assertFalse(danhSach.isEmpty());
    }

    /**
     * Test of danhSachPhong method, of class HoaDonDienNuocViewModelRepositoryImpl.
     */
    @Test
    public void testDanhSachPhong() {
        List<String> ds = repository.danhSachPhong();
        assertNotNull(ds);
        assertFalse(ds.isEmpty());
    }

    /**
     * Test of getIDByPhong method, of class HoaDonDienNuocViewModelRepositoryImpl.
     */
    @Test
    public void testGetIDByPhong() {
        String validId = "someValidId";
        String expectedPhong = "someExpeectedPhong";
        String actualPhong = repository.getPhongByID(validId);
        assertNotNull(actualPhong);
        assertEquals(expectedPhong, actualPhong);
    }

    /**
     * Test of getPhongByID method, of class HoaDonDienNuocViewModelRepositoryImpl.
     */
    @Test
    public void testGetPhongByID() {
        String validId = "someValidId";
        String expectedPhong = "someExpeectedPhong";
        String actualPhong = repository.getPhongByID(validId);
        assertNotNull(actualPhong);
        assertEquals(expectedPhong, actualPhong);
    }

    /**
     * Test of danhSachKhachHang method, of class HoaDonDienNuocViewModelRepositoryImpl.
     */
    @Test
    public void testDanhSachKhachHang() {
        List<String> ds = repository.danhSachKhachHang();
        
        assertNotNull(ds);
        assertFalse(ds.isEmpty());
    }

    /**
     * Test of getIDByKH method, of class HoaDonDienNuocViewModelRepositoryImpl.
     */
    @Test
    public void testGetIDByKH() {
        String id = repository.getIDByKH("John Doe");
        assertNotNull(id);
    }

    /**
     * Test of getKHByID method, of class HoaDonDienNuocViewModelRepositoryImpl.
     */
    @Test
    public void testGetKHByID() {
        String tenKH = repository.getKHByID("55759BA9-6737-47B5-8712-565B2E5F6FBD");
        assertNotNull(tenKH);
    }

    /**
     * Test of danhSachPhongHD method, of class HoaDonDienNuocViewModelRepositoryImpl.
     */
    @Test
    public void testDanhSachPhongHD() {
        List<PhongTroHDViewModel> ds = repository.danhSachPhongHD();
        assertNotNull(ds);
        assertFalse(ds.isEmpty());
    }

    /**
     * Test of getGiaDien method, of class HoaDonDienNuocViewModelRepositoryImpl.
     */
    @Test
    public void testGetGiaDien() {
        String giaDien = repository.getGiaDien("test");
        assertNotNull(giaDien);
    }

    /**
     * Test of getGiaNuoc method, of class HoaDonDienNuocViewModelRepositoryImpl.
     */
    @Test
    public void testGetGiaNuoc() {
        String giaNuoc = repository.getGiaNuoc("test");
        assertNotNull(giaNuoc);
    }

    /**
     * Test of getIDByHD method, of class HoaDonDienNuocViewModelRepositoryImpl.
     */
    @Test
    public void testGetIDByHD() {
       String idHD = repository.getIDByHD("test");
        assertNotNull(idHD);
    }

    /**
     * Test of main method, of class HoaDonDienNuocViewModelRepositoryImpl.
     */
    @Test
    public void testMain() {
       
    }

    /**
     * Test of ListHoaDonDienNuocTT method, of class HoaDonDienNuocViewModelRepositoryImpl.
     */
    @Test
    public void testListHoaDonDienNuocTT() {
        danhSach = repository.ListHoaDonDienNuocTT(1);
        assertNotNull(danhSach);
        assertFalse(danhSach.isEmpty());
    }
}
