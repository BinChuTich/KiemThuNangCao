/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Application;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;

/**
 *
 * @author truon
 */
public class Menu extends javax.swing.JPanel {
    
    private EventMenuSelected event;
    
    public void addEventMenuSelected(EventMenuSelected event) {
        this.event = event;
        listMenu1.addEventMenuSelected(event);
    }
    
    public Menu() {
        initComponents();
        setOpaque(false);
        listMenu1.setOpaque(false);
        init();
    }
    
    private void init() {
        listMenu1.addItem(new ModelMenu(" ", " ", ModelMenu.MenuType.EMPTY));
        listMenu1.addItem(new ModelMenu("1", "Phòng trọ", ModelMenu.MenuType.MENU));
        listMenu1.addItem(new ModelMenu(" ", " ", ModelMenu.MenuType.EMPTY));
        listMenu1.addItem(new ModelMenu("0", "Hợp đồng", ModelMenu.MenuType.MENU));
//        listMenu1.addItem(new ModelMenu(" ", " ", ModelMenu.MenuType.EMPTY));
//        listMenu1.addItem(new ModelMenu("2", "Loại phòng", ModelMenu.MenuType.MENU));
        listMenu1.addItem(new ModelMenu(" ", " ", ModelMenu.MenuType.EMPTY));
        listMenu1.addItem(new ModelMenu("3", "Khách hàng", ModelMenu.MenuType.MENU));
        listMenu1.addItem(new ModelMenu(" ", " ", ModelMenu.MenuType.EMPTY));
        listMenu1.addItem(new ModelMenu("4", "Hóa đơn điện nước", ModelMenu.MenuType.MENU));
        listMenu1.addItem(new ModelMenu(" ", " ", ModelMenu.MenuType.EMPTY));
        listMenu1.addItem(new ModelMenu("5", "Hóa đơn phòng", ModelMenu.MenuType.MENU));
        listMenu1.addItem(new ModelMenu(" ", " ", ModelMenu.MenuType.EMPTY));
        listMenu1.addItem(new ModelMenu("6", "Tài sản", ModelMenu.MenuType.MENU));
        listMenu1.addItem(new ModelMenu(" ", " ", ModelMenu.MenuType.EMPTY));
        listMenu1.addItem(new ModelMenu("8", "Thống kê", ModelMenu.MenuType.MENU));
        listMenu1.addItem(new ModelMenu(" ", " ", ModelMenu.MenuType.EMPTY));
        listMenu1.addItem(new ModelMenu("7", "Thoát", ModelMenu.MenuType.MENU));

    }
    
    
    @Override
    protected void paintChildren(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gp = new GradientPaint(0, 0, Color.decode("#6A82FB"), 0, getHeight(), Color.decode("#FC5C7D"));
        g2.setPaint(gp);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
        
        super.paintChildren(g);
    }

    private int x;
    private int y;
    
    public void initMoving(JFrame frame) {
        panelMoving.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();
            }
        });
        panelMoving.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                frame.setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
            }
        });
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMoving = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        listMenu1 = new Application.ListMenu<>();

        setPreferredSize(new java.awt.Dimension(200, 454));

        panelMoving.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/motel.png"))); // NOI18N
        jLabel2.setText("Nhà trọ số 3");

        javax.swing.GroupLayout panelMovingLayout = new javax.swing.GroupLayout(panelMoving);
        panelMoving.setLayout(panelMovingLayout);
        panelMovingLayout.setHorizontalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
        );
        panelMovingLayout.setVerticalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovingLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMoving, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMoving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private Application.ListMenu<String> listMenu1;
    private javax.swing.JPanel panelMoving;
    // End of variables declaration//GEN-END:variables
}
