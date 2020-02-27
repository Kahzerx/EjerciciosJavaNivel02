/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios2;

/**
 *
 * @author kahzerx
 */
public class Ejercicios2 {
    
    char [][] listaPalabras = {{'P', 'A', 'T', 'A'},{'P', 'A', 'T', 'O'},{'R', 'A', 'T', 'O'},{'R', 'A', 'M', 'O'},{'G', 'A', 'M', 'O'},{'G', 'A', 'T', 'O'},{'M', 'A', 'T', 'O'},};

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
            if (uno.charAt(i) == 'A'){
                if (dos.charAt(i) == '-') counter += 2;
                else if (dos.charAt(i) != 'T') counter ++;
            }
            else if (uno.charAt(i) == 'C'){
                if (dos.charAt(i) == '-') counter += 2;
                else if (dos.charAt(i) != 'G'){
                    counter++;
                }
            }
            else if (uno.charAt(i) == 'T'){
                if (dos.charAt(i) == '-') counter += 2;
                else if (dos.charAt(i) != 'A'){
                    counter++;
                }
            }
            else if (uno.charAt(i) == 'G'){
                if (dos.charAt(i) == '-') counter += 2;
                else if (dos.charAt(i) != 'C'){
                    counter++;
                }
            }
            else if (uno.charAt(i) == '-'){
                counter += 2;
            }
        }
        return counter;
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
    }
    
}
