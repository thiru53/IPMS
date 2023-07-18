package com.InvestmentPortfolioManagement.System.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.InvestmentPortfolioManagement.System.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
	
    // Add custom methods if needed
}