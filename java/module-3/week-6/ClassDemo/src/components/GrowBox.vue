<template>
    <div :style="divStyle">
        <input type="text" placeholder="size" v-model.lazy="size"/>
    </div>
</template>

<script>
export default {
    data() {
        return {
           private_size: 100
        }
    },
    computed: {
        size: {
            get() {
                return this.private_size;
            },
            set(val) {
                if (val >= 50) this.private_size = val;
                else this.private_size = 50;
            }
        },
        divStyle() {
            return {
                width: this.size + 'px',
                height: this.size + 'px'
            }
        }
    }

}
</script>

<style scoped>

* {
    box-sizing: border-box;
}
div {
    background-color: gold;
    border: 1px solid black;
    display: inline-block;
}

input {
    margin-top: 40%;
    width: 100%;
}
</style>
