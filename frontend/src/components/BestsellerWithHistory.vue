<template>
    <div>
        <Number
            label="HistoryId"
            v-model="value.historyId"
            :editMode="editMode"
        />
        <Date
            label="Timestamp"
            v-model="value.timestamp"
            :editMode="editMode"
        />
        <BestsellerActionType
            offline
            label="ActionType"
            v-model="value.actionType"
            :editMode="editMode"
            @change="change"
        />
        <Admin
            offline
            label="Admin"
            v-model="value.admin"
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
    name: 'BestsellerWithHistory',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "bestsellerWithHistories",
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
