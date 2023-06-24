<template>
  <div>
      <select v-model="selectedEmoji">
          <option value="">Please Select</option>
          <option v-for="animal in animals" :key="animal.name" :value="animal.emoji">{{ animal.name }}</option>
      </select>
      <span>{{ selectedEmoji }}</span>
  </div>
</template>

<script>
export default {
    data() {
        return {
            selectedEmoji: '',
            animals: [
                {name: 'Dog', emoji: '🐶'},
                {name: 'Cat', emoji: '🐱'},
                {name: 'Frog', emoji: '🐸'}
            ]
        }
    }

}
</script>

<style scoped>
span {
    font-size: 3em;
}
</style>
