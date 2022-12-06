package auxiliaries;

import java.util.ArrayList;
import java.util.Scanner;

import entities.User;
import office.Bags;
import office.Tasks;

public class Input {
    private Scanner sc = new Scanner(System.in);
    
    /*---------------------------------------- 
    |                                        |
    |          LOGIN AREA - CLASS A          |      - Login.java 
    |                                        |
    ----------------------------------------*/
    
    // ----- Entrada de dados da escolha na Área ----- //
    public int optionLoginArea(){
        System.out.println("\nDigite a opção desejada:\n0 - Fechar o Programa\n1 - Criar Usuario\n2 - Realizar Login\n3 - Recuperar Senha");
        return this.getOption();
    }

    /*---------------------------------------- 
    |                                        |
    |          LOGIN AREA - CLASS B          |      - Login.java
    |                                        |
    ----------------------------------------*/

    // ----- Entrada de dados da escolha na Área da função addUser ----- //
    public int getOffice(){
        System.out.println("\nDigite sua Classificação:");
        System.out.println("       [1] - Aluno de Graduação       |       [2] - Aluno de Mestrado        |       [3] - Aluno de Doutorado       ");
        System.out.println("           [4] - Professor            |          [5] - Pesquisador           |  [6] - Profissional (Desenvolvedor)  ");
        System.out.println("     [7] - Profissional (Testador)    |    [8] - Profissional (Analista)     |     [9] - Profissional (Técnico)     ");
        return this.getOption();
    }

    // ----- Entrada de dados na Área da função addUser ----- //
    public String newName(){
        System.out.println("Digite o nome do usuário:");
        return this.getString();
    }
    public String newlastName(){
        System.out.println("Digite o Sobrenome do usuário:");
        return this.getString();
    }
    public String newEmail(){
        System.out.println("Digite o email do usuário:");
        return this.getString();
    }
    public String newPassword(){
        System.out.println("Digite a senha do usuário:");
        return this.getString();
    }

    // ----- Entrada de dados na Área da função loginUser ----- //
    public String getEmail(){
        System.out.println("\nDigite o email do usuário: ");
        return this.getString();
    }
    public String getPassword(){
        System.out.println("Digite a senha do Usuário: ");
        return this.getString();
    }

    // ----- Entrada de dados na Área da função redefinePassword ----- //
    public String searchName(){
        System.out.println("\nDigite o nome do usuário a redefinir a senha:");
        return this.getString();
    }
    public String searchEmail(){
        System.out.println("Digite o email do usuário a redefinir a senha:");
        return this.getString();
    }
    public String editPassword(){
        System.out.println("Digite a nova senha do usuário:");
        return this.getString();
    }

    /*---------------------------------------- 
    |                                        |
    |         PROJECT AREA - CLASS A         |      - Date.java
    |                                        |
    ----------------------------------------*/

    // ----- Entrada de dados na Área da função addProject ----- //
    public String newIdProject(){
        System.out.println("Digite o Id do Projeto:");
        return this.getString();
    }
    public String newDescriptionProject(){
        System.out.println("Digite a Descrição do Projeto:");
        return this.getString();
    }
    public String newDateFirst(){
        System.out.println("Digite o Periodo Inicial do Projeto:\nDigite o Dia: [DD]");
        int day = this.getOption();
        System.out.println("Digite o Mês: [MM]");
        int month = this.getOption();
        System.out.println("Digite o Ano: [AAAA]");
        int year = this.getOption();
        System.out.println("Digite a Hora: [HH]");
        int hour = this.getOption();
        System.out.println("Digite os Minutos: [mm]");
        int minutes = this.getOption();
        String Date = String.valueOf(day)+"/"+String.valueOf(month)+"/"+String.valueOf(year)+" / "+String.valueOf(hour)+":"+String.valueOf(minutes);
        return Date;
    }
    public String newDateLast(){
        System.out.println("Digite o Periodo Final do Projeto:\nDigite o Dia: [DD]");
        int day = this.getOption();
        System.out.println("Digite o Mês: [MM]");
        int month = this.getOption();
        System.out.println("Digite o Ano: [AAAA]");
        int year = this.getOption();
        System.out.println("Digite a Hora: [HH]");
        int hour = this.getOption();
        System.out.println("Digite os Minutos: [mm]");
        int minutes = this.getOption();
        String Date = String.valueOf(day)+"/"+String.valueOf(month)+"/"+String.valueOf(year)+" / "+String.valueOf(hour)+":"+String.valueOf(minutes);
        return Date;
    }

