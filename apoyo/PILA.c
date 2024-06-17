#define MAX 1000
#include <stdlib.h>
#include <stdio.h>
#define TRUE 1
#define FALSE 0
#include "PILA.h"

void Initialize (PILA *s)
{
    (*s).tope= -1;
    //s -> tope= -1;
    return; 
}

void Push (PILA *s, elemento e)
{
    s-> tope++;
    if (s->tope == MAX)
        {
            puts("ERROR, Desbordamiento de la pila");
            exit(1);
        }
    s->A[s->tope]=e;
    return;
}

elemento Pop (PILA *s)
{
    elemento r;
    if(s->tope == -1)
    {
        puts("ERROR, Subdesbordamiento de la pila");
        exit(1);
    }
    r= s->A[s->tope];
    s->tope--;

return r;
}


elemento Top (PILA *s)
{
    if (s->tope == -1)
    {
        puts("Deseas consultar una pila vacia");
        exit(1);
    }

    return s->A[s-> tope];
}


int Size (PILA *s)
{
    int n;
    n= s->tope+1;
    return n;
}

boolean Empty (PILA *s)
{
    boolean r;
    if (s->tope== -1)
    r= TRUE;
    else
    r= FALSE;

return r;    
}


void Destroy (PILA *s)
{
    s->tope=-1;
    return;

    /*O USAR*/

    /*
    initialize (s);
    return;  
    */
}


