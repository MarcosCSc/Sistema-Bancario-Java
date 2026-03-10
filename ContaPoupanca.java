// Classe ContaPoupanca HERDA de Conta
public class ContaPoupanca extends Conta {

    // Percentual de rendimento
    private double taxaRendimento = 0.05; // 5%

    // Construtor
    public ContaPoupanca(String titular, double saldoInicial) {
        super(titular, saldoInicial);
    }

    // Sobrescrita do método
    @Override
    public void calcularRendimento() {
        // Calcula o valor do rendimento
        double rendimento = saldo * taxaRendimento;

        // Adiciona rendimento ao saldo
        saldo += rendimento;

        System.out.println("Rendimento aplicado: R$ " + rendimento);
    }
}