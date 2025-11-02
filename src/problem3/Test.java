package problem3;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter library capacity: ");
        int n = sc.nextInt();
        sc.nextLine();

        Library library = new Library(n);

        // Initialize with 2 documents
        library.add(new Novel("The Alchemist", "Paulo Coelho", 197, 9.99));
        library.add(new Magazine("Science Today", "October", 2025));

        int choice;
        do {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. Add a document");
            System.out.println("2. Display all documents");
            System.out.println("3. Delete a document");
            System.out.println("4. Search document by numRec");
            System.out.println("5. Display authors");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Select document type (1=Novel, 2=Textbook, 3=Magazine, 4=Dictionary): ");
                    int type = sc.nextInt();
                    sc.nextLine();

                    Document doc = null;
                    if (type == 1) {
                        System.out.print("Title: ");
                        String title = sc.nextLine();
                        System.out.print("Author: ");
                        String author = sc.nextLine();
                        System.out.print("Pages: ");
                        int pages = sc.nextInt();
                        System.out.print("Price: ");
                        double price = sc.nextDouble();
                        doc = new Novel(title, author, pages, price);
                    } else if (type == 2) {
                        System.out.print("Title: ");
                        String title = sc.nextLine();
                        System.out.print("Author: ");
                        String author = sc.nextLine();
                        System.out.print("Pages: ");
                        int pages = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Level: ");
                        String level = sc.nextLine();
                        doc = new Textbook(title, author, pages, level);
                    } else if (type == 3) {
                        System.out.print("Title: ");
                        String title = sc.nextLine();
                        System.out.print("Month: ");
                        String month = sc.nextLine();
                        System.out.print("Year: ");
                        int year = sc.nextInt();
                        doc = new Magazine(title, month, year);
                    } else if (type == 4) {
                        System.out.print("Title: ");
                        String title = sc.nextLine();
                        System.out.print("Language: ");
                        String lang = sc.nextLine();
                        doc = new Dictionary(title, lang);
                    }

                    if (doc != null && library.add(doc))
                        System.out.println("Document added successfully!");
                    else
                        System.out.println("Failed to add document.");
                    break;

                case 2:
                    library.displayDocuments();
                    break;

                case 3:
                    System.out.print("Enter numRec to delete: ");
                    int num = sc.nextInt();
                    Document toDelete = library.document(num);
                    if (toDelete != null && library.delete(toDelete))
                        System.out.println("Document deleted.");
                    else
                        System.out.println("Document not found.");
                    break;

                case 4:
                    System.out.print("Enter numRec to search: ");
                    int numSearch = sc.nextInt();
                    Document found = library.document(numSearch);
                    if (found != null)
                        System.out.println(found);
                    else
                        System.out.println("Document not found.");
                    break;

                case 5:
                    library.displayAuthors();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        sc.close();
    }
}

