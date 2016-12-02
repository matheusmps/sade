Feature: Entrar no sistema como um desenvolvedor do Sade.

    Scenario: login como usuário cadastrado
        When Entrar na página login dev
        When coloco usuário "Jo" e senha "jo"
        Then sou redirecionado para a página de dev
        And estou na página do dev Jo

	Scenario: login com senha incorreta
        When Entrar na página login dev
		When coloco usuário "Jo" e senha "naosousuasenha"
		Then sou redirecionado para a página de login
		And é mostrada a mensagem de erro "Username ou password inválido."
	
	Scenario: login com usuário não cadastrado
        When Entrar na página login dev
		When coloco usuário "naosoudev" e senha "123456"
		Then sou redirecionado para a página de login
		And é mostrada a mensagem de erro "Username ou password inválido."
	