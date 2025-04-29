sub = input().split("-")
first = sum(map(int,sub[0].split("+")))
answer=first

for i in sub[1:]:
    add=i.split("+")
    add=map(int,add)

    sumA = sum(add)
    answer-=sumA
    
print(answer)
    
    