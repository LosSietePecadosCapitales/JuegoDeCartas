/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Features.Objects;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author LosSietePecadosCapitales
 */
public class Game {
    private String ip;
    private String name;
    private String pass;
    private String hasPass;
    private String owner;
/**
 * Constructor del juego, utilizado para buscar y unirse a partidas
 * @param ip direccion de ip del jugador, identifica las partidas
 * @param name nombre de la partida
 * @param pass contraseña de la partida
 * @param hasPass determina el cambio de turno
 * @param owner quien creo la partida
 */
    public Game(String ip, String name, String pass, String hasPass, String owner) {
        this.ip = ip;
        this.name = name;
        this.pass = pass;
        this.hasPass = hasPass;
        this.owner = owner;
    }
    /**
     * Obtiene la ip del objeto
     * @return string del atributo ip
     */
    public String getIp() {
        return ip;
    }
    /**
     * Asigna un valor a la variable ip
     * @param ip 
     */
    public void setIp(String ip) {
        this.ip = ip;
    }
    /**
     * Obtiene el nombre del objeto
     * @return string del atributo name
     */
    public String getName() {
        return name;
    }
    /**
     * Asigna un valor al atributo name
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Obtiene el pass del objeto
     * @return string del atributo pass
     */
    public String getPass() {
        return pass;
    }
    /**
     * Asigna un valor al atributo pass
     * @param pass 
     */
    public void setPass(String pass) {
        this.pass = pass;
    }
    /**
     * Obtiene el valor de hasPass
     * @return 
     */
    public String getHasPass() {
        return hasPass;
    }
    /**
     * Asigna un valor al atributo hasPass
     * @param hasPass 
     */
    public void setHasPass(String hasPass) {
        this.hasPass = hasPass;
    }
    /**
     * Obtiene el valor de owner
     * @return 
     */
    public String getOwner() {
        return owner;
    }
    /**
     * Asigna un valor a owner
     * @param owner 
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

}
