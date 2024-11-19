/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package antlr;

/**
 *
 * @author yurgencm
 */
import java.util.HashMap;
import java.util.Map;
import org.antlr.v4.runtime.tree.ParseTree;

public class LenguajeL2SemanticAnalyzer extends LenguajeL2BaseVisitor<Void> {
    private Map<String, Boolean> tablaSimbolos = new HashMap<>();
    private String ultimaDeclarada;
    private int veces = 0;
    private int errores = 0;
    
    // Visitamos la regla de declaración en asignación
    @Override
    public Void visitDeclaracion(LenguajeL2Parser.DeclaracionContext ctx) {
        // Si es una expresión de tipo "identificador = expresion"
        if (ctx.expresion() != null && ctx.getText().contains("=")) {
            ParseTree primerHijo = ctx.expresion().getChild(0);

            // Buscamos el identificador de la expresión esto en caso de que sea una expresión muy grande
            while (primerHijo.getText().contains("=")) {
                primerHijo = primerHijo.getChild(0);
            }

            String nombreIdentificador = primerHijo.getText(); // Obtenemos el nombre de la variable
            if (!tablaSimbolos.containsKey(nombreIdentificador)) {
                tablaSimbolos.put(nombreIdentificador, true);  // Guardamos la variable como declarada
                ultimaDeclarada = nombreIdentificador;
            } else {
                ultimaDeclarada = ""; // Si la variable ya está declarada, no se guarda y no hay problemas
            }
            veces = 0;
        } else if (!ctx.getText().contains("=")) {
            ultimaDeclarada = "";
        }
        return visitChildren(ctx);
    }

    // Visitamos las expresiones para verificar el uso de variables
    @Override
    public Void visitExpresion(LenguajeL2Parser.ExpresionContext ctx) {
        // Se verifica si la expresión contiene un identificador
        if (ctx.identificador() != null) {
            String nombreIdentificador = ctx.identificador().getText();
            if (!tablaSimbolos.containsKey(nombreIdentificador)) {
                reportarError("Undeclared variable '" + nombreIdentificador + "'");
            }
            if (nombreIdentificador.equals(ultimaDeclarada) && veces > 0) {
                tablaSimbolos.replace(nombreIdentificador, false);
                reportarError("Variable '" + nombreIdentificador + "' is being used before being declared");
            }
            if (nombreIdentificador.equals(ultimaDeclarada)) {
                veces ++;
            }
        }
        // Se verifica si la expresión contiene una división por cero
        if (ctx.expresion() != null && ctx.getText().contains("/")) {
            ParseTree segundoHijo = ctx.getChild(2);
            if (segundoHijo.getText().equals("0")) {
                reportarError("Division by zero");
            }
        }
        return visitChildren(ctx);
    }

    // Se verifica que la variable en "print" esté declarada
    @Override
    public Void visitImpresion(LenguajeL2Parser.ImpresionContext ctx) {
        String nombreIdentificador = ctx.identificador().getText();
        if (!tablaSimbolos.containsKey(nombreIdentificador)) {
            reportarError("Undeclared variable in print '" + nombreIdentificador + "'");
        }
        return visitChildren(ctx);
    }
    
    // Método para reportar errores
    public void reportarError(String msg) {
        System.err.println(msg);
        errores ++;
    }

    // Verificar si hubo errores
    public boolean hasErrors() {
        return errores > 0;
    }

    // Método para imprimir la tabla de símbolos
    public void printTablaSimbolos() {
        System.out.println("Tabla de Símbolos: " + tablaSimbolos);
    }

    public Map<String, Boolean> getTablaSimbolos() {
        return tablaSimbolos;
    }

}

