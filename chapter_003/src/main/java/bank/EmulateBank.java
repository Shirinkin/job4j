package bank;

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
        usersAcc.keySet().remove(getUserByPassport(passport).get());

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
            getUsersAccounts(passport).remove(account);
        }
    }

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

    public boolean validTransfer(int srcPassport, int srcRequisite, int destPassport, int dstRequisite, double amount) {
        Optional<User> user1 = getUserByPassport(srcPassport);
        Optional<User> user2 = getUserByPassport(destPassport);
        boolean result = false;
        boolean rsAccount1 = false;
        boolean rsAccount2 = false;
        boolean transfer = false;
        for (int index = 0; index != getUsersAccounts(srcPassport).size(); index++) {
            if (getUsersAccounts(srcPassport).get(index).getReqs() == srcRequisite) {
                rsAccount1 = true;
                break;
            }
        }
        for (int index = 0; index != getUsersAccounts(destPassport).size(); index++) {
            if (getUsersAccounts(destPassport).get(index).getReqs() == dstRequisite) {
                rsAccount2 = true;
                break;
            }
        }
        for (Account account : getUsersAccounts(srcPassport)) {
            if (account.getReqs() == srcRequisite && account.getValue() > amount) {
                transfer = true;
                break;
            }
        }
        if ((user1.isPresent()) && (user2.isPresent()) && rsAccount1 && rsAccount2 && transfer) {
            result = true;
        }
        return result;
    }

}

