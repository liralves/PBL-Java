public class ContaCorrente {
    private String numeroConta;
    private String nomeTitular;
    private double saldo;
    private String dataAbertura;
    private static double saldoInicio = 200.00;
    private static int countContas;

    public ContaCorrente(String numeroConta, String nomeTitular, double saldo, String dataAbertura) {
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
        this.saldo = saldoInicio;
        this.dataAbertura = dataAbertura;

        countContas++;

    }
    public ContaCorrente(){
        this.saldo = this.saldoInicio;
        countContas++;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getDataAbertura() {
        return dataAbertura;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }


    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    public void setDataAbertura(String dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public void depositar(double value) {
        if (value > 0) {
            saldo += value;
            System.out.printf("Você depositou um valor de %.2f", value);
        }else {
            System.out.printf("O valor para deposito deve ser positivo.");
        }
    }

    public void sacar(double value) {
        if (value > 0 && value <= getSaldo()){
                saldo -= value;
                System.out.printf("Você sacou um valor de %.2f", value);
        }
    }

    public void transferir(ContaCorrente destino, double valor){
        if (valor <= 0){
            System.out.println("O valor para transferência deve ser positivo.");
            return;
        }

        if (valor > this.saldo){
            System.out.println("Saldo insuficiente para realizar a transferência.");
            return;
        }

        this.saldo -= valor;
        destino.depositar(valor);

        System.out.printf("Transferência de R$ %.2f para a conta %d realizada com sucesso.\n", valor, destino.getNumeroConta());
    }

    public void imprimirExtrato(){
        System.out.printf("\nCONTA BANCÁRIA\n");
        System.out.printf("\nTitular: %s\n", nomeTitular);
        System.out.printf("\nNúmero da Conta: %d\n", numeroConta);
        System.out.printf("\nData de abertura: %s\n", dataAbertura);
        System.out.printf("\nSaldo atual: %.2f\n", saldo);
    }

    public static void quantidadeContas(){
        countContas++;
        System.out.printf("Quantidade de contas atual: %d", countContas);
    }
}
