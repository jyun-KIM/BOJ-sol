def solution(info):
  total_grade=0
  total_credits=0
  grade_dict={"A+":4.5,"A0":4.0,"B+":3.5,"B0":3.0,"C+":2.5,"C0":2.0,"D+":1.5,"D0":1.0,"F":0.0}
  for data in info:
    credits=float(data[1])
    grade=data[2]
    if grade!='P':
      total_credits+=credits
      total_grade+=credits*grade_dict[grade]
    else:
      continue
  # print(total_grade,total_subject_num)
  return total_grade/total_credits

info=[]
for _ in range(20):
  info.append(list(map(str, input().split())))
answer=solution(info)
print('%6f'%answer)