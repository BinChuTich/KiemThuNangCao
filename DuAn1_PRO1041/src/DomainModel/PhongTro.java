/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

import Repositories.Impl.PhongTroRepositoryImpl;

/**
 *
 * @author PC ASUS
 */
public class PhongTro {

    private PhongTroRepositoryImpl ptri = new PhongTroRepositoryImpl();

    private String id;
    private String ma;
    private String ten;
    private String tang;
    private boolean trangThai;
    private String moTa;
    private String idLoaiPhong;
    private String idKH;

    public PhongTro() {
    }

    public PhongTro(String id, String ma, String ten, String tang, boolean trangThai, String moTa, String idLoaiPhong, String idKH) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.tang = tang;
        this.trangThai = trangThai;
        this.moTa = moTa;
        this.idLoaiPhong = idLoaiPhong;
        this.idKH = idKH;
    }

    public PhongTro(String id, String ma, String ten, String tang, boolean trangThai, String moTa, String idLoaiPhong) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.tang = tang;
        this.trangThai = trangThai;
        this.moTa = moTa;
        this.idLoaiPhong = idLoaiPhong;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTang() {
        return tang;
    }

    public void setTang(String tang) {
        this.tang = tang;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getIdLoaiPhong() {
        return idLoaiPhong;
    }

    public void setIdLoaiPhong(String idLoaiPhong) {
        this.idLoaiPhong = idLoaiPhong;
    }

    public String getIdKH() {
        return idKH;
    }

    public void setIdKH(String idKH) {
        this.idKH = idKH;
    }

    public Object[] toDataRow() {
        return new Object[]{ma, ten, ptri.getTTLoaiPhongById(idLoaiPhong), tang, trangThai == true ? "Đang sử dụng" : "Chưa sử dụng", moTa};
    }

}
