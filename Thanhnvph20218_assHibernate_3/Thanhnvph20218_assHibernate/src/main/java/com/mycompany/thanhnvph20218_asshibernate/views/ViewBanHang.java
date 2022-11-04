/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.thanhnvph20218_asshibernate.views;

import com.mycompany.thanhnvph20218_asshibernate.domainModels.ChiTietSanPham;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.HoaDon;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.HoaDonChiTiet;
import com.mycompany.thanhnvph20218_asshibernate.domainModels.NhanVien;
import com.mycompany.thanhnvph20218_asshibernate.service.impl.BanHangServiceImpl;
import com.mycompany.thanhnvph20218_asshibernate.service.impl.ChiTietSanPhamServiceImpl;
import com.mycompany.thanhnvph20218_asshibernate.service.impl.HoaDonChiTietServiceImpl;
import com.mycompany.thanhnvph20218_asshibernate.service.impl.HoaDonServiceImpl;
import com.mycompany.thanhnvph20218_asshibernate.service.impl.NhanVienServiceImpl;
import com.mycompany.thanhnvph20218_asshibernate.customModelBanHangs.GioHangModel;
import com.mycompany.thanhnvph20218_asshibernate.customModelBanHangs.SanPhamViewModel;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class ViewBanHang extends javax.swing.JFrame {

    private DefaultTableModel dtmHoaDon = new DefaultTableModel();
    private DefaultTableModel dtmGioHang = new DefaultTableModel();
    private DefaultTableModel dtmSanPham = new DefaultTableModel();
    private HoaDonServiceImpl hoaDonService = new HoaDonServiceImpl();
    private DefaultComboBoxModel dfcbNv = new DefaultComboBoxModel();
    private NhanVienServiceImpl nhanVienService = new NhanVienServiceImpl();
    private List<NhanVien> listNhanViens = new ArrayList<>();
    private List<HoaDon> listHoaDons = new ArrayList<>();
    private List<SanPhamViewModel> listSanPhams = new ArrayList<>();
    private List<ChiTietSanPham> listChiTietSP = new ArrayList<>();
    private ChiTietSanPhamServiceImpl chiTietSpService = new ChiTietSanPhamServiceImpl();
    private List<HoaDonChiTiet> listHoaDonCTs = new ArrayList<>();
    private List<GioHangModel> listGioHangS = new ArrayList<>();
    private HoaDonChiTietServiceImpl hoaDonChiTietService = new HoaDonChiTietServiceImpl();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private BanHangServiceImpl banHangService = new BanHangServiceImpl();

    /**
     * Creates new form ViewBanHang
     */
    public ViewBanHang() {
        initComponents();
        tbHoaDon.setModel(dtmHoaDon);
        tbGioHang.setModel(dtmGioHang);
        tbSanPham.setModel(dtmSanPham);
        cbbMaNv.setModel(dfcbNv);
        String headerHD[] = {"STT", "Mã HĐ", "Ngày tạo", "Tên NV", "Tình trạng"};
        String headerGH[] = {"STT", "Mã SP", "Tên SP", "Số lượng", "Đơn giá", "Thành tiền"};
        String headerSP[] = {"STT", "Mã SP", "Tên SP", "Năm bảo hành", "Mô tả", "SL SP", "Giá nhập", "Giá bán"};
        dtmHoaDon.setColumnIdentifiers(headerHD);
        dtmGioHang.setColumnIdentifiers(headerGH);
        dtmSanPham.setColumnIdentifiers(headerSP);
        listHoaDons = hoaDonService.getAll();
        loadDataHoaDon(listHoaDons);
        listChiTietSP = chiTietSpService.getAll();
        listSanPhams = banHangService.getAll();
        showDataSanPham(listSanPhams);
        listNhanViens = nhanVienService.getAll();
        listNhanViens.forEach(nhanVien -> cbbMaNv.addItem(nhanVien.getTen()));
        txtMaHD.setEditable(false);
        txtNgayTao.setEditable(false);
        txtTongTien.setText(String.valueOf(0));
        txtTienThua.setEditable(false);
        txtTongTien.setEditable(false);
    }

    private void loadDataHoaDon(List<HoaDon> listHoaDons) {
        dtmHoaDon.setRowCount(0);
        int i = 0;
        for (HoaDon listHoaDon : listHoaDons) {
            i++;
            dtmHoaDon.addRow(listHoaDon.todataRowHoaDon(i));
        }
    }

    private void showDataSanPham(List<SanPhamViewModel> listSanPhams) {
        dtmSanPham.setRowCount(0);
        int i = 0;
        for (SanPhamViewModel listSanPham : listSanPhams) {
            i++;
            dtmSanPham.addRow(listSanPham.todataRowSanPham(i));
        }

    }

    private void showDataGioHang(List<GioHangModel> listGioHangS) {
        int i = 0;
        dtmGioHang.setRowCount(0);
        for (GioHangModel gh : listGioHangS) {
            i++;
            dtmGioHang.addRow(gh.todataRow(i));
        }

    }

    private void fillData() {
        int row = tbHoaDon.getSelectedRow();
        HoaDon hd = listHoaDons.get(row);
        String date = dateFormat.format(hd.getNgayTao());
        txtMaHD.setText(hd.getMa());
        txtNgayTao.setText(date);
        cbbMaNv.setSelectedItem(hd.getNhanVien().getTen());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnTaoHoaDon = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHoaDon = new javax.swing.JTable();
        radioTatCa = new javax.swing.JRadioButton();
        radioChoThanhToan = new javax.swing.JRadioButton();
        radioDaHuy = new javax.swing.JRadioButton();
        radioDaThanhToan = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbGioHang = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbSanPham = new javax.swing.JTable();
        txtTimKiem = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();
        txtMaHD = new javax.swing.JTextField();
        txtNgayTao = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        txtTienKhachDua = new javax.swing.JTextField();
        txtTienThua = new javax.swing.JTextField();
        cbbMaNv = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnTaoHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTaoHoaDon.setText("Tạo Hóa Đơn");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        tbHoaDon.setModel(new javax.swing.table.DefaultTableModel(
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
        tbHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbHoaDon);

        buttonGroup1.add(radioTatCa);
        radioTatCa.setSelected(true);
        radioTatCa.setText("Tất cả");
        radioTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioTatCaActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioChoThanhToan);
        radioChoThanhToan.setText("Chờ thanh toán");
        radioChoThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioChoThanhToanActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioDaHuy);
        radioDaHuy.setText("Đã hủy");
        radioDaHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDaHuyActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioDaThanhToan);
        radioDaThanhToan.setText("Đã thanh toán");
        radioDaThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDaThanhToanActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        tbGioHang.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbGioHang);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Giỏ Hàng");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        tbSanPham.setModel(new javax.swing.table.DefaultTableModel(
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
        tbSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSanPhamMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbSanPham);

        txtTimKiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Sản phẩm");

        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel4.setText("Mã HD");

        jLabel5.setText("Ngày Tạo");

        jLabel6.setText("Tên NV");

        jLabel7.setText("Tổng Tiền");

        jLabel8.setText("Tiền khách đưa");

        jLabel9.setText("Tiền thừa");

        btnThanhToan.setBackground(new java.awt.Color(0, 204, 0));
        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        txtTienKhachDua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienKhachDuaActionPerformed(evt);
            }
        });

        cbbMaNv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtNgayTao)
                        .addComponent(txtTongTien)
                        .addComponent(txtTienThua, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                        .addComponent(txtTienKhachDua)
                        .addComponent(cbbMaNv, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThanhToan)
                .addGap(149, 149, 149))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbbMaNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnThanhToan)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Hóa Đơn");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(btnTaoHoaDon)
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radioTatCa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(radioChoThanhToan)
                                .addGap(41, 41, 41)
                                .addComponent(radioDaHuy)
                                .addGap(41, 41, 41)
                                .addComponent(radioDaThanhToan))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radioTatCa)
                            .addComponent(radioChoThanhToan)
                            .addComponent(radioDaHuy)
                            .addComponent(radioDaThanhToan)
                            .addComponent(jLabel3))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTaoHoaDon)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 30, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(285, 285, 285))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void radioTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioTatCaActionPerformed
        // TODO add your handling code here:
        listHoaDons = hoaDonService.getAll();
        loadDataHoaDon(listHoaDons);
    }//GEN-LAST:event_radioTatCaActionPerformed

    private void radioChoThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioChoThanhToanActionPerformed
        // TODO add your handling code here:
        listHoaDons = hoaDonService.getAllTinhTrang(1);
        loadDataHoaDon(listHoaDons);
    }//GEN-LAST:event_radioChoThanhToanActionPerformed

    private void radioDaHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDaHuyActionPerformed
        // TODO add your handling code here:
        listHoaDons = hoaDonService.getAllTinhTrang(0);
        loadDataHoaDon(listHoaDons);
    }//GEN-LAST:event_radioDaHuyActionPerformed

    private void radioDaThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDaThanhToanActionPerformed
        // TODO add your handling code here:
        listHoaDons = hoaDonService.getAllTinhTrang(3);
        loadDataHoaDon(listHoaDons);
    }//GEN-LAST:event_radioDaThanhToanActionPerformed

    private void tbHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHoaDonMouseClicked
        // TODO add your handling code here:
        int row = tbHoaDon.getSelectedRow();
        HoaDon hd = listHoaDons.get(row);
        String idHd = hd.getId();
        listHoaDonCTs = hoaDonChiTietService.getOneHoaDonCT(idHd);
        listGioHangS = banHangService.getAllId(idHd);
        showDataGioHang(listGioHangS);
        txtTongTien.setText(String.valueOf(0));

        if (hd.getTinhTrang() == 1) {
            btnThanhToan.setEnabled(true);
        } else {
            btnThanhToan.setEnabled(false);
        }
        for (GioHangModel gh : listGioHangS) {
            BigDecimal a = new BigDecimal(txtTongTien.getText());
            BigDecimal tongTien2 = BigDecimal.ZERO;
            BigDecimal tongTien1 = gh.getDonGia().multiply(BigDecimal.valueOf(gh.getSoLuong()));
            tongTien2 = tongTien2.add(tongTien1).add(a);
            txtTongTien.setText(String.valueOf(tongTien2));
        }
        fillData();
        txtTienKhachDua.setText("");
        txtTienThua.setText("");
    }//GEN-LAST:event_tbHoaDonMouseClicked

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        // TODO add your handling code here:
//        Random random = new Random();
//        int x = random.nextInt(9999);
//        Date now = new Date();
//        String id = "NV2";
//        NhanVien nv = nhanVienService.getOne(id);
//        HoaDon hd = new HoaDon(nv, "HD" + String.valueOf(x), now, 1);
//        hoaDonService.add(hd);
//        listHoaDons = hoaDonService.getAll();
//        loadDataHoaDon(listHoaDons);
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void txtTimKiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemCaretUpdate
        // TODO add your handling code here:
        String ten = txtTimKiem.getText();
        listSanPhams = banHangService.getAll();
        listSanPhams = chiTietSpService.search(listSanPhams, ten);
        showDataSanPham(listSanPhams);
    }//GEN-LAST:event_txtTimKiemCaretUpdate

    private void tbSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSanPhamMouseClicked
        // TODO add your handling code here:
        GioHangModel gh = new GioHangModel();
        int row = tbSanPham.getSelectedRow();
        SanPhamViewModel sp = listSanPhams.get(row);
        String soLuong = JOptionPane.showInputDialog("Mời bạn nhập số lượng: ");
        if (soLuong != null) {
            if (!soLuong.matches("[0-9]+")) {
                JOptionPane.showMessageDialog(this, "Nhập đúng định dạng");
            } else if (Integer.valueOf(soLuong) > sp.getSoLuong()) {
                JOptionPane.showMessageDialog(this, "Số lượng vượt quá -.-");
            } else {
                gh.setSoLuong(Integer.valueOf(soLuong));
                gh.setMaSP(sp.getMaSP());
                gh.setTenSP(sp.getTenSP());
                gh.setDonGia(sp.getGiaBan());
                listGioHangS.add(gh);
                showDataGioHang(listGioHangS);
                sp.setSoLuong(sp.getSoLuong() - Integer.valueOf(soLuong));
                showDataSanPham(listSanPhams);
                //tong tien
                BigDecimal a = new BigDecimal(txtTongTien.getText());
                BigDecimal tongTien2 = BigDecimal.ZERO;
                BigDecimal tongTien1 = gh.getDonGia().multiply(BigDecimal.valueOf(Integer.valueOf(soLuong)));
                tongTien2 = tongTien2.add(tongTien1).add(a);
                txtTongTien.setText(String.valueOf(tongTien2));
////               Tao hoaDonChiTiet  
                String maHd = txtMaHD.getText();
                HoaDon hd = hoaDonService.getOneMa(maHd);
                String idCtsp = sp.getId();
                ChiTietSanPham ctsp = chiTietSpService.getOne(idCtsp);
                int soLuong1 = Integer.valueOf(soLuong);
                BigDecimal donGia = sp.getGiaBan();
                HoaDonChiTiet hdct = new HoaDonChiTiet(hd, ctsp, soLuong1, donGia);
                hoaDonChiTietService.add(hdct);
            }
        }
    }//GEN-LAST:event_tbSanPhamMouseClicked

    private void txtTienKhachDuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienKhachDuaActionPerformed
        // TODO add your handling code here:
        BigDecimal tienKhachDua = new BigDecimal(txtTienKhachDua.getText());
        BigDecimal tongTien = new BigDecimal(txtTongTien.getText());
        if (tienKhachDua.compareTo(tongTien) < 0) {
            JOptionPane.showMessageDialog(this, "Thiếu tiền!!");
            btnThanhToan.setEnabled(false);
        } else {
            BigDecimal tienThua = (tienKhachDua).subtract(tongTien);
            txtTienThua.setText(String.valueOf(tienThua));
            btnThanhToan.setEnabled(true);
        }
    }//GEN-LAST:event_txtTienKhachDuaActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        if (txtTienKhachDua.getText().equals("") || txtTienKhachDua.getText().matches("\\s+")) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin");
            txtTienKhachDua.setText("");
        } else {
            String maHd = txtMaHD.getText();
            HoaDon hd = hoaDonService.getOneMa(maHd);
            hd.setTinhTrang(3);
            hoaDonService.updateTinhTrang(hd, maHd);
            for (SanPhamViewModel sp : listSanPhams) {
                String id = sp.getId();
                ChiTietSanPham ctsp = new ChiTietSanPham(sp.getSoLuong());
                chiTietSpService.updateSoLuong(ctsp, id);
            }
            listHoaDons = hoaDonService.getAll();
            loadDataHoaDon(listHoaDons);
            btnThanhToan.setEnabled(false);
        }

    }//GEN-LAST:event_btnThanhToanActionPerformed

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
            java.util.logging.Logger.getLogger(ViewBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewBanHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbMaNv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton radioChoThanhToan;
    private javax.swing.JRadioButton radioDaHuy;
    private javax.swing.JRadioButton radioDaThanhToan;
    private javax.swing.JRadioButton radioTatCa;
    private javax.swing.JTable tbGioHang;
    private javax.swing.JTable tbHoaDon;
    private javax.swing.JTable tbSanPham;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTienThua;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
