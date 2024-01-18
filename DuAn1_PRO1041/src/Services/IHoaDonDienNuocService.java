/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModel.HoaDonDienNuoc;
import ViewModel.HoaDonDienNuocViewModel;
import java.util.List;

/**
 *
 * @author Bânbân
 */
public interface IHoaDonDienNuocService {

    List<HoaDonDienNuoc> getAll();

    String them(HoaDonDienNuoc hddn);

    String sua(String ma, HoaDonDienNuoc hddn);

    String xoa(String ma);

    
}
