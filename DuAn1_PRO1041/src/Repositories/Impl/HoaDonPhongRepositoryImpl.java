/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModel.HoaDonPhong;
import Repositories.IHoaDonPhongRepository;
import Utilities.DBConnect;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author PC ASUS
 */
public class HoaDonPhongRepositoryImpl implements IHoaDonPhongRepository {
    
    @Override
    public List<HoaDonPhong> getAll() {
        String query = """
                      SELECT [Id]
                            ,[Ma]
                            ,[Thang]
                            ,[NgayTao]
                            ,[TongTien]
                            ,[TrangThai]
                            ,[IDPhongTro]
                            ,[IDKhachHang]
                            ,[IDHopDong]
                        FROM [dbo].[Hoadon_phong]
                         ORDER BY [Ma]
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<HoaDonPhong> lists = new ArrayList<>();
            while (rs.next()) {
                HoaDonPhong hdp = new HoaDonPhong(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getDouble(5), rs.getBoolean(6), rs.getString(7), rs.getString(8), rs.getString(9));
                lists.add(hdp);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    @Override
    public List<HoaDonPhong> getListByTT(int tt) {
        String query = """
                      SELECT [Id]
                        ,[Ma]
                        ,[Thang]
                        ,[NgayTao]
                        ,[TongTien]
                        ,[TrangThai]
                        ,[IDPhongTro]
                        ,[IDKhachHang]
                        ,[IDHopDong]
                      FROM [dbo].[Hoadon_phong]
                      WHERE [TrangThai] = ?
                      ORDER BY [Ma]
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, tt);
            ResultSet rs = ps.executeQuery();
            List<HoaDonPhong> lists = new ArrayList<>();
            while (rs.next()) {
                HoaDonPhong hdp = new HoaDonPhong(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getDouble(5), rs.getBoolean(6), rs.getString(7), rs.getString(8), rs.getString(9));
                lists.add(hdp);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    @Override
    public List<HoaDonPhong> search(String tenPhong) {
        String query = """
                       SELECT dbo.Hoadon_phong.Id, dbo.Hoadon_phong.Ma, dbo.Hoadon_phong.Thang, dbo.Hoadon_phong.NgayTao, dbo.Hoadon_phong.TongTien, dbo.Hoadon_phong.TrangThai, dbo.Hoadon_phong.IDPhongTro, 
                                         dbo.Hoadon_phong.IDKhachHang, dbo.Hoadon_phong.IDHopDong
                       FROM     dbo.Hoadon_phong INNER JOIN
                                         dbo.Phong_tro ON dbo.Hoadon_phong.IDPhongTro = dbo.Phong_tro.Id
                         WHERE dbo.Phong_tro.TenPhong like CONCAT('%',?,'%') 
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, tenPhong);
            ResultSet rs = ps.executeQuery();
            List<HoaDonPhong> lists = new ArrayList<>();
            while (rs.next()) {
                HoaDonPhong hdp = new HoaDonPhong(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getDouble(5), rs.getBoolean(6), rs.getString(7), rs.getString(8), rs.getString(9));
                lists.add(hdp);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    @Override
    public List<String> getListMa() {
        String query = """
                       SELECT [Ma]
                         FROM [dbo].[Hoadon_phong]
                       ORDER BY [Ma]
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<String> lists = new ArrayList<>();
            while (rs.next()) {
                String ma = rs.getString(1);
                lists.add(ma);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    @Override
    public List<String> getListPhong() {
        String query = """
                       SELECT [TenPhong]
                         FROM [dbo].[Phong_tro]
                       WHERE [TrangThai] = 1
                       ORDER BY [TenPhong]
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<String> lists = new ArrayList<>();
            while (rs.next()) {
                String phong = rs.getString(1);
                lists.add(phong);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    @Override
    public String getTenKHByPhong(String tenPhong) {
        String query = """
                       SELECT dbo.Khach_hang.TenKH
                       FROM     dbo.Khach_hang INNER JOIN
                                         dbo.Phong_tro ON dbo.Khach_hang.Id = dbo.Phong_tro.IDKhachHang
                        WHERE dbo.Phong_tro.TenPhong = ?
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, tenPhong);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tenKH = rs.getString(1);
                return tenKH;
            }
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    @Override
    public String getPhongById(String id) {
        String query = """
                       SELECT [TenPhong]
                         FROM [dbo].[Phong_tro]
                         WHERE [Id] = ?
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tenPhong = rs.getString(1);
                return tenPhong;
            }
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    @Override
    public String getKHByID(String id) {
        String query = """
                       SELECT [TenKH]
                         FROM [dbo].[Khach_hang]
                         WHERE [Id] = ?
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tenKH = rs.getString(1);
                return tenKH;
            }
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    @Override
    public String getIDByPhong(String tenPhong) {
        String query = """
                       SELECT [Id]
                         FROM [dbo].[Phong_tro]
                         WHERE [TenPhong] = ?
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, tenPhong);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                return id;
            }
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    @Override
    public String getIDByKH(String tenKH) {
        String query = """
                       SELECT [Id]
                         FROM [dbo].[Khach_hang]
                         WHERE [TenKH] = ?
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, tenKH);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                return id;
            }
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    @Override
    public boolean add(HoaDonPhong hdp) {
        int check = 0;
        String query = """
                       INSERT INTO [dbo].[Hoadon_phong]
                                  ([Id]
                                  ,[Ma]
                                  ,[Thang]
                                  ,[NgayTao]
                                  ,[TongTien]
                                  ,[TrangThai]
                                  ,[IDPhongTro]
                                  ,[IDKhachHang]
                                  ,[IDHopDong])
                            VALUES
                                  (?,?,?,?,?,?,?,?,?)
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, hdp.getId());
            ps.setObject(2, hdp.getMa());
            ps.setObject(3, hdp.getThang());
            ps.setObject(4, hdp.getNgTao());
            ps.setObject(5, hdp.getTongTien());
            ps.setObject(6, hdp.isTrangThai());
            ps.setObject(7, hdp.getIdPT());
            ps.setObject(8, hdp.getIdKH());
            ps.setObject(9, hdp.getIdHD());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    
    @Override
    public boolean update(HoaDonPhong hdp, String id) {
        int check = 0;
        String query = """
                       UPDATE [dbo].[Hoadon_phong]
                          SET [Ma] = ?
                             ,[Thang] = ?
                             ,[NgayTao] = ?
                             ,[TongTien] = ?
                             ,[TrangThai] = ?
                             ,[IDPhongTro] = ?
                             ,[IDKhachHang] = ?
                             ,[IDHopDong] = ?
                        WHERE [Id] = ?
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, hdp.getMa());
            ps.setObject(2, hdp.getThang());
            ps.setObject(3, hdp.getNgTao());
            ps.setObject(4, hdp.getTongTien());
            ps.setObject(5, hdp.isTrangThai());
            ps.setObject(6, hdp.getIdPT());
            ps.setObject(7, hdp.getIdKH());
            ps.setObject(8, hdp.getIdHD());
            ps.setObject(9, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    
    @Override
    public boolean delete(String id) {
        int check = 0;
        String query = """
                       DELETE FROM [dbo].[Hoadon_phong]
                             WHERE [Id] = ?
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    
    @Override
    public Double getGiaByPhong(String tenPhong) {
        String query = """
                       SELECT dbo.Hop_dong.GiaPhong * 
                       
                       (
                       SELECT dbo.Hop_dong.ThoiGianNopTien
                                              FROM     dbo.Hop_dong INNER JOIN
                                                                dbo.Phong_tro ON dbo.Hop_dong.IDPhongTro = dbo.Phong_tro.Id
                                              WHERE dbo.Phong_tro.TenPhong = ?
                       )
                       
                       FROM     dbo.Hop_dong INNER JOIN
                                         dbo.Phong_tro ON dbo.Hop_dong.IDPhongTro = dbo.Phong_tro.Id
                       WHERE dbo.Phong_tro.TenPhong = ?
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, tenPhong);
            ps.setObject(2, tenPhong);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Double gia = rs.getDouble(1);
                return gia;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    @Override
    public int getThangTaoHDByIDPhong(String idPhong) {
        String query = """
                       SELECT MONTH([NgayTao])
                         FROM [dbo].[Hop_dong]
                       WHERE IDPhongTro = ?
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, idPhong);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int thang = rs.getInt(1);
                return thang;
            }
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return 0;
    }
    
    @Override
    public int getThoiHanNopTienByIDPhong(String idPhong) {
        String query = """
                       SELECT [ThoiGianNopTien]
                         FROM [dbo].[Hop_dong]
                       WHERE IDPhongTro = ?
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, idPhong);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int thang = rs.getInt(1);
                return thang;
            }
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return 0;
    }
    
