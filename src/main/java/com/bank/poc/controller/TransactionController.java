package com.bank.poc.controller;


import com.bank.poc.customannotation.BankSensitiveData;
import com.bank.poc.openapi.model.TransactionDetails;
import com.bank.poc.openapi.model.TransactionRequest;
import com.bank.poc.openapi.model.TransactionResponse;
import com.bank.poc.service.TransactionService;
import lombok.AllArgsConstructor;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.SpringVersion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Observable;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<TransactionResponse> processPurchase(@RequestBody TransactionRequest transactionRequest) {
        logger.info("TransactionID {}",transactionRequest);
        var response = transactionService.processTransaction(transactionRequest);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/{transactionId}")
    public ResponseEntity<Mono<TransactionDetails>>  getTransactionDetails(@PathVariable String transactionId) {
        logger.info("TransactionID {}",transactionId);
    Mono<TransactionDetails> transaction = transactionService.getTransactionDetails(transactionId);
        return new ResponseEntity<>(Mono.just(new TransactionDetails()),HttpStatus.OK);
    }
}

