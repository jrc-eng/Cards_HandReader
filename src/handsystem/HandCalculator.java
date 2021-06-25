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
    
    
    public static HandEnum calculateHandValue(ArrayList<Card> c)
    {
        //Assume that all hands from now on are sorted beforehand, which makes our job easier.
        ArrayList<Card> sortedHand = sortCardArray(new ArrayList<Card>(c));
        
        for (int x = 0 ; x < sortedHand.size() ; x++)
        {
            System.out.println(sortedHand.get(x));
        }
        
        HandEnum val = HandEnum.HIGH;
        
        if(isFive(c))
        {
            return HandEnum.FIVE;
        }
        
        if(isStraightFlush(c))
        {
            return HandEnum.STRAIGHT_FLUSH;
        }
        
        if(isFlush(c))
        {
            return HandEnum.FLUSH;
        }
        
        if(isStraight(c))
        {
            return HandEnum.STRAIGHT;
        }
        
        if(isThree(c))
        {
            return HandEnum.THREE;
        }
        
        if(isPair(c))
        {
            return HandEnum.PAIR;
        }
        
        return val;
    }
    
    static ArrayList<Card> sortCardArray(ArrayList<Card> c)
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
    static boolean isStraight(ArrayList<Card> c)
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
    static boolean isFlush(ArrayList<Card> c)
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
    
    static boolean isStraightFlush(ArrayList<Card> c)
    {
        return(isFlush(c) && isStraight(c));
    }
    
    
    static boolean isFive(ArrayList<Card> c)
    {
        int firstRank = c.get(0).getRank();
        
        for(int x = 1 ; x < Hand.HAND_LENGTH ; x++)
        {
            if(c.get(x).getRank() != firstRank)
            {
                return false;
            }
        }
        
        return true;
        
    }

    static boolean isPair(ArrayList<Card> c)
    {
        for (int x = 0 ; x < Hand.HAND_LENGTH-1 ; x++)
        {
            if(x < Hand.HAND_LENGTH - 2)
            {
                if(c.get(x).getRank() == c.get(x+1).getRank() && c.get(x+1).getRank() != c.get(x+2).getRank())
                {
                    return true;
                }
            }
            else
            {
                if(c.get(x).getRank() == c.get(x+1).getRank())
                {
                    return true;
                }
            }
        }
          
        return false;
    }
    
    static boolean isThree(ArrayList<Card> c)
    {
        for (int x = 0 ; x < Hand.HAND_LENGTH-2 ; x++)
        {
            if(x < Hand.HAND_LENGTH - 3)
            {
                if(c.get(x).getRank() == c.get(x+1).getRank() && c.get(x+1).getRank() == c.get(x+2).getRank() && c.get(x+2).getRank() != c.get(x+3).getRank())
                {
                    return true;
                }
            }
            else
            {
                if(c.get(x).getRank() == c.get(x+1).getRank() && c.get(x).getRank() == c.get(x+2).getRank())
                {
                    return true;
                }
            }
        }
          
        return false; 
           
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