#include <iostream>
using namespace std;

int main()
{
	int nums[4] = {2,7,11,15};
	int target = 9;
	for(int x=0; x<4; x++)
	{
		for (int y=x+1; y<4; y++)
		{
			if(nums[x]+nums[y] == target)
			cout<<x<<endl<<y;
		}
	}
	return 0;
}
