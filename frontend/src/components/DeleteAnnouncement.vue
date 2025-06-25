<template>

    <v-card outlined>
        <v-card-title>
            DeleteAnnouncement
        </v-card-title>

        <v-card-text>
            <Number label="AnnouncementId" v-model="value.announcementId" :editMode="editMode"/>
            <Admin offline label="DeletedBy" v-model="value.deletedBy" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="deleteAnnouncement"
            >
                DeleteAnnouncement
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
    name: 'DeleteAnnouncementCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.announcementId = 0;
        this.value.deletedBy = {};
    },
    watch: {
    },
    methods: {
        deleteAnnouncement() {
            this.$emit('deleteAnnouncement', this.value);
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

