/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author PC ASUS
 */
public class DichVu {

    private String id;

    private String ma;
    private String ten;
    private double gia;
    private boolean trangThai;
    private String idHD;

    public DichVu() {
    }

    public DichVu(String id, String ma, String ten, double gia, boolean trangThai, String idHD) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
        this.trangThai = trangThai;
        this.idHD = idHD;
    }

    public DichVu(String id, String ma, String ten, double gia, boolean trangThai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
        this.trangThai = trangThai;

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

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getIdHD() {
        return idHD;
    }

    public void setIdHD(String idHD) {
        this.idHD = idHD;
    }

    

    public Object[] toDataRow() {
        return new Object[]{ma, ten, gia, trangThai == true ? "Hoạt động" : "Không hoạt động"};
    }
}
