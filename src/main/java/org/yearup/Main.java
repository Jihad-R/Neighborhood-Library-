package org.yearup;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Book[] books = new Book[5];
    static int selection;
    static int selectedBookId;



    public static void main(String[] args) {

        createInventory(books);
        homeScreen();


    }

    //Create Inventory
    public static void createInventory(Book[] books) {

        books[0] = new Book(001, "1233243", "Essentialism", false, null);
        books[1] = new Book(002, "1233243", "Complete German", false, null);
        books[2] = new Book(003, "1233243", "More Than Happiness", false, null);
        books[3] = new Book(004, "1233243", "Zero to One", false, null);
        books[4] = new Book(005, "1233243", "The Lean Startup", false, null);

    }

    //Display Home Sreen
    public static void homeScreen() {


        while (true) {
            System.out.println("---------------------------------------");
            System.out.println("WELCOME TO THE NEIGHBORHOOD'S LIBRARY");
            System.out.println("----------------------------------------");
            System.out.println(" 1 - Show available books ");
            System.out.println(" 2 - Show checked out books ");
            System.out.println(" 3 - Exit ");
            System.out.print("Please Select a Command (1,2, or 3): ");
            selection = scanner.nextInt();
            scanner.nextLine();

            if (selection == 1) {
                availableBooks(books);
            } else if (selection == 2) {
                checkedOutBooks(books);

            } else if (selection == 3) {
                break;
            }
            else{
                System.out.println("Unrecognised input please try again (press 1,2,or 3)\n");
            }

        }
    }

    //Display Available Books
    public static void availableBooks(Book[] books) {

        String name;

        System.out.println("\n Available Books");
        System.out.println("------------------------------");
        System.out.printf("ID\t\tISBN \t\tTitle \n");
        System.out.println("---\t\t-----\t\t----------");
        for (int i = 0; i < books.length; i++) {
            if (books[i].isCheckedOut() == false) {
                System.out.printf("%-5d%10s\t\t%-25s\n", books[i].getId(), books[i].getIsbn() ,books[i].getTitle());
            }

        }
        System.out.print("Type the Book ID to Check out (press 0 for home screen): ");
        selection = scanner.nextInt();
        scanner.nextLine();

        if (selection != 0) {
            System.out.print("Please enter your name: ");
            name = scanner.nextLine();

            for (Book book : books) {

                if (book.getId() == selection) {
                    book.checkOut(name);
                }
            }


        }

    }

    //Check out function
    public static void checkedOutBooks(Book[] books) {

        String option;

        System.out.println("\nChecked Out Books");
        System.out.println("------------------------------");
        System.out.printf("ID\t\tISBN \t\tTitle \n");
        System.out.println("---\t\t-----\t\t----------");
        for (Book i : books) {
            if (i.isCheckedOut() == true) {
                System.out.printf("%-5d%10s\t\t%-25s\n", i.getId(), i.getIsbn() ,i.getTitle());
            }
        }

        System.out.print("Press 'C' to Check in a book or 'X' to back to the home screen: ");
        option = scanner.nextLine();

        if(option.equalsIgnoreCase("C")){
            checkIn(books);
        }

    }

    // Check in function
    public static void checkIn(Book[] books) {

        System.out.println("\n Check In Books");
        System.out.println("---------------------");
        System.out.print("Please enter the book ID that you wish to check in: ");
        selectedBookId = scanner.nextInt();
        for (Book i : books) {
            if (i.getId() == selectedBookId) {
                i.checkIn();
            }
        }
    }

}