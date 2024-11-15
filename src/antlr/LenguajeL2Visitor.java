// Generated from LenguajeL2.g4 by ANTLR 4.9.2
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LenguajeL2Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LenguajeL2Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LenguajeL2Parser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(LenguajeL2Parser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LenguajeL2Parser#declaraciones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaraciones(LenguajeL2Parser.DeclaracionesContext ctx);
	/**
	 * Visit a parse tree produced by {@link LenguajeL2Parser#declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracion(LenguajeL2Parser.DeclaracionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LenguajeL2Parser#control_flujo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControl_flujo(LenguajeL2Parser.Control_flujoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LenguajeL2Parser#if_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_stmt(LenguajeL2Parser.If_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LenguajeL2Parser#while_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_stmt(LenguajeL2Parser.While_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LenguajeL2Parser#for_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_stmt(LenguajeL2Parser.For_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LenguajeL2Parser#impresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImpresion(LenguajeL2Parser.ImpresionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LenguajeL2Parser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresion(LenguajeL2Parser.ExpresionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LenguajeL2Parser#operador_aditivo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperador_aditivo(LenguajeL2Parser.Operador_aditivoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LenguajeL2Parser#operador_multiplicativo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperador_multiplicativo(LenguajeL2Parser.Operador_multiplicativoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LenguajeL2Parser#operador_relacional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperador_relacional(LenguajeL2Parser.Operador_relacionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link LenguajeL2Parser#numero}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumero(LenguajeL2Parser.NumeroContext ctx);
	/**
	 * Visit a parse tree produced by {@link LenguajeL2Parser#digito}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDigito(LenguajeL2Parser.DigitoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LenguajeL2Parser#identificador}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentificador(LenguajeL2Parser.IdentificadorContext ctx);
	/**
	 * Visit a parse tree produced by {@link LenguajeL2Parser#letra}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetra(LenguajeL2Parser.LetraContext ctx);
}