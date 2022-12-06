package auxiliaries;
import java.util.ArrayList;

import entities.Professional;
import entities.Research;
import entities.Student;
import entities.Teacher;
import entities.User;
import office.Activities;
import office.Bags;
import office.Project;
import office.Tasks;

public class Date {
    private Input input = new Input();
    private ArrayList<User> userList = new ArrayList<>();
    private ArrayList<Project> projectList = new ArrayList<>();
    private User userOnline = new User();

    // ----- Getters da Classe ----- //
    public ArrayList<User> getUserList(){
        return this.userList;
    }
    public ArrayList<Project> getProjectList() {
        return projectList;
    }
    public User getUserOnline(){
        return this.userOnline;
    }

    // ----- Setters da Classe ----- //
    public void SetUserList(ArrayList<User> userList){
        this.userList = userList;
    }
    public void setProjectList(ArrayList<Project> projectList) {
        this.projectList = projectList;
    }
    public void setUserOnline(User userOnline){
       this.userOnline = userOnline;
    }

    /*---------------------------------------- 
    |                                        |
    |               LOGIN AREA               |
    |                                        |
    ----------------------------------------*/

    // ----- Criação do Usuário da Área ----- //
    public void addUser(){
        boolean control = true;
        while(control){
            User useradd;
            int office = input.getOffice();
            String newName = input.newName();
            String newlastName = input.newlastName();
            String newEmail = input.newEmail();
            String newPassword = input.newPassword();
            switch(office){
                case 1:
                    useradd = new Student(newName, newlastName, newEmail, newPassword,1, "Aluno de Graduação");
                    this.userList.add(useradd);
                    control = false;
                    break;
                case 2:
                    useradd = new Student(newName, newlastName, newEmail, newPassword,2, "Aluno de Mestrado");
                    this.userList.add(useradd);
                    control = false;
                    break;
                case 3:
                    useradd = new Student(newName, newlastName, newEmail, newPassword,3, "Aluno de Doutorado");
                    this.userList.add(useradd);
                    control = false;
                    break;
                case 4:
                    useradd = new Teacher(newName, newlastName, newEmail, newPassword,4, "Professor");
                    this.userList.add(useradd);
                    control = false;
                    break;
                case 5:
                    useradd = new Research(newName, newlastName, newEmail, newPassword,5, "Pesquisador");
                    this.userList.add(useradd);
                    control = false;
                    break;
                case 6:
                    useradd = new Professional(newName, newlastName, newEmail, newPassword,6, "Desenvolvedor");
                    this.userList.add(useradd);
                    control = false;
                    break;
                case 7:
                    useradd = new Professional(newName, newlastName, newEmail, newPassword,7, "Testador");
                    this.userList.add(useradd);
                    control = false;
                    break;
                case 8:
                    useradd = new Professional(newName, newlastName, newEmail, newPassword,8, "Análista");
                    this.userList.add(useradd);
                    control = false;
                    break;
                case 9:
                    useradd = new Professional(newName, newlastName, newEmail, newPassword,9, "Técnico");
                    this.userList.add(useradd);
                    control = false;
                    break;
                default:
                    System.out.println("Tipo de Usuário não Identificado.Tente Novamente.");
                    break;
            }
        }
        System.out.println("\nUsuário adicionado com Sucesso.");
    }

    // ----- Entrada do Usuário na Área de Menu ----- //
    public User loginUser(){
        User userOnline = new User();
        String userMail = input.getEmail();
        String userPassword = input.getPassword();
        boolean control = true;
        for(User user: this.userList){
            if(user.getEmail().equals(userMail) && user.getPassword().equals(userPassword)){
                userOnline = user;
                control = false;
                break;
            }
        }
        if(control){
            userOnline = null;
        }
        return userOnline;
    }

    // ----- Redefinição da senha do Usuário na Área Login ----- //
    public void redefinePassword(){
        String userSearchName = input.searchName();
        String userSearchEmail = input.searchEmail();
        boolean control = true;
        for(User user: this.userList){
            if(user.getName().equals(userSearchName) && user.getEmail().equals(userSearchEmail)){
                String password = input.editPassword();
                user.setPassword(password);
                System.out.println("\nSenha alterada com sucesso.");
                control = false;
                break;
            }
        }
        if(control){
            System.out.println("\nInformações incorretas. Tente Novamente.");
        }
    }