    @Override
    public List<HoaDonPhong> getListHDDH() {
        String query = """
                      SELECT [Id]
                            ,[Ma]
                            ,[Thang]
                            ,[NgayTao]
                            ,[TongTien]
                            ,[TrangThai]
                            ,[IDPhongTro]
                            ,[IDKhachHang]
                            ,[IDHopDong]
                        FROM [dbo].[Hoadon_phong]
                       WHERE YEAR([NgayTao]) = YEAR(GETDATE()) and [Thang] <= MONTH(GETDATE()) and [TrangThai] = 0
                         ORDER BY [Ma]
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<HoaDonPhong> lists = new ArrayList<>();
            while (rs.next()) {
                HoaDonPhong hdp = new HoaDonPhong(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getDouble(5), rs.getBoolean(6), rs.getString(7), rs.getString(8), rs.getString(9));
                lists.add(hdp);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    @Override
    public List<String> getListThangDTT(String id) {
        String query = """
                      SELECT [Thang]
                        FROM [dbo].[Hoadon_phong]
                        WHERE [IDPhongTro] = ?
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            List<String> lists = new ArrayList<>();
            while (rs.next()) {
                String thang = rs.getString(1);
                lists.add(thang);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public String getIDHDByPhong(String tenPhong) {
        String query = """
                       SELECT dbo.Hop_dong.Id
                         FROM     dbo.Hop_dong INNER JOIN
                                           dbo.Phong_tro ON dbo.Hop_dong.IDPhongTro = dbo.Phong_tro.Id
                         WHERE dbo.Phong_tro.TenPhong = ?
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, tenPhong);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                return id;
            }
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;}
    
}
