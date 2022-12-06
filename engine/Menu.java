package engine;


import auxiliaries.Date;
import auxiliaries.Input;
import entities.User;
import office.Activities;
import office.Bags;
import office.Project;

public class Menu {
    private Input input = new Input();

    // ----- Construtores - Overloading ----- //
    public Menu(Date dataBase){
        this.menuArea(dataBase);
    }

    // ----- Utilidade para o Construtor da Classe ----- //
    private void menuArea(Date dataBase){
        if(dataBase.getUserOnline().getChoose()==4 || dataBase.getUserOnline().getChoose()==5){
            boolean control = true;
            while(control){
                int option = input.optionAreaMenu();
                switch(option){
                    case 0:
                        control = false;
                        System.out.println("\nSessão encerrada com Sucesso.");
                        break;
                    case 1:
                        this.profileArea(dataBase);
                        break;
                    case 2:
                        this.consultArea(dataBase);
                        break;
                    case 3:
                        this.paymentArea(dataBase);
                        break;
                    case 4:
                        this.projectsArea(dataBase);
                        break;
                    case 5:
                        this.activitiesArea(dataBase);
                        break;
                    default:
                        System.out.println("Comando Invalido.");
                        break;
                }
            } 
        }
        else{
            boolean control = true;
            while(control){
                int option = input.optionAreaMenu(1);
                switch(option){
                    case 0:
                        control = false;
                        System.out.println("\nSessão encerrada com Sucesso.");
                        break;
                    case 1:
                        this.profileArea(dataBase);
                        break;
                    case 2:
                        this.consultArea(dataBase);
                        break;
                    default:
                        System.out.println("Comando Invalido.");
                        break;
                }
            } 
        }
    }

    /*---------------------------------------- 
    |                                        |
    |               MENU AREA                |
    |                                        |
    ----------------------------------------*/
    
    // ----- Acesso a Área de Perfil ----- //
    private void profileArea(Date dataBase){
        int option = input.optionPerfil();
        switch(option){
            case 1:
                int optionAUX = input.optionEditInformation();
                if(optionAUX == 1){
                    for(User user:dataBase.getUserList()){
                        if(user.equals(dataBase.getUserOnline())){
                            String email = input.getEmail();
                            user.setEmail(email);
                            System.out.println("\nEmail alterado com Sucesso.");
                            break;
                        }
                    }
                }
                else if(optionAUX == 2){
                    for(User user:dataBase.getUserList()){
                        if(user.equals(dataBase.getUserOnline())){
                            String password = input.getPassword();
                            user.setPassword(password);
                            System.out.println("\nSenha alterada com Sucesso.");
                            break;
                        }
                    }
                }
                else{System.out.println("\nComando Invalido.");}
                break;
            case 2:
                dataBase.getUserOnline().printReport(dataBase);
                break;
            default:
                System.out.println("\nComando Invalido.");
                break;
        }
    }
    //ok
    // ----- Acesso a Área de Consulta ----- //
    private void consultArea(Date dataBase){
        int option = input.optionConsult();
        switch(option){
            case 1:
                String nameCaseOne = input.newName();
                String nameLastCaseOne = input.newlastName();
                boolean controlCaseOne = true;
                for(User user: dataBase.getUserList()){
                    if(user.getName().equals(nameCaseOne) && user.getLastName().equals(nameLastCaseOne)){
                        System.out.println("\n"+user.toString());
                        int opCaseOne = input.optionMoreInf();
                        switch(opCaseOne){
                            case 0:
                                break;
                            case 1:
                                user.printReport(dataBase);
                                break;
                            default:
                                System.out.println("\nComando Invalido.");
                                break;
                        }
                        controlCaseOne=false;
                        break;
                    }
                }
                if(controlCaseOne){
                    System.out.println("\nUsuário não encontrado");
                }
                break;
            case 2:
                String nameProject = input.newIdProject();
                boolean controlCaseTwo= true;
                for(Project project: dataBase.getProjectList()){
                    if(project.getIdProject().equals(nameProject)){
                        System.out.println("\n"+project.toString());
                        int opCaseTwo = input.optionMoreInf();
                        switch(opCaseTwo){
                            case 0:
                                break;
                            case 1:
                                project.printReport();
                                break;
                            default:
                                System.out.println("\nComando Invalido.");
                        }
                        controlCaseTwo = false;
                        break;
                    }
                }
                if(controlCaseTwo){
                    System.out.println("\nProjeto Não Encontrado");
                }
                break;
            case 3:
                String namePjct = input.newIdProject();
                boolean controlCaseTree = true;
                for(Project p: dataBase.getProjectList()){
                    if(p.getIdProject().equals(namePjct)){
                        String nameActivity = input.newIdActivity();
                        Boolean controlCaseTreeTwo = true;
                        for(Activities act: p.getActivities()){
                            if(act.getIdActivity().equals(nameActivity)){
                                System.out.println("\n"+act.toString());
                                int opCaseTree = input.optionMoreInf();
                                switch(opCaseTree){
                                    case 0:
                                        break;
                                    case 1: 
                                        act.printReport();
                                        break;
                                    default:
                                        System.out.println("\nComando Invalido.");
                                        break;
                                }
                                controlCaseTreeTwo = false;
                                break;
                            }
                        }
                        if(controlCaseTreeTwo){
                            System.out.println("\nAtividade não Encontrada.");
                        }
                        controlCaseTree = false;
                        break;
                    }
                }
                if(controlCaseTree){
                    System.out.println("\nProjeto Não Encontrado");
                }
                break;
            default:
                System.out.println("\nComando Invalido");
                break;
        }
    }

