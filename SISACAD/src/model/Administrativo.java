package model;

import exception.SalarioInvalidoException;

import java.text.NumberFormat;
import java.util.Locale;

public class Administrativo extends Pessoa {
    private double salario;

    public Administrativo(String nome, String cpf, String matricula, double salario) throws SalarioInvalidoException {
        super(nome, cpf, matricula);
        if(salario < 0) {
            throw new SalarioInvalidoException("O salário de professores e funcionários não pode ser menor do que zero.");
        }
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) throws SalarioInvalidoException {
        if(salario < 0) {
            throw new SalarioInvalidoException("O salário de professores e funcionários não pode ser menor do que zero.");
        }
        this.salario = salario;
    }

    @Override
    public String toString() {
        Locale currentLocale = new Locale("pt", "BR");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(currentLocale);
        String info = super.toString()
        + "\nSalário: " + currencyFormatter.format(getSalario());;
        return info;
    }

}
