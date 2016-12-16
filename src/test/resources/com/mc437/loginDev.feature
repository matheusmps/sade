Feature: Entrar no sistema como um desenvolvedor do Sade.

    Scenario: login como usuário cadastrado
        When Entrar na página 'http://localhost:8080/sade/login'
        When coloco usuário "Jo" e senha "jo"
        Then sou redirecionado para a página de dev
        And estou na página do dev Jo

	Scenario Outline: login inválido
        When Entrar na página 'http://localhost:8080/sade/login'
		When preencho uma combinação inválida nos campos <username> e <pass>
		Then sou redirecionado para a página de login
		And é mostrada a mensagem de erro "Username ou password inválido."
		Examples:
			|username		|pass					|
			|Jo				|naosousuasenha 		|
			|naosoudev		|123456					|
		