import { createRouter, createWebHashHistory } from 'vue-router';

const router = createRouter({
  history: createWebHashHistory(),
  routes: [
    {
      path: '/',
      component: () => import('../components/pages/Index.vue'),
    },
    {
      path: '/works',
      component: () => import('../components/ui/WorkGrid.vue'),
    },
    {
      path: '/workHistories',
      component: () => import('../components/ui/WorkHistoryGrid.vue'),
    },
    {
      path: '/points',
      component: () => import('../components/ui/PointGrid.vue'),
    },
    {
      path: '/comments',
      component: () => import('../components/ui/CommentGrid.vue'),
    },
    {
      path: '/announcements',
      component: () => import('../components/ui/AnnouncementGrid.vue'),
    },
    {
      path: '/bestsellerWithHistories',
      component: () => import('../components/ui/BestsellerWithHistoryGrid.vue'),
    },
    {
      path: '/sanctionWithUsers',
      component: () => import('../components/ui/SanctionWithUserGrid.vue'),
    },
  ],
})

export default router;
