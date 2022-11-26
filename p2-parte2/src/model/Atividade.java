package model;

import java.util.ArrayList;
public class Atividade{
    public Dados dados;
    private User responsavel;
    public ArrayList<User> userList = new ArrayList<>();

    public void relatorio(){
        dados.DadosRelatorio();
        printar_coord();
        activity_users();
    }
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
    public Atividade(Dados dados, User responsavel, User user) {
        super();
        this.dados = dados;
        this.responsavel = responsavel;
        this.userList.add(user);
    }
    public void setDados(Integer id, String descricao, String datainicio, String datafinal, String status) {
        this.dados = new Dados(id, descricao, datainicio, datafinal, status);
    }
    public void activity_users(){
        System.out.println("Lista de usuarios: ");
            for (User usuario: userList){
                System.out.print(usuario.getName() + "\n");
            }
    }
    public void printar_coord(){
            System.out.println("Responsavel: " + responsavel.getName());
    }
    public void setResponsavel(User responsavel) {
        this.responsavel = responsavel;
    }

}
