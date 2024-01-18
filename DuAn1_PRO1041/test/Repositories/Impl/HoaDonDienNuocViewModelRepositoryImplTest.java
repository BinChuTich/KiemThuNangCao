/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Repositories.Impl;

import ViewModel.HoaDonDienNuocViewModel;
import ViewModel.PhongTroHDViewModel;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author quach
 */
public class HoaDonDienNuocViewModelRepositoryImplTest {

    private HoaDonDienNuocViewModelRepositoryImpl repository;

    public HoaDonDienNuocViewModelRepositoryImplTest() {
    }

    @Before
    public void setup() {
        repository = new HoaDonDienNuocViewModelRepositoryImpl();
    }

    @Test
    public void testDanhSachHoaDonDienNuoc() {
        List<HoaDonDienNuocViewModel> danhSach = repository.danhSachHoaDonDienNuoc();

        assertNotNull(danhSach);
        assertFalse(danhSach.isEmpty());
    }

    @Test
    public void testTimTheoTen() {
        List<HoaDonDienNuocViewModel> danhSach = repository.timTheoTen("A101");

        assertNotNull(danhSach);
        assertFalse(danhSach.isEmpty());
    }

    @Test
    public void testDanhSachPhong() {
        List<String> danhSach = repository.danhSachPhong();

        assertNotNull(danhSach);
        assertFalse(danhSach.isEmpty());
    }

    @Test
    public void testGetIDByPhong() {
        String expectedId = "someId";

        String actualId = repository.getIDByPhong("A101");

        assertNotNull(actualId);
        assertEquals(expectedId, actualId);
    }

    @Test
    public void testGetPhongByID() {
        String validId = "someValidId";
        String expectedPhong = "someExpectedPhong";

        String actualPhong = repository.getPhongByID(validId);

        // Kiểm tra kết quả
        assertNotNull(actualPhong);
        assertEquals(expectedPhong, actualPhong);

    }

    @Test
    public void testDanhSachKhachHang() {

        List<String> danhSach = repository.danhSachKhachHang();

        assertNotNull(danhSach);
        assertFalse(danhSach.isEmpty());
    }

    @Test
    public void testGetIDByKH() {

        String id = repository.getIDByKH("John Doe");

        assertNotNull(id);
    }

    @Test
    public void testGetIDByKHWithNull() {

        String id = repository.getIDByKH(null);

        assertNull(id);
    }

    @Test
    public void testGetKHByID() {
        String tenKH = repository.getKHByID("55759BA9-6737-47B5-8712-565B2E5F6FBD");

        assertNotNull(tenKH);
    }

    @Test
    public void testGetKHByIDWithNull() {
        String tenKH = repository.getKHByID(null);

        assertNull(tenKH);
    }

    @Test
    public void testDanhSachPhongHD() {
        List<PhongTroHDViewModel> danhSach = repository.danhSachPhongHD();

        assertNotNull(danhSach);
        assertFalse(danhSach.isEmpty());
    }

    @Test
    public void testGetGiaDien() {
        String giaDien = repository.getGiaDien("test");

        assertNotNull(giaDien);
    }

    @Test
    public void testGetGiaNuoc() {
        String giaNuoc = repository.getGiaNuoc("test");

        assertNotNull(giaNuoc);
    }

    @Test
    public void testGetIDByHD() {
        String idHD = repository.getIDByHD("test");

        assertNotNull(idHD);
    }

    @Test
    public void testListHoaDonDienNuocTT() {
        
        List<HoaDonDienNuocViewModel> danhSach = repository.ListHoaDonDienNuocTT(1);

        assertNotNull(danhSach);
        assertFalse(danhSach.isEmpty());
    }

}
