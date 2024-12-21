str = input()
reverse_str=str[::-1]
flag=1

for i in range(len(str)):
    if str[i]!=reverse_str[i]:
        flag=0

if flag==0:
    print("0")
else:
    print("1")