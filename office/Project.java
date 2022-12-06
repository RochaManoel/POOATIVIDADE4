package office;

import java.util.ArrayList;

import entities.User;

public class Project {
    private String idProject;
    private String descriptionProject;
    private String firstPeriod;
    private String lastPeriod;
    private User coordinator;
    private ArrayList<User> professionals = new ArrayList<>();
    private ArrayList<Activities> activities = new ArrayList<>();
    private ArrayList<Bags> bags = new ArrayList<>();
    private String status;

    // ----- Construtores - Overloading ----- //    
    public Project(){

    }
    public Project(String newIdProject, String newDescriptionProject, String firstPeriod, String lastPeriod, User coordinator, ArrayList<User> professionals, ArrayList<Activities> activities, ArrayList<Bags> bags){
        this.idProject = newIdProject;
        this.descriptionProject = newDescriptionProject;
        this.firstPeriod = firstPeriod;
        this.lastPeriod = lastPeriod;
        this.coordinator = coordinator;
        this.professionals = professionals;
        this.activities = activities;
        this.bags = bags;
        this.status="Em processo de Criação";
    }

    // ----- Getters da Classe ----- //
    public String getIdProject() {
        return idProject;
    }
    public String getDescriptionProject() {
        return descriptionProject;
    }
    public String getFirstPeriod() {
        return firstPeriod;
    }
    public String getLastPeriod() {
        return lastPeriod;
    }
    public User getCoordinator() {
        return coordinator;
    }
    public ArrayList<User> getProfessionals() {
        return professionals;
    }
    public ArrayList<Activities> getActivities() {
        return activities;
    }
    public ArrayList<Bags> getBags() {
        return bags;
    }
    public String getStatus() {
        return status;
    }

    // ----- Setters da Classe ----- //
    public void setIdProject(String idProject) {
        this.idProject = idProject;
    }
    public void setDescriptionProject(String descriptionProject) {
        this.descriptionProject = descriptionProject;
    }
    public void setFirstPeriod(String firstPeriod) {
        this.firstPeriod = firstPeriod;
    }
    public void setLastPeriod(String lastPeriod) {
        this.lastPeriod = lastPeriod;
    }

    // ----- Adição de elementos na Classe ----- //    
    public void addActivity(Activities act){
        this.activities.add(act);
    }
    public void addUser(User user){
        this.professionals.add(user);
    }
    public void addBag(User user, int value, String period){
        Bags bg = new Bags(user, value,period);
        this.bags.add(bg);
    }
    
    // ----- Edição de elementos na Classe ----- //
    public void editBagValue(User user, int value, String period){
        for(Bags bg: this.bags){
            if(bg.getUser().equals(user)){
                bg.setValue(value);
                bg.setPeriod(period);
            }
        }
    }

    // ----- Edição do Status presente na Classe ----- //
    public boolean authentication(){
        boolean control = true;
        if(this.idProject == null){
            control = false;
        }
        if(this.descriptionProject == null){
            control = false;
        }
        if(this.professionals.isEmpty()){
            control = false;
        }
        if(this.activities.isEmpty()){
            control = false;
        }
        if(this.bags.isEmpty()){
            control = false;
        }
        return control;
    }
    public void statusProject(){
        if(this.status.equals("Em processo de Criação")){
            if(authentication()){
                this.status = "Iniciado";
                System.out.println("\nStatus alterado com Sucesso.");
            }
            else{
                System.out.println("\nNão é possivel alterar Status");
            }
            return;
        }
        if(this.status.equals("Iniciado")){
            if(authentication()){
                this.status = "Em andamento";
                System.out.println("\nStatus alterado com Sucesso.");
            }
            else{
                System.out.println("\nNão é possivel alterar Status");
            }
            return;
        }
        if(this.status.equals("Em andamento")){
            if(authentication()){
                this.status = "Concluido";
                System.out.println("\nStatus alterado com Sucesso.");
            }
            else{
                System.out.println("\nNão é possivel alterar Status");
            }
            return;
        }
    }

    // ----- Impressão de Consulta e Relatório da Classe ----- //
    public String writeToString(){
        String Inf = new String();
        Inf = "\n - Id do Projeto: "+this.idProject+"\n - Descrição: "+this.descriptionProject+"\n"+
        " - Inicio do Projeto: "+this.firstPeriod+"\n - Fim do Projeto: "+this.lastPeriod+"\n"+
        " - Coordenador do Projeto: "+this.coordinator.getName()+" "+this.coordinator.getLastName()+"\n"+
        " - Status do Projeto: "+this.status;
        return Inf;   
    }
  
    public String toString(){
        return this.writeToString();
    }
  
    public void printReport(){
        System.out.println("\nRelatório do Projeto");
        System.out.println(this.toString());
        System.out.println("\n - Usuários e Bolsas:\n");
        for(Bags bgs: this.bags){
            System.out.println("     - "+bgs.getUser().getName()+" "+bgs.getUser().getLastName()+": Valor(R$"+bgs.getValue()+".00) Periodo de Vigência( "+bgs.getPeriod()+" )");
        }
        System.out.println("\n - Atividades:\n");
        for(Activities act: this.activities){
            System.out.println("    - "+act.getIdActivity()+": "+act.getDescriptionActivity());
        }
    }

}