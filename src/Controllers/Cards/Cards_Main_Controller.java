
package Controllers.Cards;

import Controllers.Panels.Initial_Controller;
import Features.Connection.ConnectionMySQL;
import Features.Managements.Adapters;
import Features.Objects.Cards;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Cards_Main_Controller {
    
    @FXML public AnchorPane base;
    
    @FXML public Button back;
    @FXML public Button next;
    @FXML public Button prev;
    @FXML public Button createCardButton;
    @FXML public Button editCardButton;
    @FXML public Button deleteCardButton;
    @FXML public Button perzonalizeCardButton;
    @FXML public Button ownCardButton;
    
    @FXML public ImageView card00;
    @FXML public ImageView card01;
    @FXML public ImageView card02;
    @FXML public ImageView card03;
    @FXML public ImageView card10;
    @FXML public ImageView card11;
    @FXML public ImageView card12;
    @FXML public ImageView card13;
    @FXML public ImageView card20;
    @FXML public ImageView card21;
    @FXML public ImageView card22;
    @FXML public ImageView card23;
    @FXML public ImageView prevCard;

    private final int itemsPerPage = 12;
    private int page;
    public static Cards selectCard;
    private ArrayList<Cards> cards;
    private ArrayList<ImageView> cards_ImagesView;
    
    private String cardMenuState;
    
    
    public void initialize(){
        page = 0;
        selectCard = null;
        cards = new ArrayList<>();
        cards_ImagesView = new ArrayList<>();
        getArrayImagesViews();
        cardMenuState = "ORI";
        
        //estado original -> cartas originales
        fillBook();
        createCardButton.setDisable(false);
        editCardButton.setDisable(true);
        deleteCardButton.setDisable(true);
        
        
        card00.setOnMouseClicked((MouseEvent event) -> {
               Cards_Main_Controller.this.setPrevisualize(card00);
               selectCard = cards.get(0);
        });
        card01.setOnMouseClicked((MouseEvent event) -> {
               Cards_Main_Controller.this.setPrevisualize(card01);
               selectCard = cards.get(1);
        });
        card02.setOnMouseClicked((MouseEvent event) -> {
               Cards_Main_Controller.this.setPrevisualize(card02);
               selectCard = cards.get(2);
        });
        card03.setOnMouseClicked((MouseEvent event) -> {
               Cards_Main_Controller.this.setPrevisualize(card03);
               selectCard = cards.get(3);
        });
        card10.setOnMouseClicked((MouseEvent event) -> {
               Cards_Main_Controller.this.setPrevisualize(card10);
               selectCard = cards.get(4);
        });
        card11.setOnMouseClicked((MouseEvent event) -> {
               Cards_Main_Controller.this.setPrevisualize(card11);
               selectCard = cards.get(5);
        });
        card12.setOnMouseClicked((MouseEvent event) -> {
               Cards_Main_Controller.this.setPrevisualize(card12);
               selectCard = cards.get(6);
        });
        card13.setOnMouseClicked((MouseEvent event) -> {
               Cards_Main_Controller.this.setPrevisualize(card13);
               selectCard = cards.get(7);
        });
        card20.setOnMouseClicked((MouseEvent event) -> {
               Cards_Main_Controller.this.setPrevisualize(card20);
               selectCard = cards.get(8);
        });
        card21.setOnMouseClicked((MouseEvent event) -> {
               Cards_Main_Controller.this.setPrevisualize(card21);
               selectCard = cards.get(9);
        });
        card22.setOnMouseClicked((MouseEvent event) -> {
               Cards_Main_Controller.this.setPrevisualize(card22);
               selectCard = cards.get(10);
        });
        card23.setOnMouseClicked((MouseEvent event) -> {
               Cards_Main_Controller.this.setPrevisualize(card23);
               selectCard = cards.get(11);
        });
    }

    private void getArrayImagesViews(){
        cards_ImagesView.add(card00);
        cards_ImagesView.add(card01);
        cards_ImagesView.add(card02);
        cards_ImagesView.add(card03);
        cards_ImagesView.add(card10);
        cards_ImagesView.add(card11);
        cards_ImagesView.add(card12);
        cards_ImagesView.add(card13);
        cards_ImagesView.add(card20);
        cards_ImagesView.add(card21);
        cards_ImagesView.add(card22);
        cards_ImagesView.add(card23);
    }
    
    private void fillBook(){
        cards.clear();
        try {
            if(cardMenuState.equals("ORI")){//ORIGINALES
                ConnectionMySQL dataBase = new ConnectionMySQL();
                dataBase.ConectarBasedeDatos();
                String query = "SELECT * FROM Carta LIMIT "+(page*itemsPerPage)+","+itemsPerPage+";";
                dataBase.result = dataBase.sentence.executeQuery(query);

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
                    cards_ImagesView.get(i).setImage(imageAux);
                    cards.add(c);
                    i+=1;
                }
                dataBase.DesconectarBasedeDatos();
            }
            else if(cardMenuState.equals("PER")){ //PERSONALIZE
                ConnectionMySQL dataBase = new ConnectionMySQL();
                dataBase.ConectarBasedeDatos();
                String query = "SELECT * FROM Carta WHERE ref_jugador != 0 AND ref_jugador != "+Initial_Controller.ID_User+" LIMIT "+(page*itemsPerPage)+","+itemsPerPage+";";
                dataBase.result = dataBase.sentence.executeQuery(query);

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
                    cards_ImagesView.get(i).setImage(imageAux);
                    cards.add(c);
                    i+=1;
                }
                dataBase.DesconectarBasedeDatos();
            }
            else if(cardMenuState.equals("OWN")){//PROPIAS
                ConnectionMySQL dataBase = new ConnectionMySQL();
                dataBase.ConectarBasedeDatos();
                String query = "SELECT * FROM Carta WHERE ref_jugador = "+Initial_Controller.ID_User+" LIMIT "+(page*itemsPerPage)+","+itemsPerPage+";";
                dataBase.result = dataBase.sentence.executeQuery(query);
                
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
                    cards_ImagesView.get(i).setImage(imageAux);
                    cards.add(c);
                    i+=1;
                }
                dataBase.DesconectarBasedeDatos();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 
    
    private void setPrevisualize(ImageView iv){
        prevCard.setImage(iv.getImage());
    }
    
    private void cleanImagesViews(){
        cards_ImagesView.forEach((i) -> {
            i.setImage(null);
        });
    }
    
    @FXML
    public void nextPage(){
        prevCard.setImage(null);
        selectCard = null;
        cleanImagesViews();
        page+=1;
        
        fillBook();
        prev.setDisable(false);
    }
    
    @FXML
    public void prevPage(){
        prevCard.setImage(null);
        selectCard = null;
        if (page!=0) {
            cleanImagesViews();
            page-=1;
            fillBook();
        }
        if (page==0) {
            prev.setDisable(true);
        }
    }
    
    @FXML
    public void back() {
        try {
            Stage stage = (Stage) base.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/Views/Panels/Principal_Panel_View.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
        }
    }

    @FXML
    public void createCard(){
        try{
            Stage stage = (Stage) base.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/Views/Cards/Create_Card_View.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
        }
    }

    @FXML
    public void editCard(){
        try{
            
            Stage stage = (Stage) base.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/Views/Cards/Edit_Card_View.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
         
        } catch (IOException e) {
        }
    }

    @FXML
    public void deleteCard() throws SQLException{
        
        ConnectionMySQL dataBase = new ConnectionMySQL();
        dataBase.ConectarBasedeDatos();
        String query = "DELETE FROM Carta WHERE id = "+selectCard.getId()+";";
        dataBase.sentence.executeUpdate(query);
        dataBase.DesconectarBasedeDatos();
        
        prevCard.setImage(null);
        selectCard = null;
        cleanImagesViews();
        fillBook();
        
        
        
    }
    
    @FXML
    public void originalCards(){
        page = 0;
        cleanImagesViews();
        prevCard.setImage(null);
        selectCard = null;
        cardMenuState = "ORI";
        fillBook();
        createCardButton.setDisable(false);
        editCardButton.setDisable(true);
        deleteCardButton.setDisable(true);
    }
    
    @FXML
    public void PersonalizeCards(){
        page = 0;
        cleanImagesViews();
        prevCard.setImage(null);
        selectCard = null;
        cardMenuState = "PER";
        fillBook();
        createCardButton.setDisable(false);
        editCardButton.setDisable(true);
        deleteCardButton.setDisable(true);
    }
    
    @FXML
    public void OwnCards(){
        page = 0;
        cleanImagesViews();
        prevCard.setImage(null);
        selectCard = null;
        cardMenuState = "OWN";
        fillBook();
        createCardButton.setDisable(false);
        editCardButton.setDisable(false);
        deleteCardButton.setDisable(false);
    }
    
    @FXML
    public void minimize(){
        Stage s = (Stage) base.getScene().getWindow();
        s.setIconified(true);
    }
    
    @FXML
    public void exit(){
        System.exit(1);
    }
}
