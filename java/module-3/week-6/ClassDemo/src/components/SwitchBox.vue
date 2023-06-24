<!-- This one is more fun if you add a few hundred instances of it with a v-for -->

<template>
  <div :class="{red: isRed}">
      <input type="checkbox" v-model="isRed" />
  </div>
</template>

<script>
export default {
    data() {
        return {
            isRed: false
        }
    }

}
</script>

<style scoped>

* {
    box-sizing: border-box;
}

div {
    width: 50px;
    height: 50px;
    background-color: skyblue;
    padding-top: 15px;
    display: inline-block;
    text-align: center;
}

.red {
    background-color: firebrick;
}

</style>
