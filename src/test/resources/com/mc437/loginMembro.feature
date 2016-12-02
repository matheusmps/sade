Feature: Entrar no sistema como um membro da conpec.

    Scenario: Login como usuário cadastrado
        When Entrar na página login admin
        And PENDING coloco usuário e senha válido
        Then sou redirecionado para a página inicial de membro

    Scenario: login como usuário não cadastrado
        When Entrar na página login admin
        And PENDING coloco nome de usuário não cadastrado e senha qualquer
        Then uma mensagem de erro é mostrada "Usuário ou senha invádio"

    Scenario: login com usuário cadastrado e senha inválida
        When Entrar na página login admin
        And PENDING coloco nome de um usuário cadastrado e senha inválida
        Then uma mensagem de erro é mostrada "Usuário ou senha invádio"
