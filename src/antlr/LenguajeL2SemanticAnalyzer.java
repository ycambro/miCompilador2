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
    private final Map<String, Boolean> symbolTable = new HashMap<>();
    private String ultimaDeclarada;
    private int veces = 0;
    private int errores = 0;
    
    // Visitamos la regla de declaración en asignación
    @Override
    public Void visitDeclaracion(LenguajeL2Parser.DeclaracionContext ctx) {
        // Si es una expresión de tipo "identificador = expresion"
        if (ctx.expresion() != null && ctx.getText().contains("=")) {
            ultimaDeclarada = null;
            ParseTree firstChild = ctx.expresion().getChild(0);
            while (firstChild.getText().contains("=")) {
                firstChild = firstChild.getChild(0);
            }
            String varName = firstChild.getText();
            if (!symbolTable.containsKey(varName)) {
                symbolTable.put(varName, true);  // Guardamos la variable como declarada
                ultimaDeclarada = varName;
            } else {
                ultimaDeclarada = "";
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
        // Verificar si la expresión contiene un identificador
        if (ctx.identificador() != null) {
            String varName = ctx.identificador().getText();
            if (!symbolTable.containsKey(varName) || (varName.equals(ultimaDeclarada) && veces > 0)) {
                reportarError("Undeclared variable '" + varName + "'");
            }
            if (varName.equals(ultimaDeclarada)) {
                veces ++;
            }
        }
        if (ctx.expresion() != null && ctx.getText().contains("/")) {
            ParseTree secondChild = ctx.getChild(2);
            if (secondChild.getText().equals("0")) {
                reportarError("Division by zero");
            }
        }
        return visitChildren(ctx);
    }

    // Verificar que la variable en "print" esté declarada
    @Override
    public Void visitImpresion(LenguajeL2Parser.ImpresionContext ctx) {
        String varName = ctx.identificador().getText();
        if (!symbolTable.containsKey(varName)) {
            reportarError("Undeclared variable in print '" + varName + "'");
        }
        return visitChildren(ctx);
    }
    
    public void reportarError(String msg) {
        System.err.println(msg + "\n");
        errores ++;
    }

    public boolean hasErrors() {
        return errores > 0;
    }

    // Método para depuración opcional: Imprimir la tabla de símbolos
    public void printSymbolTable() {
        System.out.println("Tabla de Símbolos: " + symbolTable);
    }
}

