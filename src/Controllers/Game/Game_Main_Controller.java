/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Game;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Vicente
 */
public class Game_Main_Controller {
    
    @FXML public Label title;
    @FXML public Button exit, minimize;
    
    @FXML public AnchorPane ownAPMo1, ownAPMo2, ownAPMo3, ownAPMo4, ownAPMo5;
    @FXML public AnchorPane ownAPMa1, ownAPMa2, ownAPMa3, ownAPMa4, ownAPMa5;
    @FXML public AnchorPane prevCardAP, cemAP, deckAP, handOwnAP, handEneAP;
    
    @FXML public Label cemLabel, deckLabel;
    
    @FXML
    public void initialize(){
    }
    
}
