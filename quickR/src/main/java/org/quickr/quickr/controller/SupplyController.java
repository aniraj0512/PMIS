package com.example.quickrelief;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class SupplyController {

    private final SupplyService service;

    public SupplyController(SupplyService service) {
        this.service = service;
    }

    @PostMapping("/supplies")
    public ResponseEntity<?> addSupply(@RequestBody SupplyInput input) {
        service.addSupply(input.itemName(), input.quantity());
        return ResponseEntity.ok(
                Map.of("message", "Supply added/restocked successfully"));
    }

    @GetMapping("/supplies")
    public List<Supply> getSupplies() {
        return service.getSupplies();
    }

    @PostMapping("/requests")
    public ResponseEntity<?> requestSupply(
            @RequestBody SupplyRequest request) {
        service.requestSupply(request);
        return ResponseEntity.ok(
                Map.of("message", "Supply request approved"));
    }
}