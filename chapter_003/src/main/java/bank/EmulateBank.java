package bank;

import javax.swing.text.html.ListView;
import java.util.*;

public class EmulateBank {

    private Map<User, List<Account>> usersAcc = new HashMap<>();

    public Map<User, List<Account>> getUsersAcc() {
        return usersAcc;
    }

    /**
     * Добавление пользователя
     * @param user
     */
    public void addUser(User user) {
            usersAcc.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Найти всех пользователей по паспорту
     * @param passport
     * @return
     */
    public Optional<User> getUserByPassport(int passport) {
        Optional<User> user = Optional.empty();
        for (User u : usersAcc.keySet()) {
            if (u.getPassport() == passport) {
                user = Optional.of(u);
                break;
            }
        }
        return user;
    }

    /**
     * Удаление пользователя
     * @param passport
     */
    public void deleteUser(int passport) {
        Optional<User> u = getUserByPassport(passport);
        u.ifPresent(user -> usersAcc.keySet().remove(user));
    }

    /**
     * Добавление счета к пользователю
     * @param passport
     * @param account
     */
    public void addAccountToUser(int passport, Account account) {
        Optional<User> user = getUserByPassport(passport);
        if (user.isPresent()) {
            usersAcc.get(user.get()).add(account);
        }
    }


    /**
     * Получить все аккаунты пользователя
     * @param passport
     * @return
     */
    public List<Account> getUsersAccounts(int passport) {
        Optional<User> user = getUserByPassport(passport);
        return user.map(user1 -> usersAcc.get(user1)).orElse(null);
    }

    /**
     * Удалить счет у пользователя
     * @param passport
     * @param account
     */
    public void deleteAccountFromUser(int passport, Account account) {
        Optional<User> user = getUserByPassport(passport);
        if (user.isPresent()) {
            List<Account> userAccounts = getUsersAccounts(passport);
            if (userAccounts != null) {
                userAccounts.remove(account);
            }
        }
    }

    /**
     * Перевод средств между счетами
     * @param srcPassport
     * @param srcRequisite
     * @param destPassport
     * @param dstRequisite
     * @param amount
     * @return
     */
    public boolean transferMoney(int srcPassport, int srcRequisite, int destPassport, int dstRequisite, double amount) {
        boolean result = false;
        if (validTransfer(srcPassport, srcRequisite, destPassport, dstRequisite, amount)) {
            for (Account account : getUsersAccounts(srcPassport)) {
                if (account.getReqs() == srcRequisite) {
                    account.setValue(account.getValue() - amount);
                    break;
                }
            }
            for (Account account : getUsersAccounts(destPassport)) {
                if (account.getReqs() == dstRequisite) {
                    account.setValue(account.getValue() + amount);
                    break;
                }
            }
            result = true;
        }
        return result;
    }

    /**
     * Получение аккаунта по паспорту и реквизитам
     * @param passport
     * @param req
     * @return
     */
    public Optional<Account> getAccount(int passport, int req) {
        Optional<Account> account = Optional.empty();
        List<Account> accounts = getUsersAccounts(passport);
        if (accounts != null) {
            for (Account ac : accounts) {
                if (ac.getReqs() == req) {
                    account = Optional.of(ac);
                    break;
                }
            }
        }
        return account;
    }

    /**
     * Проверка возможности перевода
     * @param srcPassport
     * @param srcRequisite
     * @param destPassport
     * @param dstRequisite
     * @param amount
     * @return
     */
    public boolean validTransfer(int srcPassport, int srcRequisite, int destPassport, int dstRequisite, double amount) {
        boolean result = false;
        Optional<Account> srcAccount = getAccount(srcPassport, srcRequisite);
        Optional<Account> destAccount = getAccount(destPassport, dstRequisite);
        if (srcAccount.isPresent() && destAccount.isPresent()) {
            result = srcAccount.get().transfer(amount, destAccount.get());
        }
        return result;
    }

}

