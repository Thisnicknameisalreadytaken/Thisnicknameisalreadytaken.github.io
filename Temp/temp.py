from PIL import Image

# 打开图片
image = Image.open('D:\\Sun\\Download\\0.jpg')

# 获取图片宽度和高度
width, height = image.size

# 计算每份的宽度
segment_width = width // 13

# 遍历分割图片
for i in range(13):
    # 计算剪切区域的左上角和右下角坐标
    left = i * segment_width
    top = 0
    right = left + segment_width
    bottom = height

    # 剪切并保存每个部分的图片
    segment = image.crop((left, top, right, bottom))
    segment.save(f"segment_{i}.jpg")