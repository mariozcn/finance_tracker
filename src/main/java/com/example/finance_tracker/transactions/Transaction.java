package com.example.finance_tracker.transactions;


import com.example.finance_tracker.accounts.Account;
import com.example.finance_tracker.categories.Category;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    @Column(name="amount")
    private BigDecimal amount;

    @Column(name="currency_code")
    private String currencyCode;

    @Column(name="time")
    @CreationTimestamp
    private LocalDateTime time;

    @ManyToOne
    @JoinColumn(name="from_id")
    private Account fromAccount;

    @ManyToOne
    @JoinColumn(name="to_id")
    private Account toAccount;

    public void setId(Long id) {
       this.id = id;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void setFromAccount(Account fromAccount) {
        this.fromAccount = fromAccount;
    }

    public void setToAccount(Account toAccount) {
        this.toAccount = toAccount;
    }

    public Long getId() {
        return id;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public Category getCategory() {
        return category;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Account getFromAccount() {
        return fromAccount;
    }

    public Account getToAccount() {
        return toAccount;
    }

    public Transaction(Long id, TransactionType transactionType, Category category, BigDecimal amount, String currencyCode, LocalDateTime time, Account fromAccount, Account toAccount) {
        this.id = id;
        this.transactionType = transactionType;
        this.category = category;
        this.amount = amount;
        this.currencyCode = currencyCode;
        this.time = time;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
    }

    public Transaction() {
    }
}
