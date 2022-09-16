import java.util.ArrayList;
import java.util.Scanner;



public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       /* Die myDie = new Die(6);

        for(int i = 0; i < 20; i++) {
            myDie.roll();
            System.out.println(myDie.getCurrentValue());
        }*/

        /*Player playerOne = new Player("Tobbe");
        System.out.println(playerOne);
        playerOne.addDie(6);
        playerOne.addDie(6);
        System.out.println(playerOne);
        //playerOne.addDie(6);
        playerOne.increaseScore();
        System.out.println(playerOne);

        System.out.println(playerOne.getScore());
        System.out.println(playerOne.getName());

        for(int i = 0; i < 10; i++) {
            playerOne.rollDice();
            System.out.println(playerOne.getDiceValue());
        }*/
        ArrayList<Player> playerList = initialize(sc);
        System.out.println(playerList);
        takeTurns(playerList, sc);


        ArrayList<Player> winners = new ArrayList<>();
        winners = getWinners(playerList);
        if (winners.size() == 1) {
            System.out.println("And the winner is: " + winners.get(0).getName());

        } else if (winners.size() > 1) {
            System.out.print("And the winners are: ");
            String winnerString = "";
            for (Player player : winners) {
                winnerString += (player.getName());
                winnerString += " & ";
            }
            System.out.println(winnerString.substring(0, (winnerString.length()-2)));
        }
    }
    public static ArrayList<Player> initialize(Scanner sc) {
        ArrayList<Player> players = new ArrayList<>();
        int noOfPlayers;
        int noOfDice;
        int noOfSides;
        String name;

        System.out.println("How many players?");
        noOfPlayers = sc.nextInt();
        sc.nextLine();

        System.out.println("How many dice will be used?");
        noOfDice = sc.nextInt();
        sc.nextLine();

        System.out.println("How many sides should the dice have?");
        noOfSides = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < noOfPlayers; i++) {
            System.out.println("Enter the name of player " + (i+1));
            name = sc.nextLine();

            players.add(new Player(name));
            for(int dice = 0; dice < noOfDice; dice++) {
                players.get(i).addDie(noOfSides);
            }
        }

        return players;
    }
    private static void takeTurns(ArrayList<Player> playerList, Scanner sc) {
        int guess;
        for(int i = 0; i < 5; i++) {
            for(Player player: playerList) {
                System.out.println("Make a guess, " + player.getName());
                guess = sc.nextInt();
                sc.nextLine();
                player.rollDice();
                System.out.println("The dice rattle and settle on... ..." + player.getDiceValue());
                if(guess == player.getDiceValue()) {
                    player.increaseScore();
                    System.out.println("Correctomundo, " + player.getName() +"!\n" +
                            "You scored!\n" + "Current score: " + player.getScore());
                } else {
                    System.out.println("Close, but no cigar!");
                }
            }
        }
    }

    private static ArrayList<Player> getWinners (ArrayList<Player> players) {
        ArrayList<Player> winners = new ArrayList<>();
        int highestScore = 0;
        for(Player player: players) {
            if(player.getScore() > highestScore) {
                highestScore = player.getScore();
            }
        }
        if(highestScore == 0) {
            System.out.println("Sorry! There are no winner! You all suck!");
        } else {
        for(Player player: players) {
            if (player.getScore() == highestScore) {
                winners.add(player);
                }
            }
        }
        return winners;
    }
}