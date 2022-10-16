package app;
import java.util.*;
import model.*;

public class App
{
    Scanner s = new Scanner(System.in);
    public ArrayList<Project> listaProjetos = new ArrayList<>();
    public ArrayList<Atividade> listaAtividades = new ArrayList<>();
    public ArrayList<User> userList = new ArrayList<>();
    public App(ArrayList<User> userList)
    {
        this.userList.addAll(userList);
        this.programa();
    }

    public void programa() {
        Integer todosatributosp = 0;
        Integer todosatributosa = 0;
        String status = "Em processo de criacao";
        this.listaProjetos.add(new Project("concluido", 14, "projeto1", "14/08/1999", "15/10/2020",1,1.200, "12/02/2022", userList.get(0)));
        this.listaAtividades.add(new Atividade(16, "atividade1", "21/01/2021","22/02/2022", null, null, status));
        this.listaAtividades.add(new Atividade(15, "atividade1", "21/01/2021","22/02/2022", null, null, status));

        int n=0;
        while(n != -1)
        {	System.out.println("""
                Selecione a opcao desejada:
                1-criar
                2-alterar
                3-remover
                4-consultar
                5-pagar a bolsa
                6-mostrar relatorio
                7-Associar usuario a projeto
                8-Associar atividade a projeto
                9-Associar usuario a atividade
                0-encerrar o programa""");
            n = s.nextInt();

            switch(n)
            {	case 1:
                int m;
                menu();
                m = s.nextInt();
                if(m == 1) {System.out.println("Digitou 1."); criar_projeto(status);}
                else if(m == 2) {System.out.println("Digitou 2."); criar_atividade(status);}
                else {System.out.println("Digite corretamente."); break;}
                break;
                case 2:
                    System.out.println("Vc escolheu alterar.");
                    int o;
                    menu();
                    o = s.nextInt();
                    if(o == 1) {System.out.println("Digitou 1."); alterarprojeto(listaProjetos);}
                    else if(o == 2) {System.out.println("Digitou 2."); alterar_atividade(listaAtividades);}
                    else {System.out.println("Digite corretamente."); break;}
                    break;
                case 3:
                    System.out.println("Vc escolheu remover.");
                    int p;
                    menu();
                    p = s.nextInt();
                    if(p == 1) {System.out.println("Digitou 1."); removerprojeto(listaProjetos);}
                    else if(p == 2) {System.out.println("Digitou 2."); removeratividade(listaAtividades);}
                    else {System.out.println("Digite corretamente."); break;}
                    break;
                case 4:
                    System.out.println("Vc escolheu consultar.");
                    int q;
                    menu();
                    q = s.nextInt();
                    if(q == 1) {System.out.println("Digitou 1."); consultarprojeto();}
                    else if(q == 2) {System.out.println("Digitou 2."); consultaratividade();}
                    else {System.out.println("Digite corretamente."); break;}
                    break;
                case 5:
                    pagar();
                    break;
                case 6:
                    relatorio();
                    break;
                case 7:
                    associar_usuario_projeto(status, todosatributosp);
                    break;
                case 8:
                    associar_atividade_projeto(status, todosatributosp);
                    break;
                case 9:
                    associar_usuario_atividade(status, todosatributosa);
                    break;
                default:
                    n = -1;
                    break;
            }
        }
    }
    public void menu(){System.out.println("Quer fazer isso com qual atributo?\n1-projeto\n2-atividade\n");}
    public void criar_projeto(String status){
        System.out.println("Vc quer adicionar projeto.");
        double valor_bolsa=0;
        int bolsa;
        System.out.print("Quantos projetos vao ser registrados?");
        int nump = s.nextInt();
        for(int i=1; i <= nump; i++)
        {	System.out.printf("Projeto %d:\n", i);
            System.out.println("Id do projeto: ");
            Integer id = s.nextInt();
            System.out.println("Descricao do projeto:\n(se não houver descricao ainda digite -1)");
            String descrition = s.next();
            if (!descrition.equals("-1")) {status = "concluido";}
            System.out.println("(formato dd/MM/yyyy)\nData de inicio: ");
            String databegin = s.next();
            System.out.println("(formato dd/MM/yyyy)\nData de termino:\n(Se nao tiver acabado digite -1)");
            String dataend = s.next();
            System.out.println("Tem bolsa?1 - sim\n0- - nao\n");
            bolsa = s.nextInt();
            if(bolsa == 1) {System.out.println("Qual o valor da bolsa?"); valor_bolsa = s.nextDouble();}
            System.out.println("Periodo da bolsa:");
            String periodobolsa = s.next();
            if(dataend.equals("-1")){
                status = "Iniciado";
            }
            if(!Objects.equals(descrition, "-1")){
                status = "Concluido";
            }

            Project proj = new Project(status, id, descrition, databegin, dataend, bolsa, valor_bolsa, periodobolsa, null);
            listaProjetos.add(proj);
            System.out.println("Projeto adicionado com sucesso.");
        }
    }

