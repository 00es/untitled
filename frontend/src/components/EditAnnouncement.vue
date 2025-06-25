<template>

    <v-card outlined>
        <v-card-title>
            EditAnnouncement
        </v-card-title>

        <v-card-text>
            <Number label="AnnouncementId" v-model="value.announcementId" :editMode="editMode"/>
            <String label="Title" v-model="value.title" :editMode="editMode"/>
            <String label="Content" v-model="value.content" :editMode="editMode"/>
            <Admin offline label="UpdatedBy" v-model="value.updatedBy" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="editAnnouncement"
            >
                EditAnnouncement
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
    name: 'EditAnnouncementCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.announcementId = 0;
        this.value.title = '';
        this.value.content = '';
        this.value.updatedBy = {};
    },
    watch: {
    },
    methods: {
        editAnnouncement() {
            this.$emit('editAnnouncement', this.value);
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

