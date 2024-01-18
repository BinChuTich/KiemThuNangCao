/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

import Services.IHoaDonPhongService;
import Services.Impl.HoaDonPhongServiceImpl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import Utilities.Support;

/**
 *
 * @author PC ASUS
 */
public class Test {

    private IHoaDonPhongService service;

    public Test() {
        service = new HoaDonPhongServiceImpl();
    }

    public static List<String> getListThang(int thang, int soThang) {
        List<String> listThang = new ArrayList<>();
        for (int i = thang; i <= 12; i += soThang) {
            listThang.add(String.valueOf(i));
        }
        return listThang;
    }

    public static void main(String[] args) throws ParseException {
//        for (String s : getListThang(3, 5) ) {
//            System.out.println(s.toString());
//        }
//        SimpleDateFormat sdf = new SimpleDateFormat();
//        Date d1 = Support.toDate("9/04/2023", "dd/MM/yyyy");
//        Date d2 = Support.toDate("10/04/2023", "dd/MM/yyyy");
//        System.out.println(d1.compareTo(d2));
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        System.out.println(date);
    }
}
