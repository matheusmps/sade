Feature: Cadastrar um novo desenvolvedor

    Scenario: Cadastro de um novo desenvolvedor válido.
<<<<<<< c4af648b2163d091c2c16bc1b403a646705ad9b6
        When Entro na página 'http://localhost:8080/register.html'
        When coloco nome "Renato Shibata" telefone "12345678901" cpf "12345678901" endereco "Rua tal" email "renato@gmail.com" senha "renato"
        Then sou redirecionado para a página "http://localhost:8080/dev-panel.html"
        
    Scenario: Cadastro de um desenvolvedor com nome vazio
        When Entro na página 'http://localhost:8080/register.html'
        When coloco nome "" telefone "12345678901" cpf "12345678901" endereco "Rua tal" email "renato@gmail.com" senha "renato"
        Then sou redirecionado para a página "http://localhost:8080/register.html"
        And é mostrada a mensagem de erro 1        

    Scenario: Cadastro de um desenvolvedor com nome inválido com caracter estranho
        When Entro na página 'http://localhost:8080/register.html'
        When coloco nome "Ren&%ato Shibata" telefone "12345678901" cpf "12345678901" endereco "Rua tal" email "renato@gmail.com" senha "renato"
        Then sou redirecionado para a página "http://localhost:8080/register.html"
        And é mostrada a mensagem de erro 2

    Scenario: Cadastro de um desenvolvedor com um nome só
        When Entro na página 'http://localhost:8080/register.html'
        When coloco nome "Renato" telefone "12345678901" cpf "12345678901" endereco "Rua tal" email "renato@gmail.com" senha "renato"
        Then sou redirecionado para a página "http://localhost:8080/register.html"
        And é mostrada a mensagem de erro 3

    Scenario: Cadastro de um desenvolvedor com telefone vazio
        When Entro na página 'http://localhost:8080/register.html'
        When coloco nome "Renato Shibata" telefone "" cpf "12345678901" endereco "Rua tal" email "renato@gmail.com" senha "renato"
        Then sou redirecionado para a página "http://localhost:8080/register.html"
        And é mostrada a mensagem de erro 4

    Scenario: Cadastro de um desenvolvedor com telefone inválido
        When Entro na página 'http://localhost:8080/register.html'
        When coloco nome "Renato Shibata" telefone "123sdf45 78" cpf "12345678901" endereco "Rua tal" email "renato@gmail.com" senha "renato"
        Then sou redirecionado para a página "http://localhost:8080/register.html"
        And é mostrada a mensagem de erro 5

    Scenario: Cadastro de um desenvolvedor com telefone com mais numeros
        When Entro na página 'http://localhost:8080/register.html'
        When coloco nome "Renato Shibata" telefone "123456789012" cpf "12345678901" endereco "Rua tal" email "renato@gmail.com" senha "renato"
        Then sou redirecionado para a página "http://localhost:8080/register.html"
        And é mostrada a mensagem de erro 6

    Scenario: Cadastro de um desenvolvedor com telefone com menos numeros
        When Entro na página 'http://localhost:8080/register.html'
        When coloco nome "Renato Shibata" telefone "12345678" cpf "12345678901" endereco "Rua tal" email "renato@gmail.com" senha "renato"
        Then sou redirecionado para a página "http://localhost:8080/register.html"
        And é mostrada a mensagem de erro 7

    Scenario: Cadastro de um desenvolvedor com cpf vazio
        When Entro na página 'http://localhost:8080/register.html'
        When coloco nome "Renato Shibata" telefone "12345678901" cpf "" endereco "Rua tal" email "renato@gmail.com" senha "renato"
        Then sou redirecionado para a página "http://localhost:8080/register.html"
        And é mostrada a mensagem de erro 8

    Scenario: Cadastro de um desenvolvedor com cpf com mais numeros
        When Entro na página 'http://localhost:8080/register.html'
        When coloco nome "Renato Shibata" telefone "12345678901" cpf "123456789012" endereco "Rua tal" email "renato@gmail.com" senha "renato"
        Then sou redirecionado para a página "http://localhost:8080/register.html"
        And é mostrada a mensagem de erro 9

    Scenario: Cadastro de um desenvolvedor com cpf com menos numeros
        When Entro na página 'http://localhost:8080/register.html'
        When coloco nome "Renato Shibata" telefone "12345678901" cpf "12345678" endereco "Rua tal" email "renato@gmail.com" senha "renato"
        Then sou redirecionado para a página "http://localhost:8080/register.html"
        And é mostrada a mensagem de erro 10

    Scenario: Cadastro de um desenvolvedor com cpf inválido
        When Entro na página 'http://localhost:8080/register.html'
        When coloco nome "Renato Shibata" telefone "12345678901" cpf "123$e45 678" endereco "Rua tal" email "renato@gmail.com" senha "renato"
        Then sou redirecionado para a página "http://localhost:8080/register.html"
        And é mostrada a mensagem de erro 11

    Scenario: Cadastro de um desenvolvedor com endereco vazio
        When Entro na página 'http://localhost:8080/register.html'
        When coloco nome "Renato Shibata" telefone "12345678901" cpf "12345678901" endereco "" email "renato@gmail.com" senha "renato"
        Then sou redirecionado para a página "http://localhost:8080/register.html"
        And é mostrada a mensagem de erro 12

    Scenario: Cadastro de um desenvolvedor com email vazio
        When Entro na página 'http://localhost:8080/register.html'
        When coloco nome "Renato Shibata" telefone "12345678901" cpf "12345678901" endereco "Rua tal" email "" senha "renato"
        Then sou redirecionado para a página "http://localhost:8080/register.html"
        And é mostrada a mensagem de erro 13
        
    Scenario: Cadastro de um desenvolvedor com email sem arroba
        When Entro na página 'http://localhost:8080/register.html'
        When coloco nome "Renato Shibata" telefone "12345678901" cpf "12345678901" endereco "Rua tal" email "renatogmail.com" senha "renato"
        Then sou redirecionado para a página "http://localhost:8080/register.html"
        And é mostrada a mensagem de erro 14
        
    Scenario: Cadastro de um desenvolvedor com email com mais de um arroba
        When Entro na página 'http://localhost:8080/register.html'
        When coloco nome "Renato Shibata" telefone "12345678901" cpf "12345678901" endereco "Rua tal" email "ren@ato@gmail.com" senha "renato"
        Then sou redirecionado para a página "http://localhost:8080/register.html"
        And é mostrada a mensagem de erro 15
        
    Scenario: Cadastro de um desenvolvedor com email com nada antes do arroba
        When Entro na página 'http://localhost:8080/register.html'
        When coloco nome "Renato Shibata" telefone "12345678901" cpf "12345678901" endereco "Rua tal" email "@gmail.com" senha "renato"
        Then sou redirecionado para a página "http://localhost:8080/register.html"
        And é mostrada a mensagem de erro 16    
       
    Scenario: Cadastro de um desenvolvedor com email com nada depois do arroba
        When Entro na página 'http://localhost:8080/register.html'
        When coloco nome "Renato Shibata" telefone "12345678901" cpf "12345678901" endereco "Rua tal" email "renato@" senha "renato"
        Then sou redirecionado para a página "http://localhost:8080/register.html"
        And é mostrada a mensagem de erro 17 
        
    Scenario: Cadastro de um desenvolvedor com senha vazia
        When Entro na página 'http://localhost:8080/register.html'
        When coloco nome "Renato Shibata" telefone "12345678901" cpf "12345678901" endereco "Rua tal" email "renato@gmail.com" senha ""
        Then sou redirecionado para a página "http://localhost:8080/register.html"
        And é mostrada a mensagem de erro 18
        
