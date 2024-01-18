/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package DomainModel;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author quach
 */
public class DichVuTest {
    
    private DichVu dichVu;
    
    public DichVuTest() {
    }

    @Before
    public void setUp() {
        dichVu = new DichVu("1", "DV001", "Dịch Vụ 1", 100.0, true, "HD001");
        // Các thiết lập khác có thể được thêm vào đây nếu cần thiết
    }

    @Test
    public void testConstructorWithAllParameters() {
        assertEquals("1", dichVu.getId());
        assertEquals("DV001", dichVu.getMa());
        assertEquals("Dịch Vụ 1", dichVu.getTen());
        assertEquals(100.0, dichVu.getGia(), 0.001); // Đối với các giá trị số dấu chấm động, sử dụng delta
        assertTrue(dichVu.isTrangThai());
        assertEquals("HD001", dichVu.getIdHD());
    }

    @Test
    public void testConstructorWithOptionalParameters() {
        DichVu dichVuOptional = new DichVu("2", "DV002", "Dịch Vụ 2", 150.0, false);
        assertEquals("2", dichVuOptional.getId());
        assertEquals("DV002", dichVuOptional.getMa());
        assertEquals("Dịch Vụ 2", dichVuOptional.getTen());
        assertEquals(150.0, dichVuOptional.getGia(), 0.001);
        assertFalse(dichVuOptional.isTrangThai());
        assertNull(dichVuOptional.getIdHD()); // Chắc chắn rằng optional parameter đã được đặt mặc định
    }

    @Test
    public void testToDataRow() {
        Object[] expectedRow = {"DV001", "Dịch Vụ 1", 100.0, "Hoạt động"};
        assertArrayEquals(expectedRow, dichVu.toDataRow());
    }

    // Thêm các phương thức kiểm thử khác nếu cần

}
