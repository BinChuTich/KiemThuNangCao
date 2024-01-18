/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModel.DichVu;
import Repositories.IDichVuRepository;
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
public class DichVuRepositoryImpl implements IDichVuRepository {
    
    @Override
    public List<DichVu> getAll() {
        String query = """
                       SELECT [Id]
                             ,[Ma]
                             ,[Ten]
                             ,[Gia]
                             ,[TrangThai]
                             ,[IDHopDong]
                         FROM [dbo].[Dich_vu]
                         ORDER BY [Ma]
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<DichVu> lists = new ArrayList<>();
            while (rs.next()) {
                DichVu dv = new DichVu(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getBoolean(5), rs.getString(6));
                lists.add(dv);
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
                         FROM [dbo].[Dich_vu]
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
    public boolean add(DichVu dv) {
        int check = 0;
        String query = """
                       INSERT INTO [dbo].[Dich_vu]
                                  ([Id]
                                  ,[Ma]
                                  ,[Ten]
                                  ,[Gia]
                                  ,[TrangThai])
                            VALUES
                                  (?,?,?,?,?)
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, dv.getId());
            ps.setObject(2, dv.getMa());
            ps.setObject(3, dv.getTen());
            ps.setObject(4, dv.getGia());
            ps.setObject(5, dv.isTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    
    @Override
    public boolean update(DichVu dv, String id) {
        int check = 0;
        String query = """
                       UPDATE [dbo].[Dich_vu]
                          SET [Ma] = ?
                             ,[Ten] = ?
                             ,[Gia] = ?
                             ,[TrangThai] = ?
                        WHERE [Id] = ?
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, dv.getMa());
            ps.setObject(2, dv.getTen());
            ps.setObject(3, dv.getGia());
            ps.setObject(4, dv.isTrangThai());
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
                       DELETE FROM [dbo].[Dich_vu]
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
    
}
