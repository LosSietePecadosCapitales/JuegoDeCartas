/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Features.Managements;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author javen
 */
public class ValidationsTest {
    
    public ValidationsTest() {
    }

    /**
     * Test of validateNick method, of class Validations.
     * Menor a 8 caracteres
     */
    @Test
    public void testValidateNick_Prueba1() {
        System.out.println("validateNick_Prueba1");
        String nick = "User"; //4 caracteres
        Validations instance = new Validations();
        boolean expResult = false;
        boolean result = instance.validateNick(nick);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of validateNick method, of class Validations.
     * Mayor a 16 caracteres
     */
    @Test
    public void testValidateNick_Prueba2() {
        System.out.println("validateNick_Prueba2");
        String nick = "UserUserUserUserr"; //17 caracteres
        Validations instance = new Validations();
        boolean expResult = false;
        boolean result = instance.validateNick(nick);
        assertEquals(expResult, result);
    }    

    /**
     * Test of validateNick method, of class Validations.
     * Igual a 16 caracteres
     */
    @Test
    public void testValidateNick_Prueba3A() {
        System.out.println("validateNick_Prueba3A");
        String nick = "UserUserUserUser"; //16 caracteres
        Validations instance = new Validations();
        boolean expResult = true;
        boolean result = instance.validateNick(nick);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateNick method, of class Validations.
     * Igual a 8 caracteres
     */
    @Test
    public void testValidateNick_Prueba3B() {
        System.out.println("validateNick_Prueba3B");
        String nick = "UserUser"; //8 caracteres
        Validations instance = new Validations();
        boolean expResult = true;
        boolean result = instance.validateNick(nick);
        assertEquals(expResult, result);
    }    
    
    /**
     * Test of validateNick method, of class Validations.
     * Entre 8 y 16 caracteres
     */
    @Test
    public void testValidateNick_Prueba3C() {
        System.out.println("validateNick_Prueba3C");
        String nick = "UserUserUser"; //12 caracteres
        Validations instance = new Validations();
        boolean expResult = true;
        boolean result = instance.validateNick(nick);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of validateEmail method, of class Validations.
     * Ingresando formato correcto con nombre @ dominio
     */
    @Test
    public void testValidateEmail_Prueba1() {
        System.out.println("validateEmail_Prueba1");
        String email = "minombre@midominio.com";
        Validations instance = new Validations();
        boolean expResult = true;
        boolean result = instance.validateEmail(email);
        assertEquals(expResult, result);
    }    

   /**
     * Test of validateEmail method, of class Validations.
     * Solo nombre sin @ ni dominio
     */
    @Test
    public void testValidateEmail_Prueba2() {
        System.out.println("validateEmail_Prueba2");
        String email = "minombre";
        Validations instance = new Validations();
        boolean expResult = false;
        boolean result = instance.validateEmail(email);
        assertEquals(expResult, result);
    }    
    
   /**
     * Test of validateEmail method, of class Validations.
     * Solo con @ y dominio.
     */
    @Test
    public void testValidateEmail_Prueba3() {
        System.out.println("validateEmail_Prueba3");
        String email = "@dominio.cl";
        Validations instance = new Validations();
        boolean expResult = false;
        boolean result = instance.validateEmail(email);
        assertEquals(expResult, result);
    }    

   /**
     * Test of validateEmail method, of class Validations.
     * Prueba1 + dominio incorrecto
     */
    @Test
    public void testValidateEmail_Prueba4() {
        System.out.println("validateEmail_Prueba4");
        String email = "minombre@dominio,com";
        Validations instance = new Validations();
        boolean expResult = false;
        boolean result = instance.validateEmail(email);
        assertEquals(expResult, result);
    }    
    
    /**
     * Test of validatePassword method, of class Validations.
     * Menor a 6 caracteres, con letra mayúscula, minúscula y número
     */
    @Test
    public void testValidatePassword_Prueba1() {
        System.out.println("validatePassword_Prueba1");
        String pass = "Pass6"; //5 caracteres
        Validations instance = new Validations();
        boolean expResult = false;
        boolean result = instance.validatePassword(pass);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of validatePassword method, of class Validations.
     * Mayor a 10 caracteres, con letra mayúscula, minúscula y número.
     */
    @Test
    public void testValidatePassword_Prueba2() {
        System.out.println("validatePassword_Prueba2");
        String pass = "Password06X"; //11 caracteres
        Validations instance = new Validations();
        boolean expResult = false;
        boolean result = instance.validatePassword(pass);
        assertEquals(expResult, result);
    }    

    /**
     * Test of validatePassword method, of class Validations.
     * Igual a 10 caracteres, con letra mayúscula, minúscula y número.
     */
    @Test
    public void testValidatePassword_Prueba3A() {
        System.out.println("validatePassword_Prueba3A");
        String pass = "Password06"; //10 caracteres
        Validations instance = new Validations();
        boolean expResult = true;
        boolean result = instance.validatePassword(pass);
        assertEquals(expResult, result);
    }    

    /**
     * Test of validatePassword method, of class Validations.
     * Igual a 6 caracteres, con letra mayúscula, minúscula y número.
     */
    @Test
    public void testValidatePassword_Prueba3B() {
        System.out.println("validatePassword_Prueba3B");
        String pass = "Pass06"; //6 caracteres
        Validations instance = new Validations();
        boolean expResult = true;
        boolean result = instance.validatePassword(pass);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of validatePassword method, of class Validations.
     * Entre 6 y 10 caracteres, con mayúscula, minúscula y número.
     */
    @Test
    public void testValidatePassword_Prueba3C() {
        System.out.println("validatePassword_Prueba3C");
        String pass = "Password7"; //9 caracteres
        Validations instance = new Validations();
        boolean expResult = true;
        boolean result = instance.validatePassword(pass);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of validatePassword method, of class Validations.
     * Prueba3C + caracteres especiales
     */
    @Test
    public void testValidatePassword_Prueba4() {
        System.out.println("validatePassword_Prueba4");
        String pass = "Pass7_#@$"; //9 caracteres
        Validations instance = new Validations();
        boolean expResult = true;
        boolean result = instance.validatePassword(pass);
        assertEquals(expResult, result);
    }    
    
    /**
     * Test of validatePassword method, of class Validations.
     * Entre 6 y 10 caracteres, sin mayúscula, con minúscula y con número.
     */
    @Test
    public void testValidatePassword_Prueba5() {
        System.out.println("validatePassword_Prueba5");
        String pass = "password7"; //9 caracteres
        Validations instance = new Validations();
        boolean expResult = false;
        boolean result = instance.validatePassword(pass);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of validatePassword method, of class Validations.
     * Entre 6 y 10 caracteres, con mayúscula, sin minúscula y con número.
     */
    @Test
    public void testValidatePassword_Prueba6() {
        System.out.println("validatePassword_Prueba6");
        String pass = "PASSWORD7"; //9 caracteres
        Validations instance = new Validations();
        boolean expResult = false;
        boolean result = instance.validatePassword(pass);
        assertEquals(expResult, result);
    }    
    
    /**
     * Test of validatePassword method, of class Validations.
     * Entre 6 y 10 caracteres, con mayúscula, con minúscula y sin número.
     */
    @Test
    public void testValidatePassword_Prueba7() {
        System.out.println("validatePassword_Prueba7");
        String pass = "PassWord"; //8 caracteres
        Validations instance = new Validations();
        boolean expResult = false;
        boolean result = instance.validatePassword(pass);
        assertEquals(expResult, result);
    }    
    
    /**
     * Test of validateCardName method, of class Validations.
     * Entre 1 y 20 caracteres.
     */
    @Test
    public void testValidateCardName_Prueba1() {
        System.out.println("validateCardName_Prueba1");
        String cardName = "Nombre de la CartaX"; //19 caracteres
        Validations instance = new Validations();
        boolean expResult = true;
        boolean result = instance.validateCardName(cardName);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of validateCardName method, of class Validations.
     * Mayor a 20 caracteres
     */
    @Test
    public void testValidateCardName_Prueba2() {
        System.out.println("validateCardName_Prueba2");
        String cardName = "Nombre de la CartaxDD"; //21 caracteres
        Validations instance = new Validations();
        boolean expResult = false;
        boolean result = instance.validateCardName(cardName);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateCardName method, of class Validations.
     * Igual a 20 caracteres
     */
    @Test
    public void testValidateCardName_Prueba3() {
        System.out.println("validateCardName_Prueba3");
        String cardName = "Nombre de la CartaxD"; //20 caracteres
        Validations instance = new Validations();
        boolean expResult = true;
        boolean result = instance.validateCardName(cardName);
        assertEquals(expResult, result);
    }    
    
    /**
     * Test of validateCardName method, of class Validations.
     * Igual a 0 caracteres
     */
    @Test
    public void testValidateCardName_Prueba4() {
        System.out.println("validateCardName_Prueba4");
        String cardName = ""; //0 caracteres
        Validations instance = new Validations();
        boolean expResult = false;
        boolean result = instance.validateCardName(cardName);
        assertEquals(expResult, result);
    }        
    
    /**
     * Test of validateNumberAttack method, of class Validations.
     * Entre 0 y 9999
     */
    @Test
    public void testValidateNumberAttack_Prueba1() {
        System.out.println("validateNumberAttack_Prueba1");
        String number = "5000";
        Validations instance = new Validations();
        boolean expResult = true;
        boolean result = instance.validateNumberAttack(number);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateNumberAttack method, of class Validations.
     * Mayor a 9999
     */
    @Test
    public void testValidateNumberAttack_Prueba2() {
        System.out.println("validateNumberAttack_Prueba2");
        String number = "10000";
        Validations instance = new Validations();
        boolean expResult = false;
        boolean result = instance.validateNumberAttack(number);
        assertEquals(expResult, result);
    }    

    /**
     * Test of validateNumberAttack method, of class Validations.
     * Menor a 0 (valor negativo)
     */
    @Test
    public void testValidateNumberAttack_Prueba3() {
        System.out.println("validateNumberAttack_Prueba3");
        String number = "-1";
        Validations instance = new Validations();
        boolean expResult = false;
        boolean result = instance.validateNumberAttack(number);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateNumberAttack method, of class Validations.
     * Igual a 9999
     */
    @Test
    public void testValidateNumberAttack_Prueba4() {
        System.out.println("validateNumberAttack_Prueba4");
        String number = "5001";
        Validations instance = new Validations();
        boolean expResult = true;
        boolean result = instance.validateNumberAttack(number);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateNumberAttack method, of class Validations.
     * Igual a 0
     */
    @Test
    public void testValidateNumberAttack_Prueba5() {
        System.out.println("validateNumberAttack_Prueba5");
        String number = "0";
        Validations instance = new Validations();
        boolean expResult = true;
        boolean result = instance.validateNumberAttack(number);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateNumberAttack method, of class Validations.
     * String
     */
    @Test
    public void testValidateNumberAttack_Prueba6() {
        System.out.println("validateNumberAttack_Prueba6");
        String number = "HolaxD";
        Validations instance = new Validations();
        boolean expResult = false;
        boolean result = instance.validateNumberAttack(number);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of validateNumberDefense method, of class Validations.
     * Entre 0 y 9999
     */
    @Test
    public void testValidateNumberDefense_Prueba1() {
        System.out.println("validateNumberDefense_Prueba1");
        String number = "6666";
        Validations instance = new Validations();
        boolean expResult = true;
        boolean result = instance.validateNumberDefense(number);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of validateNumberDefense method, of class Validations.
     * Mayor a 9999
     */
    @Test
    public void testValidateNumberDefense_Prueba2() {
        System.out.println("validateNumberDefense_Prueba2");
        String number = "10000";
        Validations instance = new Validations();
        boolean expResult = false;
        boolean result = instance.validateNumberDefense(number);
        assertEquals(expResult, result);
    }    

    /**
     * Test of validateNumberDefense method, of class Validations.
     * Menor a 0 (valor negativo)
     */
    @Test
    public void testValidateNumberDefense_Prueba3() {
        System.out.println("validateNumberDefense_Prueba3");
        String number = "-1";
        Validations instance = new Validations();
        boolean expResult = false;
        boolean result = instance.validateNumberDefense(number);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of validateNumberDefense method, of class Validations.
     * Igual a 9999
     */
    @Test
    public void testValidateNumberDefense_Prueba4() {
        System.out.println("validateNumberDefense_Prueba4");
        String number = "9999";
        Validations instance = new Validations();
        boolean expResult = true;
        boolean result = instance.validateNumberDefense(number);
        assertEquals(expResult, result);
    }      

    /**
     * Test of validateNumberDefense method, of class Validations.
     * Igual a 0
     */
    @Test
    public void testValidateNumberDefense_Prueba5() {
        System.out.println("validateNumberDefense_Prueba5");
        String number = "0";
        Validations instance = new Validations();
        boolean expResult = true;
        boolean result = instance.validateNumberDefense(number);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of validateNumberDefense method, of class Validations.
     * String
     */
    @Test
    public void testValidateNumberDefense_Prueba6() {
        System.out.println("validateNumberDefense_Prueba6");
        String number = "CocaXD";
        Validations instance = new Validations();
        boolean expResult = false;
        boolean result = instance.validateNumberDefense(number);
        assertEquals(expResult, result);
    }  
    
    /**
     * Test of validateDescription method, of class Validations.
     * Entre 1 y 280 caracteres
     */
    @Test
    public void testValidateDescription_Prueba1() {
        System.out.println("validateDescription_Prueba1");
        String text = "Esta carta detiene cualquier ataque de una carta tipo LUZ. "
                + "En realidad también quería probar las limitaciones en la cantidad de "
                + "caracteres para intentar hacer mierda el programa muahaahahha aksjldja "
                + "aksldjaklsd laksjdklj klfsjdflksd aklsdjlka 1\"##$%/( alskdlajskd "
                + "kksdmlcm aklsdm"; //279 caracteres
        Validations instance = new Validations();
        boolean expResult = true;
        boolean result = instance.validateDescription(text);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateDescription method, of class Validations.
     * Mayor a 280 caracteres
     */
    @Test
    public void testValidateDescription_Prueba2() {
        System.out.println("validateDescription_Prueba2");
        String text = "Esta carta detiene cualquier ataque de una carta tipo LUZ. "
                + "En realidad también quería probar las limitaciones en la cantidad "
                + "de caracteres para intentar hacer mierda el programa muahaahahha "
                + "aksjldja aksldjaklsd laksjdklj klfsjdflksd aklsdjlka 1\"##$%/( "
                + "alskdlajskd kksdmlcm aklsdm O"; //281 caracteres
        System.out.println(text);
        Validations instance = new Validations();
        boolean expResult = false;
        boolean result = instance.validateDescription(text);
        assertEquals(expResult, result);
    }    

    /**
     * Test of validateDescription method, of class Validations.
     * Igual a 280 caracteres
     */
    @Test
    public void testValidateDescription_Prueba3() {
        System.out.println("validateDescription");
        String text = "Esta carta detiene cualquier ataque de una carta tipo LUZ. "
                + "En realidad también quería probar las limitaciones en la cantidad "
                + "de caracteres para intentar hacer mierda el programa muahaahahha "
                + "aksjldja aksldjaklsd laksjdklj klfsjdflksd aklsdjlka 1\"##$%/( "
                + "alskdlajskd kksdmlcm aklsdmk"; //280 caracteres
        Validations instance = new Validations();
        boolean expResult = true;
        boolean result = instance.validateDescription(text);
        assertEquals(expResult, result);
    }    

    /**
     * Test of validateDescription method, of class Validations.
     * Igual a 0 caracteres
     */
    @Test
    public void testValidateDescription_Prueba4() {
        System.out.println("validateDescription_Prueba4");
        String text = ""; //0 caracteres
        Validations instance = new Validations();
        boolean expResult = false;
        boolean result = instance.validateDescription(text);
        assertEquals(expResult, result);
    }    
    
}
