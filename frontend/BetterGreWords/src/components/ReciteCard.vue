<script setup>
import { ref, onMounted } from 'vue';
import { get10RandomWords } from '@/api/recite';

const words = ref([]);  // 确保 words 是 ref
const currentIndex = ref(0);
const selectedIndex = ref(null);
const currentWord = ref(null);  // 这里先设为空，等数据加载后再赋值
const options = ref([]);
var name = "";

const selectOption = (index) => {
  selectedIndex.value = index;
};

const nextWord = () => {
  if (currentIndex.value < words.value.length - 1) {
    currentIndex.value++;
  } else {
    currentIndex.value = 0;
  }
  currentWord.value = words.value[currentIndex.value]; // 切换到下一个单词
  options.value = [currentWord.value.similarWord1Name, currentWord.value.similarWord2Name, currentWord.value.similarWord3Name, currentWord.value.similarWord4Name];

  selectedIndex.value = null;
};

const fetchData = async () => {
  try {
    const response = await get10RandomWords(1);
    if (response.status === 200) {
      words.value = response.data;
      if (words.value.length > 0) {
        currentWord.value = words.value[0]; 
        options.value = [currentWord.value.similarWord1Name, currentWord.value.similarWord2Name, currentWord.value.similarWord3Name, currentWord.value.similarWord4Name];
        name = currentWord.value.chineseName;
        console.log(name);
      }
    }
  } catch (error) {
    console.error("获取单词数据失败:", error);
  }
};

onMounted(fetchData);
</script>

<template>
    <div class="reciteCard">
    <n-card size="huge" hoverable :segmented="{ content: true, footer: 'soft' }">
      <div class="cardInside">
        <n-space vertical>
        <n-text class="meaning" depth="3" style="font-size: 20px; font-weight: bold;">{{ name }}</n-text>
        <n-grid cols="2" x-gap="10" y-gap="10"> 
          <!-- <n-grid-item v-for="(option, index) in currentWord.options" :key="index">
            <n-button
              :type="selectedIndex === index ? (option === currentWord.wordName ? 'success' : 'error') : 'default'"
              :disabled="selectedIndex !== null"
              block
              @click="selectOption(index)"
            >
              {{ option }}
            </n-button>
          </n-grid-item> -->
        </n-grid>
        </n-space>
        <n-button class="nextBtn" type="info" size="small" @click="nextWord">Next Word</n-button>
      </div>
    </n-card>
  </div>
</template>

<style>
    .reciteCard {
        width: 100%;
    }

    .cardInside {
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    .nextBtn {
        margin-top: 20px;
    }

    .meaning {
        text-align: center;
        display: flex;
        justify-content: center;
    }
</style>