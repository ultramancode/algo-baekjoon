import sys
input = sys.stdin.readline

def calculate_area(points : list[tuple[int, int]]) -> float:
    n: int = len(points)
    area :float = 0.0
    for i in range(n):
        j: int = (i + 1) % n
        area += points[i][0] * points[j][1]
        area -= points[j][0] * points[i][1]

    return abs(area)/2


def main():
    N = int(input())
    points = []
    for _ in range(N):
        x, y = map(int, input().split())
        points.append((x,y))
    
    area = calculate_area(points)
    print(f"{area:.1f}")

if __name__ == "__main__":
    main()
