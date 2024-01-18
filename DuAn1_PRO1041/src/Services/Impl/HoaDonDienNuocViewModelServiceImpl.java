/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import Repositories.Impl.HoaDonDienNuocViewModelRepositoryImpl;
import ViewModel.HoaDonDienNuocViewModel;
import java.util.List;
import Repositories.IHoaDonDienNuocViewModelRepository;
import Services.IHoaDonDienNuocViewModelService;
import ViewModel.PhongTroHDViewModel;

/**
 *
 * @author Bânbân
 */
public class HoaDonDienNuocViewModelServiceImpl implements IHoaDonDienNuocViewModelService {

    IHoaDonDienNuocViewModelRepository ihddnvmr = new HoaDonDienNuocViewModelRepositoryImpl();

    @Override
    public List<HoaDonDienNuocViewModel> danhSach() {
        return ihddnvmr.danhSachHoaDonDienNuoc();
    }

    @Override
    public List<HoaDonDienNuocViewModel> timtheoten(String ma) {
        return ihddnvmr.timTheoTen(ma);
    }

    @Override
    public List<String> danhSachPhong() {
        return ihddnvmr.danhSachPhong();
    }

    @Override
    public String getIDByPhong(String ten) {
        return ihddnvmr.getIDByPhong(ten);
    }

    @Override
    public String getPhongByID(String id) {
        return ihddnvmr.getPhongByID(id);
    }

    @Override
    public List<String> danhSachKhachThue() {
        return ihddnvmr.danhSachKhachHang();
    }

    @Override
    public String getIDByKH(String ten) {
        return ihddnvmr.getIDByKH(ten);
    }

    @Override
    public String getKHByID(String id) {
        return ihddnvmr.getKHByID(id);
    }

    @Override
    public List<PhongTroHDViewModel> danhSachHDPhong() {
        return ihddnvmr.danhSachPhongHD();
    }

    @Override
    public String getGiaDien(String ten) {
        return ihddnvmr.getGiaDien(ten);
    }

    @Override
    public String getGiaNuoc(String ten) {
        return ihddnvmr.getGiaNuoc(ten);
    }

    @Override
    public String getIDByHD(String ten) {
        return ihddnvmr.getIDByHD(ten);
    }

    @Override
    public List<HoaDonDienNuocViewModel> listHoaDonDienNuocTT(int trangThai) {
        return ihddnvmr.ListHoaDonDienNuocTT(trangThai);
    }
}
