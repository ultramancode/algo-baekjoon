import sys
input = sys.stdin.readline

def main():
    N, M = map(int, input().split())
    r, c, d = map(int, input().split())
    room = []
    
    for _ in range(N):
        row = list(map(int, input().split()))
        room.append(row)

    # 북 동 남 서
    dr = [-1, 0, 1, 0]
    dc = [0, 1, 0, -1]

    clean_count = 0

    while True:
        # 현재 칸 청소
        if room[r][c] == 0:
            room[r][c] = 2
            clean_count += 1

        moved = False
        # 4방향
        for _ in range(4):
            d = (d - 1) % 4
            nr = r + dr[d]
            nc = c + dc[d]
            if room[nr][nc] == 0:
                r, c = nr, nc
                moved = True
                break
        if moved:
            continue

        # 네 방향 다 못 가면 후진
        back_d = (d + 2) % 4
        br = r + dr[back_d]
        bc = c + dc[back_d]
        # 벽이면
        if room[br][bc] == 1:
            break
        else:
            r, c = br, bc

    print(clean_count)


if __name__ == "__main__":
    main()
