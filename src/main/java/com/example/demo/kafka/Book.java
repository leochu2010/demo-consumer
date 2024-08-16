package com.example.demo.kafka;

public class Book {

    private Long id;
    private String name;

    public Book() {
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Book(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}
