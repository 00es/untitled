<template>
    <div>
        <Number
            label="HistoryId"
            v-model="value.historyId"
            :editMode="editMode"
        />
        <Date
            label="EventAt"
            v-model="value.eventAt"
            :editMode="editMode"
        />
        <Number
            label="EventBy"
            v-model="value.eventBy"
            :editMode="editMode"
        />
        <String
            label="Description"
            v-model="value.description"
            :editMode="editMode"
        />
        <HistoryEventType
            offline
            label="EventType"
            v-model="value.eventType"
            :editMode="editMode"
            @change="change"
        />
        <WorkId
            offline
            label="작품 ID"
            v-model="value.workId"
            :editMode="editMode"
            @change="change"
        />
        <v-row class="ma-0 pa-0">
            <v-spacer></v-spacer>
            <v-btn width="64px" color="primary" @click="save">
                저장
            </v-btn>
        </v-row>
    </div>
</template>


<script>
import BaseEntity from './base-ui/BaseEntity.vue'

export default {
    name: 'WorkHistory',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "workHistories",
        value: {
        }
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
