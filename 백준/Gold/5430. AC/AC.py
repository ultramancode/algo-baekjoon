import sys
from collections import deque

input = sys.stdin.readline

def parse_array(s: str) -> deque:
    if s == "[]":
        return deque()
    else:
        return deque(map(int, s[1:-1].split(",")))


def main():
    T = int(input())
    out = []

    for _ in range(T):
        p = input().strip()
        n = int(input())
        arr = parse_array(input().strip())

        isReverse = False
        isError = False

        for char in p:
            if char == 'R':
                isReverse = not isReverse
            elif char == 'D':
                if not arr:
                    isError = True
                    break
                if isReverse:
                    arr.pop()
                else:
                    arr.popleft()


        if isError:
            out.append("error")
        else:
            if isReverse:
                arr.reverse()
            out.append("["+",".join(map(str, arr))+"]")


    print("\n".join(out))

if __name__ == "__main__":
    main()
