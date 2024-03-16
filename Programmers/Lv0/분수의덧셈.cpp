#include <string>
#include <vector>
#include <numeric>
using namespace std;

vector<int> solution(int numer1, int denom1, int numer2, int denom2) {
    int denom = denom1 * denom2;
    numer1 *= denom2;
    numer2 *= denom1;
    int numer = numer1 + numer2;

    int _gcd = gcd(numer, denom);
    vector<int> answer;
    answer.push_back(numer/_gcd);
    answer.push_back(denom/_gcd);
    return answer;
}