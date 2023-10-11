#include <stdio.h>

int main(){

	int a,arr[100000];
	int arr1[100000],arr2[100000];
	scanf("%d",&a);
	for(int i=0;i<a;i++){
		scanf("%d",&arr[i]);
		arr1[i]=arr2[i]=arr[i];

	}

	for(int i=0;i<a;i++){

		if(i%2!=0){
			if(arr1[i-1]==arr1[i+1]+2||arr1[i-1]==arr1[i+1]-2){
				arr1[i]=(arr1[i-1]+arr1[i+1])/2;
			}else if(arr1[i-1]==arr1[i+1]){
				arr1[i]=arr1[i-1]+1;
			}else{
				arr1[i]=arr1[i-1]+1;
			}
		}

	}
	for(int i=0;i<a;i++){

		if(i%2!=0){
			if(arr2[i-1]==arr2[i+1]+2||arr2[i-1]==arr2[i+1]-2){
				arr2[i]=(arr2[i-1]+arr2[i+1])/2;
			}else if(arr2[i-1]==arr2[i+1]){
				arr2[i]=arr2[i-1]+1;
			}else{
				arr2[i]=arr2[i+1]-1;
				if(arr2[i]<0){
					arr2[i]=arr2[i-1]+1;
				}
			}
		}

	}
	int counta=1,countb=1;
	int simpana=0,simpanb=0;
	for(int i=0;i<a-1;i++){

		if(arr1[i]==arr1[i+1]-1||arr1[i]==arr1[i+1]+1)
			counta++;
		
		else {
			if(simpana>counta)
				counta=1;

			else{

				simpana=counta;
				counta=1;

			}
		}

		if(i==a-2){

			if(simpana>counta)
				counta=1;
			
			else{
				
				simpana=counta;
				counta=1;

			}

		}

	}
	for(int i=0;i<a-1;i++){

		if(arr2[i]==arr2[i+1]-1||arr2[i]==arr2[i+1]+1)
			countb++;
		
		else{

			if(simpanb>countb)
				countb=1;
			
			else{

				simpanb=countb;
				countb=1;

			}
		}

		if(i==a-2){

			if(simpanb>countb)
				countb=1;
			
			else{

				simpanb=countb;
				countb=1;

			}

		}

	}

	if(simpana>simpanb)
		printf("%d\n",simpana);
	
	else
		printf("%d\n",simpanb);
	
	
	return 0;
}
