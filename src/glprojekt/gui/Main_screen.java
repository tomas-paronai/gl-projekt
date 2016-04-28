/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glprojekt.gui;

import glprojekt.api.OnDataChange;
import glprojekt.api.database.HandlerDB;
import glprojekt.api.database.Select;
import glprojekt.api.dataholders.Employee;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bubo
 */
public class Main_screen extends ParentWindow implements OnDataChange {

    private ParentWindow currentWindow;
    private ArrayList<Employee> listOfEmployees;  

    public Main_screen(OnDataChange listener) {
        super(listener);
        initComponents();
        this.getContentPane().setBackground(new Color(106, 159, 240));
        dataChanged();
    }

    @Override
    public void dataChanged() {
        Select select = new Select(handlerDB);

        try {

            String tableQuery = "SELECT employee.employeeid,firstname,surname,positionname FROM employee "
                    + "left join employment_detail on employee.employeeid=employment_detail.employeeid "
                    + "left join `position` on employment_detail.positionid=position.positionid";
            select.selectWithQuery(tableQuery);
            EmployeesTable.setModel(new DefaultTableModel(select.getData(), select.getColumns()));

            String detailQuery = "SELECT * FROM employee "
                    + "left join address on employee.employeeid=address.employeeid "
                    + "left join contact on employee.employeeid=contact.employeeid "
                    + "left join employment_detail on employee.employeeid=employment_detail.employeeid "
                    + "left join `position` on employment_detail.positionid=position.positionid "
                    + "left join contract on employment_detail.contractid=contract.contractid";
            listOfEmployees = Employee.parseEmployee(handlerDB.executeForResult(detailQuery));
            System.out.println(listOfEmployees.size());

        } catch (HandlerDB.DBHandlerException ex) {
            ex.printStackTrace();
        }

    }

    public void openNewWindow(ParentWindow window) {
        if (currentWindow != null) {
            currentWindow.dispose();
        }
        currentWindow = window;
        currentWindow.setVisible(true);
    }

    @Override
    public void dispose() {
        notifyDataChange();
        super.dispose();
    }
    
