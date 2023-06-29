<template>
  <div class="book-container" >
    <div v-for=" book in $store.state.books" v-bind:key="book.author"></div>
    <book-card v-model= "book.read"> </book-card>

  </div>
</template>

<script>
import BookCard from './BookCard.vue'

export default {
  components: { BookCard },
    name: 'reading-list',
    data(){
       return{
            newBook: {
                title: '',
                author: '',
                read: false,
                isbn: ''
            }
        }
    },

}
</script>

<style>
.book-container {
    display: flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}
</style>