package u6pp;
import java.util.Arrays;
import java.util.Scanner;

public class Blackjack 
{

    private Deck ohnepixel;
    private String name;
    private Card[] dealer;
    private Card[] player;

    //Created a new deck to be modified later named Ohnepixel, in honor of CS:GO streamer Ohnepixel.

    public Blackjack()
    {
        ohnepixel = new Deck();
        dealer = new Card[2];
        player = new Card[2];
    }

    //Both the player and dealer are given hands of two cards each, which will be defined later.

    public void play()
    {
        String banana = "";

        for (int i = 0; i < 2; i++)
        {
            dealer[i] = ohnepixel.deal();
            player[i] = ohnepixel.deal();
        }

        //This little loop gives values to the two card hands given earlier to Fabiano Caruana and the player.
        //Fabiano Caruana is named after the chess player.

        Scanner sc = new Scanner(System.in);
        System.out.print("Welcome to Blackjack! What is your name?");
        name = sc.nextLine();
        name = "Chief";
        System.out.println("I don't care. From now on, I will call you Chief, as a sign of great respect for your people.");

        //Hacksaw Ridge.
        //The scanner lets you choose a name but it doesn't matter.

        System.out.println("Do you want gamba??? Gamba money?? All in on red Chief. GG");
        System.out.println("Free NBA Youngboy RAAAAAH. Your cards: " + Arrays.toString(player));
        System.out.println("Dealer got a low taper fade. My cards: " + Arrays.toString(dealer));

        //The arrays are turned into strings that are attached to the NPC text.

        whiteToMove();
        blackToMove();

        banana = determineResult(player, dealer);

        System.out.println(banana);

        sc.close();
    }

    private void whiteToMove()
    {
        Scanner sc = new Scanner(System.in);

        while (!isBust(player)) 
        {

            System.out.println("Hello Chief. My name is Fabiano Caruana, your dealer. I grew up in Bangladesh but moved to the US to study computer science. However, the job market is terrible so I am now an unpaid intern at a Silicon Valley startup and only being paid with equity. Hit or stand?");
            String hitorstand = sc.nextLine().toLowerCase();

            //The real Fabiano Caruana is not from Bangladesh. He is from France.
            //Saved the player's text intput into lowercase, and in a new variable.

            if (hitorstand.equals("hit"))
            {
                player = Arrays.copyOf(player, player.length + 1);
                player[player.length - 1] = ohnepixel.deal();
                System.out.println("Blawg is a gambler :skull: :skull: :joy:. This yo card lil bro: " + Arrays.toString(player));
            }

            //Because arrays can't have contents deleted or added (and therefore the length of the list modified),
            //we use the Arrays. tool to create a new copy of the old player hand array but with an extra undefined card. It is defined
            //in the next line with ohnepixel.deal.

            else if (hitorstand.equals("stand"))
            {
                break;
            }
            else
            {
                System.out.println("What did blud just type in :skull: :laugh_cry: what is bro doing. I said hit or stand Chief.");
            }

            //Does nothing if stand, makes fun of you if you mispell something.

        }

        sc.close();
    }

    private void blackToMove()
    {
        while (dealerKeepHitting(dealer))
        {
            dealer = Arrays.copyOf(dealer, dealer.length + 1);
            dealer[dealer.length - 1] = ohnepixel.deal();
            System.out.println("Mrrrp mrrp meow. Mrowoworwrr. Purrrr: " + Arrays.toString(dealer));

            //Creates a bigger dealer hand and adds the new card. 

        }
    }

    public static int calcPoints(Card[] hand)
    {
        int points = 0;

        for (Card card : hand)
        {
           String value = card.getValue(); 
           if (value.equals("Ace"))
           {
            points += 11;
           }
           else if (value.equals("King") || value.equals("Queen") || value.equals("Jack"))
           {
            points += 10;
           }
           else if (value.equals("2"))
           {
            points += 2;
           }
           else if (value.equals("3"))
           {
            points += 3;
           }
           else if (value.equals("4"))
           {
            points += 4;
           }
           else if (value.equals("5"))
           {
            points += 5;
           }
           else if (value.equals("6"))
           {
            points += 6;
           }
           else if (value.equals("7"))
           {
            points += 7;
           }
           else if (value.equals("8"))
           {
            points += 8;
           }
           else if (value.equals("9"))
           {
            points += 9;
           }
           else if (value.equals("10"))
           {
            points += 10;
           }
           else {
            points += Integer.parseInt(value);
           }

           //I Tried to make a for loop here that made it look way cleaner than this, but there was some trouble with the Ace card specifically
           //and how it's read by the code when parsing and whatnot. Trust me, I tried.

        }
        return points;
    }

    public static String determineResult(Card[] playerhand, Card[] dealerhand)
    {
        int yourpoints = calcPoints(playerhand);
        int mypoints = calcPoints(dealerhand);

        if (isBust(playerhand))
        {
            return "nt lil bro. you buste";
        }
        else if (isBust(dealerhand))
        {
            return "bro thinks hes good :joy_cat: the mouse always wins lil bro. play me again ong";
        }
        else if (isBlackjack(playerhand) && isBlackjack(dealerhand))
        {
            return "bro thought he won lolololol. we tied and we pushin";
        }
        else if (isBlackjack(playerhand))
        {
            return "alright chief you win this one fr. no cap you put more money in and play me again";
        }
        else if (isBlackjack(dealerhand))
        {
            return "nt lil bro i win this game so free. you're a straight middington blackjack player ggez.";
        }
        else if (yourpoints > mypoints)
        {
            return "? you win ig";
        }
        else if (mypoints > yourpoints)
        {
            return "nt lil bro this bag is free";
        }
        else
        {
            return "my name is fabiano caruana and we have tied the game. bien joue mi ami.";
        }

        //Do I lose points for the custom NPC text?

    }

    public static boolean isBust(Card[] hand)
    {
        if (calcPoints(hand) > 21)
        {
            return true;
        }
        else
        {
            return false;
        }

        //Idea being that if you have more than 21 you lost.

    }

    public static boolean isBlackjack(Card[] hand)
    {
        return hand.length == 2 && calcPoints(hand) == 21;

        //The hand must be two cards, and instantly 21 to count.

    }

    public static boolean dealerKeepHitting(Card[] hand)
    {
        return calcPoints(hand) < 17;

        //Less than 17 points total means the dealer goes sicko mode and keeps hitting.

    }
}