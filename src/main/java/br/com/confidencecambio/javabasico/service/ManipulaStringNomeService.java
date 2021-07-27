package br.com.confidencecambio.javabasico.service;

import br.com.confidencecambio.javabasico.exception.IncorrectNameException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ManipulaStringNomeService {

    private boolean vazioOuNulo(String nome) {
        if (Optional.ofNullable(nome).isEmpty()) {
            return true;
        }

        if ("".equals(nome)) {
            return true;
        }

        return false;
    }

    private String removerEspacosVazios(String nome) {
        return nome.trim();
    }

    public String pegarPrimeiroNome(String nome) throws IncorrectNameException {
        if(this.vazioOuNulo(nome)) {
            throw new IncorrectNameException("Nome não pode ser vazio ou nulo");
        }

        nome = removerEspacosVazios(nome);

        String[] split = nome.split(" ");
        return split[0];
    }

    public String pegarUltimoNome(String nome) throws IncorrectNameException {
        if(this.vazioOuNulo(nome)) {
            throw new IncorrectNameException("Nome não pode ser vazio ou nulo");
        }

        nome = removerEspacosVazios(nome);

        String[] split = nome.split(" ");

        if (split.length > 1) {
            StringBuilder ultimoNome = new StringBuilder();

            for (int i=1; i<split.length; i++ ) {
                ultimoNome.append(split[i] + " ");
            }

            return ultimoNome.toString().trim();
        }

        return nome;
    }

    public String retornaNomeLetrasMaiusculas(String nome) throws IncorrectNameException {
        if(this.vazioOuNulo(nome)) {
            throw new IncorrectNameException("Nome não pode ser vazio ou nulo");
        }

        nome = removerEspacosVazios(nome);

        return nome.toUpperCase();
    }

    public String retornaNomeAbreviado(String nome) throws IncorrectNameException {
        if(this.vazioOuNulo(nome)) {
            throw new IncorrectNameException("Nome não pode ser vazio ou nulo");
        }

        nome = removerEspacosVazios(nome);

        String[] split = nome.split(" ");

        if (split.length > 1) {

            StringBuilder nomeAbrev = new StringBuilder();

            for (int i=1; i < split.length - 1; i++ ) {
                nomeAbrev.append(split[i].charAt(0) + ". ");
            }

            return split[0] + " " + nomeAbrev.toString().trim() + " " + split[split.length - 1];
        }

        return nome;
    }

}
