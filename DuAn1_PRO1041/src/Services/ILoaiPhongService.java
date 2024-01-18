/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModel.LoaiPhong;
import java.util.List;

/**
 *
 * @author PC ASUS
 */
public interface ILoaiPhongService {

    List<LoaiPhong> getAll();

    List<String> getListMa();

    List<LoaiPhong> TimKiem(String tenLP);

    List<String> getListTen();

    String add(LoaiPhong lp);

    String update(LoaiPhong lp, String id);

    String delete(String id);
}
