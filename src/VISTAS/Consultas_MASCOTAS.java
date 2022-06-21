/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTAS;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import veterinaria_MODELO.Mascota;


public class Consultas_MASCOTAS extends javax.swing.JInternalFrame {


    public Consultas_MASCOTAS() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel(){
            String str="/IMAGENES/fondo_MASCOTA.png";
            ImageIcon icon = new ImageIcon(getClass().getResource(str));
            Image image = icon.getImage();

            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0,getWidth(),getHeight(), this);
            }
        };
        jlALIAS = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jlNOMBRE = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jlCONTACTO_ALTERNATIVO1 = new javax.swing.JLabel();
        jlALIAS1 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jlAPELLIDO3 = new javax.swing.JLabel();
        jlAPELLIDO5 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jSeparator5 = new javax.swing.JSeparator();
        jtEspecie = new javax.swing.JTextField();
        jtPesoActual = new javax.swing.JTextField();
        jtRaza = new javax.swing.JTextField();
        jtSexo = new javax.swing.JTextField();
        jtAlias = new javax.swing.JTextField();
        jtDNI = new javax.swing.JTextField();

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

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlALIAS.setBackground(new java.awt.Color(255, 255, 255));
        jlALIAS.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlALIAS.setForeground(new java.awt.Color(255, 255, 255));
        jlALIAS.setText("DNI Dueño:");
        jPanel1.add(jlALIAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, -1, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 580, 10));

        jlNOMBRE.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlNOMBRE.setForeground(new java.awt.Color(255, 255, 255));
        jlNOMBRE.setText("Raza:");
        jPanel1.add(jlNOMBRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 70, 20));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 590, 10));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Mascota", "Alias", "Sexo", "Especie", "ID Cliente", "Fecha Nacimiento", "Peso Actual", "Activo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 590, 180));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/close.png"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 60, 50));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/search.png"))); // NOI18N
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 60, 50));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/clear.png"))); // NOI18N
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 60, 50));

        jlCONTACTO_ALTERNATIVO1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlCONTACTO_ALTERNATIVO1.setForeground(new java.awt.Color(255, 255, 255));
        jlCONTACTO_ALTERNATIVO1.setText("Sexo:");
        jPanel1.add(jlCONTACTO_ALTERNATIVO1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, 50, 20));

        jlALIAS1.setBackground(new java.awt.Color(255, 255, 255));
        jlALIAS1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlALIAS1.setForeground(new java.awt.Color(255, 255, 255));
        jlALIAS1.setText("ALIAS:");
        jPanel1.add(jlALIAS1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, -1, -1));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 630, 10));

        jlAPELLIDO3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlAPELLIDO3.setForeground(new java.awt.Color(255, 255, 255));
        jlAPELLIDO3.setText("Especie:");
        jPanel1.add(jlAPELLIDO3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 70, 20));

        jlAPELLIDO5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlAPELLIDO5.setForeground(new java.awt.Color(255, 255, 255));
        jlAPELLIDO5.setText("Peso actual :");
        jPanel1.add(jlAPELLIDO5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 90, 20));

        jRadioButton1.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Activo");
        jRadioButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 80, 20));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 328, 620, 0));
        jPanel1.add(jtEspecie, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 110, -1));
        jPanel1.add(jtPesoActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 110, -1));
        jPanel1.add(jtRaza, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 100, -1));
        jPanel1.add(jtSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, 90, -1));
        jPanel1.add(jtAlias, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 140, -1));
        jPanel1.add(jtDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, 120, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        ArrayList<String> filtros = new ArrayList<String>();
        ArrayList<String> valores = new ArrayList<String>();

        // if jtAlias is not empty add it to the filter alias
        if (!jtAlias.getText().isEmpty()) {
            filtros.add("alias");
            valores.add(jtAlias.getText());
        }
        // if jtSexo is not empty add it to the filter sexo
        if (!jtSexo.getText().isEmpty()) {
            filtros.add("sexo");
            valores.add(jtSexo.getText());
        }
        // if jtEspecie is not empty add it to the filter especie
        if (!jtEspecie.getText().isEmpty()) {
            filtros.add("especie");
            valores.add(jtEspecie.getText());
        }
        // if jtRaza is not empty add it to the filter raza
        if (!jtRaza.getText().isEmpty()) {
            filtros.add("raza");
            valores.add(jtRaza.getText());
        }
        // if jtPeso is not empty add it to the filter peso
        if (!jtPesoActual.getText().isEmpty()) {
            filtros.add("peso_actual");
            valores.add(jtPesoActual.getText());
        }
        // if jtDNI is not empty add it to the filter id_cliente
        if (!jtDNI.getText().isEmpty()) {
            filtros.add("id_cliente");
            valores.add(Integer.toString(Menu_PRINCIPAL_VETERINARIA.cd.buscarClientexDNI(Long.parseLong(jtDNI.getText())).getId_cliente()));
        }
        
        String i = "0";
        if (jRadioButton1.isSelected()) {
            i = "1";
        }
        
        filtros.add("activo");
        valores.add(i);

        List<Mascota> mascotas = Menu_PRINCIPAL_VETERINARIA.md.obtenerMascotasConFiltro(filtros, valores);
        if (mascotas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontraron mascotas con los filtros ingresados");
        } else {
            rellenarTabla(mascotas);
        }

    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        limpiarFormulario();
    }//GEN-LAST:event_jLabel7MouseClicked
    
        public void limpiarFormulario(){
        jtAlias.setText("");
        jtDNI.setText("");
        jtEspecie.setText("");
        jtPesoActual.setText("");
        jtRaza.setText("");
        jtSexo.setText("");
    }
    public void rellenarTabla(List<Mascota> p_mascota) {
        DefaultTableModel modelo = (DefaultTableModel) jTable2.getModel();
        modelo.setRowCount(0);
        for (Mascota mascota : p_mascota) {
            modelo.addRow(new Object[]{mascota.getId_mascota(), mascota.getAlias(), mascota.getSexo(), mascota.getEspecie(), mascota.getCliente().getId_cliente(), mascota.getRaza(), mascota.getPeso_actual(), mascota.isActivo()});
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel jlALIAS;
    private javax.swing.JLabel jlALIAS1;
    private javax.swing.JLabel jlAPELLIDO3;
    private javax.swing.JLabel jlAPELLIDO5;
    private javax.swing.JLabel jlCONTACTO_ALTERNATIVO1;
    private javax.swing.JLabel jlNOMBRE;
    private javax.swing.JTextField jtAlias;
    private javax.swing.JTextField jtDNI;
    private javax.swing.JTextField jtEspecie;
    private javax.swing.JTextField jtPesoActual;
    private javax.swing.JTextField jtRaza;
    private javax.swing.JTextField jtSexo;
    // End of variables declaration//GEN-END:variables
}
