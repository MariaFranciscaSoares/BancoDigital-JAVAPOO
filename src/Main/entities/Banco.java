package Main.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Banco {

    Scanner sc = new Scanner(System.in);
    protected List<Conta> contas = new ArrayList<Conta>();

    public void incluirConta(Conta conta) {
        contas.add(conta);
    }

    public List<Conta> getLista(Conta conta) {
        return contas;
    }

    public int buscarCliente() {

        String cpf;
        int cont = 0;
        int voltar = 0;

        do {
            System.out.println("Digite seu CPF para identificação sem '.' e '-'.");
            cpf = sc.next();

            for (Conta conta : contas) {
                if (conta.cliente.getCpf().equals(cpf)) {
                    cont = 1;
                } else {
                    do {
                        System.out.println("CPF Incorreto - Digite 1 para Inserir CPF novamente ou Digite 2 para efetuar o Cadastro");
                        voltar = sc.nextInt();
                    } while ((voltar != 1) && (voltar != 2));

                }

            }
        } while ((cont == 0) | (voltar > 1));
        return cont;
    }


}


