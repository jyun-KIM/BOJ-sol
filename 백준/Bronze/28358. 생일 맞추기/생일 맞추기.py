T = int(input())
M = [0,31,29,31,30,31,30,31,31,30,31,30,31]

for t in range(T):
    TC = list(map(int,input().split()))
    if(TC[0]==1 and TC[1]==1 and TC[2]==1):
        print(TC.count(0)*TC.count(0))
    else:
        allowed_digits = [str(i) for i, v in enumerate(TC) if v == 0]
        count = 0
        
        for month in range(1, 13):
            for day in range(1, M[month] + 1):
                mm = str(month)
                dd = str(day)
                all_digits = list(mm + dd) 
                
                if all(d in allowed_digits for d in all_digits):
                    count += 1
        
        print(count)