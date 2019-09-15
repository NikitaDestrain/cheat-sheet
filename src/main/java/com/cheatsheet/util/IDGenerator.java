package com.cheatsheet.util;

public class IDGenerator {
    private int counter;

    public IDGenerator(int counter) {
        this.counter = counter;
    }

    public IDGenerator() {
        this.counter = 0;
    }

    public int generate() {
        return counter++;
    }

    public void reset() {
        this.counter = 0;
    }

    public void setCounter(int value) {
        this.counter = value;
    }
}
