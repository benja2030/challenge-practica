import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Menu {

    static void menu(String fileName, String sortedFileName) throws IOException{
        int option;
        while(true){
            System.out.println("\n\nOpciones\n-------------------"+
            "\n0 - Menu\n1 - Generar nuevo archivo\n2 - Leer archivo"+
            "\n3 - Ordenar archivo\n4 - Leer archivo ordenado"+
            "\n5 - Buscar numero en archivo\n6 - Salir");
            System.out.print("Escriba el numero de la opción (1-6): ");

            option = VerifyInput();
            switch(option){
                // Vuelve al menú.
                case 0: 
                continue;

                // Genera un archivo aleatorio nuevo.
                case 1:
                System.out.print("Escriba la cantidad de numeros: ");
                WriteAndRead.size = VerifyInput();
                WriteAndRead.TextGenerator(fileName);
                continue;

                // Lee el archivo aleatorio.
                case 2:
                WriteAndRead.TextReader(fileName);
                continue;

                // Ordena el archivo aleatorio.
                case 3: 
                int[] array = WriteAndRead.TextToArray(fileName);
                if (array != null)
                    SortSelection(array, sortedFileName);
                continue;

                // Lee el archivo ordenado.
                case 4: 
                WriteAndRead.TextReader(sortedFileName);
                continue;
                
                // Busca un número en el archivo ordenado.
                case 5: 
                SearchNumber(sortedFileName);
                continue;                                                                 
        }
        break;
        }
    }

    private static int VerifyInput(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try{
            int intInput = Integer.parseInt(input);
            return intInput;
        }catch (NumberFormatException e){
            System.out.print("Ingrese un numero\n");
            return VerifyInput();
        }
    }

    // Menú para la elección de algoritmos.
    private static void SortSelection(int[] array, String name) throws IOException{

        System.out.println("-- Algoritmos de ordenamiento --\n\t1 - Merge Sort\n\t2 - Bubble Sort\n");
        System.out.print("Seleccione el metodo de ordenamiento: ");
        int option = VerifyInput();
        Sorting.SortFile(array, name, option);
    }

    // Busca un número en un archivo .txt
    // e imprime las posiciones en la terminal.
    private static void SearchNumber(String name){

        // Lee y copia el archivo .txt dado a un arreglo.
        int[] array = WriteAndRead.TextToArray(name);
        // Verifica si se copio el arreglo.
        if (array == null)
            return;

        System.out.print("\nEscoga un numero: ");
        int number = VerifyInput();
        String positions = "";

        // Guarda las posiciones.
        for (int i = 0; i < array.length; i++){
            if (array[i] == number)
                positions += (Integer.toString(i+1))+" ";
        }

        // Condición en caso de que no exista el número.
        if (Objects.equals(positions, "")){
            System.out.println("No existe el numero en el archivo");
            return;
        }
        System.out.println("El numero "+ number +" se encuentra en la(s) linea(s): "+ positions);
    }
}
