<script setup>
import { ref } from 'vue';
import { onMounted } from 'vue';
import { getWordList } from '@/api/wordList';

const wordList = ref([]);

const fetchData = async () => {
    try {
        const response = await getWordList();
        wordList.value = response;
        console.log(wordList.value);
    } catch (error) {
        console.log(error);
    }
};

onMounted(fetchData);
</script>

<template>
    <div class="wordList" >
    <n-grid cols="1" x-gap="12" y-gap="12">
        <n-gi v-for="wordL in wordList" :key="wordL.name">
        <n-card size="huge" hoverable :segmented="{ content: true, footer: 'soft' }" style="width: 100%;">
            <div class="cardInside">
                    {{ wordL.name }}
                    <n-button type="primary" size="small">Check</n-button>
            </div>
        </n-card>
        </n-gi>
    </n-grid>
        
    </div>
</template>

<style scoped>
.wordList {
    display: flex;
    padding:20px;
    height:100%;
    width:100%;
}

.cardInside {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    align-items: center;
    width: 100%;
}

.wordList-space {
    width: 100%;
}
</style>