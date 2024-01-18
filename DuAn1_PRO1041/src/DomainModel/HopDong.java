/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

import Repositories.Impl.HopDongRepositoryImpl;
import java.util.Date;
import Utilities.Support;

/**
 *
 * @author PC ASUS
 */
public class HopDong {

    private HopDongRepositoryImpl hdri = new HopDongRepositoryImpl();
    
    private String id;
    private String ma;
    private double tienCoc;
    private double giaPhong;
    private double giaDien;
    private double giaNuoc;
    private Date ngTao;
    private Date ngKT;
    private int thoiGianNopTien;
    private String idPhongTro;
    private String idKH;

    public HopDong() {
    }

    public HopDong(String id, String ma, double tienCoc, double giaPhong, double giaDien, double giaNuoc, Date ngTao, Date ngKT, int thoiGianNopTien, String idPhongTro, String idKH) {
        this.id = id;
        this.ma = ma;
        this.tienCoc = tienCoc;
        this.giaPhong = giaPhong;
        this.giaDien = giaDien;
        this.giaNuoc = giaNuoc;
        this.ngTao = ngTao;
        this.ngKT = ngKT;
        this.thoiGianNopTien = thoiGianNopTien;
        this.idPhongTro = idPhongTro;
        this.idKH = idKH;
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

    public double getTienCoc() {
        return tienCoc;
    }

    public void setTienCoc(double tienCoc) {
        this.tienCoc = tienCoc;
    }

    public double getGiaPhong() {
        return giaPhong;
    }

    public void setGiaPhong(double giaPhong) {
        this.giaPhong = giaPhong;
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

    public Date getNgTao() {
        return ngTao;
    }

    public void setNgTao(Date ngTao) {
        this.ngTao = ngTao;
    }

    public Date getNgKT() {
        return ngKT;
    }

    public void setNgKT(Date ngKT) {
        this.ngKT = ngKT;
    }

    public int getThoiGianNopTien() {
        return thoiGianNopTien;
    }

    public void setThoiGianNopTien(int thoiGianNopTien) {
        this.thoiGianNopTien = thoiGianNopTien;
    }

    public String getIdPhongTro() {
        return idPhongTro;
    }

    public void setIdPhongTro(String idPhongTro) {
        this.idPhongTro = idPhongTro;
    }

    public String getIdKH() {
        return idKH;
    }

    public void setIdKH(String idKH) {
        this.idKH = idKH;
    }

    public String getTrangThai() {
        long millis = System.currentTimeMillis();
        java.sql.Date now = new java.sql.Date(millis);
        if (now.compareTo(ngKT) < 0) {
            return "Còn hạn";
        } else {
            return "Hết hạn";
        }
    }

    public Object[] toDataRow() {
        return new Object[]{ma,hdri.getTenKHById(idKH),hdri.getTenPTById(idPhongTro), giaPhong, tienCoc, ngTao, ngKT,getTrangThai()};
    }
}
