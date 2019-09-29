package com.library.core;


import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class Library {
  //books in the library
  private List<BookQuantity> listOfBooks;
  //Users who are Issued Book
  private List<User> usersList;
  private static Library library;

  private Library() {

    listOfBooks = new LinkedList<>();
    //Issued books to the user
    usersList = new LinkedList<>();
  }

  public static Library getInstance() {
    if (library == null) {
      library = new Library();
    }
    return library;
  }

  //initialize library with some pre-defined objects
  public void initialise() {
    listOfBooks.add(new BookQuantity(new Book("A Game Of Thrones", "English", Category.valueOf("FANTASY"), new Author("George")), new Integer(10)));
    listOfBooks.add(new BookQuantity(new Book("The Notebook", "English", Category.valueOf("ROMANCE"), new Author("Nicholas Sparks")), new Integer(10)));
    listOfBooks.add(new BookQuantity(new Book("Operating System Concepts", "English", Category.valueOf("TECHNICAL"), new Author("Galvin")), new Integer(10)));
    listOfBooks.add(new BookQuantity(new Book("Divine Nothingness", "English", Category.valueOf("POETRY"), new Author("Gerald Stern")), new Integer(10)));
    listOfBooks.add(new BookQuantity(new Book("Animal Farm", "English", Category.valueOf("SATIRE"), new Author("George Orwell")), new Integer(10)));
    listOfBooks.add(new BookQuantity(new Book("Harry Potter", "English", Category.valueOf("FANTASY"), new Author("J. K. Rowling")), new Integer(10)));
    listOfBooks.add(new BookQuantity(new Book("Hobbit", "English", Category.valueOf("FANTASY"), new Author("Tolkien")), new Integer(10)));
    listOfBooks.add(new BookQuantity(new Book("A Song Of Ice And Fire", "English", Category.valueOf("FANTASY"), new Author("George")), new Integer(10)));
  }


  //To Add Book Objects
  public void addBooks(Book book, Integer quantity) {
    boolean contains = false;
    for (int i = 0; i < listOfBooks.size(); i++) {
      if (listOfBooks.get(i).getBook().equals(book)) {
        int tempQuantity = listOfBooks.get(i).getQuantity();
        listOfBooks.get(i).setQuantity(tempQuantity + quantity);
        contains = true;
        break;
      }
    }
    if (contains == false) {
      listOfBooks.add(new BookQuantity(book, quantity));
      library.viewIssuedBookList();
    }
  }

  //To delete all the copies of particular book
  public void deleteBook(String title) {
    for (int i = 0; i < listOfBooks.size(); i++) {
      if (listOfBooks.get(i).getBook().getTitle().equalsIgnoreCase(title)) {
        listOfBooks.remove(i);
        break;
      }
    }
  }

  //Issue Book to the user
  public Book issueBook(String title, String nameOfUser) throws CloneNotSupportedException {
    Book book = null;
    for (int i = 0; i < listOfBooks.size(); i++) {
      if (listOfBooks.get(i).getBook().getTitle().equalsIgnoreCase(title)) {
        int quantity = listOfBooks.get(i).getQuantity();
        if (quantity > 0) {
          book = listOfBooks.get(i).getBook();
          listOfBooks.get(i).setQuantity(quantity - 1);
        }

        break;
      }
    }
    usersList.add(new User(nameOfUser, book));
    return book;
  }

  //View All the Books in Library
  public List<BookQuantity> viewBooks() {
    return listOfBooks;
  }

  //View All the Books written By a Particular Author
  public List<BookQuantity> viewBooksByAuthor(Author author) {
    List<BookQuantity> list = listOfBooks.stream().filter(b -> b.getBook().getAuthor().equals(author)).collect(Collectors.toList());
    return list;
  }

  //View Books By Category
  public List<BookQuantity> viewBooksByCategory(Category category) {
    List<BookQuantity> list = listOfBooks.stream().filter(b -> b.getBook().getCategory() == category).collect(Collectors.toList());
    return list;
  }

  //View All the Issued Books
  public List<User> viewIssuedBookList() {
    return usersList;
  }
}
