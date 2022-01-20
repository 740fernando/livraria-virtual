
# Aplicação web em Java - Livraria Virtual

### Como incorporar o Framework "WebF"  no projeto Livraria Virual.

- Realizar um clone https://github.com/740fernando/projeto-WebF

- Clicar com o botão direito no projeto "WebF"

- Ir na aba "Export..."

- Add JARs...

- Selecione "JAR FILE"

- Selecione apenas a pasta "src"

- Checked "Export generated class files and resources"

- Em "Select the export destination" -> Livraria/webContent/WEB-INF/web.jar


### Configurar o Apache Tomcat para reconhecer o perfil administrador

- Detalhe importante : Estou utilizando as funcionalidade do JAVA EE 6 

- Qual funcionalidade do JAVA EE 6 ? Anotação "@WebServlet" para definir o controller servlet no framework que foi criado

- O tom cat aceita o JAVA EE 6, a partir da versão 7.

- Foi utilizado o Apache Tomcat v9

- Configurar o arquivo tomcat-users.xml : < role rolename="admin" />
< user username="adm" password="123" roles="admin" />

### Diagrama ER

![diagram](https://github.com/740fernando/projeto-Livraria/blob/master/assets/er-diagram.JPG)


### Telas de usuário

<br>

<P><strong> Cadastro usuário </strong> </p>

  
![Cadastro](https://github.com/740fernando/livraria-virtual/blob/master/assets/usuario/Cadastro.JPG)


<br>

<P><strong> Carrinho  </strong> </p>

  
![ListaDepedidos](https://github.com/740fernando/livraria-virtual/blob/master/assets/usuario/LivroAdicionado.JPG)

<br>

  
![ListaDepedidos](https://github.com/740fernando/livraria-virtual/blob/master/assets/usuario/ListaDepedidos.JPG)


<br>




![carrinho](https://github.com/740fernando/livraria-virtual/blob/master/assets/usuario/carrinho.JPG)


<br>

<P><strong> Pedidos  </strong> </p>
  
![ListaDepedidos](https://github.com/740fernando/livraria-virtual/blob/master/assets/usuario/ListaDepedidosComDados.JPG)

<br>

![ListaDepedidos](https://github.com/740fernando/livraria-virtual/blob/master/assets/usuario/Pedidos.JPG)


<br>

<P><strong> Pesquisa de livros  </strong> </p>

  
![Livros](https://github.com/740fernando/livraria-virtual/blob/master/assets/usuario/Livros.JPG)


<br>


  
![LivrosPesquisados](https://github.com/740fernando/livraria-virtual/blob/master/assets/usuario/LivrosPesquisados.JPG)


<br>

<P><strong> Login  </strong> </p>

  
![login](https://github.com/740fernando/livraria-virtual/blob/master/assets/usuario/login.JPG)


<br>
