/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerAsset;
import controller.KelolaAsset;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import main.MenuUtama;
import static main.MenuUtama.namaPetugas;
import model.Asset;
import model.Petugas;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Java
 */
public class ValueAsset extends javax.swing.JFrame {

    static List<Asset> records = new ArrayList<Asset>();
    static ControllerAsset control;
    Petugas petugas = new Petugas();

    public ValueAsset() {

        initComponents();
        control = new KelolaAsset();
        this.statusAwal();
        kondisi();
        setExtendedState(MAXIMIZED_BOTH);
        update.setEnabled(false);
        detail.setEnabled(false);
        

        tabel.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int row = tabel.getSelectedRow();
            }
        });
    }

    void kondisi() {
        if (namaPetugas.getText().equals("Tata Usaha")) {
            tambah.setVisible(false);
            update.setVisible(false);
            hapus.setVisible(false);
            laporan.setVisible(false);
            print.setVisible(false);
        } else if (namaPetugas.getText().equals("Petugas Logistik")) {
            hapus.setVisible(false);
            r.setVisible(true);
            laporan.setVisible(false);
            print.setVisible(false);
            
        }else if (namaPetugas.getText().equals("Petugas Lapangan")) {
            hapus.setVisible(false);
            update.setVisible(false);
            tambah.setVisible(false);
            laporan.setVisible(false);
            print.setVisible(false);
            
        }else if (namaPetugas.getText().equals("Petugas Sarana")){
            update.setVisible(false);
            tambah.setVisible(false);
        }
        
    }

    static void isiTabel() {
        Object data[][] = new Object[records.size()][10];
        int x = 0;
        for (Asset asset : records) {
            data[x][0] = asset.getIdAsset();
            data[x][1] = asset.getJenisAsset();
            data[x][2] = asset.getNama();
            data[x][4] = asset.getTanggal();
            data[x][3] = asset.getWarnaAsset();
            data[x][5] = asset.getHarga();
            data[x][6] = asset.getMarkAsset();
            data[x][7] = asset.getLokasi();
            data[x][8] = asset.getNamaPetugas();
            x++;

        }
        String judul[] = {"ID", "Jenis", "Nama", "Warna", "Tanggal", "Harga", "Merk", "Lokasi", "Nama Petugas"};
        tabel.setModel(new DefaultTableModel(data, judul));
        jScrollPane1.setViewportView(tabel);
    }

    static void loadAsset() {
        try {
            records = control.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(ValueAsset.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void statusAwal() {
        loadAsset();
        isiTabel();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        tambah = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cari = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        update = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        detail = new javax.swing.JButton();
        print = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        halamanUtama = new javax.swing.JMenuItem();
        as = new javax.swing.JMenu();
        asset = new javax.swing.JMenuItem();
        r = new javax.swing.JMenu();
        ruangan = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        perawatan = new javax.swing.JMenuItem();
        laporan = new javax.swing.JMenuItem();
        help = new javax.swing.JMenu();
        about = new javax.swing.JMenuItem();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Manajemen Asset Sekolah");
        setIconImage(new ImageIcon(getClass().getResource("../Icons/Diamond.png")).getImage());

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/add_16.png"))); // NOI18N
        tambah.setText("Tambah");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/zoom_16.png"))); // NOI18N

        cari.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cariKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel2.setForeground(java.awt.SystemColor.textHighlight);
        jLabel2.setText("Pengelolaan Asset");

        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/arrow_up_16.png"))); // NOI18N
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/delete_16.png"))); // NOI18N
        hapus.setText("Delete");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        detail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/info_16.png"))); // NOI18N
        detail.setText("Detail");
        detail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailActionPerformed(evt);
            }
        });

        print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/print_16_1.png"))); // NOI18N
        print.setText("Print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/house.png"))); // NOI18N
        jMenu1.setText("Halaman Utama");

        halamanUtama.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        halamanUtama.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/home_page.png"))); // NOI18N
        halamanUtama.setText("Halaman Utama");
        halamanUtama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                halamanUtamaActionPerformed(evt);
            }
        });
        jMenu1.add(halamanUtama);

        jMenuBar1.add(jMenu1);

        as.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/box_closed.png"))); // NOI18N
        as.setText("Asset");

        asset.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        asset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/box_open.png"))); // NOI18N
        asset.setText("Asset");
        asset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assetActionPerformed(evt);
            }
        });
        as.add(asset);

        jMenuBar1.add(as);

        r.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/door.png"))); // NOI18N
        r.setText("Ruangan");

        ruangan.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        ruangan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/door_open.png"))); // NOI18N
        ruangan.setText("Ruangan");
        ruangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ruanganActionPerformed(evt);
            }
        });
        r.add(ruangan);

        jMenuBar1.add(r);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/toolbox.png"))); // NOI18N
        jMenu6.setText("Perawatan");

        perawatan.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        perawatan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/wrench.png"))); // NOI18N
        perawatan.setText("Perawatan");
        perawatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perawatanActionPerformed(evt);
            }
        });
        jMenu6.add(perawatan);

        laporan.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        laporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/paste_plain.png"))); // NOI18N
        laporan.setText("Laporan");
        laporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laporanActionPerformed(evt);
            }
        });
        jMenu6.add(laporan);

        jMenuBar1.add(jMenu6);

        help.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/help.png"))); // NOI18N
        help.setText("Help");

        about.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        about.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/sub-help.png"))); // NOI18N
        about.setText("About");
        about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutActionPerformed(evt);
            }
        });
        help.add(about);

        jMenuBar1.add(help);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(print)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tambah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(update)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hapus)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cari, javax.swing.GroupLayout.Alignment.LEADING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambah)
                    .addComponent(update)
                    .addComponent(hapus)
                    .addComponent(detail)
                    .addComponent(print))
                .addContainerGap(178, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        TambahAsset tambah = new TambahAsset();
        tambah.setVisible(true);
        tambah.petugas.setText(namaPetugas.getText());
    }//GEN-LAST:event_tambahActionPerformed

    private void halamanUtamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_halamanUtamaActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        MenuUtama utama = new MenuUtama();
        utama.setVisible(true);
    }//GEN-LAST:event_halamanUtamaActionPerformed

    private void assetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assetActionPerformed
        // TODO add your handling code here:
        this.setVisible(true);
    }//GEN-LAST:event_assetActionPerformed

    private void ruanganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ruanganActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        ValueRuangan ruangan = new ValueRuangan();
        ruangan.setVisible(true);
        
    }//GEN-LAST:event_ruanganActionPerformed

    private void perawatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perawatanActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        ValuePerawatan perawatan = new ValuePerawatan();
        perawatan.setVisible(true);
    }//GEN-LAST:event_perawatanActionPerformed

    private void laporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laporanActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Laporan laporan = new Laporan();
        laporan.setVisible(true);
    }//GEN-LAST:event_laporanActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
        UpdateAsset t = new UpdateAsset();
        Asset b = records.get(tabel.getSelectedRow());
        t.id.setText(String.valueOf(b.getIdAsset()));
        t.jenis.setText(b.getJenisAsset());
        t.nama.setText(b.getNama());
        t.merk.setText(b.getMarkAsset());
        t.harga.setText(String.valueOf(b.getHarga()));
        t.lokasi.setText(b.getLokasi());
        t.warna.setText(b.getWarnaAsset());
        t.petugas.setText(namaPetugas.getText());
        t.setVisible(true);

    }//GEN-LAST:event_updateActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
