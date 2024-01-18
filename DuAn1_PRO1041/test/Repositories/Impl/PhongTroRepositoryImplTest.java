/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Repositories.Impl;

import DomainModel.PhongTro;
import Repositories.IPhongTroRepository;
import java.util.List;
import java.util.UUID;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author quach
 */
public class PhongTroRepositoryImplTest {
    
    private IPhongTroRepository phongTroRepository;
    
    private String testId;
    private String testMaPhong;
    private String testTenPhong;
    private String testSoTang;
    private boolean testTrangThai;
    private String testMoTa;
    private String testIdLoaiPhong;
    private String testTenLoaiPhong;
    
    public PhongTroRepositoryImplTest() {
    }

    @Before
    public void setUp() {
        phongTroRepository = new PhongTroRepositoryImpl();
        
        testId = "14D7B03C-D0E5-4BC7-A0E3-2E64BF9445FC";
        testMaPhong = "Hahaha";
        testTenPhong = "test_ten_phong";
        testSoTang = "1";
        testTrangThai = true;
        testMoTa = "test_mo_ta";
        testIdLoaiPhong = "0F720C7C-AA80-46C0-9E33-56B44AA8F4C4";
        testTenLoaiPhong = "test_ten_loai_phong";
    }
    
    @Test
    public void testGetAllNotEmpty() {
        //Kiểm tra danh sách cho trống hay không
        List<PhongTro> listPhongTro = phongTroRepository.getAll();
        assertNotNull(listPhongTro);
        assertFalse(listPhongTro.isEmpty());
    }
    
    @Test
    public void testGetAllContainsData() {
        List<PhongTro> listPhongTro = phongTroRepository.getAll();
        assertNotNull(listPhongTro);

        // Kiểm tra xem danh sách có chứa dữ liệu hợp lệ hay không (không được null)
        for (PhongTro phongTro : listPhongTro) {
            assertNotNull(phongTro.getId());
            assertNotNull(phongTro.getMa());
            assertNotNull(phongTro.getTen());
            assertNotNull(phongTro.getTang());
            assertNotNull(phongTro.getMoTa());
            assertNotNull(phongTro.getIdLoaiPhong());
        }
    }
    
    @Test
    public void testGetAllUniqueIds() {
        List<PhongTro> listPhongTro = phongTroRepository.getAll();
        assertNotNull(listPhongTro);

        // Kiểm tra xem các ID trong danh sách có là duy nhất hay không
        for (int i = 0; i < listPhongTro.size(); i++) {
            for (int j = i + 1; j < listPhongTro.size(); j++) {
                assertNotEquals(listPhongTro.get(i).getId(), listPhongTro.get(j).getId());
            }
        }
    }

    @Test
    public void testGetListMa() {
        List<String> listMa = phongTroRepository.getListMa();
        assertNotNull(listMa);
        assertFalse(listMa.isEmpty());
    }

    @Test
    public void testGetListTen() {
        List<String> listTen = phongTroRepository.getListTen();
        assertNotNull(listTen);
        assertFalse(listTen.isEmpty());
    }

    @Test
    public void testGetListTTLoaiPhong() {
        List<String> listTTLoaiPhong = phongTroRepository.getListTTLoaiPhong();
        assertNotNull(listTTLoaiPhong);
        assertFalse(listTTLoaiPhong.isEmpty());
    }

    @Test
    public void testGetIdByTTLoaiPhong() {
        String ttlp = "Nhỏ (14m2) (LP1)";
        String id = phongTroRepository.getIdByTTLoaiPhong(ttlp);
        assertNotNull(id);
    }

    @Test
    public void testGetTTLoaiPhongById() {
        
        String id = "0F720C7C-AA80-46C0-9E33-56B44AA8F4C4";
        String ttLoaiPhong = phongTroRepository.getTTLoaiPhongById(id);
        assertNotNull(ttLoaiPhong);
    }

    @Test
    public void testAddValidPhongTro() {
        // Tạo một đối tượng PhongTro hợp lệ để thêm vào cơ sở dữ liệu
        UUID id = UUID.randomUUID();
        PhongTro newPhongTro = new PhongTro(String.valueOf(id), "P002", "Phòng 1", "1", true, "Mô tả phòng", "0F720C7C-AA80-46C0-9E33-56B44AA8F4C4", "89E29416-0DF3-42FD-8556-78EC4C3FDEBE");

        // Thêm phòng trọ vào cơ sở dữ liệu
        boolean result = phongTroRepository.add(newPhongTro);

        // Kiểm tra xem việc thêm có thành công hay không
        assertTrue(result);
    }

    @Test
    public void testAddDuplicatePhongTro() {
        // Tạo một đối tượng PhongTro đã tồn tại trong cơ sở dữ liệu
        String idExist = "14D7B03C-D0E5-4BC7-A0E3-2E64BF9445FC";
        PhongTro existingPhongTro = new PhongTro(idExist, "P001", "Phòng 1", "Tầng 1", true, "Mô tả phòng", "LP001", "KH001");

        // Thêm phòng trọ có ID trùng vào cơ sở dữ liệu
        boolean result = phongTroRepository.add(existingPhongTro);

        // Kiểm tra xem việc thêm có thành công hay không (nên thất bại vì ID đã tồn tại)
        assertFalse(result);
    }

    @Test
    public void testUpdate() {
        UUID id = UUID.randomUUID();
        testId = String.valueOf(id);
        testMaPhong = "hehe";
        PhongTro testPhongTro = new PhongTro(testId, testMaPhong, testTenPhong, testSoTang, testTrangThai, testMoTa, testIdLoaiPhong);
        assertTrue(phongTroRepository.add(testPhongTro));

        // Thực hiện các thay đổi trên đối tượng đã thêm
        testPhongTro.setMa("P203");
        testPhongTro.setTen("updated_ten_phong");
        testPhongTro.setTang("2");
        testPhongTro.setTrangThai(false);
        testPhongTro.setMoTa("updated_mo_ta");
        testPhongTro.setIdLoaiPhong("0F720C7C-AA80-46C0-9E33-56B44AA8F4C4");

        assertTrue(phongTroRepository.update(testPhongTro, testId));
        assertTrue(phongTroRepository.delete(testId)); // Xóa dữ liệu test sau khi hoàn thành
    }

    @Test
    public void testDelete() {
        UUID id = UUID.randomUUID();
        testId = String.valueOf(id);
        PhongTro testPhongTro = new PhongTro(testId, testMaPhong, testTenPhong, testSoTang, testTrangThai, testMoTa, testIdLoaiPhong);
        assertTrue(phongTroRepository.add(testPhongTro));
        assertTrue(phongTroRepository.delete(testId));
    }

    @Test
    public void testTimKiem() {
        assertNotNull(phongTroRepository.TimKiem(testTenPhong));
    }

    @Test
    public void testGetListDSD() {
        assertNotNull(phongTroRepository.getListDSD());
    }
    
}
