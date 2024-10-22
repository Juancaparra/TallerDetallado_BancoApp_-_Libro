class CuentaBancaria {
    private String titular;
    private double saldo;

    public CuentaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void depositar(double monto) throws MontoInvalidoException {
        if (monto <= 0) {
            throw new MontoInvalidoException("El monto debe ser mayor a cero.");
        }
        saldo += monto;
        System.out.println("Depósito exitoso. Nuevo saldo: " + saldo);
    }

    public void retirar(double monto) throws SaldoInsuficienteException {
        if (monto > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente.");
        }
        saldo -= monto;
        System.out.println("Retiro exitoso. Nuevo saldo: " + saldo);
    }

    public void transferir(CuentaBancaria destino, double monto)
            throws SaldoInsuficienteException, MontoInvalidoException {
        if (monto <= 0) {
            throw new MontoInvalidoException("El monto a transferir debe ser mayor a cero.");
        }
        this.retirar(monto);
        destino.depositar(monto);
        System.out.println("Transferencia exitosa de " + monto + " a " + destino.getTitular());
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }
}