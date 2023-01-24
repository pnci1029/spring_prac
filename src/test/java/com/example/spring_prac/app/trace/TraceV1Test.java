package com.example.spring_prac.app.trace;

import org.junit.jupiter.api.Test;

class TraceV1Test {

    @Test
    void begin() {
        TraceV1 traceV1 = new TraceV1();
        TraceStatus begin = traceV1.begin("begin");
        TraceStatus beginSync = traceV1.beginSync(begin.getTraceId(), "begin");
        traceV1.end(beginSync);
        traceV1.end(begin);
    }

    @Test
    void exception() {
        TraceV1 traceV1 = new TraceV1();
        TraceStatus exception = traceV1.begin("exception");
        TraceStatus exceptionSync = traceV1.beginSync(exception.getTraceId(),"exception");
        traceV1.exception(exceptionSync,new IllegalStateException("예외 발생"));
        traceV1.exception(exception,new IllegalStateException("예외 발생"));

    }

}