/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModel.PhongTro;
import java.util.List;

/**
 *
 * @author PC ASUS
 */
public interface IPhongTroService {

    List<PhongTro> getAll();
    
    List<PhongTro> getListDSD();

    List<String> getListMa();

    List<String> getListTen();

    List<PhongTro> TimKiem(String tenPhong);

    List<String> getListTTLoaiPhong();

    String getIdByTTLoaiPhong(String ttlp);

    String getTTLoaiPhongById(String id);

    String add(PhongTro pt);

    String update(PhongTro pt, String id);

    String delete(String id);
}
