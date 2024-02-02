/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Repositories.Impl;

import DomainModel.LoaiPhong;
import Repositories.ILoaiPhongRepository;
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
 * @author nhatc
 */
public class LoaiPhongRepositoryImplTest {

    private ILoaiPhongRepository lpRepository;

    public LoaiPhongRepositoryImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        lpRepository = new LoaiPhongRepositoryImpl();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addTestFullInput() {
        UUID id = UUID.randomUUID();
        String testId = String.valueOf(id).toUpperCase();
        LoaiPhong lp = new LoaiPhong(testId, "PH23737", "vip", 200, 1000000);

        // add object to db & check
        boolean result = lpRepository.add(lp);
        assertTrue(result);

        if (result) {
            System.out.println("Them thanh cong");
            // re-check 1: table isn't null
            assertNotNull(lpRepository.getAll());
            // re-check 2: added information is correct
            assertEquals(testId, lpRepository.getAll().get(0).getId());
            assertEquals("PH23737", lpRepository.getAll().get(0).getMa());
            assertEquals("vip", lpRepository.getAll().get(0).getTen());
            assertEquals(200, lpRepository.getAll().get(0).getDienTich(), 0.0);
            assertEquals(1000000, lpRepository.getAll().get(0).getGia(), 0.0);
            // clean-up: remove object for another test
            boolean delete = lpRepository.delete(testId);
            assertTrue(delete);
        }
    }

    @Test
    public void addTestMaTrong() {
        UUID id = UUID.randomUUID();
        String testId = String.valueOf(id).toUpperCase();
        LoaiPhong lp = new LoaiPhong(testId, "", "vip", 200, 1000000);

        // add object to db & check
        boolean result = lpRepository.add(lp);
        if (result) {
            System.out.println("Them thanh cong?");
            boolean delete = lpRepository.delete(testId);
            assertTrue(delete);
        }
        assertFalse(result);
    }

    @Test
    public void addTestMaSaiDinhDang() {
        UUID id = UUID.randomUUID();
        String testId = String.valueOf(id).toUpperCase();
        LoaiPhong lp = new LoaiPhong(testId, "@#!", "vip", 200, 1000000);

        // add object to db & check
        boolean result = lpRepository.add(lp);
        if (result) {
            System.out.println("Them thanh cong?");
            boolean delete = lpRepository.delete(testId);
            assertTrue(delete);
        }
        assertFalse(result);
    }

    @Test
    public void addTestTenPhongTrong() {
        UUID id = UUID.randomUUID();
        String testId = String.valueOf(id).toUpperCase();
        LoaiPhong lp = new LoaiPhong(testId, "PH23737", "", 200, 1000000);

        // add object to db & check
        boolean result = lpRepository.add(lp);
        if (result) {
            System.out.println("Them thanh cong?");
            boolean delete = lpRepository.delete(testId);
            assertTrue(delete);
        }
        assertFalse(result);
    }

    @Test
    public void addTestTenPhongChuaKTDB() {
        UUID id = UUID.randomUUID();
        String testId = String.valueOf(id).toUpperCase();
        LoaiPhong lp = new LoaiPhong(testId, "PH23737", "v_!_p", 200, 1000000);

        // add object to db & check
        boolean result = lpRepository.add(lp);
        assertTrue(result);

        if (result) {
            System.out.println("Them thanh cong");
            // re-check 1: table isn't null
            assertNotNull(lpRepository.getAll());
            // re-check 2: added information is correct
            assertEquals(testId, lpRepository.getAll().get(0).getId());
            assertEquals("PH23737", lpRepository.getAll().get(0).getMa());
            assertEquals("v_!_p", lpRepository.getAll().get(0).getTen());
            assertEquals(200, lpRepository.getAll().get(0).getDienTich(), 0.0);
            assertEquals(1000000, lpRepository.getAll().get(0).getGia(), 0.0);
            // clean-up: remove object for another test
            boolean delete = lpRepository.delete(testId);
            assertTrue(delete);
        }
    }

