# GREwords

### 此项目为前后端分离项目，旨在提供公开的GRE单词背诵网站。

用户可以访问网站进行单词背诵，同时网站会收集用户信息进行统计，帮助用户更快记住单词

### 需求

1. 用户信息： 名字，单词背诵量，错最多的单词，个性化单词表
2. 单词背诵卡片（单词名，翻译，解释，例句），单词分组记忆，单词混合记忆

### 技术栈

#### 后端

- Spring
- Spring Boot
- Redis
- RabbitMQ
- Elasticsearch
- Kafka

#### 模块划分

```
com.grewords
│── controller        # 处理 API 请求
│── service           # 业务逻辑层
│── repository        # 数据访问层
│── model             # 数据模型
│── config            # 配置管理
│── queue             # 消息队列处理（RabbitMQ/Kafka）
│── search            # Elasticsearch 处理
│── utils             # 工具类
│── security          # 安全相关（JWT 认证）
```



#### 前端

- Vue/elementUI/js

#### 数据库

- mysql

![image-20250208151856752](D:\DesktopFiles\projects\ProjectGREwords\assets\image-20250208151856752.png)

#### 服务器

- Nginx



## 任务简析

2025/2/7： 完成MySQL + JPA 构建
