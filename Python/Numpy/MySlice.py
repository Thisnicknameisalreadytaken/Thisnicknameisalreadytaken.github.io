import numpy as np

#一维数组切片
# a = np.arange(10)
# print(a[3])
# a = a[2:5]
# print(a)

#二维数组切片
# a=np.array([[1,2,3], [4,5,6]])
# print(a[1])
# print(a[1,1])
# print(a[0:1,0:1])

#花式索引
# a=np.empty((4,4))
# for i in range(4):
#     a[i]=np.arange(i,i+4)
# print(a[[0,2]])
# print(a[0,2])
# print(a[[0,2],[0,2]])

#布尔索引
# a=np.array([[1,2,3], [4,5,6]])
# print(a[[False,True]])