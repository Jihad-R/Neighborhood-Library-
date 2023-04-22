package org.yearup;

public class Book {

    private int id; // Book ID
    private String isbn; // Book's ISBN
    private String title; // Book's Title
    private boolean isCheckedOut = false; // Book's checked out status
    private String checkedOutTo; // Name of person the book is checked out to

    public Book() {
    } // Default object constructor


    public Book(int id, String isbn, String title, //Object constructor with all 5 parameter
                boolean isCheckedOut, String checkedOutTo) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = isCheckedOut;
        this.checkedOutTo = checkedOutTo;
    }

    public void checkOut(String name) // check out method
    {
        this.checkedOutTo = name; // assign a value to the 'checkedOutTo' variable of the book object
        this.isCheckedOut = true; // change the 'checked out' status of the book object to true
    }

    public void checkIn() {
        this.checkedOutTo = ""; // assign an empty string to the 'checkedOutTo' variable of the book object
        this.isCheckedOut = false; //change the 'checked out' status of the book object to false

    }

    public int getId() // returns the book object's ID
    {
        return this.id;
    }

    public void setId(int id) // set the value of the book object's ID
    {
        if (id > 0) // check if the id value is greater than 0
        {
            this.id = id;
        }
    }

    public String getIsbn() // return the value of the book object's ISBN
    {
        return this.isbn;
    }

    public void setIsbn(String isbn) // set the value og the book object's ISBN
    {
        this.isbn = isbn;
    }

    public String getTitle() // return the value of the book object's title
    {
        return this.title;
    }

    public void setTitle(String title) //set the value of the book object's title
    {
        this.title = title;
    }

    public boolean getisCheckedOut() // return the checked out status of the book object
    {
        return this.isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) // set the value of the se
    {
        isCheckedOut = checkedOut;
    }

    public String getCheckedOutTo() // return the name of the user that the book object is checked out to
    {
        return this.checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo)  //set the name of the user that the book object is checked out to
    {
        this.checkedOutTo = checkedOutTo;
    }


}
