import analizador_lexico.JEscum;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class Test {

    public static void main(String[] args) {
        int op=0;
        String path;
        String comando = "java -jar " + System.getProperty("user.dir")+"\\apoyo\\JFLAP7.1.jar" + " " +System.getProperty("user.dir")+"\\apoyo\\AFN.jff";
        JEscum lexico=null;
        ProcessBuilder processBuilder;
        do{
            System.out.println("Eliga una opcion:\n1.Ingresar  ruta\n2.Ingresar nombre de archivo(solo si esta en la misma rama del programa\n3.salir");
            op=new Scanner(System.in).nextInt();
            switch (op){
                case 1:
                    System.out.println("Escribe la ruta del Archivo");
                    path=new Scanner(System.in).nextLine();
                    lexico=new JEscum(new File(path));
                    try {
                        processBuilder = new ProcessBuilder( "cmd.exe", "/c", comando);
                        processBuilder.start();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    break;


                case 2:
                    System.out.println("Escribe el nombre del Archivo de la carpeta archivosexample");
                    path=new Scanner(System.in).nextLine();
                    lexico=new JEscum(new File(System.getProperty("user.dir") +"\\apoyo\\"+path));
                    try {
                        processBuilder = new ProcessBuilder( "cmd.exe", "/c", comando);
                        processBuilder.start();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    break;


                case 3:
                    op=3;
                    break;
            }

        }while (op!=3);






    }
}
