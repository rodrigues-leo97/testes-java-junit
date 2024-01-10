package tests.entities;

import entities.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.factory.AccountFactory;

class AccountTest {

    @Test
    public void depositShouldIncreaseBalanceWhenPositiveAmount() {
        // EXECUTANDO AS AÇÕES -> AAA

        // Arrange -> instancie os objetos necessários
        double amount = 200.00; // valor depositado
        double expectedValue = 196.00; // valor esperado após ser cobrada a taxa de 2% do banco

        Account acc = AccountFactory.createEmptyAccount(); //Preparei os dados (ACT)

        // ACT -> Execute as ações necessárias
        acc.deposit(amount); // depositei os 200 (ACT - Executando as ações necessárias)

        // ASSERT -> declare o que deveria acontecer(resultado esperado
        Assertions.assertEquals(expectedValue, acc.getBalance()); //Saldo esperado após a transação

    }

    @Test
    public void depositShouldDoNothingWhenNegativeAmount() {
        double amount = -200.00;
        double expectedValue = 100.00;
        Account acc = AccountFactory.createAccount(expectedValue);

        acc.deposit(amount);

        Assertions.assertEquals(expectedValue, acc.getBalance());

    }

    @Test
    public void fullWithDrawShouldClearBalance(){ // não tem o WHEN pq não tem argumentos
        double expectedValue = 0.0;
        double initialBalance = 200.00;
        Account acc = AccountFactory.createAccount(initialBalance);

        double result = acc.fullWithDraw();

        Assertions.assertEquals(expectedValue, acc.getBalance());
        Assertions.assertTrue(expectedValue == acc.getBalance());
        Assertions.assertTrue(result == initialBalance);
    }

    @Test
    public void withDrawShouldDecreaseBalanceWhenSufficientBalance() { // decrementar o saldo quando tiver saldo disponível
        // criar ou instanciar os objetos necessários
        double initialBalance = 500.00;
        double expectedValue = 100.00;
        double valueWithdraw = 400.00;
        Account acc = AccountFactory.createAccount(initialBalance);

        // execute as ações necessárias
        acc.withDraw(valueWithdraw);

        // declare o que deverá acontecer
        Assertions.assertEquals(expectedValue, acc.getBalance());
        Assertions.assertTrue(expectedValue == acc.getBalance());
    }

    @Test
    public void withDrawShouldThrowExceptionWhenInsufficientBalance() { // lança exceção quando saldo é insuficiente
        double initialBalance = 800.00;
        double valueWithdraw = 801.00;

        Assertions.assertThrows(IllegalArgumentException.class, () -> { // para lançar exceção tem que específicar o tipo e oq deve acontecer dentro de uma lambda
            Account acc = AccountFactory.createAccount(initialBalance);
            acc.withDraw(valueWithdraw);
        });

    }
}