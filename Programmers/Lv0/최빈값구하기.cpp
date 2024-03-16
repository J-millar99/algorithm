#include <string>
#include <vector>
#include <map>
using namespace std;

int solution(vector<int> array) {
    //  set, init
    int map[1000];
    for (int i = 0; i < 1000; i++)
        map[i] = 0;

    int max_index = 0;
    int max_value = 0;
    for (int num : array)
        map[num] += 1;
    for (int num : array) {
        if (max_value < map[num]) {
            max_value = map[num];
            max_index = num;
        }
    }
    for (int k = 0; k < 1000; k++) {
        if (k != max_index && map[k] == max_value)
            return -1;
    }
    return max_index;
}