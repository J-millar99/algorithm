#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int i = 1;
    while (1)
    {
        if (6 * i % n == 0)
            return i;
        else
            i++;
    }
}