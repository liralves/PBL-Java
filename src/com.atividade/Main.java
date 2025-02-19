package com.atividade.contabancaria;
import java.util.*;

public class Main {
    public static void main(String []args){
        int option;
        double value = 0;

        ContaCorrente conta = new ContaCorrente();
        ContaCorrente contaUm = new ContaCorrente();

        Scanner scan = new Scanner(System.in);

        System.out.printf("Insira o número da conta: \n");
        conta.setNumeroConta(scan.next());
        System.out.printf("Nome do Titular: \n");
        conta.setNomeTitular(scan.next());


        do {
            System.out.printf("\nO que deseja realizar?\n");
            System.out.printf("\n1 - Verificar saldo.\n");
            System.out.printf("\n2 - Depositar.\n");
            System.out.printf("\n3 - Sacar.\n");
            System.out.printf("\n4 - Transferir.\n");
            System.out.printf("\n0 - Encerrar programa.\n");
            option = scan.nextInt();

            switch(option){
                case 1:
                    System.out.printf("Seu saldo é %.2f", conta.getSaldo());
                    break;

                case 2:
                    System.out.printf("Insira o valor a ser depositado: \n");
                    value = scan.nextDouble();
                    if(value < 0){
                        System.out.printf("O valor depositado deve ser superior a 0.\n");
                    }else {
                        conta.depositar(value);
                        System.out.printf("\nSeu saldo é %.2f após o depósito\n", conta.getSaldo());
                        break;
                    }

                case 3:
                    System.out.printf("Quanto você quer sacar?");
                    value = scan.nextDouble();
                    conta.sacar(value);
                    System.out.printf("\nSeu saldo é %.2f após o saque\n", conta.getSaldo());
                    break;

                case 4:
                System.out.printf("Digite o número da conta que você quer transferir o valor:\n");
                String numeroContaDestino = scan.next();
                System.out.printf("Digite o valor a ser transferido:\n");
                value = scan.nextDouble();

                if (numeroContaDestino.equals(conta.getNumeroConta())) {
                    System.out.println("Você não pode transferir para sua própria conta.");
                } else if (numeroContaDestino.equals(contaUm.getNumeroConta())) {
                    conta.transferir(contaUm, value);
                } else {
                    System.out.println("Número de conta inválido.");
                }
                break;

                case 0:
                    System.out.println("Programa encerrado.");
                    break;
            }

        }while(option != 0);
    }
}
