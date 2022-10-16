package app;

import model.Admin;
import model.Aluno;
import model.User;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    private User section;
    private final ArrayList<User> userList = new ArrayList<>();

    public Runner() {
        this.userList.add(new Admin(1221, "leo", "a", "a", "coordenador"));
        this.userList.add(new Aluno(1221, "Nalanda", "b", "b", 2021));

        Scanner scan = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
            if (this.section == null) {
                System.out.println("1 - Logar\n2 - Criar usuario\n3 - recuperar senha\n4 - deletar usuario\n5 - alterar\n0 - encerrar o programa");
            } else {
                if (section instanceof Admin) {
                    System.out.println("6 - Consultar usuarios\n7 - entrar no programa");
                }
                System.out.println("5 - alterar\n0 - Logout\n");
            }
            int input = scan.nextInt();
            String trash = scan.nextLine();
            if (input == 0) {
                isRunning = false;
            }
            if (input == 1) {
                login(scan);
            }
            if (input == 2) {
                System.out.println("Digite seu nome");
                String name = scan.nextLine();
                System.out.println("Digite seu email");
                String email = scan.nextLine();
                System.out.println("Digite sua senha");
                String password = scan.nextLine();
                System.out.println("Digite\n1- para ADMIN\n2- para ALUNO");
                int ruleDigit = scan.nextInt();
                String cash = scan.nextLine();

                if (ruleDigit == 1) {
                    System.out.println("Qual o seu cargo?\n(ex: coordenador, pesquisador, doutorando, pós-graduando...)");
                    String cargo = scan.next();
                    User usuario = new Admin( 0, name, email, password, cargo);
                    this.userList.add(usuario);
                }

                if (ruleDigit == 2) {
                    System.out.println("Digite seu n° de matricula: \n");
                    int num_matricula = scan.nextInt();
                    User usuario = new Aluno( 0, name, email, password, num_matricula);
                    this.userList.add(usuario);
                }
            }

            if(input == 3) {
                System.out.println("Digite seu email");
                String email = scan.nextLine();
                for (User currentUser : this.userList) {
                    if (currentUser.email.equals(email)) {
                        System.out.println("Digite sua nova senha");
                        String newpassword = scan.nextLine();
                        currentUser.setPassword(newpassword);
                        this.login(scan);
                    }
                }
            }

            if(input == 4) {
                System.out.println("Send your email");
                String email = scan.nextLine();
                System.out.println("Send your password");
                String password = scan.nextLine();
                for (User currentUser : this.userList) {
                    if (currentUser.email.equals(email)) {
                        if (currentUser.password.equals(password)) {
                            System.out.println("Usuario " + currentUser.getName() +" removido com sucesso.");
                            userList.remove(currentUser);
                        } else {
                            System.out.println("Senha nao confere\n");
                        }
                        break;
                    }
                }
            }

            if(input == 5){
                System.out.println("Alterar...\nSend your email");
                String email = scan.nextLine();
                for (User atual : this.userList){
                    if (atual.email.equals(email)){
                        System.out.println("Alterando dados\n");
                        atual.alterar();
                        break;
                    }
                }
            }
//--------------------------------------- consultando--------------------------------------------------------------------
            if (input == 6) {
                for (User currentUser : this.userList) {
                    System.out.println(currentUser.toString());
                    System.out.print("\n");
                }
            }

            if (input == 7) {
                System.out.println("entrando no sistema...\n");
                new App(userList);
            }
        }
    }

    private void login(Scanner scan) {
        System.out.println("Send your email");
        String email = scan.nextLine();
        System.out.println("Send your password");
        String password = scan.nextLine();
        for (User currentUser : this.userList) {
            if (currentUser.email.equals(email)) {
                if (currentUser.password.equals(password)){
                    this.section = currentUser;
                } else {
                    System.out.println("Senha nao confere\n");
                    break;
                }
            }
        }
        if (this.section == null) {
            System.out.println("Usuário nao encontrado.\ntente recuperar senha.\n");
        } else {
            System.out.println("Usuario " + this.section.name + " Logado");
        }
    }
}
