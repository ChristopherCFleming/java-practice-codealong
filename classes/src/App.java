public class App {
    public static void main(String[] args) {
    NationalForest one = new NationalForest("Allegheny", "Pennslyvania", 345);
//    one.name = "Overwritten";
//    one.location = "Pennsylvania";
//    one.acres = 234;

//    NationalForest two = new NationalForest();
//    two.name = "Angeles";
//
//    NationalForest three  = new NationalForest();
//    three.name = "Angelina";

    String format = "name: %s, location: %s, acres: %s%n";

    System.out.printf(format, one.getName(), one.getLocation(), one.getAcres());
    System.out.println(one.toLine());
    }
}
