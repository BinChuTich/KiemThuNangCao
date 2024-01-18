/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModel.KhachHang;
import Repositories.IKhachHangRepository;
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
public class KhachHangRepositoryImpl implements IKhachHangRepository {

    @Override
    public List<KhachHang> getAll() {
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
    public List<String> getListMa() {
        String query = """
                       SELECT [MaKH]
                         FROM [dbo].[Khach_hang]
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
    public boolean add(KhachHang kh) {
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

    @Override
    public boolean update(KhachHang kh, String id) {
        int check = 0;
        String query = """
                       UPDATE [dbo].[Khach_hang]
                          SET [MaKH] = ?
                             ,[TenKH] = ?
                             ,[CCCD] = ?
                             ,[NgaySinh] = ?
                             ,[Email] = ?
                             ,[SDT] = ?
                             ,[GioiTinh] = ?
                             ,[DiaChi] = ?
                        WHERE [Id] = ?
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, kh.getMa());
            ps.setObject(2, kh.getTen());
            ps.setObject(3, kh.getCccd());
            ps.setObject(4, kh.getNgSinh());
            ps.setObject(5, kh.getEmail());
            ps.setObject(6, kh.getSdt());
            ps.setObject(7, kh.isGioiTinh());
            ps.setObject(8, kh.getDiaChi());
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
                       DELETE FROM [dbo].[Khach_hang]
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
    public boolean addNhanh(KhachHang kh) {
        int check = 0;
        String query = """
                       INSERT INTO [dbo].[Khach_hang]
                                  ([Id]
                                  ,[NgaySinh]
                                  ,[SDT])
                            VALUES
                                  (?,?,?)
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, kh.getId());
            ps.setObject(2, "");
            ps.setObject(3, kh.getSdt());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

}
