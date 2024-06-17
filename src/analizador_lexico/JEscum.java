package analizador_lexico;
import java.io.File;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static analizador_lexico.Tokens.*;


public class JEscum {

    private File out=new File("JEscum_out");
    private File historial=new File("Recorrido.txt");
    private Map<String,Integer> cont=new HashMap<>();
    private int linea=1,columna=1,id=1, palabra=1;
    private boolean   bandera=true;
    private String estado="q0";
    char []line;



    public JEscum(File data)  {
        if(out.exists()){out.delete();}
        if(historial.exists()){historial.delete();}
        analizador(data);
    }


    private void analizador(File data){
        String k;
        escribir("q0",1);
            try (BufferedReader lector=new BufferedReader(new FileReader(data))){
                while ((k=lector.readLine())!=null){
                    line=k.toCharArray();
                    for(char n:line){
                        lexico(n);
                        escribir(n +"-->" + estado,1);
                        columna++;
                    }
                    columna=1;
                    linea++;
                }
                mostrar();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }


    private int lexico(char n){
        if(estado.equals("q0")){
            switch (n){
                case 't':
                    estado="q1";
                    break;

                case 'f':
                    estado="q2";
                    break;

                case 'g':
                    estado="q3";
                    break;

                case 'r':
                    estado="q4";
                    break;

                case 'a':
                    estado="q5";
                    break;

                case 's':
                    estado="q6";
                    break;

                case 'e':
                    estado="q7";
                    break;

                case 'u':
                    estado="q8";
                    break;

                case 'l':
                    estado="q9";
                    break;

                case 'i':
                    estado="q10";
                    break;

                case 'd':
                    estado="q11";
                    break;

                case 'w':
                    estado="q12";
                    break;

                case 'b':
                    estado="q13";
                    break;

                case 'c':
                    estado="q14";
                    break;

                case 'v':
                    estado="q15";
                    break;

                case '_':
                    estado="q144";
                    break;

                default:
                    estado="q0";
                    break;
            }
            return 0;
        }

        //typedef
        if(estado.equals("q1")){
            switch (n){
                case 'y':
                    estado="q16";
                    break;
                default:
                    estado="q0";
                    break;
            }
            return 0;
        }
        if(estado.equals("q16")){
            switch (n){
                case 'p':
                    estado="q41";
                    break;
                default:
                    estado="q0";
                    break;
            }
            return 0;
        }
        if(estado.equals("q41")){
            switch (n){
                case 'e':
                    estado="q70";
                    break;
                default:
                    estado="q0";
                    break;
            }
            return 0;
        }
        if(estado.equals("q70")){
            switch (n){
                case 'd':
                    estado="q98";
                    break;
                default:
                    estado="q0";
                    break;
            }
            return 0;
        }
        if(estado.equals("q98")){
            switch (n){
                case 'e':
                    estado="q118";
                    break;
                default:
                    estado="q0";
                    break;
            }
            return 0;
        }
        if(estado.equals("q118")){
            switch (n){
                case 'f':
                    escribir(palabra+ ". " +TYPEDEF.toString().toLowerCase() +"("+ linea+"," + (columna-7) + ")",2);
                    contar(TYPEDEF);
                    palabra++;
                    estado="q132";
                    break;
                default:
                    estado="q0";
                    break;
            }
            return 0;
        }
        if(estado.equals("q132")){

            estado="q0";
            return 0;
        }

        //for y float
        if(estado.equals("q2")){
            switch (n){
                case 'o':
                    estado="q17";
                    break;

                case 'l':
                    estado="q18";
                    break;
                default:
                    estado="q0";
                    break;
            }
            return 0;
        }
        if(estado.equals("q17")){
            switch (n){
                case 'r':
                    escribir(palabra+ ". " + FOR.toString().toLowerCase() +"("+linea+","  + (columna-3) + ")",2);
                    contar(FOR);
                    palabra++;
                    estado="q42";
                    break;
                default:
                    estado="q0";
                    break;
            }
            return 0;
        }
        if(estado.equals("q42")){
            estado="q0";
            return 0;
        }
        if(estado.equals("q18")){
            switch (n){
                case 'o':
                    estado="q43";
                    break;
                default:
                    estado="q0";
                    break;
            }
            return 0;
        }
        if(estado.equals("q43")){
            switch (n){
                case 'a':
                    estado="q71";
                    break;
                default:
                    estado="q0";
                    break;
            }
            return 0;
        }
        if(estado.equals("q71")){
            switch (n){
                case 't':
                    escribir(palabra+ ". " +FLOAT.toString().toLowerCase() +"("+linea+"," + (columna - 5) + ")",2);
                    contar(FLOAT);
                    palabra++;
                    estado="q99";
                    break;
                default:
                    estado="q0";
                    break;
            }
            return 0;
        }
        if(estado.equals("q99")){
            estado="q0";
            return 0;
        }

        //goto
        if(estado.equals("q3")){
            switch (n){
                case 'o':
                    estado="q19";
                    break;
                default:
                    estado="q0";
                    break;
            }
            return 0;
        }
        if(estado.equals("q19")){
            switch (n){
                case 't':
                    estado="q44";
                    break;
                default:
                    estado="q0";
                    break;
            }
            return 0;
        }
        if(estado.equals("q44")){
            switch (n){
                case 'o':
                    escribir(palabra+ ". " +GOTO.toString().toLowerCase() +"("+linea+"," +(columna - 4) + ")",2);
                    contar(GOTO);
                    palabra++;
                    estado="q72";
                    break;
                default:
                    estado="q0";
                    break;
            }
            return 0;
        }
        if(estado.equals("q72")){

            estado="q0";
            return 0;
        }

        //register y return
        if(estado.equals("q4")){
            switch (n){
                case 'e':
                    estado="q20";
                    break;
                default:
                    estado="q0";
                    break;
            }
            return 0;
        }
        if(estado.equals("q20")){
            switch (n){
                case 'g':
                    estado="q46";
                    break;

                case 't':
                    estado="q45";
                    break;

                default:
                    estado="q0";
                    break;
            }
            return 0;
        }

        //register
        if(estado.equals("q46")){
            switch (n){
                case 'i':
                    estado="q74";
                    break;
                default:
                    estado="q0";
                    break;
            }
            return 0;
        }
        if(estado.equals("q74")){
            switch (n){
                case 's':
                    estado="q101";
                    break;
                default:
                    estado="q0";
                    break;
            }
            return 0;
        }
        if(estado.equals("q101")){
            switch (n){
                case 't':
                    estado="q120";
                    break;
                default:
                    estado="q0";
                    break;
            }
            return 0;
        }
        if(estado.equals("q120")){
            switch (n){
                case 'e':
                    estado="q133";
                    break;
                default:
                    estado="q0";
                    break;
            }
            return 0;
        }
        if(estado.equals("q133")){
            switch (n){
                case 'r':
                    escribir(palabra+ ". " +REGISTER.toString().toLowerCase() +"("+linea+"," +(columna - 8) + ")",2);
                    contar(REGISTER);
                    palabra++;
                    estado="q138";
                    break;
                default:
                    estado="q0";
                    break;
            }
            return 0;
        }
        if(estado.equals("q138")){
            estado="q0";
            return 0;
        }
        //return
        if(estado.equals("q45")){
            switch (n){
                case 'u':
                    estado="q73";
                    break;
                default:
                    estado="q0";
                    break;
            }
            return 0;
        }
        if(estado.equals("q73")){
            switch (n){
                case 'r':
                    estado="q100";
                    break;
                default:
                    estado="q0";
                    break;
            }
            return 0;
        }
        if(estado.equals("q100")){
            switch (n){
                case 'n':
                    escribir(palabra+ ". " +RETURN.toString().toLowerCase() +"("+linea+","  +(columna - 6) + ")",2);
                    contar(RETURN);
                    palabra++;
                    estado="q119";
                    break;
                default:
                    estado="q0";
                    break;
            }
            return 0;
        }
        if(estado.equals("q119")){
            estado="q0";
            return 0;
        }

        //auto
        if(estado.equals("q5")){
            switch (n){
                case 'u':
                    estado="q21";
                    break;
                default:
                    estado="q0";
                    break;
            }
            return 0;
        }
        if(estado.equals("q21")){
            switch (n){
                case 't':
                    estado="q47";
                    break;
                default:
                    estado="q0";
                    break;
            }
            return 0;
        }
        if(estado.equals("q47")){
            switch (n){
                case 'o':
                    escribir(palabra+ ". " +AUTO.toString().toLowerCase() +"auto ("+linea+","  +(columna - 4) + ")",2);
                    contar(AUTO);
                    palabra++;
                    estado="q75";
                    break;
                default:
                    estado="q0";
                    break;
            }
            return 0;
        }
        if(estado.equals("q75")){
            estado="q0";
            return 0;
        }

        //st,si,sh y sw
        if(estado.equals("q6")){
            switch (n){
                case 't':
                    estado="q22";
                    break;

                case 'i':
                    estado="q24";
                    break;

                case 'h':
                    estado="q23";
                    break;

                case 'w':
                    estado="q25";
                    break;
                default:
                    estado="q0";
                    break;
            }
            return 0;
        }
        //a o r
        if(estado.equals("q22")){
            switch (n){
                case 'a':
                    estado="q49";
                    break;

                case 'r':
                    estado="q48";
                    break;
                default:
                    estado="q0";
                    break;
            }
            return 0;
        }

        //tic
        if(estado.equals("q49")){
            switch (n){
                case 't':
                    estado="q77";
                    break;
                default:
                    estado="q0";
                    break;
            }
            return 0;
        }
        if(estado.equals("q77")){
            switch (n){
                case 'i':
                    estado="q103";
                    break;
                default:
                    estado="q0";
                    break;
            }
            return 0;
        }
        if(estado.equals("q103")){
            switch (n){
                case 'c':
                    escribir(palabra+ ". " +STATIC.toString().toLowerCase() +" ("+linea+","+(columna - 6) + ")",2);
                    contar(STATIC);
                    palabra++;
                    estado="q122";
                    break;
                default:
                    estado="q0";
                    break;
            }
            return 0;
        }
        if(estado.equals("q122")){
            estado="q0";
            return 0;
        }

        //uct
        if(estado.equals("q48")){
            switch (n){
                case 'u':
                    estado="q76";
                    break;
                default:
                    estado="q0";
                    break;
            }
            return 0;
        }
        if(estado.equals("q76")){
            switch (n){
                case 'c':
                    estado="q102";
                    break;
                default:
                    estado="q0";
                    break;
            }
            return 0;
        }
        if(estado.equals("q102")){
            switch (n){
                case 't':
                    escribir(palabra+ ". " +STRUCT.toString().toLowerCase() +"("+linea+"," +(columna -6) + ")",2);
                    contar(STRUCT);
                    palabra++;
                    estado="q121";
                    break;
                default:
                    estado="q0";
                    break;
            }
            return 0;
        }
        if(estado.equals("q121")){

            estado="q0";
            return 0;
        }

        //si-z o g
        if(estado.equals("q24")){
            switch (n){
                case 'z':
                    estado="q52";
                    break;

                case 'g':
                    estado="q51";
                    break;
                default:
                    estado="q0";
                    break;
            }
            return 0;
        }
        //eof
        if(estado.equals("q52")){
            switch (n){
                case 'e':
                    estado="q80";
                    break;
                default:
                    estado="q0";
                    break;
            }
            return 0;
        }
        if(estado.equals("q80")){
            switch (n){
                case 'o':
                    estado="q106";
                    break;
                default:
                    estado="q0";
                    break;
            }
            return 0;
        }
        if(estado.equals("q106")){
            switch (n){
                case 'f':
                    escribir(palabra+ ". " +SIZEOF.toString().toLowerCase() +" ("+linea+(columna - 6) + ")",2);
                    contar(SIZEOF);
                    palabra++;
                    estado="q124";
                    break;
                default:
                    estado="q0";
                    break;
            }
            return 0;
        }
        if(estado.equals("q124")){
            estado="q0";
            return 0;
        }
        //ned
        if (estado.equals("q51")) {
            switch (n) {
                case 'n':
                    estado = "q79";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q79")) {
            switch (n) {
                case 'e':
                    estado = "q105";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q105")) {
            switch (n) {
                case 'd':
                    escribir(palabra+ ". " +SIGNED.toString().toLowerCase() +"(" + linea + "," +(columna - 6) + ")",2);
                    contar(SIGNED);
                    palabra++;
                    estado = "q123";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q123")) {
            estado = "q0";
            return 0;
        }
        //ort
        if (estado.equals("q23")) {
            switch (n) {
                case 'o':
                    estado = "q50";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q50")) {
            switch (n) {
                case 'r':
                    estado = "q78";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q78")) {
            switch (n) {
                case 't':
                    escribir(palabra+ ". " +SHORT.toString().toLowerCase() +" (" + linea + "," +(columna - 5) + ")",2);
                    contar(SHORT);
                    palabra++;
                    estado = "q104";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q104")) {
            estado = "q0";
            return 0;
        }
        //itch
        if (estado.equals("q25")) {
            switch (n) {
                case 'i':
                    estado = "q53";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q53")) {
            switch (n) {
                case 't':
                    estado = "q81";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q81")) {
            switch (n) {
                case 'c':
                    estado = "q107";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q107")) {
            switch (n) {
                case 'h':
                    escribir(palabra+ ". " +SWITCH.toString().toLowerCase() +" (" + linea + "," +(columna - 6) + ")",2);
                    contar(SWITCH);
                    palabra++;
                    estado = "q125";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q125")) {
            estado = "q0";
            return 0;
        }

        //el,ex,en
        if (estado.equals("q7")) {
            switch (n) {
                case 'l':
                    estado = "q27";
                    break;

                case 'x':
                    estado = "q28";
                    break;

                case 'n':
                    estado = "q26";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }

        //se
        if (estado.equals("q27")) {
            switch (n) {
                case 's':
                    estado = "q55";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q55")) {
            switch (n) {
                case 'e':
                    escribir(palabra+ ". " +ELSE.toString().toLowerCase() +" (" + linea + "," +(columna - 4) + ")",2);
                    contar(ELSE);
                    palabra++;
                    estado = "q83";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q83")) {
            estado = "q0";
            return 0;
        }

        //tern
        if (estado.equals("q28")) {
            switch (n) {
                case 't':
                    estado = "q56";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q56")) {
            switch (n) {
                case 'e':
                    estado = "q84";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q84")) {
            switch (n) {
                case 'r':
                    estado = "q108";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q108")) {
            switch (n) {
                case 'n':
                    escribir(palabra+ ". " +EXTERN.toString().toLowerCase() +" (" + linea + "," +(columna - 6) + ")",2);
                    contar(EXTERN);
                    palabra++;
                    estado = "q126";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q126")) {
            estado = "q0";
            return 0;
        }

        //um
        if (estado.equals("q26")) {
            switch (n) {
                case 'u':
                    estado = "q54";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q54")) {
            switch (n) {
                case 'm':
                    escribir(palabra+ ". " +ENUM.toString().toLowerCase() +" (" + linea + "," +(columna - 4) + ")",2);
                    contar(ENUM);
                    palabra++;
                    estado = "q82";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q82")) {
            estado = "q0";
            return 0;
        }

        //uni-uns
        if (estado.equals("q8")) {
            switch (n) {
                case 'n':
                    estado = "q29";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q29")) {
            switch (n) {
                case 'i':
                    estado = "q58";
                    break;
                case 's':
                    estado="q57";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }

        //on
        if (estado.equals("q58")) {
            switch (n) {
                case 'o':
                    estado = "q86";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q86")) {
            switch (n) {
                case 'n':
                    escribir(palabra+ ". " +UNION.toString().toLowerCase() +" (" + linea + "," +(columna - 5) + ")",2);
                    contar(UNION);
                    palabra++;
                    estado = "q110";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q110")) {
            estado = "q0";
            return 0;
        }

        //igned
        if (estado.equals("q57")) {
            switch (n) {
                case 'i':
                    estado = "q85";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q85")) {
            switch (n) {
                case 'g':
                    estado = "q109";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q109")) {
            switch (n) {
                case 'n':
                    estado = "q127";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q127")) {
            switch (n) {
                case 'e':
                    estado = "q134";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q134")) {
            switch (n) {
                case 'd':
                    escribir(palabra+ ". " +UNSIGNED.toString().toLowerCase() +" (" + linea + ","+(columna - 8) + ")",2);
                    contar(UNSIGNED);
                    palabra++;
                    estado = "q139";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q139")) {
            estado = "q0";
            return 0;
        }

        //ong
        if (estado.equals("q9")) {
            switch (n) {
                case 'o':
                    estado = "q30";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q30")) {
            switch (n) {
                case 'n':
                    estado = "q59";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q59")) {
            switch (n) {
                case 'g':
                    escribir(palabra+ ". " +LONG.toString().toLowerCase() +" (" + linea + ","  +(columna - 4) + ")",2);
                    contar(LONG);
                    palabra++;
                    estado = "q87";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q87")) {
            estado = "q0";
            return 0;
        }

        //f-nt
        if (estado.equals("q10")) {
            switch (n) {
                case 'f':
                    escribir(palabra+ ". " +IF.toString().toLowerCase() +" (" + linea + "," +(columna - 2) + ")",2);
                    contar(IF);
                    palabra++;
                    estado = "q32";
                    break;
                case 'n':
                    estado="q31";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q32")) {
            estado = "q0";
            return 0;
        }
        if (estado.equals("q31")) {
            switch (n) {
                case 't':
                        escribir(palabra+ ". " +INT.toString().toLowerCase() +" (" + linea + "," +(columna - 3) + ")",2);
                        contar(INT);
                        palabra++;
                    estado = "q60";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q60")) {
            estado = "q0";
            return 0;
        }

        //do-de
        if (estado.equals("q11")) {
            switch (n) {
                case 'o':
                    escribir(palabra+ ". " +DO.toString().toLowerCase() +" (" + linea + "," +(columna - 2) + ")",2);
                    contar(DO);
                    palabra++;
                    estado = "q33";
                    break;
                case 'e':
                    estado="q34";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        //do
        if (estado.equals("q33")) {
            switch (n) {
                case 'u':
                    estado = "q61";
                    break;

                default:
                    estado = "q0";
            }
            return 0;
        }
        //uble
        if (estado.equals("q61")) {
            switch (n) {
                case 'b':
                    estado = "q88";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q88")) {
            switch (n) {
                case 'l':
                    estado = "q111";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q111")) {
            switch (n) {
                case 'e':
                    escribir(palabra+ ". " +DOUBLE.toString().toLowerCase() +" (" + linea + "," +(columna - 6) + ")",2);
                    contar(DOUBLE);
                    palabra++;
                    estado = "q128";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q128")) {
            estado = "q0";
            return 0;
        }

        //fault
        if (estado.equals("q34")) {
            switch (n) {
                case 'f':
                    estado = "q62";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q62")) {
            switch (n) {
                case 'a':
                    estado = "q89";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q89")) {
            switch (n) {
                case 'u':
                    estado = "q112";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q112")) {
            switch (n) {
                case 'l':
                    estado = "q129";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q129")) {
            switch (n) {
                case 't':
                    escribir(palabra+ ". " +DEFAULT.toString().toLowerCase() +" (" + linea + "," +(columna - 7) + ")",2);
                    contar(DEFAULT);
                    palabra++;
                    estado = "q135";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q135")) {
            estado = "q0";
            return 0;
        }

        //hile
        if (estado.equals("q12")) {
            switch (n) {
                case 'h':
                    estado = "q35";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q35")) {
            switch (n) {
                case 'i':
                    estado = "q63";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q63")) {
            switch (n) {
                case 'l':
                    estado = "q90";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q90")) {
            switch (n) {
                case 'e':
                    escribir(palabra+ ". " +WHILE.toString().toLowerCase() +" (" + linea + ","  +(columna - 5) + ")",2);
                    contar(WHILE);
                    palabra++;
                    estado = "q113";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q113")) {
            estado = "q0";
            return 0;
        }

        //reak
        if (estado.equals("q13")) {
            switch (n) {
                case 'r':
                    estado = "q36";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q36")) {
            switch (n) {
                case 'e':
                    estado = "q64";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q64")) {
            switch (n) {
                case 'a':
                    estado = "q91";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q91")) {
            switch (n) {
                case 'k':
                    escribir(palabra+ ". " +BREAK.toString().toLowerCase() +" (" + linea + "," +(columna - 5) + ")",2);
                    contar(BREAK);
                    palabra++;
                    estado = "q114";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q114")) {
            estado = "q0";
            return 0;
        }

        //co,ch,ca
        if (estado.equals("q14")) {
            switch (n) {
                case 'o':
                    estado = "q39";
                    break;
                case 'h':
                    estado = "q37";
                    break;
                case 'a':
                    estado = "q38";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        //cont,cons
        if (estado.equals("q39")) {
            switch (n) {
                case 'n':
                    estado = "q67";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q67")) {
            switch (n) {
                case 't':
                    estado = "q94";
                    break;
                case 's':
                    estado = "q95";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }

        //continue
        if (estado.equals("q94")) {
            switch (n) {
                case 'i':
                    estado = "q115";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q115")) {
            switch (n) {
                case 'n':
                    estado = "q130";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q130")) {
            switch (n) {
                case 'u':
                    estado = "q136";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q136")) {
            switch (n) {
                case 'e':
                    escribir(palabra+ ". " +CONTINUE.toString().toLowerCase() +" (" + linea + "," +(columna - 8) + ")" ,2);
                    contar(CONTINUE);
                    palabra++;
                    estado = "q140";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q140")) {
            estado = "q0";
            return 0;
        }

        //const
        if (estado.equals("q95")) {
            switch (n) {
                case 't':
                    escribir(palabra+ ". " +CONST.toString().toLowerCase() +" (" + linea + "," +(columna - 5) + ")",2);
                    contar(CONST);
                    palabra++;
                    estado = "q116";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q116")) {
            estado = "q0";
            return 0;
        }

        //char
        if (estado.equals("q37")) {
            switch (n) {
                case 'a':
                    estado = "q65";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q65")) {
            switch (n) {
                case 'r':
                    escribir(palabra+ ". " +CHAR.toString().toLowerCase()+"(" + linea + ","  +(columna - 4) + ")",7 );
                    contar(CHAR);
                    palabra++;
                    estado = "q92";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q92")) {
            estado = "q0";
            return 0;
        }
        //case
        if (estado.equals("q38")) {
            switch (n) {
                case 's':
                    estado = "q66";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q66")) {
            switch (n) {
                case 'e':
                    escribir(palabra+ ". " +CASE.toString().toLowerCase() +" (" + linea + "," +(columna - 4) + ")",7);
                    contar(CASE);
                    palabra++;
                    estado = "q93";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q93")) {
            estado = "q0";
            return 0;
        }

        //vo
        if (estado.equals("q15")) {
            switch (n) {
                case 'o':
                    estado = "q40";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q40")) {
            switch (n) {
                case 'i':
                    estado = "q69";
                    break;
                case 'l':
                    estado = "q68";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }

        //volatile
        if (estado.equals("q68")) {
            switch (n) {
                case 'a':
                    estado = "q96";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q96")) {
            switch (n) {
                case 't':
                    estado = "q117";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q117")) {
            switch (n) {
                case 'i':
                    estado = "q131";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q131")) {
            switch (n) {
                case 'l':
                    estado = "q137";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q137")) {
            switch (n) {
                case 'e':
                    escribir(palabra+ ". " +VOLATILE.toString().toLowerCase() +" (" + linea + ","  +(columna - 8) + ")",2);
                    contar(VOLATILE);
                    palabra++;
                    estado = "q141";
                    break;
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q141")) {
            estado = "q0";
            return 0;
        }
        //void
        if (estado.equals("q69")) {
            switch (n) {
                case 'd':
                    escribir(palabra+ ". " +VOID.toString().toLowerCase() +" (" + linea + "," +(columna - 4) + ")",2);
                    contar(VOID);
                    palabra++;
                    estado = "q97";
                default:
                    estado = "q0";
                    break;
            }
            return 0;
        }
        if (estado.equals("q97")) {
            estado = "q0";
            return 0;
        }


        if(estado.equals("q144")){
            switch (n){
                case 'P':
                    estado="q145";
                    break;
                default:
                    estado="q0";
                    break;
            }
            return 0;
        }

        if(estado.equals("q145")){
            switch (n){
                case 'a':
                    estado="q146";
                    break;
                default:
                    estado="q0";
                    break;
            }
            return 0;
        }

        if(estado.equals("q146")){
            switch (n){
                case 'c':
                    estado="q147";
                    break;
                default:
                    estado="q0";
                    break;
            }
            return 0;
        }

        if(estado.equals("q147")){
            switch (n){
                case 'k':
                    estado="q148";
                    break;
                default:
                    estado="q0";
                    break;
            }
            return 0;
        }
        if(estado.equals("q148")){
            switch (n){
                case 'e':
                    estado="q149";
                    break;
                default:
                    estado="q0";
                    break;
            }

            return 0;
        }
        if(estado.equals("q149")){
            switch (n){
                case 'd':
                    escribir(palabra+ ". " +_PACKED.toString().toLowerCase() +" (" + linea + "," +(columna - 4) + ")",2);
                    contar(_PACKED);
                    palabra++;
                    estado="q150";
                    break;
                default:
                    estado="q0";
                    break;
            }
            return 0;
        }

        if (estado.equals("q150")) {
            estado = "q0";
            return 0;
        }

        return -1;
    }



    private void escribir(String j,int ref){
        if(ref==1){
            try(PrintWriter escritor=new PrintWriter(new FileWriter(this.historial,true),true)){
                escritor.println(j);
            }catch (IOException e){
                e.printStackTrace();
            }
        }else{
            id++;
            try(PrintWriter escritor=new PrintWriter(new FileWriter(this.out,true),true)){
                if(bandera){
                    escritor.println("EL FORMATO ES EL SIGUIENTE palabra (renglon,columna) \nLAS PALABRAS ENCONTRADAS SON:");
                    bandera=false;
                }
                if(id==5){
                    escritor.println(j);
                    id=0;
                }else{
                    escritor.print(j);
                    escritor.print("        ");
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

                        //CONTINUE
    public void contar(Tokens ref){
        if(cont.containsKey(ref.toString().toLowerCase())){
            int val=cont.get(ref.toString().toLowerCase())+1;
            cont.replace(ref.toString().toLowerCase(),cont.get(ref.toString().toLowerCase()),val);
        }else{
            cont.put(ref.toString().toLowerCase(),1);
        }

    }

    public void mostrar(){
        escribir("\n\n\n*******************************PALABRAS ENCONTRADAS Y COINCIDENCIAS*************************" ,2);
        for (String clave:cont.keySet()) {
            int valor = cont.get(clave);
            escribir("\nPALABRA : " + clave + ", encontradas : " + valor,2);
        }
    }
}
