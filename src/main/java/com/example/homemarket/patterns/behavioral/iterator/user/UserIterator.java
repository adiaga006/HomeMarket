package com.example.homemarket.patterns.behavioral.iterator.user;

public interface UserIterator<T> {
    boolean hasNext();
    T next();
}
