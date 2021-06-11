package form;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;  

public class FrmMenyewa extends javax.swing.JFrame {
public static Connection con;
public static Statement st;
private ResultSet RsMobil;
private ResultSet RsRental;
private ResultSet RsPenyewa;
private String sql="";    
    
private String idRental,idMobil,idPenyewa,namaPenyewa,namaMobil,bm,status,tanggal,statusb;
private int harga;

    public FrmMenyewa() {
        initComponents();
        KoneksiMenyewa();
        tampilData(sql);
    }
    
    private void KoneksiMenyewa(){
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
        datalist.addColumn("NO");
        datalist.addColumn("ID RENTAL");
        datalist.addColumn("ID PENYEWA");
        datalist.addColumn("ID MOBIL");
        datalist.addColumn("HARGA RENTAL");
        datalist.addColumn("TANGGAL RENTAL");
        datalist.addColumn("STATUS");
        
        try{
            int i = 1;
            st=con.createStatement();
            RsRental=st.executeQuery("SELECT * FROM tb_rental");
            while(RsRental.next())
                datalist.addRow(new Object[]{
                (""+i++),
                    RsRental.getString(1),RsRental.getString(2),
                    RsRental.getString(3),RsRental.getString(6),
                    RsRental.getString(7),RsRental.getString(8),
                });
            TABEL_menyewa.setModel(datalist);
        }catch(Exception e){
         JOptionPane.showMessageDialog(null,"Gagal Tampila\n"+e.getMessage());
        }
    }

