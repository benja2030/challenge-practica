import java.io.*;


public class WriteAndRead {

    static int size;
    
    // Genera archivo .txt con numeros aleatorios.
    static void TextGenerator(String name){
        try{
            FileWriter writer = new FileWriter(name);
            for(int i = 0; i < size; i++){
                writer.write(Integer.toString((int)((Math.random()*(size-1))+1))+"\n");
            }
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("\nSe genero un archivo");
    }

    // Lee archivo .txt
    static void TextReader(String path){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            System.out.println("\n");
            while((line = reader.readLine())!= null){
                System.out.print(line+" ");
            }
            reader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("\nEl archivo no existe");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    // Transfiere contenido de archivo .txt
    // a un arreglo de numeros enteros.
    static int[] TextToArray(String path){
        int[] array = new int[size];
        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();
            for(int i = 0 ; i < size ; i++){
                array[i] = Integer.parseInt(line);
                line = reader.readLine();
            }
            reader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("\nEl archivo no existe");
            return null;
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return array;
    }
}
