#include <string>
#include <vector>

using namespace std;

int solution(int num, int k) {
    string sNum = to_string(num);
    string kNum = to_string(k);

    size_t found = sNum.find(kNum);
    if (found != string::npos)
        return found + 1;
    else
        return -1;
}