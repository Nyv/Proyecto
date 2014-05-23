/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package princip;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author usuario
 */
public class Ejemploclase extends AbstractTableModel {

    List<Libros> list;
    
    public void setDataList(List<Libros> list){
        //lista a mostrar en la tabla
        this.list=list;
    }
    
    @Override
    public int getRowCount() {
        //Proporciona el número de filas
        return list.size();
    }

    @Override
    public int getColumnCount() {
        //Proporciona el número de columnas
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //Rellenar
        //Rellena cada fila con lo dicho
        Libros libro = list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return libro.getTitulo();
            case 1:
                return libro.getAutor();
            case 2:
                return libro.getFirmado();
            case 3:
                return libro.getIdGenero().getNombre();
            case 5:
                return libro.getPrecio();
            case 4:
                return libro.getNumPaginas();
            case 6:
                return libro.getValoracion();
            case 7:
                return libro.getFechPrimPublic();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "Titulo";
            case 1:
                return "Autor";
            case 2:
                return "Firmado";
            case 3:
                return "Género";
            case 5:
                return "Precio";
            case 4:
                return "Páginas";
            case 6:
                return "Valoración";
            case 7:
                return "Fecha Publicación";
            default:
                return null;
        }
    }
    
    
    
}
