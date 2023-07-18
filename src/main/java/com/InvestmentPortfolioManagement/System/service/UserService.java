package com.InvestmentPortfolioManagement.System.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.InvestmentPortfolioManagement.System.entity.TransactionType;
import com.InvestmentPortfolioManagement.System.entity.Users;
import com.InvestmentPortfolioManagement.System.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transaction;

@Service
public class UserService {
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

     
    public Users getUserById(Long userId) {
    	TransactionType.BUY.name().toLowerCase();
        return userRepository.findById(userId).orElseThrow( ()-> new EntityNotFoundException("User Not Found"));
    }


    public Users addUsers(Users user) {
        return userRepository.save(user);
    }
}