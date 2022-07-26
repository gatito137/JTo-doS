package presentation;

public class Forms extends javax.swing.JPanel {
    private Menu m;
    
    public Forms() {
        initComponents();
    }
    
    protected void setMenu(Menu menu){
        this.m = menu;
    }
    
    protected void refresh(String Task){
        lblTask.setText("All");
        
        //Fill list
        m.use.query.setLength(0);
        m.use.query.append("select Description from Forms ");
        m.use.query.append("order by Description;");
        m.use.execute.fillList(m.use.query.toString(), lstForms);
        
        //Fill table
        m.use.query.setLength(0);
        m.use.query.append("select f.Description, f.Status from Forms f ");
        if(!Task.equals("")){
            m.use.query.append("inner join TaskToForm ttf on ttf.FormCode = f.FormCode ");
            m.use.query.append("where ttf.TaskCode = (select TaskCode from Tasks where Task = ").append(Task).append(") ");
            m.use.query.append("and f.Status = 1 ");
            lblTask.setText(Task);
        }
        m.use.query.append("order by f.Description;");
        tabMain.setModel(m.use.execute.getTable(m.use.query.toString()));
        
        btnAssign.setEnabled(!Task.equals(""));
        btnRemove.setEnabled(!Task.equals(""));
        lblForm.setText("All");
        btnAdd.setText("Add");
    }
    
