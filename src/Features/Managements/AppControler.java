/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Features.Managements;

import java.awt.AWTException;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LosSietePecadosCapitales
 */


public class AppControler {
    public static SystemTray trayApp = SystemTray.getSystemTray();
    public static TrayIcon trayIcon = new TrayIcon(
            Toolkit.getDefaultToolkit().createImage("src/Assets/Images/icon_color.png"), "YuGiOh"); 
    
    public AppControler(){   
        try {
            trayIcon.setImageAutoSize(true);            
            trayApp.add(trayIcon);
        } catch (AWTException ex) {
            Logger.getLogger(AppControler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
