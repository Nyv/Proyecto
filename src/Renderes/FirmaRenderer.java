/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Renderes;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Casa
 */
public class FirmaRenderer extends DefaultTableCellRenderer{
    @Override
    protected void setValue(Object aValue) {
        Object result = aValue;
        //pregunta si es un número
        if ((aValue != null) && (aValue instanceof Boolean)) { 
            Boolean firma = (boolean)(result);
            if(firma){
                this.setIcon(new ImageIcon(getClass().getResource("../Recursos/true.png")));
            }else{
                this.setIcon(new ImageIcon(getClass().getResource("../Recursos/false.png")));
            }
        } 
    }
}
