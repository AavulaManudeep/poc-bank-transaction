package com.bank.poc.subscriber;

import com.bank.poc.openapi.model.TransactionDetails;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * @link sub
 */
public class TransactionSubscriber implements Subscriber<TransactionDetails> {

    private  Subscription subscription;
    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        this.subscription.request(2);
    }

    @Override
    public void onNext(TransactionDetails transactionDetails) {
        System.out.println("TransactionDetails");
        this.subscription.request(2);
    }

    @Override
    public void onError(Throwable throwable) {
        subscription.cancel();
    }

    @Override
    public void onComplete() {
        System.out.println("TransactionDetails complete");
    }
}
