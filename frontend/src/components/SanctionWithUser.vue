<template>
    <div>
        <Number
            label="SanctionId"
            v-model="value.sanctionId"
            :editMode="editMode"
        />
        <String
            label="Reason"
            v-model="value.reason"
            :editMode="editMode"
        />
        <Date
            label="StartDate"
            v-model="value.startDate"
            :editMode="editMode"
        />
        <Date
            label="EndDate"
            v-model="value.endDate"
            :editMode="editMode"
        />
        <SanctionStatus
            offline
            label="Status"
            v-model="value.status"
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
    name: 'SanctionWithUser',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "sanctionWithUsers",
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
