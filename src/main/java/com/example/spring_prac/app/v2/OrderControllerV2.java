package com.example.spring_prac.app.v2;

import com.example.spring_prac.app.trace.TraceStatus;
import com.example.spring_prac.app.trace.TraceV0;
import com.example.spring_prac.app.trace.TraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequiredArgsConstructor
public class OrderControllerV2 {

    private final OrderServiceV2 orderServiceV2;
    private final TraceV1 trace;

    @GetMapping("/v2/request")
    public String request(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("시작");
            orderServiceV2.orderItem(status.getTraceId(),itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
        return "ok";
    }
}
