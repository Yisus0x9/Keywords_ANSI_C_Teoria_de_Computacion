#include <stdio.h>
#include <stdlib.h>

	typedef struct node{
	char symbol;
	struct node *next;
}Node;

	Node *ptrRoot=NULL;



	void push(char symbol){
		Node *aux;
		aux=malloc(sizeof(Node));
		aux->symbol=symbol;
		
		if(ptrRoot==NULL){
			ptrRoot=aux;
			aux->next=NULL;
		}else{
			aux->next=ptrRoot;
			ptrRoot=aux;
		}
	}
	
	char pop(){
		if(ptrRoot!=NULL){
			char symbol=ptrRoot->symbol;
			Node *temp=ptrRoot;
			ptrRoot=ptrRoot->next;
			free(temp);
			return symbol;
		}else{
			return -1;
		}
		
	}
	
	void freeStack(){
		Node *aux=ptrRoot;
		Node *temp;
		
		while(aux!=NULL){
			temp=aux;
			aux=aux->next;
			free(temp);
		}
	}
	
	int isEmpty(){
		if(ptrRoot==NULL)
		return 1;
		return 0;
	}
	
	
	int isBalanced(char *cad){
		int f=0;
		while(cad[f]!='\0'){
			if(cad[f]=='(' || cad[f]=='['|| cad[f]=='{'){
				push(cad[f]);
				
			}else{
				//case 1
				if(cad[f]==')'){
					if(pop()!='('){
					   return 0;
					}
					
				}
				
				//case 2
				if(cad[f]==']'){
					if(pop()!='['){				
					   return 0;
					}
					   
				}
				
				//case3
				if(cad[f]=='}'){
					if(pop()!='{'){			
					   return 0;
					}
				}
			
			}
		
			f++;
		}
		
		//se verifica si la pila esta vacia de esta forma si no es retornada anteriormente
		//puede que haya n simbolos balanceados pero quede alguno sin balancear 
		if(isEmpty()){
			return 1;
		}else{
			return 0;
		}
	}
	
	
	int main(){
	
		char cad[1000];
		printf("input the string:\n");
		
		if(isBalanced(gets(cad))){
			puts("correct balanced string");
		}else{
			puts("error in symbol of the string");
			
		}
		
		freeStack();
		return 0;
		
	}
