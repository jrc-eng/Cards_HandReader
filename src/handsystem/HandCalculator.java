/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handsystem;

import card52.Card;
import card52.Suit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author jrcro
 */
public class HandCalculator {
    public final double HIGH_VALUE = 0f;
    public final double PAIR_VALUE = 1f;
    public final double TWO_PAIR_VALUE = 2f;
    public final double THREE_VALUE = 3f;
    public final double STRAIGHT_VALUE = 4f;
    public final double FLUSH_VALUE = 5f;
    public final double FULLHOUSE_VALUE = 6f;
    public final double FOUR_VALUE = 7f;
    public final double STRAIGHTFLUSH_VALUE = 8f;
    
    public double calculateHandValue(ArrayList<Card> c)
    {
        //Assume that all hands from now on are sorted beforehand, which makes our job easier.
        ArrayList<Card> sortedHand = sortCardArray(c);
        
        double val = 0;
        
        return val;
    }
    
    ArrayList<Card> sortCardArray(ArrayList<Card> c)
    {
        
        
        Collections.sort(c, new CardComparator());
        
        return c;
    }
    
    /**
     * isStraight
     * 
     * Check if the Hand is a Straight by making sure all rank values are in order.
     * 
     * DISCLAIMER:  The ArrayList should be sorted in ORDER for this to work.
     * 
     * @param c
     * @return 
     */
    boolean isStraight(ArrayList<Card> c)
    {
        for(int x = 0 ; x < c.size()-1 ; x++)
        {
           if(c.get(x).getRank() != c.get(x).getRank() - 1)
           {
               return false;
           }
        }
        
        return true;
    }
    
    /**
     * isFlush
     * 
     * 
     * returns TRUE if all values equal the same suit.
     * 
     * @param c
     * @return 
     */
    boolean isFlush(ArrayList<Card> c)
    {
        Suit currentSuit = c.get(0).getSuit();
        
        for(int x = 1 ; x < Hand.HAND_LENGTH ; x++)
        {
            if(c.get(x).getSuit() != currentSuit)
            {
                return false;
            }
        }
        
        return true;
    }
    
    boolean isStraightFlush(ArrayList<Card> c)
    {
        return(isFlush(c) && isStraight(c));
    }
    
    
}


class CardComparator implements Comparator<Card> {
  
    @Override
    public int compare(Card c1, Card c2)
    {
        if (c1.getRank() == c2.getRank())
            return 0;
        else if (c1.getRank() > c2.getRank())
            return 1;
        else
            return -1;
    }
}