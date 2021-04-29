package form;

import java.awt.HeadlessException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmMobil extends javax.swing.JFrame {
private Connection con;
private Statement st;
private ResultSet RsMobil;
private String sql="";

private String id,mobil,merk,bm,status;
private int harga;


    public FrmMobil() {
        initComponents();
        KoneksiMobil();
        tampildata(sql);
    }


    private void KoneksiMobil(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rental_mobil","root","");
            System.out.println("Koneksi Berhasil");
            JOptionPane.showMessageDialog(null,"Selamat Datang Di Rental Mobil");
        } catch (HeadlessException | ClassNotFoundException | SQLException e){
            System.out.println("Koneksi Gagal"+e);
        }
    }

    private void tampildata (String sql){
        DefaultTableModel datalist = new DefaultTableModel();
        datalist.addColumn("No");
        datalist.addColumn("ID MOBIL");
        datalist.addColumn("NAMA MOBIL");
        datalist.addColumn("MERK MOBIL");
        datalist.addColumn("BM MOBIL");
        datalist.addColumn("HARGA RENTAL");
        datalist.addColumn("STATUS");
        try {
            int i = 1;
            st=con.createStatement();
            RsMobil=st.executeQuery("select * from tb_mobil");
            while(RsMobil.next())
                datalist.addRow(new Object[]{
                    (""+i++),
                    RsMobil.getString(1), RsMobil.getString(2),
                    RsMobil.getString(3), RsMobil.getString(4),
                    RsMobil.getString(5), RsMobil.getString(6),
                }});
                TABEL.setModel(datalist);
    } catch (Exception e){
        JOptionPane.showMessageDialog(null, "Gagal Tampil \n"+e.getMessage());
}

    private void bersih(){
        Txt_id_mobil.setText("");
        Txt_nama_mobil.setText("");
        Txt_merek_mobil.setText("");
        Txt_bm_mobil.setText("");
        Txt_harga_rental.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Txt_id_mobil = new javax.swing.JTextField();
        cmb_a = new javax.swing.JComboBox<>();
        BTN_SIMPAN = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABEL = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        Txt_nama_mobil = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Txt_bm_mobil = new javax.swing.JTextField();
        BTN_SIMPAN1 = new javax.swing.JButton();
        BTN_SIMPAN2 = new javax.swing.JButton();
        BTN_SIMPAN3 = new javax.swing.JButton();
        BTN_SIMPAN4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Txt_merek_mobil = new javax.swing.JTextField();
        Txt_harga_rental = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("ID_MOBIL");

        cmb_a.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pilih", "ready", "dll" }));

        BTN_SIMPAN.setText("BATAL");

        TABEL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID MOBIL", "NAMA MOBIL", "MEREK MOBIL", "BM MOBIL", "HARGA RENTAL", "STATUS"
            }
        ));
        jScrollPane1.setViewportView(TABEL);

        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("NAMA MOBIL");

        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("MEREK MOBIL");
        jLabel3.setToolTipText("");

        BTN_SIMPAN1.setText("EDIT");

        BTN_SIMPAN2.setText("HAPUS");

        BTN_SIMPAN3.setText("SIMPAN");
        BTN_SIMPAN3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_SIMPAN3ActionPerformed(evt);
            }
        });

        BTN_SIMPAN4.setText("KELUAR");

        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("HARGA RENTAL");

        Txt_merek_mobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_merek_mobilActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("BM MOBIL");

        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("STATUS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Txt_id_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Txt_nama_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Txt_merek_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cmb_a, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Txt_harga_rental, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Txt_bm_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(BTN_SIMPAN3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BTN_SIMPAN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BTN_SIMPAN4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BTN_SIMPAN2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BTN_SIMPAN1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
                        .addGap(41, 41, 41))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(51, 51, 51))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(Txt_nama_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(30, 30, 30)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(Txt_merek_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(28, 28, 28)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Txt_bm_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addGap(28, 28, 28)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Txt_harga_rental, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(cmb_a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(Txt_id_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(BTN_SIMPAN3)
                        .addGap(18, 18, 18)
                        .addComponent(BTN_SIMPAN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BTN_SIMPAN1)
                        .addGap(18, 18, 18)
                        .addComponent(BTN_SIMPAN2)
                        .addGap(18, 18, 18)
                        .addComponent(BTN_SIMPAN4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        jMenu1.setText("Master");

        jMenu4.setText("Mobil");
        jMenu1.add(jMenu4);

        jMenu5.setText("Penyewa");
        jMenu1.add(jMenu5);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Transaksi");

        jMenu6.setText("Rental");
        jMenu2.add(jMenu6);

        jMenu7.setText("Pengembalian");
        jMenu2.add(jMenu7);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Keluar");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Txt_merek_mobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_merek_mobilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_merek_mobilActionPerformed

    private void BTN_SIMPAN3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_SIMPAN3ActionPerformed
        id=String.valueOf(Txt_id_mobil.getText());
        mobil=String.valueOf(Txt_nama_mobil.getText());
        merk=String.valueOf(Txt_merek_mobil.getText());
        bm=String.valueOf(Txt_bm_mobil.getText());
        harga=Integer.parseInt(Txt_harga_rental.getText());
        status=String.valueOf(cmb_a.getSelectedItem());
        try{
            sql="INSERT INTO tb_mobil(id_mobil,nama_mobil, "
                    + "merek_mobil,bm_mobil,harga_rental, "
                    + "status)value"
                    + "'"+ id +"','"+ mobil +"',"+ merk +"','"+ bm +"',"
                    + "'"+ harga +"','"+ status +"')";
            st=con
        }
        
    }//GEN-LAST:event_BTN_SIMPAN3ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMobil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMobil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMobil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMobil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMobil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_SIMPAN;
    private javax.swing.JButton BTN_SIMPAN1;
    private javax.swing.JButton BTN_SIMPAN2;
    private javax.swing.JButton BTN_SIMPAN3;
    private javax.swing.JButton BTN_SIMPAN4;
    private javax.swing.JTable TABEL;
    private javax.swing.JTextField Txt_bm_mobil;
    private javax.swing.JTextField Txt_harga_rental;
    private javax.swing.JTextField Txt_id_mobil;
    private javax.swing.JTextField Txt_merek_mobil;
    private javax.swing.JTextField Txt_nama_mobil;
    private javax.swing.JComboBox<String> cmb_a;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
