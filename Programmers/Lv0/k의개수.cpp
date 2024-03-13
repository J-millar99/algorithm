#include <string>
#include <vector>
#include <map>
using namespace std;

int solution(int i, int j, int k) {
    map<char, int> my_map;
    for (int idx = 0; idx < 10; idx++)
        my_map[idx + '0'] = 0;
    for (;i <= j; i++) {
        string tmp = to_string(i);
        for (char ch : tmp)
            my_map[ch] += 1;
    }
    return my_map[k + '0'];
}