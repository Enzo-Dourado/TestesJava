package Models;

import java.util.Scanner;

public class RodarPrograma {
    public void rodaPrograma() {
        Scanner sc = new Scanner(System.in);
        Cliente[] listaClientes = new Cliente[20];
        String[] extratoBancario = new String[100];
        int idExtrato = 0;
        int id = 1;
        int opcao;
        int opcaoCliente;
        int opcaoClientePix;
        int opcaoLimite;

        System.out.println("*** Bem-vindo ao Banco ***");

        while (true) {
            Cliente cliente = new Cliente();
            System.out.println("\nSelecione uma opção que deseja realizar: ");
            System.out.println("""
                    1 - Cadastrar Cliente
                    2 - Depositar
                    3 - Sacar
                    4 - Emitir Saldo
                    5 - Emitir Limite
                    6 - Pix (Transferência entre Contas)
                    7 - Extrato bancário
                    8 - Sair
                    """);
            opcao = sc.nextInt();

            if (opcao == 8) {
                System.out.println("Fim do Programa, até logo!");
                break;

            } else if (opcao == 1) {
                System.out.println("*** Cadastro de Cliente ***\n");

                cliente.setId(id);

                System.out.print("Nome: ");
                cliente.setNome(sc.next());

                System.out.print("Agência: ");
                cliente.setAgencia(sc.next());

                System.out.print("Conta: ");
                cliente.setConta(sc.next());

                cliente.setSaldo(0);

                listaClientes[id] = cliente;
                id++;

                System.out.println("\n*** Novo Cliente Cadastrado com Sucesso! ***");
                extratoBancario[idExtrato] = "Cliente Cadastrado";
                idExtrato++;

            } else if (opcao == 2) {
                System.out.println("*** Depositos ***\n");
                for (int i = 1; i < id; i++) {
                    System.out.println("|ID: " + listaClientes[i].getId() + " | Nome: " + listaClientes[i].getNome() + " | Agência: " + listaClientes[i].getAgencia() +
                            " | Conta: " + listaClientes[i].getConta() + " | Saldo: " + listaClientes[i].getSaldo() + "|");
                }
                System.out.println("\nSelecione o ID do Cliente para o Depósito: ");
                opcaoCliente = sc.nextInt();

                System.out.println("Digite o valor que deseja Depositar: ");
                double deposito = sc.nextDouble();

                listaClientes[opcaoCliente].deposita(deposito);
                System.out.println("Depósito realizado com sucesso para " + listaClientes[opcaoCliente].getNome() + ", com conta de ID: " + listaClientes[opcaoCliente].getId());
                extratoBancario[idExtrato] = "Deposito Realizado para ID: " +  listaClientes[opcaoCliente].getId() ;
                idExtrato++;

            } else if (opcao == 3) {
                System.out.println("*** Saques ***\n");
                for (int i = 1; i < id; i++) {
                    System.out.println("|ID: " + listaClientes[i].getId() + " | Nome: " + listaClientes[i].getNome() + " | Agência: " + listaClientes[i].getAgencia() +
                            " | Conta: " + listaClientes[i].getConta() + " | Saldo: " + listaClientes[i].getSaldo() + " | Limite: "   + listaClientes[i].getLimite() + "|");
                }
                System.out.println("\nSelecione o ID do Cliente para o Saque: ");
                opcaoCliente = sc.nextInt();

                System.out.println("Digite o valor que deseja Sacar: ");
                double saque = sc.nextDouble();

                if (saque > listaClientes[opcaoCliente].getSaldo()) {
                    System.out.println("Saque não realizado, Saldo Insuficiente!");

                    System.out.println("Deseja utilizar seu Limite? 0 (não) | 1 (sim) ");
                    opcaoLimite =  sc.nextInt();

                    if (opcaoLimite == 1) {
                        listaClientes[opcaoCliente].sacaComLimite(saque);
                        System.out.println("Limite utlizado! $" + listaClientes[opcaoCliente].getLimite());
                    } else if (opcaoLimite == 2) {
                        System.out.println("Saque não realizado");
                        System.out.println("Saque $" + saque + " Saldo $" + listaClientes[opcaoCliente].getSaldo());

                    } else {
                        System.out.println("Opção não aceita!");
                    }

                } else {
                    listaClientes[opcaoCliente].saca(saque);
                    System.out.println("Saque realizado com sucesso para " + listaClientes[opcaoCliente].getNome() + ", com conta de ID: " + listaClientes[opcaoCliente].getId());
                    extratoBancario[idExtrato] = "Saque Realizado para ID: " +  listaClientes[opcaoCliente].getId() ;
                    idExtrato++;

                }
            } else if (opcao == 4) {
                System.out.println("*** Contas | Saldos ***\n");
                for (int i = 1; i < id; i++) {
                    System.out.println("|ID: " + listaClientes[i].getId() + " | Nome: " + listaClientes[i].getNome() + " | Agência: " + listaClientes[i].getAgencia() +
                            " | Conta: " + listaClientes[i].getConta() + " | Saldo: " + listaClientes[i].getSaldo() + "|");
                }
                extratoBancario[idExtrato] = "Emissão de Saldo";
                idExtrato++;

            } else if (opcao == 5) {
                System.out.println("*** Exibir Limites ***\n");
                for (int i = 1; i < id; i++) {
                    System.out.println("|ID: " + listaClientes[i].getId() + " | Nome: " + listaClientes[i].getNome() + " | Agência: " + listaClientes[i].getAgencia() +
                            " | Conta: " + listaClientes[i].getConta() + " | Saldo: " + listaClientes[i].getSaldo() + " | Limite: "   + listaClientes[i].getLimite() + "|");
                }
                extratoBancario[idExtrato] = "Emissão de Limite";
                idExtrato++;

            } else if (opcao == 6) {
                System.out.println("*** Pix ***");
                for (int i = 1; i < id; i++) {
                    System.out.println("|ID: " + listaClientes[i].getId() + " | Nome: " + listaClientes[i].getNome() + " | Agência: " + listaClientes[i].getAgencia() +
                            " | Conta: " + listaClientes[i].getConta() + " | Saldo: " + listaClientes[i].getSaldo() + "|");
                }
                System.out.println("Digite o ID da conta que ira TRANSFERIR: ");
                opcaoCliente = sc.nextInt();

                System.out.println("Digite o ID da conta que ira RECEBER: ");
                opcaoClientePix = sc.nextInt();

                if (opcaoCliente == opcaoClientePix) {
                    System.out.println("Não é possível realizar PIX para o mesmo ID");

                } else {
                    System.out.println("Digite o Valor que deseja Transferir: ");
                    double valorPix = sc.nextDouble();

                    if (valorPix > listaClientes[opcaoCliente].getSaldo()) {
                        System.out.println("Valor Insuficiente! Pix não Realizado!");

                    } else {
                        listaClientes[opcaoCliente].saca(valorPix);
                        listaClientes[opcaoClientePix].deposita(valorPix);
                        System.out.println("Pix realizado com sucesso de " + listaClientes[opcaoCliente].getNome() + " para " + listaClientes[opcaoClientePix].getNome());
                        extratoBancario[idExtrato] = "Pix realizado com sucesso de " + listaClientes[opcaoCliente].getNome() + " para " + listaClientes[opcaoClientePix].getNome() + " no valor de $" + valorPix;
                        idExtrato++;
                    }
                }
            } else if (opcao == 7) {
                System.out.println("*** Extrato bancário ***");
                for (int i = 0; i < idExtrato; i++) {
                    if (extratoBancario[i] != null) {
                        System.out.println("| ID Extrato: " + i + " | Extrato: " + extratoBancario[i] + " |");
                    }
                }
            }
        }
        sc.close();
    }
}
