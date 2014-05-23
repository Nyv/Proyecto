/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package princip;

import Renderes.FechaRenderer;
import Renderes.FirmaRenderer;
import Renderes.PrecioRenderer;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Nerea
 */
public class VentanaPrincp extends javax.swing.JFrame {
    Ejemploclase modelo;
    private boolean activado;
     /**
     * Creates new form VentanaPrincp
     */
    public VentanaPrincp() {
        initComponents();
        jButton6.setVisible(false);
        panelPrincp1.setEnabled(false);
        modelo = new Ejemploclase();
        //se le da la lista
        modelo.setDataList(list1);
        jTable1.setModel(modelo);
        //Dar formato precio
        jTable1.getColumnModel().getColumn(5).setCellRenderer(new PrecioRenderer());
        //Dar formato fecha
        jTable1.getColumnModel().getColumn(7).setCellRenderer(new FechaRenderer());
        //Dar formato genero
        jTable1.getColumnModel().getColumn(2).setCellRenderer(new FirmaRenderer());
        
        //Cambiar ancho de columnas
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(900);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(600);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(400);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(400);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(400);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(80);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(650);
        
        //Sólo se podrá seleccionar un intervalo de filas 
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Detectar un cambio en la selección de la tabla
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                int indiceFilaSeleccionada = jTable1.getSelectedRow();
                if(indiceFilaSeleccionada > -1){
                    Libros libro = list1.get(indiceFilaSeleccionada);
                    panelPrincp1.setLibro(libro);
                    panelPrincp1.showData(false);   
                }
            }
        });
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        entityManager1 = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("ProyectPU").createEntityManager();
        query1 = java.beans.Beans.isDesignTime() ? null : entityManager1.createQuery("SELECT l FROM Libros l");
        list1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : query1.getResultList();
        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        panelPrincp1 = new princip.PanelPrincp();
        panelBusqueda1 = new princip.PanelBusqueda();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 153));

        jToolBar1.setBackground(new java.awt.Color(255, 204, 153));
        jToolBar1.setForeground(new java.awt.Color(0, 204, 0));
        jToolBar1.setRollover(true);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Vr.png"))); // NOI18N
        jButton2.setToolTipText("Ver Libro");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setName("Ver"); // NOI18N
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Añad.png"))); // NOI18N
        jButton1.setToolTipText("Añadir Libro");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Mod.png"))); // NOI18N
        jButton3.setToolTipText("Modificar Libro");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Busc.png"))); // NOI18N
        jButton4.setToolTipText("Actualizar Libro");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Eliminar2.png"))); // NOI18N
        jButton5.setToolTipText("Eliminar Libro");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setMaximumSize(new java.awt.Dimension(63, 45));
        jButton5.setMinimumSize(new java.awt.Dimension(63, 45));
        jButton5.setPreferredSize(new java.awt.Dimension(63, 45));
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton5);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/guardar2.png"))); // NOI18N
        jButton6.setToolTipText("Guardar Libro");
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setMaximumSize(new java.awt.Dimension(63, 45));
        jButton6.setMinimumSize(new java.awt.Dimension(63, 45));
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton6);

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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jTabbedPane2.addTab("Libros", jScrollPane2);
        jTabbedPane2.addTab("Detalle", panelPrincp1);
        jTabbedPane2.addTab("Búsqueda", panelBusqueda1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 889, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 646, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Ver
        //Obtener el índice de la fila seleccionada en la tabla 
        int selectedRow = jTable1.getSelectedRow(); 
        //Obtener el objeto desde la lista de datos, conociendo su posición 
        Libros libro = list1.get(selectedRow);
        if(selectedRow > -1){
            jTabbedPane2.setSelectedIndex(1);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Añadir/insertar (Preparar para crear un nuevo libro)
        //Dejar visible el botón de guardado
        activado=true;
        jButton6.setVisible(true);
        panelPrincp1.thisEnabled(true);
        jTabbedPane2.setSelectedIndex(1);
        
        //se abre los datos del panel principal totalmente vacio y activo para rellenar
        if(panelPrincp1.isShowing()){
            panelPrincp1.clear();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //Modificar
        activado=false;
        panelPrincp1.thisEnabled(true);
        panelPrincp1.showData(true);//pasar al panel
        jTabbedPane2.setSelectedIndex(1);
        jButton6.setVisible(true);
        //Obtener el índice de la fila seleccionada en la tabla 
//        int selectedRow = jTable1.getSelectedRow(); 
        //Obtener el objeto desde la lista de datos, conociendo su posición 
//        Libros libro = list1.get(selectedRow); 
//
//        //Rellenar sus datos 
//        if(jButton6.isSelected()){
//            panelPrincp1.update();
//        }
//        
//        
//        entityManager1.getTransaction().begin(); 
//        //Actualizar el objeto en la BD 
//        entityManager1.merge(libro); 
//        entityManager1.getTransaction().commit();
//        //Añadir el objeto al final de la lista de datos 
//        list1.set(selectedRow, libro); 
//        //Informar al JTable que se ha modificado la fila seleccionada 
//        modelo.fireTableRowsUpdated(selectedRow, selectedRow);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //Buscar
        jTabbedPane2.setSelectedIndex(2);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        //Borrar
        //Obtener el índice de la fila seleccionada en la tabla 
        int selectedRow = jTable1.getSelectedRow(); 
        if(selectedRow > -1){
            int confirmar = JOptionPane.showConfirmDialog(this, "¿Realmente desea borrar el libro?", "Confirmación", JOptionPane.YES_NO_OPTION);
            //Obtener el objeto desde la lista de datos, conociendo su posición 
            Libros libro = list1.get(selectedRow);
            if (confirmar == JOptionPane.YES_OPTION) {
            //Iniciar una transacción con la BD 
            entityManager1.getTransaction().begin(); 
            //Eliminar el objeto 
            entityManager1.remove(libro); 
            //Finalizar la transacción actualizando la BD 
            entityManager1.getTransaction().commit();

            //Eliminar el objeto de la lista de datos 
            list1.remove(libro); 
            //Informar al JTable que se ha eliminado una fila 
            modelo.fireTableRowsDeleted(selectedRow, selectedRow);
            panelPrincp1.clear();
         }
            }else{
            JOptionPane.showMessageDialog(this, "Debe seleccionar un libro", "Atención", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       //Guardar
         if (activado) {
            Libros libro = panelPrincp1.getDatos();
            //recoger la clave (ajena) de Genero (id)
            int idGenero = panelPrincp1.getGenero().getIdGenero();
            //Buscamos la clave en el entityManager
            Genero genero = entityManager1.find(Genero.class, idGenero);
            
            //recoger la clave (ajena) de Editorial (id)
            int idEditorial = panelPrincp1.getEditorial().getIdEditorial();
            //Buscamos la clave en el entityManager
            Editorial editorial = entityManager1.find(Editorial.class, idEditorial);

            entityManager1.getTransaction().begin();
            //Almacenar el objeto en la BD 
            entityManager1.persist(libro);
            entityManager1.getTransaction().commit();
            //Añadir el objeto al final de la lista de datos 
            list1.add(libro);
            //Informar al JTable que se ha insertado una fila al final 
            modelo.fireTableRowsInserted(list1.size() - 1, list1.size() - 1);
        } else {
            //Obtener el índice de la fila seleccionada en la tabla 
            int selectedRow = jTable1.getSelectedRow();
            //Obtener el objeto desde la lista de datos, conociendo su posición 
            Libros libro = list1.get(selectedRow);
            //Rellenar sus datos 
            panelPrincp1.update();
            entityManager1.getTransaction().begin();
            //Actualizar el objeto en la BD 
            entityManager1.merge(libro);
            entityManager1.getTransaction().commit();

            //Añadir el objeto al final de la lista de datos 
            list1.set(selectedRow, libro);
            //Informar al JTable que se ha modificado la fila seleccionada 
            modelo.fireTableRowsUpdated(selectedRow, selectedRow);
        }
        panelPrincp1.thisEnabled(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        //Al hacer click
        if(evt.getClickCount()>1){
            jTabbedPane2.setSelectedIndex(1);
        }
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(VentanaPrincp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincp().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager entityManager1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    private java.util.List<Libros> list1;
    private princip.PanelBusqueda panelBusqueda1;
    private princip.PanelPrincp panelPrincp1;
    private javax.persistence.Query query1;
    // End of variables declaration//GEN-END:variables
}
