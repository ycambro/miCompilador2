// Generated from LenguajeL2.g4 by ANTLR 4.9.2
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LenguajeL2Parser}.
 */
public interface LenguajeL2Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LenguajeL2Parser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(LenguajeL2Parser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeL2Parser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(LenguajeL2Parser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LenguajeL2Parser#declaraciones}.
	 * @param ctx the parse tree
	 */
	void enterDeclaraciones(LenguajeL2Parser.DeclaracionesContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeL2Parser#declaraciones}.
	 * @param ctx the parse tree
	 */
	void exitDeclaraciones(LenguajeL2Parser.DeclaracionesContext ctx);
	/**
	 * Enter a parse tree produced by {@link LenguajeL2Parser#declaracion}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracion(LenguajeL2Parser.DeclaracionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeL2Parser#declaracion}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracion(LenguajeL2Parser.DeclaracionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LenguajeL2Parser#control_flujo}.
	 * @param ctx the parse tree
	 */
	void enterControl_flujo(LenguajeL2Parser.Control_flujoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeL2Parser#control_flujo}.
	 * @param ctx the parse tree
	 */
	void exitControl_flujo(LenguajeL2Parser.Control_flujoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LenguajeL2Parser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void enterIf_stmt(LenguajeL2Parser.If_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeL2Parser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void exitIf_stmt(LenguajeL2Parser.If_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LenguajeL2Parser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhile_stmt(LenguajeL2Parser.While_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeL2Parser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhile_stmt(LenguajeL2Parser.While_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LenguajeL2Parser#for_stmt}.
	 * @param ctx the parse tree
	 */
	void enterFor_stmt(LenguajeL2Parser.For_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeL2Parser#for_stmt}.
	 * @param ctx the parse tree
	 */
	void exitFor_stmt(LenguajeL2Parser.For_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LenguajeL2Parser#impresion}.
	 * @param ctx the parse tree
	 */
	void enterImpresion(LenguajeL2Parser.ImpresionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeL2Parser#impresion}.
	 * @param ctx the parse tree
	 */
	void exitImpresion(LenguajeL2Parser.ImpresionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LenguajeL2Parser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExpresion(LenguajeL2Parser.ExpresionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeL2Parser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExpresion(LenguajeL2Parser.ExpresionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LenguajeL2Parser#operador_aditivo}.
	 * @param ctx the parse tree
	 */
	void enterOperador_aditivo(LenguajeL2Parser.Operador_aditivoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeL2Parser#operador_aditivo}.
	 * @param ctx the parse tree
	 */
	void exitOperador_aditivo(LenguajeL2Parser.Operador_aditivoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LenguajeL2Parser#operador_multiplicativo}.
	 * @param ctx the parse tree
	 */
	void enterOperador_multiplicativo(LenguajeL2Parser.Operador_multiplicativoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeL2Parser#operador_multiplicativo}.
	 * @param ctx the parse tree
	 */
	void exitOperador_multiplicativo(LenguajeL2Parser.Operador_multiplicativoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LenguajeL2Parser#operador_relacional}.
	 * @param ctx the parse tree
	 */
	void enterOperador_relacional(LenguajeL2Parser.Operador_relacionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeL2Parser#operador_relacional}.
	 * @param ctx the parse tree
	 */
	void exitOperador_relacional(LenguajeL2Parser.Operador_relacionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link LenguajeL2Parser#numero}.
	 * @param ctx the parse tree
	 */
	void enterNumero(LenguajeL2Parser.NumeroContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeL2Parser#numero}.
	 * @param ctx the parse tree
	 */
	void exitNumero(LenguajeL2Parser.NumeroContext ctx);
	/**
	 * Enter a parse tree produced by {@link LenguajeL2Parser#digito}.
	 * @param ctx the parse tree
	 */
	void enterDigito(LenguajeL2Parser.DigitoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeL2Parser#digito}.
	 * @param ctx the parse tree
	 */
	void exitDigito(LenguajeL2Parser.DigitoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LenguajeL2Parser#identificador}.
	 * @param ctx the parse tree
	 */
	void enterIdentificador(LenguajeL2Parser.IdentificadorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeL2Parser#identificador}.
	 * @param ctx the parse tree
	 */
	void exitIdentificador(LenguajeL2Parser.IdentificadorContext ctx);
	/**
	 * Enter a parse tree produced by {@link LenguajeL2Parser#letra}.
	 * @param ctx the parse tree
	 */
	void enterLetra(LenguajeL2Parser.LetraContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeL2Parser#letra}.
	 * @param ctx the parse tree
	 */
	void exitLetra(LenguajeL2Parser.LetraContext ctx);
}