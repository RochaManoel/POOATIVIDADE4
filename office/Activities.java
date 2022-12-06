package office;

import java.util.ArrayList;

import entities.User;

public class Activities {
    private String idActivity;
    private String descriptionActivity;
    private String firstPeriod;
    private String lastPeriod;
    private User coordinatorActivity;
    private ArrayList<User> professionalsActivity = new ArrayList<>();
    private ArrayList<Tasks> tasks = new ArrayList<>();

    // ----- Construtores - Overloading ----- //
    public Activities(){
    }
    public Activities(String idActivity, String descriptionActivity, String firstPeriod, String lastPeriod, User coordinatorActivity, ArrayList<User> professionalsActivity, ArrayList<Tasks> tasks){
        this.idActivity = idActivity;
        this.descriptionActivity = descriptionActivity;
        this.firstPeriod = firstPeriod;
        this.lastPeriod = lastPeriod;
        this.coordinatorActivity = coordinatorActivity;
        this.professionalsActivity = professionalsActivity;
        this.tasks = tasks;
    }

    // ----- Getters da Classe ----- //
    public String getIdActivity() {
        return idActivity;
    }
    public String getDescriptionActivity() {
        return descriptionActivity;
    }
    public String getFirstPeriod() {
        return firstPeriod;
    }
    public String getLastPeriod() {
        return lastPeriod;
    }
    public User getCoordinatorActivity() {
        return coordinatorActivity;
    }
    public ArrayList<User> getProfessionalsActivity() {
        return professionalsActivity;
    }
    public ArrayList<Tasks> getTasks() {
        return tasks;
    }

    // ----- Setters da Classe ----- //
    public void setIdActivity(String idActivity) {
        this.idActivity = idActivity;
    }
    public void setDescriptionActivity(String descriptionActivity) {
        this.descriptionActivity = descriptionActivity;
    }
    public void setFirstPeriod(String firstPeriod) {
        this.firstPeriod = firstPeriod;
    }
    public void setLastPeriod(String lastPeriod) {
        this.lastPeriod = lastPeriod;
    }
    public void setCoordinatorActivity(User coordinatorActivity) {
        this.coordinatorActivity = coordinatorActivity;
    }

    // ----- Adição de elementos na Classe ----- //
    public void addUserProfessional(User user){
        this.professionalsActivity.add(user);
    }
    public void addTaskUserProfessional(User user, String task){
        this.tasks.add(new Tasks(user, task));
    }

    // ----- Edição de elementos na Classe ----- //
    public void editTask(User user, String task){
        for(Tasks tasks: this.getTasks()){
            if(tasks.getUserTask().equals(user)){
                tasks.setTasks(task);
                break;
            }
        }
    }

    // ----- Impressão de Consulta e Relatório da Classe ----- //

    public String writeToString(){
        String Inf = new String();
        Inf= "\n - Id da Atividade: " + this.idActivity+"\n - Descrição da Atividade: "+this.descriptionActivity+"\n"+
        " - Inicio da Atividade: "+this.firstPeriod+"\n - Fim da Atividade: "+this.lastPeriod+"\n"+
        " - Coordenador da Atividade: "+ this.coordinatorActivity.getName()+" "+this.coordinatorActivity.getLastName();
        return Inf;
    }
  
    public String toString(){
        return this.writeToString();
    }
  
    public void printReport(){
        System.out.println("\nRelatório da Atividade");
        System.out.println(this.toString());
        System.out.println("\n - Usuários e Tarefas Presentes:\n");
        for(Tasks tks: this.tasks){
            System.out.println("     - "+tks.getUserTask().getName()+" "+tks.getUserTask().getLastName()+": "+tks.getTasks());
        }
    }

}