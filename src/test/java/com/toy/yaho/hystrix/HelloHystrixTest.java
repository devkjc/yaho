package com.toy.yaho.hystrix;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class HelloHystrixTest {

    @Test
    public void unitTest() {
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        assertEquals(new HelloHystrix("Hystrix").execute(), is("Hello Hystrix"));
    }

    @Test
    public void unitTest_fail() {
        assertThat(new HelloHystrix("exception").execute(), is("Hello sabarada exception"));
    }

    @Test
    public void unitTest_cache() {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        try {
            String exception = new HelloHystrix("Hystrix").execute();
            String exception_1 = new HelloHystrix("Hystrix").execute();
            String exception_2 = new HelloHystrix("Hystrix").execute();
            String exception_3 = new HelloHystrix("Hystrix").execute();
        } finally {
            context.shutdown();
        }
    }

}
