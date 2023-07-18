package com.InvestmentPortfolioManagement.System.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Users {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    
    private String name;
    private String email;
    private Long balance;
    
    // Define the user's stock portfolio relationship
    
    // Getters and setters
    //Constructor according to specific requirements
    
}
