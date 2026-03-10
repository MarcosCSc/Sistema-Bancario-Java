import java.util.ArrayList;
import java.util.Scanner;

public class Banco {
    private ArrayList<Conta> contas = new ArrayList<Conta>();
    private Scanner input = new Scanner(System.in);

    public void criarConta() {
        System.out.print("Nome do titular da conta: ");
        String titular = input.nextLine();

        System.out.print("Saldo inicial: ");
        double saldo = input.nextDouble();
        input.nextLine();

        System.out.println("Tipo de conta: ");
        System.out.println("1 - Conta Corrente");
        System.out.println("2 - Conta Poupança");
        int tipo = input.nextInt();
        input.nextLine();

        if (tipo == 1) {
            Conta novaConta = new ContaCorrente(titular, saldo);
            contas.add(novaConta);
            System.out.println("Conta Corrente criada com sucesso!");
            System.out.println();
        }
        else if (tipo == 2) {
            Conta novaConta = new ContaPoupanca(titular, saldo);
            contas.add(novaConta);
            System.out.println("Conta Poupança criada com sucesso!");
            System.out.println();
        }
        else {
            System.out.println("Tipo de conta invalido!");
            System.out.println();
        }
    }

    public void listarContas() {
        //Para verificar se a lista ta vazia.
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta foi encontrada!");
            System.out.println();
            return;
        }

        for (Conta conta : contas) {
            //chamando o metodo exibirDados da classe conta
            conta.exibirDados();
        }
        System.out.println();
    }

    public void depositar() {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta foi encontrada!");
            System.out.println();
            return;
        }
        System.out.println("Escolha a conta: ");
        for (int i = 0; i < contas.size(); i++) {
            //esse contas.get(i) serve para pegar a conta na posicao conforme o for
            System.out.println(i + " - " + contas.get(i).titular);
        }
        //vai digitar o indice da conta que deseja acessar e salvar numa variavel
        int num_conta = input.nextInt();
        input.nextLine();

        //utiliza a variavel para acessar a conta especifica
        Conta conta = contas.get(num_conta);
        System.out.println("Valor para depositar: ");
        double valor = input.nextDouble();
        input.nextLine();

        //para chamar o metodo depositar na classe Conta.
        conta.depositar(valor);
        System.out.println("Valor depositado com sucesso!");
        System.out.println();
    }

    public void sacar() {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta foi encontrada!");
            return;
        }

        System.out.println("Escolha a conta: ");
        for (int i = 0; i < contas.size(); i++) {
            System.out.println(i + " - " + contas.get(i).titular);
        }
        int num_conta = input.nextInt();
        input.nextLine();

        Conta conta = contas.get(num_conta);
        System.out.println("Valor para sacar: ");
        double valor = input.nextDouble();
        input.nextLine();

        conta.sacar(valor);
        System.out.println("Valor sacado com sucesso!");
        System.out.println();
    }

    public void transferir() {
        //verificar se tem alguma conta
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta foi encontrada!");
            return;
        }
        //Listar todas as contas existentes e perguntar a conta de origem pra transf.
        System.out.println("Escolha a conta de origem: ");
        for (int i = 0; i < contas.size(); i++) {
            System.out.println(i + " - " + contas.get(i).titular);
        }
        int conta_origem = input.nextInt();
        input.nextLine();

        //Lista todas as contas novamente e pergunta a conta de destino da transf.
        System.out.println("Escolha a conta de destino: ");
        for (int i = 0; i < contas.size(); i++) {
            System.out.println(i + " - " + contas.get(i).titular);
        }
        int conta_destino = input.nextInt();
        input.nextLine();

        //Criacao das variaveis de conta de origem e destino, pegando as informacoes delas com o get. e dps pergunta o valor da transf.
        Conta contaOrigem = contas.get(conta_origem);
        Conta contaDestino = contas.get(conta_destino);
        System.out.println("Informe o valor da transferencia: ");
        double valor = input.nextDouble();
        input.nextLine();

        //Utilizando os metodos nas variaveis criadas de conta origem e destino.
        contaOrigem.sacar(valor);
        contaDestino.depositar(valor);
        System.out.println("Transferencia realizada com sucesso!");
        System.out.println();
    }

    public void consultarSaldo() {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta foi encontrada!");
            return;
        }

        System.out.println("Escolha a conta que deseja consultar: ");
        for (int i = 0; i < contas.size(); i++) {
            System.out.println(i + " - " + contas.get(i).titular);
        }
        int num_conta = input.nextInt();
        input.nextLine();

        Conta conta = contas.get(num_conta);
        conta.exibirDados();
        System.out.println();
    }
}
