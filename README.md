#  SADE - MC437
### Professor: Eliane Martins
----
### PED: Jael Zela
### Alunos: 
*	Renato Toshiaki Shibata	 -- RA: 082674
*   Matheus Pinheiros		 -- RA: 119920
*	Stéfani Fernandes		 -- RA: 147939
*   Ronaldo Prata			 -- RA: 157228
*	Flávio Moura			 -- RA: 104947
*	Thiago					 -- RA: 157413
*	Yuri					 -- RA: 158526
*	Felipe					 -- RA: 145993

## 1)Pré-requisitos para instalação
1.  `Tomcat`: Possuir uma versão do Apache Tomcat instalado, de preferência versão 8.0 para cima. Link para donwload do [Tomcat 8.5.9]( http://tomcat.apache.org/download-80.cgi#8.5.8) tanto para Windows quanto para Linux.

2.  `Maven`: Possuir uma versão recente do Apache Maven instalado. Link para donwload do  [Maven 3.3.9](http://maven.apache.org/download.cgi) tanto para Windows quanto para Linux.

3.  `Bash Shell (terminal)`: Se você estiver rodando em uma versão de Windows anterior ao Windows 10, você precisa baixar um interpretador de shell bash ou instalar o [Cygwin](https://cygwin.com/install.html). Se estiver no Linux ou Windows 10, basta abrir o terminal Bash.

4.  `Git`: Possuir Git instalado. Para instalar:
>$ sudo apt-get install git


##   2)Guia de Instalação
Primeiramente, clone do repositório do `Github` o projeto Sade:
>$   git clone https://github.com/matheusmps/sade

Agora precisamos antes de tudo alterar as informações sobre o banco de dados (estamos utilizando Mysql) que será utilzado para o projeto. Abra o arquivo:
> src/main/resources/application.properties

E altere as seguintes propriedads com as informações correspondetes ao banco:
>jdbc.driver: só alterar se for utilizar outro banco que não Mysql (ainda assim ele deve ser relacional)
>jdbc.url: url para o banco (se local usar por exemplo: jdbc:mysql://localhost:3306/sade)
>jdbc.username
>jdbc.password

Em seguida, entra na pasta do projeto e rode o maven: 
>$ mvn clean install -DskipTests=true

Copie o arquivo `target/sade-1.0.0.war` que foi gerado na pasta do projeto pelo Maven.

Depois copie o arquivo para a pasta `/webapps` do tomcate depois inicie o tomcat clicando em:
>$ /bin/startup
