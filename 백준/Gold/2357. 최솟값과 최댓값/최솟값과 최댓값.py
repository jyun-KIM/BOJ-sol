import sys
input = sys.stdin.readline

class SegmentMaxTree:
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
        self.tree[node] = max(self.init_tree(node * 2, start, mid), self.init_tree(node*2+1, mid+1, end))

        return self.tree[node]
        

    def query(self, node, start, end, left, right):
        if(left > end or right < start):  # 범위 밖 
            return 0
        if(left <= start and end <= right):
            return self.tree[node]

        mid = (start+end) // 2
        return max(self.query(node*2, start, mid, left, right), self.query(node*2+1, mid+1, end, left, right))

class SegmentMinTree:
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
        self.tree[node] = min(self.init_tree(node * 2, start, mid), self.init_tree(node*2+1, mid+1, end))

        return self.tree[node]
        

    def query(self, node, start, end, left, right):
        if(left > end or right < start):  # 범위 밖 
            return 1000000001
        if(left <= start and end <= right):
            return self.tree[node]

        mid = (start+end) // 2
        return min(self.query(node*2, start, mid, left, right), self.query(node*2+1, mid+1, end, left, right))
        

    

    

def main():
    n, m = map(int, input().split())

    # 초기 데이터 입력받기 
    arr = [int(input()) for _ in range(n)]

    stMax = SegmentMaxTree(n, arr)
    stMin = SegmentMinTree(n, arr)

    # 커맨드 처리 
    for _ in range(m):
        a,b = map(int, input().split())

        print(stMin.query(1,0, n-1, a-1, b-1), stMax.query(1, 0, n-1, a-1, b-1))

main()