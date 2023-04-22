package org.yearup;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in); // Globally instantiating a scanner object
    static Book[] books = new Book[5]; //Globally instantiating an array of Book objects
    static int selection; // Declaring the selection int variable globally
    static boolean isValidInput = false; //Declaring a boolean variable to check if the ID entered by the user is valid


    public static void main(String[] args) {

        createInventory();// loads the books array with book objects
        homeScreen(); // Displays home screen


    }

    //Create Inventory
    public static void createInventory() {
        // loading the array with 5 new book objects
        books[0] = new Book(001, "9545646567897", "Essentialism", false, "");
        books[1] = new Book(002, "9389788567897", "Complete German", false, "");
        books[2] = new Book(003, "9174453367897", "More Than Happiness", false, "");
        books[3] = new Book(004, "9781234367314", "Zero to One", false, "");
        books[4] = new Book(005, "9781343545789", "The Lean Startup", true, "Carlos");

    }

    //Display Home Sreen
    public static void homeScreen() {

        // Home Screen UI
        System.out.println("---------------------------------------");
        System.out.println("WELCOME TO THE NEIGHBORHOOD'S LIBRARY");
        System.out.println("----------------------------------------");
        System.out.println(" 1 - Show available books ");
        System.out.println(" 2 - Show checked out books ");
        System.out.println(" 3 - Exit ");
        System.out.print("Please Select a Command (1,2, or 3): ");
        selection = scanner.nextInt(); // registering the users selection
        scanner.nextLine();

        //Switch cases
        switch (selection) {
            case 1:
                availableBooks(); // Calling 'availableBooks' function
                break;
            case 2:
                checkedOutBooks(); // Calling 'checkedOutBooks' function
                break;
            case 3: {
                System.out.println("Thank you for using the neighborhood's library!");
                System.exit(1); // Exits the program and stops the recursive function
                break;
            }
            default: {
                //Error message for invalid input
                System.out.println("\nUnrecognised input! Please try again (press 1,2,or 3)");
                homeScreen(); // Recursively calling the 'homeScreen' function
            }
        }


    }

    //Display Available Books
    public static void availableBooks() {

        String name; // Stores the name of the user that book is checked out to
        isValidInput = false; // initialize the value of 'isValidInput'

        //Available books UI
        System.out.println("\n Available Books");
        System.out.println("--------------------------------------------------");
        System.out.printf("ID\t\tISBN \t\t\t\tTitle\n");
        System.out.println("---\t\t---------------\t\t-----------------------");

        //Iterating through the books array
        for (Book book : books) {
            if (!book.getisCheckedOut()) // Checking if the book has been checked out
            {
                System.out.printf("%-5d%16s\t\t%-25s\n", book.getId(), book.getIsbn(), book.getTitle());
            }

        }

        //While loop that breaks only if the user selects a valid option
        while (!isValidInput) {
            System.out.print("Type the Book ID to Check out (press 0 for home screen): ");
            selection = scanner.nextInt(); // Register the user's input

            //check if the user input is 0 or not
            if (selection != 0) {
                System.out.print("Please enter your name: ");
                scanner.nextLine();
                name = scanner.nextLine().strip(); // register the user's name

                //Iterating through the books array
                for (Book book : books) {
                    //Check if the user's input matches any of the book IDs and the books are not checked out
                    if ((book.getId() == selection) && !book.getisCheckedOut()) {
                        isValidInput = true;
                        book.checkOut(name); // change the status of the book to indicate that it has been checked out
                        System.out.printf("'%s' has been checked out to '%s'.\n\n", //Success message to user
                                book.getTitle(), book.getCheckedOutTo());
                        homeScreen();// call the 'homeScreen' function
                    }

                }
                if (!isValidInput) {
                    System.out.println("\nID not found! Please Try again."); // Error message
                }
            } else {
                homeScreen(); // call the 'homeScreen' function
            }
        }

    }

    //Check out books
    public static void checkedOutBooks() {

        String selectedOption; // String variable to register the user's selected option
        isValidInput = false; // initialize the value of 'isValidInput'

        // Check Out UI
        System.out.println("Checked Out Books");
        System.out.println("----------------------------------------------------------------------");
        System.out.printf("ID\t\tISBN \t\t\t\tTitle\t\t\t\t\tCheck Out to \n");
        System.out.println("---\t\t---------------\t\t--------------------\t-----------------");

        //Iterating through the books array
        for (Book book : books) {
            if (book.getisCheckedOut()) //check if the book has been checked out
            {
                System.out.printf("%-5d%16s\t\t%-25s%-8s\n", book.getId(), //Display all checked out books
                        book.getIsbn(), book.getTitle(), book.getCheckedOutTo());
            }
        }

        //While loop that breaks only if the user selects a valid option
        while (!isValidInput) {
            System.out.print("Press 'C' to Check in a book or 'X' to back to the home screen: "); //Display instructions
            selectedOption = scanner.nextLine(); //Register the user's selected option

            if (selectedOption.equalsIgnoreCase("C")) {
                isValidInput = true;
                checkIn(); // Call the 'checkIn()' function
            } else if (selectedOption.equalsIgnoreCase("X")) {
                isValidInput = true;
                homeScreen(); // Call the 'homeScreen' function
            } else {
                System.out.println("Invalid Input! Please try again"); // Error message
            }
        }

    }

    // Check in function
    public static void checkIn() {
        isValidInput = false; // initialize the value of 'isValidInput'

        //Check in UI
        System.out.println("\n Check In Books");
        System.out.println("---------------------");
        System.out.print("Please enter the book ID that you wish to check in " + // Display Instructions
                "(press 0 to go to the home screen): ");
        selection = scanner.nextInt();

        if (selection == 0) // check the value of the 'selectedBookId'
        {
            homeScreen();// Calling the 'homeScreen' function
        }

        //Iterating through the books array
        for (Book book : books) {
            if ((book.getId() == selection) && book.getisCheckedOut()) {
                isValidInput = true;
                System.out.printf("'%s' has been checked in.\n\n", book.getTitle());
                book.checkIn(); // Change the status of the book
            }
        }
        if (!isValidInput) {
            System.out.println("\nID not found! Please Try again."); // Error message
            checkIn();
        } else {
            homeScreen(); // Calling the 'homeScreen' function
        }
    }

}