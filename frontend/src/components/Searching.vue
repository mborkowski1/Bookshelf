<template>
    <v-container fluid class="my-2">
        <v-layout wrap class="justify-space-around">
            <v-flex xs12 sm4 lg3 class="ml-2">
                <v-select v-model="genre" :items="genres" label="Genre"></v-select>
            </v-flex>
            <v-flex xs12 sm4 lg3 class="mx-2">
                <v-text-field v-model="author" label="Search by author"></v-text-field>
            </v-flex>
            <v-flex xs12 sm4 lg3 class="mr-2">
                <v-text-field v-model="title" label="Search by title"></v-text-field>
            </v-flex>
        </v-layout>
    </v-container>
</template>

<script>
    export default {
        name: "Searching",
        data() {
            return {
                genres: ['fantasy', 'horror', 'sci-fi'],
                genre: '',
                author: '',
                title: ''
            }
        },
        watch: {
            genre(val) {
                this.$emit('searchedGenreChanged', val);
            },
            author(val) {
                this.$emit('searchedAuthorChanged', val);
            },
            title(val) {
                this.$emit('searchedTitleChanged', val);
            }
        }
    }
</script>

<style scoped>

</style>
