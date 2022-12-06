package engine;

import auxiliaries.Date;
import auxiliaries.Input;
import entities.User;

public class Login {
    private Date dataBase = new Date();
    private Input input = new Input();

    // ----- Construtores - Overloading ----- //
    public Login(){
        this.loginArea();
    }

    // ----- Utilidade para o Construtor da Classe ----- //
    private void loginArea(){
        boolean control = true;
        while(control){
            int option = input.optionLoginArea();
            switch(option){
                case 0:
                    control = false;
                    System.out.println("\nPrograma encerrado com Sucesso.");
                    break;
                case 1:
                    dataBase.addUser();
                    break;
                case 2:
                    dataBase.setUserOnline(dataBase.loginUser());
                    if(dataBase.loginUser() != null){
                        new Menu(dataBase);
                    }
                    else{
                        System.out.println("\nInformações incorretas. Tente Novamente.");
                    }
                    break;
                case 3:
                    dataBase.redefinePassword();
                    break;
                default:
                    System.out.println("\nComando Invalido.");
                    break;
            }
        } 
    }



}
