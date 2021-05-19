/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Game;

import Controllers.Decks.Decks_Main_Controller;
import Features.Managements.Notifications;
import Features.Objects.Cards;
import Features.Objects.Deck;
import java.util.ArrayList;
import java.util.Collections;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Vicente
 */
public class Game_Main_Controller_Server {
    
    public AnchorPane base;
    @FXML public Label title, ownLifeL, eneLifeL;
    @FXML public Button exit, minimize, inv_atk, inv_def, sacr, endTurn;
    
    @FXML public AnchorPane ownAPMo1, ownAPMo2, ownAPMo3, ownAPMo4, ownAPMo5;
    @FXML public ImageView ownIM01, ownIM02, ownIM03, ownIM04, ownIM05;
    
    @FXML public AnchorPane ownAPMa1, ownAPMa2, ownAPMa3, ownAPMa4, ownAPMa5;
    @FXML public AnchorPane eneAPMo1, eneAPMo2, eneAPMo3, eneAPMo4, eneAPMo5;
    @FXML public AnchorPane eneAPMa1, eneAPMa2, eneAPMa3, eneAPMa4, eneAPMa5;
    @FXML public AnchorPane prevCardAP, cemAP, deckAP, handOwnAP, handEneAP;
    
    @FXML public HBox handOwnHB, handEneHB;
    
    @FXML public Label cemLabel, deckLabel;
    
    @FXML public ImageView prevImage;
    @FXML public ImageView cementeryIM;
    
    public ArrayList<ImageView> ownCardsAL, eneCardsAL;
    
    
    public Deck ownDeck;
    public Deck eneDeck;
    
    //private Thread current;
    private int grades;
    private Cards selectedOwnCard;
    private Cards selectedEnemyCard;
    
    /* SOLUCION PARCHE */
    private ArrayList<Cards> ownDeckCards;
    private ArrayList<Cards> ownHandCards;
    private ArrayList<Cards> monsterLine;
    
    public void initialize(){
        ownDeckCards = new ArrayList<>();
        monsterLine = new ArrayList<>();
        monsterLine.add(null);
        monsterLine.add(null);
        monsterLine.add(null);
        monsterLine.add(null);
        monsterLine.add(null);
        
        ownHandCards = new ArrayList<>();
        getPrefDeck();
        initConfigCardboard();
    }
    
