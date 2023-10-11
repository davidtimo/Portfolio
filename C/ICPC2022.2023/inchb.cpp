#include <stdio.h>

int main(){
	int n;
	scanf("%d",&n);
	int time[n+5];
	int steak[n+5];
	int order[n+5];
	int cookTime=0;
	for(int i=0;i<n-1;i++){
		scanf("%d",&time[i]);
	}
	for(int i=0;i<n;i++){
		scanf("%d",&steak[i]);
	}
	for(int i=0;i<n;i++){
		scanf("%d",&order[i]);
	}
	for(int i=n-1;i>0;i--){
//		printf("1: %d %d %d\n",order[i],steak[i],cookTime);
		while(order[i]>steak[i]){
			steak[i-1]-=1;
			steak[i]+=1;
			cookTime+=time[i-1];
		}
//		printf("2: %d %d %d\n",order[i],steak[i],cookTime);
	}
	if(order[0]>steak[0]){
		cookTime=-1;
	}
	printf("%d\n",cookTime);
	return 0;
}
