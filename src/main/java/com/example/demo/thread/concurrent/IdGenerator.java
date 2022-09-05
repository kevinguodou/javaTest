package com.example.demo.thread.concurrent;

import java.util.concurrent.atomic.AtomicLong;

class IdGenerator {

    AtomicLong var = new AtomicLong(0);

    public long getNextId() {
        return var.incrementAndGet();
    }

}