    public void criar_atividade(String status)
    {	System.out.println("Vc quer adicionar atividade.");
        int numa;
        System.out.println("Quantas atividades vão ser registradas?");
        numa = s.nextInt();
        for(int i=0; i<numa; i++)
        {	System.out.printf("Atividade %d:\n", i);
            System.out.println("Id da atividade: ");
            Integer ida = s.nextInt();
            System.out.println("Descricao da atividade:\n(Se nao houver digitar -1)");
            String descritiona = s.next();
            System.out.println("(formato dd/MM/yyyy)\nData de inicio: ");
            String datainicio = s.next();
            System.out.println("(formato dd/MM/yyyy)\nData de termino:\n(se não acabou digite -1)");
            String datafinal = s.next();

            if(datafinal.equals("-1")){
                status = "Iniciado";
            }

            if(!Objects.equals(descritiona, "-1")){
                status = "Concluido";
            }

            System.out.println("Digite o e-mail do responsavel:");
            String resp = s.next();
            User coord = null;
            for(User usuario: userList){
                if (usuario.getEmail().equals(resp)){
                    coord = usuario;
                }
                break;
            }

            Atividade atividade = new Atividade(ida, descritiona, datainicio, datafinal, coord, null, status);
            this.listaAtividades.add(atividade);
            System.out.println("Atividade adicionada com sucesso.");
        }
    }

    public void alterar_atividade(List<Atividade> listaAtividades) {
        int procura;
        System.out.println("Digite o id da atividade que vc quer alterar:\n");
        procura = s.nextInt();
        Atividade atividadeatual = null;
        boolean existeatv = false;

        for (Atividade activity : listaAtividades) {
            if (activity.getId().equals(procura)) {
                atividadeatual = activity;
                System.out.print("A atividade vai ser alterada.\n");
                existeatv = true;
            }
        }

        if(existeatv == true) {
            int novoid;
            System.out.println("Digite o id:\n");
            novoid = s.nextInt();
            atividadeatual.setId(novoid);
            String novadescricao;
            System.out.println("Digite descricao:\n");
            novadescricao = s.next();
            atividadeatual.setDescricao(novadescricao);
            String novadatainicio;
            System.out.println("Digite data de inicio:\n");
            novadatainicio = s.next();
            atividadeatual.setDatainicio(novadatainicio);
            String novadatafinal;
            System.out.println("Digite data final:\n"); // dps pega essa data final só com numero e se ela for antes da data de hoje então status encerrado
            novadatafinal = s.next();
            atividadeatual.setDatafinal(novadatafinal);

            System.out.println("Digite o e-mail do novo responsavel:");
            String resp = s.next();
            User coord = null;
            for(User usuario: userList){
                if (usuario.getEmail().equals(resp)){
                    coord = usuario;
                }
                break;
            }

            atividadeatual.setResponsavel(coord);
            System.out.println("Atividade atualizada com sucesso.");

        }
        else {
            System.out.println("Atividade inexistente ou nao encontrada.\n");
        }
    }

