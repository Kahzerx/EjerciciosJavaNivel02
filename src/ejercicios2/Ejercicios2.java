/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios2;

import java.util.Arrays;

/**
 *
 * @author kahzerx
 */
public class Ejercicios2 {
    
    char [][] listaPalabras = {{'P', 'A', 'T', 'A'},{'P', 'A', 'T', 'O'},{'R', 'A', 'T', 'O'},{'R', 'A', 'M', 'O'},{'G', 'A', 'M', 'O'},{'G', 'A', 'T', 'O'},{'M', 'A', 'T', 'O'}};
    boolean[][] camion = {
            {true, true, true, false, false, true, true, true},
            {true, true, true, false, false, true, true, true},
            {true, true, true, false, false, true, true, true},
            {true, true, true, true, true, true, false, false},
            {true, true, true, true, true, true, false, false}};

    public boolean Escalera (char [][] lista){
        if (lista.length < 2) return false;
        
        for (int i = 0; i < lista.length - 1; i++){//palabras
            int counter = 0;//contador
            if (lista[i].length == lista[i + 1].length){//lenght de cada palabra
                for(int j = 0; j < lista[i].length; j++){//comprueba todas las letras
                    if (lista[i][j] != lista[i + 1][j]){
                        counter++;
                    }
                }
                if(counter != 1){
                    return false;
                }
            }
            else{
                return false;
            }
        }
        return true;
    }
    
    private int costeErroresADN(String uno, String dos){
        int counter = 0;
        
        if (uno.length() != dos.length()) System.out.println("no son de la misma lingitud ;( ");

        for (int i = 0; i < uno.length();i++){
            switch (uno.charAt(i)) {
                case 'A':
                    if (dos.charAt(i) == '-') counter += 2;
                    else if (dos.charAt(i) != 'T') counter ++;
                    break;
                case 'C':
                    if (dos.charAt(i) == '-') counter += 2;
                    else if (dos.charAt(i) != 'G'){
                        counter++;
                    }   break;
                case 'T':
                    if (dos.charAt(i) == '-') counter += 2;
                    else if (dos.charAt(i) != 'A'){
                        counter++;
                    }   break;
                case 'G':
                    if (dos.charAt(i) == '-') counter += 2;
                    else if (dos.charAt(i) != 'C'){
                        counter++;
                    }   break;
                case '-':
                    counter += 2;
                    break;
                default:
                    break;
            }
        }
        return counter;
    }


    private boolean cabeUnaCaja (boolean [][] camion, int lado1, int lado2){

        int k;
        int m;

        for (int t = 0; t < 2; t++){
            for (int i = 0; i < camion.length; i++){
                for (int j = 0; j<camion[0].length;j++){
                    k = 0;
                    while ((i + k)<camion.length && !camion[i + k][j] && k < lado2){

                        m=0;
                        while ((j + m)<camion[0].length && !camion[i + k][j + m] && m < lado1){
                            m++;
                        }
                        if (m != lado1){
                            k = lado2;
                        }
                        k++;
                    }
                    if (k == lado2){ // hueco encontrado
                        if(t == 1){
                            System.out.print("Girada, ");
                        }
                        System.out.println("la caja cabe en: " + i + " " + j);
                        return true;
                    }
                }
            }
            int x = lado1;

            lado1 = lado2;
            lado2 = x;

        }
        System.out.println("La caja no cabe");
        return false;

    }

    private int strStr (String str1, String str2){
        for (int i = 0; i < str1.length(); i++){
            if (str1.charAt(i) == str2.charAt(0)){
                if (i + str2.length() - 1 < str1.length()){
                    int counter = 0;
                    for (int j = 0; j < str2.length(); j++){
                        if (str1.charAt(i + j) == str2.charAt(j)){
                            counter++;
                        }
                    }
                    if (counter == str2.length()) return i;
                }
            }
        }
        return -1;
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Ejercicios2 ejercicios = new Ejercicios2();
        
        System.out.println("======Escalera de palabras======");
        
        System.out.println(ejercicios.Escalera(ejercicios.listaPalabras));
        
        System.out.println("======ADN=====");
        
        System.out.println(ejercicios.costeErroresADN("GGGA-GAATCTCTGGACT", "CCCTACTTA-AGACCGGT"));

        System.out.println("======Mudanzas java=====");

        System.out.println(ejercicios.cabeUnaCaja(ejercicios.camion, 2, 2));

        System.out.println("======strStr=====");

        System.out.println(ejercicios.strStr("tawdsdwdwdatadtestawdiaot", "test"));
    }
    
}
