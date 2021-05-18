/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Features.Objects;

import java.util.ArrayList;

/**
 *
 * @author F. Pino Cambiar
 */
public class Deck {
    private final int ID;
    private String name;
    private int cardsCount;
    private final int ref_player;
    private final ArrayList<Cards> cards;

    public Deck(int ID, String name, int cardsCount, int ref_player) {
        this.ID = ID;
        this.name = name;
        this.cardsCount = cardsCount;
        this.ref_player = ref_player;
        this.cards = new ArrayList<>();
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

    public int getRef_player() {
        return ref_player;
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