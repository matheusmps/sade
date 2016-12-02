Feature: Entrar no sistema como um desenvolvedor do Sade.

    Scenario: login como usuário cadastrado
        When Entrar na página 'http://localhost:8080/dev/'
        When PENDING coloco usuário "renato@gmail.com" e senha "renato"
        Then sou redirecionado para a página "http://localhost:8080/devperfil"

	Scenario: login com senha incorreta
        When Entrar na página 'http://localhost:8080/dev/'
		When PENDING coloco usuário "renato@gmail.com" e senha "123456"
		Then sou redirecionado para a página "http://localhost:8080/devperfil"
		And é mostrada a mensagem de erro 1
	
	Scenario: login com usuário não cadastrado
        When Entrar na página 'http://localhost:8080/dev/'
		When PENDING coloco usuário "renatogmail.com" e senha "123456"
		Then sou redirecionado para a página "http://localhost:8080/devperfil"
		And é mostrada a mensagem de erro 2
	
	Scenario: campo de email vazio
        When Entrar na página 'http://localhost:8080/dev/'
		When PENDING coloco usuário "" e senha "123456"
		Then sou redirecionado para a página "http://localhost:8080/devperfil"
		And é mostrada a mensagem de erro 3
	
	Scenario: campo de senha vazio
        When Entrar na página 'http://localhost:8080/dev/'
		When PENDING coloco usuário "renato@gmail.com" e senha ""
		Then sou redirecionado para a página "http://localhost:8080/devperfil"
		And é mostrada a mensagem de erro 3
	