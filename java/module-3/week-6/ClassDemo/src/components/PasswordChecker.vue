<template>
  <div>
      <input type=password v-model="password" /><span :class="{red: hasProblems}">{{ hasProblems? problems.join(' ') : 'Looks good!' }}</span>
  </div>
</template>

<script>
export default {
    data() {
        return {
            password: '',
        }
    },
    computed: {
        hasProblems() {
            return this.problems.length > 0;
        },
        problems() {
            let result = [];
            if (this.password.length < 8) result.push('Must be at least 8 characters long.');
            if (!this.password.match(/[0-9]/)) result.push('Must contain a number.');
            if (!this.password.match(/[A-Z]/)) result.push('Must contain a capital letter.');

            return result;
        }
    }

}
</script>

<style scoped>
div {
    background-color: lightgray;
    height: 3em;
}
span {
    color: green;
    padding: 5px;
}

.red {
    color: red;
}

</style>
