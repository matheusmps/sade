Feature: Entrar no sistema como um membro da conpec.

    Scenario: login como usuário cadastrado
        Given browser esta aberto
        When Entrar na página 'http://localhost:8080/admin/'
        When PENDING coloco usuário e senha válido
        Then sou redirecionado para a página inicial de membro

    Scenario: login como usuário não cadastrado
        Given browser esta aberto
        When Entrar na página 'http://localhost:8080/admin/'
        When PENDING coloco nome de usuário não cadastrado e senha qualquer
        Then uma mensagem de erro é mostrada "Usuário ou senha invádio"

    Scenario: login com usuário cadastrado e senha inválida
        Given browser esta aberto
        When Entrar na página 'http://localhost:8080/admin/'
        When PENDING coloco nome de um usuário cadastrado e senha inválida
        Then uma mensagem de erro é mostrada "Usuário ou senha invádio"
