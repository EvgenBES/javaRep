package ru.job4j;

import java.util.*;

/**
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1.0
 * @since 30.08.2018
 */
public class Bank {
    private Map<User, List<Account>> bank = new HashMap<>();

    public boolean addUser(User user) {
        boolean result = false;
        int backSize = this.bank.size();

        this.bank.putIfAbsent(user, new ArrayList<>());

        if (backSize != this.bank.size()) {
            result = true;
        }

        return result;
    }

    public boolean deleteUser(User user) {
        boolean result = false;

        if (this.bank.size() != 0) {
            int backSize = this.bank.size();
            this.bank.remove(user);
            if (backSize != this.bank.size()) {
                result = true;
            }
        }
        return result;
    }

    public void addAccountToUser(String passport, Account account) {
        if (passport != null & account != null) {
            for (User user : bank.keySet()) {
                if (user.getPassword().equals(passport)) {
                    this.bank.get(user).add(account);
                    break;
                }
            }
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        if (passport != null & account != null) {
            for (User user : bank.keySet()) {
                if (user.getPassword().equals(passport)) {
                    this.bank.get(user).remove(account);
                    break;
                }
            }
        }
    }

    public List<Account> getUserAccounts(String passport) {
        List<Account> list = null;
        if (passport != null) {
            for (User user : bank.keySet()) {
                if (user.getPassword().equals(passport)) {
                    list = this.bank.get(user);
                    break;
                }
            }
        }
        return list;
    }


    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String dstRequisite, double amount) {
        boolean result = false;

        if (amount > 0) {
            Account srcAccount = this.findAccountToBankByPassportAndRequisite(srcPassport, srcRequisite);
            Account destAccount = this.findAccountToBankByPassportAndRequisite(destPassport, dstRequisite);

            if (srcAccount != null && destAccount != null && srcAccount.getValues() > amount) {
                srcAccount.setValues(srcAccount.getValues() - amount);
                destAccount.setValues(destAccount.getValues() + amount);
                result = true;
            }
        }
        return result;
    }

    private Account findAccountToBankByPassportAndRequisite(String srcPassport, String srcRequisite) {
        Account result = null;

        List<Account> listAcc = this.getUserAccounts(srcPassport);
        if (srcPassport != null && srcRequisite != null && listAcc != null) {
            for (Account account : listAcc) {
                if (account.getRequisites().equals(srcRequisite)) {
                    result = account;
                    break;
                }
            }
        }
        return result;
    }
}