package com.InvestmentPortfolioManagement.System.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.InvestmentPortfolioManagement.System.entity.UserStock;

@Repository
public interface UserStockRepository extends JpaRepository<UserStock, Long> {
    // Add custom methods if needed
	
}

