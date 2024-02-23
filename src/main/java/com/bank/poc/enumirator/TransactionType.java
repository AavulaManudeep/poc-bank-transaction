package com.bank.poc.enumirator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public enum TransactionType {
    PURCHASE,
    REFUND
}
