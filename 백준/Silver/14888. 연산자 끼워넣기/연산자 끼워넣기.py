import sys


def dfs(depth, result, add, sub, mul, div):
  global maximun, minimum

  if depth == N:
    maximun = max(result, maximun)
    minimum = min(result, minimum)
    return

  if add:
    dfs(depth + 1, result + num_arr[depth], add - 1, sub, mul, div)
  if sub:
    dfs(depth + 1, result - num_arr[depth], add, sub - 1, mul, div)
  if mul:
    dfs(depth + 1, result * num_arr[depth], add, sub, mul - 1, div)
  if div and result<0:
    dfs(depth + 1, -1*(abs(result)//num_arr[depth]), add, sub, mul, div - 1)
  elif div and result>=0:
    dfs(depth + 1, result // num_arr[depth], add, sub, mul, div - 1)


input = sys.stdin.readline
N = int(input())
num_arr = list(map(int, input().split()))
add, sub, mul, div = map(int, input().split())
maximun = -1e9
minimum = 1e9
result = 0

dfs(1, num_arr[0], add, sub, mul, div)
print(maximun)
print(minimum)