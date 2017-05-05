# Bell : Spring Boot Vanilla Projet

<u>Headers :</u>
Accept: application/json
Content-Type: application/json

<h3>Afficher un catalogue de produits</h3>
Catalog ID : 1,2

GET 
http://localhost:8080/product/catalog/{catalogId}


<h3>Afficher le détail d’un produit</h3>
Product ID : 1,2, ... 12, 17

GET 
http://localhost:8080/product/{productId}


<h3>Ajouter un produit au panier</h3>

POST
http://localhost:8080/product

{
    userId:{productId},
    productId:{productId},
    quantity:{quantity}
}
<br/>

<h3>Enlever un produit du panier</h3>

DELETE
http://localhost:8080/cart/{productId}


<h3>Afficher le contenu du panier</h3>
Affiche le contenu du panier pour un utilisateur donné par son id.
User ID : 1,2
<br/>
GET
http://localhost:8080/cart/{userId}



