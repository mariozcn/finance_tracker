package com.example.finance_tracker.transactions;

import com.example.finance_tracker.accounts.Account;
import com.example.finance_tracker.accounts.AccountRepository;
import com.example.finance_tracker.accounts.AccountResponse;
import com.example.finance_tracker.categories.Category;
import com.example.finance_tracker.categories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    private final CategoryRepository categoryRepository;

    public TransactionService(TransactionRepository transactionRepository, AccountRepository accountRepository, CategoryRepository categoryRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
        this.categoryRepository = categoryRepository;
    }

    public Transaction createTransaction(Transaction transaction,Long fromAccountId,Long toAccountId,
                                         Long categoryId){
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        Optional<Account> optionalAccount = accountRepository.findById(fromAccountId);
        Account account = optionalAccount.orElseThrow(() -> new RuntimeException("Account not found"));
        Category category = optionalCategory.orElseThrow(()-> new RuntimeException("category not found"));
        if (toAccountId != null) {
            Account toAccount = accountRepository.findById(toAccountId)
                    .orElseThrow(() -> new RuntimeException("To account not found"));
            transaction.setToAccount(toAccount);
        }

        transaction.setCategory(category);
        transaction.setFromAccount(account);
        return transactionRepository.save(transaction);
    }
}