     public String getIdForDelete(){
        String value=EmployeesTable.getValueAt(EmployeesTable.getSelectedRow(), 0).toString();
        return value;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        EmployeesTable = new javax.swing.JTable();
        mainScrIUpdate = new javax.swing.JButton();
        mainScrDelte = new javax.swing.JButton();
        mainScrSave = new javax.swing.JButton();
        mainScrInsert = new javax.swing.JButton();
        employeeSurname = new javax.swing.JLabel();
        jRefreshButton = new javax.swing.JButton();
        SearchEmployee = new javax.swing.JButton();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        employeeDoB = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        employeeAddress = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        employeeCity = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        employeePhone = new javax.swing.JLabel();
        employeeEmail = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        employeeHours = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        employeeHourWage = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        employeeDoE = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(106, 159, 240));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.white);

        EmployeesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Surname", "Position"
            }
        ));
        EmployeesTable.setRowHeight(23);
        EmployeesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EmployeesTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(EmployeesTable);

        mainScrIUpdate.setBackground(new java.awt.Color(102, 102, 102));
        mainScrIUpdate.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        mainScrIUpdate.setForeground(new java.awt.Color(51, 51, 51));
        mainScrIUpdate.setText("Update Employee");
        mainScrIUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainScrIUpdateActionPerformed(evt);
            }
        });

        mainScrDelte.setBackground(new java.awt.Color(102, 102, 102));
        mainScrDelte.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        mainScrDelte.setForeground(new java.awt.Color(51, 51, 51));
        mainScrDelte.setText("Delete employee");
        mainScrDelte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainScrDelteActionPerformed(evt);
            }
        });

        mainScrSave.setBackground(new java.awt.Color(102, 102, 102));
        mainScrSave.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        mainScrSave.setForeground(new java.awt.Color(51, 51, 51));
        mainScrSave.setText("Save all");

        mainScrInsert.setBackground(new java.awt.Color(102, 102, 102));
        mainScrInsert.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        mainScrInsert.setForeground(new java.awt.Color(51, 51, 51));
        mainScrInsert.setText("Insert Employee");
        mainScrInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainScrInsertActionPerformed(evt);
            }
        });

        jRefreshButton.setText("Refresh");
        jRefreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRefreshButtonActionPerformed(evt);
            }
        });

        SearchEmployee.setText("Search Employee");
        SearchEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchEmployeeActionPerformed(evt);
            }
        });

        jTabbedPane4.setToolTipText("");

        jLabel9.setText("Date of birth");

        employeeDoB.setText("-");

        jLabel10.setText("Adress");

        employeeAddress.setText("-");

        jLabel11.setText("City");

        employeeCity.setText("-");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(employeeAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(employeeCity, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(employeeDoB, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(494, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(employeeDoB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(employeeAddress)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(employeeCity)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Basic Info", jPanel2);

        jLabel12.setText("Phone Number");

        jLabel13.setText("Email");

        employeePhone.setText("-");

        employeeEmail.setText("-");
        employeeEmail.setToolTipText("");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(employeeEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(employeePhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(532, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(employeePhone)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(employeeEmail)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Contact", jPanel3);

        jLabel14.setText("Hours Worked");

        employeeHours.setText("-");

        jLabel15.setText("Salary 1/h");

        employeeHourWage.setText("-");

        jLabel16.setText("Date of employment");

        employeeDoE.setText("-");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel16)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(employeeDoE, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(employeeHourWage, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(employeeHours, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(465, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(employeeHours)
                .addGap(13, 13, 13)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(employeeHourWage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(employeeDoE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Work Info", jPanel1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Arrival time", "Leaving time", "Hours Worked (day)"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        jTabbedPane4.addTab("Attendance", jScrollPane3);

        jMenuBar1.setBackground(new java.awt.Color(106, 159, 240));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane2)
                                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRefreshButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(SearchEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mainScrInsert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mainScrIUpdate)
                        .addGap(67, 67, 67)
                        .addComponent(mainScrDelte)
                        .addGap(39, 39, 39)
                        .addComponent(mainScrSave, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(employeeSurname)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jRefreshButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(employeeSurname)
                                .addGap(700, 700, 700))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(mainScrSave, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mainScrDelte, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mainScrIUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mainScrInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(SearchEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(700, 700, 700))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mainScrInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainScrInsertActionPerformed
        openNewWindow(new Add_employee(this));
    }//GEN-LAST:event_mainScrInsertActionPerformed

    private void mainScrIUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainScrIUpdateActionPerformed
        openNewWindow(new Update_employee(this));
    }//GEN-LAST:event_mainScrIUpdateActionPerformed

    private void mainScrDelteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainScrDelteActionPerformed
        int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to delele this employee?", "Close?", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
               String id = getIdForDelete();
               String query ="DELETE  FROM employee where employeeId like '"+id+"'";
               if(handlerDB.executeManipulate(query)){
                  JOptionPane.showMessageDialog(null,"Employee has been deleted");
                  dataChanged();
               }
               else
               JOptionPane.showMessageDialog(null,"Error! Problem with deleting employee");
        }
    }//GEN-LAST:event_mainScrDelteActionPerformed
 

    private void EmployeesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmployeesTableMouseClicked
        Employee selectedEmployee = listOfEmployees.get(EmployeesTable.getSelectedRow());
        System.out.println(EmployeesTable.getSelectedRow()+" "+selectedEmployee.toString());
        
        //DoB
        employeeDoB.setText(selectedEmployee.getDateOfBirth().toString());

        //address
        employeeAddress.setText(selectedEmployee.getAddress().getStreet());

        //city
        employeeCity.setText(selectedEmployee.getAddress().getCity());

        //phone
        employeePhone.setText(selectedEmployee.getContact().getPhone());

        //emial
        employeeEmail.setText(selectedEmployee.getContact().getEmail());

        //salary
        //TODO
        //salary/1h
        employeeHourWage.setText(String.valueOf(selectedEmployee.getEmploymentInforamtion().getHourWage()));

        //DoE
        employeeDoE.setText(selectedEmployee.getEmploymentInforamtion().getEmployedSince().toString());
        
       getIdForDelete();

    }//GEN-LAST:event_EmployeesTableMouseClicked

    private void jRefreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRefreshButtonActionPerformed
        dataChanged();
    }//GEN-LAST:event_jRefreshButtonActionPerformed

    private void SearchEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchEmployeeActionPerformed
        openNewWindow(new Search_Employee(this, EmployeesTable));
    }//GEN-LAST:event_SearchEmployeeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable EmployeesTable;
    private javax.swing.JButton SearchEmployee;
    private javax.swing.JLabel employeeAddress;
    private javax.swing.JLabel employeeCity;
    private javax.swing.JLabel employeeDoB;
    private javax.swing.JLabel employeeDoE;
    private javax.swing.JLabel employeeEmail;
    private javax.swing.JLabel employeeHourWage;
    private javax.swing.JLabel employeeHours;
    private javax.swing.JLabel employeePhone;
    private javax.swing.JLabel employeeSurname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton jRefreshButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton mainScrDelte;
    private javax.swing.JButton mainScrIUpdate;
    private javax.swing.JButton mainScrInsert;
    private javax.swing.JButton mainScrSave;
    // End of variables declaration//GEN-END:variables

}