=======
        When Entrar na página 'http://localhost:8080/sade-1.0.1/register.html#/'
        And PENDING adiciono todas as informações obrigatórias para cadastro de desenvolvedor. Clico no botão "Cadastrar"
        Then um novo desenvolvedor é criado. Sou redirecionado para a página de perfil deste desenvolvedor

    Scenario: Cadastro de um desenvolvedor com cpf repetido
        When Entrar na página 'http://localhost:8080/sade-1.0.1/register.html#/'
        And PENDING adiciono todas as informações obrigatórias para cadastro de desenvolvedor, utilizando um número de cpf de um usuário já cadastrado. Clico no botão "Cadastrar"
        Then uma mensagem de erro aparece "Cpf já utilizado". O desenvolvedor não é criado.

    Scenario: Cadastro de um desenvolvedor com cpf inválido
        When Entrar na página 'http://localhost:8080/sade-1.0.1/register.html#/'
        And PENDING adiciono todas as informações obrigatórias para cadastro de desenvolvedor, utilizando um número de cpf inválido.
        Then uma mensagem de erro aparece "Número de cpf inváldo". Desenvolvedor não é criado.

    Scenario: Cadastro faltando informação obrigatória.
        When Entrar na página 'http://localhost:8080/sade-1.0.1/register.html#/'
        And PENDING clico no botão "Cadastrar" sem preencher alguma informação obrigatória.
        Then uma mensagem de erro aparece "Informação xxx está faltando". Desenvolvedor não é criado.
>>>>>>> Testes Cucumber OK \o/
