/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModel.TaiSan;
import Repositories.ITaiSanRepository;
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
public class TaiSanRepositoryImpl implements ITaiSanRepository {

    @Override
    public List<TaiSan> getAll() {
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
    public boolean add(TaiSan ts) {
        int check = 0;
        String query = """
                       INSERT INTO [dbo].[Tai_san]
                                  ([Id]
                                  ,[MaTS]
                                  ,[TenTS]
                                  ,[Gia]
                                  ,[SoLuong])
                            VALUES
                                  (?,?,?,?,?)
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ts.getId());
            ps.setObject(2, ts.getMa());
            ps.setObject(3, ts.getTen());
            ps.setObject(4, ts.getGia());
            ps.setObject(5, ts.getSoLuong());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean update(TaiSan ts, String id) {
        int check = 0;
        String query = """
                       UPDATE [dbo].[Tai_san]
                          SET [MaTS] = ?
                             ,[TenTS] = ?
                             ,[Gia] = ?
                             ,[SoLuong] = ?
                        WHERE [Id] = ?
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ts.getMa());
            ps.setObject(2, ts.getTen());
            ps.setObject(3, ts.getGia());
            ps.setObject(4, ts.getSoLuong());
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
                       DELETE FROM [dbo].[Tai_san]
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
    public List<String> getListMa() {
        String query = """
                       SELECT [MaTS]
                         FROM [dbo].[Tai_san]
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
}
