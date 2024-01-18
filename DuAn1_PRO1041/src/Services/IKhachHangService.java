/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModel.KhachHang;
import java.util.List;

/**
 *
 * @author PC ASUS
 */
public interface IKhachHangService {

    List<KhachHang> getAll();
    
    List<String> getListMa();

    String add(KhachHang kh);
    
    String addNhanh(KhachHang kh);

    String update(KhachHang kh, String id);

    String delete(String id);
}
