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
    private ArrayList<Cards> cards;
    private boolean isFavorite;

    public Deck(int ID, String name, ArrayList<Cards> cards) {
        this.ID = ID;
        this.name = name;
        this.cards = cards;
        this.cardsCount = cards.size();        
        this.isFavorite = false;
    }
    
    public Deck(int ID, String name) {
        this.ID = ID;
        this.name = name;
        this.cards = new ArrayList<>();
        this.cardsCount = this.cards.size();    
        this.isFavorite = false;
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

    public void setCards(ArrayList<Cards> cards) {
        this.cards = cards;
    }

    public ArrayList<Cards> getCards() {
        return cards;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }    
}