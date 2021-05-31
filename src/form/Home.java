
package form;


public class Home extends javax.swing.JFrame {

    public Home() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        BTN_data_mobil = new javax.swing.JButton();
        BTN_data_penyewa = new javax.swing.JButton();
        BTN_rental_mobil = new javax.swing.JButton();
        BTN_pengembalian_mobil = new javax.swing.JButton();
        BTN_keluar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(0, 0, 102));

        jButton1.setBackground(new java.awt.Color(51, 153, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PNG/home 20x20.png"))); // NOI18N
        jButton1.setText("DASHBOARD");

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
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BTN_pengembalian_mobil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTN_rental_mobil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTN_data_penyewa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTN_data_mobil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTN_keluar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(BTN_data_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(BTN_data_penyewa, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(BTN_rental_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(BTN_pengembalian_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(BTN_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PNG/1000x10000.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_data_mobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_data_mobilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_data_mobilActionPerformed

    private void BTN_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_keluarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_BTN_keluarActionPerformed

    private void BTN_data_mobilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_data_mobilMouseClicked
            Mobil mobil = new Mobil ();
            mobil.setVisible(true);
            mobil.pack();
            mobil.setLocationRelativeTo(null);
            mobil.setDefaultCloseOperation(Home.EXIT_ON_CLOSE);
            this.dispose();
    }//GEN-LAST:event_BTN_data_mobilMouseClicked

    private void BTN_keluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_keluarMouseClicked

    }//GEN-LAST:event_BTN_keluarMouseClicked

    private void BTN_data_penyewaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_data_penyewaMouseClicked
            Penyewa pm = new Penyewa ();
            pm.setVisible(true);
            pm.pack();
            pm.setLocationRelativeTo(null);
            pm.setDefaultCloseOperation(Home.EXIT_ON_CLOSE);
            this.dispose();
    }//GEN-LAST:event_BTN_data_penyewaMouseClicked

    private void BTN_rental_mobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_rental_mobilActionPerformed
            FrmMenyewa fm = new FrmMenyewa ();
            fm.setVisible(true);
            fm.pack();
            fm.setLocationRelativeTo(null);
            fm.setDefaultCloseOperation(Home.EXIT_ON_CLOSE);
            this.dispose();
    }//GEN-LAST:event_BTN_rental_mobilActionPerformed

    private void BTN_pengembalian_mobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_pengembalian_mobilActionPerformed
        FrmPengembalian pn = new FrmPengembalian ();
        pn.setVisible(true);
        pn.pack();
        pn.setLocationRelativeTo(null);
        pn.setDefaultCloseOperation(Home.EXIT_ON_CLOSE);
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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_data_mobil;
    private javax.swing.JButton BTN_data_penyewa;
    private javax.swing.JButton BTN_keluar;
    private javax.swing.JButton BTN_pengembalian_mobil;
    private javax.swing.JButton BTN_rental_mobil;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
