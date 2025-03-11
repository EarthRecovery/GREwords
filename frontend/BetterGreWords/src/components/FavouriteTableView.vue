<script setup>
import { ref, computed, onMounted} from 'vue';
import { getFavouriteTable } from '@/api/favouriteTable'; 
import { useMessage} from 'naive-ui';

// 消息提示
// const message = useMessage();

// 搜索输入框
const searchText = ref('');
const items = ref([]);
var allItems = ref([]);

// 模拟数据
const Items = ref([
    { id: 1, wordName: 'Apple' },
    { id: 2, wordName: 'Orange' },
    { id: 3, wordName: 'Banana' },
    { id: 4, wordName: 'Grapes' },
    { id: 5, wordName: 'Peach' }
]);

// 加载数据
const fetchData = async () => {
    try {
    const response = await getFavouriteTable();
    if(response.status === 200){
      Items.value = response.data;
      allItems = ref([...Items.value]);
    }
    } catch (error) {
        console.log(error);
    }
};

const search = () => {
    if (!searchText.value.trim()) {
        Items.value = [...allItems.value];
        return;
    }
    Items.value = Items.value.filter(item =>
        item.wordName.toLowerCase().includes(searchText.value.toLowerCase())
    );
};

const sortAscending = () => {
    Items.value = [...Items.value].sort((a, b) => a.wordName.localeCompare(b.wordName));
};

const sortDescending = () => {
    Items.value = [...Items.value].sort((a, b) => b.wordName.localeCompare(a.wordName));
};

onMounted(fetchData);
</script>

<template>
    <div class="FavouriteTable"><div class="control">
        <n-space>
            <n-input v-model:value="searchText" placeholder="search word in favourite list" style="width: 200px;" />
            <n-button @click="search" type="primary">search</n-button>
            <n-button @click="sortAscending" type="success">Ascending</n-button>
            <n-button @click="sortDescending" type="warning">Descending</n-button>
        </n-space>
    </div>
    <div class="list">
        <n-grid cols="1" x-gap="12" y-gap="12">
            <n-gi v-for="item in Items" :key="item.id">
                <n-card>
                    <div class="card-content">
                        <span class="word">{{ item.wordName }}</span>
                        <span class="meaning">{{ item.chineseName }}</span>
                    </div>
                </n-card>
            </n-gi>
        </n-grid>
    </div>
    </div>
    
</template>

<style>
.FavouriteTable{
    max-width: 100%;
    padding: 20px;
}
.control{
    display: flex;
    text-align: center;
}
.list{
    margin-top: 20px;
}
.card-content {
    display: flex;
    justify-content: space-between; /* 左右对齐 */
    align-items: center;
}
</style>