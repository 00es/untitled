<template>

    <v-card outlined>
        <v-card-title>
            LiftSanction
        </v-card-title>

        <v-card-text>
            <Number label="SanctionId" v-model="value.sanctionId" :editMode="editMode"/>
            <Admin offline label="Admin" v-model="value.admin" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="liftSanction"
            >
                LiftSanction
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
    name: 'LiftSanctionCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.sanctionId = 0;
        this.value.admin = {};
    },
    watch: {
    },
    methods: {
        liftSanction() {
            this.$emit('liftSanction', this.value);
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

