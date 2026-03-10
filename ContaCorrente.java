
public class ContaCorrente extends Conta {

        // Taxa fixa mensal da conta corrente
        private double taxaManutencao = 20.0;

        // Construtor
        public ContaCorrente(String titular, double saldoInicial) {
            // "super" chama o construtor da classe mãe
            super(titular, saldoInicial);
        }

        // Sobrescrita do método da classe base
        // @Override indica que estamos modificando o comportamento herdado
        @Override
        public void calcularRendimento() {
            saldo -= taxaManutencao; // Desconta taxa ao invés de render juros
            System.out.println("Taxa de manutenção descontada: R$ " + taxaManutencao);
        }
}


