package com.bank.poc.publiser;

import com.bank.poc.openapi.model.TransactionDetails;
import com.bank.poc.subscriber.TransactionSubscriber;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Component
public class TransactionPublisher implements Publisher<TransactionDetails> {

    public static List<Subscriber<? super TransactionDetails> > transactionSubscriberList = new ArrayList<>();

    @Override
    public void subscribe(Subscriber<? super TransactionDetails> subscriber) {
        transactionSubscriberList.add(subscriber);
    }
}
