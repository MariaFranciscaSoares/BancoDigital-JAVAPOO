package Main.entities;


import java.util.Scanner;

public class Operacao {
    Scanner sc = new Scanner(System.in);
    Cliente dados = new Cliente();
    Banco banco = new Banco();
    ContaCorrente contaCorrente = new ContaCorrente(dados);
    ContaPoupanca contaPoupanca = new ContaPoupanca(dados);

    public void criarConta() {

        System.out.println("Digite o Nome do Cliente para cadastro: ");
        String nome = sc.nextLine();
        System.out.println("Digite o CPF do Cliente para cadastro: ");
        String cpf = sc.nextLine();
        dados.setNome(nome);
        dados.setCpf(cpf);

        int numero;
        do {
            System.out.println("Digite 1 para Criação das Contas Corrente e Poupança!" + "\n" +
                    "Digite 2 para Sair!" + "\n");
            numero = sc.nextInt();

            if (numero == 1) {
                Conta contaCorrente = new ContaCorrente(dados);
                banco.incluirConta(contaCorrente);
                System.out.println("Conta Corrente Criada com Sucesso.");
                Conta contaPoupanca = new ContaPoupanca(dados);
                banco.incluirConta(contaPoupanca);
                System.out.println("Conta Poupança Criada com Sucesso.");
            } else if (numero == 2) {
                break;
            } else System.out.println("Numero Invalido - Digite Novamente: ");

        } while ((numero < 0) && (numero > 2));
    }

    public void logarClienteConta() {
        System.out.println("---Login---");
        int verificarCadastro = banco.buscarCliente(); // metodo buscar cliente retorna 1 se encontrar o cliente na base; 0  caso não encontre.
        int selecionarConta;
        if (verificarCadastro == 1) {
            System.out.println("CPF Correto!");
            do {
                System.out.println("Digite 1 - para entrar na conta corrente.");
                System.out.println("Digite 2 para entrar na conta poupança.");
                selecionarConta = sc.nextInt();
            } while ((selecionarConta < 1) && (selecionarConta > 2));
            operacaoesConta(selecionarConta);
        } else criarConta();

    }

    public void operacaoesConta(int idConta) {

        int selecionarOperacao = 0;

        int cont = 1;
        do {
            if (idConta == 1)
                System.out.println("----Conta Corrente----");
            else if (idConta == 2)
                System.out.println("----Conta Poupança----");

            do {
                System.out.println("Digite 1 para imprimir extrato: ");
                System.out.println("Digite 2 para efetuar um Deposito: ");
                System.out.println("Digite 3 para efetuar uma trasferencia para Poupança ou criar conta: ");
                System.out.println("Digite 4 para sacar dinheiro: ");
                System.out.println("Digite 5 para SAIR.");
                selecionarOperacao = sc.nextInt();
            } while ((selecionarOperacao < 1) && (selecionarOperacao > 5));

            switch (selecionarOperacao) {
                case 1:
                    extratoConta(idConta);
                    break;
                case 2:
                    System.out.println("Digite o Valor que deseja Depositar - Conta Corrente");
                    double deposito = sc.nextDouble();
                    depositoConta(idConta, deposito);
                    break;
                case 3:
                    System.out.println("Digite o Valor que deseja transferir da Conta Corrente para a Poupança.");
                    double trasferencia = sc.nextDouble();
                    transferenciaConta(idConta, trasferencia);
                    break;
                case 4:
                    System.out.println("Digite o Valor que deseja Sacar: ");
                    double saque = sc.nextDouble();
                    saqueConta(idConta, saque);
                    break;
                default:
                    break;
            }

            do {
                System.out.println("Digite 1 para fazer outra Operação ou Digite 0 para SAIR.");
                cont = sc.nextInt();
            } while ((cont < 0) && (cont > 2));


        } while ((cont > 0) | (selecionarOperacao < 5));

    }

    public void extratoConta(int conta) {
        if (conta == 1)
            contaCorrente.imprimirExtrato();
        else if (conta == 2)
            contaPoupanca.imprimirExtrato();
    }

    public void depositoConta(int conta, double deposito) {
        if (conta == 1)
            contaCorrente.depositar(deposito);
        else if (conta == 2)
            contaPoupanca.depositar(deposito);
    }

    public void transferenciaConta(int conta, double trasferencia) {
        if (conta == 1)
            contaCorrente.trasferir(trasferencia, contaPoupanca);
        else if (conta == 2)
            contaPoupanca.trasferir(trasferencia, contaCorrente);
    }

    public void saqueConta(int conta, double saque) {
        if (conta == 1)
            contaCorrente.sacar(saque);
        else if (conta == 2)
            contaPoupanca.sacar(saque);
    }
}




