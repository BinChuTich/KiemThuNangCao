/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Repositories.Impl;

import DomainModel.HopDong;
import DomainModel.HopDongTaiSan;
import DomainModel.KhachHang;
import DomainModel.PhongTro;
import Repositories.IHopDongRepository;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author quach
 */
public class HopDongRepositoryImplTest {

    private IHopDongRepository hopDongRepository;
    private HopDong testHopDong;

    public HopDongRepositoryImplTest() {
    }

    @Before
    public void setUp() {
        // Khởi tạo đối tượng HopDongRepositoryImpl trước mỗi test case
        hopDongRepository = new HopDongRepositoryImpl();

        // Tạo dữ liệu test cho HopDong
        testHopDong = new HopDong();
        UUID id = UUID.randomUUID();
        testHopDong.setId(String.valueOf(id));
        testHopDong.setMa("HDTest03");
        testHopDong.setTienCoc(100.0);
        testHopDong.setGiaPhong(200.0);
        testHopDong.setGiaDien(50.0);
        testHopDong.setGiaNuoc(30.0);

        Calendar calendar = Calendar.getInstance();
        testHopDong.setNgTao(calendar.getTime()); // Ngày tạo là ngày hiện tại
        calendar.add(Calendar.MONTH, 1);
        testHopDong.setNgKT(calendar.getTime()); // Ngày kết thúc là ngày hiện tại + 1 tháng

        testHopDong.setThoiGianNopTien(2);
        testHopDong.setIdPhongTro("A8C24EC8-04CD-4E2E-A379-33638F2ECCF4");
        testHopDong.setIdKH("89E29416-0DF3-42FD-8556-78EC4C3FDEBE");
    }

    @Test
    public void testGetAll() {
        assertNotNull(hopDongRepository.getAll());
    }

    @Test
    public void testGetListPT() {
        assertNotNull(hopDongRepository.getListPT());
    }

    @Test
    public void testGetListKH() {
        assertNotNull(hopDongRepository.getListKH());
    }

    @Test
    public void testGetListTS() {
        assertNotNull(hopDongRepository.getListTS());
    }

    @Test
    public void testAdd() {
        UUID id = UUID.randomUUID();
        testHopDong.setId(String.valueOf(id));
        assertTrue(hopDongRepository.add(testHopDong));
    }

    @Test
    public void testAddDuplicateHopDong() {
        // Tạo một đối tượng PhongTro đã tồn tại trong cơ sở dữ liệu
        UUID id = UUID.randomUUID();
//        String idExist = "DD88F8A3-BD1C-498A-BBEF-A277FD3F5478";
        String idStr = String.valueOf(id);
        testHopDong.setId(idStr);

        // Thêm phòng trọ có ID trùng vào cơ sở dữ liệu
        boolean result = hopDongRepository.add(testHopDong);

        // Kiểm tra xem việc thêm có thành công hay không (nên thất bại vì ID đã tồn tại)
        assertFalse(result);
    }

    @Test
    public void testUpdate() {
        assertTrue(hopDongRepository.update(testHopDong, "DD88F8A3-BD1C-498A-BBEF-A277FD3F5478"));
    }

    @Test
    public void testUpdateWithNullHopDong() {
        // Cập nhật với HopDong là null và kiểm tra xem cập nhật thất bại
        assertFalse(hopDongRepository.update(null, "DD88F8A3-BD1C-498A-BBEF-A277FD3F5478"));
    }

    @Test
    public void testUpdateWithNullId() {
        // Cập nhật với id là null và kiểm tra xem cập nhật thất bại
        assertFalse(hopDongRepository.update(testHopDong, null));
    }

    @Test
    public void testUpdateNgayTao() {
        UUID id = UUID.randomUUID();
        testHopDong.setId(String.valueOf(id));
        testHopDong.setMa("HD04");
        Date ngayTaoCu = testHopDong.getNgTao();

        assertTrue(hopDongRepository.add(testHopDong));

        testHopDong.setNgTao(testHopDong.getNgKT());

        // Cập nhật HopDong
        assertTrue(hopDongRepository.update(testHopDong, String.valueOf(id)));

        // Kiểm tra xem ngày tạo có bị thay đổi hay không
        assertNotEquals(ngayTaoCu, testHopDong.getNgTao());

    }

