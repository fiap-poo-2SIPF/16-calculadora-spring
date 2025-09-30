package br.fiap.calculadora.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculadoraService {
    public BigDecimal calcular(String valor1, String valor2, String operacao) {
        BigDecimal v1 = toBigDecimal(valor1);
        BigDecimal v2 = toBigDecimal(valor2);

        return switch(operacao) {
            case "soma" -> v1.add(v2);
            case "subtracao" -> v1.subtract(v2);
            case "divisao" -> {
                if(v2.compareTo(BigDecimal.ZERO) == 0) {
                    throw new IllegalArgumentException("O segundo valor deve ser diferente de zero");
                }
                v1.divide(v2);
            }
        }

    }
}
