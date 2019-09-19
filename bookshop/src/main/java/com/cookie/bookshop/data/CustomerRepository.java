package com.cookie.bookshop.data;

import com.cookie.bookshop.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}

