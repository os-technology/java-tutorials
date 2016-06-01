/**
 * 
 */
package com.oracle.java.tutorials.reflection.tools;

import java.util.Date;

/**
 * @author LiuJian
 * 
 */
public class Book {

	private String name;

	private String isbn;

	private Date publishDate;

	private Author[] authors = initAuthors();

	private static Author[] initAuthors() {
		Author[] author = new Author[1];
		author[0] = new Author();
		author[0].setName(null);
		return author;
	};

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Author[] getAuthors() {
		return authors;
	}

	public void setAuthors(Author[] authors) {
		this.authors = authors;
	}
}
