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
 * HandCalculator
 * 
 * Calculates the value of Hands.
 * 
 * Use the Method: calculateHandValue to get the value of a Hand.
 * Results may vary when using a card hand of less than 5 cards.
 * 
 *
 * @author jrc-eng
 */
public class HandCalculator {
    
    /**
     * calculateHandValue
     * 
     * Given an ArrayList of Cards, c, returns a HandEnum value for the value of the hand.
     * Does NOT perform tiebreaker functions such as Kicker values.
     * 
     * 
     * @param c
     * @return 
     */
    public static HandEnum calculateHandValue(ArrayList<Card> c)
    {
        //Assume that all hands from now on are sorted beforehand, which makes our job easier.
        ArrayList<Card> sortedHand = sortCardArray(new ArrayList<Card>(c));
        
        for (int x = 0 ; x < sortedHand.size() ; x++)
        {
            System.out.println(sortedHand.get(x));
        }
        
        HandEnum val = HandEnum.HIGH;
        
        if(isFive(sortedHand))
        {
            return HandEnum.FIVE;
        }
        
        if(isStraightFlush(sortedHand))
        {
            return HandEnum.STRAIGHT_FLUSH;
        }
        
        if(isFour(sortedHand))
        {
            return HandEnum.FOUR;
        }
        
        if(isFullHouse(sortedHand))
        {
            return HandEnum.FULL_HOUSE;
        }
        
        if(isFlush(sortedHand))
        {
            return HandEnum.FLUSH;
        }
        
        if(isStraight(sortedHand))
        {
            return HandEnum.STRAIGHT;
        }
        
        if(isThree(sortedHand))
        {
            return HandEnum.THREE;
        }
        
        if(isTwoPair(sortedHand))
        {
            return HandEnum.TWO_PAIR;
        }
        
        if(isPair(sortedHand))
        {
            return HandEnum.PAIR;
        }
        
        return val;
    }
    
    /**
     * sortCardArray
     * 
     * Sorts an ArrayList of Cards and returns the arraylist back.
     * 
     * 
     * @param c
     * @return 
     */
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
     * For example, A-2-3-4-5 is a Straight.  The Suits can be anything.
     * 
     * DISCLAIMER:  The ArrayList should be sorted in ORDER for this to work.
     * 
     * @param c
     * @return 
     */
    static boolean isStraight(ArrayList<Card> c)
    {
        if(c.size() < 5)
        {
            return false;
        }
        for(int x = 0 ; x < c.size()-1 ; x++)
        {
            int rank1 = c.get(x).getRank();
            int rank2 = c.get(x+1).getRank();
            
           if(rank1 != rank2 - 1)
           {
               return false;
           }
        }
        
        return true;
    }
    
    /**
     * isFlush
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
    
    /**
     * isStraightFlush
     * 
     * Checks if an ArrayList of Cards is both a Flush and a Straight
     * 
     * 
     * @param c
     * @return 
     */
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
    
    static boolean isTwoPair(ArrayList<Card> c)
    {
        int pairsComplete = 0;
        int firstPairRank = 0;
        
        for (int x = 0 ; x < Hand.HAND_LENGTH-1 ; x++)
        {
            //Check if we have a winner.
            if(x < Hand.HAND_LENGTH - 2)
            {
                if(c.get(x).getRank() == c.get(x+1).getRank() && c.get(x+1).getRank() != c.get(x+2).getRank() && firstPairRank != c.get(x).getRank())
                {
                    pairsComplete++;
                    firstPairRank = c.get(x).getRank();
                }
            }
            else
            {
                if(c.get(x).getRank() == c.get(x+1).getRank() && c.get(x).getRank() != firstPairRank)
                {
                    pairsComplete++;
                    firstPairRank = c.get(x).getRank();
                }
            }
            
            if(pairsComplete == 2)
            {
                return true;
            }
            
            
        }
          
        return false;
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
        if(c.size() < 3)
        {
            return false;
        }
        
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
    
    /**
     * isFullHouse
     * 
     * Checks if the hand is a full house.
     * 
     * Full House:
     * Contains a Three of a Kind and a Pair, they do not share ranks with each other.
     * 
     * 
     * @param c
     * @return 
     */
    static boolean isFullHouse(ArrayList<Card> c)
    {
        //Awkward way.  If it's not five, we'll just not check at all.
        if(c.size() != 5)
        {
            return false;
        }
        
        boolean tripFound = false, pairFound = false;
        int firstRank = 0;
        
        //Check for triplet cards.
        for (int x = 0 ; x < c.size()-2 && tripFound == false ; x++)
        {
            Card card1 = c.get(x);
            Card card2 = c.get(x+1);
            Card card3 = c.get(x+2);
            if(card1.getRank() == card2.getRank() && card1.getRank() == card3.getRank())
            {
                tripFound = true;
                firstRank = card1.getRank();
                break;
            }
        }
        if(tripFound == false)
        {
            return false;
        }
        
        for (int x = 0 ; x < c.size()-1 ; x++)
        {
            Card card1 = c.get(x);
            Card card2 = c.get(x+1);
            
            //We found a pair after finding triplets.  Mission success.  Full House identified.
            if(card1.getRank() != firstRank && card1.getRank() == card2.getRank())
            {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * isFour
     * 
     * Returns true if at least four cards are of the same rank.
     * 
     * Returns false otherwise, or if the parameter c is not four cards long.
     * 
     * @param c
     * @return 
     */
    static boolean isFour(ArrayList<Card> c)
    {
        if(c.size() < 4)
        {
            return false;
        }
        
        for(int x = 0 ; x < c.size() - 3 ; x++)
        {
            if(c.get(x).getRank() == c.get(x+1).getRank() && c.get(x+1).getRank() == c.get(x+2).getRank() && c.get(x+2).getRank() == c.get(x+3).getRank())
            {
                return true;
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