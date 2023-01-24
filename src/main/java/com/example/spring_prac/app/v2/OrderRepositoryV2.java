package com.example.spring_prac.app.v2;

import com.example.spring_prac.app.trace.TraceStatus;
import com.example.spring_prac.app.trace.TraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV2 {

    private final TraceV1 trace;
    public void save(String itemId, String id) {
        TraceStatus status = null;
        try {
            status = trace.beginSync(status.getTraceId(), "저장");
            if (itemId.equals("ex")) {
                throw new IllegalStateException("예외발생!");
            }
            sleep(1000);
        } catch (Exception e) {
            trace.exception(status,e);
            throw e;
        }

    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
