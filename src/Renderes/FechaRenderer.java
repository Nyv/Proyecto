/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Renderes;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author usuario
 */
public class FechaRenderer extends DefaultTableCellRenderer{
    //Para dar formato a las fechas
    public FechaRenderer(){
        //Alinear a la derecha
        setHorizontalAlignment(SwingConstants.RIGHT);
    }
    @Override
    protected void setValue(Object value) {
        Object result = value;
        if(value!=null && value instanceof Date){
            Date dateValue = (Date)result;
            SimpleDateFormat formato = new SimpleDateFormat("d MMMMMMMMMMM yyyy");
            result = formato.format(result);
        }
        super.setValue(result);
    }
    
}
