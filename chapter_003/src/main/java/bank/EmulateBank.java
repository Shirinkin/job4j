package bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        try {
            usersAcc.putIfAbsent(user, new ArrayList<Account>());
        } catch (Exception e) {
            System.out.println("This User Already Exist!");
        }
    }

    /**
     * Найти всех пользователей по паспорту
     * @param passport
     * @return
     */
    public User getUserByPassport(int passport) {
        User userDest = new User();
        for (User user : usersAcc.keySet()) {
            if (user.getPassport() == passport) {
                userDest = user;
                break;
            }
        }
        return userDest;
    }

    /**
     * Удаление пользователя
     * @param passport
     */
    public void deleteUser(int passport) {
        usersAcc.keySet().remove(getUserByPassport(passport));
    }

    /**
     * Добавление счета к пользователю
     * @param passport
     * @param account
     */
    public void addAccountToUser(int passport, Account account) {
        User user = getUserByPassport(passport);
        usersAcc.get(user).add(account);
    }


    /**
     * Получить все аккаунты пользователя
     * @param passport
     * @return
     */
    public List<Account> getUsersAccounts(int passport) {
        User user = getUserByPassport(passport);
        return usersAcc.get(user);
    }

    /**
     * Удалить счет у пользователя
     * @param passport
     * @param account
     */
    public void deleteAccountFromUser(int passport, Account account) {
        User user = getUserByPassport(passport);
        usersAcc.get(user).remove(account);
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
        User user1 = getUserByPassport(srcPassport);
        User user2 = getUserByPassport(destPassport);
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
        if ((user1 != null) && (user2 != null) && rsAccount1 && rsAccount2 && transfer) {
            result = true;
        }
        return result;
    }

}

