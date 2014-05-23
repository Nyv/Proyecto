/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package princip;

import Renderes.DocumentCharactersLimiter;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Nerea
 */
public class PanelBusqueda extends javax.swing.JPanel {
    DocumentCharactersLimiter document1 = new DocumentCharactersLimiter();
    private Libros libro;
    private Genero genero;
    private Editorial editorial;
    private Connection connection = null;
    
    //booleans
    private boolean cod=false;
    private boolean gen=false;
    private boolean edit=false;
    private boolean aut=false;
   
    private final String HOST = "localhost";
    private final String NAME = "Libreria";
    private final String USER = "root";
    private final String PASSWORD = "";
    
    String busqueda;
    
    ArrayList<Libros> listaLibros = new ArrayList();
    
    private int valorSeleccionado;
    /**
     * Creates new form PanelBusqueda
     */
    public PanelBusqueda() {
        initComponents();
        //Magia "borras"
        jButton2.setVisible(false);
        this.activarCod(false);
        this.activarAutor(false);
        this.activarEdit(false);
        this.activarGen(false);
        this.preparardb();
        //Límite de caracteres de ID de libro
        document1.setLimit(6);
        jTextField1.setDocument(document1);
    }
    
    public void preparardb(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(
                    "jdbc:mysql://" + HOST + "/" + NAME,
                    USER, PASSWORD);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListEditorial.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "No se ha encontrado la librería MySQL", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } catch (InstantiationException ex) {
            Logger.getLogger(ListEditorial.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ListEditorial.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "No se ha podido conectar con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } catch (SQLException ex) {
            Logger.getLogger(ListEditorial.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "No se ha podido conectar con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
}
    /**
     * Rellena los valores seleccionados con los datos necesarios del jComboBox
     * @param valorSeleccionado 
     */
    private void rellenar(int valorSeleccionado){
            String object;
            
            switch(valorSeleccionado){
                case 0:
                    object="id_Libro";
                    this.activarCod(true);
                    this.activarAutor(false);
                    this.activarEdit(false);
                    this.activarGen(false);
                    busqueda = "SELECT titulo FROM libros WHERE "+object;
                    break;
                case 1:
                    object="id_Genero";
                    //Tomar una referencia al JFrame que contiene este panel
                        Frame frameParent = Frame.getFrames()[0];
                        ListGenero dialogListaGenero = new ListGenero(frameParent, true);
                        dialogListaGenero.setVisible(true);
                        genero = dialogListaGenero.getGeneroSelec();
                        jTextField4.setText("" + genero.getIdGenero());
                    this.activarCod(false);
                    this.activarAutor(false);
                    this.activarEdit(false);
                    this.activarGen(true);
                    busqueda = "SELECT titulo FROM libros WHERE "+object;
                    break;
                case 2:
                    object="id_Editorial";
                    //Editorial
                        //Tomar una referencia al JFrame que contiene este panel
                        Frame frameParent2 = Frame.getFrames()[0];
                        ListEditorial dialogListaEditorial = new ListEditorial(frameParent2, true);
                        dialogListaEditorial.setVisible(true);
                        editorial = dialogListaEditorial.getEditorialSelected();
                        jTextField3.setText("" + editorial.getIdEditorial());
                    this.activarCod(false);
                    this.activarAutor(false);
                    this.activarEdit(true);
                    this.activarGen(false);
                    busqueda = "SELECT titulo FROM libros WHERE "+object;
                    break;
                case 3:
                    object="autor";
                    this.activarCod(false);
                    this.activarAutor(true);
                    this.activarEdit(false);
                    this.activarGen(false);
                    busqueda = "SELECT titulo FROM libros WHERE "+object;
                    break;
            }
            jButton2.setVisible(true);
    }
    /**
     * Concatena la busqueda
     */
    private void selected(){
        if(cod){
            busqueda = busqueda.concat("='"+jTextField1.getText()+"'");
        }else{
            if(gen){
                busqueda = busqueda.concat("='"+jTextField4.getText()+"'");
            }else{
                if(edit){
                    busqueda = busqueda.concat("='"+jTextField3.getText()+"'");
                }else{
                    if(aut){
                        busqueda = busqueda.concat("='"+jTextField2.getText()+"'");
                    }
                }
            }
        }
    }
    /**
     * Realiza una consulta en la tabla libros para encontrar los titulos de los libros relacionados
     */
    private void buscar(){
        try {
            selected();
            //Crear un modelo para la lista
            DefaultListModel listModel = new DefaultListModel();
            jList1.setModel(listModel);
            //Asignar el renderer para mostrar los objetos como se desea
            jList1.setCellRenderer(new Renderes.LibroRenderer());
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(busqueda);
            while( rs.next() ) {
                String nombre = rs.getString("titulo");
                Libros libro = new Libros();
                libro.setTitulo(nombre);
                listModel.addElement(libro);
           }
            
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al tratar de conectar la base, verifica tus datos de conexion");
            }
    }
    //Mostrar la lista en modo Array
    private void mostrarLista() {
        jList1.setListData(listaLibros.toArray());
    }
    //Magia potagia desaparece de vista objeto
   public void activarCod(boolean vista){
       cod=vista;
       jLabel2.setVisible(vista);
       jTextField1.setVisible(vista);
   }
   public void activarEdit(boolean vista){
       edit=vista;
       jLabel3.setVisible(vista);
       jTextField3.setVisible(vista);
   }
   public void activarGen(boolean vista){
       gen=vista;
       jLabel4.setVisible(vista);
       jTextField4.setVisible(vista);
   }
   public void activarAutor(boolean vista){
       aut=vista;
       jLabel5.setVisible(vista);
       jTextField2.setVisible(vista);
   }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setText("Buscar por: ");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Código", "Género", "Editorial", "Autor" }));
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Código:");

        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jButton1.setText("Rellenar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Editorial:");

        jLabel4.setText("Género:");

        jLabel5.setText("Autor:");

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                            .addComponent(jTextField4)
                            .addComponent(jTextField3)
                            .addComponent(jTextField1))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addContainerGap(123, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        //Al hacer click
        valorSeleccionado = jComboBox1.getSelectedIndex();
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.rellenar(valorSeleccionado);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.buscar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
       
    }//GEN-LAST:event_jList1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
