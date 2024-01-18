/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModel.DichVu;
import java.util.List;

/**
 *
 * @author PC ASUS
 */
public interface IDichVuRepository {
    List<DichVu> getAll();
    
    List<String> getListMa();

    boolean add(DichVu dv);

    boolean update(DichVu dv, String id);

    boolean delete(String id);
}