    private void save(String Form){
        m.use.query.setLength(0);
        m.use.query.append("select FormCode from Forms where Description = '").append(Form).append("';");
        int FormCode = m.use.execute.getNat(m.use.query.toString(), 0);
        
        m.use.query.setLength(0);
        if(FormCode == 0 && lblForm.getText().equals("All")){
            m.use.query.append("insert into Forms (Description, Status) values('");
            m.use.query.append(Form).append("', ");
            m.use.query.append(lstStatus.getSelectedIndex()).append(");");
        }else{
            m.use.query.append("update Forms set ");
            m.use.query.append("Description = '").append(Form).append("', ");
            m.use.query.append("Status = ").append(lstStatus.getSelectedIndex()).append(" ");
            m.use.query.append("where FormCode = ").append(m.use.execute.getNat("select FormCode from Forms where Description = '" + lblForm.getText() + "';", 0)).append(";");
        }
        m.use.execute.executeQuery(m.use.query.toString());
        
        refresh("");
        m.use.msg("The data has been updated sucessfully!");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabMain = new javax.swing.JTable();
        lstForms = new javax.swing.JComboBox<>();
        btnAssign = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblTask = new javax.swing.JLabel();
        btnRemove = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblForm = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lstStatus = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));

        tabMain.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabMainMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabMain);

        lstForms.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        lstForms.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                lstFormsItemStateChanged(evt);
            }
        });

        btnAssign.setText("Assign");
        btnAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignActionPerformed(evt);
            }
        });

        jLabel1.setText("Task:");

        lblTask.setText("jLabel2");

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel2.setText("Form:");

        lblForm.setText("jLabel3");

        jLabel3.setText("Status:");

        lstStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inactive", "Active" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lstForms, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblForm)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTask)
                            .addComponent(lstStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRefresh)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAssign)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRemove)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblForm))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lstForms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRemove)
                            .addComponent(btnAssign)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblTask))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete)
                            .addComponent(btnAdd)
                            .addComponent(btnRefresh)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lstStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignActionPerformed
        if(lblForm.getText().equals("All")){
            m.use.msg("You must select a form to assign.");
            return;
        }
        
        if(m.use.confirm("Are you sure you want assign this form to this task?") != 0){
            return;
        }
        
        m.use.query.setLength(0);
        m.use.query.append("select count(1) from TaskToForm ttf ");
        m.use.query.append("inner join Tasks t on t.TaskCode = ttf.TaskCode ");
        m.use.query.append("where t.Task = ").append(lblTask.getText()).append(" and ");
        m.use.query.append("ttf.FormCode = (select FormCode from Forms where Description = '").append(lblForm.getText()).append("');");
        m.use.msg(m.use.query.toString());
        if(m.use.execute.getNat(m.use.query.toString(), 0) > 0){
            m.use.msg("This form already has been assignated to this task.");
            return;
        }
        
        m.use.query.setLength(0);
        m.use.query.append("insert into TaskToForm (TaskCode, FormCode) ");
        m.use.query.append("values (");
        m.use.query.append("(select TaskCode from Tasks where Task = ").append(lblTask.getText()).append("), ");
        m.use.query.append("(select FormCode from Forms where Description = '").append(lblForm.getText()).append("')");
        m.use.query.append(");");
        m.use.execute.executeQuery(m.use.query.toString());
        
        refresh(lblTask.getText());
    }//GEN-LAST:event_btnAssignActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        if(lblTask.getText().equals("All")){
            refresh("");
        }else{
            refresh(lblTask.getText());
        }
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        if(tabMain.getSelectedRow() == -1){
            m.use.msg("You must select a form to unassing.");
            return;
        }
        
        if(m.use.confirm("Are you sure you want unassign this form to this task?") != 0){
            return;
        }
        
        m.use.query.setLength(0);
        m.use.query.append("delete from TaskToForm where ");
        m.use.query.append("TaskCode = (select TaskCode from Tasks where Task = ").append(lblTask.getText()).append(") and ");
        m.use.query.append("FormCode = (select FormCode from Forms where Description  = '").append(lblForm.getText()).append("');");
        m.use.execute.executeQuery(m.use.query.toString());
        
        refresh(lblTask.getText());
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if(lblForm.getText().equals("All")){
            m.use.msg("You must select a form from list.");
            return;
        }
        
        if(m.use.confirm("Are you sure you want delete this form?") != 0){
            return;
        }
        
        m.use.query.setLength(0);
        m.use.query.append("select count(1) from Forms f ");
        m.use.query.append("inner join TaskToForm ttf on ttf.FormCode = f.FormCode ");
        m.use.query.append("where ttf.FormCode = (select FormCode from Forms where Description = '").append(lblForm.getText()).append("');");
        if(m.use.execute.getNat(m.use.query.toString(), 1) > 0){
            m.use.query.setLength(0);
            m.use.query.append("update Forms set Status = 0 ");
            m.use.query.append("where FormCode = ");
        }else{
            m.use.query.setLength(0);
            m.use.query.append("delete from Forms where FormCode = ");
        }
        m.use.query.append(m.use.execute.getNat("select FormCode from Forms where Description = '" + lblForm.getText() + "';", 0)).append(";");
        m.use.execute.executeQuery(m.use.query.toString());
        
        refresh("");
        m.use.msg("The data has been updated successfully!");
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tabMainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabMainMouseClicked
        btnAdd.setText("Update");
        lblForm.setText(tabMain.getValueAt(tabMain.getSelectedRow(), 0).toString());
        if(tabMain.getValueAt(tabMain.getSelectedRow(), 1).toString().equals("false")){
            lstStatus.setSelectedIndex(0);
        }else{
            lstStatus.setSelectedIndex(1);
        }
    }//GEN-LAST:event_tabMainMouseClicked

    private void lstFormsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_lstFormsItemStateChanged
        try{
            lblForm.setText(lstForms.getSelectedItem().toString());
            btnAdd.setText("Updated");
        }catch(Exception e){
            lblForm.setText("All");
        }
        
        if(lblForm.getText().equals("")){
            lblForm.setText("All");
        }
    }//GEN-LAST:event_lstFormsItemStateChanged

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String Form;
        
        try{
            if(lblForm.getText().equals("All")){
                Form = m.use.input("Enter the name for the form:", "");
            }else{
                Form = m.use.input("Enter the new name for the form:", lblForm.getText());
            }
        }catch(Exception e){
            Form = "";
        }
        
        if(Form.equals("")){
            m.use.msg("This isn't a valid name.");
            return;
        }
        
        save(Form);
    }//GEN-LAST:event_btnAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAssign;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRemove;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblForm;
    private javax.swing.JLabel lblTask;
    private javax.swing.JComboBox<String> lstForms;
    private javax.swing.JComboBox<String> lstStatus;
    private javax.swing.JTable tabMain;
    // End of variables declaration//GEN-END:variables
}
