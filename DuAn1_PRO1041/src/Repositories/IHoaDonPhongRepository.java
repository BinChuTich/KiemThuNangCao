/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModel.HoaDonPhong;
import java.util.List;

/**
 *
 * @author PC ASUS
 */
public interface IHoaDonPhongRepository {

    List<HoaDonPhong> getAll();
    
    List<HoaDonPhong> getListHDDH();
    
    List<String> getListThangDTT(String id);

    List<HoaDonPhong> getListByTT(int tt);

    List<HoaDonPhong> search(String tenPhong);

    List<String> getListMa();

    List<String> getListPhong();

    String getTenKHByPhong(String tenPhong);
    
     String getIDHDByPhong(String tenPhong);

    String getPhongById(String id);

    String getKHByID(String id);

    String getIDByKH(String tenKH);

    String getIDByPhong(String tenPhong);
    
    Double getGiaByPhong(String tenPhong);
    
    int getThangTaoHDByIDPhong(String idPhong);
    
    int getThoiHanNopTienByIDPhong(String idPhong);

    boolean add(HoaDonPhong hdp);

    boolean update(HoaDonPhong hdp, String id);

    boolean delete(String id);
}
