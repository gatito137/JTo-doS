package presentation;

import java.awt.Color;
import javax.swing.JOptionPane;

public class LogIn extends javax.swing.JPanel {
    private Menu menu;
    
    public LogIn() {
        initComponents();
        
        ValidateFields(3);
    }
    
    protected void setMenu(Menu menu){
        this.menu = menu;
    }
    
    private void ValidateFields(int Optional){
        txtUser.setText(txtUser.getText().trim());
        
        switch(Optional){
            case 1->{
                //Focus gained
                if(txtUser.getText().equals("User")){
                    txtUser.setText("");
                    txtUser.setForeground(new Color(0, 0, 0));
                    return;
                }
                
                //Focus lost
                if(txtUser.getText().equals("")){
                    txtUser.setText("User");
                    txtUser.setForeground(new Color(153, 153, 153));
                }
            }
            
            case 2->{
                //Focus gained
                if(txtPassword.getText().equals("Password")){
                    txtPassword.setText("");
                    txtPassword.setForeground(new Color(0, 0, 0));
                    return;
                }
                
                //Focus lost
                if(txtPassword.getText().equals("")){
                    txtPassword.setText("Password");
                    txtPassword.setForeground(new Color(153, 153, 153));
                }
            }
            
            default->{
                txtUser.setText("User");
                txtUser.setForeground(new Color(153, 153, 153));
                txtPassword.setText("Password");
                txtPassword.setForeground(new Color(153, 153, 153));
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUser = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();

        txtUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUserFocusLost(evt);
            }
        });

        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPasswordFocusLost(evt);
            }
        });

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(btnLogin)))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLogin)
                .addContainerGap(102, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserFocusGained
        ValidateFields(1);
    }//GEN-LAST:event_txtUserFocusGained

    private void txtUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserFocusLost
        ValidateFields(1);
    }//GEN-LAST:event_txtUserFocusLost

    private void txtPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusGained
        ValidateFields(2);
    }//GEN-LAST:event_txtPasswordFocusGained

    private void txtPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusLost
        ValidateFields(2);
    }//GEN-LAST:event_txtPasswordFocusLost

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        txtUser.setText(txtUser.getText().trim());
        txtPassword.setText(txtPassword.getText().trim());
        
        if(txtUser.getText().equals("") || txtUser.getText().equals("User")){
            JOptionPane.showMessageDialog(null, "Debe ingresar un usuario.");
            txtUser.requestFocus();
            return;
        }
        
        if(txtPassword.getText().equals("") || txtPassword.getText().equals("Password")){
            JOptionPane.showMessageDialog(null, "Debe ingresar una contraseña.");
            txtPassword.requestFocus();
            return;
        }
        
        connection.Jason execute = new connection.Jason("Users");
        
        if(execute.getCount("User", txtUser.getText()) == 0){
            JOptionPane.showMessageDialog(null, "El usuario no existe.");
            txtUser.setText("User");
            txtUser.requestFocus();
            return;
        }
        
        if(execute.getCount("Pass", txtPassword.getText()) == 0){
            JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
            txtPassword.setText("Password");
            txtPassword.requestFocus();
            return;
        }
        
        JOptionPane.showMessageDialog(null, "Login exitoso");
        menu.unlock(execute.getNat("Permission", 0));
        
        txtUser.setText("User");
        txtUser.setForeground(new Color(153, 153, 153));
        txtPassword.setText("Password");
        txtPassword.setForeground(new Color(153, 153, 153));
    }//GEN-LAST:event_btnLoginActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}