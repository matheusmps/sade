Feature: Home page

    Scenario: Carregar Home page.
        When Entrar na página 'http://localhost:8080/sade/'
        And ela contém 2 links 'cadastro_cv', 'login'
        
	Scenario: Botão para cadastro de dev redireciona para a página correta.
        When Entrar na página 'http://localhost:8080/sade/'
        When click no elemento 'cadastro_cv'
        Then estou na pagina 'http://localhost:8080/sade/register'
     
	Scenario: Botão para login de admin redireciona para a página correta.
        When Entrar na página 'http://localhost:8080/sade/'
        When click no elemento 'login'
        Then estou na pagina 'http://localhost:8080/sade/login'
    
