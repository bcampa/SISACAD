package model;

public abstract class Pessoa implements Comparable<Pessoa> {
    private String nome;
    private String cpf;
    private String matricula;

    public Pessoa(String nome, String cpf, String matricula) {
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public int compareTo(Pessoa p) {
        return getNome().compareTo(p.getNome());
    }

    @Override
    public String toString() {
        String info = "Nome: " + getNome()
        + "\nCPF: " + getCpf()
        + "\nMatrícula: " + getMatricula();
        return info;
    }
}
