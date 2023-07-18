package com.InvestmentPortfolioManagement.System.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
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

    @PostMapping("/users")
    public Users addUsers(@RequestBody Users user) {
        return userService.addUsers(user);
    }
    // User endpoints
    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        try{
            return ResponseEntity.ok(userService.getAllUsers());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Map<String, Object>> getUserById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try{
            Users user = userService.getUserById(id);
            response.put("id", user.getUserId());
            response.put("name", user.getName());
            response.put("email", user.getEmail());
            response.put("balance", user.getBalance());
            return ResponseEntity.ok(response);
        }catch (Exception e) {
            response.put("error", e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    // Stock endpoints
    @GetMapping("/stocks")
    public ResponseEntity<?> getAllStocks() {
        try{
            return ResponseEntity.ok(stockService.getAllStocks());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/stocks/{id}")
    public ResponseEntity<Map<String, Object>> getStockById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try{
            Stocks stock = stockService.getStockById(id);
            response.put("id", stock.getStockId());
            response.put("company", stock.getCompany());
            response.put("quantity", stock.getQuantity());
            response.put("price", stock.getPrice());
            response.put("user_limit", stock.getUserLimit());
            return ResponseEntity.ok(response);
        }catch (Exception e) {
            response.put("error", e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
        
    @PostMapping("/stocks/buy")
    public ResponseEntity<Map<String, Object>> buyStock(@RequestBody Map<String, Object> request) {

        Map<String, Object> response = new HashMap<>();
        try{
            // Extract the required parameters from the request body
            Long stockId = ((Number) request.get("stockId")).longValue();
            int quantity = ((Number) request.get("quantity")).intValue();
            Long userId = ((Number) request.get("userId")).longValue();

            UserTransactions userTransactions = stockService.buyStock(stockId,quantity, userId);
            response.put("id", userTransactions.gettId());
            response.put("stock_id", userTransactions.getStock().getStockId());
            response.put("user_Id", userTransactions.getUser().getUserId());
            response.put("quantity", userTransactions.getQuantity());
            response.put("price", userTransactions.getPrice());
            response.put("transaction_type", userTransactions.getTransactionType());
            return ResponseEntity.ok(response);
        } catch(IllegalArgumentException e){
            response.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        } catch(Exception e){
            response.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
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

