package form;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Penyewa extends javax.swing.JFrame {
public static Connection con;
public static Statement st;
private ResultSet RsPenyewa;
private String sql="";

private String id,penyewa,alamat,no_hp,no_ktp,status;
    public Penyewa() {
        initComponents();
        KoneksiPenyewa();
        tampilData(sql);
    }

private void KoneksiPenyewa(){
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
        datalist.addColumn("ID PENYEWA");
        datalist.addColumn("NAMA PENYEWA");
        datalist.addColumn("ALAMAT PENYEWA");
        datalist.addColumn("NO HP");
        datalist.addColumn("NO KTP");
        datalist.addColumn("STATUS");
        try{
            int i = 1;
            st=con.createStatement();
            RsPenyewa = st.executeQuery("select * from tb_penyewa");
            while(RsPenyewa.next())
                datalist.addRow(new Object[]{
                    (""+i++),
                    RsPenyewa.getString(1), RsPenyewa.getString(2),
                    RsPenyewa.getString(3), RsPenyewa.getString(4),
                    RsPenyewa.getString(5), RsPenyewa.getString(6)
                });
            TABEL.setModel(datalist);
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Gagal Tampil \n"+e.getMessage());
        }
}
    
    
        private void bersih(){
        Txt_id_penyewa.setText("");
        Txt_nama_penyewa.setText("");
        Txt_alamat_penyewa.setText("");
        Txt_no_hp.setText("");
        Txt_no_ktp.setText(""); 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Txt_id_penyewa = new javax.swing.JTextField();
        cmb_a = new javax.swing.JComboBox<>();
        BTN_BATAL = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABEL = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        Txt_nama_penyewa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Txt_alamat_penyewa = new javax.swing.JTextField();
        BTN_EDIT = new javax.swing.JButton();
        BTN_HAPUS = new javax.swing.JButton();
        BTN_SIMPAN = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Txt_no_hp = new javax.swing.JTextField();
        Txt_no_ktp = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        BTN_dashboard = new javax.swing.JButton();
        BTN_data_mobil = new javax.swing.JButton();
        BTN_data_penyewa = new javax.swing.JButton();
        BTN_rental_mobil = new javax.swing.JButton();
        BTN_pengembalian_mobil = new javax.swing.JButton();
        BTN_keluar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("ID Penyewa");

        Txt_id_penyewa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Txt_id_penyewaKeyPressed(evt);
            }
        });

        cmb_a.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH", "READY", "NOTREADY" }));

        BTN_BATAL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PNG/batal.png"))); // NOI18N
        BTN_BATAL.setText("BATAL");
        BTN_BATAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_BATALActionPerformed(evt);
            }
        });

        TABEL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID PENYEWA", "NAMA PENYEWA", "ALAMAT PENYEWA", "NO HP", "NO KTP", "STATUS"
            }
        ));
        jScrollPane1.setViewportView(TABEL);

        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Nama Penyewa");

        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("NO HP");
        jLabel3.setToolTipText("");

        BTN_EDIT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PNG/edit.png"))); // NOI18N
        BTN_EDIT.setText("EDIT");
        BTN_EDIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_EDITActionPerformed(evt);
            }
        });

        BTN_HAPUS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PNG/hapus.png"))); // NOI18N
        BTN_HAPUS.setText("HAPUS");
        BTN_HAPUS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_HAPUSActionPerformed(evt);
            }
        });

        BTN_SIMPAN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PNG/disket.png"))); // NOI18N
        BTN_SIMPAN.setText("SIMPAN");
        BTN_SIMPAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_SIMPANActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("NO KTP");

        Txt_no_hp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_no_hpActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("Alamat Penyewa");

        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Status");

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(BTN_data_penyewa, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                        .addComponent(BTN_rental_mobil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BTN_keluar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BTN_dashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BTN_data_mobil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(BTN_pengembalian_mobil))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(BTN_dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BTN_data_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(BTN_data_penyewa, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(BTN_rental_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(BTN_pengembalian_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(BTN_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel7.setText("FORM DATA PENYEWA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(353, 353, 353)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel7)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PNG/user.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Txt_id_penyewa, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Txt_alamat_penyewa, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Txt_nama_penyewa, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Txt_no_hp, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Txt_no_ktp, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel9))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(cmb_a, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(131, 131, 131))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(BTN_SIMPAN)
                                .addGap(155, 155, 155)
                                .addComponent(BTN_EDIT, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(194, 194, 194)
                                .addComponent(BTN_BATAL, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(183, 183, 183)
                                .addComponent(BTN_HAPUS, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 995, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Txt_id_penyewa, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Txt_nama_penyewa, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(45, 45, 45)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Txt_alamat_penyewa, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(44, 44, 44)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(Txt_no_hp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(54, 54, 54)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(Txt_no_ktp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel9)))
                        .addGap(78, 78, 78))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmb_a, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_SIMPAN)
                    .addComponent(BTN_EDIT)
                    .addComponent(BTN_BATAL)
                    .addComponent(BTN_HAPUS))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Txt_id_penyewaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txt_id_penyewaKeyPressed

        id=Txt_id_penyewa.getText();
        int tekanenter=evt.getKeyCode();
        if (tekanenter==10){
            try{
                sql="select * from tb_penyewa "
                + "where id_penyewa='"+id+"'";
                st=con.createStatement();
                RsPenyewa=st.executeQuery(sql);
                while (RsPenyewa.next()){
                    Txt_nama_penyewa.setText(RsPenyewa.getString("nama_penyewa"));
                    Txt_no_hp.setText(RsPenyewa.getString(3));
                    Txt_alamat_penyewa.setText(RsPenyewa.getString(4));
                    Txt_no_ktp.setText(RsPenyewa.getString(5));
                    cmb_a.setSelectedItem(RsPenyewa.getString(6));
                    JOptionPane.showMessageDialog(null, "Data Ditemukan");
                }
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan \n"
                    +e.getMessage());
                Txt_nama_penyewa.requestFocus();
            }
        }
    }//GEN-LAST:event_Txt_id_penyewaKeyPressed

    private void BTN_BATALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_BATALActionPerformed

        bersih();
    }//GEN-LAST:event_BTN_BATALActionPerformed

    private void BTN_EDITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_EDITActionPerformed
        // TODO add your handling code here:
        id=String.valueOf(Txt_id_penyewa.getText());
        penyewa=String.valueOf(Txt_nama_penyewa.getText());
        alamat=String.valueOf(Txt_no_hp.getText());
        no_hp=String.valueOf(Txt_alamat_penyewa.getText());
        no_ktp=String.valueOf(Txt_no_ktp.getText());
        status=String.valueOf(cmb_a.getSelectedItem());
        try {
            sql="update tb_penyewa set nama_penyewa='"+ penyewa +"',alamat_penyewa='" + alamat +"',no_hp='"+ no_hp +"',no_ktp='"+ no_ktp +"',status='"+ status +"' where id_penyewa = '"+ id +"'";
            st=con.createStatement();
            st.execute(sql);
            bersih();
            tampilData(sql);
            JOptionPane.showMessageDialog(null, "Data Berhasil Diedit");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Diedit \n"+e.getMessage());
        }
    }//GEN-LAST:event_BTN_EDITActionPerformed

    private void BTN_HAPUSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_HAPUSActionPerformed
        // TODO add your handling code here:
        id=String.valueOf(Txt_id_penyewa.getText());
        try {
            sql="DELETE FROM tb_penyewa"
            +" where id_penyewa='"+ id +"'";
            st=con.createStatement();
            st.execute(sql);
            bersih();
            tampilData(sql);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus \n"+e.getMessage());
        }
    }//GEN-LAST:event_BTN_HAPUSActionPerformed

    private void BTN_SIMPANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_SIMPANActionPerformed
        id=String.valueOf(Txt_id_penyewa.getText());
        penyewa=String.valueOf(Txt_nama_penyewa.getText());
        alamat=String.valueOf(Txt_no_hp.getText());
        no_hp=String.valueOf(Txt_alamat_penyewa.getText());
        no_ktp=String.valueOf(Txt_no_ktp.getText());
        status=String.valueOf(cmb_a.getSelectedItem());
        if (cmb_a.getSelectedItem().equals("PILIH")){
            JOptionPane.showMessageDialog(null, "MAAF STATUS BELUM TERPILIH");
        }
        else if(cmb_a.getSelectedItem().equals("NOTREADY")){
            JOptionPane.showMessageDialog(null, "MAAF MOBIL SUDAH DIRENTAL");
        } else{

            try {
                sql=  "INSERT INTO tb_penyewa(id_penyewa,nama_penyewa,alamat_penyewa,no_hp,no_ktp,status)"
                + "VALUES('"+id+"','"+ penyewa +"','"+ alamat +"','" + no_hp +"','" + no_ktp + "','" + status + "')";

                st=con.createStatement();
                st.execute(sql);
                bersih();
                tampilData(sql);
                JOptionPane.showMessageDialog(null,
                    "Data Berhasil Disimpan");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                    "Data Gagal Disimpan \n"+e.getMessage());
            }
        }
    }//GEN-LAST:event_BTN_SIMPANActionPerformed

    private void Txt_no_hpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_no_hpActionPerformed

    }//GEN-LAST:event_Txt_no_hpActionPerformed

    private void BTN_dashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_dashboardActionPerformed
        Home hm = new Home ();
        hm.setVisible(true);
        hm.pack();
        hm.setLocationRelativeTo(null);
        hm.setDefaultCloseOperation(Penyewa.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_BTN_dashboardActionPerformed

    private void BTN_data_mobilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_data_mobilMouseClicked
        Mobil mb = new Mobil ();
        mb.setVisible(true);
        mb.pack();
        mb.setLocationRelativeTo(null);
        mb.setDefaultCloseOperation(Penyewa.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_BTN_data_mobilMouseClicked

    private void BTN_data_mobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_data_mobilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_data_mobilActionPerformed

    private void BTN_data_penyewaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_data_penyewaMouseClicked

    }//GEN-LAST:event_BTN_data_penyewaMouseClicked

    private void BTN_keluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_keluarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_BTN_keluarMouseClicked

    private void BTN_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_keluarActionPerformed

    }//GEN-LAST:event_BTN_keluarActionPerformed

    private void BTN_rental_mobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_rental_mobilActionPerformed
            FrmMenyewa fm = new FrmMenyewa ();
            fm.setVisible(true);
            fm.pack();
            fm.setLocationRelativeTo(null);
            fm.setDefaultCloseOperation(Penyewa.EXIT_ON_CLOSE);
            this.dispose();
    }//GEN-LAST:event_BTN_rental_mobilActionPerformed

    private void BTN_pengembalian_mobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_pengembalian_mobilActionPerformed
        FrmPengembalian pn = new FrmPengembalian ();
        pn.setVisible(true);
        pn.pack();
        pn.setLocationRelativeTo(null);
        pn.setDefaultCloseOperation(Penyewa.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_BTN_pengembalian_mobilActionPerformed

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
            java.util.logging.Logger.getLogger(Penyewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Penyewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Penyewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Penyewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Penyewa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_BATAL;
    private javax.swing.JButton BTN_EDIT;
    private javax.swing.JButton BTN_HAPUS;
    private javax.swing.JButton BTN_SIMPAN;
    private javax.swing.JButton BTN_dashboard;
    private javax.swing.JButton BTN_data_mobil;
    private javax.swing.JButton BTN_data_penyewa;
    private javax.swing.JButton BTN_keluar;
    private javax.swing.JButton BTN_pengembalian_mobil;
    private javax.swing.JButton BTN_rental_mobil;
    private javax.swing.JTable TABEL;
    private javax.swing.JTextField Txt_alamat_penyewa;
    private javax.swing.JTextField Txt_id_penyewa;
    private javax.swing.JTextField Txt_nama_penyewa;
    private javax.swing.JTextField Txt_no_hp;
    private javax.swing.JTextField Txt_no_ktp;
    private javax.swing.JComboBox<String> cmb_a;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
