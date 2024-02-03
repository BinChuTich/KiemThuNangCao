/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import DomainModel.DichVu;
import Services.IDichVuService;
import Services.Impl.DichVuServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author PC ASUS
 */
public class QuanLyDichVu extends javax.swing.JFrame {

    private DefaultTableModel dtm;
    private IDichVuService service;
    private List<DichVu> lists;
    private List<String> listMa;

    /**
     * Creates new form QuanLyDichVu
     */
    public QuanLyDichVu() {
        initComponents();
        dtm = new DefaultTableModel();
        lists = new ArrayList<>();
        service = new DichVuServiceImpl();

        lists = service.getAll();
        listMa = service.getListMa();

        dtm = (DefaultTableModel) tblListDV.getModel();

        showDataTable(lists);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgTrangThai = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        btnLamMoi = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        txtGia = new javax.swing.JTextField();
        rdoHD = new javax.swing.JRadioButton();
        rdoKHD = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListDV = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Quản Lý Dịch Vụ");

        btnLamMoi.setText("Làm Mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        jLabel2.setText("Mã Dịch Vụ");

        jLabel3.setText("Tên Dịch Vụ");

        jLabel4.setText("Giá");

        jLabel5.setText("Trạng Thái");

        bgTrangThai.add(rdoHD);
        rdoHD.setSelected(true);
        rdoHD.setText("Hoạt động");

        bgTrangThai.add(rdoKHD);
        rdoKHD.setText("Không hoạt động");

        tblListDV.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Mã Dịch Vụ", "Tên Dịch Vụ", "Giá", "Trạng Thái"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        tblListDV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListDVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListDV);

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel6.setText("Nhập tên dịch vụ cần tìm :");

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnThem)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnSua)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnXoa)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnLamMoi)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel5)
                                                                .addGap(39, 39, 39)
                                                                .addComponent(rdoHD)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(rdoKHD)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel2)
                                                                        .addComponent(jLabel3))
                                                                .addGap(34, 34, 34)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(txtMa)
                                                                        .addComponent(txtTen)
                                                                        .addComponent(txtGia))
                                                                .addGap(34, 34, 34)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel6)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(txtSearch))
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(32, 32, 32))))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(262, 262, 262)
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(23, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(btnLamMoi)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6)
                                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel4)
                                                        .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel5)
                                                        .addComponent(rdoHD)
                                                        .addComponent(rdoKHD)))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnThem)
                                        .addComponent(btnSua)
                                        .addComponent(btnXoa))
                                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if (checkData()) {
            if (checkMa()) {
                DichVu dv = getDataFromView();
                service.add(dv);
                lists = service.getAll();
                showDataTable(lists);
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        int index = tblListDV.getSelectedRow();
        if (index >= 0) {
            lists = service.getAll();
            String id = lists.get(index).getId();
            String ma = lists.get(index).getMa();
            DichVu dv = getDataFromView();
            if (ma.equalsIgnoreCase(dv.getMa())) {
                if (checkData()) {
                    service.update(dv, id);
                    lists = service.getAll();
                    showDataTable(lists);
                }
            } else {
                if (checkData()) {
                    service.update(dv, id);
                    lists = service.getAll();
                    showDataTable(lists);
                }
            }
        } else
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần sửa!");
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        lists = service.getAll();
        int index = tblListDV.getSelectedRow();
        if (index >= 0) {
            String id = lists.get(index).getId();
            service.delete(id);
            lists = service.getAll();
            showDataTable(lists);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        txtMa.setText("");
        txtTen.setText("");
        txtGia.setText("");
        txtSearch.setText("");
        lists = service.getAll();
        rdoHD.setSelected(true);
        lists = service.getAll();
        showDataTable(lists);
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void tblListDVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListDVMouseClicked
        // TODO add your handling code here:
        int index = tblListDV.getSelectedRow();
        detail(index);
    }//GEN-LAST:event_tblListDVMouseClicked

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        showDataTable(timKiem(txtSearch.getText()));
    }//GEN-LAST:event_txtSearchKeyReleased

    public void showDataTable(List<DichVu> lists) {
        dtm.setRowCount(0);
        for (DichVu dv : lists) {
            dtm.addRow(dv.toDataRow());
        }
    }

    public boolean checkData() {
        if (txtMa.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã Dịch Vụ không được để trống!");
            return false;
        } else if (txtTen.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên Dịch Vụ không được để trống!");
            return false;
        } else if (txtGia.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Giá Dịch Vụ không được để trống!");
            return false;
        } else if (!checkNumber(txtGia.getText().trim().replace(".", ""))) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkNumber(String so) {
        String kyTu = "\\d+";
        if (so.matches(kyTu)) {
            if (Integer.valueOf(so) <= 0) {
                JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ!");
                return false;
            } else {
                return true;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ!");
        }
        return false;
    }

    public boolean checkMa() {
        String ma = txtMa.getText().trim();
        for (String s : listMa) {
            if (ma.equalsIgnoreCase(s)) {
                JOptionPane.showMessageDialog(this, "Mã Dịch Vụ đã tồn tại!");
                return false;
            }
        }
        return true;
    }

    public void detail(int index) {
        lists = service.getAll();
        DichVu dv = lists.get(index);
        txtMa.setText(dv.getMa());
        txtTen.setText(dv.getTen());
        txtGia.setText(String.valueOf(dv.getGia()));
        if (dv.isTrangThai() == true) {
            rdoHD.setSelected(true);
        } else {
            rdoKHD.setSelected(true);
        }
    }

    private DichVu getDataFromView() {
        UUID id = UUID.randomUUID();
        String ma = txtMa.getText().trim();
        String ten = txtTen.getText().trim();
        String gia = txtGia.getText().trim();
        boolean trangThai = true;
        if (rdoKHD.isSelected()) {
            trangThai = false;
        }
        return new DichVu(String.valueOf(id), ma, ten, Double.valueOf(gia), trangThai);
    }

    public List<DichVu> timKiem(String tenDV) {
        lists = service.getAll();
        List<DichVu> listSearch = new ArrayList();
        for (DichVu dv : lists) {
            if (dv.getTen().contains(tenDV)) {
                listSearch.add(dv);
            }
        }
        return listSearch;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLyDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyDichVu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgTrangThai;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoHD;
    private javax.swing.JRadioButton rdoKHD;
    private javax.swing.JTable tblListDV;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