    @Test
    public void addTestDienTichAm() {
        UUID id = UUID.randomUUID();
        String testId = String.valueOf(id).toUpperCase();
        LoaiPhong lp = new LoaiPhong(testId, "PH23737", "vip", -1, 1000000);

        // add object to db & check
        boolean result = lpRepository.add(lp);
        if (result) {
            System.out.println("Them thanh cong?");
            boolean delete = lpRepository.delete(testId);
            assertTrue(delete);
        }
        assertFalse(result);
    }

    @Test
    public void addTestDienTich0() {
        UUID id = UUID.randomUUID();
        String testId = String.valueOf(id).toUpperCase();
        LoaiPhong lp = new LoaiPhong(testId, "PH23737", "vip", 0, 1000000);

        // add object to db & check
        boolean result = lpRepository.add(lp);
        if (result) {
            System.out.println("Them thanh cong?");
            boolean delete = lpRepository.delete(testId);
            assertTrue(delete);
        }
        assertFalse(result);
    }

    @Test
    public void addTestDienTichChu() {
        UUID id = UUID.randomUUID();
        String testId = String.valueOf(id).toUpperCase();
        LoaiPhong lp = new LoaiPhong(testId, "PH23737", "vip", Float.valueOf("2tram"), 1000000);

        // add object to db & check
        boolean result = lpRepository.add(lp);
        if (result) {
            System.out.println("Them thanh cong?");
            boolean delete = lpRepository.delete(testId);
            assertTrue(delete);
        }
        assertFalse(result);
    }

    @Test
    public void addTestGiaChu() {
        UUID id = UUID.randomUUID();
        String testId = String.valueOf(id).toUpperCase();
        LoaiPhong lp = new LoaiPhong(testId, "PH23737", "vip", 200, Float.valueOf("1tr"));

        // add object to db & check
        boolean result = lpRepository.add(lp);
        if (result) {
            System.out.println("Them thanh cong?");
            boolean delete = lpRepository.delete(testId);
            assertTrue(delete);
        }
        assertFalse(result);
    }

    @Test
    public void addTestGia0() {
        UUID id = UUID.randomUUID();
        String testId = String.valueOf(id).toUpperCase();
        LoaiPhong lp = new LoaiPhong(testId, "PH23737", "vip", 200, 0);

        // add object to db & check
        boolean result = lpRepository.add(lp);
        if (result) {
            System.out.println("Them thanh cong?");
            boolean delete = lpRepository.delete(testId);
            assertTrue(delete);
        }
        assertFalse(result);
    }

    @Test
    public void addTestGiaAm() {
        UUID id = UUID.randomUUID();
        String testId = String.valueOf(id).toUpperCase();
        LoaiPhong lp = new LoaiPhong(testId, "PH23737", "vip", 200, -500000);

        // add object to db & check
        boolean result = lpRepository.add(lp);
        if (result) {
            System.out.println("Them thanh cong?");
            boolean delete = lpRepository.delete(testId);
            assertTrue(delete);
        }
        assertFalse(result);
    }

    @Test
    public void updateTestFullChange() {
        // add new
        UUID id = UUID.randomUUID();
        String testId = String.valueOf(id).toUpperCase();
        LoaiPhong lp = new LoaiPhong(testId, "PH23737", "vip", 200, 1000000);
        assertTrue(lpRepository.add(lp));

        // update info
        LoaiPhong newLP = new LoaiPhong(testId, "PH20252", "p2", 150, 1000001);
        boolean result = lpRepository.update(newLP, testId);
        assertTrue(result);

        if (result) {
            System.out.println("Cap nhat thanh cong");
            // re-check: updated information is correct
            assertEquals(testId, lpRepository.getAll().get(0).getId());
            assertEquals("PH20252", lpRepository.getAll().get(0).getMa());
            assertEquals("p2", lpRepository.getAll().get(0).getTen());
            assertEquals(150, lpRepository.getAll().get(0).getDienTich(), 0.0);
            assertEquals(1000001, lpRepository.getAll().get(0).getGia(), 0.0);
            // clean-up: remove object for another test
            boolean delete = lpRepository.delete(testId);
            assertTrue(delete);
        }
    }

