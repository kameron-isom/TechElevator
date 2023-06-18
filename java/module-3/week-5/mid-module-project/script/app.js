/*
    app.js

*/
<<<<<<< HEAD
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
=======
let product=productService.getProducts();

// create cards
function createCards(product){
  const card = document.createElement('article');
  card.classList.add('product-card')
  
  //create sku
  let sku= document.createElement('div');
  sku.classList.add('sku');
  sku.innerText=product.productSku
  card.appendChild(sku);
  
  // create name
  let name= document.createElement('div');
  name.classList.add('product-name', 'action');
  name.innerText=product.name;
  card.appendChild(name);
  name.setAttribute("data-id", product.productId)
  
  // create price
  let price= document.createElement('div');
  price.classList.add('price');
  price.innerText=product.price;
  card.appendChild(price);
  
  // create image
  let image= document.createElement('div');
  image.classList.add('product-image');
  let imagetag = document.createElement('img');
  imagetag.setAttribute('src', product.imageName);
  image.appendChild(imagetag);
  card.appendChild(image);
  
  //create shopping cart
  let shoppingCartIcon = document.createElement('div');
  shoppingCartIcon.classList.add('cart');
  let icon =document.createElement('i');
  icon.setAttribute('title', 'add item to cart');
  icon.classList.add('fa-solid','fa-cart-plus', 'icon','action');
  shoppingCartIcon.appendChild(icon);
  card.appendChild(shoppingCartIcon);
  shoppingCartIcon.setAttribute("data-id", product.productId);
  
  return card;
  }
  
  // display cards
  function displayCards(){
      const section= document.getElementById('product-cards');
       productService.allProducts.forEach((item)=>{
         return section.appendChild(createCards(item));
      });
      
  }

document.addEventListener('DOMContentLoaded', () =>{

    displayCards();
    addToCart();
    displayDescription();
    ProductSearch(searchTerm);
    

// alert with description
  function getProductDescription(id){
    product.forEach((prod)=>{
      if(id === prod.productId){
        alert(prod.description);
      }
    });
  }

  // display product discritption when clicking on name
  function displayDescription(){
    const clickName= document.querySelectorAll('.product-name.action');
    clickName.forEach((productName)=>{
      productName.addEventListener('click',(event) =>{
        const id=Number(event.currentTarget.getAttribute("data-id"));
        getProductDescription(id);
      });
  
  });
>>>>>>> 57fcb4b964c8b78ae79b2607928aec144f8a32d1
}

function displayCards(){
    const section= document.getElementById('product-cards');
      productService.getProducts.forEach((item)=>{
       section.appendChild(createCards(item));
    });
    
}

<<<<<<< HEAD
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
=======
  //product search
  function ProductSearch(searchTerm){
    const search= document.getElementById('search-tool')
    search.addEventListener('keyup',event=> {
      searchTerm = event.currentTarget.value
      if(searchTerm === ""){
        displayCards()
      } else {
        displayCards(productService.searchProducts(searchTerm));
      }
    })
    displayCards(productService.getProducts());
}

>>>>>>> 57fcb4b964c8b78ae79b2607928aec144f8a32d1
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