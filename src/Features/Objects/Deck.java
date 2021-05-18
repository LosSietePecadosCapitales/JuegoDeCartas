/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Features.Objects;

import java.util.ArrayList;

/**
 *
 * @author Vicente
 */
public class Deck {
    private int id;
    private String name;
    private ArrayList<Cards> cards;

    public Deck(int id, String name, ArrayList<Cards> cards) {
        this.id = id;
        this.name = name;
        this.cards = cards;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Cards> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Cards> cards) {
        this.cards = cards;
    }
    
    
}
