/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import java.util.Date;

/**
 *
 * @author Bânbân
 */
public class HoaDonDienNuocViewModel {

    private int stt;
    private String maHD;
    private String tenPhong;
    private String tenKH;
    private Date ngayDong;
    private int soDien;
    private int soNuoc;
    private double giaDien;
    private double giaNuoc;
    private double tongTien;
    private double tienKhachDua;
    private double tienThieu;
    private boolean TrangThai;

    public HoaDonDienNuocViewModel() {
    }

    public HoaDonDienNuocViewModel(int stt, String maHD, String tenPhong, String tenKH, Date ngayDong, int soDien, int soNuoc, double giaDien, double giaNuoc, double tongTien, double tienKhachDua, double tienThieu, boolean TrangThai) {
        this.stt = stt;
        this.maHD = maHD;
        this.tenPhong = tenPhong;
        this.tenKH = tenKH;
        this.ngayDong = ngayDong;
        this.soDien = soDien;
        this.soNuoc = soNuoc;
        this.giaDien = giaDien;
        this.giaNuoc = giaNuoc;
        this.tongTien = tongTien;
        this.tienKhachDua = tienKhachDua;
        this.tienThieu = tienThieu;
        this.TrangThai = TrangThai;
    }

    public HoaDonDienNuocViewModel(int stt, String maHD, String tenPhong, String tenKH, Date ngayDong, int soDien, int soNuoc, double giaDien, double giaNuoc, double tongTien, double tienThieu, boolean TrangThai) {
        this.stt = stt;
        this.maHD = maHD;
        this.tenPhong = tenPhong;
        this.tenKH = tenKH;
        this.ngayDong = ngayDong;
        this.soDien = soDien;
        this.soNuoc = soNuoc;
        this.giaDien = giaDien;
        this.giaNuoc = giaNuoc;
        this.tongTien = tongTien;
        this.tienThieu = tienThieu;
        this.TrangThai = TrangThai;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
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

    public Date getNgayDong() {
        return ngayDong;
    }

    public void setNgayDong(Date ngayDong) {
        this.ngayDong = ngayDong;
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

    public double getGiaDien() {
        return giaDien;
    }

    public void setGiaDien(double giaDien) {
        this.giaDien = giaDien;
    }

    public double getGiaNuoc() {
        return giaNuoc;
    }

    public void setGiaNuoc(double giaNuoc) {
        this.giaNuoc = giaNuoc;
    }

    public double getTienKhachDua() {
        return tienKhachDua;
    }

    public void setTienKhachDua(double tienKhachDua) {
        this.tienKhachDua = tienKhachDua;
    }

    public double getTienThieu() {
        return tienThieu;
    }

    public void setTienThieu(double tienThieu) {
        this.tienThieu = tienThieu;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getTrangThai() {
        return TrangThai ? "Đã thanh toán" : "Chưa thanh toán";
    }

    public double getTongTien() {

        tongTien = (soDien * giaDien) + (soNuoc * giaNuoc);
        return tongTien;
    }

    public double thieu() {

         tienThieu = getTongTien() - tienKhachDua;
        return tienThieu;
    }

    public Object[] toDataRow() {
        return new Object[]{stt, maHD, tenPhong, tenKH, ngayDong, getTongTien(),tienThieu, getTrangThai()};
    }
}
