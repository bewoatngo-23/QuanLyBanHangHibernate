/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.views;

import com.mycompany.thanhnvph20218_asshibernate.customModels.ChiTietSanPhamCustomModel;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.ChiTietSanPham;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.DongSP;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.MauSac;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.NhaSanXuat;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.SanPham;
import com.mycompany.thanhnvph20218_asshibernate.service.impl.ChiTietSanPhamServiceImpl;
import com.mycompany.thanhnvph20218_asshibernate.service.impl.DongSPServiceImpl;
import com.mycompany.thanhnvph20218_asshibernate.service.impl.MauSacServiceImpl;
import com.mycompany.thanhnvph20218_asshibernate.service.impl.NhaSanXuatServiceImpl;
import com.mycompany.thanhnvph20218_asshibernate.service.impl.SanPhamServiceImpl;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class ViewChiTietSP extends javax.swing.JFrame {

    private DefaultTableModel dtm = new DefaultTableModel();
    private List<ChiTietSanPham> listCTSP = new ArrayList<>();
    private List<ChiTietSanPhamCustomModel> listCTSPCustom = new ArrayList<>();
    private ChiTietSanPhamServiceImpl ChiTietSpService = new ChiTietSanPhamServiceImpl();
    private MauSacServiceImpl mauSacService = new MauSacServiceImpl();
    private DongSPServiceImpl dongSPService = new DongSPServiceImpl();
    private NhaSanXuatServiceImpl nhaSanXuatService = new NhaSanXuatServiceImpl();
    private SanPhamServiceImpl sanPhamService = new SanPhamServiceImpl();
    private List<SanPham> listSanPhams = new ArrayList<>();
    private List<MauSac> listMauSacs = new ArrayList<>();
    private List<NhaSanXuat> listNSXs = new ArrayList<>();
    private List<DongSP> listDongSPs = new ArrayList<>();
    private DefaultComboBoxModel dfcbSanPham = new DefaultComboBoxModel();
    private DefaultComboBoxModel dfcbMauSac = new DefaultComboBoxModel();
    private DefaultComboBoxModel dfcbNSX = new DefaultComboBoxModel();
    private DefaultComboBoxModel dfcbDongSP = new DefaultComboBoxModel();

    /**
     * Creates new form ViewChiTietSP
     */
    public ViewChiTietSP() {
        initComponents();
        tbHienThi.setModel(dtm);
        String header[] = {"M?? SP", "M?? M??u", "M?? DongSP", "M?? NSX", "N??m BH", "M?? T???", "S??? L?????ng T???n", "Gi?? Nh???p", "Gi?? B??n"};
        dtm.setColumnIdentifiers(header);
        cbbDongSP.setModel(dfcbDongSP);
        cbbMaMau.setModel(dfcbMauSac);
        cbbMaSP.setModel(dfcbSanPham);
        cbbNSX.setModel(dfcbNSX);
        listCTSPCustom = ChiTietSpService.getAllCustom();
        listDongSPs = dongSPService.getAll();
        listMauSacs = mauSacService.getAll();
        listNSXs = nhaSanXuatService.getAll();
        listSanPhams = sanPhamService.getAll();
        loadCbb();
        loadData(listCTSPCustom);
    }

    private void loadData(List<ChiTietSanPhamCustomModel> listCTSPCustom) {
        dtm.setRowCount(0);
        for (ChiTietSanPhamCustomModel ctsp : listCTSPCustom) {
            dtm.addRow(ctsp.toDataRow());
        }
    }

    private void loadCbb() {
        for (SanPham listSanPham : listSanPhams) {
            dfcbSanPham.addElement(listSanPham.getMa());
        }
        for (DongSP dongSp : listDongSPs) {
            dfcbDongSP.addElement(dongSp.getMa());
        }
        for (MauSac mauSac : listMauSacs) {
            dfcbMauSac.addElement(mauSac.getMa());
        }
        for (NhaSanXuat Nsx : listNSXs) {
            dfcbNSX.addElement(Nsx.getMa());
        }
    }

    private void fill(int index) {
        ChiTietSanPhamCustomModel ctsp = listCTSPCustom.get(index);
        lbID.setText(ctsp.getId());
        txtNamBH.setText(String.valueOf(ctsp.getNamBH()));
        txtMoTa.setText(ctsp.getMoTa());
        txtSoLuongTon.setText(String.valueOf(ctsp.getSoLuongTon()));
        txtGiaNhap.setText(String.valueOf(ctsp.getGiaNhap()));
        txtGiaBan.setText(String.valueOf(ctsp.getGiaBan()));
        cbbMaSP.setSelectedItem(ctsp.getSanPham());
        cbbMaMau.setSelectedItem(ctsp.getMauSac());
        cbbNSX.setSelectedItem(ctsp.getNhaSanXuat());
        cbbDongSP.setSelectedItem(ctsp.getDongSP());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAdd = new javax.swing.JButton();
        lbID = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbHienThi = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNamBH = new javax.swing.JTextField();
        txtMoTa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSoLuongTon = new javax.swing.JTextField();
        txtGiaNhap = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbbMaSP = new javax.swing.JComboBox<>();
        cbbMaMau = new javax.swing.JComboBox<>();
        cbbDongSP = new javax.swing.JComboBox<>();
        cbbNSX = new javax.swing.JComboBox<>();
        lbTenMau = new javax.swing.JLabel();
        lbDongSP = new javax.swing.JLabel();
        lbTenSP1 = new javax.swing.JLabel();
        lbTenNSX = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAdd.setBackground(new java.awt.Color(0, 153, 153));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 0, 0));
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lbID.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N

        jLabel1.setBackground(new java.awt.Color(255, 0, 0));
        jLabel1.setFont(new java.awt.Font("Sitka Small", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 255, 0));
        jLabel1.setText("Chi Ti???t S???n Ph???m");

        btnClear.setBackground(new java.awt.Color(0, 153, 153));
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 0, 0));
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(0, 153, 153));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 0, 0));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel2.setText("ID");

        btnUpdate.setBackground(new java.awt.Color(0, 153, 153));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 0, 0));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        tbHienThi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbHienThi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHienThiMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbHienThi);

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel3.setText("N??m BH");

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel4.setText("M?? T???");

        txtNamBH.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N

        txtMoTa.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel5.setText("Gi?? Nh???p");

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel6.setText("S??? L????ng T???n");

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel7.setText("Gi?? B??n");

        txtSoLuongTon.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N

        txtGiaNhap.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N

        txtGiaBan.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel8.setText("M?? SP");

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel9.setText("M?? DongSP");

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel10.setText("M?? M??u");

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel11.setText("M?? NSX");

        cbbMaSP.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        cbbMaSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbMaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMaSPActionPerformed(evt);
            }
        });

        cbbMaMau.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        cbbMaMau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbMaMau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMaMauActionPerformed(evt);
            }
        });

        cbbDongSP.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        cbbDongSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbDongSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbDongSPActionPerformed(evt);
            }
        });

        cbbNSX.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        cbbNSX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbNSX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbNSXActionPerformed(evt);
            }
        });

        lbTenMau.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N

        lbDongSP.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N

        lbTenSP1.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N

        lbTenNSX.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(331, 331, 331)
                                        .addComponent(jLabel10))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(330, 330, 330)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel6)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNamBH, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbID, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(cbbDongSP, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbbMaSP, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtMoTa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbDongSP, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbTenSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addGap(164, 164, 164)
                                .addComponent(btnUpdate)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtGiaBan, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                                    .addComponent(txtSoLuongTon)
                                    .addComponent(cbbMaMau, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbbNSX, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(btnDelete)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTenMau, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTenNSX, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnClear, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 63, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(275, 275, 275))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbID, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNamBH, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtSoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(cbbMaMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbTenMau, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbbMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8))
                            .addComponent(lbTenSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(cbbDongSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbNSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbDongSP, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbTenNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnAdd)
                    .addComponent(btnDelete)
                    .addComponent(btnClear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        String maSp = cbbMaSP.getSelectedItem().toString();
        SanPham sp = sanPhamService.getOne(maSp);
        String maMau = cbbMaMau.getSelectedItem().toString();
        MauSac ms = mauSacService.getOne(maMau);
        String maNSX = cbbNSX.getSelectedItem().toString();
        NhaSanXuat nsx = nhaSanXuatService.getOne(maNSX);
        String maDongSP = cbbDongSP.getSelectedItem().toString();
        DongSP dongSp = dongSPService.getOne(maDongSP);
        String namBH = txtNamBH.getText();
        String moTa = txtMoTa.getText();
        String soLuongTon = txtSoLuongTon.getText();
        String giaNhap = txtGiaNhap.getText();
        String giaBan = txtGiaBan.getText();
        ChiTietSanPham ctsp = new ChiTietSanPham(sp, nsx, ms, dongSp, Integer.valueOf(namBH), moTa, Integer.valueOf(soLuongTon), BigDecimal.valueOf(Double.valueOf(giaNhap)), BigDecimal.valueOf(Double.valueOf(giaBan)));
        JOptionPane.showMessageDialog(this, ChiTietSpService.add(ctsp));
        listCTSPCustom = ChiTietSpService.getAllCustom();
        loadData(listCTSPCustom);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        lbID.setText("");
        txtNamBH.setText(String.valueOf(""));
        txtMoTa.setText("");
        txtSoLuongTon.setText("");
        txtGiaNhap.setText("");
        txtGiaBan.setText("");
        cbbMaSP.setSelectedItem("");
        cbbMaMau.setSelectedItem("");
        cbbNSX.setSelectedIndex(0);
        cbbDongSP.setSelectedItem(0);
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int row = tbHienThi.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui l??ng ch???n d??ng");
        } else {
            ChiTietSanPhamCustomModel ctsp = listCTSPCustom.get(row);
            String id = ctsp.getId();
            JOptionPane.showMessageDialog(this, ChiTietSpService.delete(id));
            listCTSPCustom = ChiTietSpService.getAllCustom();
            loadData(listCTSPCustom);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        int row = tbHienThi.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui l??ng ch???n d??ng");
        } else {
            ChiTietSanPhamCustomModel ctspCustom = listCTSPCustom.get(row);
            String id = ctspCustom.getId();
            ChiTietSanPham ctsp = new ChiTietSanPham();
            ctsp.setNamBH(Integer.valueOf(txtNamBH.getText()));
            ctsp.setMoTa(txtMoTa.getText());
            ctsp.setSoLuongTon(Integer.valueOf(txtSoLuongTon.getText()));
            ctsp.setGiaNhap(BigDecimal.valueOf(Double.valueOf(txtGiaNhap.getText())));
            ctsp.setGiaBan(BigDecimal.valueOf(Double.valueOf(txtGiaBan.getText())));
            String maSp = cbbMaSP.getSelectedItem().toString();
            SanPham sp = sanPhamService.getOne(maSp);
            ctsp.setSanPham(sp);
            String maMau = cbbMaMau.getSelectedItem().toString();
            MauSac ms = mauSacService.getOne(maMau);
            ctsp.setMauSac(ms);
            String maNSX = cbbNSX.getSelectedItem().toString();
            NhaSanXuat nsx = nhaSanXuatService.getOne(maNSX);
            ctsp.setNhaSanXuat(nsx);
            String maDongSP = cbbDongSP.getSelectedItem().toString();
            DongSP dongSp = dongSPService.getOne(maDongSP);
            ctsp.setDongSP(dongSp);
            JOptionPane.showMessageDialog(this, ChiTietSpService.update(ctsp, id));
            listCTSPCustom = ChiTietSpService.getAllCustom();
            loadData(listCTSPCustom);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tbHienThiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHienThiMouseClicked
        // TODO add your handling code here:
        int index = tbHienThi.getSelectedRow();
        fill(index);
    }//GEN-LAST:event_tbHienThiMouseClicked

    private void cbbMaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMaSPActionPerformed
        // TODO add your handling code here:
        String ma = cbbMaSP.getSelectedItem().toString();
        SanPham sp = sanPhamService.getOne(ma);
        lbTenSP1.setText(sp.getTen());
    }//GEN-LAST:event_cbbMaSPActionPerformed

    private void cbbDongSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbDongSPActionPerformed
        // TODO add your handling code here:
        String ma = cbbDongSP.getSelectedItem().toString();
        DongSP dongSP = dongSPService.getOne(ma);
        lbDongSP.setText(dongSP.getTen());
    }//GEN-LAST:event_cbbDongSPActionPerformed

    private void cbbMaMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMaMauActionPerformed
        // TODO add your handling code here:
        String ma = cbbMaMau.getSelectedItem().toString();
        MauSac ms = mauSacService.getOne(ma);
        lbTenMau.setText(ms.getTen());
    }//GEN-LAST:event_cbbMaMauActionPerformed

    private void cbbNSXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbNSXActionPerformed
        // TODO add your handling code here:
        String ma = cbbNSX.getSelectedItem().toString();
        NhaSanXuat nsx = nhaSanXuatService.getOne(ma);
        lbTenNSX.setText(nsx.getTen());
    }//GEN-LAST:event_cbbNSXActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ViewChiTietSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ViewChiTietSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ViewChiTietSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ViewChiTietSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ViewChiTietSP().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbbDongSP;
    private javax.swing.JComboBox<String> cbbMaMau;
    private javax.swing.JComboBox<String> cbbMaSP;
    private javax.swing.JComboBox<String> cbbNSX;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbDongSP;
    private javax.swing.JLabel lbID;
    private javax.swing.JLabel lbTenMau;
    private javax.swing.JLabel lbTenNSX;
    private javax.swing.JLabel lbTenSP1;
    private javax.swing.JTable tbHienThi;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtMoTa;
    private javax.swing.JTextField txtNamBH;
    private javax.swing.JTextField txtSoLuongTon;
    // End of variables declaration//GEN-END:variables
}
