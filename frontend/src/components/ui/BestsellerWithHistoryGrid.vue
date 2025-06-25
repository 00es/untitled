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
                <v-btn style="margin-left: 5px;" @click="selectBestsellerDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('Admin')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>베스트셀러 선정
                </v-btn>
                <v-dialog v-model="selectBestsellerDialog" width="500">
                    <SelectBestseller
                        @closeDialog="selectBestsellerDialog = false"
                        @selectBestseller="selectBestseller"
                    ></SelectBestseller>
                </v-dialog>
                <v-btn style="margin-left: 5px;" @click="deselectBestsellerDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('Admin')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>베스트셀러 해제
                </v-btn>
                <v-dialog v-model="deselectBestsellerDialog" width="500">
                    <DeselectBestseller
                        @closeDialog="deselectBestsellerDialog = false"
                        @deselectBestseller="deselectBestseller"
                    ></DeselectBestseller>
                </v-dialog>
            </div>
            <BestsellerHistoryDetails @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></BestsellerHistoryDetails>
            <BestsellerHistoryList @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></BestsellerHistoryList>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>ActionType</th>
                        <th>Timestamp</th>
                        <th>Admin</th>
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
                            <td class="whitespace-nowrap" label="ActionType">{{ val.actionType }}</td>
                            <td class="whitespace-nowrap" label="Timestamp">{{ val.timestamp }}</td>
                            <td class="whitespace-nowrap" label="Admin">{{ val.admin }}</td>
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
                        <div style="color:white; font-size:17px; font-weight:700;">BestsellerWithHistory 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <BestsellerWithHistory :offline="offline"
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
                        <div style="color:white; font-size:17px; font-weight:700;">BestsellerWithHistory 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <Number label="HistoryId" v-model="selectedRow.historyId" :editMode="true"/>
                            <Date label="Timestamp" v-model="selectedRow.timestamp" :editMode="true"/>
                            <BestsellerActionType offline label="ActionType" v-model="selectedRow.actionType" :editMode="true"/>
                            <Admin offline label="Admin" v-model="selectedRow.admin" :editMode="true"/>
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
    name: 'bestsellerWithHistoryGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'bestsellerWithHistories',
        selectBestsellerDialog: false,
        deselectBestsellerDialog: false,
    }),
    watch: {
    },
    methods:{
        async selectBestseller(params){
            try{
                var path = "selectBestseller".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','SelectBestseller 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.selectBestsellerDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async deselectBestseller(params){
            try{
                var path = "deselectBestseller".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','DeselectBestseller 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.deselectBestsellerDialog = false
            }catch(e){
                console.log(e)
            }
        },
    }
}

</script>