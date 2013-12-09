/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package christmaskinect;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
import processing.core.PApplet;

/**
 *
 * @author vandersonmr
 */
public class Main {

    public static void main(String args[]) {
        try {
            System.setProperty("java.library.path", "/home/vandersonmr");
            //setLocationRelativeTo(null);
            Field fieldSysPath = ClassLoader.class.getDeclaredField("sys_paths");
            fieldSysPath.setAccessible(true);
            fieldSysPath.set(null, null);
            PApplet.main(new String[]{"christmaskinect.ChristmasKinect"});
        
        } catch (SecurityException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
