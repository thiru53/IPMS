package com.InvestmentPortfolioManagement.System.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum TransactionType {
	@JsonProperty("buy")
    BUY,
    @JsonProperty("sell")
    SELL
}