    public int optionUsersProjects(){
        System.out.println("Inscrição dos Usuários no Projeto, por favor digite a opção desejada:\n0 - Finalizar Lista\n1 - Adicionar Usuário");
        return this.getOption();
    }
    public ArrayList<User> listUsersProjects(ArrayList<User> userList){
        ArrayList<User> list = new ArrayList<>();
        boolean control = true;
        while (control){
            int option = this.optionUsersProjects();
            switch(option){
                case 0:
                    control = false;
                    System.out.println("Lista finalizada com Sucesso.");
                    break;
                case 1:
                    System.out.println("Digite o Nome do Usuário:");
                    String name = this.getString();
                    System.out.println("Digite o Sobrenome do Usuário:");
                    String firstName = this.getString();
                    boolean ctrl = true;
                    for(User user: userList){
                        if(user.getName().equals(name) && user.getLastName().equals(firstName)){
                            list.add(user);
                            ctrl = false;
                            System.out.println("Usuário adicionado com Sucesso.");
                            break;
                        }
                    }
                    if(ctrl){
                        System.out.println("Usuário Não Encontrado");
                    }
                    break;
                default:
                    System.out.println("Comando Invalido");
                    break;
            }
        }
        return list;
    }

    // ----- Entrada de dados na Área da função listActivities ----- //
    public int optionActivitiesProjects(){
        System.out.println("Inscrição de Atividades no Projeto, por favor digite a opção desejada:\n0 - Finalizar Lista\n1 - Adicionar Atividade");
        return this.getOption();
    }

    // ----- Entrada de dados na Área da função addProject ----- //
    public ArrayList<Bags> listBags(ArrayList<User> listUsers){
        ArrayList<Bags> list = new ArrayList<>();
        for(User user: listUsers){
            System.out.println("Digite o Valor da Bolsa do Usuário "+user.getName()+" "+user.getLastName()+":");
            int value = this.getOption();
            String period = this.newDatePeriod();
            Bags bags = new Bags(user, value, period);
            list.add(bags);
        }
        return list;
}

    // ----- Entrada de dados na Área da função removeProject ----- //
    public String getIdProjectForDelete(){
        System.out.println("Digite o nome do Projeto:");
        return this.getString();
    }
    public String getPasswordProjectForDelete(){
        System.out.println("Digite a Senha de Perfil para concluir o Processo de Exclusão:");
        return this.getString();
    }

    /*---------------------------------------- 
    |                                        |
    |        ACTIVITY AREA - CLASS A         |      - Date.java
    |                                        |
    ----------------------------------------*/

    // ----- Entrada de dados na Área da função addActivity ----- //
    public String newIdActivity(){
        System.out.println("Digite o Id da Atividade:");
        return getString();
    }
    public String newDescriptionActivity(){
        System.out.println("Digite a Descrição da Atividade:");
        return getString();
    }
    public String newDateFirstActivity(){
        System.out.println("Digite o Periodo Inicial da Atividade:\nDigite o Dia: [DD]");
        int day = this.getOption();
        System.out.println("Digite o Mês: [MM]");
        int month = this.getOption();
        System.out.println("Digite o Ano: [AAAA]");
        int year = this.getOption();
        System.out.println("Digite a Hora: [HH]");
        int hour = this.getOption();
        System.out.println("Digite os Minutos: [mm]");
        int minutes = this.getOption();
        String Date = String.valueOf(day)+"/"+String.valueOf(month)+"/"+String.valueOf(year)+" / "+String.valueOf(hour)+":"+String.valueOf(minutes);
        return Date;
    }
    public String newDateLastActivity(){
        System.out.println("Digite o Periodo Final da Atividade:\nDigite o Dia: [DD]");
        int day = this.getOption();
        System.out.println("Digite o Mês: [MM]");
        int month = this.getOption();
        System.out.println("Digite o Ano: [AAAA]");
        int year = this.getOption();
        System.out.println("Digite a Hora: [HH]");
        int hour = this.getOption();
        System.out.println("Digite os Minutos: [mm]");
        int minutes = this.getOption();
        String Date = String.valueOf(day)+"/"+String.valueOf(month)+"/"+String.valueOf(year)+" / "+String.valueOf(hour)+":"+String.valueOf(minutes);
        return Date;
    }
    public String newCoordinatorName(){
        System.out.println("Digite o Nome do Coordenador da Atividade:");
        return getString();
    }
    public String newCoordinatorLastName(){
        System.out.println("Digite o Sobrenome do Coordenador da Atividade:");
        return getString();
    }
    
