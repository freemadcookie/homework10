package com.cookie.bookshop;

import com.cookie.bookshop.data.BookRepository;
import com.cookie.bookshop.entity.Book;
import com.cookie.bookshop.entity.Customer;
import com.cookie.bookshop.service.BookShopService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookshopApplication.class)
public class BookshopApplicationTests {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookShopService bookShopService;


	@Before
	public void init() {
		Book book = new Book();
		book.setDescription("Увлекательные приключения Тома Сойера");
		book.setTitle("Приключения Тома Сойера");
		bookRepository.save(book);
	}


	@Test
	public void testCreation() {
		boolean founded = false;
		for (Book book : bookRepository.findAll()) {
			if (book.getTitle().contains("Тома Сойера")) {
				founded = true;
			}
		}
		assertTrue(founded);
	}


	@Test
	public void testCountTotalPurchasesByCustomer() {
		Book book = new Book();
		book.setTitle("Азбука");
		book.setAuthor("Лев Тослтой");
		book = bookShopService.saveBook(book);

		Book book2 = new Book();
		book2.setTitle("Кот в сапогах");
		book2.setAuthor("Шарль Пьеро");
		book2 = bookShopService.saveBook(book2);

		Customer customer = new Customer();
		customer.setName("Анонимный Пользователь");
		customer.setAddress("Красноярск");
		customer = bookShopService.saveCustomer(customer);

		bookShopService.buyBook(customer, book, 100);
		bookShopService.buyBook(customer, book, 150);
		bookShopService.buyBook(customer, book, 200);
		bookShopService.buyBook(customer, book2, 130);

		assertEquals(580, (int) bookShopService.boughtBooksByCustomer(customer));
	}

}