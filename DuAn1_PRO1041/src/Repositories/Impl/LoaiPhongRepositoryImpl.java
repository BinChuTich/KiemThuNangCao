/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModel.LoaiPhong;
import Repositories.ILoaiPhongRepository;
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
public class LoaiPhongRepositoryImpl implements ILoaiPhongRepository {

    @Override
    public List<LoaiPhong> getAll() {
        String query = """
                       SELECT [Id]
                             ,[Ma]
                             ,[Ten]
                             ,[DienTich]
                             ,[GiaTien]
                         FROM [dbo].[Loai_phong]
                         ORDER BY [Ma]
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<LoaiPhong> lists = new ArrayList<>();
            while (rs.next()) {
                LoaiPhong lp = new LoaiPhong(rs.getString(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getDouble(5));
                lists.add(lp);
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
                         FROM [dbo].[Loai_phong]
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
                       SELECT [Ten]
                         FROM [dbo].[Loai_phong]
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
    public boolean add(LoaiPhong lp) {
        int check = 0;
        String query = """
                       INSERT INTO [dbo].[Loai_phong]
                                  ([Id]
                                  ,[Ma]
                                  ,[Ten]
                                  ,[DienTich]
                                  ,[GiaTien])
                            VALUES
                                  (?,?,?,?,?)
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, lp.getId());
            ps.setObject(2, lp.getMa());
            ps.setObject(3, lp.getTen());
            ps.setObject(4, lp.getDienTich());
            ps.setObject(5, lp.getGia());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean update(LoaiPhong lp, String id) {
        int check = 0;
        String query = """
                       UPDATE [dbo].[Loai_phong]
                          SET [Ma] = ?
                             ,[Ten] = ?
                             ,[DienTich] = ?
                             ,[GiaTien] = ?
                        WHERE [Id] = ?
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, lp.getMa());
            ps.setObject(2, lp.getTen());
            ps.setObject(3, lp.getDienTich());
            ps.setObject(4, lp.getGia());
            ps.setObject(5, id);
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
                       DELETE FROM [dbo].[Loai_phong]
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
    public List<LoaiPhong> TimKiem(String tenLP) {
        String query = """
                       SELECT [Id]
                            ,[Ma]
                            ,[Ten]
                            ,[DienTich]
                            ,[GiaTien]
                         FROM [dbo].[Loai_phong]
                         WHERE [Ten] like CONCAT('%',?,'%')
                         ORDER BY [Ten]
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, tenLP);
            ResultSet rs = ps.executeQuery();
            List<LoaiPhong> lists = new ArrayList<>();
            while (rs.next()) {
                LoaiPhong lp = new LoaiPhong(rs.getString(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getDouble(5));
                lists.add(lp);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

}
