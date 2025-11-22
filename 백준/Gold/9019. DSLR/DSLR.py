import sys
from collections import deque

input = sys.stdin.readline

def bfs(before, after):
    visited = [False] * 10000
    prev = [-1] * 10000
    how = [''] * 10000

    q = deque()
    q.append(before)
    visited[before] = True

    while q and not visited[after]:
        number = q.popleft()

        # D 
        d_number = (2 * number) % 10000
        if not visited[d_number]:
            visited[d_number] = True
            prev[d_number] = number
            how[d_number] = 'D'
            q.append(d_number)  

        # S
        s_number = 9999 if number == 0 else number -1
        if not visited[s_number]:
            visited[s_number] = True
            prev[s_number] = number
            how[s_number] = 'S'
            q.append(s_number)
        
        # L
        l_number = (number % 1000) * 10 + (number // 1000)
        if not visited[l_number]:
            visited[l_number] = True
            prev[l_number] = number
            how[l_number] = 'L'
            q.append(l_number)
        
        # R
        r_number = (number//10) + (number%10) * 1000
        if not visited[r_number]: 
            visited[r_number] = True
            prev[r_number] = number
            how[r_number] = 'R'
            q.append(r_number)
        

    result_command = []
    cur = after
    while cur != before:
        result_command.append(how[cur])
        cur = prev[cur]
    

    result_command.reverse()
    return ''.join(result_command)

def main():
    N = int(input())
    answer = []
    for _ in range(N):
        before, after = map(int, input().split())
        answer.append(bfs(before, after))
    print('\n'.join(answer))

if __name__ == "__main__":
    main()