    public void addCard(Cards c){
        try {
            AnchorPane newAp = new AnchorPane();
            newAp.setPrefHeight(0);
            newAp.setPrefWidth(110);
            
            ImageView im = new ImageView(c.getImagen());
            
            im.setOnMouseClicked((MouseEvent e) ->{
                prevImage.setImage(((ImageView) e.getSource()).getImage());
                for (int i = 0; i < ownHandCards.size(); i++) {
                    if (c.equals(ownHandCards.get(i))) {
                        selectedOwnCard = ownHandCards.get(i);
                    }
                }
            });
            
            
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
    public void addCardToHand(){
        Cards aux = ownDeckCards.remove(0);
        addCard(aux);
        ownHandCards.add(aux);
        deckAP.setDisable(true);
        inv_atk.setDisable(false);
        inv_def.setDisable(false);
        sacr.setDisable(false);
        endTurn.setDisable(false);
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
    
    @FXML
    public void moveOwnHandAP_Up(){
        handOwnAP.setLayoutY(530);
        /*try {
            current.stop();
        } catch (Exception e) {
        }
        Task <Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                for (int i = ((int) handOwnAP.getLayoutY()); i > 530;) {
                    handOwnAP.setLayoutY(handOwnAP.getLayoutY()-1);
                    Thread.sleep(1);
                }
                return null;
            }
        };
        Thread thread = new Thread(task);
        thread.setDaemon(true);
        current = thread;
        thread.start();*/
    }
    
    @FXML
    public void moveOwnHandAP_Down(){
        handOwnAP.setLayoutY(675);
        /*
        try {
            current.stop();
        } catch (Exception e) {
        }
        Task <Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                for (int i = ((int) handOwnAP.getLayoutY()); i < 675;) {
                    handOwnAP.setLayoutY(handOwnAP.getLayoutY()+1);
                    Thread.sleep(1);
                }
                return null;
            }
        };
        Thread thread = new Thread(task);
        thread.setDaemon(true);
        current = thread;
        thread.start();*/
    }
    
    @FXML
    public void invokeDef(){
        grades = -90;
        ownAPMo1.setDisable(false);
        ownAPMo2.setDisable(false);
        ownAPMo3.setDisable(false);
        ownAPMo4.setDisable(false);
        ownAPMo5.setDisable(false);
    }
    
    @FXML
    public void invokeAtk(){
        grades = 0;
        ownAPMo1.setDisable(false);
        ownAPMo2.setDisable(false);
        ownAPMo3.setDisable(false);
        ownAPMo4.setDisable(false);
        ownAPMo5.setDisable(false);
    }
    
    public void getPrefDeck(){
        try {
            ownDeckCards = (ArrayList<Cards>) Decks_Main_Controller.deckPref.getCards().clone();
            Collections.shuffle(ownDeckCards);
            for (int i = 0; i < 5; i++) {
                Cards aux = ownDeckCards.remove(0);
                addCard(aux);
                ownHandCards.add(aux);
            }
        } catch (Exception e) {
        }
    }
    
        /* FALTA ESTO POR IMPLEMENTAR*/
    
    public void sacrifice(){
        // SACRIFICAR UNA CARTA Y MOVER AL CEMENTERIO
        int index;
        if (selectedOwnCard == null) {
            Notifications.notification("Error", "Debes seleccionar una carta antes", 1);
        }
        else{
            for (index = 0; index < ownHandCards.size(); index++) {
                if (selectedOwnCard.equals(ownHandCards.get(index))) {
                    
                    break;
                }
            }
            
            for (index = 0; index < monsterLine.size(); index++) {
                if (selectedOwnCard.equals(monsterLine.get(index))) {
                    
                    break;
                }
            }
        }
            
    }
    
    public void initConfigCardboard(){
        // COLOCAR LA CARTA SELECCIONADA LUEGO DEL MODO EN EL TABLERO
        // SOLAMENTE EN LA PRIMERA LINEA, LA SEGUNDA SON LAS MAGICAS Y TRAMPAS
        // QUE NO ESTAN :V 
        System.out.println("caca");
        ownIM01.setOnMouseClicked((MouseEvent event) -> {
            if (monsterLine.get(0)==null) {
                if (selectedOwnCard!=null) {
                    try {
                        ownAPMo1.setRotate(grades);
                        monsterLine.set(0, selectedOwnCard);
                        for (int i = 0; i < ownHandCards.size(); i++) {
                            if (ownHandCards.equals(selectedOwnCard)) {
                                handOwnHB.getChildren().remove(i);
                                break;
                            }
                        }
                        ownIM01.setImage(monsterLine.get(0).getImagen());
                        selectedOwnCard = null;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else{
                    Notifications.notification("Error", "Debes seleccionar un monstruo antes", 1);
                }
            }
            else{
                Notifications.notification("Error", "Ya hay un monstruo en esa posicion", 1);
            }
        });
        
        ownIM02.setOnMouseClicked((MouseEvent event) -> {
            if (monsterLine.get(1)==null) {
                if (selectedOwnCard!=null) {
                    try {
                        ownAPMo2.setRotate(grades);
                        monsterLine.set(1, selectedOwnCard);
                        for (int i = 0; i < ownHandCards.size(); i++) {
                            if (ownHandCards.equals(selectedOwnCard)) {
                                handOwnHB.getChildren().remove(i);
                                break;
                            }
                        }
                        ownIM02.setImage(monsterLine.get(1).getImagen());
                        selectedOwnCard = null;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else{
                    Notifications.notification("Error", "Debes seleccionar un monstruo antes", 1);
                }
            }
            else{
                Notifications.notification("Error", "Ya hay un monstruo en esa posicion", 1);
            }
                
        });
        
        ownIM03.setOnMouseClicked((MouseEvent event) -> {
            if (monsterLine.get(2)==null) {
                if (selectedOwnCard!=null) {
                    try {
                        ownAPMo3.setRotate(grades);
                        monsterLine.set(2, selectedOwnCard);
                        for (int i = 0; i < ownHandCards.size(); i++) {
                            if (ownHandCards.equals(selectedOwnCard)) {
                                handOwnHB.getChildren().remove(i);
                                break;
                            }
                        }
                        ownIM03.setImage(monsterLine.get(2).getImagen());
                        selectedOwnCard = null;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else{
                    Notifications.notification("Error", "Debes seleccionar un monstruo antes", 1);
                }
            }
            else{
                Notifications.notification("Error", "Ya hay un monstruo en esa posicion", 1);
            }
            
        });
        
        ownIM04.setOnMouseClicked((MouseEvent event) -> {
            if (monsterLine.get(3)==null) {
                if (selectedOwnCard!=null) {
                    try {
                        ownAPMo4.setRotate(grades);
                        monsterLine.set(3, selectedOwnCard);
                        for (int i = 0; i < ownHandCards.size(); i++) {
                            if (ownHandCards.equals(selectedOwnCard)) {
                                handOwnHB.getChildren().remove(i);
                                break;
                            }
                        }
                        ownIM04.setImage(monsterLine.get(3).getImagen());
                        selectedOwnCard = null;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else{
                    Notifications.notification("Error", "Debes seleccionar un monstruo antes", 1);
                }
            }
            else{
                Notifications.notification("Error", "Ya hay un monstruo en esa posicion", 1);
            }
                
        });
        
        ownIM05.setOnMouseClicked((MouseEvent event) -> {
            if (monsterLine.get(4)==null) {
                if (selectedOwnCard!=null) {
                    try {
                        ownAPMo5.setRotate(grades);
                        monsterLine.set(4, selectedOwnCard);
                        for (int i = 0; i < ownHandCards.size(); i++) {
                            if (ownHandCards.equals(selectedOwnCard)) {
                                handOwnHB.getChildren().remove(i);
                                break;
                            }
                            else{
                                System.out.println("poto");
                            }
                        }
                        ownIM05.setImage(monsterLine.get(4).getImagen());
                        selectedOwnCard = null;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else{
                    Notifications.notification("Error", "Debes seleccionar un monstruo antes", 1);
                }
            }
            else{
                Notifications.notification("Error", "Ya hay un monstruo en esa posicion", 1);
            }
                
        });
        System.out.println("caca2");
    }
    
    public void calc_Damage(){
        // CALCULAR LA DIFERENCIA DE DAÑO Y DEPENDIENDO DE QUIEN RECIBE ESA
        // DIFERENCIA ES A QUIEN SE LE DISMINUYE LA VIDA
        // VERIFICAR ACA TAMBIEN QUE PASA SI EL DAÑO ES 0 O MENOR
        // ALGUN MENSAJE PARA GANAR PARTIDA Y TERMINAR PARTIDA
        // DESPUES IMPORTANTE REDIRIGIR A LA PANTALLA PRINCIPAL
    }
    
    @FXML
    public void endTurnAction(){
        deckAP.setDisable(false);
        inv_atk.setDisable(true);
        inv_def.setDisable(true);
        sacr.setDisable(true);
        endTurn.setDisable(true);
        ownAPMo1.setDisable(true);
        ownAPMo2.setDisable(true);
        ownAPMo3.setDisable(true);
        ownAPMo4.setDisable(true);
        ownAPMo5.setDisable(true);
    }
    @FXML
    public void invAtkAction(){
        
    }
    @FXML
    public void invDefAction(){
        
    }
}