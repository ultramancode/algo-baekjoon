class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        //인덱스를 바탕으로 시간 매칭
        int attackIndex = 0;
        int hp = health;
        int success = 0;
        for (int i = 1; i <= attacks[attacks.length - 1][0]; i++) {
            if (i == attacks[attackIndex][0]) {
                hp -= attacks[attackIndex][1];
                success = 0;
                attackIndex++;
                
                if (hp <= 0) {
                    return -1;
                }
            } else {
                hp += bandage[1];
                success += 1;
                if (success == bandage[0]) {
                    hp += bandage[2];
                    success = 0;
                }
                
                if (hp > health) {
                    hp = health;
                }
            }
        }
        return hp <= 0 ? -1 : hp;
    }
}
