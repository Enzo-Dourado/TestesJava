import java.util.Scanner;

public class Desafio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nome, tipoConta;
        boolean dadosCorretos;
        double saldo;
        int operacao = 0;
        String asterisco = "*****************************************";
        String iguais = "===================================================================";

        System.out.println(iguais);
        System.out.println("Bem-Vindo ao seu banco, para iniciar, digite seus dados a seguir... ");
        System.out.println(iguais);

        System.out.print("Nome: ");
        nome = sc.nextLine();
        System.out.print("Tipo de Conta (Poupança ou Corrente): ");
        tipoConta = sc.nextLine();
        System.out.print("Saldo inicial: ");
        saldo = sc.nextDouble();

        tipoConta = tipoConta.toLowerCase();

        if (tipoConta.equals("poupanca") || tipoConta.equals("corrente") && saldo > 0) {
            System.out.println("Dados salvos com sucesso!");
            dadosCorretos = true;
        } else {
            System.out.println("Você digitou um tipo de conta que não foi encontrado ou um saldo negativo!");
            dadosCorretos = false;
        }

        if (dadosCorretos) {
            System.out.println(asterisco);
            System.out.println("===== DADOS DA CONTA =====");
            System.out.println("Nome: " + nome);
            System.out.println("Tipo da Conta: " + tipoConta);
            System.out.println("Saldo: " + saldo);
            System.out.println(asterisco);
        }

        while (dadosCorretos && operacao != 4) {
            System.out.format(""" 
                    ===== OPERAÇÕES =====
                    1 - Consultar Dados
                    2 - Depósito
                    3 - Transferência
                    4 - Sair
                    """);
            System.out.println(asterisco);
            System.out.print("Operação: ");
            operacao = sc.nextInt();

            if (operacao == 1) {
                System.out.println(asterisco);
                System.out.println("===== DADOS DA CONTA =====");
                System.out.println("Nome: " + nome);
                System.out.println("Tipo da Conta: " + tipoConta);
                System.out.println("Saldo: " + saldo);
                System.out.println(asterisco);

            } else if (operacao == 2) {
                System.out.println(asterisco);
                System.out.println("===== DEPÓSITOS =====");
                System.out.print("Digite o valor que deseja depositar: ");
                double deposito = sc.nextDouble();
                saldo += deposito;
                System.out.println("Depósito realizado com sucesso!");
                System.out.println("Novo Saldo: " + saldo);
                System.out.println(asterisco);

            } else if (operacao == 3) {
                System.out.println(asterisco);
                System.out.println("===== TRANSFERÊNCIAS =====");
                System.out.print("Digite o valor que deseja transferir: ");
                double transferencia = sc.nextDouble();

                if (transferencia < saldo) {
                    saldo -= transferencia;
                    System.out.println("Transferência realizada com sucesso!");
                    System.out.println("Novo Saldo: " + saldo);

                } else {
                    System.out.println("Transferência não realizada, SALDO INSUFICIENTE!");
                }
                System.out.println(asterisco);

            } else if (operacao == 4) {
                System.out.println("Operações encerradas, até breve...");

            }
        }
    }
}
