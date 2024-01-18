/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModel.PhongTro;
import java.util.List;

/**
 *
 * @author PC ASUS
 */
public interface IPhongTroRepository {

    List<PhongTro> getAll();
    
    List<PhongTro> getListDSD();

    List<PhongTro> TimKiem(String tenPhong);
    
    List<String> getListMa();
    
    List<String> getListTen();

    List<String> getListTTLoaiPhong();

    String getIdByTTLoaiPhong(String ttlp);
    
    String getTTLoaiPhongById(String id);

    boolean add(PhongTro pt);

    boolean update(PhongTro pt, String id);

    boolean delete(String id);
}
