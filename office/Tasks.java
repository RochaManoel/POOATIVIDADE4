package office;

import entities.User;

public class Tasks {
    private User userTask;
    private String tasks;

    // ----- Construtores - Overloading ----- //
    public Tasks(User userTask, String tasks){
        this.userTask = userTask;
        this.tasks = tasks;
    }

    // ----- Getters da Classe ----- //
    public User getUserTask() {
        return userTask;
    }
    public String getTasks() {
        return tasks;
    }

    // ----- Setters da Classe ----- //
    public void setTasks(String tasks) {
        this.tasks = tasks;
    }

}