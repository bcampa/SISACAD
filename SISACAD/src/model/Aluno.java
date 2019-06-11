package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Aluno extends Pessoa {
    private List<Curso> cursos;

    public Aluno(String nome, String cpf, String matricula) {
        super(nome, cpf, matricula);
        this.cursos = new ArrayList<Curso>();
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    @Override
    public String toString() {
        String info = super.toString()
        + "\nCursos:";
        Iterator it = cursos.iterator();
        while (it.hasNext()) {
            Curso corrente = (Curso) it.next();
            info += "\n\t" + corrente.getNome();
        }
        return info;
    }

}
