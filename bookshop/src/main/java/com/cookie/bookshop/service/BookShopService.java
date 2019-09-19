package com.cookie.bookshop.service;


import com.cookie.bookshop.entity.Book;
import com.cookie.bookshop.entity.Customer;

public interface BookShopService {
    //сохранение книги в БД
    Book saveBook(Book book);
    //сохранение пользователя в БД
    Customer saveCustomer(Customer customer);

    //операция покупки книги покупателем
    Long buyBook(Customer customer, Book book, Integer cost);
    //подсчет общей стоимости продаж по книге
    Integer boughtBooksAmount(Book book);
    //подсчет общей стоимости купленных книг по покупателю
    Integer boughtBooksByCustomer(Customer customer);
}