    @Test
    public void updateTestMaTrong() {
        // add new
        UUID id = UUID.randomUUID();
        String testId = String.valueOf(id).toUpperCase();
        LoaiPhong lp = new LoaiPhong(testId, "PH23737", "vip", 200, 1000000);
        assertTrue(lpRepository.add(lp));

        // update info
        LoaiPhong newLP = new LoaiPhong(testId, "", "vip", 200, 1000000);
        boolean result = lpRepository.update(newLP, testId);
        if (result) {
            System.out.println("Cap nhat thanh cong?");
            boolean delete = lpRepository.delete(testId);
            assertTrue(delete);
        }
        assertFalse(result);
    }

    @Test
    public void updateTestMaSaiDinhDang() {
        // add new
        UUID id = UUID.randomUUID();
        String testId = String.valueOf(id).toUpperCase();
        LoaiPhong lp = new LoaiPhong(testId, "PH23737", "vip", 200, 1000000);
        assertTrue(lpRepository.add(lp));

        // update info
        LoaiPhong newLP = new LoaiPhong(testId, "@=1", "vip", 200, 1000000);
        boolean result = lpRepository.update(newLP, testId);
        if (result) {
            System.out.println("Cap nhat thanh cong?");
            boolean delete = lpRepository.delete(testId);
            assertTrue(delete);
        }
        assertFalse(result);
    }

    @Test
    public void updateTestTenPhongTrong() {
        // add new
        UUID id = UUID.randomUUID();
        String testId = String.valueOf(id).toUpperCase();
        LoaiPhong lp = new LoaiPhong(testId, "PH23737", "vip", 200, 1000000);
        assertTrue(lpRepository.add(lp));

        // update info
        LoaiPhong newLP = new LoaiPhong(testId, "PH23737", "", 200, 1000000);
        boolean result = lpRepository.update(newLP, testId);
        if (result) {
            System.out.println("Cap nhat thanh cong?");
            boolean delete = lpRepository.delete(testId);
            assertTrue(delete);
        }
        assertFalse(result);
    }

    @Test
    public void updateTestTenPhongThemKTDB() {
        // add new
        UUID id = UUID.randomUUID();
        String testId = String.valueOf(id).toUpperCase();
        LoaiPhong lp = new LoaiPhong(testId, "PH23737", "vip", 200, 1000000);
        assertTrue(lpRepository.add(lp));

        // update info
        LoaiPhong newLP = new LoaiPhong(testId, "PH23737", "vip$", 200, 1000000);
        boolean result = lpRepository.update(newLP, testId);
        if (result) {
            System.out.println("Cap nhat thanh cong?");
            boolean delete = lpRepository.delete(testId);
            assertTrue(delete);
        }
        assertFalse(result);
    }

    @Test
    public void updateTestDienTichAm() {
        // add new
        UUID id = UUID.randomUUID();
        String testId = String.valueOf(id).toUpperCase();
        LoaiPhong lp = new LoaiPhong(testId, "PH23737", "vip", 200, 1000000);
        assertTrue(lpRepository.add(lp));

        // update info
        LoaiPhong newLP = new LoaiPhong(testId, "PH23737", "vip", -150, 1000000);
        boolean result = lpRepository.update(newLP, testId);
        if (result) {
            System.out.println("Cap nhat thanh cong?");
            boolean delete = lpRepository.delete(testId);
            assertTrue(delete);
        }
        assertFalse(result);
    }

