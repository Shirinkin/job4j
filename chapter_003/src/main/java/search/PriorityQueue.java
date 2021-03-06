package search;

import java.util.LinkedList;

public class PriorityQueue {

    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод вставляет в нужную позицию элемент
     * @param task
     */
    public void put(Task task) {
       int count = (int) tasks.stream().filter(element -> element.getPriority() < task.getPriority()).count();
       tasks.add(count, task);
    }

    public Task take() {
        return this.tasks.poll();
    }

    public void getAll() {
        for (var i = 0; i < tasks.size(); i++) {
            System.out.println(tasks.get(i));
        }
    }
}
