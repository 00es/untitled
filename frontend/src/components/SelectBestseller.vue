<template>

    <v-card outlined>
        <v-card-title>
            SelectBestseller
        </v-card-title>

        <v-card-text>
            <WorkId offline label="WorkId" v-model="value.workId" :editMode="editMode" @change="change"/>
            <Admin offline label="Admin" v-model="value.admin" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="selectBestseller"
            >
                SelectBestseller
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
    name: 'SelectBestsellerCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.workId = {};
        this.value.admin = {};
    },
    watch: {
    },
    methods: {
        selectBestseller() {
            this.$emit('selectBestseller', this.value);
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