//         TODO add your handling code here  
        try {
            // TODO add your handling code here:
            if (JOptionPane.showConfirmDialog(this, "Anda yakin untuk Menghapus data ?", "Konfirmasi", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                Asset b = records.get(tabel.getSelectedRow());
                control.delete(b.getIdAsset());
                this.statusAwal();
            } else {
                this.loadAsset();
                this.isiTabel();
            }
        } catch (SQLException ex) {
            Logger.getLogger(TambahAsset.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_hapusActionPerformed

    private void detailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailActionPerformed
        // TODO add your handling code here:
        RincianAsset r = new RincianAsset(this, rootPaneCheckingEnabled);
        Asset b = records.get(tabel.getSelectedRow());
        r.id.setText(String.valueOf(b.getIdAsset()));
        r.jenis.setText(String.valueOf(b.getJenisAsset()));
        r.nama.setText(b.getNama());
        r.merk.setText(b.getMarkAsset());
        r.pembelian.setText(String.valueOf(b.getTanggal()));
        r.harga.setText(String.valueOf(b.getHarga()));
        r.lokasi.setText(b.getLokasi());
        r.warna.setText(b.getWarnaAsset());
        r.petugas.setText(b.getNamaPetugas());
        r.setVisible(true);
    }//GEN-LAST:event_detailActionPerformed

    private void cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariKeyReleased
        // TODO add your handling code here:
        if (cari.getText().equals("")) {
            this.statusAwal();
        } else {
            try {
                // TODO add your handling code here:
                records = control.getSearch(cari.getText());
                this.isiTabel();
            } catch (SQLException ex) {
                Logger.getLogger(ValueAsset.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_cariKeyReleased

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        // TODO add your handling code here:
        try {
            JasperPrint jasper = JasperFillManager.fillReport(
                    "src/Report/Manajemen_Asset.jasper", null,
                    koneksi.Connection.getConnection());
            JasperViewer.viewReport(jasper, false);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_printActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        // TODO add your handling code here:
        update.setEnabled(true);
        detail.setEnabled(true);
        
    }//GEN-LAST:event_tabelMouseClicked

    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutActionPerformed
        // TODO add your handling code here:
        About about = new About();
        about.setVisible(true);
    }//GEN-LAST:event_aboutActionPerformed
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new ValueAsset().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem about;
    public static javax.swing.JMenu as;
    public static javax.swing.JMenuItem asset;
    private javax.swing.JTextField cari;
    private javax.swing.JButton detail;
    public static javax.swing.JMenuItem halamanUtama;
    public static javax.swing.JButton hapus;
    private javax.swing.JMenu help;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    public static javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JMenuItem laporan;
    public static javax.swing.JMenuItem perawatan;
    private javax.swing.JButton print;
    public static javax.swing.JMenu r;
    public static javax.swing.JMenuItem ruangan;
    public static javax.swing.JTable tabel;
    public static javax.swing.JButton tambah;
    public static javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
