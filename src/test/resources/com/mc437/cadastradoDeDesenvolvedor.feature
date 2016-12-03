Feature: Cadastrar um novo desenvolvedor

    Scenario: Cadastro de um novo desenvolvedor válido.
        When Entro na página 'http://localhost:8080/register.html'
        When coloco nome "Renato" sobrenome "Shibata" endereco "Rua tal" celular "12345678901" cpf "12345678901"  email "renato@gmail.com" username "renato" senha "123"
		And não entrou com cpf já existente
        Then sou redirecionado para a página "http://localhost:8080/dev-panel.html". O desenvolvedor é criado.
           
    Scenario: Cadastro de um desenvolvedor com entrada inválida
        When Entro na página 'http://localhost:8080/register.html'
        When coloco combinação inválida nos campos <nome>,<sobrenome>,<endereco>,<celular>,<cpf>,<email>,<username>,<senha> 
        Then sou redirecionado para a página "http://localhost:8080/register.html"
        And é mostrada a mensagem de erro <erromsg>.O desenvolvedor não é criado.
        
        Examples:
			|nome			|sobrenome	|endereco		|celular	 |cpf			|email				|username 	|senha 	|errormsg 	|
			|				| 			|Rua tal		|12345678901 |12345678901	|renato@gmail.com	|renato		|123	|1			|
			|				|Shibata	|Rua tal		|12345678901 |12345678901	|renato@gmail.com	|renato		|123	|1			|   
			|Renato			|			|Rua tal		|12345678901 |12345678901	|renato@gmail.com	|renato		|123	|3			|   
			|Ren&%ato		|Shibata	|Rua tal		|12345678901 |12345678901	|renato@gmail.com	|renato		|123	|2			|   
			|Renato			|Shi%$#bata	|Rua tal		|12345678901 |12345678901	|renato@gmail.com	|renato		|123	|2			|   
			|Renato			|Shibata	|Rua tal		|			 |12345678901	|renato@gmail.com	|renato		|123	|4			|   
			|Renato			|Shibata	|Rua tal		|123sdf45 78 |12345678901	|renato@gmail.com	|renato		|123	|5			|   
			|Renato			|Shibata	|Rua tal		|123456789012|12345678901	|renato@gmail.com	|renato		|123	|5			|   
			|Renato			|Shibata	|Rua tal		|12345678	 |12345678901	|renato@gmail.com	|renato		|123	|5			|   
			|Renato			|Shibata	|Rua tal		|12345678901 |				|renato@gmail.com	|renato		|123	|6			|   
			|Renato			|Shibata	|Rua tal		|12345678901 |123456789012	|renato@gmail.com	|renato		|123	|7			|   
			|Renato			|Shibata	|Rua tal		|12345678901 |12345678		|renato@gmail.com	|renato		|123	|7			|   
			|Renato			|Shibata	|Rua tal		|12345678901 |123$e45 678	|renato@gmail.com	|renato		|123	|7			|   
			|Renato			|Shibata	|				|12345678901 |12345678901	|renato@gmail.com	|renato		|123	|8			|   
			|Renato			|Shibata	|Rua tal		|12345678901 |12345678901	|					|renato		|123	|9			|   
			|Renato			|Shibata	|Rua tal		|12345678901 |12345678901	|renatogmail.com	|renato		|123	|10			|   
			|Renato			|Shibata	|Rua tal		|12345678901 |12345678901	|ren@ato@gmail.com	|renato		|123	|10			|   
			|Renato			|Shibata	|Rua tal		|12345678901 |12345678901	|		@gmail.com	|renato		|123	|10			|   
			|Renato			|Shibata	|Rua tal		|12345678901 |12345678901	|renato@			|renato		|123	|10			|   			
			|Renato			|Shibata	|Rua tal		|12345678901 |12345678901	|renato@gmail.com	|			|123	|11			|   			
			|Renato			|Shibata	|Rua tal		|12345678901 |12345678901	|renato@gmail.com	|renato		|		|12			|   						
# Legenda de errormsg: 
# 1 = nome vazio
# 2 = caracter invalido no nome ou sobrenome (uso de numero e/ou simbolos)
# 3 = sobrenome vazio
# 4 = celular vazio
# 5 = celular invalido			(nao tem 11 digitos numericos)
# 6 = cpf vazio
# 7 = cpf invalido				(nao tem 11 digitos numericos)
# 8 = endereco vazio
# 9 = email vazio
# 10 =email invalido 			(sem arroba, mais de um arroba, sem string antes do arroba)
# 11= username vazio
# 12= senha vazia 


    Scenario: Cadastro de um desenvolvedor com cpf já existente
        When Entrar na página 'http://localhost:8080/sade-1.0.1/register.html#/'
        When coloco nome "Renato" sobrenome "Shibata" endereco "Rua tal" celular "12345678901" cpf "12345678901"  email "renato@gmail.com" username "renato" senha "123"
		And utilizando um número de cpf de um usuário já cadastrado. Clico no botão "Cadastrar"
        Then sou redirecionado para a página "http://localhost:8080/register.html"        
		And uma mensagem de erro aparece "Cpf já utilizado". O desenvolvedor não é criado.

