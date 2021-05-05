/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Features.Managements;

import static Features.Managements.AppControler.trayIcon;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author F. Pino
 */
public class Notifications {
    
    public static void notification(String title, String message, int selection){
        try{  
            MessageType typeM;
            switch(selection){
                case 0:{
                    typeM = MessageType.INFO;
                    break;
                }
                case 1:{
                    typeM = MessageType.WARNING;
                    break;
                }
                case 2:{
                    typeM = MessageType.ERROR;
                    break;
                }
                default:{
                    typeM = MessageType.NONE;
                }
            }

            // Mostrar notificación de información:
            
            trayIcon.displayMessage(title, message, typeM );
            // Error:
            // trayIcon.displayMessage("Hello, World", "Java Notification Demo", MessageType.ERROR);
            // Warning:
            // trayIcon.displayMessage("Hello, World", "Java Notification Demo", MessageType.WARNING);
        }catch(Exception ex){
            System.err.print(ex);
        }
    }
    
    public void popUp(String title, String menssaje) {
        final Stage dialog = new Stage();                      
        dialog.setTitle(title);
        VBox dialogVbox = new VBox(20);
        Text msj = new Text("/ ! \\  "+menssaje+"  / ! \\");
        msj.setScaleX(1.5);
        msj.setScaleY(1.2);
        dialogVbox.getChildren().add(msj);
        dialogVbox.setAlignment(Pos.CENTER);
        Scene dialogScene = new Scene(dialogVbox, 400, 80);
        dialog.setScene(dialogScene);
        dialog.setResizable(false);
        dialog.setAlwaysOnTop(true);
        dialog.initModality(Modality.APPLICATION_MODAL);
        Toolkit.getDefaultToolkit().beep();
        dialog.show();        
    }  
    
    public void popUp(int tipo, String mensaje, String titulo){        
        Toolkit.getDefaultToolkit().beep();            
        JOptionPane auxiliar = new JOptionPane();
        auxiliar.setMessage(mensaje);
        auxiliar.setMessageType(tipo);       
        JDialog dialogo = auxiliar.createDialog("TwitterBot_ | "+titulo);  
        dialogo.setModal(true);
        dialogo.setAlwaysOnTop(true);
        dialogo.setVisible(true);            
    }    
    
}
