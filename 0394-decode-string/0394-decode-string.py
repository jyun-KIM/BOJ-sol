class Solution:
    def decodeString(self, s: str) -> str:
        stack=[]

        for c in s:
            string=''
            num=''
            
            if c==']':
                curr = stack.pop()

                while curr!='[':
                    string = curr+string
                    curr = stack.pop()
                    
                while len(stack)!=0 and stack[-1].isdigit():
                    curr=stack.pop()
                    num = curr+num
                stack.append(string*int(num))
            else: stack.append(c)
            
        answer=''
        for x in stack:
            if x.isalpha():
                answer+=x
        return answer
