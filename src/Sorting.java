import java.io.FileWriter;
import java.io.IOException;

public class Sorting {
    
    // Ordena un arreglo y genera un archivo .txt
    static void SortFile(int[] array, String path, int option) throws IOException{
        long startTime;
        long endTime;
        long elapsedTime;

        startTime = System.nanoTime();
        switch(option){
            case 1:
            MergeSort(array);
            case 2:
            BubbleSort(array);
        }
        endTime = System.nanoTime();
        elapsedTime = (endTime - startTime)/(1000000);
        System.out.println("Tiempo transcurrido: " + elapsedTime + " milisegundos.");
        FileWriter writer = new FileWriter(path);
        try{
            //FileWriter writer = new FileWriter(path);
            for(int i = 0; i < array.length; i++){
                writer.write(array[i]+"\n");
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally{
            writer.close();
        }
        System.out.println("Se genero un archivo ordenado");
    }
    
    // Algoritmo de ordenamiento por mezcla.
    private static void MergeSort(int[] array){
        
        int length = array.length;
        if (length <= 1) return; //caso base

        int middle = length / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];

        int i = 0; //arreglo izquierdo.
        int j = 0; //arreglo derecho.

        // Copia elementos del arreglo original
        // al arreglo izquierdo y derecho.
        for(; i < length; i++){
            if(i < middle){
                leftArray[i] = array[i];
            }
            else{
                rightArray[j] = array[i];
                j++;
            }
        }
        MergeSort(leftArray);
        MergeSort(rightArray);
        Merge(leftArray, rightArray, array);
    }

    private static void Merge(int[] leftArray, int[] rightArray, int[] array){
        
        int leftSize = array.length / 2;
        int rightSize = array.length - leftSize;
        int i = 0;
        int l = 0;
        int r = 0;

        // Revisa que queden elementos para la mezcla.
        while(l < leftSize && r < rightSize){
            if(leftArray[l] < rightArray[r]){
                array[i] = leftArray[l];
                i++;
                l++;
            }
            else{
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }
        // Inserta elementos restantes.
        while(l < leftSize){
            array[i] = leftArray[l];
            i++;
            l++;
        }
        while (r < rightSize) {
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }

    // Algoritmo de ordenamiento Burbuja.
    private static void BubbleSort(int[] array){
        for(int i = 0 ; i < array.length - 1 ; i++){
            for(int j = 0 ; j < array.length - 1 ; j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }


}


