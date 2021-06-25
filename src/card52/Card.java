package card52;

/**
 * Card
 * 
 * Class for Cards in a Deck.
 * 
 * Contains Rank and Suit as attributes.
 * 
 * Comes with toString.
 * 
 * 
 * @author jrcro
 */
public class Card implements Comparable<Card> {
    
    private int rank;
    private Suit suit;
    
    public final int MAX_RANK = 14;
    
    public Card(int r, Suit s)
    {
        rank = r;
        suit = s;
    }
    
    
    /*
        Getters and Setters for Rank
    */
    public void setRank(int r)
    {
        rank = r;
    }
    
    public int getRank()
    {
        return rank;
    }
    
    /*
        Getters and Setters for Suit
    */
    public void setSuit(Suit s)
    {
        suit = s;
    }
    
    public Suit getSuit()
    {
        return suit;
    }
    
    //toString method
    public String toString()
    {
        return getRankName() + " of " + getSuitName();
        
    }
    
    public String getRankName()
    {
        switch(rank)
        {
            //The Ace
            case 14:
                return "Ace";
            
            case 13:
                return "King";
            case 12:
                return "Queen";
            case 11:
                return "Jack";
            case 10:
                return "Ten";
            case 9:
                return "Nine";             
            case 8:
                return "Eight";             
            case 7:
                return "Seven";             
            case 6:
                return "Six";             
            case 5:
                return "Five";            
            case 4:
                return "Four";             
            case 3:
                return "Three";             
            case 2:
                return "Two";  
            //This should never have to be called.
            default:
                return "One";                
                
             
        }
    }
    
    public String getSuitName()
    {
        switch(suit){
            case SPADE:
                return "Spades";
            case CLUB:
                return "Clubs";
            case HEART:
                return "Hearts";
            case DIAMOND:
                return "Diamonds";
            //If this happens, we have a problem.
            default:
                return "Unknowns";
        }
    }
    
    @Override
    public int compareTo(Card o) {
        
        if(this.rank == o.getRank())
        {
            return 0;
        }
        else if(this.rank > o.getRank())
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }
}
