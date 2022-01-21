
<h1 align="center"> Aplicação web em Java - Livraria Virtual </h1>



<h2 align="center">Como incorporar o Framework "WebF"  no projeto Livraria Virual.</h2>



- Realizar um clone https://github.com/740fernando/projeto-WebF

- Clicar com o botão direito no projeto "WebF"

- Ir na aba "Export..."

- Add JARs...

- Selecione "JAR FILE"

- Selecione apenas a pasta "src"

- Checked "Export generated class files and resources"

- Em "Select the export destination" -> Livraria/webContent/WEB-INF/web.jar

----------------------------------------------------------------------------

<h2 align="center"> Configurar o Apache Tomcat para reconhecer o perfil administrador </h2>



- Detalhe importante : Estou utilizando as funcionalidade do JAVA EE 6 

- Qual funcionalidade do JAVA EE 6 ? Anotação "@WebServlet" para definir o controller servlet no framework que foi criado

- O tom cat aceita o JAVA EE 6, a partir da versão 7.

- Foi utilizado o Apache Tomcat v9

- Configurar o arquivo tomcat-users.xml : < role rolename="admin" />
< user username="adm" password="123" roles="admin" />

----------------------------------------------------------------------------

<h2 align="center">Diagrama ER</h2>


<p align="center">

<img src="https://github.com/740fernando/projeto-Livraria/blob/master/assets/er-diagram.JPG">

 </p>
 
----------------------------------------------------------------------------

<h2 align="center"> Telas "user" </h2>


<br>

<h3 align="center"><strong> Cadastro usuário </strong> </h3>

<br>

![Cadastro](https://github.com/740fernando/livraria-virtual/blob/master/assets/usuario/Cadastro.JPG)

----------------------------------------------------------------------------
<br>

<h3 align="center"><strong> Carrinho  </strong> </h3>

  
![ListaDepedidos](https://github.com/740fernando/livraria-virtual/blob/master/assets/usuario/LivroAdicionado.JPG)


<br>

  
![ListaDepedidos](https://github.com/740fernando/livraria-virtual/blob/master/assets/usuario/ListaDepedidos.JPG)


<br>



![carrinho](https://github.com/740fernando/livraria-virtual/blob/master/assets/usuario/carrinho.JPG)


<br>

----------------------------------------------------------------------------

<h3 align="center"><strong> Pedidos  </strong> </h3>

<br>
  
![ListaDepedidos](https://github.com/740fernando/livraria-virtual/blob/master/assets/usuario/ListaDepedidosComDados.JPG)

<br>

![ListaDepedidos](https://github.com/740fernando/livraria-virtual/blob/master/assets/usuario/Pedidos.JPG)


<br>

----------------------------------------------------------------------------

<h3 align="center"><strong> Pesquisa de livros  </strong> </h3>

<br>
  
![Livros](https://github.com/740fernando/livraria-virtual/blob/master/assets/usuario/Livros.JPG)


<br>


  
![LivrosPesquisados](https://github.com/740fernando/livraria-virtual/blob/master/assets/usuario/LivrosPesquisados.JPG)




----------------------------------------------------------------------------

<h3 align="center"><strong> Login  </strong> </h3>

<br>

![login](https://github.com/740fernando/livraria-virtual/blob/master/assets/usuario/login.JPG)


<br>

----------------------------------------------------------------------------

<h2 align="center"> Telas "admin" </h2>


<h3 align="center><strong>Home</strong></h3>

<br>

![Home](https://github.com/740fernando/livraria-virtual/blob/master/assets/admin/home.JPG)         
           
----------------------------------------------------------------------------

<h3 align="center"><strong> Livros  </strong> </h3>


![AlterarLivros](https://github.com/740fernando/livraria-virtual/blob/master/assets/admin/AlterarLivros.JPG)

<br>

![CadastrarLivros](https://github.com/740fernando/livraria-virtual/blob/master/assets/admin/CadastrarLivros.JPG)

<br>

![ExcluirLivros](https://github.com/740fernando/livraria-virtual/blob/master/assets/admin/ExcluirLivros.JPG)

<br>

![ExibirLivros](https://github.com/740fernando/livraria-virtual/blob/master/assets/admin/Livros.JPG)

----------------------------------------------------------------------------

<h3 align="center"><strong> Pedidos  </strong> </h3>

<br>

![Pedidos](https://github.com/740fernando/livraria-virtual/blob/master/assets/admin/Pedidos.JPG)

<br>
             


