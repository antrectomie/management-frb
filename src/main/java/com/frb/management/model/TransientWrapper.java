package com.frb.management.model;

public class TransientWrapper<T> {
    T t;
    public void setEntity(T t){
        this.t = t;
    }

    public T getEntity(){
        return this.t;
    }
}
