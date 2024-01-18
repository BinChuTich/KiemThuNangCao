/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import DomainModel.HopDong;
import DomainModel.HopDongTaiSan;
import DomainModel.KhachHang;
import DomainModel.PhongTro;
import DomainModel.TaiSan;
import Repositories.Impl.HopDongRepositoryImpl;
import Services.IHopDongService;
import java.util.List;

/**
 *
 * @author PC ASUS
 */
public class HopDongServiceImpl implements IHopDongService {

    HopDongRepositoryImpl hdri = new HopDongRepositoryImpl();

    @Override
    public List<HopDong> getAll() {
        return hdri.getAll();
    }

    @Override
    public List<PhongTro> getListPT() {
        return hdri.getListPT();
    }

    @Override
    public List<KhachHang> getListKH() {
        return hdri.getListKH();
    }

    @Override
    public List<TaiSan> getListTS() {
        return hdri.getListTS();
    }

    @Override
    public String add(HopDong hd) {
        boolean add = hdri.add(hd);
        if (add) {
            return "Tạo Hợp Đồng thành công!";
        } else {
            return "Tạo Hợp Đồng thất bại!";
        }
    }

    @Override
    public String update(HopDong hd, String idHD) {
        boolean update = hdri.update(hd, idHD);
        if (update) {
            return "Sửa Hợp Đồng thành công!";
        } else {
            return "Sửa Hợp Đồng thất bại!";
        }
    }

    @Override
    public String getLoaiPhongByIdPhong(String id) {
        return hdri.getLoaiPhongByIdPhong(id);
    }

    @Override
    public String getDienTichByIdPhong(String id) {
        return hdri.getDienTichByIdPhong(id);
    }

    @Override
    public String getGiaPhongByIdPhong(String id) {
        return hdri.getGiaPhongByIdPhong(id);
    }

    @Override
    public List<String> getListMa() {
        return hdri.getListMa();
    }

    @Override
    public String getTenKHById(String id) {
        return hdri.getTenKHById(id);
    }

    @Override
    public String getTenPTById(String id) {
        return hdri.getTenPTById(id);
    }

    @Override
    public KhachHang getKHById(String id) {
        return hdri.getKHById(id);
    }

    @Override
    public PhongTro getPTById(String id) {
        return hdri.getPTById(id);
    }

    @Override
    public String getIdPTByTenPT(String tenPT) {
        return hdri.getIdPTByTenPT(tenPT);
    }

    @Override
    public String getIdKHBySDT(String sdt) {
        return hdri.getIdKHBySDT(sdt);
    }

    @Override
    public List<HopDong> searchByTenKH(String tenKH) {
        return hdri.searchByTenKH(tenKH);
    }

    @Override
    public List<HopDong> searchHDConHan() {
        return hdri.searchHDConHan();
    }

    @Override
    public List<HopDong> searchHDHetHan() {
        return hdri.searchHDHetHan();
    }

    @Override
    public List<HopDong> searchHDSapHetHan() {
        return hdri.searchHDSapHetHan();
    }

    @Override
    public List<HopDongTaiSan> getListHDTSByIdHD(String idHD) {
        return hdri.getListHDTSByIdHD(idHD);
    }

    @Override
    public String addHDTS(HopDongTaiSan hdts) {
        boolean add = hdri.addHDTS(hdts);
        if (add) {
            return "Tạo Hợp Đồng Tài Sản thành công!";
        } else {
            return "Tạo Hợp Đồng Tài Sản thất bại!";
        }
    }

    @Override
    public String getTSByIdTS(String idTS) {
        return hdri.getTSByIdTS(idTS);
    }

    @Override
    public String addKH(KhachHang kh) {
        boolean add = hdri.addKH(kh);
        if (add) {
            return "Thêm Khách Hàng thành công!";
        } else {
            return "Thêm Khách Hàng thất bại!";
        }
    }

}