    @Test
    public void testUpdateNgayKetThuc() {
        UUID id = UUID.randomUUID();
        testHopDong.setId(String.valueOf(id));
        testHopDong.setMa("HD03");

        Date ngayKTcu = testHopDong.getNgKT();
        assertTrue(hopDongRepository.add(testHopDong));

        testHopDong.setNgKT(testHopDong.getNgTao());
        // Cập nhật HopDong
        assertTrue(hopDongRepository.update(testHopDong, String.valueOf(id)));

        // Kiểm tra xem ngày kết thúc có bị thay đổi hay không
        assertNotEquals(ngayKTcu, testHopDong.getNgKT());
    }

    @Test
    public void testGetListMa() {
        assertNotNull(hopDongRepository.getListMa());
    }

    @Test
    public void testGetLoaiPhongByIdPhong() {

        String idPhong = "976E38D5-835C-432F-B3B8-A2E16CE16B26ass";

        // Gọi hàm để lấy loại phòng
        String loaiPhong = hopDongRepository.getLoaiPhongByIdPhong(idPhong);

        // Kiểm tra kết quả
        assertNotNull(loaiPhong, "Kết quả không nên là null");

        assertEquals("Nhỏ", loaiPhong, "Loại phòng không khớp với kỳ vọng");
    }

    @Test
    public void testGetDienTichByIdPhong() {
        String idPhong = "14D7B03C-D0E5-4BC7-A0E3-2E64BF9445FC";
        String dienTich = hopDongRepository.getDienTichByIdPhong(idPhong);

        assertNotNull(dienTich);
    }

    @Test
    public void testGetDienTichByIdPhongWithNullId() {
        String dienTich = hopDongRepository.getDienTichByIdPhong(null);

        assertNotNull(dienTich);
    }

    @Test
    public void testGetGiaPhongByIdPhong() {
        String idPhong = "14D7B03C-D0E5-4BC7-A0E3-2E64BF9445FC";
        String giaPhong = hopDongRepository.getGiaPhongByIdPhong(idPhong);

        assertNotNull(giaPhong);
    }

    @Test
    public void testGetGiaPhongByIdPhongWithNullId() {
        String giaPhong = hopDongRepository.getGiaPhongByIdPhong(null);

        assertNull(giaPhong);
    }

    @Test
    public void testGetTenKHById() {
        String idKhachHang = "89E29416-0DF3-42FD-8556-78EC4C3FDEBE";
        String tenKH = hopDongRepository.getTenKHById(idKhachHang);

        assertNotNull(tenKH);
    }

    @Test
    public void testGetTenKHByIdWithNullId() {
        String tenKH = hopDongRepository.getTenKHById(null);

        assertNull(tenKH);
    }

    @Test
    public void testGetTenPTById() {
        String idPhongTro = "14D7B03C-D0E5-4BC7-A0E3-2E64BF9445FC";
        String tenPT = hopDongRepository.getTenPTById(idPhongTro);

        assertNotNull(tenPT);
    }

    @Test
    public void testGetTenPTByIdWithNullId() {
        String tenPT = hopDongRepository.getTenPTById(null);

        assertNull(tenPT);
    }

    @Test
    public void testGetKHById() {
        String idKhachHang = "89E29416-0DF3-42FD-8556-78EC4C3FDEBE";
        KhachHang kh = hopDongRepository.getKHById(idKhachHang);

        assertNotNull(kh);
    }

    @Test
    public void testGetKHByIdWithInvalidId() {
        String idKhachHang = "invalidKhachHangId14D7B03C-D0E5-4BC7-A0E3-2E64BF9445FC";
        KhachHang kh = hopDongRepository.getKHById(idKhachHang);

        assertNull(kh);
    }

