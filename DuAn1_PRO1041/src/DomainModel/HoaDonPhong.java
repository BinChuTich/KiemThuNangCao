/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

import Repositories.Impl.HoaDonPhongRepositoryImpl;
import java.util.Date;
import Utilities.Support;

/**
 *
 * @author PC ASUS
 */
public class HoaDonPhong {

    private HoaDonPhongRepositoryImpl hdpri = new HoaDonPhongRepositoryImpl();

    private String id;
    private String ma;
    private int thang;
    private Date ngTao;
    private double tongTien;
    private boolean trangThai;
    private String idPT;
    private String idKH;
    private String idHD;

    public HoaDonPhong() {
    }

    public HoaDonPhong(String id, String ma, int thang, Date ngTao, double tongTien, boolean trangThai, String idPT, String idKH) {
        this.id = id;
        this.ma = ma;
        this.thang = thang;
        this.ngTao = ngTao;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
        this.idPT = idPT;
        this.idKH = idKH;
    }
    
    public HoaDonPhong(String id, String ma, Date ngTao, double tongTien, boolean trangThai, String idPT, String idKH, String idHD) {
        this.id = id;
        this.ma = ma;
        this.ngTao = ngTao;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
        this.idPT = idPT;
        this.idKH = idKH;
        this.idHD = idHD;
    }

    public HoaDonPhong(String id, String ma, int thang, Date ngTao, double tongTien, boolean trangThai, String idPT, String idKH, String idHD) {
        this.id = id;
        this.ma = ma;
        this.thang = thang;
        this.ngTao = ngTao;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
        this.idPT = idPT;
        this.idKH = idKH;
        this.idHD = idHD;
    }

    public HoaDonPhongRepositoryImpl getHdpri() {
        return hdpri;
    }

    public void setHdpri(HoaDonPhongRepositoryImpl hdpri) {
        this.hdpri = hdpri;
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

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public Date getNgTao() {
        return ngTao;
    }

    public void setNgTao(Date ngTao) {
        this.ngTao = ngTao;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getIdPT() {
        return idPT;
    }

    public void setIdPT(String idPT) {
        this.idPT = idPT;
    }

    public String getIdKH() {
        return idKH;
    }

    public void setIdKH(String idKH) {
        this.idKH = idKH;
    }

    public String getIdHD() {
        return idHD;
    }

    public void setIdHD(String idHD) {
        this.idHD = idHD;
    }

    public Object[] toDataRow() {
        return new Object[]{ma, thang, hdpri.getPhongById(idPT), hdpri.getKHByID(idKH), tongTien, Support.toString(ngTao, "dd/MM/yyyy"), trangThai == true ? "Đã thanh Toán" : "Chưa thanh toán"};
    }
}
