#include <fstream>
#include <iostream>
#include <string>
#include <algorithm>
#include <cmath>
#include <cstdio>

using namespace std;
long facts = {
                1,
                1,
                2,
                6,
                24,
                120,
                720,
                5040,
                40320,
                362880,
                3628800,
                39916800,
                479001600,
                6227020800,
                87178291200,
                1307674368000,
                20922789888000,
                355687428096000,
                6402373705728000,
                121645100408832000,
                2432902008176640000};


int main() {
    ifstream cin("perm.in");
    int n;
    cin >> n;

    for (int i = 0; i < n; ++i) {
        string str;
        cin >> str;
        vector<char> chars;
        string::iterator it;
        for (it=str.begin(); it < str.end(); it++) {
            chars.push_back(*it);
        }
        sort(myvector.begin(), myvector.end());
        long num;
        cin >> num;
        for (int j = 0; j < 20; ++j) {
            if(num < facts[j])
                break;
        }
        
    }
}
