package com.library.core;

public class BookQuantity {
  private Book book;
  private Integer quantity;

  public BookQuantity(Book book, Integer quantity) {
    this.book = book;
    this.quantity = quantity;
  }

  public Book getBook() {
    return book;
  }

  public void setBook(Book book) {
    this.book = book;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  @Override
  public String toString() {
    return "Book{" +
        book +
        ", quantity=" + quantity +
        '}';
  }
}
