<template>
    <section>
        <h1 class="display-1 text-xs-center mt-3">Your Favourite Books</h1>
        <h2 v-show="getFavourites().length === 0" class="text-xs-center mt-3">You haven't got any favourite books</h2>
        <Searching v-show="getFavourites().length !== 0" @searchedGenreChanged="changeSearchedGenre" @searchedAuthorChanged="changeSearchedAuthor" @searchedTitleChanged="changeSearchedTitle" />
        <Book :books="filteredBooks" :favourites="true" v-show="getFavourites().length !== 0" />
    </section>
</template>

<script>
    import { mapGetters } from 'vuex';
    import Book from '../components/Book';
    import Searching from '../components/Searching';

    export default {
        name: "Favourites",
        components: {
            Book,
            Searching
        },
        data() {
            return {
                searchedGenre: '',
                searchedAuthor: '',
                searchedTitle: ''
            }
        },
        methods: {
            ...mapGetters({
                getFavourites: 'getFavourites'
            }),
            changeSearchedGenre(val) {
                this.searchedGenre = val;
            },
            changeSearchedAuthor(val) {
                this.searchedAuthor = val;
            },
            changeSearchedTitle(val) {
                this.searchedTitle = val;
            }
        },
        computed: {
            filteredBooks() {
                let booksToShow = this.getFavourites();
                if (this.searchedGenre !== '')
                    booksToShow = booksToShow.filter(book => book.genre === this.searchedGenre);
                if (this.searchedAuthor !== '')
                    booksToShow = booksToShow.filter(book => book.author.toLowerCase().includes(this.searchedAuthor.toLowerCase()));
                if (this.searchedTitle !== '')
                    booksToShow = booksToShow.filter(book => book.title.toLowerCase().includes(this.searchedTitle.toLowerCase()));
                return booksToShow;
            }
        }
    }
</script>

<style scoped lang="scss">

</style>
