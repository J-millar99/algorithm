#include <string>
#include <vector>
using namespace std;
#define 십만 100000
#define 삼십만 300000
#define 오십만 500000

int solution(int price) {
    if (price >= 오십만)
        price *= 0.8;
    else if (price >= 삼십만)
        price *= 0.9;
    else if (price >= 십만)
        price *= 0.95;
    return price;
}
// 삼항 연산자 겹치기
int solution(int price) {
    return price >= 500000 ? 0.8 * price : 
            price >= 300000 ? 0.9 * price :
            price >= 100000 ? 0.95 * price :
            price;
}