/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Renderes;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import princip.Libros;

/**
 *
 * @author Casa
 */
public class LibroRenderer implements ListCellRenderer{
     @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        //Se van a mostrar los elementos en un JLabel, que es el componente habitual en los JList
        DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
        JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index,
                isSelected, cellHasFocus);
        
        //Convertir el valor recibido (value) al tipo de datos corespondiente
        Libros libro = (Libros) value;
        //Crear el texto que se quiere mostrar para cada objeto
        renderer.setText(libro.getTitulo());
        return renderer;
    }
}
