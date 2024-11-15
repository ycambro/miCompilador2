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
        try {
            String input = new String(Files.readAllBytes(Paths.get("C:\\Users\\nuryb\\OneDrive\\Documentos\\NetBeansProjects\\miCompilador\\src\\micompilador\\test.txt")));
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
        } catch (IOException e) {
            System.err.println("Error al leer el archivo pruebas.txt: " + e.getMessage());
        }
    }
    
}
