package com.example.finance_tracker.transactions;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="api/transactions/")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public Transaction addTransaction(@RequestBody Transaction transaction,
                                      @RequestParam Long fromAccountId,
                                      @RequestParam(required = false) Long  toAccountId,
                                      @RequestParam Long categoryId){


        return transactionService.createTransaction(transaction, fromAccountId, toAccountId, categoryId);
    }

}
