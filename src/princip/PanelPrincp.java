/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package princip;

import Renderes.DocumentCharactersLimiter;
import java.awt.Frame;
import java.awt.Image;
import java.math.BigDecimal;
import java.text.NumberFormat;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *
 * @author Nerea
 */
public class PanelPrincp extends javax.swing.JPanel {
    
    DocumentCharactersLimiter document1 = new DocumentCharactersLimiter();
    DocumentCharactersLimiter document2 = new DocumentCharactersLimiter();
    
    private Libros libro;
    private Genero genero;
    private Editorial editorial;
    private NumberFormat formatoEuro = NumberFormat.getCurrencyInstance();
    private final ImageIcon VALOR = new ImageIcon(getClass().getResource("../Recursos/Valor.png"));
    private final ImageIcon NOVALOR = new ImageIcon(getClass().getResource("../Recursos/NoValor.png"));
    /**
     * Creates new form PanelPrincp
     */
    public PanelPrincp() {
        initComponents();
        //Límite de caracteres de ID de libro
        document1.setLimit(6);
        jTextField9.setDocument(document1);
        //Límite de caracteres de ISBN de libro
        document2.setLimit(13);
        jTextField8.setDocument(document2);
        
    }
    
    /**
     * Retorna el libro elegido
     * @return Libro
     */
    public Libros getLibro() {
        return libro;
    }
    /**
     * Cambia el libro elegido
     */
    public void setLibro(Libros libro) {
        this.libro = libro;
    }
    /**
     * Retorna el Genero elegido
     * @return Genero
     */
    public Genero getGenero() {
        return genero;
    }
    /**
     * Retorna el Editorial elegido
     * @return Editorial
     */
    public Editorial getEditorial() {
        return editorial;
    }
    
    
    /**
     * Activa y desactiva los campos a mostrar
     * @param enabled 
     */
    public void thisEnabled(boolean enabled){
        if(enabled){
            jTextField1.setEditable(true);
            jTextField2.setEditable(true);
            jTextField3.setEditable(true);
            jTextField4.setEditable(true);
            jTextField5.setEditable(true);
            jTextField6.setEditable(true);
            jTextField7.setEditable(true);
            jTextField8.setEditable(true);
            jTextField9.setEditable(true);
            jCheckBox1.setEnabled(true);
            jLabelPortada.setEnabled(true);
            jDateChooser1.setEnabled(true);
            jTextArea1.setEditable(true);
            jButton1.setVisible(true);
            jButton2.setVisible(true);
            jSlider1.setVisible(true);
        }else{
            jTextField1.setEditable(false);
            jTextField2.setEditable(false);
            jTextField3.setEditable(false);
            jTextField4.setEditable(false);
            jTextField5.setEditable(false);
            jTextField6.setEditable(false);
            jTextField7.setEditable(false);
            jTextField8.setEditable(false);
            jTextField9.setEditable(false);
            jCheckBox1.setEnabled(false);
            jLabelPortada.setEnabled(true);
            jTextArea1.setEditable(false);
            jButton1.setVisible(false);
            jButton2.setVisible(false);
            jSlider1.setVisible(false);
            jDateChooser1.setEnabled(false);
        }
   }
   /**
    * Muestra los datos del libro seleccionado
    * @param paraModificar 
    */
    public void showData(boolean paraModificar) {
        jTextField1.setText(libro.getTitulo());
        jTextField2.setText(libro.getAutor());
        jTextField3.setText(libro.getIlustrador());
        jTextArea1.setText(libro.getSipnosis());
        jTextField8.setText(libro.getIsbn());
        jTextField9.setText(libro.getIdLibro());
        jCheckBox1.setSelected(libro.getFirmado());
        jTextArea1.setText(libro.getSipnosis());
        jDateChooser1.setDate(libro.getFechPrimPublic());
        jTextField5.setText("" + libro.getNumPaginas());
        if(paraModificar){
           jTextField7.setText("" + libro.getPrecio()); 
        }else{
            jTextField7.setText(formatoEuro.format(libro.getPrecio())); 
        }
        if(jTextField4 == null){
            jTextField4.setText("");
        }else{
           jTextField4.setText("" + libro.getIdGenero().getNombre());
           genero = libro.getIdGenero();
        }
        if(jTextField6 == null){
            jTextField6.setText("");
        }else{
           jTextField6.setText("" + (libro.getIdEditorial().getNombre()));
           editorial = libro.getIdEditorial();
        }
        if(jLabelPortada == null){
            jLabelPortada.setIcon(new ImageIcon(getClass().getResource("/Recursos/NotFound.jpg")));
        }else{
            jLabelPortada.setIcon(new ImageIcon(getClass().getResource(libro.getPortada())));
        }
        this.valoracion();
    }
    /**
     * Limpia los campos para mostrar
     */
    public void clear(){
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextArea1.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
        jTextField7.setText("");
        jTextArea1.setText("");
        jCheckBox1.setSelected(false);
        jDateChooser1.setDate(null);
        jTextField5.setText("");
        jTextField4.setText("");
        jTextField6.setText("");
        jLabelPortada.setIcon(new ImageIcon(getClass().getResource("")));
        libro.setValoracion((short)0);
        this.valoracion();
    }
    /**
     * Prepara las estrellas de la valoracion
     */
    public void valoracion(){
        switch(libro.getValoracion()){
            case 0:
                jLabel10.setIcon(NOVALOR);
                jLabel11.setIcon(NOVALOR);
                jLabel12.setIcon(NOVALOR);
                jLabel13.setIcon(NOVALOR);
                jLabel14.setIcon(NOVALOR);
                jSlider1.setValue(0);
                break;
            case 1:
                jLabel10.setIcon(VALOR);
                jLabel11.setIcon(NOVALOR);
                jLabel12.setIcon(NOVALOR);
                jLabel13.setIcon(NOVALOR);
                jLabel14.setIcon(NOVALOR);
                jSlider1.setValue(1);
                break;
            case 2:
                jLabel10.setIcon(VALOR);
                jLabel11.setIcon(VALOR);
                jLabel12.setIcon(NOVALOR);
                jLabel13.setIcon(NOVALOR);
                jLabel14.setIcon(NOVALOR);
                jSlider1.setValue(2);
                break;
            case 3:
                jLabel10.setIcon(VALOR);
                jLabel11.setIcon(VALOR);
                jLabel12.setIcon(VALOR);
                jLabel13.setIcon(NOVALOR);
                jLabel14.setIcon(NOVALOR);
                jSlider1.setValue(3);
                break;
            case 4:
                jLabel10.setIcon(VALOR);
                jLabel11.setIcon(VALOR);
                jLabel12.setIcon(VALOR);
                jLabel13.setIcon(VALOR);
                jLabel14.setIcon(NOVALOR);
                jSlider1.setValue(4);
                break;
           case 5:
                jLabel10.setIcon(VALOR);
                jLabel11.setIcon(VALOR);
                jLabel12.setIcon(VALOR);
                jLabel13.setIcon(VALOR);
                jLabel14.setIcon(VALOR);
                jSlider1.setValue(5);
               break;
        }
    }
    
