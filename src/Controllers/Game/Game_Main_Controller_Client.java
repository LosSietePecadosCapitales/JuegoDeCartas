/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Game;

import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Vicente
 */
public class Game_Main_Controller_Client {
    
    public AnchorPane base;
    @FXML public Label title, ownLifeL, eneLifeL;
    @FXML public Button exit, minimize;
    
    @FXML public AnchorPane ownAPMo1, ownAPMo2, ownAPMo3, ownAPMo4, ownAPMo5;
    @FXML public AnchorPane ownAPMa1, ownAPMa2, ownAPMa3, ownAPMa4, ownAPMa5;
    @FXML public AnchorPane eneAPMo1, eneAPMo2, eneAPMo3, eneAPMo4, eneAPMo5;
    @FXML public AnchorPane eneAPMa1, eneAPMa2, eneAPMa3, eneAPMa4, eneAPMa5;
    @FXML public AnchorPane prevCardAP, cemAP, deckAP, handOwnAP, handEneAP;
    
    @FXML public HBox handOwnHB, handEneHB;
    
    @FXML public Label cemLabel, deckLabel;
    
    public ArrayList<ImageView> ownCardsAL, eneCardsAL;
    
    public void initialize(){
        //Crear Server
    }
    
    @FXML
    public void addCard(){
        try {
            AnchorPane newAp = new AnchorPane();
            newAp.setPrefHeight(0);
            newAp.setPrefWidth(110);
            
            ImageView im = new ImageView(new Image("/Assets/Images/Card_Back.png"));
            
            newAp.getChildren().add(im);            
            im.setX(5); im.setY(5);
            im.setPreserveRatio(true);
            im.setFitWidth(100);
            
            handOwnHB.getChildren().add(newAp);
        } catch (Exception e) {
            e.printStackTrace();
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
    
    /* FALTA ESTO POR IMPLEMENTAR*/
    
    public void moveOwnHandAP(){
        // ANIMACION PARA MOVER LA MANO
    }
    
    public void moveEneHandAP(){
        // ANIMACION PARA MOVER LA MANO
    }
    
    public void addCardHand(){
        // CLICK EN EL MAZO Y AGREGAR CARTA
    }
    
    public void invoqueDef(){
        // INVOCAR EN MODO DEFENSA CON GRADOS -90
    }
    
    public void invoqueAtk(){
        // INVOCAR EN MODO DEFENSA CON GRADOS 0
    }
    
    public void sacrifice(){
        // SACRIFICAR UNA CARTA Y MOVER AL CEMENTERIO
    }
    
    public void prevCard(){
        // MOSTRAR CARTA EN EL PREV
    }
    
    public void putCardTable(){
        // COLOCAR LA CARTA SELECCIONADA LUEGO DEL MODO EN EL TABLERO
        // SOLAMENTE EN LA PRIMERA LINEA, LA SEGUNDA SON LAS MAGICAS Y TRAMPAS
        // QUE NO ESTAN :V 
    }
    
    public void calc_Damage(){
        // CALCULAR LA DIFERENCIA DE DAÑO Y DEPENDIENDO DE QUIEN RECIBE ESA
        // DIFERENCIA ES A QUIEN SE LE DISMINUYE LA VIDA
        // VERIFICAR ACA TAMBIEN QUE PASA SI EL DAÑO ES 0 O MENOR
        // ALGUN MENSAJE PARA GANAR PARTIDA Y TERMINAR PARTIDA
        // DESPUES IMPORTANTE REDIRIGIR A LA PANTALLA PRINCIPAL
    }
}