/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageGetter;

import card52.Card;
import card52.Suit;

import java.io.File;
import javafx.scene.image.Image;

/**
 *
 * @author jrcro
 */
public class CardImageGetter {
    
    
    public static Image getImageFromCard(Card c)
    {
        
        
        String cardString = "img\\" + getStringFromCard(c);
        
        File fs = new File(cardString);
        if(!fs.exists())
        {
            return null;
        }
        
        try{
            //Issue with getting Images from the Cards.  Have to instead use fs like so.
            //https://stackoverflow.com/questions/40962739/java-lang-illegalargumentexception-invalid-url-or-resource-not-found-javafx-im
            Image imageFile = new Image(fs.toURI().toURL().toString());
            return imageFile;
        }
        catch(Exception e)
        {
            System.out.println(e);
            
            return null;
        }
        
        
        
    }
    
    static String getStringFromCard(Card c)
    {
        int rank = c.getRank();
        
        Suit suit = c.getSuit();
        
        String s;
        
        switch(suit)
        {
            case HEART:
                s = "H";
                break;
            case DIAMOND:
                s = "D";
                break;
            case CLUB:
                s = "C";
                break;
            case SPADE:
                s = "S";
                break;
            default:
                return "Cardback.png";
                
        }
        
        s += "_";
        
        switch(rank)
        {
            case 14:
                s += "A";
                break;
            case 13:
                s += "K";
                break;
            case 12:
                s += "Q";
                break;
            case 11:
                s += "J";
                break;
            case 10:
                s += "10";
                break;
            case 9:
                s += "9";
                break;
            case 8:
                s += "8";
                break;
            case 7:
                s += "7";
                break;
            case 6:
                s += "6";
                break;
            case 5:
                s += "5";
                break;
            case 4:
                s += "4";
                break;
            case 3:
                s += "3";
                break;
            case 2:
                s += "2";
                break;
            default:
                return "Cardback.png";
        }
        
        
        return s  + ".png";
    }
    
    
    public static File getFileFromCard(Card c)
    {
        File fs = null;
        
        String s = "img\\" + getStringFromCard(c);
        System.out.println(s);
        fs = new File(s);
        
        
        return fs;
    }
    
}
