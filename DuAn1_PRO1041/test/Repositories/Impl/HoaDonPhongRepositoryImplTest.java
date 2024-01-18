/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Repositories.Impl;

import DomainModel.HoaDonPhong;
import java.util.ArrayList;
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
 * @author Chien Duong
 */
public class HoaDonPhongRepositoryImplTest {

    public HoaDonPhongRepositoryImplTest() {
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
    public void testAdd_Dung() {
        HoaDonPhong hdp = new HoaDonPhong("id1", "ma1", 12,
                new Date("11-08-2023"), 5000000, true, "idPT1", "idKH2", "idHD3"
        );
        HoaDonPhongRepositoryImpl instance = new HoaDonPhongRepositoryImpl();

        boolean expResult = true;

        boolean result = instance.add(hdp);

        assertEquals(expResult, result);
    }

    @Test
    public void testAdd_DeTrong() {
        HoaDonPhong hdp = null; // Giả sử hóa đơn phòng không được cung cấp
        HoaDonPhongRepositoryImpl instance = new HoaDonPhongRepositoryImpl();

        boolean expResult = false;

        boolean result = instance.add(hdp);

        assertEquals(expResult, result);
    }

    @Test
    public void testAdd_Sai() {
       HoaDonPhong hdp = new HoaDonPhong(null, "ma1", 12,
                new Date("11-08-2023"), 5000000, true, "idPT1", "idKH2", "idHD3"
        );
        HoaDonPhongRepositoryImpl instance = new HoaDonPhongRepositoryImpl();

        boolean expResult = false;

        boolean result = instance.add(hdp);

        assertEquals(expResult, result);
    }

    @Test
    public void testUpdate_Dung() {
        
        HoaDonPhong hdp = new HoaDonPhong("id1", "ma1", 12,
                new Date("11-08-2023"), 5000000, true, "idPT1", "idKH2", "idHD3"
        );;
        String id = "HD001"; // Giả sử ID hóa đơn phòng hợp lệ
        HoaDonPhongRepositoryImpl instance = new HoaDonPhongRepositoryImpl();

        boolean expResult = true;

        boolean result = instance.update(hdp, id);

        assertEquals(expResult, result);
    }

    @Test
    public void testUpdate_DeTrong() {
        HoaDonPhong hdp = null; // Giả sử hóa đơn phòng không được cung cấp
        String id = ""; // Giả sử ID không được cung cấp
        HoaDonPhongRepositoryImpl instance = new HoaDonPhongRepositoryImpl();

        boolean expResult = false;

        boolean result = instance.update(hdp, id);

        assertEquals(expResult, result);
    }

    @Test
    public void testUpdate_Sai() {
        HoaDonPhong hdp = new HoaDonPhong(/* Thông tin không hợp lệ của hóa đơn phòng */);
        String id = "IDKhongTonTai"; // Giả sử ID không tồn tại
        HoaDonPhongRepositoryImpl instance = new HoaDonPhongRepositoryImpl();

        boolean expResult = false;

        boolean result = instance.update(hdp, id);

        assertEquals(expResult, result);
    }

    @Test
    public void testDelete_Dung() {
        String id = "HD001"; // Giả sử ID hóa đơn phòng tồn tại
        HoaDonPhongRepositoryImpl instance = new HoaDonPhongRepositoryImpl();

        boolean expResult = true;

        boolean result = instance.delete(id);

        assertEquals(expResult, result);
    }

    @Test
    public void testDelete_Sai() {
        String id = "IDKhongTonTai"; // Giả sử ID không tồn tại
        HoaDonPhongRepositoryImpl instance = new HoaDonPhongRepositoryImpl();

        boolean expResult = false;

        boolean result = instance.delete(id);

        assertEquals(expResult, result);
    }
        @Test
    public void testSearch_Dung() {
        String tenPhong = "Phong101"; // Giả sử tên phòng hợp lệ
        HoaDonPhongRepositoryImpl instance = new HoaDonPhongRepositoryImpl();

        List<HoaDonPhong> expResult = new ArrayList<>();
        expResult.add(new HoaDonPhong("ma1"));

        List<HoaDonPhong> result = instance.search(tenPhong);

        assertEquals(expResult, result);
    }

    @Test
    public void testSearch_Sai() {
        String tenPhong = "PhongKhongTonTai"; // Giả sử tên phòng không tồn tại
        HoaDonPhongRepositoryImpl instance = new HoaDonPhongRepositoryImpl();

        List<HoaDonPhong> expResult = new ArrayList<>();

        List<HoaDonPhong> result = instance.search(tenPhong);

        assertEquals(expResult, result);
    }

}
