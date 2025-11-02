package challenge;

import java.util.Comparator;
import java.util.ListIterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Creating linked list of towns
        LinkedList<Town> itinerary = new LinkedList<>();

        // Adding towns
        itinerary.add(new Town("Sydney", 0));
        itinerary.add(new Town("Adelaide", 1374));
        itinerary.add(new Town("Alice Springs", 2771));
        itinerary.add(new Town("Brisbane", 917));
        itinerary.add(new Town("Darwin", 3972));
        itinerary.add(new Town("Melbourne", 877));
        itinerary.add(new Town("Perth", 3923));

        // Sorting linked list by distance
        itinerary.sort(Comparator.comparingInt(Town::getDistance));

        // Setup
        boolean loop = true;
        Scanner scan = new Scanner(System.in);
        String choice;
        ListIterator<Town> iterator = itinerary.listIterator();
        boolean movingForward = true;
        Town current = iterator.next();

        // Display menu once at start
        printMenu();

        while (loop) {
            System.out.print("Enter your choice: ");
            choice = scan.nextLine().trim().toUpperCase();

            switch (choice) {
                case "F":
                    if (!movingForward) {
                        if (iterator.hasNext()) iterator.next();
                        movingForward = true;
                    }
                    if (iterator.hasNext()) {
                        current = iterator.next();
                        System.out.println("Now visiting: " + current);
                    } else {
                        System.out.println("You’re at the last town.");
                    }
                    break;

                case "B":
                    if (movingForward) {
                        if (iterator.hasPrevious()) iterator.previous();
                        movingForward = false;
                    }
                    if (iterator.hasPrevious()) {
                        current = iterator.previous();
                        System.out.println("Now visiting: " + current);
                    } else {
                        System.out.println("You’re at Sydney.");
                    }
                    break;

                case "L":
                    System.out.println("Towns itinerary:");
                    for (Town town : itinerary)
                        System.out.println(" - " + town);
                    break;

                case "M":
                    printMenu();
                    break;

                case "Q":
                    loop = false;
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Type 'M' to show menu.");
            }
        }

        scan.close();
    }

    // Helper method to print the menu
    private static void printMenu() {
        System.out.println("""
============================
Available actions:
(F) Forward
(B) Backward
(L) List towns
(M) Show menu
(Q) Quit
============================
""");
    }

}
