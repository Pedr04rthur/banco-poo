package SistemaBancario;

public class Conta implements InterfaceConta{
    private static int SEQUENCIAL = 1;

    private static final int AGENCIA_PADRAO = 1;
    protected int agencia;
    protected int numero;
    protected double saldo;


    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Conta(){
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
    }


    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contDestino) {
        this.sacar(valor);
        contDestino.depositar(valor);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("*** Extrato da Conta ***");
        System.out.println(String.format("Agência: %d",this.agencia));
        System.out.println(String.format("Numero: %d",this.numero));
        System.out.println(String.format("Saldo: %.2f",this.saldo));
    }
}
