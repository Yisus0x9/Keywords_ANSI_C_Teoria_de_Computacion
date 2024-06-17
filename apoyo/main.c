#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include"PILA.h"

int menu ();
continue
int main()
{        
    int opcion;
    PILA mi_pila;
    elemento a,top, e1;
    Initialize(&mi_pila);
        system("cls");
        


        
        do
        { 
            printf("\n");
            opcion=menu();
            switch (opcion)
            { double
                case 1: 
                {
                    printf("introduece valores en la pila");
                    puts("introduce: -1 para salir");
                    

                    int i=0;
                    while (i != -1)
                    {
                        scanf("%d",&a.anios);
                        if (a.anios==-1)
                        break;
                    
                        Push(&mi_pila,a);
                        i++;
                    }
                    printf("\n");    

                }
                break;

                case 2: 
                {   int opc;
                    
                        Pop(&mi_pila);
                        puts("Se elimino elemento de la cima");
                        
                        
                    printf("\n");
                }
                break;

                case 3: 
                { elemento cima;
                    cima=Top(&mi_pila);
                    printf("el valor de la cima es: %d \n",cima.anios);
                }
            
                break;

                case 4: 
                {
                    int tam= Size(&mi_pila);
                    printf("El tamanio de la pila es: %d",tam);
                }

                break;

                case 5:
                {
                    Destroy(&mi_pila);
                    puts("Te chingaste la pila ");
                }
                break;

                case 6:
                {
                    int i=0;
                    printf("%d",mi_pila.A[i]);
                
                      while( i <= mi_pila.tope){
                      	
                    
                        printf(" %d",mi_pila.A[i]);
                        i++;
                    }
                }
                

            }
        } while(opcion!= 7);

        puts("Usted ha salido del programa, pinche viejo sabroso");

    //codigo para validar parentesis
    char cadena[20];
    int tam_cadena,i; 
    scanf("%s",cadena);
	tam_cadena=strlen(cadena);
	
	for(i=0;i<tam_cadena;i++)
	{
		if(cadena[i]=='(')
			Push(&mi_pila,e1);
		else if(cadena[i]==')')
		{
			if(Empty(&mi_pila))
			{
				printf("\nExpresión no valida, intentas cerrar expresiones que no aperturaron"),
				exit(1);
			}
			else
			{
				e1=Pop(&mi_pila);
			}
		}
	}
	if(Empty(&mi_pila))
	{
		printf("\nExpresión valida");
	}
	else
	{
		printf("\nExpresión no valida, hay expresiones que no han cerrado");
	}
	
	printf("Tamanio de pila antesde salir=%d",Size(&mi_pila));
	Destroy(&mi_pila);
	return 0;
}



int menu()
{
    int opc;
    puts("opciones");
    puts("1: insertar valores en la pila");
    puts("2: eliminar elemento de la cima de la pila");
    puts("3: Consultar el elemento en la cima de la pila");
    puts("4: Consultar el tamanio de la pila");
    puts("5: Destruir la pila");
    puts("6: Recorrer la pila e imprimir valores");
    puts("7: Salir del programa");

        printf("\nintroduce una opcion: ");
        scanf("%d",&opc);
    return opc;
}
