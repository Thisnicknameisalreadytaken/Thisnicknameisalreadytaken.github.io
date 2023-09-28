bool canPlaceFlowers(int *flowerbed, int flowerbedSize, int n)
{
    if (n == 0)
        return true;
    int res = 0;
    if (flowerbedSize == 1)
        return n == 1 && flowerbed[0] == 0;
    else if (flowerbedSize == 2)
        return n == 1 && flowerbed[0] + flowerbed[1] == 0;
    if (flowerbed[0] + flowerbed[1] == 0)
    {
        ++res;
        flowerbed[0] = 1;
    }
    if (flowerbed[flowerbedSize - 1] + flowerbed[flowerbedSize - 2] == 0)
    {
        ++res;
        flowerbed[flowerbedSize - 1] = 1;
    }
    for (int i = 1; i < flowerbedSize - 1; ++i)
    {
        if (flowerbed[i - 1] + flowerbed[i] + flowerbed[i + 1] == 0)
        {
            flowerbed[i] = 1;
            ++res;
        }
    }
    return res >= n;
}