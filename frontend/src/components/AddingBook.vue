<template>
    <v-dialog v-model="dialog" persistent max-width="600px">
        <v-btn class="primary" depressed slot="activator">Add New Book</v-btn>
        <v-card>
            <v-card-title class="justify-center">
                <h2>Add A New Book</h2>
            </v-card-title>
            <v-card-text class="justify-center">
                <v-form class="px-2" ref="form" v-model="valid" @submit.prevent="addNewBook">
                    <v-text-field v-model="title" :rules="titleRules" label="Title" required></v-text-field>
                    <v-text-field v-model="photo" label="Photo url" :rules="photoRules" required></v-text-field>
                    <v-responsive v-show="photo !== ''">
                        <v-img :src="photo" aspect-ratio="1" contain></v-img>
                    </v-responsive>
                    <v-text-field v-model="author" :rules="authorRules" label="Author" required></v-text-field>
                    <v-select v-model="genre" :items="genres" label="Genre" :rules="genreRules" required></v-select>
                    <v-textarea auto-grow v-model="description" :rules="descriptionRules" label="Description" required></v-textarea>
                <v-spacer></v-spacer>
                <div class="mt-3 text-xs-center">
                    <v-btn class="warning" depressed @click="closeDialog">Close</v-btn>
                    <v-btn class="success" depressed type="submit" :disabled="!valid">Add Book</v-btn>
                </div>
                </v-form>
            </v-card-text>
        </v-card>
    </v-dialog>
</template>

<script>
    import { mapActions } from 'vuex';

    export default {
        name: "AddingBook",
        data() {
            return {
                dialog: false,
                valid: false,
                title: '',
                titleRules: [
                    v => !!v || 'Title is required'
                ],
                author: '',
                authorRules: [
                    v => !!v || 'Author is required'
                ],
                genre: null,
                genreRules: [
                    v => !!v || 'Genre is required'
                ],
                description: '',
                descriptionRules: [
                    v => !!v || 'Description is required'
                ],
                photo: '',
                photoRules: [
                    v => !!v || 'Photo url is required'
                ],
                genres: ['fantasy', 'horror', 'sci-fi']
            }
        },
        methods: {
            ...mapActions({
                saveBook: 'saveBook'
            }),
            addNewBook() {
                if (this.$refs.form.validate()) {
                    const newBook = {
                        title: this.title,
                        author: this.author,
                        genre: this.genre,
                        description: this.description,
                        photo: this.photo
                    };
                    this.saveBook(newBook);
                    this.dialog = false;
                    this.valid = false;
                    this.genre = null;
                    this.title = '';
                    this.photo = '';
                    this.author = '';
                    this.description = '';
                    this.$emit('bookAdded');
                }
            },
            closeDialog() {
                this.dialog = false;
                this.valid = false;
                this.genre = null;
                this.title = '';
                this.photo = '';
                this.author = '';
                this.description = '';
            }
        }
    }
</script>

<style scoped lang="scss">

</style>
