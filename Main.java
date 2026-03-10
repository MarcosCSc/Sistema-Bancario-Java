import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner input = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("======= BANCO JAVA =======");
            System.out.println("1 - Criar conta");
            System.out.println("2 - Listar contas");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("5 - Transferir");
            System.out.println("6 - Consultar saldo");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 0:
                    break;
                case 1:
                    banco.criarConta();
                    break;
                case 2:
                    banco.listarContas();
                    break;
                case 3:
                    banco.depositar();
                    break;
                case 4:
                    banco.sacar();
                    break;
                case 5:
                    banco.transferir();
                    break;
                case 6:
                    banco.consultarSaldo();
                    break;
                default:
                    System.out.println("Opção inválida");
            }

        }
        while (opcao != 0);

        System.out.println("Saindo do sistema...");

    }

}
