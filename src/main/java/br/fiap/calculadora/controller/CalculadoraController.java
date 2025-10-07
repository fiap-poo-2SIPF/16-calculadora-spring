package br.fiap.calculadora.controller;

import br.fiap.calculadora.service.CalculadoraService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
public class CalculadoraController {

    private CalculadoraService service;

    public CalculadoraController(CalculadoraService service) {

        this.service = service;
    }

    @PostMapping("/calcular")
    public String calcular(@RequestParam String valor1,
                           @RequestParam String valor2,
                           @RequestParam String operacao,
                           Model model)
    {
        String erro = "";
        BigDecimal resultado = null;

        try {
            resultado = service.calcular(valor1, valor2, operacao);
        } catch (Exception e) {
            erro = e.getMessage();
        }
        model.addAttribute("valor1", valor1);
        model.addAttribute("valor2", valor2);
        model.addAttribute("resultado", resultado);
        model.addAttribute("erro", erro);
        model.addAttribute("operacao", operacao);
        return "index";
    }
}
