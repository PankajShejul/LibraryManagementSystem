package com.library.core;

import java.util.Objects;


public class Book implements  Cloneable {
  private String title;
  private String language;
  private Category category;
  private Author author;

  public Book(String title, String language, Category category, Author author) {
    this.title = title;
    this.language = language;
    this.author = author;
    this.category = category;
  }

  public String getTitle() {
    return title;
  }

  public String getLanguage() {
    return language;
  }

  public Category getCategory() {
    return category;
  }

  public Author getAuthor() {
    return author;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Book book = (Book) o;
    return Objects.equals(getTitle(), book.getTitle()) &&
        Objects.equals(getLanguage(), book.getLanguage()) &&
        getCategory() == book.getCategory() &&
        Objects.equals(getAuthor(), book.getAuthor());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getTitle(), getLanguage(), getCategory(), getAuthor());
  }

  @Override
  public String toString() {
    return "title=" + title +
        ", language=" + language +
        ", category=" + category +
        ", author=" + author;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}
