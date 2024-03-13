#include <iostream>
#include <string>

using namespace std;

int main(void) {
    string str;
    cin >> str;
    for (char &ch : str)
        islower(ch) ? ch = toupper(ch) : ch = tolower(ch);
    cout << str;
    return 0;
}