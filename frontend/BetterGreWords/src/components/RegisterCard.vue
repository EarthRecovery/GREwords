<script setup>
import { ref } from 'vue';
import { useMessage } from 'naive-ui';
import { registerUser } from '@/api/register'; 
import router from '@/router';

const message = useMessage();
const username = ref('');
const password = ref('');
const email = ref('');

const emailPattern = /^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/;
const passwordPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,20}$/;


const handleRegister = async() => {
  if (!username.value || !password.value) {
    message.error('Please enter both username and password');
    return;
  }
  if (!emailPattern.test(email.value)) {
    message.error('Invalid email format');
    return;
  }

  if (!passwordPattern.test(password.value)) {
    message.error('Password must be 8-20 characters long and include at least 1 uppercase letter, 1 lowercase letter, 1 number, and 1 special character');
    return;
  }

  try {
    const response = await registerUser({
      name: username.value,
      password: password.value,
      email: email.value
    });
    if(response.success){
      localStorage.setItem('token', response.token);
      localStorage.setItem('user', JSON.stringify(response.user));
      localStorage.setItem('isLoggedIn', 'true');
      message.success(`Registered successfully as ${username.value}`);
      router.push('/main');
    }else {
    throw new Error(response.message || 'Registration failed');
    }
    
  } catch (error) {
    message.error(error.message || 'Registration failed');
  }
};
</script>

<template>
  <div class="RegisterCard">
    <n-card title="Register" size="huge" hoverable :segmented="{ content: true, footer: 'soft' }">
      <n-space vertical :size="20">
        <n-input v-model:value="username" placeholder="Enter username" clearable />
        <n-input v-model:value="password" type="password" placeholder="Enter password" clearable />
        <n-input v-model:value="email" placeholder="Enter email" clearable ></n-input>
        <n-button type="primary" block @click="handleRegister">Register</n-button>
      </n-space>
    </n-card>
  </div>
</template>

<style>
.RegisterCard {
  /* max-width: 300px; */
  margin: auto;
  padding: 20px;
}
</style>