    @Test
    public void testGetKHByIdWithNullId() {
        KhachHang kh = hopDongRepository.getKHById(null);

        assertNull(kh);
    }

    @Test
    public void testGetPTById() {
        String idPhongTro = "14D7B03C-D0E5-4BC7-A0E3-2E64BF9445FC";
        PhongTro pt = hopDongRepository.getPTById(idPhongTro);

        assertNotNull(pt);
    }

    @Test
    public void testGetPTByIdWithInvalidId() {
        String idPhongTro = "14D7B03C-D0E5-4BC7-A0E3-àasfasfasf";
        PhongTro pt = hopDongRepository.getPTById(idPhongTro);

        assertNull(pt);
    }

    @Test
    public void testGetPTByIdWithNullId() {
        PhongTro pt = hopDongRepository.getPTById(null);

        assertNull(pt);
    }

    @Test
    public void testGetIdPTByTenPT() {

        String tenPhongTro = "Test";
        String idPT = hopDongRepository.getIdPTByTenPT(tenPhongTro);

        assertNotNull(idPT);

    }

    @Test
    public void testGetIdPTByTenPTWithInvalidTenPT() {
        String tenPhongTro = "invalidTenPhongTro";
        String idPT = hopDongRepository.getIdPTByTenPT(tenPhongTro);

        assertNull(idPT);
    }

    @Test
    public void testGetIdPTByTenPTWithNullTenPT() {
        String idPT = hopDongRepository.getIdPTByTenPT(null);

        assertNull(idPT);
    }

    @Test
    public void testGetIdKHBySDT() {
        String sdt = "0375999124";

        String idKH = hopDongRepository.getIdKHBySDT(sdt);

        assertNotNull(idKH);
    }

    @Test
    public void testGetIdKHBySDTWithInvalidSDT() {
        String sdt = "invalidPhoneNumber";
        String idKH = hopDongRepository.getIdKHBySDT(sdt);

        assertNull(idKH);
    }

    @Test
    public void testGetIdKHBySDTWithNullSDT() {
        String idKH = hopDongRepository.getIdKHBySDT(null);

        assertNull(idKH);
    }

    @Test
    public void testSearchByTenKH() {
        String tenKH = "Thành";
        List<HopDong> result = hopDongRepository.searchByTenKH(tenKH);

        assertNotNull(result);
    }

    @Test
    public void testSearchByTenKHWithInvalidTenKH() {
        String tenKH = "invalidTenKH";
        List<HopDong> result = hopDongRepository.searchByTenKH(tenKH);

        assertNotNull(result);
    }

    @Test
    public void testSearchByTenKHWithNullTenKH() {
        List<HopDong> result = hopDongRepository.searchByTenKH(null);

        assertNotNull(result);
    }

    @Test
    public void testSearchHDConHan() {
        List<HopDong> result = hopDongRepository.searchHDConHan();

        assertNotNull(result);
    }

    @Test
    public void testSearchHDHetHan() {
        List<HopDong> result = hopDongRepository.searchHDHetHan();

        assertNotNull(result);
    }

    @Test
    public void testSearchHDSapHetHan() {
        List<HopDong> result = hopDongRepository.searchHDSapHetHan();

        assertNotNull(result);
    }

    @Test
    public void testAddHDTS() {
        UUID id = UUID.randomUUID();
        HopDongTaiSan hdts = new HopDongTaiSan();

        hdts.setId(String.valueOf(id));
        hdts.setIdHD("EAA656CD-4F38-4896-9B72-DC6F841DBF97");
        hdts.setIdTS("6636BC53-ACC3-4C69-9C78-4E555C9A6D0F");
        hdts.setSoLuong(1);

        boolean result = hopDongRepository.addHDTS(hdts);

        assertTrue(result);
    }

    @Test
    public void testAddHDTSWithInvalidData() {

        HopDongTaiSan hdts = new HopDongTaiSan();
        hdts.setId("2");
        hdts.setIdHD(testHopDong.getId());
        hdts.setIdTS("heheheh");
        hdts.setSoLuong(10);
        // Set other necessary attributes for HopDongTaiSan

        boolean result = hopDongRepository.addHDTS(hdts);

        assertFalse(result);
        // Add assertions for the expected behavior when adding HDTS with invalid data
    }

