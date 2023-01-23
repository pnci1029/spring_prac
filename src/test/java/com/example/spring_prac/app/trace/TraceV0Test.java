package com.example.spring_prac.app.trace;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TraceV0Test {

    @Test
    void begin() {
        TraceV0 traceV0 = new TraceV0();
        TraceStatus begin = traceV0.begin("begin");
        traceV0.end(begin);
    }

    @Test
    void exception() {
        TraceV0 traceV0 = new TraceV0();
        TraceStatus exception = traceV0.begin("exception");
        traceV0.exception(exception,new IllegalStateException("예외 발생"));

    }

}