package model;

import java.util.ArrayList;
public class Atividade{
    public Integer id;
    public String descricao;
    public String datainicio;
    public String datafinal;
    public User responsavel;
    public ArrayList<User> userList;
    private String status;

    public Atividade(Integer id, String descricao, String datainicio, String datafinal, User responsavel,
                     ArrayList<User> userList, String status) {
        super();
        this.id = id;
        this.descricao = descricao;
        this.datainicio = datainicio;
        this.datafinal = datafinal;
        this.responsavel = responsavel;
        this.userList = userList;
        this.status = status;
    }

    public void add_user(User usuario){
        this.userList.add(usuario);
    }
    public void activity_users(){
        System.out.println("Lista de usuarios: ");
        if (userList == null){
            System.out.println("sem participantes.");
        }
        else{
            for (User usuario: userList){
                System.out.print(usuario.getName() + "\n");
            }
        }
    }

    public void printar_coord(){
        if(responsavel != null){
            System.out.print("Responsavel: " + responsavel.getName());
        }
        else{
            System.out.print("sem responsavel no momento.");
        }
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(String datainicio) {
        this.datainicio = datainicio;
    }

    public String getDatafinal() {
        return datafinal;
    }

    public void setDatafinal(String datafinal) {
        this.datafinal = datafinal;
    }

    public void setResponsavel(User responsavel) {
        this.responsavel = responsavel;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
