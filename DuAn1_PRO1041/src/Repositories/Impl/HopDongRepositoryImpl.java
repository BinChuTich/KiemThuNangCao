/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModel.HopDong;
import DomainModel.HopDongTaiSan;
import DomainModel.KhachHang;
import DomainModel.PhongTro;
import DomainModel.TaiSan;
import Repositories.IHopDongRepository;
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
public class HopDongRepositoryImpl implements IHopDongRepository {

    @Override
    public List<HopDong> getAll() {
        String query = """
                      SELECT [Id]
                               ,[Ma]
                               ,[TienCoc]
                               ,[GiaPhong]
                               ,[GiaDien]
                               ,[GiaNuoc]
                               ,[NgayTao]
                               ,[NgayKetThuc]
                               ,[ThoiGianNopTien]
                               ,[IDPhongTro]
                               ,[IDKhachHang]
                           FROM [dbo].[Hop_dong]
                       ORDER BY [Ma]
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<HopDong> lists = new ArrayList<>();
            while (rs.next()) {
                HopDong hd = new HopDong(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDate(7), rs.getDate(8), rs.getInt(9), rs.getString(10), rs.getString(11));
                lists.add(hd);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<PhongTro> getListPT() {
        String query = """
                      SELECT [Id]
                             ,[MaPhong]
                             ,[TenPhong]
                             ,[SoTang]
                             ,[TrangThai]
                             ,[MoTa]
                             ,[IDLoaiPhong]
                             ,[IDKhachHang]
                         FROM [dbo].[Phong_tro]
                       WHERE [TrangThai] = 0
                       ORDER BY [MaPhong]
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<PhongTro> lists = new ArrayList<>();
            while (rs.next()) {
                PhongTro pt = new PhongTro(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5), rs.getString(6), rs.getString(7));
                lists.add(pt);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<KhachHang> getListKH() {
        String query = """
                      SELECT [Id]
                             ,[MaKH]
                             ,[TenKH]
                             ,[CCCD]
                             ,[NgaySinh]
                             ,[Email]
                             ,[SDT]
                             ,[GioiTinh]
                             ,[DiaChi]
                         FROM [dbo].[Khach_hang]
                       
                       ORDER BY [MaKH]
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<KhachHang> lists = new ArrayList<>();
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getBoolean(8), rs.getString(9));
                lists.add(kh);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<TaiSan> getListTS() {
        String query = """
                      SELECT [Id]
                             ,[MaTS]
                             ,[TenTS]
                             ,[Gia]
                             ,[SoLuong]
                         FROM [dbo].[Tai_san]
                       ORDER BY [MaTS]
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<TaiSan> lists = new ArrayList<>();
            while (rs.next()) {
                TaiSan ts = new TaiSan(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5));
                lists.add(ts);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean add(HopDong hd) {
        int check = 0;
        String query = """
                       INSERT INTO [dbo].[Hop_dong]
                                  ([Id]
                                  ,[Ma]
                                  ,[TienCoc]
                                  ,[GiaPhong]
                                  ,[GiaDien]
                                  ,[GiaNuoc]
                                  ,[NgayTao]
                                  ,[NgayKetThuc]
                                  ,[ThoiGianNopTien]
                                  ,[IDPhongTro]
                                  ,[IDKhachHang])
                            VALUES
                                  (?,?,?,?,?,?,?,?,?,?,?)
                       
                       UPDATE [dbo].[Phong_tro]
                          SET [TrangThai] = 1
                             ,[IDKhachHang] = ?
                        WHERE [Id] = ?
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, hd.getId());
            ps.setObject(2, hd.getMa());
            ps.setObject(3, hd.getTienCoc());
            ps.setObject(4, hd.getGiaPhong());
            ps.setObject(5, hd.getGiaDien());
            ps.setObject(6, hd.getGiaNuoc());
            ps.setObject(7, hd.getNgTao());
            ps.setObject(8, hd.getNgKT());
            ps.setObject(9, hd.getThoiGianNopTien());
            ps.setObject(10, hd.getIdPhongTro());
            ps.setObject(11, hd.getIdKH());

            ps.setObject(12, hd.getIdKH());
            ps.setObject(13, hd.getIdPhongTro());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean update(HopDong hd, String idHD) {
        int check = 0;
        String query = """
                       UPDATE [dbo].[Hop_dong]
                          SET [Ma] = ?
                             ,[TienCoc] = ?
                             ,[GiaPhong] = ?
                             ,[GiaDien] = ?
                             ,[GiaNuoc] = ?
                             ,[NgayKetThuc] = ?
                        WHERE [Id] = ?
                       
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, hd.getMa());
            ps.setObject(2, hd.getTienCoc());
            ps.setObject(3, hd.getGiaPhong());
            ps.setObject(4, hd.getGiaDien());
            ps.setObject(5, hd.getGiaNuoc());
            ps.setObject(6, hd.getNgKT());
            ps.setObject(7, idHD);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public List<String> getListMa() {
        String query = """
                      SELECT [Ma]
                           FROM [dbo].[Hop_dong]
                       ORDER BY [Ma]
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<String> lists = new ArrayList<>();
            while (rs.next()) {
                String s = rs.getString(1);
                lists.add(s);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public String getLoaiPhongByIdPhong(String id) {
        String query = """
                      SELECT dbo.Loai_phong.Ten
                       FROM     dbo.Loai_phong INNER JOIN
                                         dbo.Phong_tro ON dbo.Loai_phong.Id = dbo.Phong_tro.IDLoaiPhong
                      WHERE dbo.Phong_tro.Id = ?
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String lp = rs.getString(1);
                return lp;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public String getDienTichByIdPhong(String id) {
        String query = """
                      SELECT dbo.Loai_phong.DienTich
                      FROM     dbo.Loai_phong INNER JOIN
                                         dbo.Phong_tro ON dbo.Loai_phong.Id = dbo.Phong_tro.IDLoaiPhong
                      WHERE dbo.Phong_tro.Id = ?
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String dt = rs.getString(1);
                return dt;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public String getGiaPhongByIdPhong(String id) {
        String query = """
                      SELECT dbo.Loai_phong.GiaTien
                      FROM     dbo.Loai_phong INNER JOIN
                                         dbo.Phong_tro ON dbo.Loai_phong.Id = dbo.Phong_tro.IDLoaiPhong
                      WHERE dbo.Phong_tro.Id = ?
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String dt = rs.getString(1);
                return dt;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public String getTenKHById(String id) {
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
    public String getTenPTById(String id) {
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
    public KhachHang getKHById(String id) {
        String query = """
                      SELECT [Id]
                             ,[MaKH]
                             ,[TenKH]
                             ,[CCCD]
                             ,[NgaySinh]
                             ,[Email]
                             ,[SDT]
                             ,[GioiTinh]
                             ,[DiaChi]
                         FROM [dbo].[Khach_hang]
                       WHERE [Id] = ?
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getBoolean(8), rs.getString(9));
                return kh;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public PhongTro getPTById(String id) {
        String query = """
                      SELECT [Id]
                               ,[MaPhong]
                               ,[TenPhong]
                               ,[SoTang]
                               ,[TrangThai]
                               ,[MoTa]
                               ,[IDLoaiPhong]
                               ,[IDKhachHang]
                           FROM [dbo].[Phong_tro]
                       WHERE [Id] = ?
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PhongTro pt = new PhongTro(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5), rs.getString(6), rs.getString(7), rs.getString(8));
                return pt;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public String getIdPTByTenPT(String tenPT) {
        String query = """
                     SELECT [Id]
                       FROM [dbo].[Phong_tro]
                       WHERE [TenPhong] = ?
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, tenPT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String idPT = rs.getString(1);
                return idPT;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public String getIdKHBySDT(String sdt) {
        String query = """
                     SELECT [Id]
                       FROM [dbo].[Khach_hang]
                       WHERE [SDT] = ?
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, sdt);
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
    public List<HopDong> searchByTenKH(String tenKH) {
        String query = """
                      SELECT dbo.Hop_dong.Id, dbo.Hop_dong.Ma, dbo.Hop_dong.TienCoc, dbo.Hop_dong.GiaPhong, dbo.Hop_dong.GiaDien, dbo.Hop_dong.GiaNuoc, dbo.Hop_dong.NgayTao, dbo.Hop_dong.NgayKetThuc, dbo.Hop_dong.ThoiGianNopTien, 
                                        dbo.Hop_dong.IDPhongTro, dbo.Hop_dong.IDKhachHang
                      FROM     dbo.Hop_dong INNER JOIN
                                        dbo.Khach_hang ON dbo.Hop_dong.IDKhachHang = dbo.Khach_hang.Id
                       WHERE dbo.Khach_hang.TenKH like CONCAT('%',?,'%')
                       ORDER BY dbo.Hop_dong.Ma
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, tenKH);
            ResultSet rs = ps.executeQuery();
            List<HopDong> lists = new ArrayList<>();
            while (rs.next()) {
                HopDong hd = new HopDong(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDate(7), rs.getDate(8), rs.getInt(9), rs.getString(10), rs.getString(11));
                lists.add(hd);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<HopDong> searchHDConHan() {
        String query = """
                      SELECT [Id]
                            ,[Ma]
                            ,[TienCoc]
                            ,[GiaPhong]
                            ,[GiaDien]
                            ,[GiaNuoc]
                            ,[NgayTao]
                            ,[NgayKetThuc]
                            ,[ThoiGianNopTien]
                            ,[IDPhongTro]
                            ,[IDKhachHang]
                        FROM [dbo].[Hop_dong]
                        WHERE GETDATE() < [NgayKetThuc]
                        ORDER BY [Ma]
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<HopDong> lists = new ArrayList<>();
            while (rs.next()) {
                HopDong hd = new HopDong(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDate(7), rs.getDate(8), rs.getInt(9), rs.getString(10), rs.getString(11));
                lists.add(hd);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<HopDong> searchHDHetHan() {
        String query = """
                      SELECT [Id]
                            ,[Ma]
                            ,[TienCoc]
                            ,[GiaPhong]
                            ,[GiaDien]
                            ,[GiaNuoc]
                            ,[NgayTao]
                            ,[NgayKetThuc]
                            ,[ThoiGianNopTien]
                            ,[IDPhongTro]
                            ,[IDKhachHang]
                        FROM [dbo].[Hop_dong]
                        WHERE GETDATE() > [NgayKetThuc]
                        ORDER BY [Ma]
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<HopDong> lists = new ArrayList<>();
            while (rs.next()) {
                HopDong hd = new HopDong(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDate(7), rs.getDate(8), rs.getInt(9), rs.getString(10), rs.getString(11));
                lists.add(hd);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<HopDong> searchHDSapHetHan() {
        String query = """
                      SELECT [Id]
                            ,[Ma]
                            ,[TienCoc]
                            ,[GiaPhong]
                            ,[GiaDien]
                            ,[GiaNuoc]
                            ,[NgayTao]
                            ,[NgayKetThuc]
                            ,[ThoiGianNopTien]
                            ,[IDPhongTro]
                            ,[IDKhachHang]
                        FROM [dbo].[Hop_dong]
                        WHERE Year([NgayKetThuc]) = YEAR(GETDATE()) and (MONTH([NgayKetThuc]) - MONTH(GETDATE())) <= 1
                        ORDER BY [Ma]
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<HopDong> lists = new ArrayList<>();
            while (rs.next()) {
                HopDong hd = new HopDong(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDate(7), rs.getDate(8), rs.getInt(9), rs.getString(10), rs.getString(11));
                lists.add(hd);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean addHDTS(HopDongTaiSan hdts) {
        int check = 0;
        String query = """
                       INSERT INTO [dbo].[Hop_dong_ts]
                                   ([Id]
                                   ,[IDHopDong]
                                   ,[IdTaiSan]
                                   ,[soLuong])
                             VALUES
                                   (?,?,?,?)
                       
                       UPDATE [dbo].[Tai_san]
                          SET [SoLuong] = [SoLuong] - ?
                        WHERE [Id] = ?
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, hdts.getId());
            ps.setObject(2, hdts.getIdHD());
            ps.setObject(3, hdts.getIdTS());
            ps.setObject(4, hdts.getSoLuong());
            ps.setObject(5, hdts.getSoLuong());
            ps.setObject(6, hdts.getIdTS());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public List<HopDongTaiSan> getListHDTSByIdHD(String idHD) {
        String query = """
                      SELECT [Id]
                            ,[IDHopDong]
                            ,[IdTaiSan]
                            ,[soLuong]
                        FROM [dbo].[Hop_dong_ts]
                       WHERE [IDHopDong] = ?
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, idHD);
            ResultSet rs = ps.executeQuery();
            List<HopDongTaiSan> lists = new ArrayList<>();
            while (rs.next()) {
                HopDongTaiSan hdts = new HopDongTaiSan(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                lists.add(hdts);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public String getTSByIdTS(String idTS) {
        String query = """
                     SELECT [TenTS]
                       FROM [dbo].[Tai_san]
                       WHERE [Id] = ?
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, idTS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String ts = rs.getString(1);
                return ts;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean addKH(KhachHang kh) {
        int check = 0;
        String query = """
                       INSERT INTO [dbo].[Khach_hang]
                                  ([Id]
                                  ,[MaKH]
                                  ,[TenKH]
                                  ,[CCCD]
                                  ,[NgaySinh]
                                  ,[Email]
                                  ,[SDT]
                                  ,[GioiTinh]
                                  ,[DiaChi])
                            VALUES
                                  (?,?,?,?,?,?,?,?,?)
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, kh.getId());
            ps.setObject(2, kh.getMa());
            ps.setObject(3, kh.getTen());
            ps.setObject(4, kh.getCccd());
            ps.setObject(5, kh.getNgSinh());
            ps.setObject(6, kh.getEmail());
            ps.setObject(7, kh.getSdt());
            ps.setObject(8, kh.isGioiTinh());
            ps.setObject(9, kh.getDiaChi());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
}
