package com.example.retotecnico.controller;

import com.example.retotecnico.dto.ChangeResponse;
import com.example.retotecnico.service.ChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ChangeController {
    @Autowired
    private ChangeService changeService;

    @GetMapping("/exchange")
    public ResponseEntity<ChangeResponse> getExchangeRate(
            @RequestParam double monto,
            @RequestParam String monedaOrigen,
            @RequestParam String monedaDestino) {

        ChangeResponse response = changeService.applyExchangeRate(monto, monedaOrigen, monedaDestino);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/exchange-rate")
    public ResponseEntity<String> updateExchangeRate(
            @RequestParam String monedaOrigen,
            @RequestParam String monedaDestino,
            @RequestParam double tipoCambio) {

        changeService.updateExchangeRate(monedaOrigen, monedaDestino, tipoCambio);
        return ResponseEntity.ok("Tipo de cambio actualizado exitosamente");
    }
}
