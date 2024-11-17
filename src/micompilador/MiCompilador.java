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

        String input = leerArchivo("test.txt");
        if (input == null || input.isEmpty()) {
            return;
        }
        
        CharStream charStream = CharStreams.fromString(input);

        // Análisis léxico
        LenguajeL2Lexer lexer = new LenguajeL2Lexer(charStream);

        // Deshabilitar mensajes de error por consola y crear contador de errores
        lexer.removeErrorListeners();
        CountingErrorListener errorListener = new CountingErrorListener();
        lexer.addErrorListener(errorListener);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        tokens.fill();

        // Verificar si hubo errores
        if (errorListener.hasErrors()) {
            System.out.println("Errores encontrados durante el analisis lexico. Terminando programa.");
            return;
        }
        System.out.println("Confirmacion [Fase Lexica]: Analisis lexico completado con exito.");
        
        // Análisis sintáctico
        LenguajeL2Parser parser = new LenguajeL2Parser(tokens);
        ParseTree tree = parser.programa();

        // Verificar si hubo errores
        if (parser.getNumberOfSyntaxErrors() > 0) {
            System.out.println("Errores encontrados durante el analisis sintactico. Terminando programa.");
            return;
        }
        System.out.println("Confirmacion [Fase Sintactica]: Analisis sintactico completado con exito.");

        // Análisis semántico
        LenguajeL2SemanticAnalyzer analyzer = new LenguajeL2SemanticAnalyzer();
        analyzer.visit(tree);

        if (analyzer.hasErrors()) {
            System.out.println("Errores encontrados durante el analisis semantico. Terminando programa.");
            return;
        }
        System.out.println("Confirmacion [Fase Semantica]: Analisis semantico completado con exito.");

        // Guardar en archivo
        guardarArchivo(args[1], generarTokensParaGuardar(tokens), generarASTParaGuardar(tree, parser));
    }
    
    // Lee el archivo de entrada
    private static String leerArchivo(String rutaArchivo) {
        try {
            return new String(Files.readAllBytes(Paths.get(rutaArchivo)));
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return null;
        }
    }

    private static String generarTokensParaGuardar(CommonTokenStream tokens) {
        StringBuilder builder = new StringBuilder();
        builder.append("=== Tokens ===\n");
        for (Token token : tokens.getTokens()) {
            builder.append("Token: ")
                   .append(token.getText())
                   .append(", Tipo: ")
                   .append(token.getType())
                   .append(", Línea: ")
                   .append(token.getLine())
                   .append(", Posición: ")
                   .append(token.getCharPositionInLine())
                   .append("\n");
        }
        return builder.toString();
    }

    private static String generarASTParaGuardar(ParseTree tree, LenguajeL2Parser parser) {
        return "=== AST ===\n" + tree.toStringTree(parser);
    }

    // Guarda el archivo de salida
    private static void guardarArchivo(String archivoGuardado, String tokensStr, String astStr) {
        try {
            String contenido = tokensStr + "\n\n" + astStr;
            Files.write(Paths.get(archivoGuardado), contenido.getBytes());
            System.out.println("Datos guardados en: " + archivoGuardado);
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        }
    }
    
}
