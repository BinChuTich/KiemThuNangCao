/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import DomainModel.LoaiPhong;
import Repositories.Impl.LoaiPhongRepositoryImpl;
import Services.ILoaiPhongService;
import java.util.List;

/**
 *
 * @author PC ASUS
 */
public class LoaiPhongServiceImpl implements ILoaiPhongService {

    LoaiPhongRepositoryImpl lpri = new LoaiPhongRepositoryImpl();

    @Override
    public List<LoaiPhong> getAll() {
        return lpri.getAll();
    }

    @Override
    public List<String> getListMa() {
        return lpri.getListMa();
    }

    @Override
    public List<String> getListTen() {
        return lpri.getListTen();
    }

    @Override
    public String add(LoaiPhong lp) {
        boolean add = lpri.add(lp);
        if (add) {
            return "Thêm Loại Phòng thành công!";
        } else {
            return "Thêm Loại Phòng thất bại!";
        }
    }

    @Override
    public String update(LoaiPhong lp, String id) {
        boolean update = lpri.update(lp, id);
        if (update) {
            return "Sửa Loại Phòng thành công!";
        } else {
            return "Sửa Loại Phòng thất bại!";
        }
    }

    @Override
    public String delete(String id) {
        boolean delete = lpri.delete(id);
        if (delete) {
            return "Xóa Loại Phòng thành công!";
        } else {
            return "Xóa Loại Phòng thất bại!";
        }
    }

    @Override
    public List<LoaiPhong> TimKiem(String tenLP) {
        return lpri.TimKiem(tenLP);
    }
}
