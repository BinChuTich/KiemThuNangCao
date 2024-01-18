/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModel.HopDong;
import DomainModel.HopDongTaiSan;
import DomainModel.KhachHang;
import DomainModel.PhongTro;
import DomainModel.TaiSan;
import java.util.List;

/**
 *
 * @author PC ASUS
 */
public interface IHopDongRepository {

    List<HopDong> getAll();
    
    List<HopDongTaiSan> getListHDTSByIdHD(String idHD);

    List<String> getListMa();

    String getLoaiPhongByIdPhong(String id);

    String getDienTichByIdPhong(String id);

    String getGiaPhongByIdPhong(String id);

    String getTenKHById(String id);

    String getTenPTById(String id);

    KhachHang getKHById(String id);

    PhongTro getPTById(String id);

    String getIdPTByTenPT(String tenPT);

    String getIdKHBySDT(String sdt);

    List<PhongTro> getListPT();

    List<KhachHang> getListKH();

    List<TaiSan> getListTS();

    boolean add(HopDong hd);
    
    boolean addKH(KhachHang kh);
    
    boolean addHDTS(HopDongTaiSan hdts);

    boolean update(HopDong hd, String idHD);
    
    String getTSByIdTS(String idTS);

    List<HopDong> searchByTenKH(String tenKH);

    List<HopDong> searchHDConHan();

    List<HopDong> searchHDHetHan();

    List<HopDong> searchHDSapHetHan();
}
