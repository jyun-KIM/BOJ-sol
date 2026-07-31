class Solution:
    def isValid(self, s: str) -> bool:
        open_set = {"(", "{", "["}
        close_set = {")", "}", "]"}
        stack = []
        for x in s:
            if x in close_set:
                if len(stack)==0: return False
                y=stack.pop()
                if x==')' and y=='(' or x=='}' and y=='{' or x==']' and y=='[': continue
                else:
                    return False
            stack.append(x)
        if len(stack)==0: return True
        else: return False     