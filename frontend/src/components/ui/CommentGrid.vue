<template>
    <v-container>
        <v-snackbar
            v-model="snackbar.status"
            :timeout="snackbar.timeout"
            :color="snackbar.color"
        >
            
            <v-btn style="margin-left: 80px;" text @click="snackbar.status = false">
                Close
            </v-btn>
        </v-snackbar>
        <div class="panel">
            <div class="gs-bundle-of-buttons" style="max-height:10vh;">
                <v-btn @click="addNewRow" @class="contrast-primary-text" small color="primary">
                    <v-icon small style="margin-left: -5px;">mdi-plus</v-icon>등록
                </v-btn>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="openEditDialog()" class="contrast-primary-text" small color="primary">
                    <v-icon small>mdi-pencil</v-icon>수정
                </v-btn>
                <v-btn style="margin-left: 5px;" @click="reportCommentDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('Reader')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>댓글 신고
                </v-btn>
                <v-dialog v-model="reportCommentDialog" width="500">
                    <ReportComment
                        @closeDialog="reportCommentDialog = false"
                        @reportComment="reportComment"
                    ></ReportComment>
                </v-dialog>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="editCommentDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('Reader')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>댓글 수정
                </v-btn>
                <v-dialog v-model="editCommentDialog" width="500">
                    <EditComment
                        @closeDialog="editCommentDialog = false"
                        @editComment="editComment"
                    ></EditComment>
                </v-dialog>
                <v-btn style="margin-left: 5px;" @click="writeCommentDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('Reader')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>댓글 작성
                </v-btn>
                <v-dialog v-model="writeCommentDialog" width="500">
                    <WriteComment
                        @closeDialog="writeCommentDialog = false"
                        @writeComment="writeComment"
                    ></WriteComment>
                </v-dialog>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="deleteCommentDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('Reader')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>댓글 삭제
                </v-btn>
                <v-dialog v-model="deleteCommentDialog" width="500">
                    <DeleteComment
                        @closeDialog="deleteCommentDialog = false"
                        @deleteComment="deleteComment"
                    ></DeleteComment>
                </v-dialog>
            </div>
            <CommentDetails @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></CommentDetails>
            <CommentList @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></CommentList>
            <MyCommentList @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></MyCommentList>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>Reader</th>
                        <th>Content</th>
                        <th>Status</th>
                        <th>CreatedAt</th>
                        <th>작품 ID</th>
                        <th>작품</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" 
                            @click="changeSelectedRow(val)"
                            :key="val"  
                            :style="val === selectedRow ? 'background-color: rgb(var(--v-theme-primary), 0.2) !important;':''"
                        >
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="Reader">{{ val.reader }}</td>
                            <td class="whitespace-nowrap" label="Content">{{ val.content }}</td>
                            <td class="whitespace-nowrap" label="Status">{{ val.status }}</td>
                            <td class="whitespace-nowrap" label="CreatedAt">{{ val.createdAt }}</td>
                            <td class="whitespace-nowrap" label="작품">
                                <WorkId :editMode="editMode" v-model="val.workId"></WorkId>
                            </td>
                            <v-row class="ma-0 pa-4 align-center">
                                <v-spacer></v-spacer>
                                <Icon style="cursor: pointer;" icon="mi:delete" @click="deleteRow(val)" />
                            </v-row>
                        </tr>
                    </tbody>
                </v-table>
            </div>
        </div>
        <v-col>
            <v-dialog
                v-model="openDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0 pa-4"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">Comment 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <Comment :offline="offline"
                            :isNew="!value.idx"
                            :editMode="true"
                            :inList="false"
                            v-model="newValue"
                            @add="append"
                        />
                    </v-card-text>
                </v-card>
            </v-dialog>
            <v-dialog
                v-model="editDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0 pa-4"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">Comment 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <Number label="CommentId" v-model="selectedRow.commentId" :editMode="true"/>
                            <String label="Content" v-model="selectedRow.content" :editMode="true"/>
                            <Date label="CreatedAt" v-model="selectedRow.createdAt" :editMode="true"/>
                            <Reader offline label="Reader" v-model="selectedRow.reader" :editMode="true"/>
                            <CommentStatus offline label="Status" v-model="selectedRow.status" :editMode="true"/>
                            <WorkId offline label="작품 ID" v-model="selectedRow.workId" :editMode="true"/>
                            <v-divider class="border-opacity-100 my-divider"></v-divider>
                            <v-layout row justify-end>
                                <v-btn
                                    width="64px"
                                    color="primary"
                                    @click="save"
                                >
                                    수정
                                </v-btn>
                            </v-layout>
                        </div>
                    </v-card-text>
                </v-card>
            </v-dialog>
        </v-col>
    </v-container>
</template>

<script>
import { ref } from 'vue';
import { useTheme } from 'vuetify';
import BaseGrid from '../base-ui/BaseGrid.vue'


export default {
    name: 'commentGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'comments',
        reportCommentDialog: false,
        editCommentDialog: false,
        writeCommentDialog: false,
        deleteCommentDialog: false,
    }),
    watch: {
    },
    methods:{
        async reportComment(params){
            try{
                var path = "reportComment".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','ReportComment 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.reportCommentDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async editComment(params){
            try{
                var path = "editComment".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','EditComment 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.editCommentDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async writeComment(params){
            try{
                var path = "writeComment".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','WriteComment 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.writeCommentDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async deleteComment(params){
            try{
                var path = "deleteComment".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','DeleteComment 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.deleteCommentDialog = false
            }catch(e){
                console.log(e)
            }
        },
    }
}

</script>