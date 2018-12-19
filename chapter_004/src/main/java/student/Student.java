package student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Student implements Comparator<Student> {
    private String name;
    private int scope;

    public Student(String name, int scope) {
        this.name = name;
        this.scope = scope;
    }

    public String getName() {
        return name;
    }

    public int getScope() {
        return scope;
    }

    public void setScope(int scope) {
        this.scope = scope;
    }

    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o2.scope, o1.scope);
    }
}
