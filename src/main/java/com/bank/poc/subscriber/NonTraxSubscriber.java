package com.bank.poc.subscriber;

import com.bank.poc.openapi.model.TransactionDetails;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;


/**
 * (@link Sub)
 *
 */
public class NonTraxSubscriber implements Subscriber<TransactionDetails> {

    @Override
    public void onSubscribe(Subscription subscription) {

    }

    @Override
    public void onNext(TransactionDetails transactionDetails) {

    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onComplete() {

    }
}
