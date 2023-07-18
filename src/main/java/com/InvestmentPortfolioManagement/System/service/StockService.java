package com.InvestmentPortfolioManagement.System.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.InvestmentPortfolioManagement.System.entity.*;
import com.InvestmentPortfolioManagement.System.repository.UserTransactionRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import com.InvestmentPortfolioManagement.System.repository.StockRepository;
import com.InvestmentPortfolioManagement.System.repository.UserRepository;
import com.InvestmentPortfolioManagement.System.repository.UserStockRepository;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockService {
    private final StockRepository stockRepository;
    private final UserStockRepository userStockRepository;
    private final UserRepository userRepository;

    private final UserTransactionRepository userTransactionRepository;

    public StockService(StockRepository stockRepository, UserRepository userRepository, UserStockRepository userStockRepository, UserTransactionRepository userTransactionRepository) {
        this.stockRepository = stockRepository;
        this.userRepository = userRepository;
        this.userStockRepository = userStockRepository;
        this.userTransactionRepository = userTransactionRepository;
    }

    public List<Stocks> getAllStocks() {
        return stockRepository.findAll();
    }

    public Stocks getStockById(Long id) {
        return stockRepository.findById(id).orElseThrow( ()-> new EntityNotFoundException("Stock Not Found"));
    }

    @Transactional
    public UserTransactions buyStock(Long stockId, int quantity, Long userId) {
        // TODO: Implement the buy stock functionality


        Users user = userRepository.findById(userId).orElseThrow( ()-> new EntityNotFoundException("User Not Found for Id : "+userId));
        Stocks stock = stockRepository.findById(stockId).orElseThrow( ()-> new EntityNotFoundException("Stock Not Found for Id : "+stockId));
        if(quantity > stock.getUserLimit()) {
            throw new IllegalArgumentException("Quantity not allowed more than 15 per user");
        }
        if(quantity > stock.getQuantity()){
            throw new IllegalArgumentException("Insufficient quantity stocks");
        }

        UserStock userStock = new UserStock();
        userStock.setUser(user);
        userStock.setStock(stock);
        userStock.setQuantity(quantity);
        userStock.setCreatedAt(LocalDateTime.now());
        userStock.setUpdatedAt(LocalDateTime.now());
        userStockRepository.save(userStock);

        stock.setQuantity(stock.getQuantity()-quantity);
        Double price = Double.valueOf(quantity%stock.getQuantity())/10;
        stock.setPrice(stock.getPrice()+price);
        stockRepository.save(stock);

        user.setBalance((long) (user.getBalance() - quantity*stock.getPrice()));
        userRepository.save(user);

        UserTransactions userTransactions = new UserTransactions();

        userTransactions.setUser(userStock.getUser());
        userTransactions.setStock(userStock.getStock());

        userTransactions.setQuantity(Long.valueOf(userStock.getQuantity()));
        userTransactions.setCreatedAt(LocalDateTime.now());
        userTransactions.setPrice(stock.getPrice());
        userTransactions.setTransactionType(TransactionType.BUY);

        return  userTransactionRepository.save(userTransactions);
    }

    public Map<String, Object> sellStock(Long stockId, int quantity, Long userId) {
        // TODO: Implement the sell stock functionality
    	
    	
    	return  null/*response*/;
    }
}