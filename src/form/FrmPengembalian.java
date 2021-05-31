package form;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Date;

public class FrmPengembalian extends javax.swing.JFrame {
private Connection con;
private Statement st;
private ResultSet RsPengembalian;
private ResultSet RsRental;
private ResultSet RsMobil;
private ResultSet RsStatus;
private ResultSet RsPenyewa;
private ResultSet RsM;
private String sql="";

public String tanggal1,tanggal2,idpengembalian,idrental,namapenyewa,namamobil,bm,status,idmobil,idpenyewa;
public int harga,hari,total;

    public FrmPengembalian() {
        initComponents();
        KoneksiPengembalian();
        TampilData(sql);
    }
    
    private void KoneksiPengembalian(){
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
    private void TampilData(String sql){
        DefaultTableModel datalist = new DefaultTableModel();
        datalist.addColumn("No");
        datalist.addColumn("ID PENGEMBALIAN");
        datalist.addColumn("ID RENTAL");
        datalist.addColumn("ID PENYEWA");
        datalist.addColumn("ID MOBIL");       
        datalist.addColumn("TANGGAL KEMBALI");
        datalist.addColumn("LAMA");
        datalist.addColumn("TOTAL BAYAR");
        try {
            int i=1;
            st=con.createStatement();
            RsPengembalian=st.executeQuery("SELECT * FROM tb_pengembalian");
            while (RsPengembalian.next())
                datalist.addRow(new Object[]{
                    (""+i++),
                    RsPengembalian.getString(1), RsPengembalian.getString(2),
                    RsPengembalian.getString(3), RsPengembalian.getString(4),
                    RsPengembalian.getString(6), RsPengembalian.getString(7),
                    RsPengembalian.getString(8),
                });
            tabel.setModel(datalist);
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Gagal Tampil \n"+e.getMessage());
        }
    }
    private void bersih(){
        Txt_harga.setText("");
        Txt_id_pengembalian.setText("");
        Txt_id_mobil.setText("");
        Txt_id_penyewa.setText("");
        Txt_nama_penyewa.setText("");
        Txt_lama.setText("");
        Txt_nama_mobil.setText("");
        Txt_status.setText("");
        Txt_total.setText("");
        cmb_status.setSelectedItem("PILIH");
        cmb_status.setSelectedItem("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BTN_BATAL = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        BTN_EDIT = new javax.swing.JButton();
        BTN_HAPUS = new javax.swing.JButton();
        BTN_SIMPAN = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
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
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        Txt_nama_penyewa = new javax.swing.JTextField();
        Txt_nama_mobil = new javax.swing.JTextField();
        Txt_status = new javax.swing.JTextField();
        Txt_harga = new javax.swing.JTextField();
        Txt_lama = new javax.swing.JTextField();
        Txt_total = new javax.swing.JTextField();
        Txt_id_penyewa = new javax.swing.JTextField();
        Txt_id_mobil = new javax.swing.JTextField();
        tanggal_rental = new com.toedter.calendar.JDateChooser();
        tanggal_kembali = new com.toedter.calendar.JDateChooser();
        cmb_id_rental = new javax.swing.JComboBox<>();
        cmb_status = new javax.swing.JComboBox<>();
        Txt_id_pengembalian = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("ID PENGEMBALIAN");

        BTN_BATAL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PNG/batal.png"))); // NOI18N
        BTN_BATAL.setText("BATAL");
        BTN_BATAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_BATALActionPerformed(evt);
            }
        });

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID PENGEMBALIAN", "ID RENTAL", "ID PENYEWA", "ID MOBIL", "TANGGAL KEMBALI", "LAMA", "TOTAL BAYAR"
            }
        ));
        jScrollPane1.setViewportView(tabel);

        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("PILIHAN KEMBALI");

        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("ID PENYEWA");
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
        jLabel4.setText("ID MOBIL");

        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("ID RENTAL");

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
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BTN_data_penyewa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTN_rental_mobil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTN_keluar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTN_dashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTN_data_mobil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTN_pengembalian_mobil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(BTN_dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addComponent(BTN_data_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101)
                .addComponent(BTN_data_penyewa, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(BTN_rental_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
                .addComponent(BTN_pengembalian_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addComponent(BTN_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel7.setText("FORM DATA PENGEMBALIAN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(435, 435, 435))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel7)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PNG/mobil.png"))); // NOI18N

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("TANGGAL RENTAL");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("TANGGAL KEMBALI");
        jLabel10.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jLabel10PropertyChange(evt);
            }
        });

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("NAMA PENYEWA");

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("NAMA MOBIL");

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("HARGA");

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("LAMA");
        jLabel14.setToolTipText("");

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("TOTAL BAYAR");

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("STATUS");

        Txt_lama.setToolTipText("");

        Txt_total.setToolTipText("");

        Txt_id_penyewa.setToolTipText("");

        Txt_id_mobil.setToolTipText("");

        tanggal_rental.setEnabled(false);
        tanggal_rental.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tanggal_rentalPropertyChange(evt);
            }
        });

        tanggal_kembali.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tanggal_kembaliPropertyChange(evt);
            }
        });

        cmb_id_rental.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_id_rentalItemStateChanged(evt);
            }
        });

        cmb_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH", "KEMBALI" }));
        cmb_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_statusActionPerformed(evt);
            }
        });

        Txt_id_pengembalian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Txt_id_pengembalianKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel1))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addGap(47, 47, 47))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(7, 7, 7)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel12)
                                                            .addComponent(jLabel4)))
                                                    .addComponent(jLabel3)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(25, 25, 25)
                                                        .addComponent(BTN_SIMPAN))
                                                    .addComponent(jLabel2)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(7, 7, 7)
                                                        .addComponent(jLabel5)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Txt_nama_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(BTN_EDIT, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(59, 59, 59))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                            .addComponent(cmb_id_rental, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(Txt_nama_penyewa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                                            .addComponent(Txt_id_mobil, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                                            .addComponent(Txt_id_penyewa, javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(cmb_status, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(Txt_id_pengembalian))
                                                        .addGap(84, 84, 84)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel13)
                                                            .addComponent(jLabel8)
                                                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel15)
                                                            .addComponent(jLabel16)
                                                            .addComponent(jLabel10))
                                                        .addGap(33, 33, 33)))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(Txt_lama)
                                                        .addComponent(Txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(Txt_status, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(tanggal_kembali, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(tanggal_rental, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(Txt_harga, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)))))))
                                .addGap(80, 80, 80)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(BTN_BATAL, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(244, 244, 244)
                                        .addComponent(BTN_HAPUS, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1213, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel13)
                            .addComponent(Txt_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Txt_id_pengembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(cmb_status, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tanggal_rental, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(tanggal_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cmb_id_rental, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5)))))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Txt_lama, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(Txt_id_penyewa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Txt_nama_penyewa, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel15)
                            .addComponent(Txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Txt_status, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(Txt_id_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Txt_nama_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(47, 47, 47)))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_HAPUS)
                    .addComponent(BTN_BATAL)
                    .addComponent(BTN_EDIT)
                    .addComponent(BTN_SIMPAN))
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1670, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1049, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 1, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 2, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_rental_mobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_rental_mobilActionPerformed
        FrmMenyewa fm = new FrmMenyewa ();
        fm.setVisible(true);
        fm.pack();
        fm.setLocationRelativeTo(null);
        fm.setDefaultCloseOperation(FrmPengembalian.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_BTN_rental_mobilActionPerformed

    private void BTN_data_penyewaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_data_penyewaMouseClicked
        Penyewa pn = new Penyewa ();
        pn.setVisible(true);
        pn.pack();
        pn.setLocationRelativeTo(null);
        pn.setDefaultCloseOperation(FrmPengembalian.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_BTN_data_penyewaMouseClicked

    private void BTN_data_mobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_data_mobilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_data_mobilActionPerformed

    private void BTN_data_mobilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_data_mobilMouseClicked
        Mobil mb = new Mobil ();
        mb.setVisible(true);
        mb.pack();
        mb.setLocationRelativeTo(null);
        mb.setDefaultCloseOperation(FrmPengembalian.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_BTN_data_mobilMouseClicked

    private void BTN_dashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_dashboardActionPerformed
        Home hm = new Home ();
        hm.setVisible(true);
        hm.pack();
        hm.setLocationRelativeTo(null);
        hm.setDefaultCloseOperation(FrmPengembalian.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_BTN_dashboardActionPerformed

    private void BTN_SIMPANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_SIMPANActionPerformed
       idpengembalian=String.valueOf(Txt_id_pengembalian.getText());
       idrental=cmb_id_rental.getItemAt(cmb_id_rental.getSelectedIndex()).toString();
       idmobil=String.valueOf(Txt_id_mobil.getText());
       idpenyewa=String.valueOf(Txt_id_penyewa.getText());
       namapenyewa=String.valueOf(Txt_nama_penyewa.getText());
       namamobil=String.valueOf(Txt_nama_mobil.getText());
       harga=Integer.parseInt(Txt_harga.getText());
       total=Integer.parseInt(Txt_total.getText());
       status=cmb_status.getItemAt(cmb_status.getSelectedIndex()).toString();
       if(cmb_status.getSelectedItem().equals("SELESAI")){
           JOptionPane.showMessageDialog(null,"MAAF MOBIL SUDHA DIKEMBALIKAN");
           bersih();
       }
       else if(Txt_id_pengembalian.getText().equals("")){
           JOptionPane.showMessageDialog(null,"MAAF ID PENGEMBALIAN MASIH KOSONG");
       }
       else{
           try{
               sql="INSERT INTO tb_pengembalian(id_pengembalian,id_rental,id_penyewa,id_mobil, "
                       + "tgl_rental, tgl_kembali,lama,total_bayar,status)VALUE"
                       +"('"+idpengembalian + "','" + idrental + "','" + idpenyewa + "','" + idmobil + "',"
                       + "'"+ tanggal1 + "','" + tanggal2 + "','" + hari + "','" + total + "','" + status +"')";
                       st=con.createStatement();
                       st.execute(sql);
                       bersih();
                       TampilData(sql);
                       JOptionPane.showMessageDialog(null,"Data Behasil Disimpan");
           }
           catch(Exception e){
               JOptionPane.showMessageDialog(null,"Data Gagal Disimpan\n"+e.getMessage());
           }
           try{
               String sql="select * from tb_mobil";
               Statement st = con.createStatement();
               RsMobil =st.executeQuery(sql);
               status = "READY";
               sql="update tb_mobil set status = '"+ status +"' where id_mobil = '"+ idmobil +"'";
               st = con.createStatement();
               st.execute(sql);
           }catch(Exception e){
               JOptionPane.showMessageDialog(null,"MAAF EROR\n"+e.getMessage());
           }
           
           try{
               String sql="select * from tb_penyewa";
               Statement st = con.createStatement();
               RsMobil =st.executeQuery(sql);
               status = "READY";
               sql="update tb_penyewa set status = '"+ status +"' where id_penyewa = '"+ idpenyewa +"'";
               st = con.createStatement();
               st.execute(sql);
           }catch(Exception e){
               JOptionPane.showMessageDialog(null,"MAAF EROR\n"+e.getMessage());
           }
           try{
               status="SELESAI";
               sql="update tb_rental set status = '" + status + "' where id_rental = '"+idrental +"'";
               st=con.createStatement();
               st.execute(sql);
           } catch(Exception e){
               JOptionPane.showMessageDialog(null, "MAAF ERORR\n"+e.getMessage());
           }
       }
    }//GEN-LAST:event_BTN_SIMPANActionPerformed

    private void BTN_HAPUSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_HAPUSActionPerformed
        // TODO add your handling code here:
        idpengembalian=String.valueOf(Txt_id_pengembalian.getText());
        try {
            sql="DELETE FROM tb_pengembalian"
            +" where id_pengembalian='"+ idpengembalian +"'";
            st=con.createStatement();
            st.execute(sql);
            bersih();
            TampilData(sql);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus \n"+e.getMessage());
        }
    }//GEN-LAST:event_BTN_HAPUSActionPerformed

    private void BTN_EDITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_EDITActionPerformed

        idpengembalian=String.valueOf(Txt_id_pengembalian.getText());
        idrental=cmb_status.getItemAt(cmb_status.getSelectedIndex()).toString();
        idmobil=String.valueOf(Txt_id_mobil.getText());
        idpenyewa=String.valueOf(Txt_id_penyewa.getText());
        namapenyewa=String.valueOf(Txt_nama_penyewa.getText());
        namamobil=String.valueOf(Txt_nama_mobil.getText());
        harga=Integer.parseInt(Txt_harga.getText());
        hari=Integer.parseInt(Txt_lama.getText());
        total=Integer.parseInt(Txt_total.getText());
        status=cmb_status.getItemAt(cmb_status.getSelectedIndex()).toString();
        try {
            sql="update tb_pengembalian set tgl_kembali='"+ tanggal2 +"',lama='" + hari +"',total_bayar='" + total +"',status ='"+ status+"' "
            + "where id_pengembalian='"+ idpengembalian +"'";
            st=con.createStatement();
            st.execute(sql);
            bersih();
            TampilData(sql);
            JOptionPane.showMessageDialog(null, "Data Berhasil Diedit");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Diedit \n"+e.getMessage());
        }
    }//GEN-LAST:event_BTN_EDITActionPerformed

    private void BTN_BATALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_BATALActionPerformed
        bersih();
    }//GEN-LAST:event_BTN_BATALActionPerformed

    private void jLabel10PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jLabel10PropertyChange

    }//GEN-LAST:event_jLabel10PropertyChange

    private void tanggal_kembaliPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tanggal_kembaliPropertyChange
        if(tanggal_kembali.getDate()!=null){
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
            tanggal2=format.format(tanggal_kembali.getDate());

        }
        try{
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date pinjam = tanggal_rental.getDate();
            Date kembali = tanggal_kembali.getDate();
            long pinjam1 = pinjam.getTime();
            long kembali1 = kembali.getTime();
            long diff = kembali1-pinjam1;
            long lama = diff/(24*60*60*1000);
            Txt_lama.setText(Long.toString(lama));
            harga=Integer.parseInt(Txt_harga.getText());
            hari=Integer.parseInt(Txt_lama.getText());
            total= harga*hari;
            Txt_total.setText(String.valueOf(total));
        } catch(Exception e){
        }
    }//GEN-LAST:event_tanggal_kembaliPropertyChange

    private void tanggal_rentalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tanggal_rentalPropertyChange
        if(tanggal_rental.getDate()!=null){
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
            tanggal1=format.format(tanggal_rental.getDate());
   }
    }//GEN-LAST:event_tanggal_rentalPropertyChange

    private void BTN_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_keluarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_BTN_keluarActionPerformed

    private void BTN_keluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_keluarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_BTN_keluarMouseClicked

    private void cmb_id_rentalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_id_rentalItemStateChanged
         try{
            sql = "select * from tb_rental where "
            + "id_rental='"+ cmb_id_rental.getSelectedItem() +"'";
            st=con.createStatement();
            RsRental=st.executeQuery(sql);
            while(RsRental.next()){
                Txt_id_mobil.setText(RsRental.getString("id_mobil"));
                Txt_id_penyewa.setText(RsRental.getString("id_penyewa"));
                Txt_nama_penyewa.setText(RsRental.getString("nama_penyewa"));
                tanggal_rental.setDate(RsRental.getDate(7));
                Txt_nama_mobil.setText(RsRental.getString("nama_mobil"));
                Txt_harga.setText(RsRental.getString("harga_rental"));
                Txt_status.setText(RsRental.getString("status"));
            }
        }catch(Exception e){

        }
    }//GEN-LAST:event_cmb_id_rentalItemStateChanged

    private void cmb_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_statusActionPerformed
      if(cmb_status.getSelectedItem()=="KEMBALI"){
          cmb_id_rental.removeAllItems();
          cmb_id_rental.addItem("PILIH");
        
          try{
              status=String.valueOf(cmb_status.getSelectedItem());
              status = "SEWA";
              String Sql = "select * from tb_rental where status = '" + status+"'";
              Statement st=con.createStatement();
              RsRental=st.executeQuery(Sql);
              while(RsRental.next()){
                  String Aliaskd= RsRental.getString("id_rental");
                  cmb_id_rental.addItem(Aliaskd);
              }
          }catch (Exception e){
              JOptionPane.showMessageDialog(null,"Gagal Menampilakn id rental"+e.getMessage());
          }
          
      }
    }//GEN-LAST:event_cmb_statusActionPerformed

    private void Txt_id_pengembalianKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txt_id_pengembalianKeyPressed
    idpengembalian = Txt_id_pengembalian.getText();
    int tekanenter=evt.getKeyCode();
    if(tekanenter==10){
        try{
            String Sql = "select * from tb_rental";
            Statement st = con.createStatement();
            RsRental=st.executeQuery(Sql);
            while(RsRental.next()){
                String Aliaskd = RsRental.getString("id_rental");
                cmb_id_rental.addItem(Aliaskd);
                cmb_status.setEnabled(false);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Gagal Menampilkan \n"+e.getMessage());
        }
        try{
            sql="select * from tb_pengembalian "
                    + "where id_pengembalian='"+ idpengembalian+"'";
            st=con.createStatement();
            RsPengembalian = st.executeQuery(sql);
            while(RsPengembalian.next()){
                cmb_id_rental.setSelectedItem(RsPengembalian.getString("id_rental"));
                Txt_id_mobil.setText(RsPengembalian.getString("id_mobil"));
                tanggal_rental.setDate(RsPengembalian.getDate("tgl_rental"));
                tanggal_kembali.setDate(RsPengembalian.getDate("tgl_kembali"));
                Txt_lama.setText(RsPengembalian.getString("lama"));
                Txt_total.setText(RsPengembalian.getString("total_bayar"));
                Txt_status.setText(RsPengembalian.getString("status"));
                JOptionPane.showMessageDialog(null,"Data Ditemukan\n");
            }
        }catch(Exception e){
        JOptionPane.showMessageDialog(null,"Data Tidak Ditemukan\n"+e.getMessage());
    }
    }
    }//GEN-LAST:event_Txt_id_pengembalianKeyPressed

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
            java.util.logging.Logger.getLogger(FrmPengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPengembalian().setVisible(true);
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
    private javax.swing.JTextField Txt_harga;
    private javax.swing.JTextField Txt_id_mobil;
    private javax.swing.JTextField Txt_id_pengembalian;
    private javax.swing.JTextField Txt_id_penyewa;
    private javax.swing.JTextField Txt_lama;
    private javax.swing.JTextField Txt_nama_mobil;
    private javax.swing.JTextField Txt_nama_penyewa;
    private javax.swing.JTextField Txt_status;
    private javax.swing.JTextField Txt_total;
    private javax.swing.JComboBox<String> cmb_id_rental;
    private javax.swing.JComboBox<String> cmb_status;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel;
    private com.toedter.calendar.JDateChooser tanggal_kembali;
    private com.toedter.calendar.JDateChooser tanggal_rental;
    // End of variables declaration//GEN-END:variables
}
