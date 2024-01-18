/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import DomainModel.HoaDonPhong;
import Repositories.Impl.HoaDonPhongRepositoryImpl;
import Services.IHoaDonPhongService;
import java.util.List;

/**
 *
 * @author PC ASUS
 */
public class HoaDonPhongServiceImpl implements IHoaDonPhongService {

    HoaDonPhongRepositoryImpl hdpri = new HoaDonPhongRepositoryImpl();

    @Override
    public List<HoaDonPhong> getAll() {
        return hdpri.getAll();
    }

    @Override
    public List<HoaDonPhong> getListByTT(int tt) {
        return hdpri.getListByTT(tt);
    }

    @Override
    public List<HoaDonPhong> search(String tenPhong) {
        return hdpri.search(tenPhong);
    }

    @Override
    public List<String> getListMa() {
        return hdpri.getListMa();
    }

    @Override
    public List<String> getListPhong() {
        return hdpri.getListPhong();
    }

    @Override
    public String getTenKHByPhong(String tenPhong) {
        return hdpri.getTenKHByPhong(tenPhong);
    }

    @Override
    public String getPhongById(String id) {
        return hdpri.getPhongById(id);
    }

    @Override
    public String getKHByID(String id) {
        return hdpri.getKHByID(id);
    }

    @Override
    public String getIDByKH(String tenKH) {
        return hdpri.getIDByKH(tenKH);
    }

    @Override
    public String getIDByPhong(String tenPhong) {
        return hdpri.getIDByPhong(tenPhong);
    }

    @Override
    public String add(HoaDonPhong hdp) {
        boolean add = hdpri.add(hdp);
        if (add) {
            return "Thêm Hóa Đơn Phòng thành công!";
        } else {
            return "Thêm Hóa Đơn Phòng thất bại!";
        }
    }

    @Override
    public String update(HoaDonPhong hdp, String id) {
        boolean update = hdpri.update(hdp, id);
        if (update) {
            return "Sửa Hóa Đơn Phòng thành công!";
        } else {
            return "Sửa Hóa Đơn Phòng thất bại!";
        }
    }

    @Override
    public String delete(String id) {
        boolean delete = hdpri.delete(id);
        if (delete) {
            return "Xóa Hóa Đơn Phòng thành công!";
        } else {
            return "Xóa Hóa Đơn Phòng thất bại!";
        }
    }

    @Override
    public int getThangTaoHDByIDPhong(String idPhong) {
        return hdpri.getThangTaoHDByIDPhong(idPhong);
    }

    @Override
    public int getThoiHanNopTienByIDPhong(String idPhong) {
        return hdpri.getThoiHanNopTienByIDPhong(idPhong);
    }

    @Override
    public Double getGiaByPhong(String tenPhong) {
        return hdpri.getGiaByPhong(tenPhong);
    }

    @Override
    public List<HoaDonPhong> getListHDDH() {
        return hdpri.getListHDDH();
    }

    @Override
    public List<String> getListThangDTT(String id) {
        return hdpri.getListThangDTT(id);
    }

    @Override
    public String getIDHDByPhong(String tenPhong) {
        return hdpri.getIDHDByPhong(tenPhong);
    }

}
