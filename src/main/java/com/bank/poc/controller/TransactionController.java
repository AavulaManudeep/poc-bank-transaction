package com.bank.poc.controller;


import com.bank.poc.openapi.model.TransactionRequest;
import com.bank.poc.openapi.model.TransactionResponse;
import com.bank.poc.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<TransactionResponse> processPurchase(@RequestBody TransactionRequest transactionRequest) {
        var response = transactionService.processTransaction(transactionRequest);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
