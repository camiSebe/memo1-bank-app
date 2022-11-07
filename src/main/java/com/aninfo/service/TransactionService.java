package com.aninfo.service;
import com.aninfo.service.AccountService;


import com.aninfo.exceptions.InvalidTransactionTypeException;
import com.aninfo.model.Transaction;
import com.aninfo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountService accountService;


    public Transaction createTransaction(Transaction transaction) {
        if (transaction.getType().equals("withdraw")) {
            return createWithdrawTransaction(transaction);
        } else if (transaction.getType().equals("deposit")) {
            return createDepositTransaction(transaction);
        } else {
            throw new InvalidTransactionTypeException("Invalid Transaction Type");
        }
    }

    private Transaction createWithdrawTransaction(Transaction transaction) {
        accountService.withdraw(transaction.getCbu(), transaction.getAmount());
        return transactionRepository.save(transaction);
    }

    private Transaction createDepositTransaction(Transaction transaction) {
        accountService.deposit(transaction.getCbu(), transaction.getAmount());
        return transactionRepository.save(transaction);
    }


    public Collection<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }

    public Collection<Transaction> getTransactionsByCbu(Long cbu) {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> findById(Long id) {
        return transactionRepository.findById(id);
    }

    public void save(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public void deleteById(Long id) {
        transactionRepository.deleteById(id);
    }

}
