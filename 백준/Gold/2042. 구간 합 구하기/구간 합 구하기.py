import sys
input = sys.stdin.readline

class SegmentTree:
    def __init__(self, n, array):
        self.n = n
        self.array = array
        self.tree = [0] * (4*n)
        self.init_tree(1,0,n-1)

    def init_tree(self, node, start, end):
        if(start==end):
                self.tree[node] = self.array[start]
                return self.tree[node]

        mid = (start+end) // 2
        self.tree[node] = self.init_tree(node * 2, start, mid) + self.init_tree(node*2+1, mid+1, end)

        return self.tree[node]

            
    def update(self, node, start, end, idx, val):
        if(idx<start or idx>end):
            return self.tree[node]
        elif(start == end):
            self.tree[node] = val
            return self.tree[node]
            
        mid = (start+end) // 2
        self.tree[node] = self.update(node*2, start, mid, idx, val) + self.update(node*2+1, mid+1, end, idx, val)
        return self.tree[node]
        

    def query(self, node, start, end, left, right):
        if(left > end or right < start):
            return 0
        if(left <= start and end <= right):
            return self.tree[node]

        mid = (start+end) // 2
        return self.query(node*2, start, mid, left, right) + self.query(node*2+1, mid+1, end, left, right)
        

    

    

def main():
    n,m,k = map(int, input().split())

    # 초기 데이터 입력받기 
    arr = [int(input()) for _ in range(n)]

    st = SegmentTree(n, arr)

    # 커맨드 처리 
    for _ in range(m+k):
        a,b,c = map(int, input().split())

        if(a==1):
            # b번째 수를  c로 바꿈
            st.update(1, 0, n-1, b-1, c)
        else:
            # 구간 합 
            print(st.query(1, 0, n-1, b-1, c-1))

if __name__ == "__main__":
    main()