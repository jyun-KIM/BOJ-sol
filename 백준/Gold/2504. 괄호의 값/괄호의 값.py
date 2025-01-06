arr = input()
stack = []
tmp=1
answer=0

for i in range(len(arr)):
  if arr[i] =='(':
    stack.append(arr[i])
    tmp*=2
  elif arr[i] =='[':
    stack.append(arr[i])
    tmp*=3
  elif arr[i]==')':
    if len(stack)==0:
      answer=0
      break
    j=stack.pop()
    if arr[i-1]=='(':
      answer+=tmp
    tmp//=2
    if j!='(':
      answer=0
      tmp=1
      break
  elif arr[i]==']':
    if len(stack)==0:
      answer=0
      break
    j=stack.pop()
    if arr[i-1]=='[':
      answer+=tmp
    tmp//=3
    if j!='[':
      answer=0
      tmp=1
      break
  
if len(stack)!=0:
  answer=0
print(answer)
