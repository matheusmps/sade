Feature: Home page

    Scenario: Carregar Home page.
        When Entrar na página 'http://sample-env-2.v5vayj2nke.us-west-2.elasticbeanstalk.com/'
        And ela contém 2 links 'cadastro_cv', 'login'
        
	Scenario: Botão para cadastro de dev redireciona para a página correta.
        When Entrar na página 'http://sample-env-2.v5vayj2nke.us-west-2.elasticbeanstalk.com/'
        When click no elemento 'cadastro_cv'
        Then estou na pagina 'http://sample-env-2.v5vayj2nke.us-west-2.elasticbeanstalk.com/register'
     
	Scenario: Botão para login de admin redireciona para a página correta.
        When Entrar na página 'http://sample-env-2.v5vayj2nke.us-west-2.elasticbeanstalk.com/'
        When click no elemento 'login'
        Then estou na pagina 'http://sample-env-2.v5vayj2nke.us-west-2.elasticbeanstalk.com/login'
    
