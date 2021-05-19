/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Features.Managements;

import java.sql.Blob;
import javafx.scene.image.Image;
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
public class AdaptersTest {
    
    public AdaptersTest() {
    }

    /**
     * Test of blobToImage method, of class Adapters.
     */
    @Test
    public void testBlobToImage() {
        System.out.println("blobToImage");
        Blob b = null;
        Image expResult = null;
        Image result = Adapters.blobToImage(b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
