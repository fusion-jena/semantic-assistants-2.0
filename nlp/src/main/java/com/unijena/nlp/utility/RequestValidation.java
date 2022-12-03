package com.unijena.nlp.utility;

import com.google.common.util.concurrent.RateLimiter;
import com.unijena.nlp.exception.RequestLimitException;
import com.unijena.nlp.exception.StringLimitException;

public class RequestValidation {
    final static RateLimiter rateLimiter = RateLimiter.create(200);

    public static void checkTermLength(String term) {
        if (term.split(" ").length > 500) {
            throw new StringLimitException("the entered string is bigger than 500 words");
        }
    }

    public static void checkRequestLimit() {
        if (!rateLimiter.tryAcquire()) {
            throw new RequestLimitException("Too many request");
        }
    }
}
