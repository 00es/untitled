<template>

    <v-card outlined>
        <v-card-title>
            WriteComment
        </v-card-title>

        <v-card-text>
            <WorkId offline label="WorkId" v-model="value.workId" :editMode="editMode" @change="change"/>
            <Reader offline label="Reader" v-model="value.reader" :editMode="editMode" @change="change"/>
            <String label="Content" v-model="value.content" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="writeComment"
            >
                WriteComment
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
    name: 'WriteCommentCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.workId = {};
        this.value.reader = {};
        this.value.content = '';
    },
    watch: {
    },
    methods: {
        writeComment() {
            this.$emit('writeComment', this.value);
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

