/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModel.DichVu;
import java.util.List;

/**
 *
 * @author PC ASUS
 */
public interface IDichVuService {

    List<DichVu> getAll();

    List<String> getListMa();

    String add(DichVu dv);

    String update(DichVu dv, String id);

    String delete(String id);
}
