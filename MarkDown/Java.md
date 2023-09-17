# Java

## 一.精度转化

### 1.ASCLL 码运算

在 java 中进行 ASCLL 码运算需要进行强制类型转化

```java
char myChara = 'a';
// char myCharb = 'a' + 1; 错误,'a'和1进行运算后变为int型数据,不能赋给char型数据
char myCharc = (char) ('a' + 2); // 正确
```

## 二.传参

### 1.检查参数

先检查参数是否为 null,再检查参数是否合法(数组,字符串长度是否为 0),之后再进行功能实现
