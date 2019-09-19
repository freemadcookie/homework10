package com.cookie.bookshop.service;

import com.cookie.bookshop.data.BookRepository;
import com.cookie.bookshop.data.BoughtBookRepository;
import com.cookie.bookshop.data.CustomerRepository;
import com.cookie.bookshop.entity.Book;
import com.cookie.bookshop.entity.BoughtBook;
import com.cookie.bookshop.entity.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class BookShopServiceImpl implements BookShopService {
    private BookRepository bookRepository = null;
    private BoughtBookRepository boughtBookRepository = null;
    private CustomerRepository customerRepository = null;

    public BookShopServiceImpl(BookRepository bookRepository, BoughtBookRepository boughtBookRepository,
                               CustomerRepository customerRepository) {
        this.bookRepository = bookRepository;
        this.boughtBookRepository = boughtBookRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Long buyBook(Customer customer, Book book, Integer cost) {
        BoughtBook boughtBook = new BoughtBook();
        boughtBook.setCustomer(customer);
        boughtBook.setBook(book);
        boughtBook.setCost(cost);
        return boughtBook.getId();
    }

    @Override
    public Integer boughtBooksAmount(Book book) {
        return boughtBookRepository.boughtByBook(book).stream().reduce(0, Integer::sum);
    }

    @Override
    public Integer boughtBooksByCustomer(Customer customer) {
        return boughtBookRepository.boughtByCustomer(customer).stream().reduce(0, Integer::sum);
    }
}
