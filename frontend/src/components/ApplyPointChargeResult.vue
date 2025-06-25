<template>

    <v-card outlined>
        <v-card-title>
            ApplyPointChargeResult
        </v-card-title>

        <v-card-text>
            <Number label="PointId" v-model="value.pointId" :editMode="editMode"/>
            <PointChargeStatus offline label="Status" v-model="value.status" :editMode="editMode" @change="change"/>
            <Date label="ChargedAt" v-model="value.chargedAt" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="applyPointChargeResult"
            >
                ApplyPointChargeResult
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
    name: 'ApplyPointChargeResultCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.pointId = 0;
        this.value.status = {};
        this.value.chargedAt = '2025-06-25';
    },
    watch: {
    },
    methods: {
        applyPointChargeResult() {
            this.$emit('applyPointChargeResult', this.value);
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

