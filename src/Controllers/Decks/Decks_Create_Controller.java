package Controllers.Decks;

import static Controllers.Panels.Initial_Controller.ID_User;
import Features.Connection.ConnectionMySQL;
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
import javax.imageio.ImageIO;

public class Decks_Create_Controller {
    
    @FXML public AnchorPane base;
    @FXML public ScrollPane eligible_Cards;
    @FXML public Label number_Label;
    @FXML public Label amount_Label;
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
    
    @FXML public ImageView card000;
    @FXML public ImageView card001;
    @FXML public ImageView card002;
    @FXML public ImageView card003;
    @FXML public ImageView card004;

    @FXML public ImageView defaultCard;
    @FXML public ImageView prevCard;
    
    private final int itemsPerPage = 12;
    private int page;
    public static Cards selectCard;
    private ArrayList<Cards> cards;
    private ArrayList<Cards> cardsSelected;
    private ArrayList<ImageView> cards_ImagesView;
    private int count = 0;

    @FXML
    public void initialize(){
        page = 0;
        selectCard = null;
        cards = new ArrayList<>();
        cards_ImagesView = new ArrayList<>();
        cardsSelected = new ArrayList<>();
        getArrayImagesViews();
        fillBook();
        card00.setOnMouseClicked((MouseEvent event) -> {
               Decks_Create_Controller.this.setImagePanel(card00);
               selectCard = cards.get(0);
        });
        card01.setOnMouseClicked((MouseEvent event) -> {
               Decks_Create_Controller.this.setImagePanel(card01);
               selectCard = cards.get(1);
        });
        card02.setOnMouseClicked((MouseEvent event) -> {
               Decks_Create_Controller.this.setImagePanel(card02);
               selectCard = cards.get(2);
        });
        card03.setOnMouseClicked((MouseEvent event) -> {
               Decks_Create_Controller.this.setImagePanel(card03);
               selectCard = cards.get(3);
        });
        card10.setOnMouseClicked((MouseEvent event) -> {
               Decks_Create_Controller.this.setImagePanel(card10);
               selectCard = cards.get(4);
        });
        card11.setOnMouseClicked((MouseEvent event) -> {
               Decks_Create_Controller.this.setImagePanel(card11);
               selectCard = cards.get(5);
        });
        card12.setOnMouseClicked((MouseEvent event) -> {
               Decks_Create_Controller.this.setImagePanel(card12);
               selectCard = cards.get(6);
        });
        card13.setOnMouseClicked((MouseEvent event) -> {
               Decks_Create_Controller.this.setImagePanel(card13);
               selectCard = cards.get(7);
        });
        card20.setOnMouseClicked((MouseEvent event) -> {
               Decks_Create_Controller.this.setImagePanel(card20);
               selectCard = cards.get(8);
        });
        card21.setOnMouseClicked((MouseEvent event) -> {
               Decks_Create_Controller.this.setImagePanel(card21);
               selectCard = cards.get(9);
        });
        card22.setOnMouseClicked((MouseEvent event) -> {
               Decks_Create_Controller.this.setImagePanel(card22);
               selectCard = cards.get(10);
        });
        card23.setOnMouseClicked((MouseEvent event) -> {
               Decks_Create_Controller.this.setImagePanel(card23);
               selectCard = cards.get(11);
        });

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
        
        prevCard.setOnMouseClicked((MouseEvent event) -> {     
            if(card000.getImage()==null)   
               Decks_Create_Controller.this.setImagePanel(card000, prevCard);
            else if(card001.getImage()==null) 
                Decks_Create_Controller.this.setImagePanel(card001, prevCard);
            else if(card002.getImage()==null) 
                Decks_Create_Controller.this.setImagePanel(card002, prevCard);
            else if(card003.getImage()==null) 
                Decks_Create_Controller.this.setImagePanel(card003, prevCard);
            else if(card004.getImage()==null) 
                Decks_Create_Controller.this.setImagePanel(card004, prevCard);
            else{
                Decks_Create_Controller.this.setImagePanel(card000, card001);  
                Decks_Create_Controller.this.setImagePanel(card001, card002); 
                Decks_Create_Controller.this.setImagePanel(card002, card003);    
                Decks_Create_Controller.this.setImagePanel(card003, card004);
                Decks_Create_Controller.this.setImagePanel(card004, prevCard);
            }       
            Decks_Create_Controller.this.cardsSelected.add(selectCard);
            Decks_Create_Controller.this.prevCard.setImage(new Image("/Assets/Images/Card_Back.png"));
            Decks_Create_Controller.this.amount_Label.setText((Decks_Create_Controller.this.count++)+"/40");
        });
        
    }
    
    private void setImagePanel(ImageView selected){
        prevCard.setImage(selected.getImage());
    }
    
    private void setImagePanel(ImageView aux, ImageView selected){
        aux.setImage(selected.getImage());
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
        try {
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
                cards_ImagesView.get(i).setImage(imageAux);
                cards.add(c);
                i+=1;
            }
            
            dataBase.DesconectarBasedeDatos();
        } catch (SQLException e) {
        }
    } 
    
    
    @FXML
    public void saveClick(){
        this.save();
    }
    
    
    private void save(){
        try {
            ConnectionMySQL dataBase = new ConnectionMySQL();
            dataBase.ConectarBasedeDatos();            
            String query = "INSERT INTO Mazo (nombre, cant_cartas, ref_Jugador) VALUES ('"+this.nameDeck.getText()+"', "
                    + ""+this.cardsSelected.size()+", "+ID_User+");";
            dataBase.sentence.execute(query);            
            for (int i = 0; i < this.cardsSelected.size(); i++) {                
                query = "INSERT INTO Contiene (ref_Mazo, ref_Carta) VALUES ((SELECT id FROM Mazo WHERE nombre='"+this.nameDeck.getText()+"'), "+this.cardsSelected.get(i).getId()+");";     
                System.out.println(query);
                dataBase.sentence.execute(query);
            }
            dataBase.DesconectarBasedeDatos();
        } catch (SQLException e) {
            System.out.println(e.getMessage());     
        }
    } 
    
    private void cleanImagesViews(){
        cards_ImagesView.forEach((i) -> {
            i.setImage(null);
        });
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