    public void alterarprojeto(ArrayList <Project> projeto){
        System.out.println("Digite o id da atividade que vc quer alterar:\n");
        int idprojeto = s.nextInt();
        Project projetoatual = null;
        boolean existeproj = false;

        for (Project projetonovo : listaProjetos) {
            if (projetonovo.getId().equals(idprojeto)) {
                projetoatual = projetonovo;
                System.out.print("parabens deu certo");
                existeproj = true;
            }
        }

        if(existeproj == true) {
            System.out.println("Id do projeto: ");
            Integer id = s.nextInt();
            projetoatual.setId(id);
            System.out.println("Descricao do projeto:");
            String descrition = s.next();
            projetoatual.setDescrition(descrition);
            System.out.println("Data de inicio: ");
            String databegin = s.next();
            projetoatual.setDatabegin(databegin);
            System.out.println("Data de termino: ");
            String dataend = s.next();
            projetoatual.setDataend(dataend);
            System.out.println("Valor da bolsa ");
            Integer bolsa = s.nextInt();
            projetoatual.setBolsa(bolsa);
            System.out.println("Periodo da bolsa:");
            String periodobolsa = s.next();
            projetoatual.setPeriodobolsa(periodobolsa);
            System.out.println("Valor da bolsa:");
            int novovalorbolsa = s.nextInt();
            projetoatual.setValor_bolsa(novovalorbolsa);
        }
        else {System.out.println("Projeto inexistente ou nao encontrada.\n"); }
    }

    public void removeratividade(List<Atividade> listaAtividades) {
        System.out.println("Digite o id da atividade que vc quer remover:\n");
        int procura = s.nextInt();
        for (Atividade activity : listaAtividades) {
            if (activity.getId().equals(procura)) {
                System.out.print("Atividade removida com sucesso.\n");
                listaAtividades.remove(activity); // activity pega o id, para remover
                break;
            }
        }

    }

    public void removerprojeto(ArrayList<Project> projeto) {
        int idprojeto;
        System.out.println("Digite o id da atividade que vc quer alterar:\n");
        idprojeto = s.nextInt();
        Project projetoatual;
        int foiremovido = 0;

        for (Project projetonovo : listaProjetos) {
            if (projetonovo.getId().equals(idprojeto)) {
                projetoatual = projetonovo;
                System.out.print("parabens deu certo\n");
                this.listaProjetos.remove(projetoatual);
                foiremovido = 1;
            }
        }

        if(foiremovido == 1) {System.out.print("nao foi removido ou nao existe.\n");}
        else {System.out.print("foi removido com sucesso.\n");}
    }

    public void consultaratividade() {
        System.out.println("Digite o id da atividade que vc quer consultar:\n");
        int procura = s.nextInt();
        for (Atividade atividade : this.listaAtividades) {
            if(atividade.getId().equals(procura)) {
                System.out.print("Atividade(id): " + atividade.getId() + "\nDescricao: " + atividade.getDescricao()
                + "\nData inicio: " + atividade.getDatainicio() + "\nData final: " + atividade.getDatafinal());
                atividade.printar_coord();
                atividade.activity_users();
            }
        }
    }

    public void consultarprojeto() {
        System.out.println("Digite o id do projeto que vc quer consultar:\n");
        int procura = s.nextInt();
        for (Project projeto : this.listaProjetos) {
            if(projeto.getId().equals(procura)) {
                System.out.println("Projeto(id)" + projeto.getId() + "\nDescricao: " + projeto.getDescrition() + "\nInicio" + projeto.getDatabegin() + "\nfinal:" +
                        projeto.getDataend() + "\nBolsa tipo:" + projeto.getBolsa() + "\nValor da bolsa:" + projeto.getValor_bolsa() +
                        "\nperiodo:" + projeto.getPeriodo_bolsa() + "\n");
                projeto.print_user_projects();
                projeto.print_activity_projects();
                System.out.print("\n");
            }
        }
    }
    public void pagar() {
        System.out.println("Digite o id do projeto que vc quer pagar:\n");
        int procura = s.nextInt();
        for (Project projeto : this.listaProjetos) {
            if(projeto.getId().equals(procura)) {
                System.out.print("Pagamento em andamento do projeto ");
                System.out.println(projeto.getId());
                double salario_bolsa = projeto.getValor_bolsa();
                for (User currentUser : this.userList) {
                    if(currentUser instanceof Aluno){
                        ((Aluno) currentUser).recebe_salario(salario_bolsa, currentUser.getName());
                        ((Aluno) currentUser).recebe_salario(salario_bolsa);
                    }
                    if(currentUser instanceof Admin){
                        ((Admin) currentUser).recebe_salario(salario_bolsa, currentUser.getName());
                        ((Admin) currentUser).recebe_salario(salario_bolsa);
                    }
                }
                break;
            }
            break;
        }
    }
    public void relatorio() {
        for (Project projeto : this.listaProjetos) {
            projeto.relatorio();
        }
    }

