package com.example.spring_prac.app.v2;

import com.example.spring_prac.app.trace.TraceId;
import com.example.spring_prac.app.trace.TraceStatus;
import com.example.spring_prac.app.trace.TraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class OrderServiceV2 {
    private final OrderRepositoryV2 orderRepositoryV2;
    private final TraceV1 trace;

    public void orderItem(TraceId traceId, String itemId) {
        TraceStatus status = null;
        try {
            status = trace.beginSync(traceId,"시작");
            orderRepositoryV2.save(traceId.getId(),itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }

    }
}
