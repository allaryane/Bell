# Bell : Spring Boot Vanilla Projet

<h2>Installation</h2>

Build : mvn clean package

Run : mvn spring-boot:run


<h2>Database (In Memory)</h2>
 
 La base de donneées SQL a été configurée en utilisant l'outil de persistence 
 <b>H2 database</b>.
 Pour se faire le fichier <b>application.properties</b> a été configuré comme suit : 
 
 ```properties
 spring.datasource.url=jdbc:h2:mem:bell;MVCC=true;DB_CLOSE_DELAY=-1;MODE=MySQL
 spring.datasource.username=sa 
 spring.datasource.password=
 spring.datasource.driver-class-name=org.h2.Driver 
 spring.datasource.platform=h2
 spring.datasource.initialize=true
 spring.h2.console.enabled=true
 spring.jpa.hibernate.ddl-auto=none
 spring.session.store-type=none
 security.user.password=root
 ```
 
Aussi H2 permet de créer la base de données SQL au démarrage de l'application en ajoutant les scripts SQL 
pour la création de la structure et des données (insertions), à la racine du répertoire <b>src/main/resources/</b> :

<b>schema-h2.sql</b>        <b>data-h2.sql</b>

Ainsi une fois l'application démarrée, la base de données est accessible via la console H2 à partir de l'url locale : 

<a href="http://localhost:8080/h2-console">http://localhost:8080/h2-console</a>

Par la suite pour se connecter à la base de données <b>bell</b> créer en mémoire, il faut cliquer sur le bouton "Connect",
en s'assurant avant que les paramètres de connexion requis sont corrects (Voir capture d'écran ci-dessous).

<img src="./h2Console.png" width="350" title="H2 Console"/>

<h2>Rest API</h2>

<u>Headers :</u>

Accept: application/json

Content-Type: application/json

<h4>Afficher un catalogue de produits</h4>
Catalog ID : 1,2

GET 
http://localhost:8080/product/catalog/{catalogId}


<h4>Afficher le détail d’un produit</h4>
Product ID : 1,2, ... 12, 17

GET 
http://localhost:8080/product/{productId}


<h4>Ajouter un produit au panier</h4>

POST
http://localhost:8080/product

{
    userId:{productId},
    productId:{productId},
    quantity:{quantity}
}
<br/>

<h4>Enlever un produit du panier</h4>

DELETE
http://localhost:8080/cart/{productId}


<h4>Afficher le contenu du panier</h4>
Affiche le contenu du panier pour un utilisateur donné par son id.
User ID : 1,2


GET
http://localhost:8080/cart/{userId}




