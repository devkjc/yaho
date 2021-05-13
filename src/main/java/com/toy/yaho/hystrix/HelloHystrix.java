package com.toy.yaho.hystrix;

// HystrixCommand는 annotation을 import 하지않도록 주의하자.
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class HelloHystrix extends HystrixCommand<String> {

    private String name;

    public HelloHystrix(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup")); // Hystrix 통계에서 사용하는 구별 Key
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());

        System.out.println("run method");

        if(name.equals("exception")) {
            throw new RuntimeException("sabarada exception");
        }

        return "Hello " + name;
    }

    @Override
    protected String getFallback() {
        System.out.println("fallback");
        return "Hello sabarada exception";
    }

    // cache key
    @Override
    protected String getCacheKey() {
        return name;
    }
}