    @Test
    public void testAddHDTSWithNullData() {

        HopDongTaiSan hdts = new HopDongTaiSan();
        hdts.setId("3");
        hdts.setIdHD(testHopDong.getId());
        hdts.setIdTS(null);
        hdts.setSoLuong(3);
        // Set other necessary attributes for HopDongTaiSan

        boolean result = hopDongRepository.addHDTS(hdts);

        assertFalse(result);
        // Add assertions for the expected behavior when adding HDTS with null data
    }

    @Test
    public void testGetListHDTSByIdHD() {
        List<HopDongTaiSan> result = hopDongRepository.getListHDTSByIdHD(testHopDong.getId());

        assertNotNull(result);
    }
    
    @Test
    public void testGetListHDTSByInvalidIdHD() {
        String invalidId = UUID.randomUUID().toString();
        String invalidHopDongId = invalidId;

        List<HopDongTaiSan> result = hopDongRepository.getListHDTSByIdHD(invalidHopDongId);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testGetTSByIdTS() {
        String taiSanId = "6636BC53-ACC3-4C69-9C78-4E555C9A6D0F";
        String result = hopDongRepository.getTSByIdTS(taiSanId);

        assertNotNull(result);
    }
    
    @Test
    public void testGetTSByInvalidIdTS() {
        String invalidId = UUID.randomUUID().toString();
        String invalidTaiSanId = invalidId;

        String result = hopDongRepository.getTSByIdTS(invalidTaiSanId);

        assertNull(result);

    }

    @Test
    public void testAddKH() {
        String invalidId = UUID.randomUUID().toString();
        
        KhachHang khachHang = new KhachHang();
        khachHang.setId(invalidId);
        khachHang.setMa("KH001");
        khachHang.setTen("Nguyen Van A");
        khachHang.setCccd("123456789");
        khachHang.setNgSinh(new Date());
        khachHang.setEmail("nguyenvana@example.com");
        khachHang.setSdt("0123456789");
        khachHang.setGioiTinh(true);
        khachHang.setDiaChi("123 Main Street");
        // Thiết lập các thuộc tính khác cho KhachHang

        boolean result = hopDongRepository.addKH(khachHang);

        assertTrue(result);
    }
    
    @Test
    public void testAddKHWithExistingData() {
        String existingKhachHangId = "existingId";

        KhachHang khachHang = new KhachHang();
        khachHang.setId(existingKhachHangId);
        khachHang.setMa("KH0011421");
        khachHang.setTen("Nguyen Van B");
        khachHang.setCccd("987654321");
        khachHang.setNgSinh(new Date());
        khachHang.setEmail("nguyenvanb@example.com");
        khachHang.setSdt("9876543210");
        khachHang.setGioiTinh(false);
        khachHang.setDiaChi("456 Main Street");
        // Thiết lập các thuộc tính khác cho KhachHang

        boolean result = hopDongRepository.addKH(khachHang);

        assertFalse(result);
    }

    @Test
    public void testAddKHWithNullId() {
        KhachHang khachHang = new KhachHang();
        // Không thiết lập id

        boolean result = hopDongRepository.addKH(khachHang);

        assertFalse(result);
    }

    @Test
    public void testAddKHWithEmptyMa() {
        KhachHang khachHang = new KhachHang();
        khachHang.setId("2");
        khachHang.setMa(""); // Ma rỗng
        khachHang.setTen("Nguyen Van C");
        khachHang.setCccd("333333333");
        khachHang.setNgSinh(new Date());
        khachHang.setEmail("nguyenvanc@example.com");
        khachHang.setSdt("5555555555");
        khachHang.setGioiTinh(true);
        khachHang.setDiaChi("789 Main Street");
        // Thiết lập các thuộc tính khác cho KhachHang

        boolean result = hopDongRepository.addKH(khachHang);

        assertFalse(result);
    }

}
