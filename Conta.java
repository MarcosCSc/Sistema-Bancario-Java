// Classe base que representa uma conta genérica
// Não colocamos "public" porque só pode haver uma classe pública por arquivo
public class Conta {

    // protected permite que as classes filhas acessem esses atributos
    protected String titular;   // Nome do dono da conta
    protected double saldo;     // Saldo disponível

    // Construtor: executado quando um objeto é criado
    // Ele inicializa os atributos obrigatórios
    public Conta(String titular, double saldoInicial) {
        this.titular = titular;       // "this" diferencia atributo da variável do construtor
        this.saldo = saldoInicial;
    }

    // Método para adicionar dinheiro na conta
    public void depositar(double valor) {
        saldo += valor;  // Soma o valor ao saldo atual
    }

    // Método para retirar dinheiro
    public void sacar(double valor) {
        // Verifica se há saldo suficiente antes de sacar
        if (valor <= saldo) {
            saldo -= valor;  // Subtrai o valor do saldo
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    // Método que será sobrescrito pelas subclasses
    // Serve para demonstrar polimorfismo
    public void calcularRendimento() {
        System.out.println("Conta comum não possui rendimento específico.");
    }

    // Método para mostrar dados da conta
    public void exibirDados() {
        System.out.println("Titular: " + titular);
        System.out.println("Saldo: R$ " + saldo);
    }
}
