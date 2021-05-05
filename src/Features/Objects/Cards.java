/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Features.Objects;

import javafx.scene.image.Image;

public class Cards {
    private int id;
    private String name;
    private String element;
    private int atk;
    private int def;
    private int stars;
    private Image imagen;
    private String type;
    private String description;

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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getElement() {
        return element;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public int getStars() {
        return stars;
    }

    public Image getImagen() {
        return imagen;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
    
    
}
