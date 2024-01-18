/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import DomainModel.PhongTro;
import Repositories.Impl.PhongTroRepositoryImpl;
import Services.IPhongTroService;
import java.util.List;

/**
 *
 * @author PC ASUS
 */
public class PhongTroServiceImpl implements IPhongTroService {

    PhongTroRepositoryImpl ptri = new PhongTroRepositoryImpl();

    @Override
    public List<PhongTro> getAll() {
        return ptri.getAll();
    }

    @Override
    public List<String> getListMa() {
        return ptri.getListMa();
    }

    @Override
    public List<String> getListTen() {
        return ptri.getListTen();
    }

    @Override
    public List<String> getListTTLoaiPhong() {
        return ptri.getListTTLoaiPhong();
    }

    @Override
    public String getIdByTTLoaiPhong(String ttlp) {
        return ptri.getIdByTTLoaiPhong(ttlp);
    }

    @Override
    public String getTTLoaiPhongById(String id) {
        return ptri.getTTLoaiPhongById(id);
    }

    @Override
    public String add(PhongTro pt) {
        boolean add = ptri.add(pt);
        if (add) {
            return "Thêm Phòng Trọ thành công!";
        } else {
            return "Thêm Phòng Trọ thất bại!";
        }
    }

    @Override
    public String update(PhongTro pt, String id) {
        boolean update = ptri.update(pt, id);
        if (update) {
            return "Sửa Phòng Trọ thành công!";
        } else {
            return "Sửa Phòng Trọ thất bại!";
        }
    }

    @Override
    public String delete(String id) {
        boolean delete = ptri.delete(id);
        if (delete) {
            return "Xóa Phòng Trọ thành công!";
        } else {
            return "Xóa Phòng Trọ thất bại!";
        }
    }

    @Override
    public List<PhongTro> TimKiem(String tenPhong) {
        return ptri.TimKiem(tenPhong);
    }

    @Override
    public List<PhongTro> getListDSD() {
        return ptri.getListDSD();
    }

}
