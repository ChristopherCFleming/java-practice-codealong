import java.util.Scanner;

public class Daycare {
    //variables
    static Scanner console = new Scanner(System.in);
    static String[] daycareSpaces;
    static int capacity;


    public static void main(String[] args) {
        startUp();
    }//end of main class

    public static void startUp(){
        System.out.println("Welcome to the Doggy Daycare!");
        System.out.print("Please enter the number of spaces available today: ");

        capacity = Integer.parseInt(console.nextLine());
        daycareSpaces = new String[capacity];
        menu();
    }// end of the start up method

    public static void menu(){
        boolean exit = false;
        do{
            System.out.println("What would you like to do?");
            System.out.println("1. Check a dog into daycare.");
            System.out.println("2. Check a dog out of daycare.");
            System.out.println("3. View all dogs in our care.");
            System.out.println("4. Exit\n");
            System.out.println("What would you like to do? ");
            int choice = Integer.parseInt(console.nextLine());
            switch (choice){
                case 1:
                    checkInDog();
                    break;
                case 2:
                    checkOutDog();
                    break;
                case 3:
                    viewAllDogs();
                    break;
                case 4:
                    System.out.println("Thank you for vising the daycare! Have a nice day.");
                    exit = true;
                    break;
                default:
                    System.out.println("Not a valid choice. Please enter a number from 1 - 4");
                    break;
            }
        } while(!exit);
    }//end of the menu method

    public static void checkInDog(){
        System.out.print("\nWhat is your dog's name? ");
        String dogName = console.nextLine();

        for (int i = 0; i < daycareSpaces.length; i++) {
            if (daycareSpaces[i] == null) {
                daycareSpaces[i] = dogName;
                System.out.println("\n" + dogName + "has been checked in!");
                return;
            }
        }
        System.out.println("Sorry, there is no space available today. We're fully booked!");
    }//end of checkInDog method

    public static void checkOutDog() {
        System.out.print("What is the name of the dog you wanna check out?");

        String dogName = console.nextLine();
        for (int i = 0; i < daycareSpaces.length; i++) {
            if (daycareSpaces[i] != null && daycareSpaces[i].equalsIgnoreCase(dogName)){
                daycareSpaces[i] = null;
                System.out.println("Successfully checked out!");
                return;
            }
        }
        System.out.println("We can't find your dog. Maybe they were already picked up?");
    }//end of the checkOutDog method

    public static void viewAllDogs(){
        System.out.println("\n Current dogs in our care: ");

        for (int i = 0; i < daycareSpaces.length; i++) {
            if (daycareSpaces[i] == null){
                System.out.println("Empty Space!");
            } else {
                System.out.println(daycareSpaces[i]);
            }
        }
    }//end of view all dogs method
}//end of class method
