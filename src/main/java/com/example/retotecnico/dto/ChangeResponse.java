package com.example.retotecnico.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChangeResponse {
    private double monto;
    private double montoConTipoCambio;
    private String monedaOrigen;
    private String monedaDestino;
    private double tipoCambio;
}
