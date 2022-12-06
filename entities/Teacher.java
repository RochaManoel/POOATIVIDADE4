package entities;

public class Teacher extends User {
    private String Object;

    // ----- Construtores - Overloading ----- //
    public Teacher(String newName, String newlastName, String newEmail, String newPassword, int choose, String Object){
        super(newName, newlastName, newEmail, newPassword, choose);
        this.Object = Object;
    }

    // ----- Getters da Classe ----- //
    public String getObject() {
        return Object;
    }

    // ----- Setters da Classe ----- //
    public void setObject(String object) {
        Object = object;
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
