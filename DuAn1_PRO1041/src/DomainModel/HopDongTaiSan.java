/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

import Repositories.Impl.HopDongRepositoryImpl;

/**
 *
 * @author PC ASUS
 */
public class HopDongTaiSan {
     private HopDongRepositoryImpl hdri = new HopDongRepositoryImpl();
    
    private String id;
    private String idHD;
    private String idTS;
    private int soLuong;

    public HopDongTaiSan() {
    }

    public HopDongTaiSan(String id, String idTS, int soLuong) {
        this.id = id;
        this.idTS = idTS;
        this.soLuong = soLuong;
    }
    
    public HopDongTaiSan(String id, String idHD, String idTS, int soLuong) {
        this.id = id;
        this.idHD = idHD;
        this.idTS = idTS;
        this.soLuong = soLuong;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdHD() {
        return idHD;
    }

    public void setIdHD(String idHD) {
        this.idHD = idHD;
    }

    public String getIdTS() {
        return idTS;
    }

    public void setIdTS(String idTS) {
        this.idTS = idTS;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    public Object[] toDataRow() {
        return new Object[] {hdri.getTSByIdTS(idTS),soLuong};
    }
}
