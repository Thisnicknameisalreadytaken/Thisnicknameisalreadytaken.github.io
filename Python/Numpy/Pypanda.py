import numpy as np
import pandas as pd

# ser_obj = pd.Series([1, 2, 3, 4, 5])
# print(ser_obj)

# ser_obj2 = pd.Series([1, 2, 3, 4, 5], index=['a', 'b', 'c', 'd', 'e'])
# print(ser_obj2)

# year_data = {'2010': [10, 20, 30], '2011': [40, 50, 60], '2012': [70, 80, 90]}
# ser_obj3 = pd.Series(year_data)
# print(ser_obj3)

#运算时只对内容进行运算 不对index运算
# ser_obj4 = pd.Series([1, 2, 3, 4, 5], index=['a', 'b', 'c', 'd', 'e'])
# ser_obj4 *= 2
# print(ser_obj4)

# ser_obj5 = pd.Series([1, 2, 3, 4, 5])
# ser_obj5[5] = 6
# del ser_obj5[0]
# print(ser_obj5)

# ser_obj6 = pd.DataFrame(data = [1,2,3], index = ['a', 'b', 'c']).index
# print(ser_obj6)

# ser_obj7 = pd.DataFrame({'years': [2010, 2011, 2012], 'population': [1.2, 1.3, 1.4]})
# print(ser_obj7)

# ser_obj8 = pd.Series([1, 2, 3, 4, 5], index=['a', 'b', 'c', 'd', 'e'])
# ser_obj8.index = ['x', 'y', 'z', 'a', 'b']
# print(ser_obj8)

ser_obj9 = pd.Series([1, 2, 3, 4, 5], index=['a', 'b', 'c', 'd', 'e'])
print(ser_obj9)
ser_obj9 = ser_obj9[:2]
print(ser_obj9)