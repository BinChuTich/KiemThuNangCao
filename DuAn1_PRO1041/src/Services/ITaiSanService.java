/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModel.TaiSan;
import java.util.List;

/**
 *
 * @author PC ASUS
 */
public interface ITaiSanService {

    List<TaiSan> getAll();
    
    List<String> getListMa();

    String add(TaiSan ts);

    String update(TaiSan ts, String id);

    String delete(String id);
}
