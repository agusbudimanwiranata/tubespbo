package form;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmInfoMobil extends javax.swing.JFrame {
public static Connection con;
public static Statement st;
private ResultSet RsInfo;
private String sql="";

private String status;
private String model;
    
    public FrmInfoMobil() {
        initComponents();
        KoneksiInfo();
        tampilData(sql);
        
    }

   private void KoneksiInfo(){
       try{
          String url = "jdbc:mysql://localhost:3306/rental_mobil";
          String user = "root";
          String pass = "";
          Class.forName("com.mysql.jdbc.Driver");
          con =DriverManager.getConnection(url,user,pass);
          st=con.createStatement();
          System.out.println("Koneksi Berhasil");
          JOptionPane.showMessageDialog(null,"SELAMAT DATANG DI RENTAL MOBIL");
      } catch (Exception e){
          System.out.println("Koneksi Gagal \n"+e.getMessage());
      }
}
   
       private void tampilData(String sql){
        DefaultTableModel datalist = new DefaultTableModel();
        datalist.addColumn("No");
        datalist.addColumn("ID MOBIL");
        datalist.addColumn("NAMA MOBIL");
        datalist.addColumn("MERK MOBIL");
        datalist.addColumn("BM MOBIL");
        datalist.addColumn("HARGA RENTAL");
        datalist.addColumn("STATUS");
        try{
            int i = 1;
            st=con.createStatement();
            RsInfo = st.executeQuery("select * from tb_mobil");
            while(RsInfo.next())
                datalist.addRow(new Object[]{
                    (""+i++),
                    RsInfo.getString(1), RsInfo.getString(2),
                    RsInfo.getString(3), RsInfo.getString(4),
                    RsInfo.getString(5), RsInfo.getString(6)
                });
            TABEL.setModel(datalist);
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Gagal Tampil \n"+e.getMessage());
        }
    }
     
    private void cariStatus(){
        DefaultTableModel datalist = new DefaultTableModel();
        datalist.addColumn("No");
        datalist.addColumn("ID MOBIL");
        datalist.addColumn("NAMA MOBIL");
        datalist.addColumn("MERK MOBIL");
        datalist.addColumn("BM MOBIL");
        datalist.addColumn("HARGA RENTAL");
        datalist.addColumn("STATUS");
        status = (String) combo_status.getSelectedItem();
        
        if (combo_status.getSelectedItem().equals("PILIH")){
            JOptionPane.showMessageDialog(null, "MAAF STATUS BELUM TERPILIH");
        }
        else if(combo_status.getSelectedItem().equals("READY")){
                try{
            
                    int i = 1;
                    st=con.createStatement();
                    RsInfo = st.executeQuery("SELECT * FROM tb_mobil WHERE status ='"+ status +"'");
                    while(RsInfo.next())
                        datalist.addRow(new Object[]{
                        (""+i++),
                        RsInfo.getString(1), RsInfo.getString(2),
                        RsInfo.getString(3), RsInfo.getString(4),
                        RsInfo.getString(5), RsInfo.getString(6)
                    });
                TABEL.setModel(datalist);     
                } 
                    catch (Exception e){
                        JOptionPane.showMessageDialog(null, "Gagal Tampil \n"+e.getMessage());
                    }
            } 
            else if(combo_status.getSelectedItem().equals("NOTREADY")){
                try{
                    int i = 1;
                    st=con.createStatement();
                    RsInfo = st.executeQuery("SELECT * FROM tb_mobil WHERE status ='"+ status +"'");
                    while(RsInfo.next())
                        datalist.addRow(new Object[]{
                        (""+i++),
                        RsInfo.getString(1), RsInfo.getString(2),
                        RsInfo.getString(3), RsInfo.getString(4),
                        RsInfo.getString(5), RsInfo.getString(6)
                    });
                TABEL.setModel(datalist);     
                } 
                    catch (Exception e){
                        JOptionPane.showMessageDialog(null, "Gagal Tampil \n"+e.getMessage());
                    }
            }
            
            else if(combo_status.getSelectedItem().equals("SERVICE")){
                try{
                    int i = 1;
                    st=con.createStatement();
                    RsInfo = st.executeQuery("SELECT * FROM tb_mobil WHERE status ='"+ status +"'");
                    while(RsInfo.next())
                        datalist.addRow(new Object[]{
                        (""+i++),
                        RsInfo.getString(1), RsInfo.getString(2),
                        RsInfo.getString(3), RsInfo.getString(4),
                        RsInfo.getString(5), RsInfo.getString(6)
                    });
                TABEL.setModel(datalist);     
                } 
                    catch (Exception e){
                        JOptionPane.showMessageDialog(null, "Gagal Tampil \n"+e.getMessage());
                    }
            }
            }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABEL = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        BTN_dashboard = new javax.swing.JButton();
        BTN_data_mobil = new javax.swing.JButton();
        BTN_data_penyewa = new javax.swing.JButton();
        BTN_rental_mobil = new javax.swing.JButton();
        BTN_pengembalian_mobil = new javax.swing.JButton();
        BTN_keluar = new javax.swing.JButton();
        BTN_info_mobil = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        combo_status = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        TABEL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID MOBIL", "NAMA MOBIL", "MEREK MOBIL", "BM MOBIL", "HARGA RENTAL", "STATUS"
            }
        ));
        jScrollPane1.setViewportView(TABEL);

        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Status Mobil");

        jPanel4.setBackground(new java.awt.Color(0, 0, 102));

        BTN_dashboard.setBackground(new java.awt.Color(51, 153, 255));
        BTN_dashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PNG/home 20x20.png"))); // NOI18N
        BTN_dashboard.setText("DASHBOARD");
        BTN_dashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_dashboardActionPerformed(evt);
            }
        });

        BTN_data_mobil.setBackground(new java.awt.Color(51, 153, 255));
        BTN_data_mobil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PNG/mobil 40x40.png"))); // NOI18N
        BTN_data_mobil.setText("DATA MOBIL");
        BTN_data_mobil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_data_mobilMouseClicked(evt);
            }
        });
        BTN_data_mobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_data_mobilActionPerformed(evt);
            }
        });

        BTN_data_penyewa.setBackground(new java.awt.Color(51, 153, 255));
        BTN_data_penyewa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PNG/user 40x40.png"))); // NOI18N
        BTN_data_penyewa.setText("Data Penyewa");
        BTN_data_penyewa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_data_penyewaMouseClicked(evt);
            }
        });

        BTN_rental_mobil.setBackground(new java.awt.Color(51, 153, 255));
        BTN_rental_mobil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PNG/mobil1 (2).png"))); // NOI18N
        BTN_rental_mobil.setText("Rental Mobil");
        BTN_rental_mobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_rental_mobilActionPerformed(evt);
            }
        });

        BTN_pengembalian_mobil.setBackground(new java.awt.Color(51, 153, 255));
        BTN_pengembalian_mobil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PNG/mobil2.png"))); // NOI18N
        BTN_pengembalian_mobil.setText("Pengembalian Mobil");
        BTN_pengembalian_mobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_pengembalian_mobilActionPerformed(evt);
            }
        });

        BTN_keluar.setBackground(new java.awt.Color(51, 153, 255));
        BTN_keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PNG/turn off.png"))); // NOI18N
        BTN_keluar.setText("Keluar");
        BTN_keluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_keluarMouseClicked(evt);
            }
        });
        BTN_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_keluarActionPerformed(evt);
            }
        });

        BTN_info_mobil.setBackground(new java.awt.Color(51, 153, 255));
        BTN_info_mobil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PNG/png-transparent-japanese-industrial-standards-logo-technical-standard-industry-info-ico-emblem-text-logo.png"))); // NOI18N
        BTN_info_mobil.setText("Informasi Mobil");
        BTN_info_mobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_info_mobilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(BTN_data_penyewa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                    .addComponent(BTN_dashboard, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTN_data_mobil, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BTN_rental_mobil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_pengembalian_mobil, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BTN_info_mobil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(BTN_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_rental_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BTN_pengembalian_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_data_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_info_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_data_penyewa, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(BTN_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel7.setText("FORM INFORMASI MOBIL");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(jLabel7)
                .addContainerGap(184, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(23, 23, 23))
        );

        combo_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH", "READY", "NOTREADY", "SERVICE" }));
        combo_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_statusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel6)
                        .addGap(37, 37, 37)
                        .addComponent(combo_status, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(combo_status, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_info_mobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_info_mobilActionPerformed

    }//GEN-LAST:event_BTN_info_mobilActionPerformed

    private void BTN_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_keluarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_BTN_keluarActionPerformed

    private void BTN_keluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_keluarMouseClicked

    }//GEN-LAST:event_BTN_keluarMouseClicked

    private void BTN_pengembalian_mobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_pengembalian_mobilActionPerformed
        FrmPengembalian pn = new FrmPengembalian ();
        pn.setVisible(true);
        pn.pack();
        pn.setLocationRelativeTo(null);
        pn.setDefaultCloseOperation(FrmInfoMobil.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_BTN_pengembalian_mobilActionPerformed

    private void BTN_rental_mobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_rental_mobilActionPerformed
        FrmMenyewa fm = new FrmMenyewa ();
        fm.setVisible(true);
        fm.pack();
        fm.setLocationRelativeTo(null);
        fm.setDefaultCloseOperation(FrmInfoMobil.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_BTN_rental_mobilActionPerformed

    private void BTN_data_penyewaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_data_penyewaMouseClicked
        Penyewa pm = new Penyewa ();
        pm.setVisible(true);
        pm.pack();
        pm.setLocationRelativeTo(null);
        pm.setDefaultCloseOperation(FrmInfoMobil.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_BTN_data_penyewaMouseClicked

    private void BTN_data_mobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_data_mobilActionPerformed

    }//GEN-LAST:event_BTN_data_mobilActionPerformed

    private void BTN_data_mobilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_data_mobilMouseClicked
        Mobil mb = new Mobil ();
        mb.setVisible(true);
        mb.pack();
        mb.setLocationRelativeTo(null);
        mb.setDefaultCloseOperation(FrmInfoMobil.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_BTN_data_mobilMouseClicked

    private void BTN_dashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_dashboardActionPerformed
        Home hm = new Home ();
        hm.setVisible(true);
        hm.pack();
        hm.setLocationRelativeTo(null);
        hm.setDefaultCloseOperation(FrmInfoMobil.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_BTN_dashboardActionPerformed

    private void combo_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_statusActionPerformed
        cariStatus();
    }//GEN-LAST:event_combo_statusActionPerformed

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
            java.util.logging.Logger.getLogger(FrmInfoMobil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmInfoMobil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmInfoMobil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmInfoMobil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmInfoMobil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_dashboard;
    private javax.swing.JButton BTN_data_mobil;
    private javax.swing.JButton BTN_data_penyewa;
    private javax.swing.JButton BTN_info_mobil;
    private javax.swing.JButton BTN_keluar;
    private javax.swing.JButton BTN_pengembalian_mobil;
    private javax.swing.JButton BTN_rental_mobil;
    private javax.swing.JTable TABEL;
    private javax.swing.JComboBox<String> combo_status;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
