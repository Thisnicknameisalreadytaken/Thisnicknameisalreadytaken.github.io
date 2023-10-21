## 变量和简单数据类型

### 1.变量

- 变量名只能包含字母,数字和下划线
- 变量名不能包含空格,但可使用下划线来分隔其中的单词
- 不要使用 Python 保留用于特殊用途的单词

### 2.字符串

用引号括起的都是字符串,其中的引号可以是单引号,也可以是双引号

`rstrip()`--确保字符串末尾没有空白

`lstrip()`--确保字符串开头没有空白

字符串只能与字符串进行拼接

```python
age = 20
# 报错TypeError: Can't convert 'int' object to str implicitly
message = "Happy " + age + "rd Birthday!"
message = "Happy " + str(age) + "rd Birthday!"  # 正确写法
```

### 3.数字

#### 1.整数

#### 2.浮点数

浮点数运算有误差

### 4.注释

注释用井号 `#`标识