    // ----- Acesso a Área de Pagamentos ----- //
    private void paymentArea(Date dataBase){
        String nameProject = input.sourceProjects();
        boolean control = true;
        for(Project pj: dataBase.getProjectList()){
            if(pj.getIdProject().equals(nameProject)){
                String nameUser = input.newName();
                String nameLastUser = input.newlastName();
                boolean controlCaseOne = true;
                for(Bags bgs: pj.getBags()){
                    if(bgs.getUser().getName().equals(nameUser) && bgs.getUser().getLastName().equals(nameLastUser)){
                        if(bgs.getPayment()){
                            System.out.println("\nPagamento Feito.");
                        }
                        else{
                            System.out.println("\nValor: R$"+bgs.getValue()+".00");
                            int option = input.optionPayment();
                            switch(option){
                                case 1:
                                    bgs.setPayment(true);
                                    System.out.println("\nPagamento Realizado com Sucesso.");
                                    break;
                                default:
                                    System.out.println("\nPagamento não Realizado.");
                                    break;
                            }
                        }
                        controlCaseOne = false;
                        break;
                    }
                }
                if(controlCaseOne){
                    System.out.println("\nUsuário não Encontrado.");
                }
                control = false;
                break;
            }
        }
        if(control){
            System.out.println("\nProjeto não Encontrado.");
        }
    }

