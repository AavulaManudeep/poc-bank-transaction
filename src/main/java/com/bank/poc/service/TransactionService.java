package com.bank.poc.service;

import com.bank.poc.enumirator.TransactionType;
import com.bank.poc.openapi.model.*;
import com.bank.poc.subscriber.TransactionSubscriber;
import com.bank.poc.util.TransactionUtil;
import lombok.AllArgsConstructor;
import org.apache.camel.CamelContext;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
@AllArgsConstructor
public class TransactionService {

    private final ProducerTemplate producerTemplate;

    public TransactionResponse processTransaction(TransactionRequest transactionRequest) {
        //camelContext.asyncSendBody("direct:test_camel","Test");
        producerTemplate.asyncSendBody("direct:test_camel","Test");
        return getResponse();
    }

    public Mono<TransactionDetails> getTransactionDetails(String transactionId) {
        Mono.fromSupplier(()-> new TransactionDetails()).subscribe(new TransactionSubscriber());
        return  Mono.just(new TransactionDetails());
    }

    public TransactionResponse getResponse(){
        var transactionResponse = new TransactionResponse();
        transactionResponse.setTransactionId(12345);
        transactionResponse.setTransactionDetails(new TransactionDetails());
        transactionResponse.getTransactionDetails().setTransactionAmount(234.44);
        transactionResponse.getTransactionDetails().setTransactionType(TransactionType.PURCHASE.name());
        var merchantInfo = new MerchantInfo();
        merchantInfo.setMerchantCategory("Whole Sale");
        merchantInfo.setName("Metro");
        merchantInfo.setAddress(merchantInfo.getAddress());
        transactionResponse.getTransactionDetails().setMerchantInfo(merchantInfo);
        var address = new Address();
        address.address1("Test1");
        address.address2("Test2");
        address.setCity("city");
        address.setState("state");
        address.setZipCode(12345);
        var val = TransactionUtil.isItCorrect();
        return transactionResponse;
    }
}
