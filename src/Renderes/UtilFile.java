/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Renderes;

import java.awt.Component;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author usuario
 */
public class UtilFile {
    public static int showOpenImageFiles(Component parent){//<--parámetro de tipo componente que pide el padre. 
    //Se crea el objeto JFileChooser
    JFileChooser fileChooser = new JFileChooser();
    //Añadir filtro de selección de solo directorios
    //fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    //Añadir filtro de imagenes
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Imágenes (*.bmp, *.gif, *.jpg, *.png)", "bmp", "gif", "jpg", "png");
    fileChooser.setFileFilter(filter);
    //Seleccionar varias cosas
    fileChooser.setMultiSelectionEnabled(false);
    //Pide un padre para sacar el dialog, puede ser un componente o directamente this
    int respuesta = fileChooser.showOpenDialog(parent);
    //Mostrar el nombre de los ficheros seleccionados
    String ruta = fileChooser.getSelectedFile().getPath();
    return respuesta;
    }
}