    // ----- Acesso a Área de Projetos ----- //
    private void projectsArea(Date dataBase){
        boolean control = true;
        while (control){
            int option = input.optionAreaProjects();
            switch(option){
                case 0:
                    control = false;
                    break;
                case 1:
                    dataBase.addProject(dataBase.getUserOnline());
                    break;
                case 2:
                    String nameProject = input.sourceProjects();
                    boolean controlCaseTwo = true;
                    for(Project p: dataBase.getProjectList()){
                        if(p.getIdProject().equals(nameProject) && p.getCoordinator().equals(dataBase.getUserOnline())){
                            int opCaseTwo = input.optionAreaEditProjets();
                            switch(opCaseTwo){
                                case 1:
                                    String newName = input.newIdProject();
                                    p.setIdProject(newName);
                                    System.out.println("\nId alterado com sucesso.");
                                    break;
                                case 2:
                                    String newDescription = input.newDescriptionProject();
                                    p.setDescriptionProject(newDescription);
                                    System.out.println("\nDescrição alterada com sucesso.");
                                    break;
                                case 3:
                                    String newFirstPeriod = input.newDateFirst();
                                    p.setFirstPeriod(newFirstPeriod);
                                    System.out.println("\nData Inicial alterada com sucesso.");
                                    break;
                                case 4:
                                    String newLastPeriod = input.newDateLast();
                                    p.setLastPeriod(newLastPeriod);
                                    System.out.println("\nData Final alterada com sucesso.");
                                    break;
                                case 5:
                                    String name = input.nameUser();
                                    String firstName = input.newlastName();
                                    boolean controlCaseFive = true;
                                    for(User user: dataBase.getUserList()){
                                        if(user.getName().equals(name) && user.getLastName().equals(firstName)){
                                            p.addUser(user);
                                            int value = input.getBagValue();
                                            String period = input.newDatePeriod();
                                            p.addBag(dataBase.getUserOnline(), value,period);
                                            controlCaseFive = false;
                                            System.out.println("\nUsuário adicionado com Sucesso.");
                                            break;
                                        }
                                    }
                                    if(controlCaseFive){
                                        System.out.println("\nUsuário não Encontrado");
                                    }
                                    break;
                                case 6:
                                    String nm = input.nameUser();
                                    String firstNm = input.newlastName();
                                    boolean controlCaseSix = true;
                                    for(User user: p.getProfessionals()){
                                        if(user.getName().equals(nm) && user.getLastName().equals(firstNm)){
                                            p.getProfessionals().remove(user);
                                            controlCaseSix = false;
                                            System.out.println("\nUsuário removido com Sucesso.");
                                            break;
                                        }
                                    }
                                    if(controlCaseSix){
                                        System.out.println("\nUsuário não Encontrado");
                                    }
                                    break;
                                case 7:
                                    String nameUser = input.nameUser();
                                    String firstNameUser = input.newlastName();
                                    boolean controlCaseSeven = true;
                                    for(User user: p.getProfessionals()){
                                        if(user.getName().equals(nameUser) && user.getLastName().equals(firstNameUser)){
                                            int value = input.getBagValue();
                                            String pd = input.newDatePeriod();
                                            p.editBagValue(user, value,pd);
                                            controlCaseSeven = false;
                                            System.out.println("\nBolsa editada com Sucesso.");
                                            break;
                                        }
                                    }
                                    if(controlCaseSeven){
                                        System.out.println("\nUsuário não Encontrado");
                                    }
                                    break;
                                default:
                                    System.out.println("\nComando Invalido.");
                                    break;
                            }
                            controlCaseTwo = false;
                            break;
                        }
                    }
                    if(controlCaseTwo){
                        System.out.println("\nProjeto não Encontrado.");
                    }
                    break;
                case 3:
                    dataBase.removeProject(dataBase.getUserOnline());
                    break;
                case 4:
                    String nmProject = input.sourceProjects();
                    boolean ctrlEdit = true;
                    for(Project p: dataBase.getProjectList()){
                        if(p.getIdProject().equals(nmProject) && p.getCoordinator().equals(dataBase.getUserOnline())){
                            System.out.println("\nStatus do Projeto: "+ p.getStatus());
                            int opt = input.optionEditStatus();
                            switch(opt){
                                case 0:
                                    break;
                                case 1:
                                    p.statusProject();
                                    break;
                                default:
                                    System.out.println("\nComando Invalido");
                                    break;
                            }
                            ctrlEdit = false;
                            break;
                        }
                    }
                    if(ctrlEdit){
                        System.out.println("\nProjeto não Encontrado.");
                    }
                    break;
                default:
                    System.out.println("\nComando Invalido");
                    break;
            }
        }
    }

