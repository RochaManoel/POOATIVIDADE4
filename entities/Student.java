package entities;

public class Student extends User {
    private String Level;

    // ----- Construtores - Overloading ----- //
    public Student(String newName, String newlastName, String newEmail, String newPassword,int choose, String Level){
        super(newName, newlastName, newEmail, newPassword, choose);
        this.Level = Level;
    }

    // ----- Getters da Classe ----- //
    public String getLevel() {
        return Level;
    }

    // ----- Setters da Classe ----- //
    public void setLevel(String level) {
        Level = level;
    }

    @Override
    public String toString(){
        return super.toString();
    }

}