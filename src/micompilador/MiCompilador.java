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
import java.util.Map;

/**
 *
 * @author yurgencm
 */
public class MiCompilador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length < 2) {
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

        // Deshabilitar mensajes de error por consola default, se crea uno propio que cuenta errores
        lexer.removeErrorListeners();
        CountingErrorListener errorListener = new CountingErrorListener();
        lexer.addErrorListener(errorListener);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        tokens.fill();

        // Verificar si hubo errores léxicos
        if (errorListener.hasErrors()) {
            System.out.println("Errores encontrados durante el analisis lexico. Terminando programa.");
            guardarArchivo(args[1], generarTokensParaGuardar(tokens), "Errores encontrados durante el analisis lexico.", "");
            return;
        }
        System.out.println("Confirmacion [Fase Lexica]: Analisis lexico completado con exito.");
        
        // Análisis sintáctico
        LenguajeL2Parser parser = new LenguajeL2Parser(tokens);
        ParseTree tree = parser.programa();

        // Verificar si hubo errores sintácticos
        if (parser.getNumberOfSyntaxErrors() > 0) {
            System.out.println("Errores encontrados durante el analisis sintactico. Terminando programa.");
            guardarArchivo(args[1], generarTokensParaGuardar(tokens), generarASTParaGuardar(tree, parser), "Errores encontrados durante el analisis semantico.");
            return;
        }
        System.out.println("Confirmacion [Fase Sintactica]: Analisis sintactico completado con exito.");

        // Análisis semántico
        LenguajeL2SemanticAnalyzer analyzer = new LenguajeL2SemanticAnalyzer();
        analyzer.visit(tree);
        Map<String, Boolean> tablaSimbolos = analyzer.getTablaSimbolos();

        // Verificar si hubo errores semánticos
        if (analyzer.hasErrors()) {
            System.out.println("Errores encontrados durante el analisis semantico. Terminando programa.");

            // Guardar en archivo
            guardarArchivo(args[1], generarTokensParaGuardar(tokens), generarASTParaGuardar(tree, parser), generarTablaSimbolos(tablaSimbolos) + "\n\nErrores encontrados durante el analisis semantico.");
            return;
        }
        System.out.println("Confirmacion [Fase Semantica]: Analisis semantico completado con exito.");
        // Guardar en archivo
        guardarArchivo(args[1], generarTokensParaGuardar(tokens), generarASTParaGuardar(tree, parser), generarTablaSimbolos(tablaSimbolos));
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

    // Genera los tokens para guardar
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

    // Genera el AST para guardar
    private static String generarASTParaGuardar(ParseTree tree, LenguajeL2Parser parser) {
        return "=== AST ===\n" + tree.toStringTree(parser);
    }

    // Genera la tabla de símbolos para guardar
    private static String generarTablaSimbolos(Map<String, Boolean> tablaSimbolos) {
        StringBuilder builder = new StringBuilder();
        builder.append("=== Tabla de Símbolos ===\n");
        for (Map.Entry<String, Boolean> entry : tablaSimbolos.entrySet()) {
            builder.append("Variable: ")
                   .append(entry.getKey())
                   .append(", Declarada: ")
                   .append(entry.getValue())
                   .append("\n");
        }
        return builder.toString();
    }

    // Guarda el archivo de salida
    private static void guardarArchivo(String archivoGuardado, String tokensStr, String astStr, String tablaSimbolos) {
        try {
            String contenido = tokensStr + "\n\n" + astStr + "\n\n" + tablaSimbolos;
            Files.write(Paths.get(archivoGuardado), contenido.getBytes());
            System.out.println("Datos guardados en: " + archivoGuardado);
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        }
    }
    
}
