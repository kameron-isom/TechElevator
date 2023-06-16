let productService = {
  allProducts: [
    {
      "productId": 1,
      "productSku": "MUG-023",
      "name": "Solar Geeks coffee mug",
      "description": "Start your day off right!",
      "price": 14.99,
      "imageName": "https://via.placeholder.com/350x250.jpg"
    },
    {
      "productId": 2,
      "productSku": "YET-001",
      "name": "Solar Geeks Yeti",
      "description": "Keep cool all day long.",
      "price": 21.99,
      "imageName": "https://via.placeholder.com/350x250.jpg"
    },
    {
      "productId": 3,
      "productSku": "ART-256",
      "name": "Galactic poster",
      "description": "Beautiful view of a galaxy",
      "price": 9.59,
      "imageName": "https://via.placeholder.com/350x250.jpg"
    },
    {
      "productId": 4,
      "productSku": "TOY-978",
      "name": "Toy rocket",
      "description": "To infinite imagination",
      "price": 39.99,
      "imageName": "https://via.placeholder.com/350x250.jpg"
    },
    {
      "productId": 5,
      "productSku": "EAT-235",
      "name": "Astronaut ice cream",
      "description": "As cold as space",
      "price": 5.79,
      "imageName": "https://via.placeholder.com/350x250.jpg"
    },
    {
      "productId": 6,
      "productSku": "HAT-928",
      "name": "Solar Geeks baseball cap",
      "description": "Look stylish with our logo",
      "price": 16.89,
      "imageName": "https://via.placeholder.com/350x250.jpg"
    },
    {
      "productId": 7,
      "productSku": "LIT-612",
      "name": "Intro to Astrophysics",
      "description": "Learn about astrophysics",
      "price": 7.99,
      "imageName": "https://via.placeholder.com/350x250.jpg"
    }
  ],

  getProducts() {
    return this.allProducts;
  },


};
function displayCards(){
   const productCard= document.querySelectorAll('.product-card');
  productService.allProducts.forEach((product => {
    //product.productId.setAttribute("data-id", product.productId)
    //product.setAttribute("data-id", product.productId);
    div.setAttribute("data-id", product.productId);

  }));
   
}
  // const sku = document.querySelectorAll('.sku');
  //   const price = document.querySelectorAll('.price');
  //   const name = document.querySelectorAll('.product-name.action');
  //   const image = document.querySelectorAll('.product-image');
  // const productCard= document.querySelectorAll('.product-card');
  // for(i=0;i<=productCard.length;i++){
  // i.setAttribute("data-id", product.productId);
  // }
    

    
 // });
//}
 document.addEventListener('DOMContentLoaded', () =>{

  const clickName= document.querySelector('.product-name.action');
  clickName.addEventListener('click', window.alert);
  
  
  const shoppingCart = document.querySelector('.cart');
  shoppingCart.addEventListener('click', window.alert)
  });
  
function searchProducts(searchTerm){
//productService.allProducts.forEach
  if(searchTerm==productService.getProducts){
   foundProducts= productService.allProducts.filter(searchTerm);
    return foundProducts;
  }
  return getProducts;
};

