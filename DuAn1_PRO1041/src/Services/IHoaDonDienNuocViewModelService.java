/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModel.HoaDonDienNuocViewModel;
import ViewModel.PhongTroHDViewModel;
import java.util.List;

/**
 *
 * @author Bânbân
 */
public interface IHoaDonDienNuocViewModelService {

    List<HoaDonDienNuocViewModel> danhSach();

    List<HoaDonDienNuocViewModel> timtheoten(String ma);

    List<PhongTroHDViewModel> danhSachHDPhong();

    List<HoaDonDienNuocViewModel> listHoaDonDienNuocTT(int trangThai);

    List<String> danhSachPhong();

    String getIDByPhong(String ten);

    String getPhongByID(String id);

    List<String> danhSachKhachThue();

    String getIDByKH(String ten);

    String getKHByID(String id);

    String getIDByHD(String ten);

    String getGiaDien(String ten);

    String getGiaNuoc(String ten);
}
