package br.com.confidencecambio.javabasico.service;

import br.com.confidencecambio.javabasico.entity.Cliente;
import br.com.confidencecambio.javabasico.entity.Gerente;
import br.com.confidencecambio.javabasico.entity.Robo;
import br.com.confidencecambio.javabasico.exception.IncorrectNameException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.Assert.*;

public class ManipulaStringNomeServiceTest {

    @MockBean
    private ManipulaStringNomeService service;

    @Before
    public void init(){
        service= new ManipulaStringNomeService();
    }

    @Test(expected = IncorrectNameException.class)
    public void quandoPassarNomeNuloRetornaError() throws IncorrectNameException {

        Cliente cliente = new Cliente();
        cliente.setNome(null);
        service.retornaNomeAbreviado(cliente.getNome());
    }

    @Test(expected = IncorrectNameException.class)
    public void quandoPassarNomeVazioRetornaError() throws IncorrectNameException {

        Cliente cliente = new Cliente();
        cliente.setNome("");
        service.retornaNomeAbreviado(cliente.getNome());
    }

    @Test
    public void quandoPassarNomeComEspacoRetornaNomeMaiusculo() throws IncorrectNameException {

        Robo robo = new Robo();
        robo.setNome("xpto 47l  ");

        String expected = "XPTO 47L";

        String retorno = service.retornaNomeLetrasMaiusculas(robo.getNome());
        assertEquals(expected, retorno);
    }

    @Test
    public void quandoPassarNomeClienteRetornaPrimeiroNome() throws IncorrectNameException {

        Cliente cliente = new Cliente();
        cliente.setNome("João Soares Silva");

        String expected = "João";

        String retorno = service.pegarPrimeiroNome(cliente.getNome());
        assertEquals(expected, retorno);
    }

    @Test
    public void quandoPassarNomeGerenteRetornaUltimoNome() throws IncorrectNameException {

        Gerente gerente = new Gerente();
        gerente.setNome("Tales Santana de Paula");

        String expected = "Santana de Paula";

        String retorno = service.pegarUltimoNome(gerente.getNome());
        assertEquals(expected, retorno);
    }

    @Test
    public void quandoPassarNomeRoboRetornaNomeMaiusculo() throws IncorrectNameException {

        Robo robo = new Robo();
        robo.setNome("xpto 47l");

        String expected = "XPTO 47L";

        String retorno = service.retornaNomeLetrasMaiusculas(robo.getNome());
        assertEquals(expected, retorno);
    }

    @Test
    public void quandoPassarNomeRoboRetornaNomeAbreviado() throws IncorrectNameException {

        Cliente cliente = new Cliente();
        cliente.setNome("Thiago Carvalho Souza");

        String expected = "Thiago C. Souza";

        String retorno = service.retornaNomeAbreviado(cliente.getNome());
        assertEquals(expected, retorno);
    }


}
