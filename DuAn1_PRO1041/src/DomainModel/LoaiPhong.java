/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author PC ASUS
 */
public class LoaiPhong {

    private String id;
    private String ma;
    private String ten;
    private float dienTich;
    private double gia;

    public LoaiPhong() {
    }

    public LoaiPhong(String id, String ma, String ten, float dienTich, double gia) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.dienTich = dienTich;
        this.gia = gia;
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

    public float getDienTich() {
        return dienTich;
    }

    public void setDienTich(float dienTich) {
        this.dienTich = dienTich;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public Object[] toDataRow() {
        return new Object[]{ma, ten, dienTich, gia};
    }
}
