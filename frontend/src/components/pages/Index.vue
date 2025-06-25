<template>
  <v-container fluid>
    <v-row>
      <v-card
          v-for="(card, index) in cards"
          :key="index"
          class="mx-auto"
          style="height:300px; width:300px; margin-bottom:20px;"
          outlined
      >
        <v-list-item>
          <v-icon style="margin-top: 30%; margin-left: 37.5%;" color="primary" size="64">mdi-apps</v-icon>
        </v-list-item>
        <v-card-actions>
          <v-btn
              class="mx-auto"
              outlined
              rounded
              :to="card.link"
              style="font-weight:500; font-size:20px; border:solid 2px; max-width:250px; overflow:hidden; margin-top: 10%;"
          >
              {{ card.text }}
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: 'Index',
  data: () => ({
    cards: [
      {
          text: "작품",
          link: "/works",
      },
      {
          text: "작품변경이력",
          link: "/workHistories",
      },
      {
          text: "작품 통계",
          link: "/workStatistics",
      },
      {
          text: "작품 목록",
          link: "/workLists",
      },
      {
          text: "작품 상세",
          link: "/workDetails",
      },
      {
          text: "작품 이력 상세",
          link: "/workHistoryDetails",
      },
      {
          text: "작품 이력 목록",
          link: "/workHistoryLists",
      },
      {
          text: "포인트",
          link: "/points",
      },
      {
          text: "댓글",
          link: "/comments",
      },
      {
          text: "포인트 충전 내역",
          link: "/pointHistories",
      },
      {
          text: "포인트 잔액 조회",
          link: "/pointBalances",
      },
      {
          text: "댓글 상세",
          link: "/commentDetails",
      },
      {
          text: "댓글 목록",
          link: "/commentLists",
      },
      {
          text: "내가 작성한 댓글 목록",
          link: "/myCommentLists",
      },
      {
          text: "공지사항",
          link: "/announcements",
      },
      {
          text: "베스트셀러 및 선정이력",
          link: "/bestsellerWithHistories",
      },
      {
          text: "제재 및 사용자",
          link: "/sanctionWithUsers",
      },
      {
          text: "공지 목록",
          link: "/announcementLists",
      },
      {
          text: "공지 상세",
          link: "/announcementDetails",
      },
      {
          text: "베스트셀러 이력 상세",
          link: "/bestsellerHistoryDetails",
      },
      {
          text: "베스트셀러 이력 목록",
          link: "/bestsellerHistoryLists",
      },
      {
          text: "내 제재 현황",
          link: "/mySanctionStatuses",
      },
      {
          text: "제재 상세 정보",
          link: "/sanctionDetails",
      },
      {
          text: "제재 이력 목록",
          link: "/sanctionHistories",
      },
    ],
  }),
};
</script>
