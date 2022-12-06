package entities;

import auxiliaries.Date;
import office.Activities;
import office.Bags;
import office.Project;

public class User {
    private String name;
    private String lastName;
    private String email;
    private String password;
    private int choose;

    // ----- Construtores - Overloading ----- //
    public User(){
    }
    public User(String newName, String newlastName, String newEmail, String newPassword, int choose){
        this.name = newName;
        this.lastName = newlastName;
        this.email = newEmail;
        this.password = newPassword;
        this.choose = choose;
    }

    // ----- Getters da Classe ----- //
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getLastName() {
        return lastName;
    }
    public int getChoose() {
        return choose;
    }

    // ----- Setters da Classe ----- //
    public void setPassword(String password) {
        this.password = password;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    // ----- Impressão de Consulta e Relatório da Classe ----- //
    public String office(){
        String str  = new String();
        int option = this.choose;
        switch(option){
            case 1:
                str ="Aluno de Graduação";
                break;
            case 2:
                str ="Aluno de Mestrado";
                break;
            case 3:
                str ="Aluno de Doutorado";
                break;
            case 4:
                str ="Professor";
                break;
            case 5:
                str ="Pesquisador";
                break;
            case 6:
                str ="Desenvolvedor";
                break;
            case 7:
                str ="Testador";
                break;
            case 8:
                str ="Análista";
                break;
            case 9:
                str ="Técnico";
                break;    
        }
        return str;
    }

    public String writeToString(){
        String Inf = "Nome Completo: "+this.name+" "+this.lastName+"\n"+
        "Email para Contato: "+this.email+"\nTipo de Usuário: "+office()+"\n";
        return Inf;
    }
  
    public String toString(){
        return this.writeToString();
    }
    public void bag(Date dataBase){
        System.out.println("\n - Bolsas:\n");
        for(Project pj: dataBase.getProjectList()){
            for(Bags bgs: pj.getBags()){
                if(bgs.getUser().getEmail().equals(this.email)){
                    System.out.println("    - Valor R$"+bgs.getValue()+".00 Periodo de Vigência: "+bgs.getPeriod()+" (Projeto: "+pj.getIdProject()+" ).");
                }
            }
        }
    }
    public void printReport(Date dataBase){
        System.out.println("\nFicha do Usuário\n");
        System.out.println(this.toString());
        System.out.println("\n - Projetos:\n");
        for(Project pjct: dataBase.getProjectList()){
            for(User user: pjct.getProfessionals()){
                if(user.getEmail().equals(this.getEmail())){
                    System.out.println("    - "+pjct.getIdProject());
                }
            }
        }
        this.bag(dataBase);
        System.out.println("\n - Atividades:\n");
        for(Project pj: dataBase.getProjectList()){
            boolean present = false;
            for(User user: pj.getProfessionals()){
                if(user.getEmail().equals(this.email)){
                    present = true;
                    break;
                }
            }
            if(present){
                for(Activities act: pj.getActivities()){
                    for(User user:act.getProfessionalsActivity()){
                        if(user.getEmail().equals(this.email)){
                            System.out.println("    - "+act.getIdActivity()+" (Projeto: "+pj.getIdProject()+").");
                        }     
                    }
                }
            }
            else{
                for(Activities act:pj.getActivities()){
                    for(User user:act.getProfessionalsActivity()){
                        if(user.getEmail().equals(this.email)){
                            System.out.println("    - "+act.getIdActivity()+" (Projeto: "+pj.getIdProject()+") OBS: Atividade de Intercâmbio.");
                        }
                    }
                }
            }
        }
        
    }

}