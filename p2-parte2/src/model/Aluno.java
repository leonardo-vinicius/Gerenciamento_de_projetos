package model;
import view.Payments;

import java.util.*;

public class Aluno extends User implements Payments {
    public int matricula;
    public Aluno(double salario, String name, String email, String password, int matricula){
            super(salario, name, email, password);
            this.matricula = matricula;
        }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    // Uso de Overriding
    @Override
    public String toString(){
        System.out.println(super.toString());
        return  "numero de matrícula:" + this.matricula;
    }

    // Uso de abstract class
    @Override
    public void alterar(){
            System.out.print("Digite o que voce quer que seja  alterado:");
            Scanner s = new Scanner(System.in);
            System.out.print("\n1-nome\n2-email\n3-senha\n4-n° de matricula\n");
            int num = s.nextInt();
            if(num==1){System.out.print("Digite seu novo nome: ");String v = s.next();setName(v);}
            else if(num==2){System.out.print("Digite seu novo email: ");String v = s.next();setEmail(v);}
            else if(num==3){System.out.print("Digite sua nova senha: ");String v = s.next();setPassword(v);}
            else if(num==4){System.out.print("Digite seu novo n° de matricula: ");int v = s.nextInt();setMatricula(v);}
            else{System.out.print("Erro! numero digitado errado.");}
        }
    @Override
    public void recebe_salario(double dinheiro) {
        System.out.printf("Salario caiu na conta. R$:%.4f\n", dinheiro);
    }

    @Override
    public void recebe_salario(double dinheiro, String name) {
        System.out.printf("Efetuando pagamento de R$:%.4f na conta do aluno %s\n", dinheiro, name);
    }
}
