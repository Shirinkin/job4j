package bank;

import java.util.Objects;

public class User {

    private String name;
    private int passport;

    public User(String name, int passport) {
        this.name = name;
        this.passport = passport;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public int getPassport() {
        return passport;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassport(int passport) {
        this.passport = passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(name, user.name)
                && Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passport);
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", passport=" + passport
                + '}';
    }
}
