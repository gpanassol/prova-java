package br.com.confidencecambio.javabasico.controller;

import br.com.confidencecambio.javabasico.service.IMCService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;

@RestController
@RequestMapping("/v1")
public class IMCController {

    private IMCService service;

    public IMCController(final IMCService service) {
        this.service = service;
    }

    @RequestMapping(value = "/imc", method = RequestMethod.GET)
    public ResponseEntity<BigDecimal> getImc(@RequestParam(value = "peso", required = true) BigDecimal peso,
                                         @RequestParam(value = "altura", required = true) BigDecimal altura) {
        var retorno = service.retornaIMC(peso, altura);
        return new ResponseEntity<>(retorno, HttpStatus.OK);
    }
}
