package com.library.core;

public class User {
  private String name;
  private Book book;

  public User(String name, Book book) {
    this.name = name;
    this.book = book;
  }

  public String getName() {
    return name;
  }

  public Book getBook() {
    return book;
  }

  @Override
  public String toString() {
    return "User{" +
        "name='" + name + '\'' +
        ", book=" + book +
        '}';
  }
}
