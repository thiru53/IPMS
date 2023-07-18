package com.InvestmentPortfolioManagement.System.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.InvestmentPortfolioManagement.System.entity.UserTransactions;

import jakarta.transaction.UserTransaction;

@Repository
public interface UserTransactionRepository extends JpaRepository<UserTransactions, Long> {
    // Add custom methods if needed
	 
}