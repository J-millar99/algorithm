#include <iostream>

using namespace std;

int main(void) {
    int n;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j <= i; j++)
            cout << '*';
        cout << endl;
    }
    return 0;
}
// string 생성자로 문자열을 생성할 수 있다, 마치 파이썬에서 문자열에 곱셈연산이 가능한 것처럼 보인다
int main(void) {
    int n;
    cin >> n;

    for(int i = 1; i <= n; ++i)
    {
        cout << string(i,'*') << endl;
    }
    return 0;
}