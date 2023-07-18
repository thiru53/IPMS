package com.InvestmentPortfolioManagement.System.service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.InvestmentPortfolioManagement.System.entity.UserTransactions;
import com.InvestmentPortfolioManagement.System.repository.UserTransactionRepository;

@Service
public class UserTransactionService {
    private final UserTransactionRepository userTransactionRepository;

    public UserTransactionService(UserTransactionRepository userTransactionRepository) {
        this.userTransactionRepository = userTransactionRepository;
    }

    public List<UserTransactions> getAllTransactions() {
    	// TODO: Implement the logic to retrieve all transaction information from the database
        
        
        return null/* Placeholder or dummy output */;
    }

    public UserTransactions getTransactionById(Long id) {
    	// TODO: Implement the logic to retrieve a specific  transaction information by ID 
        
        
        return  null/* Placeholder or dummy output */;
        
    }
}