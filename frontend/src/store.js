import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios';

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        favourites: [],
        books: []
    },
    getters: {
        getFavourites: state => {
            return state.favourites
        },
        getBooks: state => {
            return state.books
        }
    },
    mutations: {
        setBooks(state, payload) {
            state.books = payload;
        },
        addBook(state, payload) {
            state.books.push(payload);
        },
        addToFavourites(state, payload) {
            state.favourites.push(payload);
        },
        removeFromFavourites(state, payload) {
            state.favourites.splice(state.favourites.indexOf(payload), 1);
        }
    },
    actions: {
        async getAllBooks({commit}) {
            await axios.get('/api/books')
                .then(res => res.data)
                .then(books => {
                    commit('setBooks', books)
                })
        },
        async saveBook({commit}, payload) {
            const { data } = await axios.post('/api/book', payload);
            commit('addBook', data);
        },
        addToFavourites({commit}, payload) {
            commit('addToFavourites', payload)
        },
        removeFromFavourites({commit}, payload) {
            commit('removeFromFavourites', payload)
        }
    }
})
