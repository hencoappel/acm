#include <iostream>

using namespace std;


/*
 * http://acm.sgu.ru/problem.php?contest=0&problem=230
 * ACCEPTED
 *
 * Basically just spent a while to find the relation.
 * The nth line cuts n zones producing n more zones.
 */

int main() {
    int n;
    cin >> n;
    int m = 1;
    for(int i = 1; i <= n; i++) {
        m = m + i;
    }
    cout << m << endl;
}
