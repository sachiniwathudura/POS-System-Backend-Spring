package lk.ijse.posspringbackend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/healthCheck")
public class HealthCheckController {
    public String healthCheck(){
        return "POS SYSTEM BACKEND IS RUNNING";
    }
}
