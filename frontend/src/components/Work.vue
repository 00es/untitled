<template>
    <div>
        <Number
            label="WorkId"
            v-model="value.workId"
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
        <Boolean
            label="CopyrightAgreement"
            v-model="value.copyrightAgreement"
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
        <Author
            offline
            label="Author"
            v-model="value.author"
            :editMode="editMode"
            @change="change"
        />
        <PublicationStatus
            offline
            label="PublicationStatus"
            v-model="value.publicationStatus"
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
    name: 'Work',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "works",
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
