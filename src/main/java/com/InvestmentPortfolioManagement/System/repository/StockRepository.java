package com.InvestmentPortfolioManagement.System.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.InvestmentPortfolioManagement.System.entity.Stocks;

@Repository
public interface StockRepository extends JpaRepository<Stocks, Long> {

	// Add custom methods if needed
}