/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Repositories.Impl;

import DomainModel.LoaiPhong;
import Repositories.ILoaiPhongRepository;
import java.util.List;
import java.util.UUID;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author quach
 */
public class LoaiPhongRepositoryImplTest {
    
    private ILoaiPhongRepository loaiPhongRepository;
    
    @Before
    public void setUp() {
        loaiPhongRepository = new LoaiPhongRepositoryImpl();
    }
    
    public LoaiPhongRepositoryImplTest() {
    }

    @Test
    public void testGetAll() {
        List<LoaiPhong> loaiPhongs = loaiPhongRepository.getAll();

        assertNotNull(loaiPhongs);
//        assertFalse(loaiPhongs.isEmpty());
    }

    @Test
    public void testGetListMa() {
        List<String> listMa = loaiPhongRepository.getListMa();

        assertNotNull(listMa);
        assertFalse(listMa.isEmpty());
    }

    @Test
    public void testGetListTen() {
        List<String> listTen = loaiPhongRepository.getListTen();

        assertNotNull(listTen);
        assertFalse(listTen.isEmpty());
    }

    @Test
    public void testAdd() {
        UUID id = UUID.randomUUID();
        LoaiPhong newLoaiPhong = new LoaiPhong(String.valueOf(id).toUpperCase(), "hahah11", "TestTen", 25.0f, 100.0);

        // Thực hiện thêm đối tượng LoaiPhong vào cơ sở dữ liệu
        boolean result = loaiPhongRepository.add(newLoaiPhong);

        assertTrue(result); // Kiểm tra xem thêm có thành công hay không

        // Kiểm tra xem đối tượng LoaiPhong đã được thêm vào cơ sở dữ liệu chưa
        LoaiPhong retrievedLoaiPhong = loaiPhongRepository.getAll()
                .stream()
                .filter(lp -> lp.getId().equals(newLoaiPhong.getId()))
                .findFirst()
                .orElse(null);

        assertNotNull(retrievedLoaiPhong);
        assertEquals("hahah11", retrievedLoaiPhong.getMa());
        assertEquals("TestTen", retrievedLoaiPhong.getTen());
        assertEquals(25.0f, retrievedLoaiPhong.getDienTich(), 0.01);
        assertEquals(100.0, retrievedLoaiPhong.getGia(), 0.01);
        
        assertTrue(loaiPhongRepository.delete(newLoaiPhong.getId()));
    }

    @Test
    public void testUpdate() {
        UUID id = UUID.randomUUID();
        String idTest = String.valueOf(id).toUpperCase();
        LoaiPhong newLoaiPhong = new LoaiPhong(idTest, "Ma011", "TestTen", 25.0f, 100.0);
        assertTrue(loaiPhongRepository.add(newLoaiPhong));

        // Tạo một đối tượng LoaiPhong mới để cập nhật thông tin
        LoaiPhong updatedLoaiPhong = new LoaiPhong(idTest, "UpdatedMa1", "UpdatedTen", 30.0f, 120.0);

        // Thực hiện cập nhật đối tượng LoaiPhong trong cơ sở dữ liệu
        boolean result = loaiPhongRepository.update(updatedLoaiPhong, idTest);

        assertTrue(result); // Kiểm tra xem cập nhật có thành công hay không

        // Kiểm tra xem đối tượng LoaiPhong đã được cập nhật đúng thông tin chưa
        LoaiPhong retrievedLoaiPhong = loaiPhongRepository.getAll()
                .stream()
                .filter(lp -> lp.getId().equals(updatedLoaiPhong.getId()))
                .findFirst()
                .orElse(null);

        assertNotNull(retrievedLoaiPhong);
        assertEquals("UpdatedMa1", retrievedLoaiPhong.getMa());
        assertEquals("UpdatedTen", retrievedLoaiPhong.getTen());
        assertEquals(30.0f, retrievedLoaiPhong.getDienTich(), 0.01);
        assertEquals(120.0, retrievedLoaiPhong.getGia(), 0.01);
        
        assertTrue(loaiPhongRepository.delete(idTest));
    }

    @Test
    public void testDelete() {
        UUID id = UUID.randomUUID();
        String idTest = String.valueOf(id).toUpperCase();
        LoaiPhong loaiPhongToDelete = new LoaiPhong(idTest, "Ma011", "TestTen", 25.0f, 100.0);
        assertTrue(loaiPhongRepository.add(loaiPhongToDelete));
        
        boolean result = loaiPhongRepository.delete(idTest);
        
        assertTrue(result);
        
        LoaiPhong deletedLoaiPhong = loaiPhongRepository.getAll()
                .stream()
                .filter(lp -> lp.getId().equals(loaiPhongToDelete.getId()))
                .findFirst()
                .orElse(null);

        assertNull(deletedLoaiPhong);
    }

    @Test
    public void testTimKiem() {
        UUID id = UUID.randomUUID();
        LoaiPhong newLoaiPhong = new LoaiPhong(String.valueOf(id).toUpperCase(), "TestMa10", "TestTen11", 25.0f, 100.0);

        assertTrue(loaiPhongRepository.add(newLoaiPhong)); // Kiểm tra xem thêm có thành công hay không
        
        List<LoaiPhong> result = loaiPhongRepository.TimKiem("TestTen11");
        
        assertTrue(result.size() > 0);
        assertTrue(result.stream().anyMatch(lp -> lp.getId().equals(newLoaiPhong.getId())));
        
        assertTrue(loaiPhongRepository.delete(newLoaiPhong.getId()));
    }
    
}
