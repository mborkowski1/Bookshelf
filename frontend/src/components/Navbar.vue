<template>
    <nav>
        <v-toolbar color="indigo" dark fixed app>
            <v-toolbar-title class="text-uppercase"><router-link to="/">Bookshelf</router-link></v-toolbar-title>
            <v-spacer></v-spacer>
            <v-toolbar-items class="hidden-sm-and-down">
                <v-btn v-for="link in links" :key="link.text" :to="link.route" flat>{{ link.text }}</v-btn>
            </v-toolbar-items>
            <v-menu offset-y class="hidden-md-and-up">
                <v-toolbar-side-icon slot="activator"></v-toolbar-side-icon>
                <v-list>
                    <v-list-tile v-for="link in links" :key="link.text" router :to="link.route">
                        <v-list-tile-content>
                            <v-list-tile-title class="text-uppercase">{{ link.text }}</v-list-tile-title>
                        </v-list-tile-content>
                    </v-list-tile>
                </v-list>
            </v-menu>
        </v-toolbar>
    </nav>
</template>

<script>
    export default {
        name: "Navbar",
        data() {
            return {
                links: [
                    { text: 'Books', route: '/' },
                    { text: 'Favourite Books', route: '/favourites' }
                ]
            }
        }
    }
</script>

<style scoped lang="scss">
    a {
        color: white;
        text-decoration: none;
    }
</style>
