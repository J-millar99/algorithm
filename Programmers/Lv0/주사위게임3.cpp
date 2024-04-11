#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(int a, int b, int c, int d) {
    vector<int> diceMap(7, 0);
    vector<int> dupMap(5, 0);

    diceMap[a] += 1;
    diceMap[b] += 1;
    diceMap[c] += 1;
    diceMap[d] += 1;

    for (int i = 1; i < 7; i++)
        if (diceMap[i] != 0)
            dupMap[diceMap[i]] += 1;

    if (dupMap[4] == 1) // 모든 주사위가 같음
        return 1111 * a;
    else if (dupMap[3] == 1) {// 3개가 같고 다른 하나가 다름
        int n1 = distance(diceMap.begin(), find(diceMap.begin(), diceMap.end(), 3));
        int n2 = distance(diceMap.begin(), find(diceMap.begin(), diceMap.end(), 1));
        return (10 * n1 + n2) * (10 * n1 + n2);
    }
    else if (dupMap[2] == 2) { // 2개 끼리 같음
        int n1 = distance(diceMap.begin(), find(diceMap.begin(), diceMap.end(), 2));
        int n2 = distance(find(diceMap.rbegin(), diceMap.rend(), 2), diceMap.rend() - 1);
        return (n1 + n2) * (abs(n1 - n2));
    }
    else if (dupMap[2] == 1) { // 2개같고 하나가 다름
        int n1 = distance(diceMap.begin(), find(diceMap.begin(), diceMap.end(), 1));
        int n2 = distance(find(diceMap.rbegin(), diceMap.rend(), 1), diceMap.rend() - 1);
        return n1 * n2;
    }
    else if (dupMap[1] == 4) { // 모든 주사위가 다름
        return distance(diceMap.begin(), find(diceMap.begin(), diceMap.end(), 1)); // 1을 갖는 가장 먼저 발견한 인덱스 = 최솟값
    }
    return 0;
}