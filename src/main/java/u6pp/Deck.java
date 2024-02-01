package u6pp;

public class Deck {
    
    private Card[] cards = new Card[52];
    private int mainindex = 0;

    public void reset()
    {
        mainindex = 0;

        //Keeps track of the index globalls for things such as shuffling

    }

    public Deck()
    {
        int subindex = 0;

        for (String suit : Card.SUITS) 
        {
            for (String values : Card.VALUES) 
            {
                cards[subindex++] = new Card(suit, values);
            }
        }

        //This piece of code cycles four times for the four suits and assigns all the possible values before ending the loop.
        //This means that for every one of the four loops, the 12 card values are assigned before repeating again.
        //Subindex is also increased by one in the middle of the loop so that each iteration of the loop means the next set of suits and values.
        //Got help with this one, and it's actually pretty clever

    }

    public int numLeft()
    {
        return cards.length - mainindex;

        //The size of the deck, minus the index.

    }

    public Card deal()
    {
        return cards[mainindex++];

        //The "top" card is at index 0 first, then goes down the deck with index 1, 2, etc.

    }

    public void shuffle()
    {
        for (int i = cards.length - 1; i > 0; i--)
        {
            int randomizer = (int) (Math.random()*(i + 1));
            Card blank = cards[i];
            cards[i] = cards[randomizer];
            cards[randomizer] = blank;
        }

        //Classic swapping code used here. C is a placeholder, C = A, A = B, B = C. The randomizer defines the max value is i+1, or the
        //loop iteration plus one.

        reset();
    }

    public Card[] getDeck()
    {
        return cards;
    }

}