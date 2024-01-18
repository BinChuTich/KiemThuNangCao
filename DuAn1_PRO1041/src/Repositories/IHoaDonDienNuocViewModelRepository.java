/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import ViewModel.HoaDonDienNuocViewModel;
import ViewModel.PhongTroHDViewModel;
import java.util.List;

/**
 *
 * @author Bânbân
 */
public interface IHoaDonDienNuocViewModelRepository {

    List<HoaDonDienNuocViewModel> danhSachHoaDonDienNuoc();

    List<HoaDonDienNuocViewModel> timTheoTen(String ma);

    List<PhongTroHDViewModel> danhSachPhongHD();
    List<HoaDonDienNuocViewModel> ListHoaDonDienNuocTT(int trangthai);

    List<String> danhSachPhong();

    String getIDByPhong(String ten);

    String getPhongByID(String id);

    List<String> danhSachKhachHang();

    String getIDByKH(String ten);

    String getKHByID(String id);

    String getIDByHD(String ten);

    String getGiaDien(String ten);

    String getGiaNuoc(String ten);

}
