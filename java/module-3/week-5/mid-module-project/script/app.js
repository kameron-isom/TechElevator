/*
    app.js

*/
document.addEventListener('DOMContentLoaded', () =>{

    displayCards();
    addToCart();
    displayDescription();


  // display product discritption when clicking on name
  function displayDescription(){
    const clickName= document.querySelectorAll('.product-name.action');
    clickName.forEach((productName)=>{
      productName.addEventListener('click',(name) =>{
        const productID=Number(name.currentTarget.getAttribute("data-id"));
        alert(productID.projectDescription)
      });
  
  });
}
    
    // display string after clicking on cart
    function addToCart(){
    const carts = document.querySelectorAll('.cart');
    carts.forEach((cart)=>{
      cart.addEventListener('click',() => {
          alert("item added to cart!")
      });
    });
  }

    });

   