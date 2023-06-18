/*
    app.js

*/
function createCards(product){
const card = document.createElement('article');
card.classList.add('.product-card')

//create sku
let sku= document.createElement('div');
sku.classList.add('.sku');
sku.innerText=product.productSku
card.appendChild(sku);

// create name
let name= document.createElement('div');
name.classList.add('.name');
name.innerText=product.name;
card.appendChild(name);
name.setAttribute("data-id", product.productId)

// create price
let price= document.createElement('div');
price.classList.add('.price');
price.innerText=currency(product.price);
card.appendChild(price);

// create image
let image= document.createElement('div');
image.classList.add('.product-image');
image.src=product.imageName;
card.appendChild(image);

//create shopping cart
let shoppingCartIcon = document.createElement('div');
shoppingCartIcon.classList.add('.cart');
shoppingCartIcon.innerText='<i class="fa-solid fa-cart-plus icon action" title="Add item to cart"></i>'
card.appendChild(shoppingCartIcon);
shoppingCartIcon.setAttribute("data-id", product.productId);

return card;
}

function displayCards(){
    const section= document.getElementById('product-cards');
      productService.getProducts.forEach((item)=>{
       section.appendChild(createCards(item));
    });
    
}

document.addEventListener('DOMContentLoaded', () =>{
    createCards();
    displayCards();

    const clickName= document.querySelectorAll('.product-name.action');
    clickName.forEach((productName)=>{
      productName=Number(productName.getAttribute("data-id"));
      productName.addEventListener('click',window.alert(product.description))
    });
    
    
    const shoppingCart = document.querySelectorAll('cart');
    shoppingCart.forEach((cartItem)=>{
        shoppingCart=Number(cartItem.getAttribute("data-it"));
        shoppingCart.addEventListener('click', window.alert("Item has been added to cart"))
    })
    });

    function searchProducts(searchTerm){
        productService.allProducts.forEach((product=>{
          if(searchTerm==product){
            foundProducts= productService.allProducts.filter(searchTerm);
             return foundProducts;
           }
           return getProducts;
        }))
        };