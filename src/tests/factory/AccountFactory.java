package tests.factory;

import entities.Account;

public class AccountFactory {
    public static Account createEmptyAccount() {
        return new Account(1L, 0.0); // devolve instância de uma conta com saldo ZERADO
    }

    public static Account createAccount(double initialBalance) {
        return new Account(1L, initialBalance); // devolve instância de uma conta com saldo passado via parâmetro
    }
}
