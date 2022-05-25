package Main;


import Main.entities.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Operacao operacao = new Operacao();

        System.out.println("Bem vindo!");
        operacao.criarConta();
        int cont = 0;
        do {
            System.out.println("\n" + "Digite 1 se deseja logar na Conta" + "\n" +
                    "Digite 2 se deseja sair");
            cont = sc.nextInt();
        } while ((cont < 1) && (cont > 2));


        if (cont == 1)
            operacao.logarClienteConta();


        System.out.println("Operação Encerrada");
    }


}