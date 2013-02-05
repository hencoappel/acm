#include <iostream>
#include <cstdio>
#include <map>

using namespace std;

typedef pair<int, int> Point;

int main()
{
	int scenarios;
	cin >> scenarios;
	for (int i = 0; i < scenarios; ++i)
	{
		int d, n;
		cin >> d >> n;
		map<Point, int> rat_map;
		for (int j = 0; j < n; ++j)
		{
			int x, y, rats;
			cin >> x >> y >> rats;
			rat_map[make_pair(x, y)] = rats;
		}
		Point best_p = rat_map.begin()->first;
		int best_total = 0;
		for (map<Point, int>::iterator it = rat_map.begin(); it != rat_map.end(); it++)
		{
			printf("for nest %d %d\n", it->first.first, it->first.second);
			int x1_start = it->first.first - d;
			int x1_end = it->first.first + d;
			for (int x1 = x1_start; x1 <= x1_end; ++x1)
			{
				int y1_start = it->first.second - d;
				int y1_end = it->first.second + d;
				for (int y1 = y1_start; y1 <= y1_end; ++y1)
				{
					int total = 0;
					int x2_start = x1 - d;
					int x2_end = x1 + d;
					for (int x2 = x2_start; x2 <= x2_end; ++x2)
					{
						int y2_start = y1 - d;
						int y2_end = y1 + d;
						for (int y2 = y2_start; y2 <= y2_end; ++y2)
						{
							Point p(x2, y2);
							// element is in map
							if (rat_map.count(p) > 0)
							{
								total += rat_map[p];
							}
						}
					}
					if (total > best_total)
					{
						best_total = total;
						best_p = Point(x1, y1);
					}
				}
			}
		}
		printf("%d %d %d\n", best_p.first, best_p.second, best_total);
	}
}
