import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    final private static Scanner sc = new Scanner(System.in); // the Scanner is used for player input
    public static void main(String[] args) {

        ArrayList<Player> playerList = initialize(); // the players are initialized and saved in an ArrayList

        takeTurns(playerList); // the game is executed here
        winningMessage(getWinners(playerList)); // the winners are decided, and a concluding message is displayed
    }

    public static ArrayList<Player> initialize() {
        /* Takes user input and creates players, which are stored in ArrayList players.
        This is then returned.
         */
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

        // This loop creates the Player instances, and adds dice with the correct number of sides
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
    private static void takeTurns(ArrayList<Player> playerList) {
        // this is a pretty straight-forward game loop. Asks for guesses, rolls dice and updates scores.
        int guess;
        for(int i = 0; i < 5; i++) {
            for(Player player: playerList) {
                System.out.println("Guess no: " + (i + 1) + ", " + player.getName());
                guess = sc.nextInt();
                sc.nextLine();
                player.rollDice();
                System.out.println("The dice rattle, roll  and settle on... ..." + player.getDiceValue());
                if(guess == player.getDiceValue()) {
                    player.increaseScore();
                    System.out.println("Correctomundo, " + player.getName() +"!\n" +
                            "You scored!\n" + "Current score: " + player.getScore());
                } else {
                    System.out.println("Close, but no cigar!");
                }
                System.out.println("-----------------------------");
            }
        }
    }

    private static ArrayList<Player> getWinners (ArrayList<Player> players) {
        /* Here we decide who is the winner(s).
        First, we loop through all players to get the highest score.
        Then, we loop through all players again to add those with a winning score
        to ArrayList winners. Returns ArrayList<Player> winners.
         */
        ArrayList<Player> winners = new ArrayList<>();
        int highestScore = 0;
        for(Player player: players) {
            if(player.getScore() > highestScore) {
                highestScore = player.getScore();
            }
        }
        if(highestScore > 0) {
            for(Player player: players) {
                if (player.getScore() == highestScore) {
                    winners.add(player);
                }
            }
        }
        return winners;
    }

    private static void winningMessage(ArrayList<Player> winners) {
        // this method prints the final message to the players, telling them who the winner is.
        if(winners.size() == 0) {
            System.out.println("Sorry! There are no winners. You all suck!");
        } else if (winners.size() == 1) {
            System.out.println("And the winner is: " + winners.get(0).getName() +
                    ", with a score of " + winners.get(0).getScore() + "!");

        } else {
            System.out.print("And the winners are: ");
            String winnerString = "";
            for (Player player : winners) {
                winnerString += (player.getName());
                winnerString += " & ";
            }
            System.out.print(winnerString.substring(0, (winnerString.length()-2)));
            System.out.println(", with a score of " + winners.get(0).getScore() + "!");
        }
    }
}