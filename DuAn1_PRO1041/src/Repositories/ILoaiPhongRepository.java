/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModel.LoaiPhong;
import java.util.List;

/**
 *
 * @author PC ASUS
 */
public interface ILoaiPhongRepository {

    List<LoaiPhong> getAll();
    
    List<LoaiPhong> TimKiem(String tenLP);

    List<String> getListMa();
    
    List<String> getListTen();

    boolean add(LoaiPhong lp);

    boolean update(LoaiPhong lp, String id);

    boolean delete(String id);
}
