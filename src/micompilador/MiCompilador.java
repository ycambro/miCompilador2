/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package micompilador;
import antlr.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author yurgencm
 */
public class MiCompilador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Uso: [NOMBRE DEL PROGRAMA] [ARCHIVO DE ENTRADA] [ARCHIVO DE SALIDA]");
            return;
        }

        String input = leerArchivo(args[0]);
        if (input == null || input.isEmpty()) {
            return;
        }
        
        CharStream charStream = CharStreams.fromString(input);

        // Análisis léxico
        LenguajeL2Lexer lexer = new LenguajeL2Lexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        System.out.println("Confirmacion [Fase Lexica]: Analisis lexico completado con exito.");

        // Análisis sintáctico
        LenguajeL2Parser parser = new LenguajeL2Parser(tokens);
        ParseTree tree = parser.programa();
        System.out.println("Confirmacion [Fase Sintactica]: Analisis sintactico completado con exito.");
        
        // Imprimir el AST
        //System.out.println(tree.toStringTree(parser));

        if (parser.getNumberOfSyntaxErrors() == 0) {
            // Análisis semántico
            LenguajeL2SemanticAnalyzer analyzer = new LenguajeL2SemanticAnalyzer();
            analyzer.visit(tree);
            System.out.println("Confirmacion [Fase Semantica]: Analisis semantico completado con exito.");
        } else {
            System.out.println("Se encontraron errores de sintaxis; no se ejecutara el analisis semantico.");
        }
    }
    
    // Lee el archivo de entrada
    private static String leerArchivo(String rutaArchivo) {
        try {
            return new String(Files.readAllBytes(Paths.get(rutaArchivo)));
        } catch (IOException e) {
            System.out.println("Intentando leer archivo desde la ruta: " + Paths.get(rutaArchivo).toAbsolutePath());
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return null;
        }
    }

    // Guarda el archivo de salida
    private static void guardarArchivo(String archivoGuardado, String contenido) {
        try {
            Files.write(Paths.get(archivoGuardado), contenido.getBytes());
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        }
    }
    
}
