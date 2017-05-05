# Bell : Spring Boot Vanilla Projet

<u>Headers :</u>
Accept: application/json
Content-Type: application/json


<h5>Afficher un catalogue de produits</h5>
Catalog ID : 1,2

GET 
http://localhost:8080/product/catalog/{catalogId}


<h5>Afficher le détail d’un produit</h5>
Product ID : 1,2, ... 12, 17

GET 
http://localhost:8080/product/{productId}


<h5>Ajouter un produit au panier</h5>

POST
{
    userId:{productId},
    productId:{productId},
    quantity:{quantity}
}
http://localhost:8080/product



<h5>Enlever un produit du panier</h5>

DELETE
http://localhost:8080/cart/{productId}


<h5>Afficher le contenu du panier</h5>
Affiche le contenu du panier pour un utilisateur donné par son id.
User ID : 1,2

GET
http://localhost:8080/cart/{userId}



