import java.util.Scanner;

public class game {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String userChoice = "";
        System.out.println("Choose rock paper or scissors");
        userChoice = console.nextLine();
        int random = (int)Math.floor(Math.random() * 3); //this will give us a random number between 0, 1, or 2.
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
        if (computerChoice.equalsIgnoreCase(userChoice)) {
            System.out.printf("This is a tie! You both picked %s %n", userChoice);
        } else if (computerChoice.equalsIgnoreCase("rock") && userChoice.equalsIgnoreCase("paper")){
            System.out.printf("Congrats! You won! The computer picked %s, and you picked %s%n", computerChoice, userChoice);
        } else if (computerChoice.equalsIgnoreCase("scissors") && userChoice.equalsIgnoreCase("rock")) {
            System.out.printf("Congrats! You won. The computer picked %s and you picked %s.%n", computerChoice, userChoice);
        } else if (computerChoice.equalsIgnoreCase("paper") && userChoice.equalsIgnoreCase("rock")) {
            System.out.printf("You lost. The computer picked %s, and you picked %s%n", computerChoice, userChoice);
        } else if (computerChoice.equalsIgnoreCase("rock") && userChoice.equalsIgnoreCase("scissors")) {
            System.out.printf("You lost. The computer picked %s and you picked %s.%n", computerChoice, userChoice);
        }
    }  //this closes the main method
} //this closes the class

/* Pseudo Code:

1) Take input from user
2) Randomly generate a computer choice
3) Compare the choices and determine winner
 */