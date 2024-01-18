/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import DomainModel.DichVu;
import Repositories.Impl.DichVuRepositoryImpl;
import Services.IDichVuService;
import java.util.List;

/**
 *
 * @author PC ASUS
 */
public class DichVuServiceImpl implements IDichVuService {

    DichVuRepositoryImpl svri = new DichVuRepositoryImpl();

    @Override
    public List<DichVu> getAll() {
        return svri.getAll();
    }

    @Override
    public List<String> getListMa() {
        return svri.getListMa();
    }

    @Override
    public String add(DichVu dv) {
        boolean add = svri.add(dv);
        if (add) {
            return "Thêm Dịch Vụ thành công!";
        } else {
            return "Thêm Dịch Vụ thất bại!";
        }
    }

    @Override
    public String update(DichVu dv, String id) {
        boolean update = svri.update(dv, id);
        if (update) {
            return "Sửa Dịch Vụ thành công!";
        } else {
            return "Sửa Dịch Vụ thất bại!";
        }
    }

    @Override
    public String delete(String id) {
        boolean delete = svri.delete(id);
        if (delete) {
            return "Xóa Dịch Vụ thành công!";
        } else {
            return "Xóa Dịch Vụ thất bại!";
        }
    }

}
