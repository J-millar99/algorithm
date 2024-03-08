#include <string>
#include <vector>
#include <cmath>
using namespace std;

int solution(vector<int> num_list) {
    int sumPow = 0;
    int mulply = 1;
    for (int num : num_list)
    {
        sumPow += num;
        mulply *= num;
    }
    return mulply < pow(sumPow, 2) ? 1 : 0;
}