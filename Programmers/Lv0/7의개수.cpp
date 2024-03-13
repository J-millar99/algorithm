#include <string>
#include <vector>

using namespace std;

int solution(vector<int> array) {
    string str = "";
    int cnt = 0;
    for (int num : array)
        str += to_string(num);
    for (char ch : str)
        if (ch == '7')
            cnt++;
    return cnt;
}