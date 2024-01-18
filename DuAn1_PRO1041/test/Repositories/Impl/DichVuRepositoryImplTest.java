/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Repositories.Impl;

import DomainModel.DichVu;
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
public class DichVuRepositoryImplTest {
    
    public DichVuRepositoryImplTest() {
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
     * Test of getAll method, of class DichVuRepositoryImpl.
     */
 @Test
    public void testGetAll_Dung() {
        // Trường hợp: Lấy danh sách dịch vụ thành công
        
        // Arrange
        DichVuRepositoryImpl instance = new DichVuRepositoryImpl();
        
        // Act
        List<DichVu> result = instance.getAll();
        
        // Assert
        assertNotNull("Danh sách dịch vụ không được là null", result);
        assertFalse("Danh sách dịch vụ không được trống", result.isEmpty());
    }

    @Test
    public void testGetAll_DeTrong() {
        // Trường hợp: Lấy danh sách dịch vụ với danh sách rỗng
        
        // Arrange
        // Giả sử có điều kiện nào đó làm cho việc lấy danh sách dịch vụ trả về rỗng
        DichVuRepositoryImpl instance = new DichVuRepositoryImpl() {
          
            public List<DichVu> layDanhSachDichVu() {
                // Giả sử danh sách rỗng
                return List.of();
            }
        };
        
        // Act
        List<DichVu> result = instance.getAll();
        
        // Assert
        assertNotNull("Danh sách dịch vụ không được là null", result);
        assertTrue("Danh sách dịch vụ phải là rỗng", result.isEmpty());
    }

    @Test
    public void testGetAll_Sai() {
        // Trường hợp: Lấy danh sách dịch vụ không thành công vì lý do nào đó
        
        // Arrange
        // Giả sử có điều kiện nào đó làm cho việc lấy danh sách dịch vụ không thành công
        DichVuRepositoryImpl instance = new DichVuRepositoryImpl() {
        
            public List<DichVu> layDanhSachDichVu() {
                // Giả sử danh sách là null
                return null;
            }
        };
        
        // Act
        List<DichVu> result = instance.getAll();
        
        // Assert
        assertNull("Danh sách dịch vụ phải là null", result);
    }

    /**
     * Test of getListMa method, of class DichVuRepositoryImpl.
     */
    @Test
    public void testGetListMa_Dung() {
        // Trường hợp: Lấy danh sách mã dịch vụ thành công
        
        // Arrange
        DichVuRepositoryImpl instance = new DichVuRepositoryImpl();
        
        // Act
        List<String> result = instance.getListMa();
        
        // Assert
        assertNotNull("Danh sách mã dịch vụ không được là null", result);
        assertFalse("Danh sách mã dịch vụ không được trống", result.isEmpty());
    }

    @Test
    public void testGetListMa_DeTrong() {
        // Trường hợp: Lấy danh sách mã dịch vụ với danh sách rỗng
        
        // Arrange
        // Giả sử có điều kiện nào đó làm cho việc lấy danh sách mã dịch vụ trả về rỗng
        DichVuRepositoryImpl instance = new DichVuRepositoryImpl() {
         
            public List<String> layDanhSachMa() {
                // Giả sử danh sách rỗng
                return List.of();
            }
        };
        
        // Act
        List<String> result = instance.getListMa();
        
        // Assert
        assertNotNull("Danh sách mã dịch vụ không được là null", result);
        assertTrue("Danh sách mã dịch vụ phải là rỗng", result.isEmpty());
    }

    @Test
    public void testGetListMa_Sai() {
        // Trường hợp: Lấy danh sách mã dịch vụ không thành công vì lý do nào đó
        
        // Arrange
        // Giả sử có điều kiện nào đó làm cho việc lấy danh sách mã dịch vụ không thành công
        DichVuRepositoryImpl instance = new DichVuRepositoryImpl() {

            public List<String> layDanhSachMa() {
                // Giả sử danh sách là null
                return null;
            }
        };
        
        // Act
        List<String> result = instance.getListMa();
        
        // Assert
        assertNull("Danh sách mã dịch vụ phải là null", result);
    }

    /**
     * Test of add method, of class DichVuRepositoryImpl.
     */
   
    @Test
    public void testAdd_Dung() {
        // Trường hợp: Thêm dịch vụ thành công
        
        // Arrange
        DichVu dv = new DichVu(); // Tạo một đối tượng dịch vụ hợp lệ
        DichVuRepositoryImpl instance = new DichVuRepositoryImpl();
        
        // Act
        boolean result = instance.add(dv);
        
        // Assert
        assertTrue("Thêm dịch vụ không thành công", result);
    }

    @Test
    public void testAdd_DeTrong() {
        // Trường hợp: Thêm dịch vụ với đối tượng dịch vụ là null
        
        // Arrange
        DichVu dv = null; // Đối tượng dịch vụ là null
        DichVuRepositoryImpl instance = new DichVuRepositoryImpl();
        
        // Act
        boolean result = instance.add(dv);
        
        // Assert
        assertFalse("Thêm dịch vụ không thành công với đối tượng dịch vụ là null", result);
    }

    @Test
    public void testAdd_Sai() {
        // Trường hợp: Thêm dịch vụ không thành công vì lý do nào đó
        
        // Arrange
        DichVu dv = new DichVu(); // Tạo một đối tượng dịch vụ hợp lệ
        // Giả sử có điều kiện nào đó làm cho việc thêm dịch vụ không thành công
        DichVuRepositoryImpl instance = new DichVuRepositoryImpl() {
     
            public boolean kiemTraDieuKienThem(DichVu dichVu) {
                // Giả sử có điều kiện không thoả mãn
                return false;
            }
        };
        
        // Act
        boolean result = instance.add(dv);
        
        // Assert
        assertFalse("Thêm dịch vụ không thành công vì điều kiện không thoả mãn", result);
    }

    /**
     * Test of update method, of class DichVuRepositoryImpl.
     */
  @Test
    public void testUpdate_Dung() {
        // Trường hợp: Cập nhật dịch vụ thành công
        
        // Arrange
        DichVu dv = new DichVu(); // Tạo một đối tượng dịch vụ hợp lệ
        String id = "123"; // ID hợp lệ
        DichVuRepositoryImpl instance = new DichVuRepositoryImpl();
        
        // Act
        boolean result = instance.update(dv, id);
        
        // Assert
        assertTrue("Cập nhật dịch vụ không thành công", result);
    }

    @Test
    public void testUpdate_DeTrong() {
        // Trường hợp: Cập nhật dịch vụ với đối tượng dịch vụ hoặc ID là null
        
        // Arrange
        DichVu dv = null; // Đối tượng dịch vụ là null
        String id = ""; // ID là rỗng
        DichVuRepositoryImpl instance = new DichVuRepositoryImpl();
        
        // Act
        boolean result = instance.update(dv, id);
        
        // Assert
        assertFalse("Cập nhật dịch vụ không thành công với đối tượng dịch vụ hoặc ID là null", result);
    }

    @Test
    public void testUpdate_Sai() {
        // Trường hợp: Cập nhật dịch vụ không thành công vì lý do nào đó
        
        // Arrange
        DichVu dv = new DichVu(); // Tạo một đối tượng dịch vụ hợp lệ
        String id = "123"; // ID hợp lệ
        // Giả sử có điều kiện nào đó làm cho việc cập nhật dịch vụ không thành công
        DichVuRepositoryImpl instance = new DichVuRepositoryImpl() {
        
            public boolean kiemTraDieuKienCapNhat(DichVu dichVu, String id) {
                // Giả sử có điều kiện không thoả mãn
                return false;
            }
        };
        
        // Act
        boolean result = instance.update(dv, id);
        
        // Assert
        assertFalse("Cập nhật dịch vụ không thành công vì điều kiện không thoả mãn", result);
    }
    /**
     * Test of delete method, of class DichVuRepositoryImpl.
     */
       @Test
    public void testDelete_Dung() {
        // Trường hợp: Xóa dịch vụ thành công
        
        // Arrange
        String id = "123"; // ID hợp lệ
        DichVuRepositoryImpl instance = new DichVuRepositoryImpl();
        
        // Act
        boolean result = instance.delete(id);
        
        // Assert
        assertTrue("Xóa dịch vụ không thành công", result);
    }

    @Test
    public void testDelete_DeTrong() {
        // Trường hợp: Xóa dịch vụ với ID là null hoặc rỗng
        
        // Arrange
        String id = ""; // ID là rỗng
        DichVuRepositoryImpl instance = new DichVuRepositoryImpl();
        
        // Act
        boolean result = instance.delete(id);
        
        // Assert
        assertFalse("Xóa dịch vụ không thành công với ID là null hoặc rỗng", result);
    }

    @Test
    public void testDelete_Sai() {
        // Trường hợp: Xóa dịch vụ không thành công vì lý do nào đó
        
        // Arrange
        String id = "123"; // ID hợp lệ
        // Giả sử có điều kiện nào đó làm cho việc xóa dịch vụ không thành công
        DichVuRepositoryImpl instance = new DichVuRepositoryImpl() {
         
            public boolean kiemTraDieuKienXoa(String id) {
                // Giả sử có điều kiện không thoả mãn
                return false;
            }
        };
        
        // Act
        boolean result = instance.delete(id);
        
        // Assert
        assertFalse("Xóa dịch vụ không thành công vì điều kiện không thoả mãn", result);
    }
    
}
