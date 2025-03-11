<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();
const menuOptions = ref([
  { label: 'User', key: '/main/user' },
  { label: 'Favourite Table', key: '/main/favourite-table' },
  { label: 'Word List', key: '/main/word-list' },
  { label: 'User Word List', key: '/main/user-word-list' }
]);

const handleMenuSelect = (key) => {
  router.push(key);
};
</script>

<template>
  <n-layout has-sider>
    <n-layout-sider width="240px" bordered>
      <n-menu :options="menuOptions" @update:value="handleMenuSelect" />
    </n-layout-sider>
    <n-layout-content style="width:100%">
        <router-view></router-view> 
    </n-layout-content>
  </n-layout>
</template>

<style scoped>
.n-layout {
  display: flex;
  height: 100vh;
}
</style>