/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Repositories;

import DomainModel.HopDong;
import DomainModel.HopDongTaiSan;
import DomainModel.KhachHang;
import DomainModel.PhongTro;
import DomainModel.TaiSan;
import Repositories.Impl.HopDongRepositoryImpl;
import java.util.Calendar;
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
 * @author vungo
 */
public class IHopDongRepositoryTest {
    
    private IHopDongRepository hopDongRepository;
    private HopDong testHopDong;

    public IHopDongRepositoryTest() {
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
    
// lỗi 
    
    @Test
    public void testAdd() {
        UUID id = UUID.randomUUID();
        testHopDong.setId(String.valueOf(id));
        assertTrue(hopDongRepository.add(testHopDong));
    }
// oke 
    
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
// sai
    @Test
    public void testUpdate() {
        assertTrue(hopDongRepository.update(testHopDong, "DD88F8A3-BD1C-498A-BBEF-A277FD3F5478"));
    }
    
// oke 
    
    @Test
    public void testUpdateWithNullHopDong() {
        // Cập nhật với HopDong là null và kiểm tra xem cập nhật thất bại
        assertFalse(hopDongRepository.update(null, "DD88F8A3-BD1C-498A-BBEF-A277FD3F5478"));
    }
// oke 
    @Test
    public void testUpdateWithNullId() {
        // Cập nhật với id là null và kiểm tra xem cập nhật thất bại
        assertFalse(hopDongRepository.update(testHopDong, null));
    }
// lỗi 
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
// lỗi
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
// oke
    @Test
    public void testGetListMa() {
        assertNotNull(hopDongRepository.getListMa());
    }
// lỗi 
    @Test
    public void testGetLoaiPhongByIdPhong() {

        String idPhong = "976E38D5-835C-432F-B3B8-A2E16CE16B26ass";

        // Gọi hàm để lấy loại phòng
        String loaiPhong = hopDongRepository.getLoaiPhongByIdPhong(idPhong);

        // Kiểm tra kết quả
        assertNotNull(loaiPhong, "Kết quả không nên là null");

        assertEquals("Nhỏ", loaiPhong, "Loại phòng không khớp với kỳ vọng");
    }
// lỗi 
    @Test
    public void testGetDienTichByIdPhong() {
        String idPhong = "14D7B03C-D0E5-4BC7-A0E3-2E64BF9445FC";
        String dienTich = hopDongRepository.getDienTichByIdPhong(idPhong);

        assertNotNull(dienTich);
    }
// lỗi 
    @Test
    public void testGetDienTichByIdPhongWithNullId() {
        String dienTich = hopDongRepository.getDienTichByIdPhong(null);

        assertNotNull(dienTich);
    }
// lỗi
    @Test
    public void testGetGiaPhongByIdPhong() {
        String idPhong = "14D7B03C-D0E5-4BC7-A0E3-2E64BF9445FC";
        String giaPhong = hopDongRepository.getGiaPhongByIdPhong(idPhong);

        assertNotNull(giaPhong);
    }
// oke 
    @Test
    public void testGetGiaPhongByIdPhongWithNullId() {
        String giaPhong = hopDongRepository.getGiaPhongByIdPhong(null);

        assertNull(giaPhong);
    }
// lỗi 
    @Test
    public void testGetTenKHById() {
        String idKhachHang = "89E29416-0DF3-42FD-8556-78EC4C3FDEBE";
        String tenKH = hopDongRepository.getTenKHById(idKhachHang);

        assertNotNull(tenKH);
    }
// oke 
    @Test
    public void testGetTenKHByIdWithNullId() {
        String tenKH = hopDongRepository.getTenKHById(null);

        assertNull(tenKH);
    }
// lỗi
    @Test
    public void testGetTenPTById() {
        String idPhongTro = "14D7B03C-D0E5-4BC7-A0E3-2E64BF9445FC";
        String tenPT = hopDongRepository.getTenPTById(idPhongTro);

        assertNotNull(tenPT);
    }
// oke 
    @Test
    public void testGetTenPTByIdWithNullId() {
        String tenPT = hopDongRepository.getTenPTById(null);

        assertNull(tenPT);
    }
// lỗi 
    @Test
    public void testGetKHById() {
        String idKhachHang = "89E29416-0DF3-42FD-8556-78EC4C3FDEBE";
        KhachHang kh = hopDongRepository.getKHById(idKhachHang);

        assertNotNull(kh);
    }
// oke 
    @Test
    public void testGetKHByIdWithInvalidId() {
        String idKhachHang = "invalidKhachHangId14D7B03C-D0E5-4BC7-A0E3-2E64BF9445FC";
        KhachHang kh = hopDongRepository.getKHById(idKhachHang);

        assertNull(kh);
    }
// oke 
    @Test
    public void testGetKHByIdWithNullId() {
        KhachHang kh = hopDongRepository.getKHById(null);

        assertNull(kh);
    }
// lỗi 
    @Test
    public void testGetPTById() {
        String idPhongTro = "14D7B03C-D0E5-4BC7-A0E3-2E64BF9445FC";
        PhongTro pt = hopDongRepository.getPTById(idPhongTro);

        assertNotNull(pt);
    }
// oke 
    @Test
    public void testGetPTByIdWithInvalidId() {
        String idPhongTro = "14D7B03C-D0E5-4BC7-A0E3-àasfasfasf";
        PhongTro pt = hopDongRepository.getPTById(idPhongTro);

        assertNull(pt);
    }
// oke 
    @Test
    public void testGetPTByIdWithNullId() {
        PhongTro pt = hopDongRepository.getPTById(null);

        assertNull(pt);
    }
// lỗi 
    @Test
    public void testGetIdPTByTenPT() {

        String tenPhongTro = "Test";
        String idPT = hopDongRepository.getIdPTByTenPT(tenPhongTro);

        assertNotNull(idPT);

    }
// oke 
    @Test
    public void testGetIdPTByTenPTWithInvalidTenPT() {
        String tenPhongTro = "invalidTenPhongTro";
        String idPT = hopDongRepository.getIdPTByTenPT(tenPhongTro);

        assertNull(idPT);
    }
// oke 
    @Test
    public void testGetIdPTByTenPTWithNullTenPT() {
        String idPT = hopDongRepository.getIdPTByTenPT(null);

        assertNull(idPT);
    }
// lỗi 
    @Test
    public void testGetIdKHBySDT() {
        String sdt = "0375999124";

        String idKH = hopDongRepository.getIdKHBySDT(sdt);

        assertNotNull(idKH);
    }
// oke 
    @Test
    public void testGetIdKHBySDTWithInvalidSDT() {
        String sdt = "invalidPhoneNumber";
        String idKH = hopDongRepository.getIdKHBySDT(sdt);

        assertNull(idKH);
    }
// oke 
    @Test
    public void testGetIdKHBySDTWithNullSDT() {
        String idKH = hopDongRepository.getIdKHBySDT(null);

        assertNull(idKH);
    }
// oke 
    @Test
    public void testSearchByTenKH() {
        String tenKH = "Thành";
        List<HopDong> result = hopDongRepository.searchByTenKH(tenKH);

        assertNotNull(result);
    }
// oke 
    @Test
    public void testSearchByTenKHWithInvalidTenKH() {
        String tenKH = "invalidTenKH";
        List<HopDong> result = hopDongRepository.searchByTenKH(tenKH);

        assertNotNull(result);
    }
// oke 
    @Test
    public void testSearchByTenKHWithNullTenKH() {
        List<HopDong> result = hopDongRepository.searchByTenKH(null);

        assertNotNull(result);
    }
// oke 
    @Test
    public void testSearchHDConHan() {
        List<HopDong> result = hopDongRepository.searchHDConHan();

        assertNotNull(result);
    }
// oke 
    @Test
    public void testSearchHDHetHan() {
        List<HopDong> result = hopDongRepository.searchHDHetHan();

        assertNotNull(result);
    }
// oke 
    @Test
    public void testSearchHDSapHetHan() {
        List<HopDong> result = hopDongRepository.searchHDSapHetHan();

        assertNotNull(result);
    }
// lỗi 
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
// oke 
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
// oke 
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
// oke 
    @Test
    public void testGetListHDTSByIdHD() {
        List<HopDongTaiSan> result = hopDongRepository.getListHDTSByIdHD(testHopDong.getId());

        assertNotNull(result);
    }
// oke 
    @Test
    public void testGetListHDTSByInvalidIdHD() {
        String invalidId = UUID.randomUUID().toString();
        String invalidHopDongId = invalidId;

        List<HopDongTaiSan> result = hopDongRepository.getListHDTSByIdHD(invalidHopDongId);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
// lỗi 
    @Test
    public void testGetTSByIdTS() {
        String taiSanId = "6636BC53-ACC3-4C69-9C78-4E555C9A6D0F";
        String result = hopDongRepository.getTSByIdTS(taiSanId);

        assertNotNull(result);
    }
// lỗi   
    @Test
    public void testGetTSByInvalidIdTS() {
        String invalidId = UUID.randomUUID().toString();
        String invalidTaiSanId = invalidId;

        String result = hopDongRepository.getTSByIdTS(invalidTaiSanId);

        assertNull(result);

    }
// lỗi 
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
// oke  
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
// oke 
    @Test
    public void testAddKHWithNullId() {
        KhachHang khachHang = new KhachHang();
        // Không thiết lập id

        boolean result = hopDongRepository.addKH(khachHang);

        assertFalse(result);
    }
// oke 
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
    // moiws
    
    @Test
    public void testAddKHhWithEmptyMa() {
        KhachHang khachHang = new KhachHang();
        khachHang.setId("2");
        khachHang.setMa(""); // Ma dể rỗng
        khachHang.setTen("Nguyen Truc Nhan ");
        khachHang.setCccd("012345789");
        khachHang.setNgSinh(new Date());
        khachHang.setEmail("nguyentrucn@example.com");
        khachHang.setSdt("0395789474");
        khachHang.setGioiTinh(false);
        khachHang.setDiaChi("09 Main Street");
        // Nhap các thuộc tính khác cho KhachHang

        boolean result = hopDongRepository.addKH(khachHang);

        assertFalse(result);
    }
    
     @Test
    public void testGetTSSByIdTS() {
        String taiSanId = "5636BC53-ACC3-4C9-9C78-6E55C9A6D0F";
        String result = hopDongRepository.getTSByIdTS(taiSanId);

        assertNotNull(result);
    }
    
     @Test
    public void testSearchByTenKHlWithInvalidTenKH() {
        String tenKH = "TenKHl";
        List<HopDong> result = hopDongRepository.searchByTenKH(tenKH);

        assertNotNull(result);
    }
     @Test
    public void testGetIdKHBySDTkhac() {
        String sdt = "0347068376";

        String idKH = hopDongRepository.getIdKHBySDT(sdt);

        assertNotNull(idKH);
    }
    
     @Test
    public void testAddKH02() {
        String invalidId = UUID.randomUUID().toString();
        
        KhachHang khachHang = new KhachHang();
        khachHang.setId(invalidId);
        khachHang.setMa("KH02");
        khachHang.setTen("Vu Minh Dai");
        khachHang.setCccd("097847878");
        khachHang.setNgSinh(new Date());
        khachHang.setEmail("vuminhdai@example.com");
        khachHang.setSdt("0123478949");
        khachHang.setGioiTinh(true);
        khachHang.setDiaChi("03 Main Street");
        // Nhap các thuộc tính khác cho KhachHang

        boolean result = hopDongRepository.addKH(khachHang);

        assertTrue(result);
    }
    @Test
    public void testSearchByTenKHNhan() {
        String tenKH = "Nhan";
        List<HopDong> result = hopDongRepository.searchByTenKH(tenKH);

        assertNotNull(result);
    }
     @Test
    public void testGetTen2PTById() {
        String idPhongTro = "Sof304";
        String tenPT = hopDongRepository.getTenPTById(idPhongTro);

        assertNotNull(tenPT);
    }
    
    @Test
    public void testGetPTByIdphong() {
        String idPhongTro = "PH01";
        PhongTro pt = hopDongRepository.getPTById(idPhongTro);

        assertNotNull(pt);
    }
    @Test
    public void testSearchByTenKHTrung() {
        String tenKH = "Trung";
        List<HopDong> result = hopDongRepository.searchByTenKH(tenKH);

        assertNotNull(result);
    }
    @Test
    public void testAddSWithNullData() {

        HopDongTaiSan hdts = new HopDongTaiSan();
        hdts.setId("009");
        hdts.setIdHD(testHopDong.getId());
        hdts.setIdTS(null);
        hdts.setSoLuong(04);
        // Set other necessary attributes for HopDongTaiSan

        boolean result = hopDongRepository.addHDTS(hdts);

        assertFalse(result);
        // Add assertions for the expected behavior when adding HDTS with null data
    }
}
