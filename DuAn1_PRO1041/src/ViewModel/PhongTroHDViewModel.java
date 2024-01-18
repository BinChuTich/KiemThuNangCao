/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author Bânbân
 */
public class PhongTroHDViewModel {

    private String id;
    private String tenPhong;
    private String tenKH;
    private int soTang;
    private boolean trangThai;

    public PhongTroHDViewModel() {
    }

    public PhongTroHDViewModel(String id, String tenPhong, String tenKH, int soTang, boolean trangThai) {
        this.id = id;
        this.tenPhong = tenPhong;
        this.tenKH = tenKH;
        this.soTang = soTang;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public int getSoTang() {
        return soTang;
    }

    public void setSoTang(int soTang) {
        this.soTang = soTang;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getTrangThai() {
        return trangThai ? "Đã thuê" : "Trống";
    }

    public Object[] toDataRow() {
        return new Object[]{id, tenPhong, tenKH, soTang, getTrangThai()};
    }
}
