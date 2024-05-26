import java.util.Scanner;

public class game {
    static Scanner console = new Scanner(System.in); //changed to static so all methods can access it.

    public static void main(String[] args) {
        boolean exit = false;
        do {
            int userMove = getUserChoice();
            int computerMove = computerChoice();
            String userChoice = generateMove(userMove);
            String computerChoice = generateMove(computerMove);
            determineWinner(userChoice, computerChoice);
            exit = playAgain();
        } while (!exit);

    }  //this closes the main method


    public static int getUserChoice() {
        boolean validChoice = false;
        int userChoice;
        do {
            System.out.println("Choose rock paper or scissors");
            System.out.println("0 for rock");
            System.out.println("1 for paper");
            System.out.println("2 for scissors");

            userChoice = Integer.parseInt(console.nextLine());

            if (userChoice == 0 || userChoice == 1 || userChoice == 2) {
                validChoice = true;
            } else {
                System.out.println("Error! Please type either rock paper or scissors.");
            }
        } while (!validChoice);

        return userChoice;
    }// This closes getUserChoice method

    public static int computerChoice() {
        int random = (int) Math.floor(Math.random() * 3); //this will give us a random number between 0, 1, or 2.
        return random;
    }//this closes getComputerChoice Method

    public static String generateMove(int playerChoice) {
        String move = null;
        switch (playerChoice) {
            case 0:
                move = "rock";
                break;
            case 1:
                move = "paper";
                break;
            case 2:
                move = "scissors";
                break;
            default:
                move = null;
        }
        return move;
    } //closes generateMove method

    public static void determineWinner(String userOneChoice, String userTwoChoice) {
        String graphic = "L O A D I N G";
        for (int i = 0; i < graphic.length(); i++) {
            System.out.println(graphic.charAt(i));
        }

        if (userTwoChoice.equalsIgnoreCase(userOneChoice)) {
            System.out.printf("This is a tie! You both picked %s %n", userOneChoice);
        } else if (userTwoChoice.equalsIgnoreCase("rock") && userOneChoice.equalsIgnoreCase("paper")) {
            System.out.printf("Congrats! You won! The computer picked %s, and you picked %s%n", userTwoChoice, userOneChoice);
        } else if (userTwoChoice.equalsIgnoreCase("scissors") && userOneChoice.equalsIgnoreCase("rock")) {
            System.out.printf("Congrats! You won. The computer picked %s and you picked %s.%n", userTwoChoice, userOneChoice);
        } else if (userTwoChoice.equalsIgnoreCase("paper") && userOneChoice.equalsIgnoreCase("rock")) {
            System.out.printf("You lost. The computer picked %s, and you picked %s%n", userTwoChoice, userOneChoice);
        } else if (userTwoChoice.equalsIgnoreCase("rock") && userOneChoice.equalsIgnoreCase("scissors")) {
            System.out.printf("You lost. The computer picked %s and you picked %s.%n", userTwoChoice, userOneChoice);
        }
    } //ends determineWinner method

    public static boolean playAgain() {
        System.out.println("Would you like to play again? y/n");
        String playAgain = console.nextLine();

        if (playAgain.equalsIgnoreCase("n")) {
            System.out.println("Thank you for playing! See you next time.");
            return true;
        } else {
            return false;
        }
    }//closes playAgain method

} //this closes the class

/* Pseudo Code:

1) Take input from user
2) Randomly generate a computer choice
3) Compare the choices and determine winner
 */