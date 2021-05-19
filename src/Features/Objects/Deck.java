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
 * Clase Deck: Su funcion es la de recrear el mazo extraido de la base de datos
 * tanto con sus atribitos como metodos
 */
public class Deck {
    private final int ID;
    private String name;
    private final int cardsCount;
    private ArrayList<Cards> cards;
    private boolean isFavorite;

    /**
     *  Constructor Deck con cartas
     * @param ID Numero identificador de mazo unico.
     * @param name Nombre de mazo asignado por el usuario.
     * @param cards Lista de cartas pertenecientes al mazo.
     */
    public Deck(int ID, String name, ArrayList<Cards> cards) {
        this.ID = ID;
        this.name = name;
        this.cards = cards;
        this.cardsCount = cards.size();        
        this.isFavorite = false;
    }
    
    /**
     * Constructor Deck sin cartas
     * @param ID Numero identificador de mazo unico.
     * @param name Nombre de mazo asignado por el usuario. 
     */
    public Deck(int ID, String name) {
        this.ID = ID;
        this.name = name;
        this.cards = new ArrayList<>();
        this.cardsCount = this.cards.size();    
        this.isFavorite = false;
    }
    
    /**
     * 
     * @return Se obtiene numero identificador unico de mazo.
     */
    public int getID() {
        return ID;
    }

    /**
     * 
     * @return Se obtiene nombre del mazo.
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @return Se obtiene numero de cartas que posee el mazo.
     */
    public int getCardsCount() {
        return this.cards.size();
    }

    /**
     * 
     * @param name Se le asigna un el String del mazo.
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * 
     * @param card Se agrega un ArrayList de cartas listado de cartas que tendrá el mazo
     * @return 
     */
    public boolean addCard(Cards card) {
        return this.cards.add(card);
    }
    
    /**
     * 
     * @param cardNumber Obtener un objeto Cards(carta) del mazo en la posicion numerica deseada.
     * @return 
     */
    public Cards getCard(int cardNumber){
        return this.cards.get(cardNumber);
    }

    /**
     * 
     * @param cards 
     */
    public void setCards(ArrayList<Cards> cards) {
        this.cards = cards;
    }

    /**
     * 
     * @return Obtener listado (ArrayList) de objetos Cards de cartas del mazo.
     */
    public ArrayList<Cards> getCards() {
        return cards;
    }

    /**
     * 
     * @return Retorna verdadero si el mazo es el favorito por el usuario.
     */
    public boolean isFavorite() {
        return isFavorite;
    }
    /**
     * 
     * @param isFavorite  Se ingresa verdadero o falso dependiendo de si el usuario la ha elegido como favoritio.
     */
    public void setFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }    
}