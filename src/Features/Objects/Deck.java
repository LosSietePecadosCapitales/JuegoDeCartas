/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Features.Objects;

import java.util.ArrayList;

/**
 *
 * @author F. Pino 
 */
public class Deck {
    private final int ID;
    private String name;
    private int cardsCount;
    private final ArrayList<Cards> cards;

    public Deck(int ID, String name, ArrayList<Cards> cards) {
        this.ID = ID;
        this.name = name;
        this.cardsCount = cards.size();
        this.cards = cards;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getCardsCount() {
        return this.cards.size();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCardsCount(int cardsCount) {
        this.cardsCount = cardsCount;
    }  
    
    public boolean addCard(Cards card) {
        return this.cards.add(card);
    }
    
    public Cards getCard(int cardNumber){
        return this.cards.get(cardNumber);
    }
    
}