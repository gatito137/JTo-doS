package presentation;

public class SingleTask extends javax.swing.JPanel {
    private Menu m;
    
    public SingleTask() {
        initComponents();
    }
    
    protected void setMenu(Menu menu){
        this.m = menu;
    }
    
    protected void refresh(){
        m.execute.fillList("select Description from Status order by Description;", lstStatus);
        
        //Clean controls
        txtCode.setText("");
        txtDescription.setText("");
        lstStatus.setSelectedIndex(0);
        
        btnSave.setText("Save");
        txtCode.setEnabled(true);
    }
    
    private void ValidateFields(){
        txtCode.setText(String.valueOf(m.use.getNat(txtCode.getText(), -1)));
        txtDescription.setText(m.use.getCleanText(txtDescription.getText()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        lstStatus = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        btnSave = new javax.swing.JButton();
        btnFilter = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Code:");

        jLabel2.setText("Status:");

        jLabel3.setText("Description:");

        txtDescription.setColumns(20);
        txtDescription.setLineWrap(true);
        txtDescription.setRows(5);
        txtDescription.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDescriptionFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(txtDescription);

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnFilter.setText("Filter");
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCode)
                                    .addComponent(lstStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 81, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFilter)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lstStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnFilter))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        ValidateFields();
        
        if(m.use.confirm("Are you sure you want to " + btnSave.getText() + " this record?") != 0){
            return;
        }
        
        if(txtCode.getText().equals("-1")){
            m.use.msg("This isn't a valid task number.");
            refresh();
            return;
        }
        
        m.query.setLength(0);
        m.query.append("select count(1) from Tasks where TaskCode = ").append(txtCode.getText()).append(";");
        if(m.execute.getNat(m.query.toString(), -1) > 0){
            m.query.setLength(0);
            m.query.append("set @Status = ").append(m.execute.getNat("select StatusCode from Status where Description = '" + lstStatus.getSelectedItem() + "';", 0)).append(";");
            m.query.append("set @Desc = '").append(txtDescription.getText()).append("';");
            m.query.append("set @Code = ").append(m.execute.getNat("select TaskCode from Tasks where Task = " + txtCode.getText() + ";", 0)).append(";");
            m.query.append("update Tasks set ");
            m.query.append("Description = @Desc, ");
            m.query.append("StatusCode = @Status ");
            m.query.append("where TaskCode = @Code;");
        }else{
            m.query.setLength(0);
            m.query.append("set @Desc = '").append(txtDescription.getText()).append("';");
            m.query.append("set @Status = ").append(m.execute.getNat("select StatusCode from Status where Description = '" + lstStatus.getSelectedItem() + "';", 0)).append(";");
            m.query.append("set @Code = ").append(txtCode.getText()).append(";");
            m.query.append("insert into Tasks(Description, StatusCode, Task) ");
            m.query.append("values(@Desc, @Status, @Code);");
        }
        
        m.execute.executeQuery(m.query.toString());
        
        refresh();
        m.use.msg("The data has been " + btnSave.getText() + "d successfully!");
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        ValidateFields();
        
        if(txtCode.getText().equals("-1")){
            m.use.msg("This isn't a valid task number.");
            return;
        }
    }//GEN-LAST:event_btnFilterActionPerformed

    private void txtDescriptionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescriptionFocusLost
        if(txtDescription.getText().length() > 100){
            txtDescription.setText(txtDescription.getText().substring(0, 99));
        }
    }//GEN-LAST:event_txtDescriptionFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> lstStatus;
    protected javax.swing.JTextField txtCode;
    private javax.swing.JTextArea txtDescription;
    // End of variables declaration//GEN-END:variables
}
