/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import DomainModel.HoaDonDienNuoc;
import Repositories.IHoaDonDienNuocRepository;
import Repositories.Impl.HoaDonDienNuocRepositoryImpl;
import Services.IHoaDonDienNuocService;
import java.util.List;

/**
 *
 * @author Bânbân
 */
public class HoaDonDienNuocServiceImpl implements IHoaDonDienNuocService {

    IHoaDonDienNuocRepository ihddnr = new HoaDonDienNuocRepositoryImpl();

    @Override
    public String them(HoaDonDienNuoc hddn) {
        boolean addHD = ihddnr.them(hddn);
        if (addHD) {
            return "Thêm dữ liệu thành công!";
        }
        return "Thêm dữ liệu thất bại!";
    }

    @Override
    public String sua(String ma, HoaDonDienNuoc hddn) {
        boolean updateHD = ihddnr.sua(ma, hddn);
        if (updateHD) {
            return "Cập nhật dữ liệu thành công!";
        }
        return "Cập nhật dữ liệu thất bại!";
    }

    @Override
    public String xoa(String ma) {
        boolean deleteHD = ihddnr.xoa(ma);
        if (deleteHD) {
            return "Xóa dữ liệu thành công!";
        }
        return "Xóa dữ liệu thất bại!";
    }

    @Override
    public List<HoaDonDienNuoc> getAll() {
        return ihddnr.getAll();
    }

}
