<template>
    <div>
        <Number
            label="AnnouncementId"
            v-model="value.announcementId"
            :editMode="editMode"
        />
        <String
            label="Title"
            v-model="value.title"
            :editMode="editMode"
        />
        <String
            label="Content"
            v-model="value.content"
            :editMode="editMode"
        />
        <Date
            label="CreatedAt"
            v-model="value.createdAt"
            :editMode="editMode"
        />
        <Date
            label="UpdatedAt"
            v-model="value.updatedAt"
            :editMode="editMode"
        />
        <Admin
            offline
            label="CreatedBy"
            v-model="value.createdBy"
            :editMode="editMode"
            @change="change"
        />
        <Admin
            offline
            label="UpdatedBy"
            v-model="value.updatedBy"
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
    name: 'Announcement',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "announcements",
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