    /**
     * Recoge los datos del libro
     * @return Libro
     */
    public Libros getDatos(){
        Libros libro = new Libros();
        try{
        if(jTextField1.getText() != null && jTextField9.getText() != null){
            //conversión bigdecimal
            BigDecimal conversion = BigDecimal.valueOf(Double.valueOf(jTextField7.getText()));
            libro.setTitulo(jTextField1.getText());
            libro.setIdLibro(jTextField9.getText());
            libro.setAutor(jTextField2.getText());
            libro.setIlustrador(jTextField3.getText());
            libro.setFirmado(jCheckBox1.getHideActionText());
            libro.setNumPaginas((int)Integer.valueOf(jTextField5.getText()));
            libro.setPrecio(conversion);
            libro.setIdGenero(genero);
            libro.setIdEditorial(editorial);
            libro.setSipnosis(jTextArea1.getText());
            libro.setFechPrimPublic(jDateChooser1.getDate());
            libro.setValoracion((short)(jSlider1.getValue()));
            libro.setIsbn(jTextField8.getText());
            libro.setSipnosis(jTextArea1.getText());
            if(jLabelPortada == null){
                libro.setPortada("./Recursos/NotFound.jpg");
            }else{
                libro.setPortada(libro.getPortada());
            }
            if (jCheckBox1.isSelected()) {
                    libro.setFirmado(true);
                } else {
                    libro.setFirmado(false);
                }
        } else {
                JOptionPane.showMessageDialog(this, "Debe rellenar los campos Titulo e ID", "Atención", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Asegurese de que hay un número en Páginas y Precio", "Atención", JOptionPane.WARNING_MESSAGE);
        }
        return libro;
    }
    /**
     * Actualiza los datos de un lbro selecionado y modificado
     * @return Libro
     */
    public Libros update(){
        try{
        if(jTextField1.getText() != null && jTextField9.getText() != null){
            //conversión bigdecimal
            BigDecimal conversion = BigDecimal.valueOf(Double.valueOf(jTextField7.getText()));
            libro.setTitulo(jTextField1.getText());
            libro.setIdLibro(jTextField9.getText());
            libro.setAutor(jTextField2.getText());
            libro.setIlustrador(jTextField3.getText());
            libro.setFirmado(jCheckBox1.getHideActionText());
            libro.setNumPaginas((int)Integer.valueOf(jTextField5.getText()));
            libro.setPrecio(conversion);
            libro.setIdGenero(genero);
            libro.setIdEditorial(editorial);
            libro.setSipnosis(jTextArea1.getText());
            libro.setFechPrimPublic(jDateChooser1.getDate());
            libro.setValoracion((short)(jSlider1.getValue()));
            libro.setIsbn(jTextField8.getText());
            libro.setSipnosis(jTextArea1.getText());
            if(jLabelPortada == null){
                libro.setPortada("../Recursos/NotFound.jpg");
            }else{
                libro.setPortada(libro.getPortada());
            }
            if (jCheckBox1.isSelected()) {
                    libro.setFirmado(true);
                } else {
                    libro.setFirmado(false);
                }
        } else {
                JOptionPane.showMessageDialog(this, "Debe rellenar los campos Titulo e ID", "Atención", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Asegurese de que hay un número en Páginas y Precio", "Atención", JOptionPane.WARNING_MESSAGE);
        }
        return libro;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabelPortada = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jSlider1 = new javax.swing.JSlider();
        jTextField4 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(255, 255, 204));

        jLabel2.setText("Título:");

        jLabel3.setText("Autor:");

        jLabel4.setText("Ilustrador:");

        jLabel5.setText("Género:");

        jLabel6.setText("Páginas:");

        jLabel7.setText("Firmado:");

        jLabel8.setText("Precio:");

        jLabel9.setText("Fecha Primera Publicación:");

        jTextField1.setEditable(false);

        jTextField2.setEditable(false);

        jTextField3.setEditable(false);

        jTextField7.setEditable(false);

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Valoración:");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/NoValor.png"))); // NOI18N

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/NoValor.png"))); // NOI18N

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/NoValor.png"))); // NOI18N

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/NoValor.png"))); // NOI18N

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/NoValor.png"))); // NOI18N

        jLabel15.setText("Editorial: ");

        jPanel1.setBackground(new java.awt.Color(255, 204, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Portada", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Edwardian Script ITC", 0, 12), new java.awt.Color(255, 102, 255))); // NOI18N

