/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import Utilities.DBConnect;
import ViewModel.HoaDonDienNuocViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Repositories.IHoaDonDienNuocViewModelRepository;
import ViewModel.PhongTroHDViewModel;
import java.util.UUID;

/**
 *
 * @author Bânbân
 */
public class HoaDonDienNuocViewModelRepositoryImpl implements IHoaDonDienNuocViewModelRepository {

    @Override
    public List<HoaDonDienNuocViewModel> danhSachHoaDonDienNuoc() {
        String query = """
                       SELECT Hoadon_dien_nuoc.Ma, Phong_tro.TenPhong, Khach_hang.TenKH, Hoadon_dien_nuoc.NgayTao, Hoadon_dien_nuoc.SoDien, Hoadon_dien_nuoc.SoNuoc, Hop_dong.GiaDien, Hop_dong.GiaNuoc, Hoadon_dien_nuoc.TongTien,Hoadon_dien_nuoc.TienThieu, 
                                         Hoadon_dien_nuoc.TrangThai
                       FROM     Hoadon_dien_nuoc INNER JOIN
                                         Hop_dong ON Hoadon_dien_nuoc.IDHopDong = Hop_dong.Id INNER JOIN
                                         Khach_hang ON Hoadon_dien_nuoc.IDKhachHang = Khach_hang.Id AND Hop_dong.IDKhachHang = Khach_hang.Id INNER JOIN
                                         Phong_tro ON Hoadon_dien_nuoc.IDPhongTro = Phong_tro.Id AND Hop_dong.IDPhongTro = Phong_tro.Id AND Khach_hang.Id = Phong_tro.IDKhachHang
                       """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<HoaDonDienNuocViewModel> list = new ArrayList<>();
            int stt = 1;
            while (rs.next()) {
                HoaDonDienNuocViewModel hddnvm = new HoaDonDienNuocViewModel(stt, rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getInt(5), rs.getInt(6), rs.getDouble(7), rs.getDouble(8), rs.getDouble(9), rs.getDouble(10), rs.getBoolean(11));
                list.add(hddnvm);
                stt++;
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<HoaDonDienNuocViewModel> timTheoTen(String ma) {
        String query = """
                       SELECT Hoadon_dien_nuoc.Ma, Phong_tro.TenPhong, Khach_hang.TenKH, Hoadon_dien_nuoc.NgayTao, Hoadon_dien_nuoc.SoDien, Hoadon_dien_nuoc.SoNuoc, Hop_dong.GiaDien, Hop_dong.GiaNuoc, Hoadon_dien_nuoc.TongTien,Hoadon_dien_nuoc.TienThieu, 
                                                                Hoadon_dien_nuoc.TrangThai
                                              FROM     Hoadon_dien_nuoc INNER JOIN
                                                                Hop_dong ON Hoadon_dien_nuoc.IDHopDong = Hop_dong.Id INNER JOIN
                                                                Khach_hang ON Hoadon_dien_nuoc.IDKhachHang = Khach_hang.Id AND Hop_dong.IDKhachHang = Khach_hang.Id INNER JOIN
                                                                Phong_tro ON Hoadon_dien_nuoc.IDPhongTro = Phong_tro.Id AND Hop_dong.IDPhongTro = Phong_tro.Id AND Khach_hang.Id = Phong_tro.IDKhachHang
                       Where Phong_tro.TenPhong like concat ('%',?,'%')
                       """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            List<HoaDonDienNuocViewModel> list = new ArrayList<>();
            int stt = 1;
            while (rs.next()) {
                HoaDonDienNuocViewModel hddnvm = new HoaDonDienNuocViewModel(stt, rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getInt(5), rs.getInt(6), rs.getDouble(7), rs.getDouble(8), rs.getDouble(9), rs.getDouble(10), rs.getBoolean(11));
                list.add(hddnvm);
                stt++;
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<String> danhSachPhong() {
        String query = """
                       SELECT [TenPhong]
                         FROM [dbo].[Phong_tro]
                       Order By [MaPhong] asc
                       """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<String> lists = new ArrayList<>();
            while (rs.next()) {
                String cv = rs.getString(1);
                lists.add(cv);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public String getIDByPhong(String ten) {
        String query = """
                       SELECT [Id]
                         FROM [dbo].[Phong_tro]
                       Where [TenPhong] = ?
                       """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String cv = rs.getString(1);
                return cv;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public String getPhongByID(String id) {
        String query = """
                       SELECT [TenPhong]
                         FROM [dbo].[Phong_tro]
                       Where [Id] = ?
                       """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String s = rs.getString(1);
                return s;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<String> danhSachKhachHang() {
        String query = """
                       SELECT [TenKH]
                         FROM [dbo].[Khach_hang]
                       Order By [MaKH] asc
                       """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<String> lists = new ArrayList<>();
            while (rs.next()) {
                String cv = rs.getString(1);
                lists.add(cv);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public String getIDByKH(String ten) {
        String query = """
                       SELECT [Id]
                         FROM [dbo].[Khach_hang]
                       Where [TenKH] = ?
                       """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ten);
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
    public String getKHByID(String id) {
        String query = """
                       SELECT [TenKH]
                         FROM [dbo].[Khach_hang]
                       Where [Id] = ?
                       """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            UUID uuid = UUID.fromString(id);
            ps.setObject(1, uuid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Object tenKH = rs.getObject(1);
                String ten = String.valueOf(tenKH);
                return ten;
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<PhongTroHDViewModel> danhSachPhongHD() {
        String query = """
                       SELECT Phong_tro.Id, Phong_tro.TenPhong, Khach_hang.TenKH, Phong_tro.SoTang, Phong_tro.TrangThai
                       FROM     Khach_hang INNER JOIN
                                         Phong_tro ON Khach_hang.Id = Phong_tro.IDKhachHang AND Khach_hang.Id = Phong_tro.IDKhachHang
                       Where Phong_tro.TrangThai = 1
                       """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {

            ResultSet rs = ps.executeQuery();
            List<PhongTroHDViewModel> list = new ArrayList<>();
            while (rs.next()) {
                PhongTroHDViewModel pthdvm = new PhongTroHDViewModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getBoolean(5));
                list.add(pthdvm);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public String getGiaDien(String ten) {
        String query = """
                      SELECT Hop_dong.GiaDien
                        FROM Hop_dong INNER JOIN
                        Phong_tro ON Hop_dong.IDPhongTro = Phong_tro.Id AND Hop_dong.IDPhongTro = Phong_tro.Id
                        Where Phong_tro.TenPhong = ?
                      """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String d = rs.getString(1);
                return d;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public String getGiaNuoc(String ten) {
        String query = """
                       SELECT Hop_dong.GiaNuoc
                         FROM Hop_dong INNER JOIN
                              Phong_tro ON Hop_dong.IDPhongTro = Phong_tro.Id AND Hop_dong.IDPhongTro = Phong_tro.Id
                        Where Phong_tro.TenPhong = ?
                       """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String n = rs.getString(1);
                return n;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public String getIDByHD(String ten) {
        String query = """
                       SELECT Hop_dong.Id
                       FROM     Hop_dong INNER JOIN
                                         Phong_tro ON Hop_dong.IDPhongTro = Phong_tro.Id
                       				  Where Phong_tro.TenPhong = ?
                       """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String hd = rs.getString(1);
                return hd;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public static void main(String[] args) {
        String s = new HoaDonDienNuocViewModelRepositoryImpl().getIDByHD("A101");
        System.out.println(s);
    }

    @Override
    public List<HoaDonDienNuocViewModel> ListHoaDonDienNuocTT(int trangthai) {
        String query = """
                       SELECT Hoadon_dien_nuoc.Ma, Phong_tro.TenPhong, Khach_hang.TenKH, Hoadon_dien_nuoc.NgayTao, Hoadon_dien_nuoc.SoDien, Hoadon_dien_nuoc.SoNuoc, Hop_dong.GiaDien, Hop_dong.GiaNuoc, Hoadon_dien_nuoc.TongTien,
                       Hoadon_dien_nuoc.TienThieu, Hoadon_dien_nuoc.TrangThai
                                FROM     Hoadon_dien_nuoc INNER JOIN
                                    Hop_dong ON Hoadon_dien_nuoc.IDHopDong = Hop_dong.Id INNER JOIN
                                    Khach_hang ON Hoadon_dien_nuoc.IDKhachHang = Khach_hang.Id AND Hop_dong.IDKhachHang = Khach_hang.Id INNER JOIN
                                    Phong_tro ON Hoadon_dien_nuoc.IDPhongTro = Phong_tro.Id AND Hop_dong.IDPhongTro = Phong_tro.Id AND Khach_hang.Id = Phong_tro.IDKhachHang
                       WHERE Hoadon_dien_nuoc.TrangThai = ?
                       ORDER BY Hoadon_dien_nuoc.Ma
                       """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, trangthai);
            ResultSet rs = ps.executeQuery();
            List<HoaDonDienNuocViewModel> list = new ArrayList<>();
            int stt = 1;
            while (rs.next()) {
                HoaDonDienNuocViewModel hddnvm = new HoaDonDienNuocViewModel(stt, rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getInt(5), rs.getInt(6), rs.getDouble(7), rs.getDouble(8), rs.getDouble(9), rs.getDouble(10), rs.getBoolean(11));
                list.add(hddnvm);
                stt++;
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
