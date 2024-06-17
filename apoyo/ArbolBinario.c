#include <stdio.h>
#include <stdlib.h>
for float
typedef struct Nodo{
	int key;
	struct Nodo  *der;
	struct Nodo *izq;
}Nodo;

/*----------------------------Crear Nodo--------------------*/
struct Nodo* crearNodo(int key){
	Nodo *nuevo=malloc(sizeof(Nodo));
	nuevo->key=key;
	nuevo->der=NULL;
	nuevo->izq=NULL;
	return nuevo;
}

/*-------------------------insertar-------------------*/
void insertar(Nodo **raiz,int key){
	
	Nodo *p,*ant;
	p=*raiz;
	ant=NULL;
	
	while(p!=NULL){
		ant=p;
		if(p->key<key)
			p=p->der;
		else
			p=p->izq;
	}
		
	if((*raiz)==NULL){
		*raiz=crearNodo(key);
	}else if((ant->key)<key){
		ant->der=crearNodo(key);
	}
	  else{
			ant->izq=crearNodo(key);
		}

	
}

/*------------------buscar-----------------*/
int buscar(Nodo *raiz,int el){
	
	Nodo *aux=raiz;
	while(aux!=NULL){
		if(el==aux->key)
			return 1;
		else if(el<aux->key)
		aux=aux->izq;
		else
		aux=aux->der;
			
	}
	
}

/*----------------------Eliminacion por fusion----------------*/

void delete(Nodo *raiz,int key){
	Nodo *tmp,*nodo,*p=raiz,*ant=NULL;
	
	/*Recorre el arbol a modo de encontrar el nodo que tiene el key*/
	while(p!=NULL && p->key != key){
		ant=p;
		if(p->key <key)
		p=p->der;
		else p=p->izq;
	}
	
	nodo=p;
	if(p!=NULL && p->key==key){
		
		if(nodo->der==NULL)/* si el nodo no tiene hijo derecho su hijo izquierdo (si tiene) se une a su padre*/
		 nodo=nodo->izq;
		else if(nodo->der==NULL)/*si el nodo no tiene hijo izquierdo su hijo derecho se adjunta al padre */
		nodo=nodo->der;
		
		else{ /*si entra a esta condicion esta listo para fusionar arboles*/
	
		 tmp=nodo->izq;/*PASO 1 SE MUEVE A LA IZQUIERDA*/
		
		 while(tmp->der != NULL)/*PASO 2 luego se mueve a la derecha hasta donde pueda*/
	     	tmp=tmp->der;
		
		 tmp->der=nodo->der;/* PASO 3 se establece el enlace entre el nodo en el extremo derecho del subarbol izquierdo y el arbol derecho*/
		 nodo=nodo->izq;	/*PASO 4*/
		}
	
		if(p==raiz)
			raiz=nodo;
		else  if(ant->izq==p)
			ant->izq=nodo;
		else
			ant->der=nodo;/*PASO 5*/
	
	}
	else if(raiz!=NULL)
         printf("La llave %d no esta en el arbol",key);
	else
		 printf("El arbol esta vacio");	
	
	
}



/*--------------------Recorrido en inorden,preorden y postorden------*/

void preorden(Nodo *raiz){
	Nodo *aux=raiz;
	if(aux!=NULL)
	printf("%d,",aux->key);
	preorden(aux->izq);
	preorden(aux->der);
	
	
}

void inorden(Nodo *raiz){
	Nodo *aux=raiz;
	if(aux!=NULL){
		inorden(aux->izq);
		printf("%d ",aux->key);
		inorden(aux->der);
	}

}

void postorden( Nodo *raiz) {
	printf("RECORRIDO POSTORDEN: ");
	Nodo *aux=raiz;
    if (raiz != NULL) {
        postorden(raiz->izq);
        postorden(raiz->der);
        printf("%d,", raiz->key);
    }
}


/****************RECORRIDDO EN AMPLITUD**********************/

main(){
	
	Nodo *raiz=NULL;
	insertar(&raiz,1);
	insertar(&raiz,4);
	insertar(&raiz,6);
	insertar(&raiz,72);
	insertar(&raiz,9);
	insertar(&raiz,9);
	insertar(&raiz,0);
	
	inorden(raiz);
		printf("\n");

	delete(raiz,23);
	inorden(raiz);

}
