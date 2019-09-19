package com.cookie.bookshop.entity;

import javax.persistence.*;

@Entity
public class BoughtBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private int cost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_customer")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_book")
    private Book book;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public  Customer getCustomer() {
        return customer;
    }

    public  void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getCost() {
        return cost;
    }

    public  void setCost(int cost) {
        this.cost = cost;
    }

    public Book getBook() {
        return book;
    }

    public  void setBook(Book book) {
        this.book = book;
    }
}

