package Controllers.Decks;

import static Controllers.Cards.Cards_Main_Controller.selectCard;
import Controllers.Panels.Initial_Controller;
import static Controllers.Panels.Initial_Controller.ID_User;
import Features.Connection.ConnectionMySQL;
import Features.Managements.Notifications;
import Features.Objects.Cards;
import java.awt.image.BufferedImage;
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
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javax.imageio.ImageIO;

public class Decks_Create_Controller {
    
    @FXML public AnchorPane base;
    @FXML public ScrollPane eligible_Cards;
    @FXML public HBox hbox_cards;
    @FXML public Label number_Label;
    @FXML public Label amount_Label;
    @FXML public Label title;
    @FXML public Text slogan;
    @FXML public TextField nameDeck;
    
    @FXML public Button back;
    @FXML public Button save;    
    @FXML public Button next;
    @FXML public Button prev;
    
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
    private ArrayList<Cards> cardsSelected;
    private ArrayList<ImageView> cards_ImagesView_Book;
    private ArrayList<ImageView> cards_ImagesView_Selected;
    private String cardMenuState = "ORI";
    private int count = 0;

    @FXML
    public void initialize(){
        page = 0;
        selectCard = null;
        cards = new ArrayList<>();
        cards_ImagesView_Book = new ArrayList<>();
        cards_ImagesView_Selected = new ArrayList<>();
        cardsSelected = new ArrayList<>();
        getArrayImagesViews();
        fillBook();
        card00.setOnMouseClicked((MouseEvent event) -> {
            try {
                selectCard = cards.get(0);
                Decks_Create_Controller.this.setImagePanel(card00);
            } catch (Exception e) {
            }
        });
        card01.setOnMouseClicked((MouseEvent event) -> {
            try {
                selectCard = cards.get(1);
                Decks_Create_Controller.this.setImagePanel(card01);
            } catch (Exception e) {
            }
        });
        card02.setOnMouseClicked((MouseEvent event) -> {
            try {
                selectCard = cards.get(2);
                Decks_Create_Controller.this.setImagePanel(card02);
            } catch (Exception e) {
            }
        });
        card03.setOnMouseClicked((MouseEvent event) -> {
            try {
                selectCard = cards.get(3);
                Decks_Create_Controller.this.setImagePanel(card03);
            } catch (Exception e) {
            }
        });
        card10.setOnMouseClicked((MouseEvent event) -> {
            try {
                selectCard = cards.get(4);
                Decks_Create_Controller.this.setImagePanel(card10);
            } catch (Exception e) {
            }
        });
        card11.setOnMouseClicked((MouseEvent event) -> {
            try {
                selectCard = cards.get(5);
                Decks_Create_Controller.this.setImagePanel(card11);
            } catch (Exception e) {
            }
        });
        card12.setOnMouseClicked((MouseEvent event) -> {
            try {
                selectCard = cards.get(6);
                Decks_Create_Controller.this.setImagePanel(card12);                
            } catch (Exception e) {
            }
        });
        card13.setOnMouseClicked((MouseEvent event) -> {
            try {
                selectCard = cards.get(7);
                Decks_Create_Controller.this.setImagePanel(card13);
            } catch (Exception e) {
            }
        });
        card20.setOnMouseClicked((MouseEvent event) -> {
            try {
                selectCard = cards.get(8);
                Decks_Create_Controller.this.setImagePanel(card20);
            } catch (Exception e) {
            }
        });
        card21.setOnMouseClicked((MouseEvent event) -> {
            try {
                selectCard = cards.get(9);
                Decks_Create_Controller.this.setImagePanel(card21);
            } catch (Exception e) {
            }
        });
        card22.setOnMouseClicked((MouseEvent event) -> {
            try {
                selectCard = cards.get(10);
                Decks_Create_Controller.this.setImagePanel(card22);
            } catch (Exception e) {
            }
        });
        card23.setOnMouseClicked((MouseEvent event) -> {
            try {
                selectCard = cards.get(11);
                Decks_Create_Controller.this.setImagePanel(card23);
            } catch (Exception e) {
            }
        });
/*
        card000.setOnMouseClicked((MouseEvent event) -> {
               Decks_Create_Controller.this.setImagePanel(card000, new ImageView("/Assets/Images/Card_Back.png"));
               amount_Label.setText((Decks_Create_Controller.this.count--)+"/40");
        });
        card001.setOnMouseClicked((MouseEvent event) -> {
               Decks_Create_Controller.this.setImagePanel(card001, new ImageView("/Assets/Images/Card_Back.png"));
               amount_Label.setText((Decks_Create_Controller.this.count--)+"/40");
        });
        card002.setOnMouseClicked((MouseEvent event) -> {
               Decks_Create_Controller.this.setImagePanel(card002, new ImageView("/Assets/Images/Card_Back.png"));
               amount_Label.setText((Decks_Create_Controller.this.count--)+"/40");
        });
        card003.setOnMouseClicked((MouseEvent event) -> {
               Decks_Create_Controller.this.setImagePanel(card003, new ImageView("/Assets/Images/Card_Back.png"));
               amount_Label.setText((Decks_Create_Controller.this.count--)+"/40");
        });
        card004.setOnMouseClicked((MouseEvent event) -> {
               Decks_Create_Controller.this.setImagePanel(card004, new ImageView("/Assets/Images/Card_Back.png"));              
               amount_Label.setText((Decks_Create_Controller.this.count--)+"/40");             
        });    
*/
        prevCard.setOnMouseClicked((MouseEvent event) -> {
            if (cardsSelected.size()<40) {
                //cardsSelected.add(selectCard);
                addCard();
                selectCard = null;
            }
            else{
                Notifications.notification("Error", "No puedes tener más de 40 cartas en tu mazo.", 1);
            }
                
//            
//            if(card000.getImage()==null)   
//               Decks_Create_Controller.this.setImagePanel(card000, prevCard);
//            else if(card001.getImage()==null) 
//                Decks_Create_Controller.this.setImagePanel(card001, prevCard);
//            else if(card002.getImage()==null) 
//                Decks_Create_Controller.this.setImagePanel(card002, prevCard);
//            else if(card003.getImage()==null) 
//                Decks_Create_Controller.this.setImagePanel(card003, prevCard);
//            else if(card004.getImage()==null) 
//                Decks_Create_Controller.this.setImagePanel(card004, prevCard);
//            else{
//                Decks_Create_Controller.this.setImagePanel(card000, card001);  
//                Decks_Create_Controller.this.setImagePanel(card001, card002); 
//                Decks_Create_Controller.this.setImagePanel(card002, card003);    
//                Decks_Create_Controller.this.setImagePanel(card003, card004);
//                Decks_Create_Controller.this.setImagePanel(card004, prevCard);
//            }       
//            Decks_Create_Controller.this.cardsSelected.add(selectCard);
//            Decks_Create_Controller.this.prevCard.setImage(new Image("/Assets/Images/Card_Back.png"));
//            Decks_Create_Controller.this.amount_Label.setText((Decks_Create_Controller.this.count++)+"/40");
        });        
    }
    
