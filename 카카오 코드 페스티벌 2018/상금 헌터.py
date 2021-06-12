import sys

first_price = [0, ]
second_price = [0, ]

f_p = [0, 500, 300, 200, 50, 30, 10]
s_p = [0, 512, 256, 128, 64, 32]


for i in range(1, 7):
    first_price = first_price + ([f_p[i]] * i)
    if i != 6:
        second_price = second_price + ([s_p[i]] * (2**(i-1)))

p = int(sys.stdin.readline().rstrip())

for i in range(p):
    t1, t2 = 0, 0
    a, b = map(int, sys.stdin.readline().rstrip().split())
    t1 = first_price[a] if a < len(first_price) else 0
    t2 = second_price[b] if b < len(second_price) else 0
    if t1 == 0 and t2 == 0:
        print(0)
    else:
        print(str(t1 + t2) + "0000")
    
