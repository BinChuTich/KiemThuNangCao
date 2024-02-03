/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModel.PhongTro;
import Repositories.IPhongTroRepository;
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
public class PhongTroRepositoryImpl implements IPhongTroRepository {

    @Override
    public List<PhongTro> getAll() {
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
                         ORDER BY [MaPhong]
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<PhongTro> lists = new ArrayList<>();
            while (rs.next()) {
                PhongTro pt = new PhongTro(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5), rs.getString(6), rs.getString(7), rs.getString(8));
                lists.add(pt);
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
                       SELECT [MaPhong]
                         FROM [dbo].[Phong_tro]
                       ORDER BY [MaPhong]
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
    public List<String> getListTen() {
        String query = """
                       SELECT [TenPhong]
                         FROM [dbo].[Phong_tro]
                       ORDER BY [TenPhong]
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<String> lists = new ArrayList<>();
            while (rs.next()) {
                String ten = rs.getString(1);
                lists.add(ten);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<String> getListTTLoaiPhong() {
        String query = """
                      SELECT [Ten] + ' ' + '(' + cast([DienTich] as varchar) + 'm2' + ')' + ' ' + '(' + [Ma] + ')'
                        FROM [dbo].[Loai_phong]
                       ORDER BY [MA]
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
    public String getIdByTTLoaiPhong(String ttlp) {
        String query = """
                      SELECT [Id] 
                        FROM [dbo].[Loai_phong]
                      	where [Ten] + ' ' + '(' + cast([DienTich] as varchar) + 'm2' + ')' + ' ' + '(' + [Ma] + ')' = ?
                      """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ttlp);
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
    public String getTTLoaiPhongById(String id) {
        String query = """
                      SELECT [Ten] + ' ' + '(' + cast([DienTich] as varchar) + 'm2' + ')' + ' ' + '(' + [Ma] + ')'
                        FROM [dbo].[Loai_phong]
                        WHERE [Id] = ?
                      """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tt = rs.getString(1);
                return tt;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean add(PhongTro pt) {
        int check = 0;
        String query = """
                       INSERT INTO [dbo].[Phong_tro]
                                  ([Id]
                                  ,[MaPhong]
                                  ,[TenPhong]
                                  ,[SoTang]
                                  ,[TrangThai]
                                  ,[MoTa]
                                  ,[IDLoaiPhong])
                            VALUES
                                  (?,?,?,?,?,?,?)
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, pt.getId());
            ps.setObject(2, pt.getMa());
            ps.setObject(3, pt.getTen());
            ps.setObject(4, pt.getTang());
            ps.setObject(5, pt.isTrangThai());
            ps.setObject(6, pt.getMoTa());
            ps.setObject(7, pt.getIdLoaiPhong());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean update(PhongTro pt, String id) {
        int check = 0;
        String query = """
                       UPDATE [dbo].[Phong_tro]
                          SET [MaPhong] = ?
                             ,[TenPhong] = ?
                             ,[SoTang] = ?
                             ,[TrangThai] = ?
                             ,[MoTa] = ?
                             ,[IDLoaiPhong] = ?
                        WHERE [Id] = ?
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, pt.getMa());
            ps.setObject(2, pt.getTen());
            ps.setObject(3, pt.getTang());
            ps.setObject(4, pt.isTrangThai());
            ps.setObject(5, pt.getMoTa());
            ps.setObject(6, pt.getIdLoaiPhong());
            ps.setObject(7, id);
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
                       DELETE FROM [dbo].[Phong_tro]
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
    public List<PhongTro> TimKiem(String tenPhong) {
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
                         WHERE [TenPhong] like CONCAT('%',?,'%')
                       ORDER BY [TenPhong]
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, tenPhong);
            ResultSet rs = ps.executeQuery();
            List<PhongTro> lists = new ArrayList<>();
            while (rs.next()) {
                PhongTro pt = new PhongTro(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5), rs.getString(6), rs.getString(7), rs.getString(8));
                lists.add(pt);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<PhongTro> getListDSD() {
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
                       WHERE [TrangThai] = 1
                       ORDER BY [TenPhong]
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<PhongTro> lists = new ArrayList<>();
            while (rs.next()) {
                PhongTro pt = new PhongTro(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5), rs.getString(6), rs.getString(7), rs.getString(8));
                lists.add(pt);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

}
