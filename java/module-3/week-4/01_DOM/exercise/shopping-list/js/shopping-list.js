// add pageTitle
const pageTitle = "My Shopping List";
// add groceries
const groceries= [ 
  {  id: 1,
  food: 'Apples',
  completed: true
},
{
  id: 2,
  task: 'Broccli',
  completed: true
},
{
  id: 3,
  food: 'Sugar',
  completed: true
},
{
  id: 4,
  food: 'Goat Cheese',
  completed: true
},
{
  id: 5,
  food: 'Ding Dongs',
  completed: true
},
{
  id: 6,
  food: 'Water',
  completed: true
},
{
  id: 7,
  food: 'Apples',
  completed: true
},
{
  id: 8,
  food: 'Oranges',
  completed: true
},
{
  id: 9,
  food: 'Berries',
  completed: true
},
{
  id: 10,
  food : 'Juice',
  completed: true
}]

 const shoppingList = document.getElementById('groceries');
/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  const heading = document.getElementById('title');
  heading.innerText = pageTitle;
  
}
/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
  const ul = document.getElementById('groceries');
  groceries.forEach((todo) => {
    const li = document.createElement('li');
    li.innerText = todo.food;
    ul.appendChild(li);
  });
}

/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {
const ul = document.getElementById('groceries');
const li = document.querySelectorAll('li')
li.forEach((todo) => {
 todo.classList.add('completed');
});
}

setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
});
