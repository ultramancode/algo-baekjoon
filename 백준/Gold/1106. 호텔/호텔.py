import sys
def main():
    input = sys.stdin.readline
    C, N = map(int, input().split())

    cities =[]

    for _ in range(N):
        cost, customer = map(int, input().split())
        cities.append((cost, customer))

    max_customer = C+100
    dp = [float('inf')] * (max_customer + 1)
    dp[0] = 0

    for cost, customer in cities:
        for i in range(customer, max_customer+1):
            dp[i] = min(dp[i], dp[i-customer]+cost)


    print(min(dp[C:]))


if __name__ == "__main__":
    main()



