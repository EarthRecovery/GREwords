<script setup>
import RegisterCard from '@/components/RegisterCard.vue';
import { NMessageProvider } from 'naive-ui';
</script>

<template>
    <div class="Register-view">
      <n-message-provider>
        <n-grid cols="1 s:1 m:1 l:3" responsive="screen" x-gap="12px" y-gap="12px" class="Register-grid">
          <n-grid-item span="1 l:1" />
          <n-grid-item span="1 l:1" class="center-content">
            <RegisterCard />
          </n-grid-item>
          <n-grid-item span="1 l:1" />
        </n-grid>
      </n-message-provider>
    </div>
</template>

<style>
.Register-view {
  width: 100vw;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: #f4f4f4;
}

.Register-grid {
  height: 100vh;
  display: flex;
  align-items: center;
  justify-content: center;
}

.center-content {
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>