import sys
input = sys.stdin.readline

class MinTree:
    def __init__(self, n, array):
        self.n = n
        self.array = array
        self.tree = [0] * (4*n)
        self.init_tree(1,0,n-1)

    def init_tree(self, node, start, end):
        if(start==end):
            self.tree[node] = (self.array[start], start+1) # 문제 조건: 수열의 인덱스는 1부터 시작 
            return self.tree[node]
        
        mid = (start+end) // 2

        left_val = self.init_tree(node*2, start, mid)
        right_val = self.init_tree(node*2+1, mid+1, end)

        self.tree[node] = (min(left_val, right_val))
        
        return self.tree[node]

    def update(self, node, start, end, idx, val):
        if(idx<start or idx>end):
            return self.tree[node]
            
        if(start==end):
            self.tree[node] = (val, idx+1)
            return self.tree[node]

        mid = (start+end) // 2

        left_val = self.update(node*2, start, mid, idx, val)
        right_val = self.update(node*2+1, mid+1, end, idx, val)

        self.tree[node] = min(left_val, right_val)
        return self.tree[node]

    def query(self, node, start, end, i, j):
        if(i>end or j<start):
            return (1000000001,0)

        if(i<=start and end<=j):
            return self.tree[node]

        mid = (start+end) // 2
        return min(self.query(node*2, start, mid, i, j), self.query(node*2+1, mid+1, end, i, j))
        

def main():
    n = int(input())
    arr = [int(x) for x in input().split()]
    m = int(input())

    st = MinTree(n, arr)

    for _ in range(m):
        a,b,c = map(int, input().split())

        if(a==1):
            st.update(1,0,n-1,b-1,c)
        if(a==2):
            print(st.query(1,0,n-1,b-1,c-1)[1])

main()
        