package office;

import entities.User;

public class Bags {
    private User user;
    private int value;
    private String period;
    private boolean payment = false;

    // ----- Construtores - Overloading ----- //
    public Bags(User user, Integer value, String period){
        this.user = user;
        this.value = value;
        this.period = period;
        this.payment = false;
    }
    public Bags(Integer value, String period){
        this(new User(), value, period);
    }
    

    // ----- Getters da Classe ----- //
    public User getUser() {
        return user;
    }
    public int getValue() {
        return value;
    }
    public String getPeriod() {
        return period;
    }
    public Boolean getPayment(){
        return payment;
    }

    // ----- Setters da Classe ----- //    
    public void setUser(User user) {
        this.user = user;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public void setPeriod(String period) {
        this.period = period;
    }
    public void setPayment(boolean payment) {
        this.payment = payment;
    }
    
}