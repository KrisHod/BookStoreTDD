package com.fdmgroup;

import java.util.List;

public class Checkout {
	private static final double PERCENTAGE_DISCOUNT_PER_THREE_BOOKS = 0.01;
	private static final double TEN_BOOKS_DISCOUNT_PERCENTAGE = 0.10;

	public double calculatePrice(Basket basket) {
		List<Book> books = basket.getBooksInBasket();
		double totalPrice = 0.0;

		for (Book book : books) {
			totalPrice += book.getPrice();
		}

		int totalBooks = books.size();
		double accumulatedDiscount = (totalBooks / 3) * PERCENTAGE_DISCOUNT_PER_THREE_BOOKS;

		if (totalBooks >= 10) {
			accumulatedDiscount += TEN_BOOKS_DISCOUNT_PERCENTAGE;
		}

		double discountedPrice = totalPrice - (totalPrice * accumulatedDiscount);
		return discountedPrice;
	}
}
