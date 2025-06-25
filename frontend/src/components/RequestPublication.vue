<template>

    <v-card outlined>
        <v-card-title>
            RequestPublication
        </v-card-title>

        <v-card-text>
            <Number label="WorkId" v-model="value.workId" :editMode="editMode"/>
            <Boolean label="CopyrightAgreement" v-model="value.copyrightAgreement" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="requestPublication"
            >
                RequestPublication
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
    name: 'RequestPublicationCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.workId = 0;
        this.value.copyrightAgreement = false;
    },
    watch: {
    },
    methods: {
        requestPublication() {
            this.$emit('requestPublication', this.value);
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

