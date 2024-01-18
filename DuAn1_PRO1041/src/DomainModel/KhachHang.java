/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

import java.util.Date;
import Utilities.Support;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author PC ASUS
 */
public class KhachHang {

    private String id;
    private String ma;
    private String ten;
    private String cccd;
    private Date ngSinh;
    private String email;
    private String sdt;
    private boolean gioiTinh;
    private String diaChi;

    public KhachHang() {
    }

    public KhachHang(String id, String ma, String ten, String cccd, Date ngSinh, String email, String sdt, boolean gioiTinh, String diaChi) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.cccd = cccd;
        this.ngSinh = ngSinh;
        this.email = email;
        this.sdt = sdt;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
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

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public Date getNgSinh() {
        return ngSinh;
    }

    public void setNgSinh(Date ngSinh) {
        this.ngSinh = ngSinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Object[] toDataRow() {
//        SimpleDateFormat dateFomat = new SimpleDateFormat("dd/MM/yyyy");
        return new Object[]{ma, ten, cccd, ngSinh, email, sdt, gioiTinh == true ? "Nam" : "Nữ", diaChi};
    }
}
