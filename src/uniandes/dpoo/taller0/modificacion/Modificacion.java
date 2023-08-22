package uniandes.dpoo.taller0.modificacion;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import uniandes.dpoo.taller0.procesamiento.CalculadoraEstadisticas;
import uniandes.dpoo.taller0.procesamiento.LoaderOlimpicos;



public class Modificacion {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Solicita al usuario ingresar la ruta del archivo
        String rutadelArchivo = input("Por favor ingrese la ruta del archivo CSV con los atletas");
        
        // Carga de datos
        CalculadoraEstadisticas calculadora = cargarArchivoAtletas(rutadelArchivo);
        
        // Se imprime la carga del archivo
        if (calculadora != null) {
            System.out.println("Se cargó el archivo " + rutadelArchivo + " con información de los Juegos Olímpicos.");
            System.out.println("===================================");
        }
        
        // Realiza el cálculo y muestra el país con más medallistas
        if (calculadora != null) {
            Map<String, Integer> paisConMasMedallistas = calculadora.paisConMasMedallistas();
            System.out.println("===================================");
            System.out.println("País con más medallistas: " + paisConMasMedallistas);
        }
    }
    
    //basado en ConsolaOlimpicos se realizó esto para imprimir mensajes de error y 
    //usar lo indicado en el taller

    private static CalculadoraEstadisticas cargarArchivoAtletas(String archivo) {
        try {
            CalculadoraEstadisticas calculadora = LoaderOlimpicos.cargarArchivo(archivo);
            return calculadora;
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: el archivo indicado no se encontró.");
            return null;
        } catch (IOException e) {
            System.out.println("ERROR: hubo un problema leyendo el archivo.");
            System.out.println(e.getMessage());
            return null;
        }
    }
//para poder usar input
    private static String input(String mensaje) {
        try {
            System.out.print(mensaje + ": ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            return reader.readLine();
        } catch (IOException e) {
            System.out.println("Error leyendo de la consola");
            e.printStackTrace();
            return null;
        }
    }
}