    public int optionUsersActivities(){
        System.out.println("Inscrição de Usuários na Atividade, por favor digite a opção desejada:\n0 - Finalizar Lista\n1 - Adicionar Usuário");
        return this.getOption();
    }
    public ArrayList<User> listUsersActivities(ArrayList<User> userList){
        ArrayList<User> list = new ArrayList<>();
        boolean control = true;
        while (control){
            int option = this.optionUsersActivities();
            switch(option){
                case 0:
                    control = false;
                    break;
                case 1:
                    System.out.println("Digite o Nome do Usuário:");
                    String name = getString();
                    System.out.println("Digite o Sobrenome do Usuário:");
                    String lastName = getString();
                    boolean get = true;
                    for(User user: userList){
                        if(user.getName().equals(name) && user.getLastName().equals(lastName)){
                            list.add(user);
                            get = false;
                            System.out.println("Usuário adicionado com Sucesso.");
                            break;
                        }
                    }
                    if(get){
                        System.out.println("Usuário Não Encontrado");
                    }
                    break;
                default:
                    System.out.println("Comando Invalido");
                    break;
            }
        }
        return list;
    }
    
    public ArrayList<Tasks> listTasksActivities(ArrayList<User> listUsers){
        ArrayList<Tasks> list = new ArrayList<>();
        for(User user: listUsers){
            System.out.println("Digite a Tarefa do Usuário "+user.getName()+" "+user.getLastName()+":");
            String task = getString();
            Tasks taskadd = new Tasks(user, task);
            list.add(taskadd);
        }
        return list;
    }

    /*---------------------------------------- 
    |                                        |
    |         MENU AREA - CLASS A            |      - Menu.java
    |                                        |
    ----------------------------------------*/

    // ----- Entrada de dados da escolha na Área da função menuArea ----- //
    public int optionAreaMenu(){
        System.out.println("\nDigite a opção desejada:\n0 - Encerrar Sessão\n1 - Área de Perfil\n2 - Área de Consultas e Relatórios");
        System.out.println("3 - Área de Pagamentos\n4 - Área de Projetos\n5 - Área de Atividades");
        return this.getOption();
    }
    public int optionAreaMenu(int number){
        System.out.println("\nDigite a opção desejada:\n0 - Encerrar Sessão\n1 - Área de Perfil\n2 - Área de Consultas e Relatórios");
        return this.getOption();
    }

    /*---------------------------------------- 
    |                                        |
    |        PROFILE AREA - CLASS A          |      - Menu.java
    |                                        |
    ----------------------------------------*/

    // ----- Entrada de dados da escolha na Área da função profileArea ----- //
    public int optionPerfil(){
        System.out.println("Digite a opção desejada:\n1 - Editar Informações\n2 - Obter Informações");
        return this.getOption();
    }
    public int optionEditInformation(){
        System.out.println("Digite a opção desejada:\n1 - Editar Email\n2 - Editar Senha");
        return this.getOption();
    }

    /*---------------------------------------- 
    |                                        |
    |        CONSULT AREA - CLASS A          |      - Menu.java
    |                                        |
    ----------------------------------------*/
    
    // ----- Entrada de dados da escolha na Área da função consultArea ----- //
    public int optionConsult(){
        System.out.println("\nDigite a opção desejada:\n1 - Consultar Usuário\n2 - Consultar Projeto\n3 - Consultar Atividade");
        return this.getOption();
    }
    public int optionMoreInf(){
        System.out.println("\nDigite a opção desejada:\n0 - Retornar\n1 - Obter Relatórios");
        return this.getOption();
    }

    /*---------------------------------------- 
    |                                        |
    |        PAYMENT AREA - CLASS A          |      - Menu.java
    |                                        |
    ----------------------------------------*/

    // ----- Entrada de dados da escolha na Área da função paymentArea ----- //
    public int optionPayment(){
        System.out.println("\nDigite a opção desejada:\n1 - Realizar Pagamento");
        return this.getOption();
    }

