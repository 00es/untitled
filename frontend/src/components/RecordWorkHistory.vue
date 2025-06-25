<template>

    <v-card outlined>
        <v-card-title>
            RecordWorkHistory
        </v-card-title>

        <v-card-text>
            <WorkId offline label="WorkId" v-model="value.workId" :editMode="editMode" @change="change"/>
            <HistoryEventType offline label="EventType" v-model="value.eventType" :editMode="editMode" @change="change"/>
            <Date label="EventAt" v-model="value.eventAt" :editMode="editMode"/>
            <Number label="EventBy" v-model="value.eventBy" :editMode="editMode"/>
            <String label="Description" v-model="value.description" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="recordWorkHistory"
            >
                RecordWorkHistory
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
    name: 'RecordWorkHistoryCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.workId = {};
        this.value.eventType = {};
        this.value.eventAt = '2025-06-25';
        this.value.eventBy = 0;
        this.value.description = '';
    },
    watch: {
    },
    methods: {
        recordWorkHistory() {
            this.$emit('recordWorkHistory', this.value);
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

