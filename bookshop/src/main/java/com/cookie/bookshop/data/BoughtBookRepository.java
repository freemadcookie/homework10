package com.cookie.bookshop.data;

import com.cookie.bookshop.entity.Book;
import com.cookie.bookshop.entity.BoughtBook;
import com.cookie.bookshop.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoughtBookRepository extends CrudRepository<BoughtBook, Long>, JpaRepository<BoughtBook, Long> {

    @Query("select bought.cost from BoughtBook bought where bought.book = ?1")
    List<Integer> boughtByBook(Book book);

    @Query("select bought.cost from BoughtBook bought where bought.customer = ?1")
    List<Integer> boughtByCustomer(Customer customer);
}