    @Test
    public void updateTestDienTich0() {
        // add new
        UUID id = UUID.randomUUID();
        String testId = String.valueOf(id).toUpperCase();
        LoaiPhong lp = new LoaiPhong(testId, "PH23737", "vip", 200, 1000000);
        assertTrue(lpRepository.add(lp));

        // update info
        LoaiPhong newLP = new LoaiPhong(testId, "PH23737", "vip", 0, 1000000);
        boolean result = lpRepository.update(newLP, testId);
        if (result) {
            System.out.println("Cap nhat thanh cong?");
            boolean delete = lpRepository.delete(testId);
            assertTrue(delete);
        }
        assertFalse(result);
    }

    @Test
    public void updateTestDienTichChu() {
        // add new
        UUID id = UUID.randomUUID();
        String testId = String.valueOf(id).toUpperCase();
        LoaiPhong lp = new LoaiPhong(testId, "PH23737", "vip", 200, 1000000);
        assertTrue(lpRepository.add(lp));

        // update info
        LoaiPhong newLP = new LoaiPhong(testId, "PH23737", "vip", Float.valueOf("2tram"), 1000000);
        boolean result = lpRepository.update(newLP, testId);
        if (result) {
            System.out.println("Cap nhat thanh cong?");
            boolean delete = lpRepository.delete(testId);
            assertTrue(delete);
        }
        assertFalse(result);
    }

    @Test
    public void updateTestGiaChu() {
        // add new
        UUID id = UUID.randomUUID();
        String testId = String.valueOf(id).toUpperCase();
        LoaiPhong lp = new LoaiPhong(testId, "PH23737", "vip", 200, 1000000);
        assertTrue(lpRepository.add(lp));

        // update info
        LoaiPhong newLP = new LoaiPhong(testId, "PH23737", "vip", 200, Float.valueOf("1trieu"));
        boolean result = lpRepository.update(newLP, testId);
        if (result) {
            System.out.println("Cap nhat thanh cong?");
            boolean delete = lpRepository.delete(testId);
            assertTrue(delete);
        }
        assertFalse(result);
    }

    @Test
    public void updateTestGia0() {
        // add new
        UUID id = UUID.randomUUID();
        String testId = String.valueOf(id).toUpperCase();
        LoaiPhong lp = new LoaiPhong(testId, "PH23737", "vip", 200, 1000000);
        assertTrue(lpRepository.add(lp));

        // update info
        LoaiPhong newLP = new LoaiPhong(testId, "PH23737", "vip", 200, 0);
        boolean result = lpRepository.update(newLP, testId);
        if (result) {
            System.out.println("Cap nhat thanh cong?");
            boolean delete = lpRepository.delete(testId);
            assertTrue(delete);
        }
        assertFalse(result);
    }

    @Test
    public void updateTestGiaAm() {
        // add new
        UUID id = UUID.randomUUID();
        String testId = String.valueOf(id).toUpperCase();
        LoaiPhong lp = new LoaiPhong(testId, "PH23737", "vip", 200, 1000000);
        assertTrue(lpRepository.add(lp));

        // update info
        LoaiPhong newLP = new LoaiPhong(testId, "PH23737", "vip", 200, -1000000);
        boolean result = lpRepository.update(newLP, testId);
        if (result) {
            System.out.println("Cap nhat thanh cong?");
            boolean delete = lpRepository.delete(testId);
            assertTrue(delete);
        }
        assertFalse(result);
    }

    @Test
    public void deleteTest() {
        UUID id = UUID.randomUUID();
        String testId = String.valueOf(id).toUpperCase();
        LoaiPhong lp = new LoaiPhong(testId, "PH23737", "vip", 200, 99999);

        // add object to db & check
        boolean result = lpRepository.add(lp);
        assertTrue(result);

        // delete object from db & check
        boolean delete = lpRepository.delete(testId);
        assertTrue(delete);
    }
}
