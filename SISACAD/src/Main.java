import model.Pessoa;
import repository.PessoaRepository;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Consultar dados de uma pessoa:");
        String input = sc.nextLine();
        sc.close();
        PessoaRepository rep = new PessoaRepository();
        Pessoa pessoa = rep.getByMatricula(input);
        if(pessoa != null) {
            System.out.println(pessoa);
        } else {
            System.out.println("não houve dados encontrados");
        }
    }
}
