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
    <h1>Hello World</h1>
</template>