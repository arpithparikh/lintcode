c enum Suit{};
public class Deck<T extends Card>{
    ArrayList<T> cards;
}
public abstract class Card{
    protected boolean available = true;
    protected int faceValue;
    protected Suit suit;
    public Card(int c, Suit s){
        faceValue = c;
        suit = s;
    }
    public abstract int value();
    public Suit suit(){return suit};
    public boolean isAvailable(){return available;}
}

public class Hand <T extends Card>{
    protected ArrayList<T> cards = new ArrayList<T>();
    public int score(){
        int score = 0;
        for(T card: cards){
            score += cards.get(i).value();
        }
        return score;
    }
    public void addCard(T card){
        cards.add(card);
    }
}

public class BlackJackHand extends Hand<BlackJackCard>{
    
}
public class BlackJackCard extends Card{
}
