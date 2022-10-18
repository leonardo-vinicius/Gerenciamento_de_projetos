package model;

import java.util.ArrayList;
public class Atividade{
    private Integer id;
    private String descricao;
    private String datainicio;
    private String datafinal;
    private User responsavel;
    public ArrayList<User> userList = new ArrayList<>();
    private String status;
    public boolean find_user(String email) {
        for (User user : userList) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
    public void add_user(User usuario){
        this.userList.add(usuario);
    }
    public Atividade(Integer id, String descricao, String datainicio, String datafinal, User responsavel,
                      String status, User user) {
        super();
        this.id = id;
        this.descricao = descricao;
        this.datainicio = datainicio;
        this.datafinal = datafinal;
        this.responsavel = responsavel;
        this.status = status;
        this.userList.add(user);
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
