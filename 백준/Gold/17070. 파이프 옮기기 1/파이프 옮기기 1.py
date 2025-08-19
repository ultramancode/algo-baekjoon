import sys
input = sys.stdin.readline
def main():
    N = int(input())
    # 1베이스로 할거니까 더미행 + 더미열.. 고려하고 리스트컴프리헨션
    house = [[0] * (N+1)] + [[0] + list(map(int, input().split())) for _ in range(N)]

    #행 ,열, 방향 해야하니 3차원 배열
    #방향은 1: 가로 , 2: 세로, 3: 대각선
    dp = [[[0]*3 for _ in range(N+1)] for _ in range(N+1)]
    
    #끝점, 방향(0아닌 1베이스.. n+1로 만들었으니)
    dp[1][2][0] = 1

    for r in range(1, N+1):
        for c in range(1, N+1):
            # 벽이니 파이프 끝점 불가
            if house[r][c] == 1:
                continue

            #가로 끝점 r,c 오려면 이전 끝점이 r,c-1 방향은 가로, 대각선이고
            #이전 끝점은 비어있어야 함(새 기둥의 시작점)
            #1based.. c-1이 1이상이어야 기둥 시작점이 배열 안에 있는거니
            #끝점 자체는 위에서 1인지 체크하니 제외
            if c-1 >= 1 and house[r][c-1] == 0:
                dp[r][c][0] += dp[r][c-1][0] + dp[r][c-1][2]

            #세로 (세로, 대각선)
            if r-1 >=1 and house[r-1][c] == 0:
                dp[r][c][1] += dp[r-1][c][1] + dp[r-1][c][2]
            #대각선(가로, 세로, 대각선)
            if r-1 >=1 and c-1 >=1:
                if house[r-1][c-1] == 0 and house[r-1][c] == 0 and house[r][c-1]==0:
                    dp[r][c][2] += dp[r-1][c-1][0] + dp[r-1][c-1][1]+dp[r-1][c-1][2]
            
    # 해당 열,행의 3방향 좌표 dp 값 더하기
    print(sum(dp[N][N]))

if __name__ == "__main__":
    main()





