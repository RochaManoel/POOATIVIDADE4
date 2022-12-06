package entities;

public class Professional extends User{
    private String Office;

    // ----- Construtores - Overloading ----- //
    public Professional(String newName, String newlastName, String newEmail, String newPassword,int choose, String Office){
        super(newName, newlastName, newEmail, newPassword, choose);
        this.Office = Office;
    } 

    // ----- Getters da Classe ----- //
    public String getOffice() {
        return Office;
    }

    // ----- Setters da Classe ----- //
    public void setOffice(String office) {
        Office = office;
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
