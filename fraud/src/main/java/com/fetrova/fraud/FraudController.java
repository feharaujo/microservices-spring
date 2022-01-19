package com.fetrova.fraud;

import com.fetrova.clients.fraud.FraudCheckResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/fraud-check")
@AllArgsConstructor
public class FraudController {

    private final FraudCheckHistoryService service;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId) {
        var isFraudster = service.isFraudulentCustomer(customerId);

        log.info("Fraud check, request for customer {}", customerId);

        return new FraudCheckResponse(isFraudster);
    }

}
