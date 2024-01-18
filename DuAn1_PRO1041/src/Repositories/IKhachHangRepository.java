/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModel.KhachHang;
import java.util.List;

/**
 *
 * @author PC ASUS
 */
public interface IKhachHangRepository {

    List<KhachHang> getAll();
    
    List<String> getListMa();

    boolean add(KhachHang kh);
    
    boolean addNhanh(KhachHang kh);

    boolean update(KhachHang kh, String id);

    boolean delete(String id);
}
