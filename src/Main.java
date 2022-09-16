public class Main {
    public static void main(String[] args) {

       /* Die myDie = new Die(6);

        for(int i = 0; i < 20; i++) {
            myDie.roll();
            System.out.println(myDie.getCurrentValue());
        }*/

        Player playerOne = new Player("Tobbe");
        playerOne.addDie(6);
        playerOne.addDie(6);
        //playerOne.addDie(6);
        playerOne.increaseScore();

        System.out.println(playerOne.getScore());
        System.out.println(playerOne.getName());

        for(int i = 0; i < 10; i++) {
            playerOne.rollDice();
            System.out.println(playerOne.getDiceValue());
        }
    }
}