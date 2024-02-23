package com.bank.poc;


import com.bank.poc.controller.TransactionController;
import com.bank.poc.openapi.model.TransactionRequest;
import com.bank.poc.openapi.model.TransactionResponse;
import com.bank.poc.service.TransactionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Objects;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TransactionControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    TransactionService transactionService;


    @Test
    public void purchaseTransactionTest() {
        webTestClient.post().uri("/transaction")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(new TransactionRequest())
                .exchange()
                .expectBody(TransactionResponse.class)
                .consumeWith(rep -> Assertions.assertEquals(12345, Objects.requireNonNull(rep.getResponseBody()).getTransactionId()));
    }



}
