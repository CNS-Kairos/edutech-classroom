package com.edutech.classroom.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-support-ticket", url = "http://localhost:8080/api/support-tickets")
public interface SupportTicketClient {
    @GetMapping("/{id}")
    Object getSupportTicketById(@PathVariable("id") String id);
}
