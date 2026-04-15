package Models;

public class Cliente {
    private int id;
    private String nome;
    private String agencia;
    private String conta;
    private double saldo;
    private double limite;

    public Cliente() {
        this.limite = 50;
    }
    public double getLimite() {
        return limite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void deposita(double valor) {
        this.saldo += valor;
    }

    public void saca(double valor) {
        this.saldo -= valor;
    }
    public void sacaComLimite(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
        } else if (this.saldo < valor && this.limite < valor) {
            System.out.println("Saldo insuficiente ou Limite atingido!");
        }
        else {
            this.limite -= valor;
            if (this.limite <= 0) {
                System.out.println("Limite atingido!");
                this.limite = 0;
            }
        }
    }
    public double emiteSaldo() {
        return this.saldo;
    }
}
