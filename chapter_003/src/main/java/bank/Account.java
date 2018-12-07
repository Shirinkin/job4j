package bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Account {

    private double value;
    private int reqs;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getReqs() {
        return reqs;
    }

    public void setReqs(int reqs) {
        this.reqs = reqs;
    }

    public Account(double value, int reqs) {
        this.value = value;
        this.reqs = reqs;
    }

    public Account() {
    }

    public boolean transfer(double amount, Account dest) {
        boolean result = false;
        if (this.getValue() >= amount) {
            this.value = this.value - amount;
            dest.setValue(dest.getValue() + amount);
            result = true;
        }
        return result;
    }

    @Override
    public String toString() {
        return "Account{"
                + "value=" + value
                + ", reqs=" + reqs
                + '}';
    }
}
