# p2-parte2
Projeto de programação orientada a objetos em Java sobre gerenciamento de projetos
caminho para executar o arquivo:
<p>
<h4>p2-parte2/p2-parte2/src/app/Main.java</h4>
<p>
<h4>Algumas alterações no projeto:</h4>
<div>o switch ficou mais limpo servindo com menos informações levando para as funções propriamente ditas.
<div>algumas funções também ficaram com um código mais enxuto
<div>foi adotado o método MVC, model, view, controller e organizado mais as funções
<p>
<h4>Conceitos de OO aplicados:</h4>
<div>1 - as classes já existiam, foram melhorados os tipos dos atributos e enxugados os getters e setters, removendo os sem uso
<div>2 - foi aplicado um overloading nas classes aluno e  admin relacionados a pagamento de bolsa(método recebe_salario)
<div>3, 6, 7, 8 - foram aplicados vários overriding com as seguintes alterações:
<ul>
    <li>foi alterado o enum e implementado classes de aluno e admin aplicando o conceito de abstract class</li>
    <li>foram aplicados os conceitos de interface já que aluno e admin implementam o 'contrato' pagamento</li>
    <li>há a interface pagamento que 'obriga' aluno e admin a implementarem o método recebe_salário dentre essas </li>
    <li>e outras aplicando polimorfismo propriamente dito que nesse caso não poderá entrar no programa apenas criar</li>
    <li>seu usuário com e-mail, senha, etc.</li>
</ul>
<div>4 - foram usados modificadores de acesso public e private conforme o uso se era para poder ser modificada para outras classes ou não e etc.
<div>5 - Herança foi aplicada na classe User que é uma classe mãe de aluno e admin, que, portanto, herdam os atributos da classe User
<div>9, 10 - O conceito de generics e collection já tinha sido utilixado no 1° projeto, mas foi melhorado o uso com ArrayLists mais especificos