        jLabelPortada.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelPortada, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelPortada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 204, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sipnosis", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Edwardian Script ITC", 0, 12), new java.awt.Color(204, 51, 255))); // NOI18N

        jScrollPane2.setBackground(new java.awt.Color(255, 204, 255));

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(255, 255, 204));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(102, 153, 255));
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton2.setText("Examinar...");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel16.setText("Portada:");

        jLabel17.setText("ISBN:");

        jTextField8.setEditable(false);

        jLabel18.setText("ID:");

        jTextField9.setEditable(false);

        jTextField5.setEditable(false);

        jButton1.setText("Ver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Ver");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jSlider1.setBackground(new java.awt.Color(255, 255, 204));
        jSlider1.setForeground(new java.awt.Color(255, 153, 0));
        jSlider1.setMajorTickSpacing(5);
        jSlider1.setMaximum(5);
        jSlider1.setPaintLabels(true);
        jSlider1.setPaintTicks(true);
        jSlider1.setToolTipText("");
        jSlider1.setValue(0);

        jTextField4.setEditable(false);

        jTextField6.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                                    .addComponent(jTextField3)
                                    .addComponent(jTextField2)
                                    .addComponent(jTextField1)
                                    .addComponent(jCheckBox1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField8))
                                    .addComponent(jTextField9)
                                    .addComponent(jTextField5)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jTextField6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton3))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jTextField4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1))
                                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(26, 26, 26)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jButton1)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jCheckBox1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jButton3)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel14)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jButton2)
                            .addComponent(jLabel17)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Examinar
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imágenes (*.bmp *.gif *.jpg *.png)", "bmp", "gif", "jpg", "png");
        fileChooser.setFileFilter(filtro);
        int respuesta = fileChooser.showOpenDialog(this);
        //Comprobar si se ha pulsado Aceptar
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            ImageIcon photo = new ImageIcon(fileChooser.getSelectedFile().getPath());
            if (photo.getIconHeight() > 342 || photo.getIconWidth() > 230) {
                ImageIcon photoDimension = new ImageIcon(photo.getImage().getScaledInstance(296, 360, Image.SCALE_SMOOTH));
                jLabelPortada.setIcon(photoDimension);
            } else {
                jLabelPortada.setIcon(photo);
            }
        }
        //Guardar la ruta de la imagen en el libro
        libro.setPortada(fileChooser.getSelectedFile().getPath());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Ver Género
        //Tomar una referencia al JFrame que contiene este panel
        Frame frameParent = Frame.getFrames()[0];
        ListGenero dialogListaGenero = new ListGenero(frameParent, true);
        dialogListaGenero.setVisible(true);
        genero = dialogListaGenero.getGeneroSelec();
        jTextField4.setText("" + genero.getNombre());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //Editorial
        //Tomar una referencia al JFrame que contiene este panel
        Frame frameParent = Frame.getFrames()[0];
        ListEditorial dialogListaEditorial = new ListEditorial(frameParent, true);
        dialogListaEditorial.setVisible(true);
        editorial = dialogListaEditorial.getEditorialSelected();
        jTextField6.setText("" + editorial.getNombre());
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelPortada;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