    public void associar_usuario_projeto(String status, Integer todos_atributos){
        int i = 0;
        for (User usuario: this.userList){
            if (usuario instanceof Aluno){
                System.out.println("Aluno(a):" + usuario.getName() + "e-mail:" + usuario.getEmail());
            }
        }
        System.out.println("Quer adicionar algum aluno a algum projeto?\n1-[Sim]\n0-[Nao]");
        int resp = s.nextInt();
        if(resp == 1)
        {
            System.out.println("vc quer adicionar.\nDigite o id do projeto:");
            int id_p = s.nextInt();
            for(Project procurar : this.listaProjetos)
            {
                if(procurar.getId().equals(id_p))
                {
                    System.out.println("Digite o e-mail do aluno:");
                    String p_email = s.next();
                    for (User usuario: this.userList)
                    {
                        if (usuario instanceof Aluno)
                        {
                            if (usuario.email.equals(p_email))
                            {   i = 1;
                                procurar.add_user(usuario);//adicionando nesse projeto esse usuario pelo e-mail dele
                                todos_atributos = todos_atributos + 1;
                                if(todos_atributos >= 2 && !procurar.getDescrition().equals("-1")){
                                    status = "Em andamento";
                                    procurar.setStatus(status);
                                }
                            }
                        }
                    }
                }
            }
            if(i != 1){System.out.println("Erro! e-mail incorreto ou inexistente");}

        }
        if(resp == 0){System.out.println("vc nao quer adicionar.");}
    }

    public void associar_atividade_projeto(String status, Integer todos_atributos){
        int i = 0;
        System.out.println("Quer adicionar alguma atividade a algum projeto?\n1-[Sim]\n0-[Nao]");
        int resp = s.nextInt();
        if(resp == 1)
        {
            System.out.println("vc quer adicionar.\nDigite o id do projeto:");
            int id_p = s.nextInt();
            for(Project procurar : this.listaProjetos)
            {
                if(procurar.getId().equals(id_p))
                {   System.out.println("Digite o id da atividade:");
                    int id_a = s.nextInt();
                    for (Atividade atividade : this.listaAtividades)
                    {
                        if (atividade.getId().equals(id_a))
                        {
                            i = 1;
                            procurar.add_atividade(atividade);
                            todos_atributos = todos_atributos + 1;
                            if(todos_atributos >= 2 && !procurar.getDescrition().equals("-1")){
                                status = "Em andamento";
                                procurar.setStatus(status);
                            }
                        }
                    }
                }
            }
            if(i != 1){System.out.println("Erro! id incorreto ou inexistente");}
        }
        if(resp == 0){System.out.println("vc nao quer adicionar.");}
    }

    public void associar_usuario_atividade(String status, Integer todos_atributos){
        System.out.print("...");
        int i = 0;
        System.out.println("Quer adicionar algum usuario a alguma atividade?\n1-[Sim]\n0-[Nao]");
        int resp = s.nextInt();
        if(resp == 1)
        {
            System.out.println("vc quer adicionar.\nDigite o id da atividade:");
            int id_a = s.nextInt();
            for(Atividade procurar : this.listaAtividades)
            {
                if(procurar.getId().equals(id_a))
                {   System.out.println("Digite o e-mail do usuario");
                    String email = s.next();
                    for (User usuario : this.userList)
                    {
                        if (usuario instanceof Aluno){
                            if(usuario.getEmail().equals(email)){
                                procurar.add_user(usuario);
                                i = 1;
                                todos_atributos = todos_atributos + 1;
                                if(todos_atributos >= 2 && !procurar.getDescricao().equals("-1")){
                                    status = "Em andamento";
                                    procurar.setStatus(status);
                                }
                            }
                        }
                    }
                }
            }
            if(i != 1){System.out.println("Erro! id incorreto ou inexistente");}
        }
        if(resp == 0){System.out.println("vc nao quer adicionar.");}
    }
}