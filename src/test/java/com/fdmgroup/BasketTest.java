package com.fdmgroup;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class BasketTest {
	@Test
	public void test_GetBooksInBasket_ReturnsEmptyBookList_IfNoBooksHaveBeenAdded(){
	    Basket basket = new Basket();
	    List<Book> books = basket.getBooksInBasket();
	    assertEquals(0, books.size());
	}

	@Test
	public void test_GetBooksInBasket_ReturnsArrayOfLengthOne_AfterAddBookMethodIsCalledWithOneBook() {
	    Basket basket = new Basket();
	    Book book = new Book("Title", "Author", 19.99);

	    basket.addBook(book);
	    List<Book> books = basket.getBooksInBasket();
	    assertEquals(1, books.size());
	}

}
