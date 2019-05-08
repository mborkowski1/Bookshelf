<template>
    <v-container fluid class="my-2">
        <v-snackbar v-if="!favourites" v-model="snackbar" multi-line :timeout="2000" top>
            <span>Book has been added to favourites</span>
            <v-btn color="green" flat @click="snackbar = false">Close</v-btn>
        </v-snackbar>
        <v-snackbar v-else v-model="snackbar" multi-line :timeout="2000" top>
            <span>Book has been removed from favourites</span>
            <v-btn color="green" flat @click="snackbar = false">Close</v-btn>
        </v-snackbar>
        <v-layout row wrap class="justify-center">
            <v-flex xs12 sm6 md3 lg2 class="ma-2" v-for="book in paginatedData" :key="book.id">
                <v-card flat class="text-xs-center blue-grey">
                    <v-responsive class="pt-3">
                        <v-img :src="book.photo" contain aspect-ratio="1"></v-img>
                    </v-responsive>
                    <v-card-title class="justify-center pb-0">
                        <h3 class="headline">{{ book.title }}</h3>
                    </v-card-title>
                    <v-card-text>
                        <p class="font-weight-bold">{{ book.author }}</p>
                        <p class="font-weight-bold">{{ book.genre }}</p>
                        <p class="mb-0">{{ book.description }}</p>
                    </v-card-text>
                    <v-divider class="mt-0" light></v-divider>
                    <v-card-actions class="justify-center" v-if="!favourites">
                        <v-tooltip bottom :disabled="!checkIfFavourite(book)">
                            <v-btn slot="activator" flat class="add-to-favourites-button" @click="(addToFavourites(book)) && (snackbar = true)" :disabled="checkIfFavourite(book)">
                                <v-icon small left>favorite</v-icon>
                                <span>Add To Favourites</span>
                            </v-btn>
                            <span>Book is actually in favourites</span>
                        </v-tooltip>
                    </v-card-actions>
                    <v-card-actions class="justify-center" v-else>
                        <v-btn flat class="add-to-favourites-button" @click="(removeFromFavourites(book)) && (snackbar = true)">
                            <v-icon small left>favorite</v-icon>
                            <span>Remove From Favourites</span>
                        </v-btn>
                    </v-card-actions>
                </v-card>
            </v-flex>
        </v-layout>
        <div class="text-xs-center">
            <v-btn depressed color="primary" :disabled="pageNumber === 0" @click="prevPage">Previous</v-btn>
            <v-btn depressed color="primary" :disabled="pageNumber >= pageCount - 1" @click="nextPage">Next</v-btn>
        </div>
    </v-container>
</template>

<script>
    import { mapGetters, mapActions } from 'vuex';

    export default {
        name: "Book",
        props: {
            books: {
                type: Array,
                required: true
            },
            favourites: {
                type: Boolean,
                required: true
            }
        },
        data() {
            return {
                snackbar: false,
                pageNumber: 0,
                size: 5
            }
        },
        methods: {
            ...mapGetters({
                getFavourites: 'getFavourites'
            }),
            ...mapActions({
                addToFavourites: 'addToFavourites',
                removeFromFavourites: 'removeFromFavourites'
            }),
            checkIfFavourite(book) {
                let isFavourite = false;
                const favourites = this.getFavourites();
                favourites.forEach(favourite => {
                    if (favourite.id === book.id)
                        isFavourite = true;
                });
                return isFavourite;
            },
            nextPage() {
                this.pageNumber++;
            },
            prevPage() {
                this.pageNumber--;
            }
        },
        computed: {
            pageCount() {
                let l = this.books.length;
                let s = this.size;
                return Math.ceil(l/s);
            },
            paginatedData() {
                const start = this.pageNumber * this.size;
                const end = start + this.size;
                return this.books.slice(start, end);
            }
        }
    }
</script>

<style scoped lang="scss">
    .add-to-favourites-button {
        color: #00B8D4;
    }
</style>
