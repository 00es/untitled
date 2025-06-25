<template>

    <v-card outlined>
        <v-card-title>
            ReportComment
        </v-card-title>

        <v-card-text>
            <Number label="CommentId" v-model="value.commentId" :editMode="editMode"/>
            <Reader offline label="Reader" v-model="value.reader" :editMode="editMode" @change="change"/>
            <String label="Reason" v-model="value.reason" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="reportComment"
            >
                ReportComment
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
    name: 'ReportCommentCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.commentId = 0;
        this.value.reader = {};
        this.value.reason = '';
    },
    watch: {
    },
    methods: {
        reportComment() {
            this.$emit('reportComment', this.value);
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

