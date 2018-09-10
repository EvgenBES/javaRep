package ru.job4j.transfer;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.List;

/**
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1.0
 * @since 30.08.2018
 */
public class BankTest {
    @Test
    public void whenAddUserToBantThenReturnNumberUser() {
        Bank bank = new Bank();
        User user = new User("Ivan", "123456");
        Account account = new Account(1, "USD");
        bank.addUser(user);
        bank.addAccountToUser("123456", account);
        List<Account> result = bank.getUserAccounts("123456");
        assertThat(result.size(), is(1));
    }


    @Test
    public void whenDeleteAccountThenGetNumberAccount() {
        Bank bank = new Bank();
        User user = new User("Ivan", "123456");
        Account accountA = new Account(10, "USD");
        Account accountB = new Account(0, "RUB");
        bank.addUser(user);
        bank.addAccountToUser("123456", accountA);
        bank.addAccountToUser("123456", accountB);
        bank.deleteAccountFromUser("123456", accountB);
        List<Account> result = bank.getUserAccounts("123456");
        assertThat(result.size(), is(1));
    }

    @Test
    public void whenDeleteUserThenToBankZeroUser() {
        Bank bank = new Bank();
        User user = new User("Ivan", "123456");
        bank.addUser(user);
        boolean result = bank.deleteUser(user);
        assertThat(result, is(true));
    }

    @Test
    public void whenDeleteUserWithWrongNameUserThenResultFalse() {
        Bank bank = new Bank();
        User userA = new User("Ivan", "123456");
        User userB = new User("Ivon", "012345");
        bank.addUser(userA);
        boolean result = bank.deleteUser(userB);
        assertThat(result, is(false));
    }

    @Test
    public void whenAddUserThenReturnTrue() {
        Bank bank = new Bank();
        User user = new User("Ivan", "123456");
        boolean result = bank.addUser(user);
        assertThat(result, is(true));
    }

    @Test
    public void whenUserTransferAnotherThenReturnTrue() {
        Bank bank = new Bank();
        String passwordUserA = "123456";
        String passwordUserB = "654321";
        User userA = new User("Ivan", passwordUserA);
        User userB = new User("Serge", passwordUserB);
        Account accountA = new Account(50, "USD");
        Account accountB = new Account(0, "USD");
        bank.addUser(userA);
        bank.addUser(userB);
        bank.addAccountToUser(passwordUserA, accountA);
        bank.addAccountToUser(passwordUserB, accountB);
        boolean result = bank.transferMoney(passwordUserA, "USD", passwordUserB, "USD", 25);
        assertThat(result, is(true));
    }

    @Test
    public void whenUserDoesNotHaveEnoughMoneyForTranslationThenReturnFalse() {
        Bank bank = new Bank();
        String passwordUserA = "123456";
        String passwordUserB = "654321";
        User userA = new User("Ivan", passwordUserA);
        User userB = new User("Serge", passwordUserB);
        Account accountA = new Account(20, "USD");
        Account accountB = new Account(0, "USD");
        bank.addUser(userA);
        bank.addUser(userB);
        bank.addAccountToUser(passwordUserA, accountA);
        bank.addAccountToUser(passwordUserB, accountB);
        boolean result = bank.transferMoney(passwordUserA, "USD", passwordUserB, "USD", 30);
        assertThat(result, is(false));
    }

    @Test
    public void whenInvalidUserPasswordForTranslationThenReturnFalse() {
        Bank bank = new Bank();
        String passwordUserA = "123456";
        User userA = new User("Ivan", passwordUserA);
        User userB = new User("Serge", "000000");
        Account accountA = new Account(20, "USD");
        Account accountB = new Account(0, "USD");
        bank.addUser(userA);
        bank.addUser(userB);
        bank.addAccountToUser(passwordUserA, accountA);
        bank.addAccountToUser("000000", accountB);
        boolean result = bank.transferMoney(passwordUserA, "USD", "123", "USD", 30);
        assertThat(result, is(false));
    }

    @Test
    public void whenTransferIsSuccessfulAndBalanceIsValidThenCorrectBalance() {
        Bank bank = new Bank();
        String passwordUserA = "123456";
        String passwordUserB = "654321";
        User userA = new User("Ivan", passwordUserA);
        User userB = new User("Serge", passwordUserB);
        Account accountA = new Account(50, "USD");
        Account accountB = new Account(0, "USD");
        bank.addUser(userA);
        bank.addUser(userB);
        bank.addAccountToUser(passwordUserA, accountA);
        bank.addAccountToUser(passwordUserB, accountB);
        bank.transferMoney(passwordUserA, "USD", passwordUserB, "USD", 25);
        List<Account> result = bank.getUserAccounts(passwordUserB);
        assertThat(result.get(0).getValues(), is(25.0));
    }
}