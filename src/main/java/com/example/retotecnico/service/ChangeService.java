package com.example.retotecnico.service;

import com.example.retotecnico.dto.ChangeResponse;
import com.example.retotecnico.entity.Change;
import com.example.retotecnico.repository.ChangeRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChangeService {

    @Autowired
    private ChangeRepository changeRepository;



    public ChangeResponse applyExchangeRate(double monto, String monedaOrigen, String monedaDestino) {

        Optional<Change> exchangeRateOptional = changeRepository.findByMonedaOrigenAndMonedaDestino(monedaOrigen, monedaDestino);

        if (!exchangeRateOptional.isPresent()) {
            throw new IllegalArgumentException("Tipo de cambio no encontrado para las monedas especificadas");
        }

        double tipoCambio = exchangeRateOptional.get().getTipoCambio();
        double montoConTipoCambio = monto * tipoCambio;

        return new ChangeResponse(monto, montoConTipoCambio, monedaOrigen, monedaDestino, tipoCambio);
    }

    @Transactional
    public void updateExchangeRate(String monedaOrigen, String monedaDestino, double tipoCambio) {
        Change exchangeRate = changeRepository.findByMonedaOrigenAndMonedaDestino(monedaOrigen, monedaDestino)
                .orElse(new Change(monedaOrigen, monedaDestino, tipoCambio));
        exchangeRate.setTipoCambio(tipoCambio);
        changeRepository.save(exchangeRate);
    }
}
