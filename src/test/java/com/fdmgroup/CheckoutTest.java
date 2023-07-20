package com.fdmgroup;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CheckoutTest {
	@Test
	public void test_CalculatePrice_ReturnsDoubleZeroPointZeroWhenPassedAnEmptyBasket() {
		Basket basket = new Basket();
		Checkout checkout = new Checkout();

		double price = checkout.calculatePrice(basket);
		assertEquals(0.0, price, 0.001);
	}

	@Test
	public void test_CalculatePrice_ReturnsPriceOfBookInBasket_WhenPassedBasketWithOneBook() {
		Basket basket = new Basket();
		Checkout checkout = new Checkout();
		Book book = new Book("Title", "Author", 19.99);

		basket.addBook(book);
		double price = checkout.calculatePrice(basket);
		assertEquals(19.99, price, 0.001);
	}

	@Test
	public void test_CalculatePrice_ReturnsSumOfPricesOfBooksInBasket_WhenPassedBasketWithMultipleBooks() {
		Basket basket = new Basket();
		Checkout checkout = new Checkout();
		Book book1 = new Book("Title1", "Author1", 19.99); // Assuming Book constructor exists
		Book book2 = new Book("Title2", "Author2", 12.49); // Assuming Book constructor exists

		basket.addBook(book1);
		basket.addBook(book2);

		double price = checkout.calculatePrice(basket);
		assertEquals(32.48, price, 0.001);
	}

	@Test
	public void test_CalculatePrice_AppliesOnePercentDiscountForEveryThreeBooksInBasket() {
		Basket basket = new Basket();
		Checkout checkout = new Checkout();
		Book book1 = new Book("Title1", "Author1", 10.0);
		Book book2 = new Book("Title2", "Author2", 10.0);
		Book book3 = new Book("Title3", "Author3", 10.0);

		basket.addBook(book1);
		basket.addBook(book2);
		basket.addBook(book3);

		double price = checkout.calculatePrice(basket);
		assertEquals(29.7, price, 0.001);
	}

	@Test
	public void test_CalculatePrice_AppliesAdditionalFivePercentDiscountForDifferentBooks() {
		Basket basket = new Basket();
		Checkout checkout = new Checkout();
		Book book1 = new Book("Title1", "Author1", 15.0); 
		Book book2 = new Book("Title2", "Author2", 10.0); 
		Book book3 = new Book("Title3", "Author3", 5.0); 

		basket.addBook(book1);
		basket.addBook(book2);
		basket.addBook(book3);

		double price = checkout.calculatePrice(basket);
		assertEquals(27.0, price, 0.001);
	}

	@Test
	public void test_CalculatePrice_AppliesUniqueFiftyPercentDiscountForTwoSameBooks() {
		Basket basket = new Basket();
		Checkout checkout = new Checkout();
		Book book1 = new Book("Title1", "Author1", 20.0);
		Book book2 = new Book("Title1", "Author1", 20.0);

		basket.addBook(book1);
		basket.addBook(book2);

		double price = checkout.calculatePrice(basket);
		assertEquals(20.0, price, 0.001);
	}
}


