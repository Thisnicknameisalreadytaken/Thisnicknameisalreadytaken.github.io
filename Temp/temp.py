def rgb(radio):
    start=(18,194,233)
    mid=(196,113,237)
    end=(246,79,89)
    if radio<=4:
        r=int(start[0]+(mid[0]-start[0])*((radio-1)/1.5))
        g=int(start[1]+(mid[1]-start[1])*((radio-1)/1.5))
        b=int(start[2]+(mid[2]-start[2])*((radio-1)/1.5))
    else:
        r=int(mid[0]+(end[0]-mid[0])*((radio-4.5)/3.5))
        g=int(mid[1]+(end[1]-mid[1])*((radio-4.5)/3.5))
        b=int(mid[2]+(end[2]-mid[2])*((radio-4.5)/3.5))
    return f"#{r:02X}{g:02X}{b:02X}"

print(rgb(1))
print(rgb(2))
print(rgb(3))
print(rgb(4))
print(rgb(5))
print(rgb(6))
print(rgb(7))
print(rgb(8))