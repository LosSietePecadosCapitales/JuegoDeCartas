/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Features.Managements;

import Features.Connection.ConnectionMySQL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 *  Clase de Validaciones
 * @author LosSietePecadosCapitales
 */
public class Validations { 
    //Declaracion de variables
    private final ConnectionMySQL dataBase = new ConnectionMySQL();
    private final String emailSentence = "SELECT correo, nick, contrasenia "
                    + "FROM Jugador WHERE (correo='' or nick='') and contrasenia='';";            
    private final Pattern patternEmail = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    private final Pattern patternPassword = Pattern
                .compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,10}$");
    private final Pattern patternNick = Pattern
                .compile("[a-zA-Z0-9_]{8,16}");
    private final Pattern patternCardName = Pattern
                .compile("^[A-Z][a-zA-Z_ ]*$");
    
    /**
     * Validacion de Nick
     * @param nick
     * @return True or False (Correcto/Incorrecto)
     */
    public boolean validateNick(String nick){
        return this.patternNick.matcher(nick).matches();
    }
    
    /**
     * Validacion de Email
     * @param email
     * @return 
     */
    public boolean validateEmail(String email){        
        try {
            this.dataBase.ConectarBasedeDatos();
            this.dataBase.result = dataBase.sentence.executeQuery(emailSentence);        
            return this.patternEmail.matcher(email).matches() && !dataBase.result.next();
        } catch (SQLException ex) {
            Logger.getLogger(Validations.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /**
     * Validacion de Contraseña
     * @param pass
     * @return 
     */
    public boolean validatePassword(String pass){
        return this.patternPassword.matcher(pass).matches();
    }
    
    /**
     * Validacion Nombre de Carta
     * @param cardName
     * @return 
     */
    public boolean validateCardName(String cardName){        
        return cardName.length()<=20 && this.patternCardName.matcher(cardName).matches();
    }
    
    /**
     * Validacion Numero de Ataque
     * @param number
     * @return 
     */
    public boolean validateNumberAttack(String number){        
        //-5000
        return false;
    }
    
    /**
     * Validacion Numero de Defensa
     * @param number
     * @return 
     */
    public boolean validateNumberDefense(String number){        
        //-5000
        return false;
    }
    
    /**
     * Validacion Descripcion de Carta
     * @param text
     * @return 
     */
    public boolean validateDescription(String text){        
        return text.length()<=280 && text.length()>0;
    }
}