    private void bersih(){
        Txt_id_rental.setText("");
        Txt_nama_penyewa.setText("");
        Txt_nama_mobil.setText("");
        Txt_bm_mobil.setText("");
        Txt_harga_rental.setText("");
        Txt_status.setText("");
        cmb_sewa.setSelectedItem("PILIH");
        cmb_id_mobil.setSelectedItem("PILIH");
        cmb_id_penyewa.setSelectedItem("PILIH");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BTN_BATAL = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABEL_menyewa = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        BTN_EDIT = new javax.swing.JButton();
        BTN_HAPUS = new javax.swing.JButton();
        BTN_SIMPAN = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
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
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Txt_id_rental = new javax.swing.JTextField();
        cmb_id_penyewa = new javax.swing.JComboBox<>();
        cmb_sewa = new javax.swing.JComboBox<>();
        Txt_nama_penyewa = new javax.swing.JTextField();
        Txt_bm_mobil = new javax.swing.JTextField();
        Txt_nama_mobil = new javax.swing.JTextField();
        cmb_id_mobil = new javax.swing.JComboBox<>();
        Txt_harga_rental = new javax.swing.JTextField();
        Txt_status = new javax.swing.JTextField();
        tanggal_rental = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("ID Rental");

        BTN_BATAL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PNG/batal.png"))); // NOI18N
        BTN_BATAL.setText("BATAL");
        BTN_BATAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_BATALActionPerformed(evt);
            }
        });

        TABEL_menyewa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID RENTAL", "ID PENYEWA", "ID MOBIL", "HARGA RENTAL", "TANGGAL RENTAL", "STATUS"
            }
        ));
        jScrollPane1.setViewportView(TABEL_menyewa);

        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Pilihan Sewa");

        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("ID MOBIL");
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
        jLabel4.setText("Nama Penyewa");

        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("ID Penyewa");

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
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(BTN_data_penyewa, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                        .addComponent(BTN_rental_mobil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BTN_keluar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BTN_dashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BTN_data_mobil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(BTN_pengembalian_mobil)
                    .addComponent(BTN_info_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(BTN_dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(BTN_data_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(BTN_data_penyewa, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(BTN_rental_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BTN_pengembalian_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(BTN_info_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(BTN_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel7.setText("FORM DATA MENYEWA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(36, 36, 36))
        );

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PNG/resolusi2.png"))); // NOI18N

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Nama Mobil");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("BM Mobil");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Harga Rental");

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Tanggal");

        Txt_id_rental.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Txt_id_rentalKeyPressed(evt);
            }
        });

        cmb_id_penyewa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_id_penyewaItemStateChanged(evt);
            }
        });

        cmb_sewa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH", "SEWA" }));
        cmb_sewa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_sewaActionPerformed(evt);
            }
        });

        Txt_nama_penyewa.setEnabled(false);

        Txt_bm_mobil.setEnabled(false);

        Txt_nama_mobil.setEnabled(false);

        cmb_id_mobil.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_id_mobilItemStateChanged(evt);
            }
        });

        Txt_harga_rental.setEnabled(false);

        Txt_status.setEnabled(false);

        tanggal_rental.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tanggal_rentalPropertyChange(evt);
            }
        });

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
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cmb_sewa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(Txt_id_rental, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(24, 24, 24)
                                            .addComponent(BTN_SIMPAN))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel5)
                                                .addComponent(jLabel3))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cmb_id_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cmb_id_penyewa, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Txt_harga_rental, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(51, 51, 51)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(BTN_EDIT, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(194, 194, 194)
                                        .addComponent(BTN_BATAL, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(BTN_HAPUS, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel8))
                                        .addGap(34, 34, 34)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(Txt_nama_penyewa, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                                            .addComponent(Txt_bm_mobil, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                                            .addComponent(Txt_nama_mobil, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                                            .addComponent(Txt_status, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                                            .addComponent(tanggal_rental, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 995, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(24, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(Txt_id_rental, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(Txt_nama_penyewa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel10)
                            .addComponent(cmb_sewa, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Txt_bm_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(cmb_id_penyewa, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Txt_nama_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel3)
                            .addComponent(cmb_id_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tanggal_rental, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel11)
                    .addComponent(Txt_harga_rental, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Txt_status, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
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

    private void BTN_BATALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_BATALActionPerformed
        bersih();
    }//GEN-LAST:event_BTN_BATALActionPerformed

    private void BTN_EDITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_EDITActionPerformed

        idRental=String.valueOf(Txt_id_rental.getText());
        idPenyewa=String.valueOf(cmb_id_penyewa.getSelectedItem());
        idMobil=String.valueOf(cmb_id_mobil.getSelectedItem());
        namaPenyewa=String.valueOf(Txt_nama_penyewa.getText());
        namaMobil=String.valueOf(Txt_nama_mobil.getText());
        harga=Integer.parseInt(Txt_harga_rental.getText());
        status=String.valueOf(Txt_status.getText());
        try {
            sql = "update tb_rental set id_mobil = '"+ idMobil +"', "
                    + "id_penyewa = '" + idPenyewa + "', nama_penyewa = '"+ namaPenyewa +"', "
                    + "nama_mobil = '" + namaMobil +"', "
                    + "tgl_rental = '" + tanggal +"', harga_rental = '" + harga +"', "
                    + "status = '"+ status + "' "
                    + "where id_rental = '" + idRental +"'";
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
        idRental=String.valueOf(Txt_id_rental.getText());
        try {
            sql="DELETE FROM tb_rental"
            +" where id_rental='"+ idRental +"'";
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
        idRental=String.valueOf(Txt_id_rental.getText());
        idMobil=cmb_id_mobil.getItemAt(cmb_id_mobil.getSelectedIndex()).toString();
        idPenyewa=cmb_id_penyewa.getItemAt(cmb_id_penyewa.getSelectedIndex()).toString();
        namaPenyewa=String.valueOf(Txt_nama_penyewa.getText());
        namaMobil=String.valueOf(Txt_nama_mobil.getText());
        bm=String.valueOf(Txt_bm_mobil.getText());
        harga=Integer.parseInt(Txt_harga_rental.getText());
        status =cmb_sewa.getItemAt(cmb_sewa.getSelectedIndex()).toString();
        if (cmb_sewa.getSelectedItem().equals("PILIH")){
            JOptionPane.showMessageDialog(null, "MAAF STATUS BELUM TERPILIH");
        }
         else{

            try {
                sql=  "INSERT INTO tb_rental(id_rental,id_penyewa,id_mobil,nama_penyewa,nama_mobil,harga_rental,tgl_rental,status)"
                + "VALUES('"+idRental+"','"+ idPenyewa +"','"+ idMobil +"','" + namaPenyewa +"','" + namaMobil + "','"+ harga + "','"  + tanggal + "','" + status + "')";

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
        try{
            status = "NOTREADY";
            sql = "update tb_mobil set status = '"+status+"'where id_mobil ='"+idMobil +"'";
            st=con.createStatement();
            st.execute(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Maaf Data Tidak Bisa Dirubah"+e.getMessage());
        }
        
        try{
            String Sql ="select * from tb_penyewa";
            st = con.createStatement();
            RsPenyewa =st.executeQuery(Sql);
            status ="NOTREADY";
            sql="update tb_penyewa set status ='"+status+"'where id_penyewa = '"+ idPenyewa +"'";
            st=con.createStatement();
            st.execute(sql);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Maaf Data Tidak bisa Dirubah"+e.getMessage());
        }
    }//GEN-LAST:event_BTN_SIMPANActionPerformed

    private void BTN_dashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_dashboardActionPerformed
        Home hm = new Home ();
        hm.setVisible(true);
        hm.pack();
        hm.setLocationRelativeTo(null);
        hm.setDefaultCloseOperation(FrmMenyewa.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_BTN_dashboardActionPerformed

    private void BTN_data_mobilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_data_mobilMouseClicked
        Mobil mb = new Mobil ();
        mb.setVisible(true);
        mb.pack();
        mb.setLocationRelativeTo(null);
        mb.setDefaultCloseOperation(FrmMenyewa.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_BTN_data_mobilMouseClicked

    private void BTN_data_mobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_data_mobilActionPerformed

    }//GEN-LAST:event_BTN_data_mobilActionPerformed

    private void BTN_data_penyewaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_data_penyewaMouseClicked
        Penyewa pn = new Penyewa ();
        pn.setVisible(true);
        pn.pack();
        pn.setLocationRelativeTo(null);
        pn.setDefaultCloseOperation(FrmMenyewa.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_BTN_data_penyewaMouseClicked

    private void BTN_keluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_keluarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_BTN_keluarMouseClicked

    private void BTN_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_keluarActionPerformed

    }//GEN-LAST:event_BTN_keluarActionPerformed

@SuppressWarnings("empty-statement")
    private void cmb_sewaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_sewaActionPerformed
       
        if(cmb_sewa.getSelectedItem()=="SEWA"){
        status=String.valueOf(cmb_sewa.getSelectedItem());
        statusb=String.valueOf(Txt_status.getText());
        statusb="READY";
        Txt_status.setText(String.valueOf(statusb));
   }
         Txt_status.setText(String.valueOf(statusb));
        if(cmb_sewa.getSelectedItem()=="SEWA"){
            cmb_id_mobil.removeAllItems();
            cmb_id_mobil.addItem("PILIH");

       try{
           status=String.valueOf(cmb_sewa.getSelectedItem());
           status="READY";
           String Sql = "select * from tb_mobil where status = '"+ status +"'";
           Statement st = con.createStatement();
           RsMobil=st.executeQuery(Sql);
           while(RsMobil.next()){
               String Aliaskd = RsMobil.getString("id_mobil");
               cmb_id_mobil.addItem(Aliaskd);
           }
       }catch(Exception e){
           JOptionPane.showMessageDialog(null,"Gagal Menampilkan id mobil\n"+e.getMessage());
           }
            cmb_id_penyewa.removeAllItems();
            cmb_id_penyewa.addItem("PILIH");
          
        try{
           status=String.valueOf(cmb_sewa.getSelectedItem());
           status="READY";
           String Sql = "select * from tb_penyewa where status = '"+ status +"'";
           Statement st = con.createStatement();
           RsPenyewa=st.executeQuery(Sql);
           while(RsPenyewa.next()){
               String Aliaskd = RsPenyewa.getString("id_penyewa");
               cmb_id_penyewa.addItem(Aliaskd);
           }
       }catch(Exception e){
           JOptionPane.showMessageDialog(null,"Gagal Menampilkan id mobil\n"+e.getMessage());
           }
       }
    }//GEN-LAST:event_cmb_sewaActionPerformed

    private void tanggal_rentalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tanggal_rentalPropertyChange
        if(tanggal_rental.getDate()!=null){
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
            tanggal=format.format(tanggal_rental.getDate());
   }
    }//GEN-LAST:event_tanggal_rentalPropertyChange

    private void cmb_id_penyewaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_id_penyewaItemStateChanged
      try{
          sql="select * from tb_penyewa where "
                  +"id_penyewa='"+ cmb_id_penyewa.getSelectedItem()+"'";
          st=con.createStatement();
          RsPenyewa=st.executeQuery(sql);
          while(RsPenyewa.next()){
              Txt_nama_penyewa.setText(RsPenyewa.getString("nama_penyewa"));
          }
      }catch(Exception e){
      }
    }//GEN-LAST:event_cmb_id_penyewaItemStateChanged

    private void cmb_id_mobilItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_id_mobilItemStateChanged
        try{
            sql="select * from tb_mobil where "
                    + "id_mobil ='"+cmb_id_mobil.getSelectedItem()+"'";
            st=con.createStatement();
            RsMobil=st.executeQuery(sql);
            while(RsMobil.next()){
                Txt_nama_mobil.setText(RsMobil.getString("nama_mobil"));
                Txt_bm_mobil.setText(RsMobil.getString(4));
                Txt_harga_rental.setText(RsMobil.getString(5));
                cmb_sewa.setSelectedItem(RsMobil.getString(6));
            }
            Txt_nama_mobil.requestFocus();
        }catch (Exception e){
        }
    }//GEN-LAST:event_cmb_id_mobilItemStateChanged

    private void Txt_id_rentalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txt_id_rentalKeyPressed
        idRental=Txt_id_rental.getText();
        int tekanenter=evt.getKeyCode();

        if (tekanenter==10){
            try{
                cmb_id_mobil.removeAllItems();
                String Sql="select * from tb_mobil ";
                Statement st=con.createStatement();
                RsMobil=st.executeQuery(Sql);
                while (RsMobil.next()){
                    String Aliaskd= RsMobil.getString("id_mobil");
                    cmb_id_mobil.addItem(Aliaskd);
                    cmb_sewa.setEnabled(false);
                }
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Gagal Menampilkan ID MOBIL \n"
                    +e.getMessage());
            }
            try {
                cmb_id_penyewa.removeAllItems();
                String Sql = "select * from tb_penyewa";
                Statement st=con.createStatement();
                RsPenyewa = st.executeQuery(Sql);
                while(RsPenyewa.next()){
                    String Aliaskd = RsPenyewa.getString("id_penyewa");
                    cmb_id_penyewa.addItem(Aliaskd);
                    cmb_sewa.setEnabled(false);
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"Gagal Menampilkan ID PENYEWA"+e.getMessage());
            }
            try{
                sql ="select * from tb_rental "
                +"where id_rental= '" + idRental +"'";
                st=con.createStatement();
                RsRental=st.executeQuery(sql);
                while(RsRental.next()){
                    cmb_id_mobil.setSelectedItem(RsRental.getString("id_mobil"));
                    cmb_id_penyewa.setSelectedItem(RsRental.getString("id_penyewa"));
                    Txt_nama_penyewa.setText(RsRental.getString("nama_penyewa"));
                    Txt_nama_mobil.setText(RsRental.getString("nama_mobil"));
                    tanggal_rental.setDate(RsRental.getDate("tgl_rental"));
                    Txt_harga_rental.setText(RsRental.getString("harga_rental"));
                    Txt_status.setText(RsRental.getString("status"));
                    JOptionPane.showMessageDialog(null,"Data Ditemukan\n");
                }
            } catch (Exception e){
                JOptionPane.showMessageDialog(null,"Data Tidak Ditemukan\n"+e.getMessage());
                cmb_id_mobil.requestFocus();
            }
        }
    }//GEN-LAST:event_Txt_id_rentalKeyPressed

    private void BTN_pengembalian_mobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_pengembalian_mobilActionPerformed
        FrmPengembalian pn = new FrmPengembalian ();
        pn.setVisible(true);
        pn.pack();
        pn.setLocationRelativeTo(null);
        pn.setDefaultCloseOperation(FrmMenyewa.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_BTN_pengembalian_mobilActionPerformed

    private void BTN_info_mobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_info_mobilActionPerformed
        FrmInfoMobil fim = new FrmInfoMobil ();
        fim.setVisible(true);
        fim.pack();
        fim.setLocationRelativeTo(null);
        fim.setDefaultCloseOperation(FrmMenyewa.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_BTN_info_mobilActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenyewa().setVisible(true);
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
    private javax.swing.JButton BTN_info_mobil;
    private javax.swing.JButton BTN_keluar;
    private javax.swing.JButton BTN_pengembalian_mobil;
    private javax.swing.JButton BTN_rental_mobil;
    private javax.swing.JTable TABEL_menyewa;
    private javax.swing.JTextField Txt_bm_mobil;
    private javax.swing.JTextField Txt_harga_rental;
    private javax.swing.JTextField Txt_id_rental;
    private javax.swing.JTextField Txt_nama_mobil;
    private javax.swing.JTextField Txt_nama_penyewa;
    private javax.swing.JTextField Txt_status;
    private javax.swing.JComboBox<String> cmb_id_mobil;
    private javax.swing.JComboBox<String> cmb_id_penyewa;
    private javax.swing.JComboBox<String> cmb_sewa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser tanggal_rental;
    // End of variables declaration//GEN-END:variables
}
