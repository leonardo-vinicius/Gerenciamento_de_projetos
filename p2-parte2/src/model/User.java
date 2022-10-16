package model;

public abstract class User {
    public double salario;
    public String name;
    public String email;
    public String password;

    public User(double salario, String name, String email, String password) {
        this.setSalario(salario);
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public String getEmail(){
        return this.email;
    }
    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String toString() {
        return "Nome: " + this.name + ", Email: " + this.email + " ";
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }

    public abstract void alterar();

}
