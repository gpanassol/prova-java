package br.com.confidencecambio.javabasico.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.math.MathContext;

import static org.junit.Assert.assertEquals;

public class IMCServiceTest {

    @MockBean
    private IMCService service;

    private final MathContext mc = new MathContext(4);

    @Before
    public void init(){
        service= new IMCService();
    }

    @Test
    public void quandoPassarValoresPesoAlturaQueroRetornaIMC(){

        var expected = new BigDecimal(36.93, mc);
        var peso = new BigDecimal(121);
        var altura = new BigDecimal(1.81);

        BigDecimal imc = service.retornaIMC(peso, altura);
        assertEquals(expected, imc);
    }
}
