#include <stdio.h>
#include <string.h>
#include <time.h>
#include <stdlib.h>

#define SIZE 20

int toyCount = 0;

struct toy{
	char name[25];
	char desc[300];
	char type[10];
	char id[10];
	int weight;
	int price;
	
	toy *next;
	toy *prev;
} *head[SIZE], *tail[SIZE];

bool sameId(char id[]){
	for(int i = 0 ; i < SIZE; i++){
		if(head[i]==NULL){
			continue;
		}
		toy *curr = head[i];
		while(curr!=NULL){
			if(strcmp(curr->id, id)==0){
				return true;
			}
		}
		
	}
	return false;
}

int hash(char id[]){
	printf("hash: %d\n",(id[0]+id[1]+id[2]+id[3]+id[4])%20);
	return (id[0]+id[1]+id[2]+id[3]+id[4])%20;
}

toy *createToy(char name[], char desc[], char type[], int weight, int price){
	toy *newToy = (toy*)malloc(sizeof(toy));
	
	strcpy(newToy->name, name);
	strcpy(newToy->desc, desc);
	strcpy(newToy->type, type);
	newToy->weight = weight;
	newToy->price = price;
	newToy->next = NULL;
	newToy->prev = NULL;
	
	
		if(strcmp(type, "Toy")==0){
			sprintf(newToy->id, "%s%03d", "TO", rand()%1000);
		}
		else if(strcmp(type, "Clothing")==0){
			sprintf(newToy->id, "%s%03d", "CL", rand()%1000);
		}
		else if(strcmp(type, "Food")==0){
			sprintf(newToy->id, "%s%03d", "FO", rand()%1000);
		}
	
	
	
	return newToy;
}

void pushToy(char name[], char desc[], char type[], int weight, int price){
	toy *newToy = createToy(name,  desc, type, weight, price);
	
	int key = hash(newToy->id);
	
	if(head[key]==NULL){
		head[key] = newToy;
		tail[key] = newToy;	
	}
	else{
		tail[key]->next = newToy;
		newToy->prev = tail[key];
		tail[key] = newToy;
	}
}

void view(){
	puts("");
	if(toyCount == 0){
		printf("No product\n");
		return;
	}
	
	for(int i = 0; i < SIZE; i++){
		if(head[i]==NULL){
			continue;
		}
		
		toy *curr = head[i];
		
		while(curr!=NULL){
			printf("%-6s | %s - %d\n", curr->id, curr->name, curr->price);
			printf("%s\n", curr->desc);
			curr = curr->next;
			
		}
		puts("");
	}
}


void addProduct(){
	char name[25];
	 char desc[300];
	  char type[10];
	   int weight;
	    int price;
	
	do{
		printf("Input product name[5 - 20 chars]: ");
		scanf("%[^\n]", name);
		getchar();
	} while(strlen(name)<5 || strlen(name)>20);
	
	do{
		printf("Input product description [less than 250 chars]: ");
		scanf("%[^\n]", desc);
		getchar();
	} while(strlen(desc)>250);
	
	do{
		printf("Input product type [Toy | Clothing | Food] (Case-Sensitive): ");
		scanf("%s", type);
		getchar();
	} while(strcmp(type, "Toy")!= 0 && strcmp(type, "Clothing")!= 0 && strcmp(type, "Food")!= 0);
	
	do{
		printf("Input product weight [1 - 20]: ");
		scanf("%d", &weight);
		getchar();
	} while(weight<1 || weight > 20);
	
	do{
		printf("Input product maximum price [10000 - 500000]: ");
		scanf("%d", &price);
		getchar();
	} while(price<10000 || price>500000);
	
	char config;
	
	do{
		printf("Are you sure you want to add this product? [Y/N] (Case-Sensitive): ");
		scanf("%c", &config);
		getchar();
	} while(config!= 'N' && config!='Y');
	
	if(config == 'Y'){
		puts("Product created");
		pushToy(name, desc, type, weight, price);
		toyCount++;
	}
	else {
		puts("cancelled");
		return;
	}
	
	
	
}

void sellProduct(){
	if(toyCount == 0 ){
		return;
	}
	
	view();
	char id[6];
	printf("Enter ID of item to sell: ");
	scanf("%s", id);
	getchar();
	
	int key = hash(id);
	if(head[key]==NULL){
		return;
	}
	else if(head[key]==tail[key] && strcmp(head[key]->id, id)==0){
		printf("The customer bartered the price to: %d\n", (rand()%51)*head[key]->price/100);
				char conf;
				do{
					printf("Confirm transaction [Y/N]: ");
					scanf("%c", &conf);
				} while(conf!= 'N' && conf!='Y');
								
				if(conf=='Y'){
					head[key] = NULL;
					tail[key] = NULL;
					free(head[key]);
					free(tail[key]);
					printf("Transaction has been made!\n");
					return;
				}
				else if(conf=='N'){
					puts("cancelled");
					return;
				}
	}
	else if(strcmp(head[key]->id, id)==0){
		printf("The customer bartered the price to: %d\n", (rand()%51)*head[key]->price/100);
		char conf;
				do{
					printf("Confirm transaction [Y/N]: ");
					scanf("%c", &conf);
				} while(conf!= 'N' && conf!='Y');
								
				if(conf=='Y'){
					head[key]= head[key]->next;
					head[key]->prev->next = NULL;
					free(head[key]->prev);
					head[key]->prev = NULL;
					printf("Transaction has been made!\n");
					return;
				}
				else if(conf=='N'){
					puts("cancelled");
					return;
				}
	
	}
	else if(strcmp(tail[key]->id, id)==0){
		printf("The customer bartered the price to: %d\n", (rand()%51)*tail[key]->price/100);
				char conf;
				do{
					printf("Confirm transaction [Y/N]: ");
					scanf("%c", &conf);
				} while(conf!= 'N' && conf!='Y');
								
				if(conf=='Y'){
					tail[key]= tail[key]->prev;
					tail[key]->next->prev = NULL;
					free(tail[key]->next);
					tail[key]->next = NULL;
					printf("Transaction has been made!\n");
					return;
				}
				else if(conf=='N'){
					puts("cancelled");
					return;
				}
	
	}
	else{
		//mid
		toy *curr = head[key];
		while(curr!=NULL){
			if(strcmp(curr->id, id)==0){
				printf("The customer bartered the price to: %d\n", (rand()%51)*curr->price/100);
				char conf;
				do{
					printf("Confirm transaction [Y/N]: ");
					scanf("%c", &conf);
				} while(conf!= 'N' && conf!='Y');
								
				if(conf=='Y'){
					curr->next->prev = curr->prev;
					curr->prev->next = curr->next;
					curr->next = NULL;
					curr->prev =NULL;
					free(curr);
					printf("Transaction has been made!\n");
					return;
				}
				else if(conf=='N'){
					puts("cancelled");
					return;
				}
				
				
			}
			curr= curr->next;
		}
		puts("Not found");
	}
	puts("Not found");
}

void menu(){
	
	int choice;
	do{
	
		puts("Backyard Sale");
		puts("=============");
		puts("1. Add Product");
		puts("2. View Product Catalog");
		puts("3. Sell Product");
		puts("4. Exit");
		printf(">> ");
		
		scanf("%d", &choice); getchar();
		switch(choice){
			case 1:
				system("cls");
				addProduct();
				break;
			case 2:
				system("cls");
				view();
				break;
			case 3:
				system("cls");
				sellProduct();
				break;
			case 4:
				return;
		}
	} while (choice !=4);

	
}
int main(){
	system("cls");
	srand(time(NULL));
	menu();
	return 0;
}