    public void addCard(){
        try {
            AnchorPane newAp = new AnchorPane();
            newAp.setPrefHeight(0);
            newAp.setPrefWidth(110);
            
            ImageView im = new ImageView(prevCard.getImage());
            
            im.setOnMouseClicked((MouseEvent event) ->{
                for (int i = 0; i < cards_ImagesView_Selected.size(); i++) {
                    if (cards_ImagesView_Selected.get(i).equals(event.getSource())) {                        
                        hbox_cards.getChildren().remove(i);
                        cardsSelected.remove(i);
                        cards_ImagesView_Selected.remove(i);
                        count-=1;
                        amount_Label.setText(count+"/40");
                        break;
                    }
                }
            });
            cards_ImagesView_Selected.add(im);
            cardsSelected.add(selectCard);
            newAp.getChildren().add(im);
            im.setX(5); im.setY(5);
            im.setPreserveRatio(true);
            im.setFitWidth(100);
            
            hbox_cards.getChildren().add(newAp);
            eligible_Cards.setHvalue(1.0);
            count+=1;
            amount_Label.setText(count+"/40");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void setImagePanel(ImageView selected){
        prevCard.setImage(selected.getImage());
    }
    
    private void setImagePanel(ImageView aux, ImageView selected){
        aux.setImage(selected.getImage());
    }
    
     private void getArrayImagesViews(){
        cards_ImagesView_Book.add(card00);
        cards_ImagesView_Book.add(card01);
        cards_ImagesView_Book.add(card02);
        cards_ImagesView_Book.add(card03);
        cards_ImagesView_Book.add(card10);
        cards_ImagesView_Book.add(card11);
        cards_ImagesView_Book.add(card12);
        cards_ImagesView_Book.add(card13);
        cards_ImagesView_Book.add(card20);
        cards_ImagesView_Book.add(card21);
        cards_ImagesView_Book.add(card22);
        cards_ImagesView_Book.add(card23);
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
                    Image imageAux = blobToImage(dataBase.result.getBlob(7));
                    Cards c = new Cards(dataBase.result.getInt(1),
                    dataBase.result.getString(2),
                    dataBase.result.getString(3),
                    dataBase.result.getInt(4),
                    dataBase.result.getInt(5),
                    dataBase.result.getInt(6),
                    imageAux,
                    dataBase.result.getString(8),
                    dataBase.result.getString(9));
                    cards_ImagesView_Book.get(i).setImage(imageAux);
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
                    Image imageAux = blobToImage(dataBase.result.getBlob(7));
                    Cards c = new Cards(dataBase.result.getInt(1),
                    dataBase.result.getString(2),
                    dataBase.result.getString(3),
                    dataBase.result.getInt(4),
                    dataBase.result.getInt(5),
                    dataBase.result.getInt(6),
                    imageAux,
                    dataBase.result.getString(8),
                    dataBase.result.getString(9));
                    cards_ImagesView_Book.get(i).setImage(imageAux);
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
                    Image imageAux = blobToImage(dataBase.result.getBlob(7));
                    Cards c = new Cards(dataBase.result.getInt(1),
                    dataBase.result.getString(2),
                    dataBase.result.getString(3),
                    dataBase.result.getInt(4),
                    dataBase.result.getInt(5),
                    dataBase.result.getInt(6),
                    imageAux,
                    dataBase.result.getString(8),
                    dataBase.result.getString(9));
                    cards_ImagesView_Book.get(i).setImage(imageAux);
                    cards.add(c);
                    i+=1;
                }
                dataBase.DesconectarBasedeDatos();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void saveClick(){
        this.save();
    }
    
    private void save(){
        if (cardsSelected.size()<40) {
            Notifications.notification("Error", "Debes tener 40 Cartas en tu mazo",1);
        }
        try {
            ConnectionMySQL dataBase = new ConnectionMySQL();
            dataBase.ConectarBasedeDatos();            
            String query = "INSERT INTO Mazo (nombre, cant_cartas, ref_Jugador) VALUES ('"+this.nameDeck.getText()+"', "
                    + ""+this.cardsSelected.size()+", "+ID_User+");";
            dataBase.sentence.execute(query);            
            for (int i = 0; i < this.cardsSelected.size(); i++) {                
                query = "INSERT INTO Contiene (ref_Mazo, ref_Carta) VALUES ((SELECT id FROM Mazo WHERE nombre='"+this.nameDeck.getText()+"'), "+this.cardsSelected.get(i).getId()+");";     
                dataBase.sentence.execute(query);
            }
            dataBase.DesconectarBasedeDatos();
        } catch (SQLException e) {
            System.out.println(e.getMessage());     
        }
        try {
            try{
                Stage stage = (Stage) base.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("/Views/Decks/Decks_View.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
            } catch (IOException e) {
            }
        } catch (Exception e) {
        }
    } 
    
    private void cleanImagesViews(){
        cards_ImagesView_Book.forEach((i) -> {
            i.setImage(null);
        });
    }
    
    @FXML
    public void originalCards(){
        page = 0;
        cleanImagesViews();
        prevCard.setImage(null);
        selectCard = null;
        cardMenuState = "ORI";
        fillBook();
    }
    
    @FXML
    public void PersonalizeCards(){
        page = 0;
        cleanImagesViews();
        prevCard.setImage(null);
        selectCard = null;
        cardMenuState = "PER";
        fillBook();
    }
    
    @FXML
    public void OwnCards(){
        page = 0;
        cleanImagesViews();
        prevCard.setImage(null);
        selectCard = null;
        cardMenuState = "OWN";
        fillBook();
    }
    
    @FXML
    public void nextPage(){
        cleanImagesViews();
        page+=1;
        fillBook();
        prev.setDisable(false);
    }
    
    @FXML
    public void prevPage(){
        if (page!=0) {
            cleanImagesViews();
            page-=1;
            fillBook();
        }
        if (page==0) {
            prev.setDisable(true);
        }
    }
    
    private Image blobToImage(Blob b){
        Image image = null;
        try {
            InputStream in = b.getBinaryStream();
            BufferedImage bufImage = ImageIO.read(in);
            image = SwingFXUtils.toFXImage(bufImage, null);
        } catch (IOException | SQLException e) {
        }
        return image;
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
