<template>

    <v-card outlined>
        <v-card-title>
            ChargePoint
        </v-card-title>

        <v-card-text>
            <Reader offline label="Reader" v-model="value.reader" :editMode="editMode" @change="change"/>
            <Number label="Amount" v-model="value.amount" :editMode="editMode"/>
            <String label="PaymentMethod" v-model="value.paymentMethod" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="chargePoint"
            >
                ChargePoint
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
    name: 'ChargePointCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.reader = {};
        this.value.amount = 0;
        this.value.paymentMethod = '';
    },
    watch: {
    },
    methods: {
        chargePoint() {
            this.$emit('chargePoint', this.value);
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

