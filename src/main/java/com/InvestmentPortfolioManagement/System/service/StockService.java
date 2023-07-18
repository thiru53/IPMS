package com.InvestmentPortfolioManagement.System.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import com.InvestmentPortfolioManagement.System.entity.Stocks;
import com.InvestmentPortfolioManagement.System.entity.UserStock;
import com.InvestmentPortfolioManagement.System.entity.Users;
import com.InvestmentPortfolioManagement.System.repository.StockRepository;
import com.InvestmentPortfolioManagement.System.repository.UserRepository;
import com.InvestmentPortfolioManagement.System.repository.UserStockRepository;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StockService {
    private final StockRepository stockRepository;
    private final UserStockRepository userStockRepository;
    private final UserRepository userRepository;

    public StockService(StockRepository stockRepository, UserRepository userRepository, UserStockRepository userStockRepository) { 
        this.stockRepository = stockRepository;
        this.userRepository = userRepository;
        this.userStockRepository = userStockRepository;
    }

    public List<Stocks> getAllStocks() {
        return stockRepository.findAll();
    }

    public Stocks getStockById(Long id) {
        return stockRepository.findById(id).orElseThrow( ()-> new EntityNotFoundException("Stock Not Found"));
    }

    public UserStock buyStock(Long stockId, int quantity, Long userId) {
        Users user = userRepository.findById(userId).orElseThrow( ()-> new EntityNotFoundException("User Not Found for Id : "+userId));
        Stocks stock = stockRepository.findById(stockId).orElseThrow( ()-> new EntityNotFoundException("Stock Not Found for Id : "+stockId));
        
        UserStock userStock = new UserStock();
        userStock.setUser(user);
        userStock.setStock(stock);
        userStock.setQuantity(quantity);
        userStock.setCreatedAt(LocalDateTime.now());

    	return  userStockRepository.save(userStock);
    }

    public Map<String, Object> sellStock(Long stockId, int quantity, Long userId) {
        // TODO: Implement the sell stock functionality
    	
    	
    	return  null/*response*/;
    }
}