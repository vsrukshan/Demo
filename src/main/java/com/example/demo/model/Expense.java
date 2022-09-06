package com.example.demo.model;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
public class Expense {

    @Id
    @GeneratedValue()
    private Long id;

    @Column
    private String note;

    @ManyToOne
    @JoinColumn(name="category_id", nullable = false)
    private Category category;

    @Column
    private Double amount;

    @Column
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "method_id", nullable = false)
    private Method method;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }
}
