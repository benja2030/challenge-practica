import java.io.*;


public class WriteAndRead {

    static int size;
    
    // Genera archivo .txt con numeros aleatorios.
    static void TextGenerator(String path) throws IOException{
        FileWriter writer = new FileWriter(path);
        try{
            //FileWriter writer = new FileWriter(path);
            for(int i = 0; i < size; i++){
                writer.write(Integer.toString((int)((Math.random()*(size-1))+1))+"\n");
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally{
            writer.close();
        }
        System.out.println("\nSe genero un archivo");
    }

    // Lee archivo .txt
    static void TextReader(String path) throws IOException{
        FileReader reader = new FileReader(path);
        try{
            //FileReader reader = new FileReader(path);
            int line;
            System.out.println("\n");
            while((line = reader.read())!= -1){ //Continua leyendo hasta que el metodo read retorne -1.
                System.out.print((char)line+"");
            }
        }
        catch (FileNotFoundException e){
            System.out.println("\nEl archivo no existe");
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally{
            reader.close();
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
