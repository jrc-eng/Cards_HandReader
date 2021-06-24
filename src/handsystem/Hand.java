/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handsystem;

import card52.Card;
import card52.Suit;
import java.util.ArrayList;

/**
 *
 * @author jrcro
 */
public class Hand {
    
    public static final int HAND_LENGTH = 5;
    
    ArrayList<Card> cardHand;
    
    double handValue = 0.0f;
    
    public Hand()
    {
        cardHand = new ArrayList<Card>();
        
        for (int x = 0 ; x < HAND_LENGTH ; x++)
        {
            cardHand.add(new Card(x+2,Suit.SPADE));
        }
    }
    
    public void setCardHand(ArrayList<Card> ch)
    {
        cardHand = ch;
    }
    
    public ArrayList<Card> getCardHand()
    {
        return cardHand;
    }
    
    public void setCardAtPos(Card c, int pos)
    {
        if(pos < 0 || pos > HAND_LENGTH)
        {
            return;
        }
        
        cardHand.set(pos, c);
    }
    
    public Card getCardAtPos(int pos)
    {
        if(pos < 0 || pos > HAND_LENGTH)
        {
            return null;
        }
        
        return cardHand.get(pos);
    }
}
