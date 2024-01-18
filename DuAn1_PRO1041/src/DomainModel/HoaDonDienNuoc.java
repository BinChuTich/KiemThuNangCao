/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

import java.util.Date;

/**
 *
 * @author Bânbân
 */
public class HoaDonDienNuoc {

    private String id;
    private String ma;
    private int soDien;
    private int soNuoc;
    private double tongTien;
    private double tienThieu;
    private Date ngayTao;
    private boolean trangThai;
    private String idKH;
    private String idPhongTro;
    private String idHopDong;

    public HoaDonDienNuoc() {
    }

    public HoaDonDienNuoc(String id, String ma, int soDien, int soNuoc, double tongTien, double tienThieu, Date ngayTao, boolean trangThai, String idKH, String idPhongTro, String idHopDong) {
        this.id = id;
        this.ma = ma;
        this.soDien = soDien;
        this.soNuoc = soNuoc;
        this.tongTien = tongTien;
        this.tienThieu = tienThieu;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
        this.idKH = idKH;
        this.idPhongTro = idPhongTro;
        this.idHopDong = idHopDong;
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

    public int getSoDien() {
        return soDien;
    }

    public void setSoDien(int soDien) {
        this.soDien = soDien;
    }

    public int getSoNuoc() {
        return soNuoc;
    }

    public void setSoNuoc(int soNuoc) {
        this.soNuoc = soNuoc;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public double getTienThieu() {
        return tienThieu;
    }

    public void setTienThieu(double tienThieu) {
        this.tienThieu = tienThieu;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getIdKH() {
        return idKH;
    }

    public void setIdKH(String idKH) {
        this.idKH = idKH;
    }

    public String getIdPhongTro() {
        return idPhongTro;
    }

    public void setIdPhongTro(String idPhongTro) {
        this.idPhongTro = idPhongTro;
    }

    public String getIdHopDong() {
        return idHopDong;
    }

    public void setIdHopDong(String idHopDong) {
        this.idHopDong = idHopDong;
    }

}
