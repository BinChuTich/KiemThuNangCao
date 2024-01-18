/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import DomainModel.TaiSan;
import Repositories.Impl.TaiSanRepositoryImpl;
import Services.ITaiSanService;
import java.util.List;

/**
 *
 * @author PC ASUS
 */
public class TaiSanServiceImpl implements ITaiSanService {

    TaiSanRepositoryImpl tsri = new TaiSanRepositoryImpl();

    @Override
    public List<TaiSan> getAll() {
        return tsri.getAll();
    }

    @Override
    public String add(TaiSan ts) {
        boolean add = tsri.add(ts);
        if (add) {
            return "Thêm Tài Sản thành công!";
        } else {
            return "Thêm Tài Sản thất bại!";
        }
    }

    @Override
    public String update(TaiSan ts, String id) {
        boolean update = tsri.update(ts, id);
        if (update) {
            return "Sửa Tài Sản thành công!";
        } else {
            return "Sửa Tài Sản thất bại!";
        }
    }

    @Override
    public String delete(String id) {
        boolean delete = tsri.delete(id);
        if (delete) {
            return "Xóa Tài Sản thành công!";
        } else {
            return "Xóa Tài Sản thất bại!";
        }
    }

    @Override
    public List<String> getListMa() {
        return tsri.getListMa();
    }

}
