package com.bank.poc.service;

import com.bank.poc.enumirator.TransactionType;
import com.bank.poc.openapi.model.*;
import com.bank.poc.util.TransactionUtil;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    public TransactionResponse processTransaction(TransactionRequest transactionRequest) {

        return getResponse();
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
        boolean val = TransactionUtil.isItCorrect();
        return transactionResponse;
    }
}
