/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Repositories.Impl;

import DomainModel.HoaDonPhong;
import DomainModel.PhongTro;
import Repositories.IHoaDonPhongRepository;
import Repositories.IPhongTroRepository;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alvin
 */
public class HoaDonPhongRepositoryImplTest {

    private HoaDonPhongRepositoryImpl instance;
    private PhongTroRepositoryImpl instancePT;

    public HoaDonPhongRepositoryImplTest() {
        instance = new HoaDonPhongRepositoryImpl();
        instancePT = new PhongTroRepositoryImpl();
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
    public void testGetAll() {
        System.out.println("pass");
        HoaDonPhongRepositoryImpl instance = new HoaDonPhongRepositoryImpl();
//        List<HoaDonPhong> expResult = null;
        List<HoaDonPhong> result = instance.getAll();
//        assertEquals(expResult, result);
        assertNotNull("Danh sách hoá đơn không được null", result);
//        fail("The test case is a prototype.");
    }//pass

    @Test
    public void testAdd_Dung() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = sdf.parse("2024/01/01");
        HoaDonPhong hdp = new HoaDonPhong("PH101", "101", 1,
                new Date("01-02-2024"), 2000000, true, "1792F29F-B057-4A29-ABEE-EAA3D554E79B", "037CBDEB-1073-4D51-A641-1FC20A5F8C8E", "42EE1E38-9510-4A52-8C2C-E5C654F30C87"
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
    }//pass

    @Test
    public void testAdd_Sai() {
        HoaDonPhong hdp = new HoaDonPhong(null, "ma1", 12,
                new Date("11-08-2023"), 5000000, true, "idPT1", "idKH2", "idHD3"
        );
        HoaDonPhongRepositoryImpl instance = new HoaDonPhongRepositoryImpl();

        boolean expResult = false;

        boolean result = instance.add(hdp);

        assertEquals(expResult, result);
    }//

    @Test
    public void testUpdate_Dung() {

        HoaDonPhong hdp = new HoaDonPhong("E8834485-D5FB-4C81-A740-461AD3AB01E5", "HDPP03", 9,
                new Date("11-08-2023"), 5000000, true, "1792F29F-B057-4A29-ABEE-EAA3D554E79B", "037CBDEB-1073-4D51-A641-1FC20A5F8C8E", "42EE1E38-9510-4A52-8C2C-E5C654F30C87"
        );
        String id = "E8834485-D5FB-4C81-A740-461AD3AB01E5"; // Giả sử ID hóa đơn phòng hợp lệ
        HoaDonPhongRepositoryImpl instance = new HoaDonPhongRepositoryImpl();

        boolean expResult = true;

        boolean result = instance.update(hdp, id);

        assertEquals(expResult, result);
    }//fail

    @Test
    public void testUpdate_DeTrong() {
        HoaDonPhong hdp = null; // Giả sử hóa đơn phòng không được cung cấp
        String id = ""; // Giả sử ID không được cung cấp
        HoaDonPhongRepositoryImpl instance = new HoaDonPhongRepositoryImpl();

        boolean expResult = false;

        boolean result = instance.update(hdp, id);

        assertEquals(expResult, result);
    }//pass

    @Test
    public void testUpdate_Sai() {
        HoaDonPhong hdp = new HoaDonPhong(/* Thông tin không hợp lệ của hóa đơn phòng */);
        String id = "IDKhongTonTai"; // Giả sử ID không tồn tại
        HoaDonPhongRepositoryImpl instance = new HoaDonPhongRepositoryImpl();

        boolean expResult = false;

        boolean result = instance.update(hdp, id);

        assertEquals(expResult, result);
    }//pass

//    @Test
//    public void testSearch_Dung() {
//        String tenPhong = "Phòng số 3"; // Giả sử tên phòng hợp lệ
//        HoaDonPhongRepositoryImpl instance = new HoaDonPhongRepositoryImpl();
//
//        List<HoaDonPhong> expResult = new ArrayList<>();
//        expResult.add(new HoaDonPhong("1"));
//
//        List<HoaDonPhong> result = instance.search(tenPhong);
//
//        assertEquals(expResult, result);
//    }//fail
    @Test
    public void testSearch_Sai() {
        String tenPhong = "Phong987987"; // Giả sử tên phòng không tồn tại
        HoaDonPhongRepositoryImpl instance = new HoaDonPhongRepositoryImpl();

        List<HoaDonPhong> expResult = new ArrayList<>();

        List<HoaDonPhong> result = instance.search(tenPhong);

        assertEquals(expResult, result);
    }//pass

    /**
     * Test of getListByTT method, of class HoaDonPhongRepositoryImpl.
     */
    @Test
    public void testGetListByTT() {
        System.out.println("getListByTT");
        int tt = 0;
        HoaDonPhongRepositoryImpl instance = new HoaDonPhongRepositoryImpl();
        List<HoaDonPhong> expResult = null;
        List<HoaDonPhong> result = instance.getListByTT(tt);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    @Test
    public void testGetListMa() {
        System.out.println("getListMa");
        HoaDonPhongRepositoryImpl instance = new HoaDonPhongRepositoryImpl();
        List<String> expResult = null;
        List<String> result = instance.getListMa();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetListPhong() {
        System.out.println("getListPhong");
        HoaDonPhongRepositoryImpl instance = new HoaDonPhongRepositoryImpl();
        List<String> expResult = null;
        List<String> result = instance.getListPhong();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetTenKHByPhong() {
        System.out.println("getTenKHByPhong");
        String tenPhong = "";
        HoaDonPhongRepositoryImpl instance = new HoaDonPhongRepositoryImpl();
        String expResult = "";
        String result = instance.getTenKHByPhong(tenPhong);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPhongById() {
        System.out.println("getPhongById");
        String id = "";
        HoaDonPhongRepositoryImpl instance = new HoaDonPhongRepositoryImpl();
        String expResult = "";
        String result = instance.getPhongById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetKHByID() {
        System.out.println("getKHByID");
        String id = "";
        HoaDonPhongRepositoryImpl instance = new HoaDonPhongRepositoryImpl();
        String expResult = "";
        String result = instance.getKHByID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetIDByPhong() {
        System.out.println("getIDByPhong");
        String tenPhong = "";
        HoaDonPhongRepositoryImpl instance = new HoaDonPhongRepositoryImpl();
        String expResult = "";
        String result = instance.getIDByPhong(tenPhong);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetIDByKH() {
        System.out.println("getIDByKH");
        String tenKH = "";
        HoaDonPhongRepositoryImpl instance = new HoaDonPhongRepositoryImpl();
        String expResult = "";
        String result = instance.getIDByKH(tenKH);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testAdd() {
        System.out.println("add");
        HoaDonPhong hdp = null;
        HoaDonPhongRepositoryImpl instance = new HoaDonPhongRepositoryImpl();
        boolean expResult = false;
        boolean result = instance.add(hdp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdate() {
        System.out.println("update");
        HoaDonPhong hdp = null;
        String id = "";
        HoaDonPhongRepositoryImpl instance = new HoaDonPhongRepositoryImpl();
        boolean expResult = false;
        boolean result = instance.update(hdp, id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDelete() {
        System.out.println("delete");
        String id = "";
        HoaDonPhongRepositoryImpl instance = new HoaDonPhongRepositoryImpl();
        boolean expResult = false;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetGiaByPhong() {
        System.out.println("getGiaByPhong");
        String tenPhong = "";
        HoaDonPhongRepositoryImpl instance = new HoaDonPhongRepositoryImpl();
        Double expResult = null;
        Double result = instance.getGiaByPhong(tenPhong);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetThangTaoHDByIDPhong() {
        System.out.println("getThangTaoHDByIDPhong");
        String idPhong = "";
        HoaDonPhongRepositoryImpl instance = new HoaDonPhongRepositoryImpl();
        int expResult = 0;
        int result = instance.getThangTaoHDByIDPhong(idPhong);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetThoiHanNopTienByIDPhong() {
        System.out.println("getThoiHanNopTienByIDPhong");
        String idPhong = "";
        HoaDonPhongRepositoryImpl instance = new HoaDonPhongRepositoryImpl();
        int expResult = 0;
        int result = instance.getThoiHanNopTienByIDPhong(idPhong);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetListHDDH() {
        System.out.println("getListHDDH");
        HoaDonPhongRepositoryImpl instance = new HoaDonPhongRepositoryImpl();
        List<HoaDonPhong> expResult = null;
        List<HoaDonPhong> result = instance.getListHDDH();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetListThangDTT() {
        System.out.println("getListThangDTT");
        String id = "";
        HoaDonPhongRepositoryImpl instance = new HoaDonPhongRepositoryImpl();
        List<String> expResult = null;
        List<String> result = instance.getListThangDTT(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetIDHDByPhong() {
        System.out.println("getIDHDByPhong");
        String tenPhong = "";
        HoaDonPhongRepositoryImpl instance = new HoaDonPhongRepositoryImpl();
        String expResult = "";
        String result = instance.getIDHDByPhong(tenPhong);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    //new update 10 unittest---------
    @Test
    public void testGetAll2() {
        List<HoaDonPhong> result = instance.getAll();
        assertNotNull("Danh sách hóa đơn không được null", result);
        assertFalse("Danh sách hóa đơn không được rỗng", result.isEmpty());
    }

    //test kiểm tra tìm kiếm tra nhập ĐÚNG dữ liệu
    @Test
    public void testSearchTrue() {
        String tenPhong = "Phòng số 3";
//        PhongTroRepositoryImpl ptRepo = new PhongTroRepositoryImpl();
        List<PhongTro> result = instancePT.TimKiem(tenPhong);
        assertNotNull("Danh sách hóa đơn tìm kiếm không được null", result);
        assertFalse("Danh sách hóa đơn tìm kiếm không được rỗng", result.isEmpty());
        for (PhongTro pt : result) {
            assertEquals("Phòng không đúng", tenPhong, pt.getTen());
        }
    }

    //test kiểm tra tìm kiếm tra nhập SAI dữ liệu
    @Test
    public void testSearchFalse() {
        String tenPhong = "";
        List<PhongTro> result = instancePT.TimKiem(tenPhong);
        assertNotNull("Danh sách phòng trống tìm kiếm không được null", result);
        assertFalse("Danh sách phòng trống tìm kiếm không được rỗng", result.isEmpty());
        for (PhongTro pt : result) {
            assertEquals("Phòng không đúng", tenPhong, pt.getTen());
        }
    }

    //test update pass
    @Test
    public void testUpdateTrue() {
        HoaDonPhong hdp = new HoaDonPhong("HDP0012", 55000);
        String id = "E8834485-D5FB-4C81-A740-461AD3AB01E5";
        HoaDonPhongRepositoryImpl instance = new HoaDonPhongRepositoryImpl();
        boolean expResult = true;
        boolean result = instance.update(hdp, id);
//        assertTrue(result);
        assertEquals(expResult, result);
    }

    //test update false
    @Test
    public void testUpdateFalse() {
        HoaDonPhong hdp = new HoaDonPhong("HDP0012", 55000);
        String id = ""; //để trống để test
        HoaDonPhongRepositoryImpl instance = new HoaDonPhongRepositoryImpl();
        boolean expResult = false;
        boolean result = instance.update(hdp, id);
//        assertTrue(result);
        assertEquals(expResult, result);
    }

    //test update with wrong date format
    @Test
    public void testUpdateWithWrongDateFormat() {
        System.out.println("updateWithWrongDateFormat");
        HoaDonPhong hdp = new HoaDonPhong("65998C72-51E9-42A2-B1A3-E5EEB4C00732", "HDPP02", new Date("@#@%$"), 2000000, true, "85CEF08E-5094-4811-89F7-FE9C95CA453C", "3B40B979-8069-43A2-B745-65C31EEDFAEB", "39494AD2-953A-484B-A0C5-EE09D41111EE");
        String id = "E8834485-D5FB-4C81-A740-461AD3AB01E5";
        HoaDonPhongRepositoryImpl instance = new HoaDonPhongRepositoryImpl();
        boolean expResult = false;
        boolean result = instance.update(hdp, id);
        assertEquals(expResult, result);
    }

    //test add pass
    @Test
    public void testAddValidData() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date ngayTao = sdf.parse("2024-01-22");
        HoaDonPhong hdp = new HoaDonPhong("PH101", "101", 1,
                ngayTao, 2000000, true, "1792F29F-B057-4A29-ABEE-EAA3D554E79B", "037CBDEB-1073-4D51-A641-1FC20A5F8C8E", "42EE1E38-9510-4A52-8C2C-E5C654F30C87"
        );
        HoaDonPhongRepositoryImpl instance = new HoaDonPhongRepositoryImpl();
        boolean expResult = true;
        boolean result = instance.add(hdp);
        assertEquals(expResult, result);
    }

    //test add null false
    @Test
    public void testAddNullData() {
        HoaDonPhong hdp = null;
        HoaDonPhongRepositoryImpl instance = new HoaDonPhongRepositoryImpl();
        boolean expResult = false;
        boolean result = instance.add(hdp);
        assertEquals(expResult, result);
    }

    //test add sai định dạng mã hoá đơn phòng
    @Test
    public void testAddInvalidCode() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date ngayTao = sdf.parse("2024-01-22");
        HoaDonPhong hdp = new HoaDonPhong("PH101", "##&^@$", 1,
                ngayTao, 2000000, true, "1792F29F-B057-4A29-ABEE-EAA3D554E79B", "037CBDEB-1073-4D51-A641-1FC20A5F8C8E", "42EE1E38-9510-4A52-8C2C-E5C654F30C87"
        );
        HoaDonPhongRepositoryImpl instance = new HoaDonPhongRepositoryImpl();
        boolean expResult = false;
        boolean result = instance.add(hdp);
        assertEquals(expResult, result);
    }

    //test add để trống mã hoá đơn
    @Test
    public void testAddEmtyCode() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date ngayTao = sdf.parse("2024-01-22");
        HoaDonPhong hdp = new HoaDonPhong("PH101", "", 1, ngayTao, 2000000, true,
                "1792F29F-B057-4A29-ABEE-EAA3D554E79B",
                "037CBDEB-1073-4D51-A641-1FC20A5F8C8E",
                "42EE1E38-9510-4A52-8C2C-E5C654F30C87");
        HoaDonPhongRepositoryImpl instance = new HoaDonPhongRepositoryImpl();
        boolean expResult = false;
        boolean result = instance.add(hdp);
        assertEquals(expResult, result);
    }
}
