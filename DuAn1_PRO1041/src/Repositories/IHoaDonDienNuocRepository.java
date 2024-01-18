/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModel.HoaDonDienNuoc;
import java.util.List;

/**
 *
 * @author Bânbân
 */
public interface IHoaDonDienNuocRepository {
   
    List<HoaDonDienNuoc> getAll();

    boolean them(HoaDonDienNuoc hddn);

    boolean sua(String ma, HoaDonDienNuoc hddn);

    boolean xoa(String ma);


}
