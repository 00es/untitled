<script setup>
import {
  VerticalNavLink,
  VerticalNavSectionTitle,
} from '@layouts'
</script>

<template>
    <ul>
        <VerticalNavSectionTitle :item="{ heading: '작가-작품 관리' }" />
        <VerticalNavLink
            :item="{
                title: '작품',
                to: '/works',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '작품변경이력',
                to: '/workHistories',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '작품 통계',
                to: '/workStatistics',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '작품 목록',
                to: '/workLists',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '작품 상세',
                to: '/workDetails',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '작품 이력 상세',
                to: '/workHistoryDetails',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '작품 이력 목록',
                to: '/workHistoryLists',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '리더-작품 소비' }" />
        <VerticalNavLink
            :item="{
                title: '포인트',
                to: '/points',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '댓글',
                to: '/comments',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '포인트 충전 내역',
                to: '/pointHistories',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '포인트 잔액 조회',
                to: '/pointBalances',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '댓글 상세',
                to: '/commentDetails',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '댓글 목록',
                to: '/commentLists',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '내가 작성한 댓글 목록',
                to: '/myCommentLists',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '관리자-서비스 운영' }" />
        <VerticalNavLink
            :item="{
                title: '공지사항',
                to: '/announcements',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '베스트셀러 및 선정이력',
                to: '/bestsellerWithHistories',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '제재 및 사용자',
                to: '/sanctionWithUsers',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '공지 목록',
                to: '/announcementLists',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '공지 상세',
                to: '/announcementDetails',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '베스트셀러 이력 상세',
                to: '/bestsellerHistoryDetails',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '베스트셀러 이력 목록',
                to: '/bestsellerHistoryLists',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '내 제재 현황',
                to: '/mySanctionStatuses',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '제재 상세 정보',
                to: '/sanctionDetails',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '제재 이력 목록',
                to: '/sanctionHistories',
            }"
        />
    </ul>
</template>
