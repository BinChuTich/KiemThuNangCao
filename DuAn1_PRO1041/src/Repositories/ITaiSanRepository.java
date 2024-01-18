/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModel.TaiSan;
import java.util.List;

/**
 *
 * @author PC ASUS
 */
public interface ITaiSanRepository {

    List<TaiSan> getAll();
    
    List<String> getListMa();

    boolean add(TaiSan ts);

    boolean update(TaiSan ts, String id);

    boolean delete(String id);
}
