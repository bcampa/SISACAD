package repository;

import exception.SalarioInvalidoException;
import model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PessoaRepository {

    static private List<Pessoa> pessoaList;

    static {
        pessoaList = new ArrayList<Pessoa>();
        List<Curso> cursoList = new ArrayList<Curso>();
        Curso c1 = new Curso("Java Web", 250);
        Curso c2 = new Curso("UML", 250);
        cursoList.add(c1);
        cursoList.add(c2);
        Aluno p1 = new Aluno("Bruno", "11144466605", "1");
        p1.setCursos(cursoList);
        Pessoa p2 = new Aluno("Pedro", "11122233344", "2");
        Pessoa p3 = new Aluno("David", "55566677788", "3");
        pessoaList.add(p1);
        pessoaList.add(p2);
        pessoaList.add(p3);
        try {
            Professor p4 = new Professor("Eduardo", "22233344477", "4", 24000.00);
            p4.setCursos(cursoList);
            p4.calcularSalario();
            pessoaList.add(p4);
        } catch (SalarioInvalidoException e) {
            e.printStackTrace();
        }
        try {
            Pessoa p5 = new Administrativo("André", "55566633322", "5", 30000.00);
            pessoaList.add(p5);
        } catch (SalarioInvalidoException e) {
            e.printStackTrace();
        }
        Collections.sort(pessoaList);
    }

    public List<Pessoa> findAll() {
        return pessoaList;
    }

    public void save(Pessoa pessoa) {
        pessoaList.add(pessoa);
    }

    public void delete(String matricula) {
        Iterator it = pessoaList.iterator();
        while(it.hasNext()) {
            Pessoa corrente = (Pessoa) it.next();
            if(matricula.equals(corrente.getMatricula())) {
                pessoaList.remove(corrente);
            }
        }
    }

    public Pessoa getByMatricula(String matricula) {
        Iterator it = pessoaList.iterator();
        while(it.hasNext()) {
            Pessoa corrente = (Pessoa) it.next();
            if(matricula.equals(corrente.getMatricula())) {
                return corrente;
            }
        }
        return null;
    }

}
