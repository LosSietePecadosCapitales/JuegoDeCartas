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
 *
 * @author F. Pino
 */
public class Validations { 
    private final ConnectionMySQL dataBase = new ConnectionMySQL();
    private final String emailSentence = "SELECT correo, nick, contrasenia "
                    + "FROM Jugador WHERE (correo='' or nick='') and contrasenia='';";            
    private final Pattern patternEmail = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    private final Pattern patternPassword = Pattern
                .compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,10}$");
    private final Pattern patternNick = Pattern
                .compile("[a-zA-Z0-9_ ]{6,8}");
    private final Pattern patternCardName = Pattern
                .compile("^[A-Z][a-zA-Z_ ]*$");
    
    public boolean validateNick(String nick){
        return this.patternNick.matcher(nick).matches();
    }
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
    
    public boolean validatePassword(String pass){
        return this.patternPassword.matcher(pass).matches();
    }
    
    public boolean validateCardName(String cardName){        
        return cardName.length()<25 && this.patternCardName.matcher(cardName).matches();
    }
    public boolean validateNumberAttack(String number){        
        //-5000
        return false;
    }
    public boolean validateNumberDefense(String number){        
        //-5000
        return false;
    }
    public boolean validateDescription(String text){        
        //-285 caracteres
        return false;
    }
}