    // ----- Entrada de dados na Área da função paymentArea ----- //
    public String sourceProjects(){
        System.out.println("\nDigite o Id do Projeto Procurado:");
        return getString();
    }

    /*---------------------------------------- 
    |                                        |
    |        PROJECTS AREA - CLASS A         |      - Menu.java
    |                                        |
    ----------------------------------------*/

    // ----- Entrada de dados da escolha na Área da função projectsArea ----- //
    public int optionAreaProjects(){
        System.out.println("\nDigite a opção desejada:\n0 - Retornar Menu\n1 - Criar Projeto\n2 - Editar Projeto\n3 - Excluir Projeto\n4 - Alterar Status");
        return this.getOption();
    }
    public int optionAreaEditProjets(){
        System.out.println("\nDigite a opção desejada:\n1 - Editar Id do Projeto\n2 - Editar Descrição do Projeto\n3 - Editar Periodo Inicial do Projeto");
        System.out.println("4 - Editar Periodo Final do Projeto\n5 - Adicionar Usuário do Projeto\n6 - Remover Usuário do Projeto\n7 - Editar Bolsa\nObs: Para editar atividades dirija-se a área de Atividades.");
        return this.getOption();
    }
    public int optionEditStatus(){
        System.out.println("Digite a opção desejada:\n0 - Não Alterar Status\n1 - Alterar Status");
        return this.getOption();
    }

    // ----- Entrada de dados na Área da função projectsArea ----- //
    public String newDatePeriod(){
        System.out.println("Digite o Periodo de Vigência da Bolsa:\nDigite o Dia: [DD]");
        int day = this.getOption();
        System.out.println("Digite o Mês: [MM]");
        int month = this.getOption();
        System.out.println("Digite o Ano: [AAAA]");
        int year = this.getOption();
        System.out.println("Digite a Hora: [HH]");
        int hour = this.getOption();
        System.out.println("Digite os Minutos: [mm]");
        int minutes = this.getOption();
        String Date = String.valueOf(day)+"/"+String.valueOf(month)+"/"+String.valueOf(year)+" / "+String.valueOf(hour)+":"+String.valueOf(minutes);
        return Date;
    }
    public int getBagValue(){
        System.out.println("Digite o Valor da Bolsa:");
        return this.getOption();
    }

    /*---------------------------------------- 
    |                                        |
    |       ACTIVITIES AREA - CLASS A        |      - Menu.java
    |                                        |
    ----------------------------------------*/

    // ----- Entrada de dados da escolha na Área da função activitiesArea ----- //
    public int optionAreaActivities(){
        System.out.println("\nDigite a opção desejada:\n0 - Retornar Menu\n1 - Criar Atividades\n2 - Editar Atividades\n3 - Excluir Atividades");
        return this.getOption();
    }
    public int optionEditActivity(){
        System.out.println("\nDigite a opção desejada:\n1 - Editar Id da Atividade\n2 - Editar Descrição da Atividade\n3 - Editar Periodo de Inicio da Atividade\n4 - Editar Periodo Final da Atividade");
        System.out.println("5 - Editar Coordenador da Atividade\n6 - Adicionar Usuário a Atividade\n7 - Remover Usuário\n8 - Editar Tarefa");
        return this.getOption();
    }

    // ----- Entrada de dados na Área da função activitiesArea ----- //
    public String sourceActivities(){
        System.out.println("\nDigite o Id da Atividade Procurada:");
        return getString();
    }
    public String nameUser(){
        System.out.println("Digite o Nome do Usuário:");
        return getString();
    }
    public String taskUser(){
        System.out.println("Digite a tarefa do usuário:");
        return getString();
    }

    // ----- Entrada de String ----- //
    public String getString(){
        String str = "";
        boolean control = true;
        do{
            str = sc.nextLine();
            if(str!=""){
                control = false;
            }
        }
        while(control);
        return str;
    }

    //Tratamento de Excessões geradas na Entrada das Opções
    public int getOption(){
        int option = 9999;
        boolean control = true;
        do{
            try{
                option = sc.nextInt();
                control = false;
            }
            catch(Exception e){
                sc.nextLine();
                System.out.println("\nDigite um Numero Inteiro, Por favor!");
            }
        }while(control);
        return option;
    }
}
