package model;
import java.util.*;

public class Project {
    public ArrayList<User> userList = new ArrayList<>();
    public ArrayList<Atividade> listaAtividades = new ArrayList<>();
    private String status;
    private Integer id;
    private String descrition;
    private String databegin;
    private String dataend;
    private Integer bolsa;
    private double valor_bolsa;
    private String periodo_bolsa;

    public boolean find_user(String name) {
        for (User user : userList) {
            if (user.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
    public void relatorio() {
        System.out.println("Mostrando relatorio...");
        System.out.printf("id: %d\n", id);
        System.out.printf("descricao: %s\n", descrition);
        System.out.printf("status: %s\n", status);
        System.out.printf("Data de inicio do projeto: %s\n", databegin);
        System.out.printf("Data de término do projeto: %s\n", dataend);
        System.out.printf("período da bolsa: %s\n", periodo_bolsa);

        print_activity_projects();
        print_user_projects();
    }

    public void print_user_projects(){
        System.out.print("Lista de Usuarios:\n");
        for (User usuario: this.userList){
            System.out.print(usuario.getName() + "\n");
        }
    }

    public void add_user(User usuario){
        this.userList.add(usuario);
    }

    public void print_activity_projects(){
        System.out.println("Lista de Atividades:");
        for (Atividade atividade: this.listaAtividades){
            System.out.print(atividade.getDescricao() + "\n");
        }
    }
    public void add_atividade(Atividade atividade){
        this.listaAtividades.add(atividade);
    }
    public Project(String status, Integer id, String descrition, String databegin, String dataend,
                    Integer bolsa, Double valor_bolsa, String periodobolsa, User user) {
        super();
        this.setStatus(status);
        this.id = id;
        this.descrition = descrition;
        this.databegin = databegin;
        this.dataend = dataend;
        this.bolsa = bolsa;
        this.valor_bolsa = valor_bolsa;
        this.periodo_bolsa = periodobolsa;
        this.userList.add(user);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescrition() {
        return descrition;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }

    public String getDatabegin() {
        return databegin;
    }

    public void setDatabegin(String databegin) {
        this.databegin = databegin;
    }

    public String getDataend() {
        return dataend;
    }

    public void setDataend(String dataend) {
        this.dataend = dataend;
    }

    public Integer getBolsa() {
        return bolsa;
    }

    public void setBolsa(Integer bolsa) {
        this.bolsa = bolsa;
    }

    public String getPeriodo_bolsa() {
        return periodo_bolsa;
    }

    public void setPeriodobolsa(String periodobolsa) {
        this.periodo_bolsa = periodobolsa;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public double getValor_bolsa() {
        return valor_bolsa;
    }

    public void setValor_bolsa(double valor_bolsa) {
        this.valor_bolsa = valor_bolsa;
    }

}