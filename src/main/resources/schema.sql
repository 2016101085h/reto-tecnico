DROP TABLE IF EXISTS changes;
CREATE TABLE changes (
                                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                moneda_origen VARCHAR(3) NOT NULL,
                                moneda_destino VARCHAR(3) NOT NULL,
                                tipo_cambio DOUBLE NOT NULL
);