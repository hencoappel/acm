#include <iostream>
using namespace std;

// http://acm.sgu.ru/problem.php?contest=0&problem=222
// ACCEPTED!

const int MAX = 11;

int fact[MAX];

void factorial() {
    fact[0] = 1;
    fact[1] = 1;
    for (int i = 2; i < MAX; ++i) {
        fact[i] = fact[i - 1] * i;
    }
}

/*
 * Calculate the number of rook placements recursively.
 *  For board same height and width, and same value of k, it's n!
 *
 *  For k = 1, it's the number of squares on the board, w * h.
 *
 *  k > w or k > h, then there are no solutions
 *
 *  For width of 1, it...
 *
 *  The recurrence relation consists of the height times the number of ways
 *  to place k-1 rooks on  w-1 by h-1 size board. This is the same as having
 *  h places to choose from to place a rook. The other half is if a rook isn't
 *  placed on a line, so we reduce the width by one.
 */
int calc(int w, int h, int k) {
    if(w == h && h == k) {
        return fact[w];
    } else if (k == 1) {
        return w * h;
    } else if (k > w || k > h) {
        return 0;
    } else if (w == 1) {
        return w * h;
    } else {
        int val = h * calc(w - 1, h - 1, k - 1) +  calc(w - 1, h, k);
        return val;
    }
}

int main() {
    int n, k;
    cin >> n >> k;

    // not possible
    if (k > n) {
        cout << "0\n";
        return 0;
    }

    // 1 solution, i.e. no rooks placed
    if (k == 0) {
        cout << "1\n";
        return 0;
    }

    // if there is 1 rook then there are the number of squares on the board placements
    if (k == 1) {
        cout << n * n << endl;
        return 0;
    }

    // precompute the factorials
    factorial();

    // If the k == n then there are n! placements of the rooks
    if (k == n) {
        cout << fact[n] << endl;
        return 0;
    }

    // calculate recursively.
    cout << calc(n, n, k) << endl;

    return 0;
}
