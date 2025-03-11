import { createRouter, createWebHistory } from 'vue-router'
import LoginView from '@/views/LoginView.vue'
import FavouriteTableView from '@/components/FavouriteTableView.vue'
import UserView from '@/components/UserView.vue'
import WordListView from '@/components/WordListView.vue'
import UserWordListView from '@/components/UserWordListView.vue'
import MainPage from '@/views/MainPage.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'login',
      component: LoginView,
    },
    {
      path: '/main',
      component: MainPage,
      children: [
        { path: 'user', component: UserView },
        { path: 'favourite-table', component: FavouriteTableView },
        { path: 'word-list', component: WordListView },
        { path: 'user-word-list', component: UserWordListView }
      ]
    }
  ],
})

router.beforeEach((to, from, next) => {
  localStorage.setItem('isLoggedIn','true');
  localStorage.setItem('user','1');
  const isLoggedIn = localStorage.getItem('isLoggedIn') === 'true';
  if(!isLoggedIn && to.path === '/'){
    next();
  }
  if (to.path === '/' && isLoggedIn) {
    next('/main');
  }else if (!isLoggedIn) {
    next('/');
  } else {
    next();
  }
});


export default router
