package bank;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class EmulateBankTest {

    @Test
    public void whenAddUser() {
        EmulateBank bank = new EmulateBank();
        bank.addUser(new User("Misha", 458));
        assertThat(bank.getUserByPassport(458).get().getName(), is("Misha"));
    }

    @Test
    public void whenDeleteUser() {
        EmulateBank bank = new EmulateBank();
        bank.addUser(new User("Misha", 895));
        bank.deleteUser(895);
        assertThat(bank.getUsersAcc().keySet().iterator().hasNext(), is(false));
    }

    @Test
    public void whenAddAccountToUser() {
        EmulateBank bank = new EmulateBank();
        bank.addUser(new User("Pavel", 999));
        bank.addAccountToUser(999, new Account(586, 654987));
        bank.addAccountToUser(999, new Account(5896, 12345678));
        assertThat(bank.getUsersAccounts(999).size(), is(2));

    }

    @Test
    public void whenDeleteAccountFromUser() {
        EmulateBank bank = new EmulateBank();
        bank.addUser(new User("Pavel", 999));
        Account account = new Account(9966, 555555);
        bank.addAccountToUser(999, account);
        bank.addAccountToUser(999, new Account(5896, 12345678));
        bank.deleteAccountFromUser(999, account);
        assertThat(bank.getUsersAccounts(999).size(), is(1));
    }

    @Test
    public void whenTransferMoneySuccess() {
        EmulateBank bank = new EmulateBank();
        bank.addUser(new User("Pavel", 999));
        Account account = new Account(20000, 555555);
        bank.addAccountToUser(999, account);
        bank.addUser(new User("Misha", 111));
        Account account2 = new Account(98000, 666666);
        bank.addAccountToUser(111, account2);
        boolean result = bank.transferMoney(999, 555555, 111, 666666, 10000);
        assertThat(result, is(true));
    }

    @Test
    public void whenTransferMoneyFailed() {
        EmulateBank bank = new EmulateBank();
        bank.addUser(new User("Pavel", 999));
        Account account = new Account(20000, 555555);
        bank.addAccountToUser(999, account);
        bank.addUser(new User("Misha", 111));
        Account account2 = new Account(98000, 666666);
        bank.addAccountToUser(111, account2);
        boolean result = bank.transferMoney(999, 555555, 111, 666666, 100000);
        assertThat(result, is(false));
    }
}