#include <string>
#include <vector>
#include <numeric>
using namespace std;

long long solution(int balls, int share) {
    vector<int> num; // 분자 배열
    vector<int> den; // 분모 배열
    for (int i = balls; i > 1; i--)
        num.push_back(i);
    for (int j = balls - share; j > 1; j--)
        den.push_back(j);
    for (int k = share; k > 1; k--)
        den.push_back(k);

    __int128 front = 1;
    __int128 back = 1;
    for (unsigned long long n : num)
        front *= n;
    for (unsigned long long d : den)
        back *= d;
    return front / back;
}