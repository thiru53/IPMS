package com.InvestmentPortfolioManagement.System.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.InvestmentPortfolioManagement.System.entity.Stocks;
import com.InvestmentPortfolioManagement.System.entity.TransactionType;
import com.InvestmentPortfolioManagement.System.entity.UserStock;
import com.InvestmentPortfolioManagement.System.entity.UserTransactions;
import com.InvestmentPortfolioManagement.System.entity.Users;
import com.InvestmentPortfolioManagement.System.service.StockService;
import com.InvestmentPortfolioManagement.System.service.UserService;
import com.InvestmentPortfolioManagement.System.service.UserStockService;
import com.InvestmentPortfolioManagement.System.service.UserTransactionService;

@RestController
public class AllController {
    private final UserService userService;
    private final StockService stockService;
    private final UserTransactionService userTransactionService;
    private final UserStockService userStockService;
     
    public AllController(UserService userService,StockService stockService,UserTransactionService userTransactionService,UserStockService userStockService){
    	this.userService=userService;
    	this.stockService=stockService;
    	this.userTransactionService=userTransactionService;
    	this.userStockService=userStockService;
    }

    

    // User endpoints
    @GetMapping("/users")
    public List<Users> getAllUsers() {

        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public Users getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
        
       
    }

    // Stock endpoints
    @GetMapping("/stocks")
    public List<Stocks> getAllStocks() {
        return stockService.getAllStocks();
    }

    @GetMapping("/stocks/{id}")
    public Stocks getStockById(@PathVariable Long id) {
        return stockService.getStockById(id);
    }
        
    @PostMapping("/stocks/buy")
    public ResponseEntity<Map<String, Object>> buyStock(@RequestBody Map<String, Object> request) {
        // Extract the required parameters from the request body
    	Long stockId = ((Number) request.get("stockId")).longValue();
        int quantity = ((Number) request.get("quantity")).intValue();
        Long userId = ((Number) request.get("userId")).longValue();

        UserStock userStock = stockService.buyStock(stockId,quantity, userId);
        
        UserTransactions userTransactions = new UserTransactions();
        userTransactions.setUser(userStock.getUser());
        userTransactions.setStock(userStock.getStock());
        userTransactions.setQuantity(Long.valueOf(userStock.getQuantity()));
        
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Buy Stock API Endpoint with JSON Response");
        
        
         return ResponseEntity.ok(response);
    }


    
    @PostMapping("/stocks/sell")
    public ResponseEntity<Map<String, Object>> sellStock(@RequestBody Map<String, Object> request) {
        // Extract the required parameters from the request body
    	Long stockId = ((Number) request.get("stockId")).longValue();
        int quantity = ((Number) request.get("quantity")).intValue();
        Long userId = ((Number) request.get("userId")).longValue();

        // TODO: Implement the logic to facilitate the selling of shares for a specific company and user
        // based on the extracted parameters from the request body 
        //can change the return type of method
        
     
        
        // Create a dummy response map with the endpoint message
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Sell Stock API Endpoint with JSON Response");
        
        
         return ResponseEntity.ok(response);
    }



    // Transaction endpoints
    @GetMapping("/transactions")
    public Map<String, Object> getAllTransactions() {
    	// TODO: Implement the logic , that retrieves all transaction information 
    	//from the database and provides a JSON response.
        // Can Change the return type of method
    	
    	
    	
    	
    	// Create a dummy response map with the endpoint message 
    	Map<String, Object> response = new HashMap<>();
    	response.put("message","Transaction Information Retrieval API Endpoint with JSON Response");
        
        return response;
        
        
        
    }

    @GetMapping("/transactions/{id}")
    public Map<String, Object> getTransactionById(@PathVariable Long id) {
    	
    	
    	// TODO: Implement the logic to retrieves information about a single transaction from the database and returns a JSON response.
        //Can Change the return type of method
    	
    	// Create a dummy response map with the endpoint message
    	Map<String, Object> response = new HashMap<>();
        response.put("message","API Endpoint for Retrieving Single Transaction Information with JSON Response using transaction Id");
        
        return response;
    }

    // User Stock endpoints
    @GetMapping("/user/stocks")
    public Map<String, Object>getUserStocks() {
    	//TODO:-
    	// retrieves stock information for each user from the database and provides a JSON response.
    	//Can Change the return type of method 
    	
    	
    	// Create a dummy response map with the endpoint message
    	Map<String, Object> response = new HashMap<>();
        response.put("message", "API Endpoint for Retrieving User's Stock Information with JSON Response");
       
     
            
           

        return response;
            
        }
    }

