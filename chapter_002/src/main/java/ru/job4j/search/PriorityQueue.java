package ru.job4j.search;

import java.util.LinkedList;

/**
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1.0
 * @since 22.08.2018
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     *
     * @param task задача
     */
    public void put(Task task) {
        if (tasks.size() == 0) {
            tasks.add(task);
        } else {
            for (int i = 0; i <= tasks.size() - 1; i++) {
                if (tasks.get(i).getPriority() >= task.getPriority()) {
                    tasks.add(i, task);
                    break;
                } else if (tasks.getLast().getPriority() <= task.getPriority()) {
                    tasks.addLast(task);
                    break;
                }
            }
        }
    }

    public Task task() {
        return this.tasks.poll();
    }


}
