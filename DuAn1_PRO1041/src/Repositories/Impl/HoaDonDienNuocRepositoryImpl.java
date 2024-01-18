/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModel.HoaDonDienNuoc;
import Repositories.IHoaDonDienNuocRepository;
import Utilities.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bânbân
 */
public class HoaDonDienNuocRepositoryImpl implements IHoaDonDienNuocRepository {

    @Override
    public boolean them(HoaDonDienNuoc hddn) {
        int check = 0;
        String query = """
                       INSERT INTO [dbo].[Hoadon_dien_nuoc]
                                             ([Id]
                                             ,[Ma]
                                             ,[SoDien]
                                             ,[SoNuoc]
                                             ,[TongTien]
                                             ,[TienThieu]
                                             ,[NgayTao]
                                             ,[TrangThai]
                                             ,[IDPhongTro]
                                             ,[IDKhachHang]
                                             ,[IDHopDong])
                                       VALUES
                                             (?,?,?,?,?,?,?,?,?,?,?)
                       """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, hddn.getId());
            ps.setObject(2, hddn.getMa());
            ps.setObject(3, hddn.getSoDien());
            ps.setObject(4, hddn.getSoNuoc());
            ps.setObject(5, hddn.getTongTien());
            ps.setObject(6, hddn.getTienThieu());
            ps.setObject(7, hddn.getNgayTao());
            ps.setObject(8, hddn.isTrangThai());
            ps.setObject(9, hddn.getIdPhongTro());
            ps.setObject(10, hddn.getIdKH());
            ps.setObject(11, hddn.getIdHopDong());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean sua(String ma, HoaDonDienNuoc hddn) {
        int check = 0;
        String query = """
                       UPDATE [dbo].[Hoadon_dien_nuoc]
                           SET [SoDien] = ?
                              ,[SoNuoc] = ?
                              ,[TongTien] = ?
                              ,[TienThieu] = ?
                              ,[NgayTao] = ?
                              ,[TrangThai] = ?
                              ,[IDPhongTro] = ?
                              ,[IDKhachHang] = ?
                              ,[IDHopDong] = ?
                         WHERE Ma = ?
                       """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, hddn.getSoDien());
            ps.setObject(2, hddn.getSoNuoc());
            ps.setObject(3, hddn.getTongTien());
            ps.setObject(4, hddn.getTienThieu());
            ps.setObject(5, hddn.getNgayTao());
            ps.setObject(6, hddn.isTrangThai());
            ps.setObject(7, hddn.getIdPhongTro());
            ps.setObject(8, hddn.getIdKH());
            ps.setObject(9, hddn.getIdHopDong());
            ps.setObject(10, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean xoa(String ma) {
        int check = 0;
        String query = """
                       DELETE FROM [dbo].[Hoadon_dien_nuoc]
                              WHERE Ma = ?
                       """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ma);

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public List<HoaDonDienNuoc> getAll() {
        String query = """
                       SELECT [Id]
                               ,[Ma]
                               ,[SoDien]
                               ,[SoNuoc]
                               ,[TongTien]
                               ,[TienThieu]
                               ,[NgayTao]
                               ,[TrangThai]
                               ,[IDPhongTro]
                               ,[IDKhachHang]
                               ,[IDHopDong]
                           FROM [dbo].[Hoadon_dien_nuoc]
                       """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<HoaDonDienNuoc> list = new ArrayList<>();
            while (rs.next()) {
                HoaDonDienNuoc hddn = new HoaDonDienNuoc(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getDouble(5), rs.getDouble(6), rs.getDate(7), rs.getBoolean(8), rs.getString(9), rs.getString(10), rs.getString(11));
                list.add(hddn);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

}
