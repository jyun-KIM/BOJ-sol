arr = input()
stack = []
tmp=1
answer=0

for i in range(len(arr)):
  if arr[i] =='(':
    stack.append(arr[i])
    tmp*=2
    # print(tmp)
  elif arr[i] =='[':
    stack.append(arr[i])
    tmp*=3
    # print(tmp)
  elif arr[i]==')':
    if len(stack)==0:
      answer=0
      break
    j=stack.pop()
    # if len(stack)==0:
    #   answer+=tmp
    #   tmp=1 #확인 
    if arr[i-1]=='(':
      answer+=tmp
      # print("answer1:", answer)
    tmp//=2
    # print(tmp)
    if j!='(':
      answer=0
      tmp=1
      break
    # tmp//=2
  elif arr[i]==']':
    if len(stack)==0:
      answer=0
      break
    j=stack.pop()
    # if len(stack)==0:
    #   answer+=tmp
    #   tmp=1
    if arr[i-1]=='[':
      answer+=tmp
      # print("answer2: ",answer)
    tmp//=3
    # print(tmp)
    if j!='[':
      answer=0
      tmp=1
      break
    # tmp//=3
  
if len(stack)!=0:
  answer=0
print(answer)