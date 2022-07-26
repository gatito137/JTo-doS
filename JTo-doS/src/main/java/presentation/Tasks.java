package presentation;

public class Tasks extends javax.swing.JPanel {
    private Menu m;
    
    public Tasks() {
        initComponents();
    }
    
    protected void setMenu(Menu menu){
        this.m = menu;
        
        m.use.query.setLength(0);
        m.use.query.append("select Description from Status;");
        m.use.execute.fillList(m.use.query.toString(), lstStatus);
    }
    
    protected void refresh(String Options){
        m.use.query.setLength(0);
        m.use.query.append("select t.Task, s.Description, t.Description ");
        m.use.query.append("from Tasks as t ");
        m.use.query.append("inner join Status s on s.StatusCode = t.StatusCode ");
        m.use.query.append(Options);
        m.use.query.append("order by Task;");
        
        tabMain.setModel(m.use.execute.getTable(m.use.query.toString()));
        
        btnAdd.setText("Add");
        txtTask.setEnabled(true);
        
        //Clean controls
        txtTask.setText("");
        lstStatus.setSelectedIndex(0);
        txtDescription.setText("");
    }
    
    private void validateAllTexts(){
        txtTask.setText(String.valueOf(m.use.getNat(txtTask.getText(), -1)));
        txtDescription.setText(m.use.getCleanText(txtDescription.getText()));
    }
    
    private void save(){
        m.use.query.setLength(0);
        m.use.query.append("select TaskCode from Tasks where Task = ").append(txtTask.getText()).append(";");
        int TaskCode = m.use.execute.getNat(m.use.query.toString(), 0);
        
        m.use.query.setLength(0);
        if(TaskCode == 0){
            m.use.query.append("insert into Tasks(Task, Description, Status) ");
            m.use.query.append("values(");
            m.use.query.append(txtTask.getText()).append(", '");
            m.use.query.append(txtDescription.getText()).append("', ");
            m.use.query.append("(select StatusCode from Status where Description = '").append(lstStatus.getSelectedItem()).append("')");
            m.use.query.append(");");
        }else{
            m.use.query.append("update Tasks set ");
            m.use.query.append("Status = (select StatusCode from Status where Description = '").append(lstStatus.getSelectedItem()).append("'), ");
            m.use.query.append("Description = '").append(txtDescription.getText()).append("' ");
            m.use.query.append("where StatusCode = ").append(TaskCode).append(";");
        }
        m.use.execute.executeQuery(m.use.query.toString());
        
        refresh("");
        m.use.msg("The data has been updated successfully!");
        
        if(chkForms.isSelected() == false){
            return;
        }
        
        m.use.query.setLength(0);
        m.use.query.append("(select Task from Tasks where TaskCode = ").append(TaskCode).append(")");
        m.show("forms", m.use.execute.getVal(m.use.query.toString()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTasks = new javax.swing.JToggleButton();
        pnlTab = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabMain = new javax.swing.JTable();
        pnlFields = new javax.swing.JPanel();
        lstStatus = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        btnAdd = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTask = new javax.swing.JTextField();
        btnRefresh = new javax.swing.JButton();
        chkForms = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(255, 255, 255));

        btnTasks.setText("Tasks");
        btnTasks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTasksActionPerformed(evt);
            }
        });

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
        jScrollPane2.setViewportView(tabMain);

        javax.swing.GroupLayout pnlTabLayout = new javax.swing.GroupLayout(pnlTab);
        pnlTab.setLayout(pnlTabLayout);
        pnlTabLayout.setHorizontalGroup(
            pnlTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlTabLayout.setVerticalGroup(
            pnlTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtDescription.setColumns(20);
        txtDescription.setLineWrap(true);
        txtDescription.setRows(5);
        jScrollPane1.setViewportView(txtDescription);

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel1.setText("Task:");

        jLabel2.setText("Status:");

        jLabel3.setText("Description:");

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFieldsLayout = new javax.swing.GroupLayout(pnlFields);
        pnlFields.setLayout(pnlFieldsLayout);
        pnlFieldsLayout.setHorizontalGroup(
            pnlFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFieldsLayout.createSequentialGroup()
                .addContainerGap(123, Short.MAX_VALUE)
                .addGroup(pnlFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFieldsLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(pnlFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lstStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTask, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(42, 42, 42))
            .addGroup(pnlFieldsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRefresh)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlFieldsLayout.setVerticalGroup(
            pnlFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFieldsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTask, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lstStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(pnlFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnRefresh))
                .addContainerGap())
        );

        chkForms.setText("Show forms");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlFields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTasks)
                        .addGap(18, 18, 18)
                        .addComponent(chkForms)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTasks)
                    .addComponent(chkForms))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlFields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(237, 237, 237))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTasksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTasksActionPerformed
        if(btnTasks.isSelected()){
            pnlTab.setVisible(false);
        }else{
            pnlTab.setVisible(true);
        }
    }//GEN-LAST:event_btnTasksActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        refresh("");
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void tabMainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabMainMouseClicked
        btnAdd.setText("Update");
        txtTask.setEnabled(false);
        txtTask.setText(tabMain.getValueAt(tabMain.getSelectedRow(), 0).toString());
        lstStatus.setSelectedItem(tabMain.getValueAt(tabMain.getSelectedRow(), 1).toString());
        txtDescription.setText(tabMain.getValueAt(tabMain.getSelectedRow(), 2).toString());
        btnTasks.setSelected(true);
        pnlTab.setVisible(false);
        
        if(chkForms.isSelected() == false){
            return;
        }
        
        m.show("forms", tabMain.getValueAt(tabMain.getSelectedRow(), 0).toString());
    }//GEN-LAST:event_tabMainMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if(m.use.confirm("Are you sure you want " + btnAdd.getText() + " this task?") != 0){
            return;
        }
        
        validateAllTexts();
        
        if(txtTask.getText().equals("-1")){
            m.use.msg("This isn't a valid task.");
            txtTask.setText("");
            txtTask.requestFocus();
            return;
        }
        
        if(lstStatus.getSelectedIndex() == 0){
            m.use.msg("You must select a status.");
            return;
        }
        
        save();
    }//GEN-LAST:event_btnAddActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JToggleButton btnTasks;
    private javax.swing.JCheckBox chkForms;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> lstStatus;
    private javax.swing.JPanel pnlFields;
    private javax.swing.JPanel pnlTab;
    private javax.swing.JTable tabMain;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtTask;
    // End of variables declaration//GEN-END:variables
}
