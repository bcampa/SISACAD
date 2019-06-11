package model;

import exception.SalarioInvalidoException;

import java.text.NumberFormat;
import java.util.*;

public class Professor extends Pessoa {
    private List<Curso> cursos;
    private double salario;
    private final double VALORHORAAULA;

    public Professor(String nome, String cpf, String matricula, double salario) throws SalarioInvalidoException {
        super(nome, cpf, matricula);
        if(salario < 0) {
            throw new SalarioInvalidoException("O salário de professores e funcionários não pode ser menor do que zero.");
        }
        this.salario = salario;
        this.cursos = new ArrayList<Curso>();
        this.VALORHORAAULA = 50;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
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

    public double calcularSalario() throws SalarioInvalidoException {
        int totalHoras = 0;
        Iterator it = cursos.iterator();
        while(it.hasNext()) {
            Curso corrente = (Curso) it.next();
            totalHoras += corrente.getDuracaoHoras();
        }
        setSalario(totalHoras * VALORHORAAULA);
        return getSalario();
    }

    @Override
    public String toString() {
        String info = super.toString()
        + "\nCursos:";
        Iterator it = cursos.iterator();
        while(it.hasNext()) {
            Curso corrente = (Curso) it.next();
            info += "\n\t" + corrente.getNome();
        }
        Locale currentLocale = new Locale("pt", "BR");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(currentLocale);
        info += "\nSalário: " + currencyFormatter.format(getSalario());
        return info;
    }

}
