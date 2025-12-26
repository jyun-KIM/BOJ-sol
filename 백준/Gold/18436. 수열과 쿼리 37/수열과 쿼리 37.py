import sys
input=sys.stdin.readline

class SegmentTree:
    def __init__(self, arr, n):
        self.arr = arr
        self.n = n
        self.tree = [0]*(4*n)
        self.init_tree(1,0,n-1)

    # 홀수 개수의 합 
    def init_tree(self, node, start, end):
        if(start == end):
            self.tree[node] = self.arr[start]
            return self.tree[node]

        mid = (start+end) // 2
        left = self.init_tree(node*2, start, mid)
        right = self.init_tree(node*2+1, mid+1, end)
        self.tree[node] = left+right
        return self.tree[node]

    def update(self, node, start, end, idx, val):
        if(start>idx or idx>end):
            return self.tree[node] # 범위에서 벗어난다면 합에 영향을 미치지 않음 
        if(start == end):
            self.tree[node] = val
            return self.tree[node]

        mid = (start+end) // 2
        left = self.update(node*2, start, mid, idx, val)
        right = self.update(node*2+1, mid+1, end, idx, val)
        self.tree[node] = left+right
        return self.tree[node]

    def query(self, node, start, end, left, right):
        if(start>right or left>end):
            return 0 # 범위에서 벗어난다면 합에 영향을 미치지 않음 
        if(left<=start and end<=right):
            return self.tree[node]

        mid = (start+end) // 2
        return self.query(node*2, start, mid, left, right)+self.query(node*2+1, mid+1, end, left, right)
    

def main():
    n = int(input())
    arr = [int(x) for x in input().split()]
    m = int(input())

    # TODO: arr의 숫자를 홀=1 짝=0으로 보내기 
    for i in range(n):
        arr[i] = arr[i]%2
        
    st = SegmentTree(arr, n)

    for _ in range(m):
        a,b,c = map(int, input().split())

        if a==1:
            c=c%2
            st.update(1,0,n-1,b-1,c)
        if a==2:
            even = st.query(1,0,n-1,b-1,c-1)
            section = c-b+1
            print(section-even)
        if a==3:
            print(st.query(1,0,n-1,b-1,c-1))
main()
        