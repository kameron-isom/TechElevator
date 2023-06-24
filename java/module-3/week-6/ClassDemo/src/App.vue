<template>
    <div id="app">
        <h1>2022 Top Movies</h1>
        <box-office />
        <animal-select />
        <dessert-menu />
        <fun-table />
        <grow-box />
        <password-checker />
        <switch-box />
    </div>
</template>

<script>
import BoxOffice from "./components/BoxOffice.vue";
import AnimalSelect from "./components/AnimalSelect.vue";
import DessertMenu from "./components/DessertMenu.vue";
import FunTable from "./components/FunTable.vue";
import GrowBox from "./components/GrowBox.vue";
import PasswordChecker from "./components/PasswordChecker.vue";
import SwitchBox from "./components/SwitchBox.vue";

export default {
    name: "app",
    components: {
        BoxOffice,
        AnimalSelect,
        DessertMenu,
        FunTable,
        GrowBox,
        PasswordChecker,
        SwitchBox
    }
};
</script>

<style>
</style>