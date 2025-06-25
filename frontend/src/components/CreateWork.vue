<template>

    <v-card outlined>
        <v-card-title>
            CreateWork
        </v-card-title>

        <v-card-text>
            <Author offline label="Author" v-model="value.author" :editMode="editMode" @change="change"/>
            <String label="Title" v-model="value.title" :editMode="editMode"/>
            <String label="Content" v-model="value.content" :editMode="editMode"/>
            <Boolean label="CopyrightAgreement" v-model="value.copyrightAgreement" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="createWork"
            >
                CreateWork
            </v-btn>
            
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>

export default {
    name: 'CreateWorkCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.author = {};
        this.value.title = '';
        this.value.content = '';
        this.value.copyrightAgreement = false;
    },
    watch: {
    },
    methods: {
        createWork() {
            this.$emit('createWork', this.value);
        },
        close() {
            this.$emit('closeDialog');
        },
        change() {
            this.$emit("update:modelValue", this.value);
        },
    }
}
</script>

