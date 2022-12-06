<h3>-> Para iniciar o programa caminho para executar:</h2>
<i>p2-parte2/p2-parte2/src/app/Main.java</i>
<h3>Aplicação de padrões de projeto<div>(Design patterns):</div></h3>

<div> <ul> <p> <b># Padrões aplicados:</b>
  <i>
      <li> Dependency Injection </li>
      <li> Introduce Parameter Object </li>
      <li> Builder </li>
  </i>
</ul> </div>

<div> <b>Dependency Injection</b> </div>
Foi aplicado o padrão de injeção depência tal qual as classes Atividade e Projeto tiveram atributos
em comum colocados em outra classe chamada "Dados" e o mesmo foi feito com uma refatoração
para deixar mais simples a classe User que era Abstract passou a ser classe comum e ter uma injeção de 
Dependência em seus filhos, as classes "Aluno" e "Admin".

<p> </p>
<div> <b> Introduce Parameter Object </b>  </div>
Na injeção de dependencia e outras funcionalidades foi implementado o padrão de projeto Introduce Parameter Object,
tal qual funções foram reduzidas a métodos implementados por ambas as funções que compartilham de atributos da mesma classe,
a função relatório por exemplo que tinha um código muito parecido para Atividade e Projeto, como ambos compartilham do mesmo
atributo, chamar o relatório em cada classe se reduziu a uma função só com mais algumas coisas próprias de cada classe. 
Aconteceu algo parecido para o método alterar para as classes Aluno e Admin que compartilham da mesma classe encapsulada "Pessoa".

<p> </p>
<div> <b> Builder </b>  </div>
Para resolver a problemática de uma classe adicionada no meio do projeto e com os atributos em lugares os quais não
dá para saber o que tem nessa classe e em qual lugar está, por exemplo: classe "Pessoa("Leo", "Vinicius", "20")", não
dá para saber o que significam essas Strings e com o método Builder fica tudo mais visível para quem está mexendo no
código, ficaria algo como classe "Pessoa.PessoaBuilder().nome("Leo").sobrenome("Vinicius").idade(20).CreatePessoa()".
Bem mais visível e fácil de se trabalhar.

<p> </p>
<div> <b> SOLID(Single Responsibility Principle) </b>  </div>
Neste método foram aplicados princípios para organização de cada classe, em que uma classe só se faz uso de métodos
que permitam ter atributos da mesma, se precisar de acesso de um atributo de outra classe, esta outra precisa ter um
método tal qual a classe que a chamou possa utiliza-lo, determinado pelo usuário, sendo assim, respeitando a responsabilidade
de cada classe, em que uma não se sobressaia com métodos mais gerais quando não era para ter, por exemplo uma classe
Carro com um método trocarRoda(), mas não é apenas carro que se troca roda, este método deveria ser implementado pela
classe mãe automóvel por exemplo.

<div><p>Pasta com a imagem de alguns exemplos e para ver as mudanças estabelecidas:
<a href="https://github.com/leonardo-vinicius/p2-parte2/tree/padrao_de_projeto/prints">Pasta com imagens</a>
</div>