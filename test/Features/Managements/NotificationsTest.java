/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Features.Managements;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author javen
 */
public class NotificationsTest {
    
    public NotificationsTest() {
    }

    /**
     * Test of notification method, of class Notifications.
     */
    @Test
    public void testNotification() {
        System.out.println("notification");
        String title = "Notificacion";
        String message = "Mensaje Notificacion";
        int selection = 0;
        Notifications.notification(title, message, selection);
    }

    /**
     * Test of popUp method, of class Notifications.
     */
    @Test
    public void testPopUp_String_String() {
        System.out.println("popUp");
        String title = "Titulo";
        String menssaje = "Mensaje";
        Notifications instance = new Notifications();
        instance.popUp(title, menssaje);
    }

    /**
     * Test of popUp method, of class Notifications.
     */
    @Test
    public void testPopUp_3args() {
        System.out.println("popUp");
        int tipo = 0;
        String mensaje = "PopUp_3args";
        String titulo = "Titulo";
        Notifications instance = new Notifications();
        instance.popUp(tipo, mensaje, titulo);
    }
    
}
