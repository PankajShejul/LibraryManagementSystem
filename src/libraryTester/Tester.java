package libraryTester;

import com.library.core.*;

import java.util.List;
import java.util.Scanner;

public class Tester {
  public static void main(String[] args) throws CloneNotSupportedException {
    Library library = Library.getInstance();
    library.initialise();
    List<BookQuantity> list;
    Category category = null;
    Author author = null;
    final int VIEW = 1, VIEWBYAUTHOR = 2, VIEWBYCATEGORY = 3, ADD = 4, ISSUE = 5, REMOVE = 6, VIEWISSUEDBOOK = 7, EXIT = 8;
    Scanner scanner = new Scanner(System.in);
    boolean flag = true;
    while (flag) {
      System.out.println("1.View All Books");
      System.out.println("2.View Books By Author");
      System.out.println("3.View Books By Category");
      System.out.println("4.Add Books");
      System.out.println("5.Issue Books");
      System.out.println("6.Delete Books");
      System.out.println("7.View Issued Book List");
      System.out.println("8.Exit");
      int choice = scanner.nextInt();
      scanner.nextLine();
      switch (choice) {
        case VIEW:
          list = library.viewBooks();
          if (list.isEmpty()) {
            System.out.println("No Books Available");
          } else {
            list.stream().forEach(System.out::println);
          }
          break;
        case VIEWBYAUTHOR:
          System.out.println("Enter the Name Of Author");
          String name = scanner.nextLine();
          author = new Author(name);
          list = library.viewBooksByAuthor(author);
          if (list.isEmpty()) {
            System.out.println("No Books Available of this author");
          } else {
            list.stream().forEach(System.out::println);
          }

          break;
        case VIEWBYCATEGORY:
          System.out.println("Enter the name of Category");
          category = Category.valueOf(scanner.nextLine().toUpperCase());
          list = library.viewBooksByCategory(category);
          if (list.isEmpty()) {
            System.out.println("No Books Available In this category");
          } else {
            list.stream().forEach(System.out::println);
          }
          break;
        case ADD:
          System.out.println("Enter Title Of The Book");
          String title = scanner.nextLine();
          System.out.println("Enter Language");
          String language = scanner.nextLine();
          System.out.println("Enter Category");
          category = Category.valueOf(scanner.nextLine().toUpperCase());
          System.out.println("Enter the name of author:");
          author = new Author(scanner.nextLine());
          Book book = new Book(title, language, category, author);
          System.out.println("Enter Quantity");
          int quanity = scanner.nextInt();
          scanner.nextLine();
          library.addBooks(book, quanity);
          break;
        case ISSUE:
          System.out.println("Enter the title of the book");
          title = scanner.nextLine();
          System.out.println("Enter the name of user");
          book = library.issueBook(title, scanner.nextLine());
          System.out.println("Book Issued:" + book);
          break;
        case REMOVE:
          System.out.println("Enter the title of the book");
          title = scanner.nextLine();
          library.deleteBook(title);
          break;
        case VIEWISSUEDBOOK:
          List<User> user = library.viewIssuedBookList();
          if (user.isEmpty()) {
            System.out.println("No books Issued..!!");
          } else {
            user.stream().forEach(System.out::println);
          }
          break;
        case EXIT:
          flag = false;
          break;
        default:
          System.out.println("Please Enter Correct Option");
          break;
      }
    }
  }
}
