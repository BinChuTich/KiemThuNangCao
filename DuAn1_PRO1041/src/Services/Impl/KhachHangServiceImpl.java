/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import DomainModel.KhachHang;
import Repositories.Impl.KhachHangRepositoryImpl;
import Services.IKhachHangService;
import java.util.List;

/**
 *
 * @author PC ASUS
 */
public class KhachHangServiceImpl implements IKhachHangService {

    KhachHangRepositoryImpl khri = new KhachHangRepositoryImpl();

    @Override
    public List<KhachHang> getAll() {
        return khri.getAll();
    }

    @Override
    public List<String> getListMa() {
        return khri.getListMa();
    }

    @Override
    public String add(KhachHang kh) {
        boolean add = khri.add(kh);
        if (add) {
            return "Thêm Khách Hàng thành công!";
        } else {
            return "Thêm Khách Hàng thất bại!";
        }
    }

    @Override
    public String update(KhachHang kh, String id) {
        boolean update = khri.update(kh, id);
        if (update) {
            return "Sửa Khách Hàng thành công!";
        } else {
            return "Sửa Khách Hàng thất bại!";
        }
    }

    @Override
    public String delete(String id) {
        boolean delete = khri.delete(id);
        if (delete) {
            return "Xóa Khách Hàng thành công!";
        } else {
            return "Xóa Khách Hàng thất bại!";
        }
    }

    @Override
    public String addNhanh(KhachHang kh) {
        boolean add = khri.addNhanh(kh);
        if (add) {
            return "Thêm Khách Hàng nhanh thành công!";
        } else {
            return "Thêm Khách Hàng nhanh thất bại!";
        }
    }
}
