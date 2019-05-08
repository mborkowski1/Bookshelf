<template>
    <section>
        <v-snackbar v-model="snackbar" multi-line :timeout="2000" top>
            <span>You added a new book</span>
            <v-btn flat color="green" @click="snackbar = false">Close</v-btn>
        </v-snackbar>
        <h1 class="display-1 text-xs-center mt-3">Available Books</h1>
        <div class="text-xs-center mt-3">
            <AddingBook @bookAdded="snackbar = true" />
        </div>
        <Searching @searchedGenreChanged="changeSearchedGenre" @searchedAuthorChanged="changeSearchedAuthor" @searchedTitleChanged="changeSearchedTitle" />
        <Book :books="filteredBooks" :favourites="false" />
    </section>
</template>

<script>
    import { mapGetters, mapActions } from 'vuex';
    import Book from '../components/Book';
    import Searching from '../components/Searching';
    import AddingBook from "../components/AddingBook";

    export default {
        name: 'Home',
        components: {
            AddingBook,
            Book,
            Searching
        },
        data() {
            return {
                searchedGenre: '',
                searchedAuthor: '',
                searchedTitle: '',
                snackbar: false
            }
        },
        created() {
            this.getAllBooks();
        },
        methods: {
            ...mapGetters({
                getBooks: 'getBooks'
            }),
            ...mapActions({
                getAllBooks: 'getAllBooks'
            }),
            changeSearchedGenre(val) {
                this.searchedGenre = val;
            },
            changeSearchedAuthor(val) {
                this.searchedAuthor = val;
            },
            changeSearchedTitle(val) {
                this.searchedTitle = val;
            },
        },
        computed: {
            filteredBooks() {
                let booksToShow = this.getBooks();
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
