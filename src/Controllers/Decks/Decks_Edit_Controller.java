/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Decks;


import Controllers.Panels.Initial_Controller;
import Features.Connection.ConnectionMySQL;
import Features.Managements.Adapters;
import Features.Objects.Cards;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;

public class Decks_Edit_Controller {
    
    @FXML public AnchorPane base;
    @FXML public ScrollPane eligible_Cards;
    @FXML public Label number_Label;
    @FXML public Label amount_Label;
    @FXML public Text slogan;
    @FXML public Button back;
    @FXML public Button save;

    private final ArrayList<Cards> deck = new ArrayList<>();
    @FXML
    public void initialize(){
        try {
            ConnectionMySQL dataBase = new ConnectionMySQL();
            String SQLsentence = "SELECT Carta.nombre, Carta.elemento, Carta.ataque, Carta.defensa, Carta.defensa, "
                    + "Carta.estrellas, Carta.imagen, Carta.tipo, Carta.descripcion "
                    + "FROM Carta, Mazo, Contiene WHERE Contiene.ref_carta = Carta.id AND Contiene.ref_mazo ="
                    + "(SELECT id FROM Mazo WHERE Mazo.ref_jugador = "+Initial_Controller.ID_User+" "
                    + "AND Mazo.nombre = "+"holi"+");";
            dataBase.ConectarBasedeDatos();    
            dataBase.result = dataBase.sentence.executeQuery(SQLsentence);
            int i = 0;
                while (dataBase.result.next()) {
                    Image imageAux = Adapters.blobToImage(dataBase.result.getBlob(7));
                    Cards c = new Cards(dataBase.result.getInt(1),
                    dataBase.result.getString(2),
                    dataBase.result.getString(3),
                    dataBase.result.getInt(4),
                    dataBase.result.getInt(5),
                    dataBase.result.getInt(6),
                    imageAux,
                    dataBase.result.getString(8),
                    dataBase.result.getString(9));
                    //cards_ImagesView.get(i).setImage(imageAux);
                    deck.add(c);
                    i+=1;
                }
                dataBase.DesconectarBasedeDatos();
        } catch (SQLException ex) {
            Logger.getLogger(Decks_Edit_Controller.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @FXML
    public void back() {
        try {
            Stage stage = (Stage) base.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/Views/Decks/Decks_View.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
        }
    }
}
