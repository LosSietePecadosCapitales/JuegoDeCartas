/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Features.Objects;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Vicente
 */
public class Game {
    private String ip;
    private String name;
    private String pass;
    private String hasPass;
    private String owner;

    public Game(String ip, String name, String pass, String hasPass, String owner) {
        this.ip = ip;
        this.name = name;
        this.pass = pass;
        this.hasPass = hasPass;
        this.owner = owner;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getHasPass() {
        return hasPass;
    }

    public void setHasPass(String hasPass) {
        this.hasPass = hasPass;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

}