    // ----- Acesso a Área de Atividades ----- //
    private void activitiesArea(Date dataBase){
        String idProject = input.sourceProjects();
        boolean c = true;
        for(Project p: dataBase.getProjectList()){
            if(p.getIdProject().equals(idProject) && p.getCoordinator() == dataBase.getUserOnline()){
                Boolean control = true;
                while(control){
                    int option = input.optionAreaActivities();
                    switch(option){
                        case 0:
                            control=false;
                            break;
                        case 1:
                            Activities act = dataBase.addActivity();
                            p.addActivity(act);
                            System.out.println("\nAtividade adicionada com Sucesso.");
                            break;
                        case 2:
                            String nameActivity = input.sourceActivities();
                            boolean controlEdit = true;
                            for(Activities activities:p.getActivities()){
                                if(activities.getIdActivity().equals(nameActivity)){
                                    int optCaseTwo = input.optionEditActivity();
                                    switch(optCaseTwo){
                                        case 1:
                                            String newName = input.newIdActivity();
                                            activities.setIdActivity(newName);
                                            System.out.println("\nId alterado com sucesso.");
                                            break;
                                        case 2:
                                            String newDescription = input.newDescriptionActivity();
                                            activities.setDescriptionActivity(newDescription);
                                            System.out.println("\nDescrição alterada com sucesso.");
                                            break;
                                        case 3:
                                            String newFirstPeriod = input.newDateFirstActivity();
                                            activities.setFirstPeriod(newFirstPeriod);
                                            System.out.println("\nData Inicial alterada com sucesso.");
                                            break;
                                        case 4:
                                            String newLastPeriod = input.newDateLastActivity();
                                            activities.setLastPeriod(newLastPeriod);
                                            System.out.println("\nData Final alterada com sucesso.");
                                            break;
                                        case 5:
                                            boolean controlCaseFive = true;
                                            while(controlCaseFive){
                                                String nameCoordinator = input.newCoordinatorName();
                                                String lastNameCoordinator = input.newCoordinatorLastName();
                                                boolean controlCaseFiveTwo = true;
                                                for(User user:dataBase.getUserList()){
                                                    if(user.getName().equals(nameCoordinator) && user.getLastName().equals(lastNameCoordinator)){
                                                        activities.setCoordinatorActivity(user);
                                                        System.out.println("\nCoordenador Adicionado a atividade.");
                                                        controlCaseFiveTwo = false;
                                                        controlCaseFive = false;
                                                        break;
                                                    }
                                                }
                                                if(controlCaseFiveTwo){
                                                    controlCaseFive = true;
                                                    System.out.println("\nUsuário não encontrado.");
                                                }
                                            }
                                            break;
                                        case 6:
                                            String name = input.nameUser();
                                            String firstName = input.newlastName();
                                            boolean controlCaseSix = true;
                                            for(User user: dataBase.getUserList()){
                                                if(user.getName().equals(name) && user.getLastName().equals(firstName)){
                                                    activities.addUserProfessional(user);
                                                    String newtask = input.taskUser();
                                                    activities.addTaskUserProfessional(user, newtask);
                                                    controlCaseSix = false;
                                                    System.out.println("\nUsuário adicionado com Sucesso.");
                                                    break;
                                                }
                                            }
                                            if(controlCaseSix){
                                                System.out.println("\nUsuário não Encontrado");
                                            }
                                            break;
                                        case 7:
                                            String nm = input.nameUser();
                                            String firstNm = input.newlastName();
                                            boolean controlCaseSeven = true;
                                            for(User user: activities.getProfessionalsActivity()){
                                                if(user.getName().equals(nm) && user.getLastName().equals(firstNm)){
                                                    activities.getProfessionalsActivity().remove(user);
                                                    controlCaseSeven = false;
                                                    System.out.println("\nUsuário removido com Sucesso.");
                                                    break;
                                                }
                                            }
                                            if(controlCaseSeven){
                                                System.out.println("\nUsuário não Encontrado");
                                            }
                                            break;
                                        case 8:
                                            String nameUser = input.nameUser();
                                            String firstNameUser = input.newlastName();
                                            boolean controlCaseEight = true;
                                            for(User user: activities.getProfessionalsActivity()){
                                                if(user.getName().equals(nameUser) && user.getLastName().equals(firstNameUser)){
                                                    String newtask = input.taskUser();
                                                    activities.editTask(user, newtask);
                                                    controlCaseEight = false;
                                                    System.out.println("\nTarefa editada com Sucesso.");
                                                    break;
                                                }
                                            }
                                            if(controlCaseEight){
                                                System.out.println("\nUsuário não Encontrado");
                                            }
                                            break;
                                        default:
                                            System.out.println("Comando Invalido.");
                                            break;
                                    }
                                    controlEdit = false;
                                    break;
                                }
                            }
                            if(controlEdit){
                                System.out.println("\nAtividade não encontrada");
                            }
                            break;
                        case 3:
                            String nameAct = input.sourceActivities();
                            boolean ctrl = true;
                            for(Activities activity:p.getActivities()){
                                if(activity.getIdActivity().equals(nameAct)){
                                    p.getActivities().remove(activity);
                                    System.out.println("\nAtividade removida com Sucesso");
                                    ctrl = false;
                                    break;
                                }
                            }
                            if(ctrl){
                                System.out.println("\nAtividade não encontrada.");
                            }
                            break;
                        default:
                            System.out.println("\nComando Invalido");
                            break;
                    }
                }
                c = false;
                break;
            }
        }
        if(c){
            System.out.println("\nProjeto não existente ou Usuário Online não é Coordenador do Projeto.");
        }
    }
    
}
