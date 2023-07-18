package com.InvestmentPortfolioManagement.System.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.InvestmentPortfolioManagement.System.entity.Stocks;
import com.InvestmentPortfolioManagement.System.entity.UserStock;
import com.InvestmentPortfolioManagement.System.repository.UserStockRepository;

@Service
public class UserStockService {
    private final UserStockRepository userStockRepository;

    public UserStockService(UserStockRepository userStockRepository) {
        this.userStockRepository = userStockRepository;
    }

    public List<UserStock> getUserStocks() {
    	
        // TODO: Implement fetching  User's Stock Information
    	
    	return null/* Placeholder or dummy output*/;
    	
    }
}
