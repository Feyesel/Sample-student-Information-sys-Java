/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author RehaTutorial
 */
public class Student extends javax.swing.JFrame {

    String path2=null;
    String gender=null;
    Connection con=null;
    PreparedStatement pst = null;
    ResultSet Rs = null;
    
    public Student() {
        initComponents();
        connect();
        updateTable();
    }
    
    public void connect(){
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/studentinfo","root","");
            System.out.println("connected....");
        } catch (Exception ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateTable(){
        int column;
        
        try {
            pst = con.prepareStatement("Select * from record");
            Rs = pst.executeQuery();
            
            ResultSetMetaData RSMD = Rs.getMetaData();
            column = RSMD.getColumnCount();
            DefaultTableModel DFT = (DefaultTableModel) jTable1.getModel();
            DFT.setRowCount(0);
            
            while(Rs.next()){
                Vector v = new Vector();
                for(int i=1; i<column ; i++){
                    v.add(Rs.getString(1));
                    v.add(Rs.getString(2));
                    v.add(Rs.getString(3));
                    v.add(Rs.getString(4));
                    v.add(Rs.getString(5));
                    v.add(Rs.getString(6));
                    v.add(Rs.getBlob(7));
                }
                DFT.addRow(v);
            }
        } catch (Exception ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        l_photo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtFname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtLname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCity = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtComboAge = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        Male = new javax.swing.JRadioButton();
        Female = new javax.swing.JRadioButton();
        btnUpload = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("STUDENT INFORMATION MANAGEMENT SYSTEM");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        l_photo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("FIRST NAME :");

        txtFname.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtFname.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 2, true));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 153));
        jLabel4.setText("LAST NAME  :");

        txtLname.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtLname.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 2, true));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("CITY :");

        txtCity.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtCity.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 2, true));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setText("AGE :");

        txtComboAge.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtComboAge.setForeground(new java.awt.Color(0, 153, 153));
        txtComboAge.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "18", "19", "20", "21", "22", "23", "24", "25" }));
        txtComboAge.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 2, true));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 153));
        jLabel7.setText("GENDER :");

        buttonGroup1.add(Male);
        Male.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Male.setForeground(new java.awt.Color(0, 153, 153));
        Male.setText("Male");
        Male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaleActionPerformed(evt);
            }
        });

        buttonGroup1.add(Female);
        Female.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Female.setForeground(new java.awt.Color(0, 153, 153));
        Female.setText("Female");
        Female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FemaleActionPerformed(evt);
            }
        });

        btnUpload.setBackground(new java.awt.Color(0, 153, 153));
        btnUpload.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpload.setForeground(new java.awt.Color(255, 255, 255));
        btnUpload.setText("UPLOAD");
        btnUpload.setBorderPainted(false);
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(txtComboAge, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(Male)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Female)
                                .addGap(40, 40, 40))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtLname, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtFname, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(l_photo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnUpload)))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(l_photo, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(btnUpload)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtFname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtLname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtComboAge, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(Male)
                    .addComponent(Female))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        btnSave.setBackground(new java.awt.Color(0, 153, 153));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("SAVE");
        btnSave.setBorderPainted(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(0, 153, 153));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("UPDATE");
        btnUpdate.setBorderPainted(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(0, 153, 153));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("DELETE");
        btnDelete.setBorderPainted(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(0, 153, 153));
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("CLEAR");
        btnClear.setBorderPainted(false);
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(0, 153, 153));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "FIRST NAME", "LAST NAME", "CITY", "AGE", "GENDER", "PHOTO"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSave)
                                .addGap(40, 40, 40)
                                .addComponent(btnUpdate)
                                .addGap(50, 50, 50)
                                .addComponent(btnDelete)
                                .addGap(45, 45, 45)
                                .addComponent(btnClear))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnClear))
                .addGap(0, 32, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed
        // upload btn
        JFileChooser chose = new JFileChooser();
        chose.showOpenDialog(null);
        File f = chose.getSelectedFile();
        String path = f.getAbsolutePath();
        
        try {
            BufferedImage bi = ImageIO.read(new File(path));
            Image img = bi.getScaledInstance(134, 172, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(img);
            l_photo.setIcon(icon);
            path2 = path;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnUploadActionPerformed

    private void MaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaleActionPerformed
        // male clik
        gender = "Male";
    }//GEN-LAST:event_MaleActionPerformed

    private void FemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FemaleActionPerformed
        // TODO add your handling code here:
        gender = "Female";
    }//GEN-LAST:event_FemaleActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // save btn
        String Fname,Lname,City,Age;
        Fname = txtFname.getText();
        Lname = txtLname.getText();
        City = txtCity.getText();
        Age = txtComboAge.getSelectedItem().toString();
        
        try {
            InputStream input = new FileInputStream(path2);
            pst = con.prepareStatement("insert into record(fname,lname,city,age,gender,photo) values(?,?,?,?,?,?)");
            pst.setString(1, Fname);
            pst.setString(2, Lname);
            pst.setString(3, City);
            pst.setString(4, Age);
            pst.setString(5, gender);
            pst.setBlob(6, input);
            pst.executeUpdate();
            JOptionPane.showInternalMessageDialog(null, "RECORD SAVED");
            updateTable();
            txtFname.setText("");
            txtLname.setText("");
            txtCity.setText("");
            txtComboAge.setSelectedIndex(-1);
            l_photo.setIcon(null);
            txtFname.requestFocus();
        } catch (Exception ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        //table click
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int row = jTable1.getSelectedRow();
        int id = Integer.parseInt(model.getValueAt(row, 0).toString());
        txtFname.setText(model.getValueAt(row, 1).toString());
        txtLname.setText(model.getValueAt(row, 2).toString());
        txtCity.setText(model.getValueAt(row, 3).toString());
        txtComboAge.setSelectedItem(model.getValueAt(row, 4));
        gender = model.getValueAt(row, 5).toString();
        if(gender.equals("Male")){
            Male.setSelected(true);
        }else{
            Female.setSelected(true);
        }
        Blob image =(Blob)model.getValueAt(row, 6);
        String path ="C:\\Users\\Feyesel Sultan\\Desktop\\Image\\img.jpg";
        
        try {
            byte[] byt = image.getBytes(1, (int)image.length());
            FileOutputStream fos = new FileOutputStream(path);
            fos.write(byt);
            ImageIcon icon = new ImageIcon(byt);
            l_photo.setIcon(icon);
            path2=path;
        } catch (Exception ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // clear btn
        txtFname.setText("");
            txtLname.setText("");
            txtCity.setText("");
            txtComboAge.setSelectedIndex(-1);
            l_photo.setIcon(null);
            txtFname.requestFocus();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        //btn update
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int row = jTable1.getSelectedRow();
        
        int id = Integer.parseInt(model.getValueAt(row, 0).toString());
        
        String Fname, Lname, City, Age;
        Fname=txtFname.getText();
        Lname=txtLname.getText();
        City=txtCity.getText();
        Age=txtComboAge.getSelectedItem().toString();
        
        try {
            InputStream input = new FileInputStream(new File(path2));
            
            pst = con.prepareStatement("update record set fname=?, lname=?, city=?,age=?,gender=?,photo=? where id=?");
            pst.setString(1,Fname);
            pst.setString(2,Lname);
            pst.setString(3,City);
            pst.setString(4,Age);
            pst.setString(5,gender);
            pst.setBlob(6,input);
            pst.setInt(7,id);
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "RECORD UPDATED");
            updateTable();
            txtFname.setText("");
            txtLname.setText("");
            txtCity.setText("");
            txtComboAge.setSelectedIndex(-1);
            l_photo.setIcon(null);
            txtFname.requestFocus();
        } catch (Exception ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // delete btn
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int row = jTable1.getSelectedRow();
        
        int id = Integer.parseInt(model.getValueAt(row, 0).toString());
        
        try {
            pst = con.prepareStatement("delete from record where id=?");
            pst.setInt(1, id);
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "REcord Deleted");
            updateTable();
            txtFname.setText("");
            txtLname.setText("");
            txtCity.setText("");
            txtComboAge.setSelectedIndex(-1);
            l_photo.setIcon(null);
            txtFname.requestFocus();
        } catch (Exception ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Female;
    private javax.swing.JRadioButton Male;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpload;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel l_photo;
    private javax.swing.JTextField txtCity;
    private javax.swing.JComboBox<String> txtComboAge;
    private javax.swing.JTextField txtFname;
    private javax.swing.JTextField txtLname;
    // End of variables declaration//GEN-END:variables
}
