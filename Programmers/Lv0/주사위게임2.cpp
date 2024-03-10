#include <string>
#include <vector>
#include <cmath>
#include <set>
using namespace std;

int solution(int a, int b, int c) {
    if (a == b && b == c)
        return (3 * a) * (3 * pow(a, 2)) * (3 * pow(a, 3));
    else if (a != b && b != c && a != c)
        return a + b + c;
    else
        return (a + b + c) * (pow(a, 2) + pow(b, 2) + pow(c, 2));
}

//  중복을 허용하지 않는 set을 이용한 방법
int solution(int a, int b, int c)
{
    set<int> s{a, b, c};
    if(s.size() == 3)
        return a + b + c;
    if(s.size() == 2)
        return (a + b + c) * (pow(a, 2) + pow(b, 2) + pow(c, 2));
    if(s.size() == 1)
        return (a + b + c) * (pow(a, 2) + pow(b, 2) + pow(c, 2)) * (pow(a, 3) + pow(b, 3) + pow(c, 3));

}