    /*---------------------------------------- 
    |                                        |
    |              PROJECT AREA              |
    |                                        |
    ----------------------------------------*/

    // ----- Criação do Projeto da Área ----- //
    public void addProject(User userOnline){
        String idProject = input.newIdProject();
        String description = input.newDescriptionProject();
        String firstPeriod = input.newDateFirst();
        String lastPeriod = input.newDateLast();
        User coordinator = new User();
        for(User user : this.userList){
            if(user==userOnline){
                coordinator = user;
                break;
            }
        }
        System.out.println("O coordenador do Projeto: "+coordinator.getName()+" "+coordinator.getLastName());
        ArrayList<User> listUsers = input.listUsersProjects(userList);
        ArrayList<Activities> listActivities = this.listActivities();
        ArrayList<Bags> bags = input.listBags(listUsers);
        Project p = new Project(idProject, description, firstPeriod, lastPeriod, coordinator, listUsers, listActivities, bags);
        this.projectList.add(p);
        System.out.println("\nProjeto Criado com Sucesso.");
    }
    public ArrayList<Activities> listActivities(){
        ArrayList<Activities> list = new ArrayList<>();
        boolean control = true;
        while(control){
            int option = input.optionActivitiesProjects();
            switch(option){
                case 0:
                    control = false;
                    System.out.println("\nLista finalizada com Sucesso.");
                    break;
                case 1:
                    Activities activities = this.addActivity();
                    list.add(activities);
                    System.out.println("\nAtividade adicionada com Sucesso.");
                    break;
                default:
                    System.out.println("Comando Invalido");
                    break;
            }
        }
        return list;
    }
    
    // ----- Remoção de Projeto da Área ----- //
    public void removeProject(User userOnline){
        String idProject = input.getIdProjectForDelete();
        boolean control = true;
        Project source = new Project();
        for(Project project : this.projectList){
            if(project.getIdProject().equals(idProject)){
                control = false;
                source = project;
            }
        }
        if(control){System.out.println("\nProjeto Não Encontrado.");}
        else{
            if(source.getCoordinator().equals(userOnline)){
                String password = input.getPasswordProjectForDelete();
                if(userOnline.getPassword().equals(password)){
                    for(Project prj : this.projectList){
                        if(prj.getIdProject().equals(idProject)){
                            this.projectList.remove(prj);
                            System.out.println("\nProjeto Excluido com Sucesso.");
                            break;
                        }
                    }
                }
                else{
                    System.out.println("\nSenha Incorreta");
                }
            }
            else{
                System.out.println("\nUsuário Atual não é Coordenador do Projeto.");
            }
        }
    }

    /*---------------------------------------- 
    |                                        |
    |             ACTIVITY AREA              |
    |                                        |
    ----------------------------------------*/

    // ----- Criação de Atividade da Área ----- //
    public Activities addActivity(){
        String idAcitivity = input.newIdActivity();
        String description = input.newDescriptionActivity();
        String firstPeriod = input.newDateFirstActivity();
        String lastPeriod = input.newDateFirstActivity();
        boolean control = true;
        User coordinator = new User();
        while(control){
            String nameCoordinator = input.newCoordinatorName();
            String lastNameCoordinator = input.newCoordinatorLastName();
            boolean op = true;
            for(User user:this.userList){
                if(user.getName().equals(nameCoordinator) && user.getLastName().equals(lastNameCoordinator)){
                    coordinator = user;
                    System.out.println("Coordenador Adicionado a atividade.");
                    op = false;
                    control = false;
                    break;
                }
            }
            if(op){
                control = true;
                System.out.println("Usuário não encontrado.");
            }
        }
        ArrayList<User> listUsers = input.listUsersActivities(userList);
        ArrayList<Tasks> listTasks = input.listTasksActivities(listUsers);
        Activities activities = new Activities(idAcitivity, description, firstPeriod, lastPeriod, coordinator, listUsers, listTasks);
        return activities;
    }
   
}