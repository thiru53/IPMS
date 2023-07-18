package com.InvestmentPortfolioManagement.System.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Stocks {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_id")
    private Long stockId;
    
    private String company;
    private Long quantity;
    private Double price;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    @JsonProperty
    private Long userLimit;
    
  //Getter and Setter
    //Constructor according to specific requirement

}

	
