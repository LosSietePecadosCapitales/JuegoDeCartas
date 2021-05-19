/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Features.Objects;

import javafx.scene.image.Image;

/**
 * Clase Cards
 * Contiene atributos y metodos basicos de una carta
 * @author LosSietePecadosCapitales
 */
public class Cards {
    //Declaracion de variables
    private int id;
    private String name;
    private String element;
    private int atk;
    private int def;
    private int stars;
    private Image imagen;
    private String type;
    private String description;
    
    /**
     * Constructor Cards
     * @param id identificacion carta
     * @param name nombre carta
     * @param element elemento carta
     * @param atk ataque carta
     * @param def defensa carta
     * @param stars estrellas carta
     * @param imagen imagen carta
     * @param type tipo carta
     * @param description descripcion carta
     */
    public Cards(int id, String name, String element, int atk, int def, int stars, Image imagen, String type, String description) {
        this.id = id;
        this.name = name;
        this.element = element;
        this.atk = atk;
        this.def = def;
        this.stars = stars;
        this.imagen = imagen;
        this.type = type;
        this.description = description;
    }
    
    /**
     * Obtiene Identificacion de carta
     * @return id
     */
    public int getId() {
        return id;
    }
    
    /**
     * Obtiene Nombre de carta
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Obtiene Elemento de carta
     * @return element
     */
    public String getElement() {
        return element;
    }
    
    /**
     * Obtiene Ataque de carta
     * @return atk
     */
    public int getAtk() {
        return atk;
    }

    /**
     * Obtiene Defensa de carta
     * @return def
     */
    public int getDef() {
        return def;
    }

    /**
     * Obtiene Estrellas de carta
     * @return stars
     */
    public int getStars() {
        return stars;
    }

    /**
     * Obtiene Imagen de carta
     * @return imagen
     */
    public Image getImagen() {
        return imagen;
    }
    
    /**
     * Obtiene Tipo de carta
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Obtiene Descripcion de carta
     * @return description
     */
    public String getDescription() {
        return description;
    }   
    
}
