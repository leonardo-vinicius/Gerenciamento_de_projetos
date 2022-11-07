Para iniciar o programa caminho para executar:
<h4><div>p2-parte2/p2-parte2/src/app/Main.java</h4>
  <div> O programa teve as seguintes alterações e/ou tratamento de erros:
    <div> tratamento de NumberFormatException com a criação de uma função process()
      <div> na função app/App que só continua quando o usuário digita corretamente o que foi pedido.(um número inteiro)
        <div> o tratamento de NullPointException foi tratado com um current user que é passado ao criar Atividade/Projeto
          <div> como coordenador e próprio membro do projeto, com isso as listas nunca estarão vazias.
            <div> Os code smells foram tratados com funções como a em app/App procuraratividade() e procurarprojeto()
              <div> que evitam duplicações de código e procuram se tal atividade ou tal projeto existem, pouparam umas 100 linhas
                <div> de código e deixaram o programa mais limpo e mais visivel. E outros pequenos detalhes que contribuiram para
                  <div> tornar o código mais limpo.
