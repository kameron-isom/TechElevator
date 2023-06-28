<template>
  <div>
    <h3>{{ header }}</h3>
    <h4>Showing {{ movieCount }} movies from 2022</h4>
    <h4 v-show="currentMovie!==''">Currently looking at {{ currentMovie }}. Does that movie look interesting?</h4>
    Gross Higher Than: <input type="number" v-model.number="grossSearch" /><br/><br/>
    <div class="box-office-box">
        <div class="movie" v-on:mouseenter="movieMouseOver(movie.movie)" v-bind:class="movieClass(movie.distributor)" v-for="(movie, index) in movies" v-bind:key="index">
          <h3>{{ movie.movie }}</h3>
          <img v-bind:src="movie.poster" style="float:right" />
          <h4>{{ movie.distributor }}</h4>
          <b>Gross: </b> <span v-bind:class="{ 'big-gross' : movie.gross >= grossSearch && grossSearch !== null && grossSearch !== undefined && grossSearch > 0 }">${{ movie.gross }}</span><br/>
          <b>Screens: </b> {{ movie.theaters }}<br/>
          <em>{{ movie.release }}</em>
        </div>
    </div>
  </div>  
</template>

<script>
export default {
  name:"box-office",
  data() {
    return {
      header: "The top 10 domestic grossing movies of 2022",
      grossSearch: 0,
      currentMovie: "",
      movies: [
        {
          "movie": "Top Gun: Maverick",
          "gross": 718318561,
          "theaters": 4751,
          "release": "May 27",
          "distributor": "Paramount",
          "stars": ["Tom Cruise", "Jennifer Connolly", "Miles Teller"],
          "poster": require('../assets/topgun.jpg')
        },
        {
          "movie": "Black Panther: Wakanda Forever",
          "gross": 436499646,
          "theaters": 4396,
          "release": "Nov 11",
          "distributor": "Disney",
          "stars": ["Letitia Wright", "Lupita Nyong'o", "Angela Bassett"],
          "poster": require('../assets/blackpanther.jpg')
        },
        {
          "movie": "Doctor Strange in the Multiverse of Madness",
          "gross": 411331607,
          "theaters": 4534,
          "release": "May 6",
          "distributor": "Disney",
          "stars": ["Benedict Cumberbatch", "Elizabeth Olsen", "Chiwetel Ejiofor"],
          "poster": require('../assets/doctorstrange.jpg')
        },
        {
          "movie": "Avatar: The Way of Water",
          "gross": 684075767,
          "theaters": 4340,
          "release": "Dec 16",
          "distributor": "20th Century",
          "stars": ["Sam Worthington", "Zoe Saldana", "Sigourney Weaver"],
          "poster": require('../assets/avatar.jpg')
        },
        {
          "movie": "Jurassic World: Dominion",
          "gross": 376851080,
          "theaters": 4697,
          "release": "Jun 10",
          "distributor": "Universal",
          "stars": ["Chris Pratt", "Bryce Dallas Howard", "Laura Dern"],
          "poster": require('../assets/jurassic.jpg')
        },
        {
          "movie": "Minions: The Rise of Gru",
          "gross": 369695210,
          "theaters": 4427,
          "release": "Jul 1",
          "distributor": "Unviersal",
          "stars": ["Steve Carell", "Pierre Coffin", "Alan Arkin"],
          "poster": require('../assets/minions.jpg')
        },
        {
          "movie": "The Batman",
          "gross": 369345583,
          "theaters": 4417,
          "release": "Mar 4",
          "distributor": "Warner Bros",
          "stars": ["Robert Pattinson", "Zoe Kravitz", "Jeffrey Wright"],
          "poster": require('../assets/batman.jpg')
        },
        {
          "movie": "Thor: Love and Thunder",
          "gross": 343256830,
          "theaters": 4375,
          "release": "Jul 8",
          "distributor": "Disney",
          "stars": ["Chris Hemsworth", "Natalie Portman", "Christian Bale"],
          "poster": require('../assets/thor.jpg')
        },
        {
          "movie": "Spiderman: No Way Home",
          "gross": 804793477,
          "theaters": 4336,
          "release": "Dec 17",
          "distributor": "Sony",
          "stars": ["Tom Holland", "Zendaya", "Benedict Cumberbatch"],
          "poster": require('../assets/spiderman.jpg')
        },
        {
          "movie": "Sonic: the Hedgehog 2",
          "gross": 190872904,
          "theaters": 4258,
          "release": "Apr 8",
          "distributor": "Paramount",
          "stars": ["James Marsden", "Jim Carrey", "Ben Schwartz"],
          "poster": require('../assets/sonic.jpg')
        }
      ]
    }
  },
  computed: {
    movieCount() {
      return this.movies.length;
    }
  },
  methods: {
    movieClass(distributor) {
      if(distributor === 'Disney') return 'disney';
      if(distributor=== 'Paramount') return 'paramount';
      return '';
    },
    movieMouseOver(title) {
      this.currentMovie = title;
      setTimeout(()=> {
        this.currentMovie = '';
      }, 6000);
    }
  }
}
</script>

<style scoped>
  .box-office-box{
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    align-items: stretch;
    align-content: flex-start;
    gap: 15px;
  }

  .movie {
    border: 2px solid black;
    border-radius: 3px;
    padding: 10px;
    max-width: 300px;
    min-width: 200px;
    background-color: darkslategrey;
    color: beige;
  }

    .disney {
    background-color:olive;
  }
  
  .big-gross {
    font-size: 1.2em;
    color: red;
  }

  .paramount {
    background-color: teal;
  }
  
</style>