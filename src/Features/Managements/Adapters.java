/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Features.Managements;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;

/**
 *
 * @author F. Pino
 */
public class Adapters {
    
    public static Image blobToImage(Blob b){
        Image image = null;
        try {
            InputStream in = b.getBinaryStream();
            BufferedImage bufImage = ImageIO.read(in);
            image = SwingFXUtils.toFXImage(bufImage, null);
        } catch (IOException | SQLException e) {
        }
        return image;
    }
    
}
