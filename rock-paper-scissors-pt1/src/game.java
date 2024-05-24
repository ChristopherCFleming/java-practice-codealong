import java.util.Scanner;

public class game {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String userChoice = "";
        boolean exit = false;

        do {
            boolean validChoice = false;

            do {
                System.out.println("Choose rock paper or scissors");
                userChoice = console.nextLine();

                if (userChoice.equalsIgnoreCase("rock") || userChoice.equalsIgnoreCase("scissors") || userChoice.equalsIgnoreCase("paper")) {
                    validChoice = true;
                } else {
                    System.out.println("Error! Please type either rock paper or scissors.");
                }
            } while (!validChoice);


            int random = (int) Math.floor(Math.random() * 3); //this will give us a random number between 0, 1, or 2.
            String computerChoice = null;

            switch (random) {
                case 0:
                    computerChoice = "rock";
                    break;
                case 1:
                    computerChoice = "paper";
                    break;
                case 2:
                    computerChoice = "scissors";
                    break;
                default:
                    computerChoice = null;
            }

            String graphic = "L O A D I N G";
            for (int i = 0; i < graphic.length(); i++) {
                System.out.println(graphic.charAt(i));
            }

            if (computerChoice.equalsIgnoreCase(userChoice)) {
                System.out.printf("This is a tie! You both picked %s %n", userChoice);
            } else if (computerChoice.equalsIgnoreCase("rock") && userChoice.equalsIgnoreCase("paper")) {
                System.out.printf("Congrats! You won! The computer picked %s, and you picked %s%n", computerChoice, userChoice);
            } else if (computerChoice.equalsIgnoreCase("scissors") && userChoice.equalsIgnoreCase("rock")) {
                System.out.printf("Congrats! You won. The computer picked %s and you picked %s.%n", computerChoice, userChoice);
            } else if (computerChoice.equalsIgnoreCase("paper") && userChoice.equalsIgnoreCase("rock")) {
                System.out.printf("You lost. The computer picked %s, and you picked %s%n", computerChoice, userChoice);
            } else if (computerChoice.equalsIgnoreCase("rock") && userChoice.equalsIgnoreCase("scissors")) {
                System.out.printf("You lost. The computer picked %s and you picked %s.%n", computerChoice, userChoice);
            }

            //give the user a way to exit the game.

            System.out.println("Would you like to play again? y/n");
            String playAgain = console.nextLine();

            if (playAgain.equalsIgnoreCase("n")) {
                exit = true;
                System.out.println("Thank you for playing! See you next time.");
            }
        } while (!exit);

    }  //this closes the main method
} //this closes the class

/* Pseudo Code:

1) Take input from user
2) Randomly generate a computer choice
3) Compare the choices and determine winner
 */