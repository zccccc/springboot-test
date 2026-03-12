# springboot-test

基于 SpringBoot 3.2 的用户 CRUD 项目。

## 技术栈

- JDK 17
- Spring Boot 3.2
- Spring Web
- MyBatis-Plus 3.5.5
- MySQL 8.0
- Lombok

## 项目结构

```
src/main/java/com/example/usercrud/
├── UserCrudApplication.java        # 启动类
├── common/
│   └── Result.java                 # 统一返回结果
├── config/
│   └── MyBatisPlusConfig.java      # MyBatis-Plus 配置（分页插件）
├── controller/
│   └── UserController.java         # 用户 CRUD 接口
├── entity/
│   └── User.java                   # 用户实体类
├── exception/
│   └── GlobalExceptionHandler.java # 全局异常处理
├── mapper/
│   └── UserMapper.java             # 用户 Mapper 接口
└── service/
    ├── UserService.java            # 用户 Service 接口
    └── impl/
        └── UserServiceImpl.java    # 用户 Service 实现

src/main/resources/
├── application.yml                 # 应用配置文件
└── mybatis-config.xml              # MyBatis 配置文件
```

## 启动说明

### 1. 环境准备

- JDK 17+
- Maven 3.6+
- MySQL 8.0+

### 2. 创建数据库

登录 MySQL，执行以下 SQL 创建数据库和数据表：

```sql
CREATE DATABASE IF NOT EXISTS usercrud DEFAULT CHARACTER SET utf8mb4;

USE usercrud;

CREATE TABLE IF NOT EXISTS `user` (
  `id`          BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `username`    VARCHAR(50)  NOT NULL                COMMENT '用户名',
  `password`    VARCHAR(100) NOT NULL                COMMENT '密码',
  `create_time` DATETIME     DEFAULT NOW()           COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';
```

### 3. 修改配置文件

编辑 `src/main/resources/application.yml`，将数据库连接信息替换为实际值：

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/usercrud?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&useSSL=false
    username: root          # TODO: 替换为实际 MySQL 用户名
    password: your_password # TODO: 替换为实际 MySQL 密码
```

### 4. 编译运行

```bash
# 进入项目根目录
cd springboot-test

# 使用 Maven 编译并启动
mvn spring-boot:run

# 或先打包再运行
mvn clean package -DskipTests
java -jar target/usercrud-0.0.1-SNAPSHOT.jar
```

启动成功后，服务监听在 `http://localhost:8080`。

## API 接口

| 方法   | 路径              | 说明             |
|--------|-------------------|------------------|
| GET    | /api/users        | 分页查询用户列表 |
| GET    | /api/users/{id}   | 根据 ID 查询用户 |
| POST   | /api/users        | 新增用户         |
| PUT    | /api/users/{id}   | 更新用户         |
| DELETE | /api/users/{id}   | 删除用户         |

### 请求示例

**分页查询**
```
GET /api/users?pageNum=1&pageSize=10
```

**新增用户**
```json
POST /api/users
Content-Type: application/json

{
  "username": "zhangsan",
  "password": "123456"
}
```

**更新用户**
```json
PUT /api/users/1
Content-Type: application/json

{
  "username": "lisi",
  "password": "654321"
}
```

### 统一返回格式

```json
{
  "code": 200,
  "message": "success",
  "data": { ... }
}
```