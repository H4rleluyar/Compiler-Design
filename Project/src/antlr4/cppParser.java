// Generated from C:/Users/kevin/Downloads/CS153-Project/grammar/cpp.g4 by ANTLR 4.13.1

    package antlr4;
    import java.util.HashMap;
    import intermediate.symtab.SymtabEntry;
    import intermediate.type.Typespec;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class cppParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		DIR_INCLUDE=25, MAIN=26, CONST=27, TYPE=28, ARRAY=29, OF=30, RECORD=31, 
		VAR=32, END=33, DIV=34, MOD=35, AND=36, OR=37, NOT=38, IF=39, THEN=40, 
		ELSE=41, UNTIL=42, WHILE=43, DO=44, FOR=45, TO=46, DOWNTO=47, COUT=48, 
		WRITELN=49, READ=50, READLN=51, PROCEDURE=52, FUNCTION=53, RETURN=54, 
		IDENTIFIER=55, INT=56, DOUBLE=57, NEWLINE=58, WS=59, QUOTE=60, CHARACTER=61, 
		STRING=62, COMMENT=63;
	public static final int
		RULE_program = 0, RULE_programHeader = 1, RULE_programParameters = 2, 
		RULE_programIdentifier = 3, RULE_intMain = 4, RULE_block = 5, RULE_declarations = 6, 
		RULE_variablesPart = 7, RULE_variableDeclarationsList = 8, RULE_variableDeclarations = 9, 
		RULE_variableIdentifierList = 10, RULE_variableIdentifier = 11, RULE_constantsPart = 12, 
		RULE_constantDefinitionsList = 13, RULE_constantDefinition = 14, RULE_constantIdentifier = 15, 
		RULE_constant = 16, RULE_sign = 17, RULE_typesPart = 18, RULE_typeDefinitionsList = 19, 
		RULE_typeDefinition = 20, RULE_typeIdentifier = 21, RULE_typeSpecification = 22, 
		RULE_simpleType = 23, RULE_enumerationType = 24, RULE_enumerationConstant = 25, 
		RULE_subrangeType = 26, RULE_arrayType = 27, RULE_arrayDimensionList = 28, 
		RULE_recordType = 29, RULE_recordFields = 30, RULE_routinesPart = 31, 
		RULE_routineDefinition = 32, RULE_procedureHead = 33, RULE_functionHead = 34, 
		RULE_returnStatement = 35, RULE_routineIdentifier = 36, RULE_parameters = 37, 
		RULE_parameterDeclarationsList = 38, RULE_parameterDeclarations = 39, 
		RULE_parameterIdentifierList = 40, RULE_parameterIdentifier = 41, RULE_statement = 42, 
		RULE_compoundStatement = 43, RULE_emptyStatement = 44, RULE_statementList = 45, 
		RULE_assignmentStatement = 46, RULE_lhs = 47, RULE_rhs = 48, RULE_ifStatement = 49, 
		RULE_trueStatement = 50, RULE_falseStatement = 51, RULE_whileStatement = 52, 
		RULE_forStatement = 53, RULE_procedureCallStatement = 54, RULE_procedureName = 55, 
		RULE_argumentList = 56, RULE_argument = 57, RULE_writeStatement = 58, 
		RULE_writelnStatement = 59, RULE_writeArguments = 60, RULE_writeArgument = 61, 
		RULE_fieldWidth = 62, RULE_decimalPlaces = 63, RULE_readStatement = 64, 
		RULE_readlnStatement = 65, RULE_readArguments = 66, RULE_expression = 67, 
		RULE_simpleExpression = 68, RULE_term = 69, RULE_factor = 70, RULE_variable = 71, 
		RULE_modifier = 72, RULE_indexList = 73, RULE_index = 74, RULE_field = 75, 
		RULE_functionCall = 76, RULE_functionName = 77, RULE_number = 78, RULE_unsignedNumber = 79, 
		RULE_intConstant = 80, RULE_doubleConstant = 81, RULE_characterConstant = 82, 
		RULE_stringConstant = 83, RULE_relOp = 84, RULE_addOp = 85, RULE_mulOp = 86;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "programHeader", "programParameters", "programIdentifier", 
			"intMain", "block", "declarations", "variablesPart", "variableDeclarationsList", 
			"variableDeclarations", "variableIdentifierList", "variableIdentifier", 
			"constantsPart", "constantDefinitionsList", "constantDefinition", "constantIdentifier", 
			"constant", "sign", "typesPart", "typeDefinitionsList", "typeDefinition", 
			"typeIdentifier", "typeSpecification", "simpleType", "enumerationType", 
			"enumerationConstant", "subrangeType", "arrayType", "arrayDimensionList", 
			"recordType", "recordFields", "routinesPart", "routineDefinition", "procedureHead", 
			"functionHead", "returnStatement", "routineIdentifier", "parameters", 
			"parameterDeclarationsList", "parameterDeclarations", "parameterIdentifierList", 
			"parameterIdentifier", "statement", "compoundStatement", "emptyStatement", 
			"statementList", "assignmentStatement", "lhs", "rhs", "ifStatement", 
			"trueStatement", "falseStatement", "whileStatement", "forStatement", 
			"procedureCallStatement", "procedureName", "argumentList", "argument", 
			"writeStatement", "writelnStatement", "writeArguments", "writeArgument", 
			"fieldWidth", "decimalPlaces", "readStatement", "readlnStatement", "readArguments", 
			"expression", "simpleExpression", "term", "factor", "variable", "modifier", 
			"indexList", "index", "field", "functionCall", "functionName", "number", 
			"unsignedNumber", "intConstant", "doubleConstant", "characterConstant", 
			"stringConstant", "relOp", "addOp", "mulOp"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'<'", "'>'", "'('", "','", "')'", "';'", "'='", "'-'", "'+'", 
			"'..'", "'['", "']'", "'{'", "'}'", "':='", "'<<'", "':'", "'.'", "'=='", 
			"'!='", "'<='", "'>='", "'*'", "'/'", null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "'\"'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "DIR_INCLUDE", "MAIN", "CONST", "TYPE", "ARRAY", "OF", "RECORD", 
			"VAR", "END", "DIV", "MOD", "AND", "OR", "NOT", "IF", "THEN", "ELSE", 
			"UNTIL", "WHILE", "DO", "FOR", "TO", "DOWNTO", "COUT", "WRITELN", "READ", 
			"READLN", "PROCEDURE", "FUNCTION", "RETURN", "IDENTIFIER", "INT", "DOUBLE", 
			"NEWLINE", "WS", "QUOTE", "CHARACTER", "STRING", "COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "cpp.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public cppParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public ProgramHeaderContext programHeader() {
			return getRuleContext(ProgramHeaderContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			programHeader();
			setState(175);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramHeaderContext extends ParserRuleContext {
		public TerminalNode DIR_INCLUDE() { return getToken(cppParser.DIR_INCLUDE, 0); }
		public ProgramIdentifierContext programIdentifier() {
			return getRuleContext(ProgramIdentifierContext.class,0);
		}
		public ProgramHeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programHeader; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterProgramHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitProgramHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitProgramHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramHeaderContext programHeader() throws RecognitionException {
		ProgramHeaderContext _localctx = new ProgramHeaderContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_programHeader);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(DIR_INCLUDE);
			setState(178);
			match(T__0);
			setState(179);
			programIdentifier();
			setState(180);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramParametersContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(cppParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(cppParser.IDENTIFIER, i);
		}
		public ProgramParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterProgramParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitProgramParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitProgramParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramParametersContext programParameters() throws RecognitionException {
		ProgramParametersContext _localctx = new ProgramParametersContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_programParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			match(T__2);
			setState(183);
			match(IDENTIFIER);
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(184);
				match(T__3);
				setState(185);
				match(IDENTIFIER);
				}
				}
				setState(190);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(191);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramIdentifierContext extends ParserRuleContext {
		public SymtabEntry entry = null;
		public TerminalNode IDENTIFIER() { return getToken(cppParser.IDENTIFIER, 0); }
		public ProgramIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterProgramIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitProgramIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitProgramIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramIdentifierContext programIdentifier() throws RecognitionException {
		ProgramIdentifierContext _localctx = new ProgramIdentifierContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_programIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IntMainContext extends ParserRuleContext {
		public TerminalNode MAIN() { return getToken(cppParser.MAIN, 0); }
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public IntMainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intMain; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterIntMain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitIntMain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitIntMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntMainContext intMain() throws RecognitionException {
		IntMainContext _localctx = new IntMainContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_intMain);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			match(MAIN);
			setState(196);
			match(T__2);
			setState(197);
			match(T__4);
			setState(198);
			compoundStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public IntMainContext intMain() {
			return getRuleContext(IntMainContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			declarations();
			setState(201);
			intMain();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationsContext extends ParserRuleContext {
		public ConstantsPartContext constantsPart() {
			return getRuleContext(ConstantsPartContext.class,0);
		}
		public TypesPartContext typesPart() {
			return getRuleContext(TypesPartContext.class,0);
		}
		public VariablesPartContext variablesPart() {
			return getRuleContext(VariablesPartContext.class,0);
		}
		public RoutinesPartContext routinesPart() {
			return getRuleContext(RoutinesPartContext.class,0);
		}
		public DeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterDeclarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitDeclarations(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitDeclarations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationsContext declarations() throws RecognitionException {
		DeclarationsContext _localctx = new DeclarationsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_declarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONST) {
				{
				setState(203);
				constantsPart();
				setState(204);
				match(T__5);
				}
			}

			setState(211);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE) {
				{
				setState(208);
				typesPart();
				setState(209);
				match(T__5);
				}
			}

			setState(216);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(213);
				variablesPart();
				setState(214);
				match(T__5);
				}
				break;
			}
			setState(219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PROCEDURE || _la==IDENTIFIER) {
				{
				setState(218);
				routinesPart();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariablesPartContext extends ParserRuleContext {
		public VariableDeclarationsListContext variableDeclarationsList() {
			return getRuleContext(VariableDeclarationsListContext.class,0);
		}
		public VariablesPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variablesPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterVariablesPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitVariablesPart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitVariablesPart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariablesPartContext variablesPart() throws RecognitionException {
		VariablesPartContext _localctx = new VariablesPartContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_variablesPart);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			variableDeclarationsList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclarationsListContext extends ParserRuleContext {
		public List<VariableDeclarationsContext> variableDeclarations() {
			return getRuleContexts(VariableDeclarationsContext.class);
		}
		public VariableDeclarationsContext variableDeclarations(int i) {
			return getRuleContext(VariableDeclarationsContext.class,i);
		}
		public VariableDeclarationsListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarationsList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterVariableDeclarationsList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitVariableDeclarationsList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitVariableDeclarationsList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationsListContext variableDeclarationsList() throws RecognitionException {
		VariableDeclarationsListContext _localctx = new VariableDeclarationsListContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_variableDeclarationsList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			variableDeclarations();
			setState(228);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(224);
					match(T__5);
					setState(225);
					variableDeclarations();
					}
					} 
				}
				setState(230);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclarationsContext extends ParserRuleContext {
		public TypeSpecificationContext typeSpecification() {
			return getRuleContext(TypeSpecificationContext.class,0);
		}
		public VariableIdentifierListContext variableIdentifierList() {
			return getRuleContext(VariableIdentifierListContext.class,0);
		}
		public VariableDeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterVariableDeclarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitVariableDeclarations(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitVariableDeclarations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationsContext variableDeclarations() throws RecognitionException {
		VariableDeclarationsContext _localctx = new VariableDeclarationsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_variableDeclarations);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			typeSpecification();
			setState(232);
			variableIdentifierList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableIdentifierListContext extends ParserRuleContext {
		public List<VariableIdentifierContext> variableIdentifier() {
			return getRuleContexts(VariableIdentifierContext.class);
		}
		public VariableIdentifierContext variableIdentifier(int i) {
			return getRuleContext(VariableIdentifierContext.class,i);
		}
		public VariableIdentifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableIdentifierList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterVariableIdentifierList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitVariableIdentifierList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitVariableIdentifierList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableIdentifierListContext variableIdentifierList() throws RecognitionException {
		VariableIdentifierListContext _localctx = new VariableIdentifierListContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_variableIdentifierList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			variableIdentifier();
			setState(239);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(235);
				match(T__3);
				setState(236);
				variableIdentifier();
				}
				}
				setState(241);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableIdentifierContext extends ParserRuleContext {
		public Typespec type = null;
		public SymtabEntry entry = null;
		public TerminalNode IDENTIFIER() { return getToken(cppParser.IDENTIFIER, 0); }
		public VariableIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterVariableIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitVariableIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitVariableIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableIdentifierContext variableIdentifier() throws RecognitionException {
		VariableIdentifierContext _localctx = new VariableIdentifierContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_variableIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstantsPartContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(cppParser.CONST, 0); }
		public ConstantDefinitionsListContext constantDefinitionsList() {
			return getRuleContext(ConstantDefinitionsListContext.class,0);
		}
		public ConstantsPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantsPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterConstantsPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitConstantsPart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitConstantsPart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantsPartContext constantsPart() throws RecognitionException {
		ConstantsPartContext _localctx = new ConstantsPartContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_constantsPart);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			match(CONST);
			setState(245);
			constantDefinitionsList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstantDefinitionsListContext extends ParserRuleContext {
		public List<ConstantDefinitionContext> constantDefinition() {
			return getRuleContexts(ConstantDefinitionContext.class);
		}
		public ConstantDefinitionContext constantDefinition(int i) {
			return getRuleContext(ConstantDefinitionContext.class,i);
		}
		public ConstantDefinitionsListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantDefinitionsList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterConstantDefinitionsList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitConstantDefinitionsList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitConstantDefinitionsList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantDefinitionsListContext constantDefinitionsList() throws RecognitionException {
		ConstantDefinitionsListContext _localctx = new ConstantDefinitionsListContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_constantDefinitionsList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			constantDefinition();
			setState(252);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(248);
					match(T__5);
					setState(249);
					constantDefinition();
					}
					} 
				}
				setState(254);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstantDefinitionContext extends ParserRuleContext {
		public ConstantIdentifierContext constantIdentifier() {
			return getRuleContext(ConstantIdentifierContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ConstantDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterConstantDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitConstantDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitConstantDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantDefinitionContext constantDefinition() throws RecognitionException {
		ConstantDefinitionContext _localctx = new ConstantDefinitionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_constantDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			constantIdentifier();
			setState(256);
			match(T__6);
			setState(257);
			constant();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstantIdentifierContext extends ParserRuleContext {
		public Typespec type = null;
		public SymtabEntry entry = null;
		public TerminalNode IDENTIFIER() { return getToken(cppParser.IDENTIFIER, 0); }
		public ConstantIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterConstantIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitConstantIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitConstantIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantIdentifierContext constantIdentifier() throws RecognitionException {
		ConstantIdentifierContext _localctx = new ConstantIdentifierContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_constantIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstantContext extends ParserRuleContext {
		public Typespec type = null;
		public Object value = null;
		public TerminalNode IDENTIFIER() { return getToken(cppParser.IDENTIFIER, 0); }
		public UnsignedNumberContext unsignedNumber() {
			return getRuleContext(UnsignedNumberContext.class,0);
		}
		public SignContext sign() {
			return getRuleContext(SignContext.class,0);
		}
		public CharacterConstantContext characterConstant() {
			return getRuleContext(CharacterConstantContext.class,0);
		}
		public StringConstantContext stringConstant() {
			return getRuleContext(StringConstantContext.class,0);
		}
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_constant);
		int _la;
		try {
			setState(270);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
			case T__8:
			case IDENTIFIER:
			case INT:
			case DOUBLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(262);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__7 || _la==T__8) {
					{
					setState(261);
					sign();
					}
				}

				setState(266);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IDENTIFIER:
					{
					setState(264);
					match(IDENTIFIER);
					}
					break;
				case INT:
				case DOUBLE:
					{
					setState(265);
					unsignedNumber();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case CHARACTER:
				enterOuterAlt(_localctx, 2);
				{
				setState(268);
				characterConstant();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(269);
				stringConstant();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SignContext extends ParserRuleContext {
		public SignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterSign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitSign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitSign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SignContext sign() throws RecognitionException {
		SignContext _localctx = new SignContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_sign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			_la = _input.LA(1);
			if ( !(_la==T__7 || _la==T__8) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypesPartContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(cppParser.TYPE, 0); }
		public TypeDefinitionsListContext typeDefinitionsList() {
			return getRuleContext(TypeDefinitionsListContext.class,0);
		}
		public TypesPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typesPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterTypesPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitTypesPart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitTypesPart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypesPartContext typesPart() throws RecognitionException {
		TypesPartContext _localctx = new TypesPartContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_typesPart);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			match(TYPE);
			setState(275);
			typeDefinitionsList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeDefinitionsListContext extends ParserRuleContext {
		public List<TypeDefinitionContext> typeDefinition() {
			return getRuleContexts(TypeDefinitionContext.class);
		}
		public TypeDefinitionContext typeDefinition(int i) {
			return getRuleContext(TypeDefinitionContext.class,i);
		}
		public TypeDefinitionsListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDefinitionsList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterTypeDefinitionsList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitTypeDefinitionsList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitTypeDefinitionsList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDefinitionsListContext typeDefinitionsList() throws RecognitionException {
		TypeDefinitionsListContext _localctx = new TypeDefinitionsListContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_typeDefinitionsList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			typeDefinition();
			setState(282);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(278);
					match(T__5);
					setState(279);
					typeDefinition();
					}
					} 
				}
				setState(284);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeDefinitionContext extends ParserRuleContext {
		public TypeIdentifierContext typeIdentifier() {
			return getRuleContext(TypeIdentifierContext.class,0);
		}
		public TypeSpecificationContext typeSpecification() {
			return getRuleContext(TypeSpecificationContext.class,0);
		}
		public TypeDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterTypeDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitTypeDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitTypeDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDefinitionContext typeDefinition() throws RecognitionException {
		TypeDefinitionContext _localctx = new TypeDefinitionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_typeDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			typeIdentifier();
			setState(286);
			match(T__6);
			setState(287);
			typeSpecification();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeIdentifierContext extends ParserRuleContext {
		public Typespec type = null;
		public SymtabEntry entry = null;
		public TerminalNode IDENTIFIER() { return getToken(cppParser.IDENTIFIER, 0); }
		public TypeIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterTypeIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitTypeIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitTypeIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeIdentifierContext typeIdentifier() throws RecognitionException {
		TypeIdentifierContext _localctx = new TypeIdentifierContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_typeIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeSpecificationContext extends ParserRuleContext {
		public Typespec type = null;
		public TypeSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeSpecification; }
	 
		public TypeSpecificationContext() { }
		public void copyFrom(TypeSpecificationContext ctx) {
			super.copyFrom(ctx);
			this.type = ctx.type;
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SimpleTypespecContext extends TypeSpecificationContext {
		public SimpleTypeContext simpleType() {
			return getRuleContext(SimpleTypeContext.class,0);
		}
		public SimpleTypespecContext(TypeSpecificationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterSimpleTypespec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitSimpleTypespec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitSimpleTypespec(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayTypespecContext extends TypeSpecificationContext {
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public ArrayTypespecContext(TypeSpecificationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterArrayTypespec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitArrayTypespec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitArrayTypespec(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RecordTypespecContext extends TypeSpecificationContext {
		public RecordTypeContext recordType() {
			return getRuleContext(RecordTypeContext.class,0);
		}
		public RecordTypespecContext(TypeSpecificationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterRecordTypespec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitRecordTypespec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitRecordTypespec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeSpecificationContext typeSpecification() throws RecognitionException {
		TypeSpecificationContext _localctx = new TypeSpecificationContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_typeSpecification);
		try {
			setState(294);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__7:
			case T__8:
			case IDENTIFIER:
			case INT:
			case DOUBLE:
			case CHARACTER:
			case STRING:
				_localctx = new SimpleTypespecContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(291);
				simpleType();
				}
				break;
			case ARRAY:
				_localctx = new ArrayTypespecContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(292);
				arrayType();
				}
				break;
			case RECORD:
				_localctx = new RecordTypespecContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(293);
				recordType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SimpleTypeContext extends ParserRuleContext {
		public Typespec type = null;
		public SimpleTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleType; }
	 
		public SimpleTypeContext() { }
		public void copyFrom(SimpleTypeContext ctx) {
			super.copyFrom(ctx);
			this.type = ctx.type;
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SubrangeTypespecContext extends SimpleTypeContext {
		public SubrangeTypeContext subrangeType() {
			return getRuleContext(SubrangeTypeContext.class,0);
		}
		public SubrangeTypespecContext(SimpleTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterSubrangeTypespec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitSubrangeTypespec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitSubrangeTypespec(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EnumerationTypespecContext extends SimpleTypeContext {
		public EnumerationTypeContext enumerationType() {
			return getRuleContext(EnumerationTypeContext.class,0);
		}
		public EnumerationTypespecContext(SimpleTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterEnumerationTypespec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitEnumerationTypespec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitEnumerationTypespec(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeIdentifierTypespecContext extends SimpleTypeContext {
		public TypeIdentifierContext typeIdentifier() {
			return getRuleContext(TypeIdentifierContext.class,0);
		}
		public TypeIdentifierTypespecContext(SimpleTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterTypeIdentifierTypespec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitTypeIdentifierTypespec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitTypeIdentifierTypespec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleTypeContext simpleType() throws RecognitionException {
		SimpleTypeContext _localctx = new SimpleTypeContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_simpleType);
		try {
			setState(299);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new TypeIdentifierTypespecContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(296);
				typeIdentifier();
				}
				break;
			case 2:
				_localctx = new EnumerationTypespecContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(297);
				enumerationType();
				}
				break;
			case 3:
				_localctx = new SubrangeTypespecContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(298);
				subrangeType();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EnumerationTypeContext extends ParserRuleContext {
		public List<EnumerationConstantContext> enumerationConstant() {
			return getRuleContexts(EnumerationConstantContext.class);
		}
		public EnumerationConstantContext enumerationConstant(int i) {
			return getRuleContext(EnumerationConstantContext.class,i);
		}
		public EnumerationTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumerationType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterEnumerationType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitEnumerationType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitEnumerationType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumerationTypeContext enumerationType() throws RecognitionException {
		EnumerationTypeContext _localctx = new EnumerationTypeContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_enumerationType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			match(T__2);
			setState(302);
			enumerationConstant();
			setState(307);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(303);
				match(T__3);
				setState(304);
				enumerationConstant();
				}
				}
				setState(309);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(310);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EnumerationConstantContext extends ParserRuleContext {
		public ConstantIdentifierContext constantIdentifier() {
			return getRuleContext(ConstantIdentifierContext.class,0);
		}
		public EnumerationConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumerationConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterEnumerationConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitEnumerationConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitEnumerationConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumerationConstantContext enumerationConstant() throws RecognitionException {
		EnumerationConstantContext _localctx = new EnumerationConstantContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_enumerationConstant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			constantIdentifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SubrangeTypeContext extends ParserRuleContext {
		public List<ConstantContext> constant() {
			return getRuleContexts(ConstantContext.class);
		}
		public ConstantContext constant(int i) {
			return getRuleContext(ConstantContext.class,i);
		}
		public SubrangeTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subrangeType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterSubrangeType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitSubrangeType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitSubrangeType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubrangeTypeContext subrangeType() throws RecognitionException {
		SubrangeTypeContext _localctx = new SubrangeTypeContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_subrangeType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			constant();
			setState(315);
			match(T__9);
			setState(316);
			constant();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayTypeContext extends ParserRuleContext {
		public TerminalNode ARRAY() { return getToken(cppParser.ARRAY, 0); }
		public ArrayDimensionListContext arrayDimensionList() {
			return getRuleContext(ArrayDimensionListContext.class,0);
		}
		public TerminalNode OF() { return getToken(cppParser.OF, 0); }
		public TypeSpecificationContext typeSpecification() {
			return getRuleContext(TypeSpecificationContext.class,0);
		}
		public ArrayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitArrayType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayTypeContext arrayType() throws RecognitionException {
		ArrayTypeContext _localctx = new ArrayTypeContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_arrayType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			match(ARRAY);
			setState(319);
			match(T__10);
			setState(320);
			arrayDimensionList();
			setState(321);
			match(T__11);
			setState(322);
			match(OF);
			setState(323);
			typeSpecification();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayDimensionListContext extends ParserRuleContext {
		public List<SimpleTypeContext> simpleType() {
			return getRuleContexts(SimpleTypeContext.class);
		}
		public SimpleTypeContext simpleType(int i) {
			return getRuleContext(SimpleTypeContext.class,i);
		}
		public ArrayDimensionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayDimensionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterArrayDimensionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitArrayDimensionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitArrayDimensionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayDimensionListContext arrayDimensionList() throws RecognitionException {
		ArrayDimensionListContext _localctx = new ArrayDimensionListContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_arrayDimensionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			simpleType();
			setState(330);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(326);
				match(T__3);
				setState(327);
				simpleType();
				}
				}
				setState(332);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RecordTypeContext extends ParserRuleContext {
		public SymtabEntry entry = null;
		public TerminalNode RECORD() { return getToken(cppParser.RECORD, 0); }
		public RecordFieldsContext recordFields() {
			return getRuleContext(RecordFieldsContext.class,0);
		}
		public TerminalNode END() { return getToken(cppParser.END, 0); }
		public RecordTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recordType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterRecordType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitRecordType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitRecordType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RecordTypeContext recordType() throws RecognitionException {
		RecordTypeContext _localctx = new RecordTypeContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_recordType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333);
			match(RECORD);
			setState(334);
			recordFields();
			setState(336);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(335);
				match(T__5);
				}
			}

			setState(338);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RecordFieldsContext extends ParserRuleContext {
		public VariableDeclarationsListContext variableDeclarationsList() {
			return getRuleContext(VariableDeclarationsListContext.class,0);
		}
		public RecordFieldsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recordFields; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterRecordFields(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitRecordFields(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitRecordFields(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RecordFieldsContext recordFields() throws RecognitionException {
		RecordFieldsContext _localctx = new RecordFieldsContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_recordFields);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			variableDeclarationsList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RoutinesPartContext extends ParserRuleContext {
		public List<RoutineDefinitionContext> routineDefinition() {
			return getRuleContexts(RoutineDefinitionContext.class);
		}
		public RoutineDefinitionContext routineDefinition(int i) {
			return getRuleContext(RoutineDefinitionContext.class,i);
		}
		public RoutinesPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_routinesPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterRoutinesPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitRoutinesPart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitRoutinesPart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RoutinesPartContext routinesPart() throws RecognitionException {
		RoutinesPartContext _localctx = new RoutinesPartContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_routinesPart);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			routineDefinition();
			setState(346);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PROCEDURE || _la==IDENTIFIER) {
				{
				{
				setState(343);
				routineDefinition();
				}
				}
				setState(348);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RoutineDefinitionContext extends ParserRuleContext {
		public ProcedureHeadContext procedureHead() {
			return getRuleContext(ProcedureHeadContext.class,0);
		}
		public FunctionHeadContext functionHead() {
			return getRuleContext(FunctionHeadContext.class,0);
		}
		public VariablesPartContext variablesPart() {
			return getRuleContext(VariablesPartContext.class,0);
		}
		public StatementListContext statementList() {
			return getRuleContext(StatementListContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public RoutineDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_routineDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterRoutineDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitRoutineDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitRoutineDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RoutineDefinitionContext routineDefinition() throws RecognitionException {
		RoutineDefinitionContext _localctx = new RoutineDefinitionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_routineDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(351);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PROCEDURE:
				{
				setState(349);
				procedureHead();
				}
				break;
			case IDENTIFIER:
				{
				setState(350);
				functionHead();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(353);
			match(T__12);
			setState(357);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(354);
				variablesPart();
				setState(355);
				match(T__5);
				}
				break;
			}
			setState(360);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 40295451890556992L) != 0)) {
				{
				setState(359);
				statementList();
				}
			}

			setState(365);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RETURN) {
				{
				setState(362);
				returnStatement();
				setState(363);
				match(T__5);
				}
			}

			setState(367);
			match(T__13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProcedureHeadContext extends ParserRuleContext {
		public TerminalNode PROCEDURE() { return getToken(cppParser.PROCEDURE, 0); }
		public RoutineIdentifierContext routineIdentifier() {
			return getRuleContext(RoutineIdentifierContext.class,0);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public ProcedureHeadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedureHead; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterProcedureHead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitProcedureHead(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitProcedureHead(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProcedureHeadContext procedureHead() throws RecognitionException {
		ProcedureHeadContext _localctx = new ProcedureHeadContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_procedureHead);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(369);
			match(PROCEDURE);
			setState(370);
			routineIdentifier();
			setState(371);
			match(T__2);
			setState(373);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VAR || _la==IDENTIFIER) {
				{
				setState(372);
				parameters();
				}
			}

			setState(375);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionHeadContext extends ParserRuleContext {
		public TypeIdentifierContext typeIdentifier() {
			return getRuleContext(TypeIdentifierContext.class,0);
		}
		public RoutineIdentifierContext routineIdentifier() {
			return getRuleContext(RoutineIdentifierContext.class,0);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public FunctionHeadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionHead; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterFunctionHead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitFunctionHead(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitFunctionHead(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionHeadContext functionHead() throws RecognitionException {
		FunctionHeadContext _localctx = new FunctionHeadContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_functionHead);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(377);
			typeIdentifier();
			setState(378);
			routineIdentifier();
			setState(379);
			match(T__2);
			setState(381);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VAR || _la==IDENTIFIER) {
				{
				setState(380);
				parameters();
				}
			}

			setState(383);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(cppParser.RETURN, 0); }
		public RhsContext rhs() {
			return getRuleContext(RhsContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(385);
			match(RETURN);
			setState(386);
			rhs();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RoutineIdentifierContext extends ParserRuleContext {
		public Typespec type = null;
		public SymtabEntry entry = null;
		public TerminalNode IDENTIFIER() { return getToken(cppParser.IDENTIFIER, 0); }
		public RoutineIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_routineIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterRoutineIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitRoutineIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitRoutineIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RoutineIdentifierContext routineIdentifier() throws RecognitionException {
		RoutineIdentifierContext _localctx = new RoutineIdentifierContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_routineIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(388);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParametersContext extends ParserRuleContext {
		public ParameterDeclarationsListContext parameterDeclarationsList() {
			return getRuleContext(ParameterDeclarationsListContext.class,0);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_parameters);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(390);
			parameterDeclarationsList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterDeclarationsListContext extends ParserRuleContext {
		public List<ParameterDeclarationsContext> parameterDeclarations() {
			return getRuleContexts(ParameterDeclarationsContext.class);
		}
		public ParameterDeclarationsContext parameterDeclarations(int i) {
			return getRuleContext(ParameterDeclarationsContext.class,i);
		}
		public ParameterDeclarationsListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterDeclarationsList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterParameterDeclarationsList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitParameterDeclarationsList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitParameterDeclarationsList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterDeclarationsListContext parameterDeclarationsList() throws RecognitionException {
		ParameterDeclarationsListContext _localctx = new ParameterDeclarationsListContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_parameterDeclarationsList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(392);
			parameterDeclarations();
			setState(397);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(393);
				match(T__3);
				setState(394);
				parameterDeclarations();
				}
				}
				setState(399);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterDeclarationsContext extends ParserRuleContext {
		public TypeIdentifierContext typeIdentifier() {
			return getRuleContext(TypeIdentifierContext.class,0);
		}
		public ParameterIdentifierListContext parameterIdentifierList() {
			return getRuleContext(ParameterIdentifierListContext.class,0);
		}
		public TerminalNode VAR() { return getToken(cppParser.VAR, 0); }
		public ParameterDeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterDeclarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterParameterDeclarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitParameterDeclarations(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitParameterDeclarations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterDeclarationsContext parameterDeclarations() throws RecognitionException {
		ParameterDeclarationsContext _localctx = new ParameterDeclarationsContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_parameterDeclarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(401);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VAR) {
				{
				setState(400);
				match(VAR);
				}
			}

			setState(403);
			typeIdentifier();
			setState(404);
			parameterIdentifierList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterIdentifierListContext extends ParserRuleContext {
		public ParameterIdentifierContext parameterIdentifier() {
			return getRuleContext(ParameterIdentifierContext.class,0);
		}
		public ParameterIdentifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterIdentifierList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterParameterIdentifierList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitParameterIdentifierList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitParameterIdentifierList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterIdentifierListContext parameterIdentifierList() throws RecognitionException {
		ParameterIdentifierListContext _localctx = new ParameterIdentifierListContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_parameterIdentifierList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(406);
			parameterIdentifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterIdentifierContext extends ParserRuleContext {
		public Typespec type = null;
		public SymtabEntry entry = null;
		public TerminalNode IDENTIFIER() { return getToken(cppParser.IDENTIFIER, 0); }
		public ParameterIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterParameterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitParameterIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitParameterIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterIdentifierContext parameterIdentifier() throws RecognitionException {
		ParameterIdentifierContext _localctx = new ParameterIdentifierContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_parameterIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(408);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public AssignmentStatementContext assignmentStatement() {
			return getRuleContext(AssignmentStatementContext.class,0);
		}
		public WriteStatementContext writeStatement() {
			return getRuleContext(WriteStatementContext.class,0);
		}
		public WritelnStatementContext writelnStatement() {
			return getRuleContext(WritelnStatementContext.class,0);
		}
		public ReadStatementContext readStatement() {
			return getRuleContext(ReadStatementContext.class,0);
		}
		public ReadlnStatementContext readlnStatement() {
			return getRuleContext(ReadlnStatementContext.class,0);
		}
		public ProcedureCallStatementContext procedureCallStatement() {
			return getRuleContext(ProcedureCallStatementContext.class,0);
		}
		public EmptyStatementContext emptyStatement() {
			return getRuleContext(EmptyStatementContext.class,0);
		}
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_statement);
		try {
			setState(425);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
			case COUT:
			case WRITELN:
			case READ:
			case READLN:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(417);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(410);
					assignmentStatement();
					}
					break;
				case 2:
					{
					setState(411);
					writeStatement();
					}
					break;
				case 3:
					{
					setState(412);
					writelnStatement();
					}
					break;
				case 4:
					{
					setState(413);
					readStatement();
					}
					break;
				case 5:
					{
					setState(414);
					readlnStatement();
					}
					break;
				case 6:
					{
					setState(415);
					procedureCallStatement();
					}
					break;
				case 7:
					{
					setState(416);
					emptyStatement();
					}
					break;
				}
				setState(419);
				match(T__5);
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				setState(421);
				compoundStatement();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(422);
				ifStatement();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 4);
				{
				setState(423);
				whileStatement();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 5);
				{
				setState(424);
				forStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CompoundStatementContext extends ParserRuleContext {
		public StatementListContext statementList() {
			return getRuleContext(StatementListContext.class,0);
		}
		public CompoundStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterCompoundStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitCompoundStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitCompoundStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompoundStatementContext compoundStatement() throws RecognitionException {
		CompoundStatementContext _localctx = new CompoundStatementContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_compoundStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(427);
			match(T__12);
			setState(428);
			statementList();
			setState(429);
			match(T__13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EmptyStatementContext extends ParserRuleContext {
		public EmptyStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterEmptyStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitEmptyStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitEmptyStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmptyStatementContext emptyStatement() throws RecognitionException {
		EmptyStatementContext _localctx = new EmptyStatementContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_emptyStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementListContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterStatementList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitStatementList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitStatementList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementListContext statementList() throws RecognitionException {
		StatementListContext _localctx = new StatementListContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_statementList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(433);
			statement();
			setState(437);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 40295451890556992L) != 0)) {
				{
				{
				setState(434);
				statement();
				}
				}
				setState(439);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentStatementContext extends ParserRuleContext {
		public LhsContext lhs() {
			return getRuleContext(LhsContext.class,0);
		}
		public RhsContext rhs() {
			return getRuleContext(RhsContext.class,0);
		}
		public AssignmentStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterAssignmentStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitAssignmentStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitAssignmentStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentStatementContext assignmentStatement() throws RecognitionException {
		AssignmentStatementContext _localctx = new AssignmentStatementContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_assignmentStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(440);
			lhs();
			setState(441);
			match(T__6);
			setState(442);
			rhs();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LhsContext extends ParserRuleContext {
		public Typespec type = null;
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public LhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lhs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterLhs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitLhs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitLhs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LhsContext lhs() throws RecognitionException {
		LhsContext _localctx = new LhsContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_lhs);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(444);
			variable();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RhsContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rhs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterRhs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitRhs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitRhs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RhsContext rhs() throws RecognitionException {
		RhsContext _localctx = new RhsContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_rhs);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(446);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(cppParser.IF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TrueStatementContext trueStatement() {
			return getRuleContext(TrueStatementContext.class,0);
		}
		public TerminalNode ELSE() { return getToken(cppParser.ELSE, 0); }
		public FalseStatementContext falseStatement() {
			return getRuleContext(FalseStatementContext.class,0);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(448);
			match(IF);
			setState(449);
			match(T__2);
			setState(450);
			expression();
			setState(451);
			match(T__4);
			setState(452);
			trueStatement();
			setState(455);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(453);
				match(ELSE);
				setState(454);
				falseStatement();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TrueStatementContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TrueStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trueStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterTrueStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitTrueStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitTrueStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TrueStatementContext trueStatement() throws RecognitionException {
		TrueStatementContext _localctx = new TrueStatementContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_trueStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(457);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FalseStatementContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public FalseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_falseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterFalseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitFalseStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitFalseStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FalseStatementContext falseStatement() throws RecognitionException {
		FalseStatementContext _localctx = new FalseStatementContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_falseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(459);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(cppParser.WHILE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(461);
			match(WHILE);
			setState(462);
			match(T__2);
			setState(463);
			expression();
			setState(464);
			match(T__4);
			setState(465);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForStatementContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(cppParser.FOR, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode DO() { return getToken(cppParser.DO, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode TO() { return getToken(cppParser.TO, 0); }
		public TerminalNode DOWNTO() { return getToken(cppParser.DOWNTO, 0); }
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(467);
			match(FOR);
			setState(468);
			variable();
			setState(469);
			match(T__14);
			setState(470);
			expression();
			setState(471);
			_la = _input.LA(1);
			if ( !(_la==TO || _la==DOWNTO) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(472);
			expression();
			setState(473);
			match(DO);
			setState(474);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProcedureCallStatementContext extends ParserRuleContext {
		public ProcedureNameContext procedureName() {
			return getRuleContext(ProcedureNameContext.class,0);
		}
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public ProcedureCallStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedureCallStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterProcedureCallStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitProcedureCallStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitProcedureCallStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProcedureCallStatementContext procedureCallStatement() throws RecognitionException {
		ProcedureCallStatementContext _localctx = new ProcedureCallStatementContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_procedureCallStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(476);
			procedureName();
			setState(477);
			match(T__2);
			setState(479);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 7169730881651737352L) != 0)) {
				{
				setState(478);
				argumentList();
				}
			}

			setState(481);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProcedureNameContext extends ParserRuleContext {
		public SymtabEntry entry = null;
		public TerminalNode IDENTIFIER() { return getToken(cppParser.IDENTIFIER, 0); }
		public ProcedureNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedureName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterProcedureName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitProcedureName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitProcedureName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProcedureNameContext procedureName() throws RecognitionException {
		ProcedureNameContext _localctx = new ProcedureNameContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_procedureName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(483);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentListContext extends ParserRuleContext {
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public ArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterArgumentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitArgumentList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitArgumentList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentListContext argumentList() throws RecognitionException {
		ArgumentListContext _localctx = new ArgumentListContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_argumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(485);
			argument();
			setState(490);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(486);
				match(T__3);
				setState(487);
				argument();
				}
				}
				setState(492);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(493);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WriteStatementContext extends ParserRuleContext {
		public TerminalNode COUT() { return getToken(cppParser.COUT, 0); }
		public WriteArgumentsContext writeArguments() {
			return getRuleContext(WriteArgumentsContext.class,0);
		}
		public WriteStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writeStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterWriteStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitWriteStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitWriteStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WriteStatementContext writeStatement() throws RecognitionException {
		WriteStatementContext _localctx = new WriteStatementContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_writeStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(495);
			match(COUT);
			setState(496);
			writeArguments();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WritelnStatementContext extends ParserRuleContext {
		public TerminalNode WRITELN() { return getToken(cppParser.WRITELN, 0); }
		public WriteArgumentsContext writeArguments() {
			return getRuleContext(WriteArgumentsContext.class,0);
		}
		public WritelnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writelnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterWritelnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitWritelnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitWritelnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WritelnStatementContext writelnStatement() throws RecognitionException {
		WritelnStatementContext _localctx = new WritelnStatementContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_writelnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(498);
			match(WRITELN);
			setState(500);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(499);
				writeArguments();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WriteArgumentsContext extends ParserRuleContext {
		public List<WriteArgumentContext> writeArgument() {
			return getRuleContexts(WriteArgumentContext.class);
		}
		public WriteArgumentContext writeArgument(int i) {
			return getRuleContext(WriteArgumentContext.class,i);
		}
		public WriteArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writeArguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterWriteArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitWriteArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitWriteArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WriteArgumentsContext writeArguments() throws RecognitionException {
		WriteArgumentsContext _localctx = new WriteArgumentsContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_writeArguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(502);
			match(T__15);
			setState(503);
			writeArgument();
			setState(508);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(504);
				match(T__3);
				setState(505);
				writeArgument();
				}
				}
				setState(510);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WriteArgumentContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FieldWidthContext fieldWidth() {
			return getRuleContext(FieldWidthContext.class,0);
		}
		public WriteArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writeArgument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterWriteArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitWriteArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitWriteArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WriteArgumentContext writeArgument() throws RecognitionException {
		WriteArgumentContext _localctx = new WriteArgumentContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_writeArgument);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(511);
			expression();
			setState(514);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(512);
				match(T__16);
				setState(513);
				fieldWidth();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FieldWidthContext extends ParserRuleContext {
		public IntConstantContext intConstant() {
			return getRuleContext(IntConstantContext.class,0);
		}
		public SignContext sign() {
			return getRuleContext(SignContext.class,0);
		}
		public DecimalPlacesContext decimalPlaces() {
			return getRuleContext(DecimalPlacesContext.class,0);
		}
		public FieldWidthContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldWidth; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterFieldWidth(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitFieldWidth(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitFieldWidth(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldWidthContext fieldWidth() throws RecognitionException {
		FieldWidthContext _localctx = new FieldWidthContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_fieldWidth);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(517);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7 || _la==T__8) {
				{
				setState(516);
				sign();
				}
			}

			setState(519);
			intConstant();
			setState(522);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(520);
				match(T__16);
				setState(521);
				decimalPlaces();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DecimalPlacesContext extends ParserRuleContext {
		public IntConstantContext intConstant() {
			return getRuleContext(IntConstantContext.class,0);
		}
		public DecimalPlacesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decimalPlaces; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterDecimalPlaces(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitDecimalPlaces(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitDecimalPlaces(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecimalPlacesContext decimalPlaces() throws RecognitionException {
		DecimalPlacesContext _localctx = new DecimalPlacesContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_decimalPlaces);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(524);
			intConstant();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReadStatementContext extends ParserRuleContext {
		public TerminalNode READ() { return getToken(cppParser.READ, 0); }
		public ReadArgumentsContext readArguments() {
			return getRuleContext(ReadArgumentsContext.class,0);
		}
		public ReadStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterReadStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitReadStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitReadStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReadStatementContext readStatement() throws RecognitionException {
		ReadStatementContext _localctx = new ReadStatementContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_readStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(526);
			match(READ);
			setState(527);
			readArguments();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReadlnStatementContext extends ParserRuleContext {
		public TerminalNode READLN() { return getToken(cppParser.READLN, 0); }
		public ReadArgumentsContext readArguments() {
			return getRuleContext(ReadArgumentsContext.class,0);
		}
		public ReadlnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readlnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterReadlnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitReadlnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitReadlnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReadlnStatementContext readlnStatement() throws RecognitionException {
		ReadlnStatementContext _localctx = new ReadlnStatementContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_readlnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(529);
			match(READLN);
			setState(530);
			readArguments();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReadArgumentsContext extends ParserRuleContext {
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public ReadArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readArguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterReadArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitReadArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitReadArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReadArgumentsContext readArguments() throws RecognitionException {
		ReadArgumentsContext _localctx = new ReadArgumentsContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_readArguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(532);
			match(T__2);
			setState(533);
			variable();
			setState(538);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(534);
				match(T__3);
				setState(535);
				variable();
				}
				}
				setState(540);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(541);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public Typespec type = null;
		public List<SimpleExpressionContext> simpleExpression() {
			return getRuleContexts(SimpleExpressionContext.class);
		}
		public SimpleExpressionContext simpleExpression(int i) {
			return getRuleContext(SimpleExpressionContext.class,i);
		}
		public RelOpContext relOp() {
			return getRuleContext(RelOpContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(543);
			simpleExpression();
			setState(547);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 7864326L) != 0)) {
				{
				setState(544);
				relOp();
				setState(545);
				simpleExpression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SimpleExpressionContext extends ParserRuleContext {
		public Typespec type = null;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public SignContext sign() {
			return getRuleContext(SignContext.class,0);
		}
		public List<AddOpContext> addOp() {
			return getRuleContexts(AddOpContext.class);
		}
		public AddOpContext addOp(int i) {
			return getRuleContext(AddOpContext.class,i);
		}
		public SimpleExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterSimpleExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitSimpleExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitSimpleExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleExpressionContext simpleExpression() throws RecognitionException {
		SimpleExpressionContext _localctx = new SimpleExpressionContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_simpleExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(550);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				setState(549);
				sign();
				}
				break;
			}
			setState(552);
			term();
			setState(558);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 137438954240L) != 0)) {
				{
				{
				setState(553);
				addOp();
				setState(554);
				term();
				}
				}
				setState(560);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public Typespec type = null;
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<MulOpContext> mulOp() {
			return getRuleContexts(MulOpContext.class);
		}
		public MulOpContext mulOp(int i) {
			return getRuleContext(MulOpContext.class,i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(561);
			factor();
			setState(567);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 120284250112L) != 0)) {
				{
				{
				setState(562);
				mulOp();
				setState(563);
				factor();
				}
				}
				setState(569);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FactorContext extends ParserRuleContext {
		public Typespec type = null;
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	 
		public FactorContext() { }
		public void copyFrom(FactorContext ctx) {
			super.copyFrom(ctx);
			this.type = ctx.type;
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumberFactorContext extends FactorContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public NumberFactorContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterNumberFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitNumberFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitNumberFactor(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringFactorContext extends FactorContext {
		public StringConstantContext stringConstant() {
			return getRuleContext(StringConstantContext.class,0);
		}
		public StringFactorContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterStringFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitStringFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitStringFactor(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CharacterFactorContext extends FactorContext {
		public CharacterConstantContext characterConstant() {
			return getRuleContext(CharacterConstantContext.class,0);
		}
		public CharacterFactorContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterCharacterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitCharacterFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitCharacterFactor(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VariableFactorContext extends FactorContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public VariableFactorContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterVariableFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitVariableFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitVariableFactor(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallFactorContext extends FactorContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public FunctionCallFactorContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterFunctionCallFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitFunctionCallFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitFunctionCallFactor(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotFactorContext extends FactorContext {
		public TerminalNode NOT() { return getToken(cppParser.NOT, 0); }
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public NotFactorContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterNotFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitNotFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitNotFactor(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenthesizedFactorContext extends FactorContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParenthesizedFactorContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterParenthesizedFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitParenthesizedFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitParenthesizedFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_factor);
		try {
			setState(581);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				_localctx = new VariableFactorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(570);
				variable();
				}
				break;
			case 2:
				_localctx = new NumberFactorContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(571);
				number();
				}
				break;
			case 3:
				_localctx = new CharacterFactorContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(572);
				characterConstant();
				}
				break;
			case 4:
				_localctx = new StringFactorContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(573);
				stringConstant();
				}
				break;
			case 5:
				_localctx = new FunctionCallFactorContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(574);
				functionCall();
				}
				break;
			case 6:
				_localctx = new NotFactorContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(575);
				match(NOT);
				setState(576);
				factor();
				}
				break;
			case 7:
				_localctx = new ParenthesizedFactorContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(577);
				match(T__2);
				setState(578);
				expression();
				setState(579);
				match(T__4);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableContext extends ParserRuleContext {
		public Typespec type = null;
		public SymtabEntry entry = null;
		public VariableIdentifierContext variableIdentifier() {
			return getRuleContext(VariableIdentifierContext.class,0);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_variable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(583);
			variableIdentifier();
			setState(587);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10 || _la==T__17) {
				{
				{
				setState(584);
				modifier();
				}
				}
				setState(589);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ModifierContext extends ParserRuleContext {
		public IndexListContext indexList() {
			return getRuleContext(IndexListContext.class,0);
		}
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public ModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModifierContext modifier() throws RecognitionException {
		ModifierContext _localctx = new ModifierContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_modifier);
		try {
			setState(596);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				enterOuterAlt(_localctx, 1);
				{
				setState(590);
				match(T__10);
				setState(591);
				indexList();
				setState(592);
				match(T__11);
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 2);
				{
				setState(594);
				match(T__17);
				setState(595);
				field();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IndexListContext extends ParserRuleContext {
		public List<IndexContext> index() {
			return getRuleContexts(IndexContext.class);
		}
		public IndexContext index(int i) {
			return getRuleContext(IndexContext.class,i);
		}
		public IndexListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterIndexList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitIndexList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitIndexList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IndexListContext indexList() throws RecognitionException {
		IndexListContext _localctx = new IndexListContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_indexList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(598);
			index();
			setState(603);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(599);
				match(T__3);
				setState(600);
				index();
				}
				}
				setState(605);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IndexContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IndexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_index; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterIndex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitIndex(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitIndex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IndexContext index() throws RecognitionException {
		IndexContext _localctx = new IndexContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_index);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(606);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FieldContext extends ParserRuleContext {
		public Typespec type = null;
		public SymtabEntry entry = null;
		public TerminalNode IDENTIFIER() { return getToken(cppParser.IDENTIFIER, 0); }
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_field);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(608);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallContext extends ParserRuleContext {
		public FunctionNameContext functionName() {
			return getRuleContext(FunctionNameContext.class,0);
		}
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(610);
			functionName();
			setState(611);
			match(T__2);
			setState(613);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 7169730881651737352L) != 0)) {
				{
				setState(612);
				argumentList();
				}
			}

			setState(615);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionNameContext extends ParserRuleContext {
		public Typespec type = null;
		public SymtabEntry entry = null;
		public TerminalNode IDENTIFIER() { return getToken(cppParser.IDENTIFIER, 0); }
		public FunctionNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterFunctionName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitFunctionName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitFunctionName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionNameContext functionName() throws RecognitionException {
		FunctionNameContext _localctx = new FunctionNameContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_functionName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(617);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NumberContext extends ParserRuleContext {
		public UnsignedNumberContext unsignedNumber() {
			return getRuleContext(UnsignedNumberContext.class,0);
		}
		public SignContext sign() {
			return getRuleContext(SignContext.class,0);
		}
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(620);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7 || _la==T__8) {
				{
				setState(619);
				sign();
				}
			}

			setState(622);
			unsignedNumber();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnsignedNumberContext extends ParserRuleContext {
		public IntConstantContext intConstant() {
			return getRuleContext(IntConstantContext.class,0);
		}
		public DoubleConstantContext doubleConstant() {
			return getRuleContext(DoubleConstantContext.class,0);
		}
		public UnsignedNumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsignedNumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterUnsignedNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitUnsignedNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitUnsignedNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnsignedNumberContext unsignedNumber() throws RecognitionException {
		UnsignedNumberContext _localctx = new UnsignedNumberContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_unsignedNumber);
		try {
			setState(626);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(624);
				intConstant();
				}
				break;
			case DOUBLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(625);
				doubleConstant();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IntConstantContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(cppParser.INT, 0); }
		public IntConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterIntConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitIntConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitIntConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntConstantContext intConstant() throws RecognitionException {
		IntConstantContext _localctx = new IntConstantContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_intConstant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(628);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DoubleConstantContext extends ParserRuleContext {
		public TerminalNode DOUBLE() { return getToken(cppParser.DOUBLE, 0); }
		public DoubleConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doubleConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterDoubleConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitDoubleConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitDoubleConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoubleConstantContext doubleConstant() throws RecognitionException {
		DoubleConstantContext _localctx = new DoubleConstantContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_doubleConstant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(630);
			match(DOUBLE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CharacterConstantContext extends ParserRuleContext {
		public TerminalNode CHARACTER() { return getToken(cppParser.CHARACTER, 0); }
		public CharacterConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_characterConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterCharacterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitCharacterConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitCharacterConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CharacterConstantContext characterConstant() throws RecognitionException {
		CharacterConstantContext _localctx = new CharacterConstantContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_characterConstant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(632);
			match(CHARACTER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StringConstantContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(cppParser.STRING, 0); }
		public StringConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterStringConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitStringConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitStringConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringConstantContext stringConstant() throws RecognitionException {
		StringConstantContext _localctx = new StringConstantContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_stringConstant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(634);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RelOpContext extends ParserRuleContext {
		public RelOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterRelOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitRelOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitRelOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelOpContext relOp() throws RecognitionException {
		RelOpContext _localctx = new RelOpContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_relOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(636);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 7864326L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AddOpContext extends ParserRuleContext {
		public TerminalNode OR() { return getToken(cppParser.OR, 0); }
		public AddOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterAddOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitAddOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitAddOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddOpContext addOp() throws RecognitionException {
		AddOpContext _localctx = new AddOpContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_addOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(638);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 137438954240L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MulOpContext extends ParserRuleContext {
		public TerminalNode DIV() { return getToken(cppParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(cppParser.MOD, 0); }
		public TerminalNode AND() { return getToken(cppParser.AND, 0); }
		public MulOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).enterMulOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cppListener ) ((cppListener)listener).exitMulOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof cppVisitor ) return ((cppVisitor<? extends T>)visitor).visitMulOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MulOpContext mulOp() throws RecognitionException {
		MulOpContext _localctx = new MulOpContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_mulOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(640);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 120284250112L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001?\u0283\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u00071\u0002"+
		"2\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u00076\u0002"+
		"7\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007;\u0002"+
		"<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007@\u0002"+
		"A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0002E\u0007E\u0002"+
		"F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007I\u0002J\u0007J\u0002"+
		"K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002N\u0007N\u0002O\u0007O\u0002"+
		"P\u0007P\u0002Q\u0007Q\u0002R\u0007R\u0002S\u0007S\u0002T\u0007T\u0002"+
		"U\u0007U\u0002V\u0007V\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0005\u0002\u00bb\b\u0002\n\u0002\f\u0002\u00be"+
		"\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u00cf\b\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u00d4\b\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0003\u0006\u00d9\b\u0006\u0001\u0006\u0003\u0006\u00dc"+
		"\b\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0005\b\u00e3"+
		"\b\b\n\b\f\b\u00e6\t\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n"+
		"\u0005\n\u00ee\b\n\n\n\f\n\u00f1\t\n\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0001\r\u0001\r\u0001\r\u0005\r\u00fb\b\r\n\r\f\r\u00fe\t\r"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0003\u0010\u0107\b\u0010\u0001\u0010\u0001\u0010\u0003\u0010"+
		"\u010b\b\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u010f\b\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0005\u0013\u0119\b\u0013\n\u0013\f\u0013\u011c\t\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u0127\b\u0016\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0003\u0017\u012c\b\u0017\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0005\u0018\u0132\b\u0018\n\u0018\f\u0018\u0135"+
		"\t\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0005\u001c\u0149\b\u001c\n\u001c\f\u001c\u014c\t\u001c\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0003\u001d\u0151\b\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0005\u001f\u0159\b\u001f"+
		"\n\u001f\f\u001f\u015c\t\u001f\u0001 \u0001 \u0003 \u0160\b \u0001 \u0001"+
		" \u0001 \u0001 \u0003 \u0166\b \u0001 \u0003 \u0169\b \u0001 \u0001 \u0001"+
		" \u0003 \u016e\b \u0001 \u0001 \u0001!\u0001!\u0001!\u0001!\u0003!\u0176"+
		"\b!\u0001!\u0001!\u0001\"\u0001\"\u0001\"\u0001\"\u0003\"\u017e\b\"\u0001"+
		"\"\u0001\"\u0001#\u0001#\u0001#\u0001$\u0001$\u0001%\u0001%\u0001&\u0001"+
		"&\u0001&\u0005&\u018c\b&\n&\f&\u018f\t&\u0001\'\u0003\'\u0192\b\'\u0001"+
		"\'\u0001\'\u0001\'\u0001(\u0001(\u0001)\u0001)\u0001*\u0001*\u0001*\u0001"+
		"*\u0001*\u0001*\u0001*\u0003*\u01a2\b*\u0001*\u0001*\u0001*\u0001*\u0001"+
		"*\u0001*\u0003*\u01aa\b*\u0001+\u0001+\u0001+\u0001+\u0001,\u0001,\u0001"+
		"-\u0001-\u0005-\u01b4\b-\n-\f-\u01b7\t-\u0001.\u0001.\u0001.\u0001.\u0001"+
		"/\u0001/\u00010\u00010\u00011\u00011\u00011\u00011\u00011\u00011\u0001"+
		"1\u00031\u01c8\b1\u00012\u00012\u00013\u00013\u00014\u00014\u00014\u0001"+
		"4\u00014\u00014\u00015\u00015\u00015\u00015\u00015\u00015\u00015\u0001"+
		"5\u00015\u00016\u00016\u00016\u00036\u01e0\b6\u00016\u00016\u00017\u0001"+
		"7\u00018\u00018\u00018\u00058\u01e9\b8\n8\f8\u01ec\t8\u00019\u00019\u0001"+
		":\u0001:\u0001:\u0001;\u0001;\u0003;\u01f5\b;\u0001<\u0001<\u0001<\u0001"+
		"<\u0005<\u01fb\b<\n<\f<\u01fe\t<\u0001=\u0001=\u0001=\u0003=\u0203\b="+
		"\u0001>\u0003>\u0206\b>\u0001>\u0001>\u0001>\u0003>\u020b\b>\u0001?\u0001"+
		"?\u0001@\u0001@\u0001@\u0001A\u0001A\u0001A\u0001B\u0001B\u0001B\u0001"+
		"B\u0005B\u0219\bB\nB\fB\u021c\tB\u0001B\u0001B\u0001C\u0001C\u0001C\u0001"+
		"C\u0003C\u0224\bC\u0001D\u0003D\u0227\bD\u0001D\u0001D\u0001D\u0001D\u0005"+
		"D\u022d\bD\nD\fD\u0230\tD\u0001E\u0001E\u0001E\u0001E\u0005E\u0236\bE"+
		"\nE\fE\u0239\tE\u0001F\u0001F\u0001F\u0001F\u0001F\u0001F\u0001F\u0001"+
		"F\u0001F\u0001F\u0001F\u0003F\u0246\bF\u0001G\u0001G\u0005G\u024a\bG\n"+
		"G\fG\u024d\tG\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0003H\u0255\b"+
		"H\u0001I\u0001I\u0001I\u0005I\u025a\bI\nI\fI\u025d\tI\u0001J\u0001J\u0001"+
		"K\u0001K\u0001L\u0001L\u0001L\u0003L\u0266\bL\u0001L\u0001L\u0001M\u0001"+
		"M\u0001N\u0003N\u026d\bN\u0001N\u0001N\u0001O\u0001O\u0003O\u0273\bO\u0001"+
		"P\u0001P\u0001Q\u0001Q\u0001R\u0001R\u0001S\u0001S\u0001T\u0001T\u0001"+
		"U\u0001U\u0001V\u0001V\u0001V\u0000\u0000W\u0000\u0002\u0004\u0006\b\n"+
		"\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.0246"+
		"8:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a"+
		"\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2"+
		"\u00a4\u00a6\u00a8\u00aa\u00ac\u0000\u0005\u0001\u0000\b\t\u0001\u0000"+
		"./\u0002\u0000\u0001\u0002\u0013\u0016\u0002\u0000\b\t%%\u0002\u0000\u0017"+
		"\u0018\"$\u026c\u0000\u00ae\u0001\u0000\u0000\u0000\u0002\u00b1\u0001"+
		"\u0000\u0000\u0000\u0004\u00b6\u0001\u0000\u0000\u0000\u0006\u00c1\u0001"+
		"\u0000\u0000\u0000\b\u00c3\u0001\u0000\u0000\u0000\n\u00c8\u0001\u0000"+
		"\u0000\u0000\f\u00ce\u0001\u0000\u0000\u0000\u000e\u00dd\u0001\u0000\u0000"+
		"\u0000\u0010\u00df\u0001\u0000\u0000\u0000\u0012\u00e7\u0001\u0000\u0000"+
		"\u0000\u0014\u00ea\u0001\u0000\u0000\u0000\u0016\u00f2\u0001\u0000\u0000"+
		"\u0000\u0018\u00f4\u0001\u0000\u0000\u0000\u001a\u00f7\u0001\u0000\u0000"+
		"\u0000\u001c\u00ff\u0001\u0000\u0000\u0000\u001e\u0103\u0001\u0000\u0000"+
		"\u0000 \u010e\u0001\u0000\u0000\u0000\"\u0110\u0001\u0000\u0000\u0000"+
		"$\u0112\u0001\u0000\u0000\u0000&\u0115\u0001\u0000\u0000\u0000(\u011d"+
		"\u0001\u0000\u0000\u0000*\u0121\u0001\u0000\u0000\u0000,\u0126\u0001\u0000"+
		"\u0000\u0000.\u012b\u0001\u0000\u0000\u00000\u012d\u0001\u0000\u0000\u0000"+
		"2\u0138\u0001\u0000\u0000\u00004\u013a\u0001\u0000\u0000\u00006\u013e"+
		"\u0001\u0000\u0000\u00008\u0145\u0001\u0000\u0000\u0000:\u014d\u0001\u0000"+
		"\u0000\u0000<\u0154\u0001\u0000\u0000\u0000>\u0156\u0001\u0000\u0000\u0000"+
		"@\u015f\u0001\u0000\u0000\u0000B\u0171\u0001\u0000\u0000\u0000D\u0179"+
		"\u0001\u0000\u0000\u0000F\u0181\u0001\u0000\u0000\u0000H\u0184\u0001\u0000"+
		"\u0000\u0000J\u0186\u0001\u0000\u0000\u0000L\u0188\u0001\u0000\u0000\u0000"+
		"N\u0191\u0001\u0000\u0000\u0000P\u0196\u0001\u0000\u0000\u0000R\u0198"+
		"\u0001\u0000\u0000\u0000T\u01a9\u0001\u0000\u0000\u0000V\u01ab\u0001\u0000"+
		"\u0000\u0000X\u01af\u0001\u0000\u0000\u0000Z\u01b1\u0001\u0000\u0000\u0000"+
		"\\\u01b8\u0001\u0000\u0000\u0000^\u01bc\u0001\u0000\u0000\u0000`\u01be"+
		"\u0001\u0000\u0000\u0000b\u01c0\u0001\u0000\u0000\u0000d\u01c9\u0001\u0000"+
		"\u0000\u0000f\u01cb\u0001\u0000\u0000\u0000h\u01cd\u0001\u0000\u0000\u0000"+
		"j\u01d3\u0001\u0000\u0000\u0000l\u01dc\u0001\u0000\u0000\u0000n\u01e3"+
		"\u0001\u0000\u0000\u0000p\u01e5\u0001\u0000\u0000\u0000r\u01ed\u0001\u0000"+
		"\u0000\u0000t\u01ef\u0001\u0000\u0000\u0000v\u01f2\u0001\u0000\u0000\u0000"+
		"x\u01f6\u0001\u0000\u0000\u0000z\u01ff\u0001\u0000\u0000\u0000|\u0205"+
		"\u0001\u0000\u0000\u0000~\u020c\u0001\u0000\u0000\u0000\u0080\u020e\u0001"+
		"\u0000\u0000\u0000\u0082\u0211\u0001\u0000\u0000\u0000\u0084\u0214\u0001"+
		"\u0000\u0000\u0000\u0086\u021f\u0001\u0000\u0000\u0000\u0088\u0226\u0001"+
		"\u0000\u0000\u0000\u008a\u0231\u0001\u0000\u0000\u0000\u008c\u0245\u0001"+
		"\u0000\u0000\u0000\u008e\u0247\u0001\u0000\u0000\u0000\u0090\u0254\u0001"+
		"\u0000\u0000\u0000\u0092\u0256\u0001\u0000\u0000\u0000\u0094\u025e\u0001"+
		"\u0000\u0000\u0000\u0096\u0260\u0001\u0000\u0000\u0000\u0098\u0262\u0001"+
		"\u0000\u0000\u0000\u009a\u0269\u0001\u0000\u0000\u0000\u009c\u026c\u0001"+
		"\u0000\u0000\u0000\u009e\u0272\u0001\u0000\u0000\u0000\u00a0\u0274\u0001"+
		"\u0000\u0000\u0000\u00a2\u0276\u0001\u0000\u0000\u0000\u00a4\u0278\u0001"+
		"\u0000\u0000\u0000\u00a6\u027a\u0001\u0000\u0000\u0000\u00a8\u027c\u0001"+
		"\u0000\u0000\u0000\u00aa\u027e\u0001\u0000\u0000\u0000\u00ac\u0280\u0001"+
		"\u0000\u0000\u0000\u00ae\u00af\u0003\u0002\u0001\u0000\u00af\u00b0\u0003"+
		"\n\u0005\u0000\u00b0\u0001\u0001\u0000\u0000\u0000\u00b1\u00b2\u0005\u0019"+
		"\u0000\u0000\u00b2\u00b3\u0005\u0001\u0000\u0000\u00b3\u00b4\u0003\u0006"+
		"\u0003\u0000\u00b4\u00b5\u0005\u0002\u0000\u0000\u00b5\u0003\u0001\u0000"+
		"\u0000\u0000\u00b6\u00b7\u0005\u0003\u0000\u0000\u00b7\u00bc\u00057\u0000"+
		"\u0000\u00b8\u00b9\u0005\u0004\u0000\u0000\u00b9\u00bb\u00057\u0000\u0000"+
		"\u00ba\u00b8\u0001\u0000\u0000\u0000\u00bb\u00be\u0001\u0000\u0000\u0000"+
		"\u00bc\u00ba\u0001\u0000\u0000\u0000\u00bc\u00bd\u0001\u0000\u0000\u0000"+
		"\u00bd\u00bf\u0001\u0000\u0000\u0000\u00be\u00bc\u0001\u0000\u0000\u0000"+
		"\u00bf\u00c0\u0005\u0005\u0000\u0000\u00c0\u0005\u0001\u0000\u0000\u0000"+
		"\u00c1\u00c2\u00057\u0000\u0000\u00c2\u0007\u0001\u0000\u0000\u0000\u00c3"+
		"\u00c4\u0005\u001a\u0000\u0000\u00c4\u00c5\u0005\u0003\u0000\u0000\u00c5"+
		"\u00c6\u0005\u0005\u0000\u0000\u00c6\u00c7\u0003V+\u0000\u00c7\t\u0001"+
		"\u0000\u0000\u0000\u00c8\u00c9\u0003\f\u0006\u0000\u00c9\u00ca\u0003\b"+
		"\u0004\u0000\u00ca\u000b\u0001\u0000\u0000\u0000\u00cb\u00cc\u0003\u0018"+
		"\f\u0000\u00cc\u00cd\u0005\u0006\u0000\u0000\u00cd\u00cf\u0001\u0000\u0000"+
		"\u0000\u00ce\u00cb\u0001\u0000\u0000\u0000\u00ce\u00cf\u0001\u0000\u0000"+
		"\u0000\u00cf\u00d3\u0001\u0000\u0000\u0000\u00d0\u00d1\u0003$\u0012\u0000"+
		"\u00d1\u00d2\u0005\u0006\u0000\u0000\u00d2\u00d4\u0001\u0000\u0000\u0000"+
		"\u00d3\u00d0\u0001\u0000\u0000\u0000\u00d3\u00d4\u0001\u0000\u0000\u0000"+
		"\u00d4\u00d8\u0001\u0000\u0000\u0000\u00d5\u00d6\u0003\u000e\u0007\u0000"+
		"\u00d6\u00d7\u0005\u0006\u0000\u0000\u00d7\u00d9\u0001\u0000\u0000\u0000"+
		"\u00d8\u00d5\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000"+
		"\u00d9\u00db\u0001\u0000\u0000\u0000\u00da\u00dc\u0003>\u001f\u0000\u00db"+
		"\u00da\u0001\u0000\u0000\u0000\u00db\u00dc\u0001\u0000\u0000\u0000\u00dc"+
		"\r\u0001\u0000\u0000\u0000\u00dd\u00de\u0003\u0010\b\u0000\u00de\u000f"+
		"\u0001\u0000\u0000\u0000\u00df\u00e4\u0003\u0012\t\u0000\u00e0\u00e1\u0005"+
		"\u0006\u0000\u0000\u00e1\u00e3\u0003\u0012\t\u0000\u00e2\u00e0\u0001\u0000"+
		"\u0000\u0000\u00e3\u00e6\u0001\u0000\u0000\u0000\u00e4\u00e2\u0001\u0000"+
		"\u0000\u0000\u00e4\u00e5\u0001\u0000\u0000\u0000\u00e5\u0011\u0001\u0000"+
		"\u0000\u0000\u00e6\u00e4\u0001\u0000\u0000\u0000\u00e7\u00e8\u0003,\u0016"+
		"\u0000\u00e8\u00e9\u0003\u0014\n\u0000\u00e9\u0013\u0001\u0000\u0000\u0000"+
		"\u00ea\u00ef\u0003\u0016\u000b\u0000\u00eb\u00ec\u0005\u0004\u0000\u0000"+
		"\u00ec\u00ee\u0003\u0016\u000b\u0000\u00ed\u00eb\u0001\u0000\u0000\u0000"+
		"\u00ee\u00f1\u0001\u0000\u0000\u0000\u00ef\u00ed\u0001\u0000\u0000\u0000"+
		"\u00ef\u00f0\u0001\u0000\u0000\u0000\u00f0\u0015\u0001\u0000\u0000\u0000"+
		"\u00f1\u00ef\u0001\u0000\u0000\u0000\u00f2\u00f3\u00057\u0000\u0000\u00f3"+
		"\u0017\u0001\u0000\u0000\u0000\u00f4\u00f5\u0005\u001b\u0000\u0000\u00f5"+
		"\u00f6\u0003\u001a\r\u0000\u00f6\u0019\u0001\u0000\u0000\u0000\u00f7\u00fc"+
		"\u0003\u001c\u000e\u0000\u00f8\u00f9\u0005\u0006\u0000\u0000\u00f9\u00fb"+
		"\u0003\u001c\u000e\u0000\u00fa\u00f8\u0001\u0000\u0000\u0000\u00fb\u00fe"+
		"\u0001\u0000\u0000\u0000\u00fc\u00fa\u0001\u0000\u0000\u0000\u00fc\u00fd"+
		"\u0001\u0000\u0000\u0000\u00fd\u001b\u0001\u0000\u0000\u0000\u00fe\u00fc"+
		"\u0001\u0000\u0000\u0000\u00ff\u0100\u0003\u001e\u000f\u0000\u0100\u0101"+
		"\u0005\u0007\u0000\u0000\u0101\u0102\u0003 \u0010\u0000\u0102\u001d\u0001"+
		"\u0000\u0000\u0000\u0103\u0104\u00057\u0000\u0000\u0104\u001f\u0001\u0000"+
		"\u0000\u0000\u0105\u0107\u0003\"\u0011\u0000\u0106\u0105\u0001\u0000\u0000"+
		"\u0000\u0106\u0107\u0001\u0000\u0000\u0000\u0107\u010a\u0001\u0000\u0000"+
		"\u0000\u0108\u010b\u00057\u0000\u0000\u0109\u010b\u0003\u009eO\u0000\u010a"+
		"\u0108\u0001\u0000\u0000\u0000\u010a\u0109\u0001\u0000\u0000\u0000\u010b"+
		"\u010f\u0001\u0000\u0000\u0000\u010c\u010f\u0003\u00a4R\u0000\u010d\u010f"+
		"\u0003\u00a6S\u0000\u010e\u0106\u0001\u0000\u0000\u0000\u010e\u010c\u0001"+
		"\u0000\u0000\u0000\u010e\u010d\u0001\u0000\u0000\u0000\u010f!\u0001\u0000"+
		"\u0000\u0000\u0110\u0111\u0007\u0000\u0000\u0000\u0111#\u0001\u0000\u0000"+
		"\u0000\u0112\u0113\u0005\u001c\u0000\u0000\u0113\u0114\u0003&\u0013\u0000"+
		"\u0114%\u0001\u0000\u0000\u0000\u0115\u011a\u0003(\u0014\u0000\u0116\u0117"+
		"\u0005\u0006\u0000\u0000\u0117\u0119\u0003(\u0014\u0000\u0118\u0116\u0001"+
		"\u0000\u0000\u0000\u0119\u011c\u0001\u0000\u0000\u0000\u011a\u0118\u0001"+
		"\u0000\u0000\u0000\u011a\u011b\u0001\u0000\u0000\u0000\u011b\'\u0001\u0000"+
		"\u0000\u0000\u011c\u011a\u0001\u0000\u0000\u0000\u011d\u011e\u0003*\u0015"+
		"\u0000\u011e\u011f\u0005\u0007\u0000\u0000\u011f\u0120\u0003,\u0016\u0000"+
		"\u0120)\u0001\u0000\u0000\u0000\u0121\u0122\u00057\u0000\u0000\u0122+"+
		"\u0001\u0000\u0000\u0000\u0123\u0127\u0003.\u0017\u0000\u0124\u0127\u0003"+
		"6\u001b\u0000\u0125\u0127\u0003:\u001d\u0000\u0126\u0123\u0001\u0000\u0000"+
		"\u0000\u0126\u0124\u0001\u0000\u0000\u0000\u0126\u0125\u0001\u0000\u0000"+
		"\u0000\u0127-\u0001\u0000\u0000\u0000\u0128\u012c\u0003*\u0015\u0000\u0129"+
		"\u012c\u00030\u0018\u0000\u012a\u012c\u00034\u001a\u0000\u012b\u0128\u0001"+
		"\u0000\u0000\u0000\u012b\u0129\u0001\u0000\u0000\u0000\u012b\u012a\u0001"+
		"\u0000\u0000\u0000\u012c/\u0001\u0000\u0000\u0000\u012d\u012e\u0005\u0003"+
		"\u0000\u0000\u012e\u0133\u00032\u0019\u0000\u012f\u0130\u0005\u0004\u0000"+
		"\u0000\u0130\u0132\u00032\u0019\u0000\u0131\u012f\u0001\u0000\u0000\u0000"+
		"\u0132\u0135\u0001\u0000\u0000\u0000\u0133\u0131\u0001\u0000\u0000\u0000"+
		"\u0133\u0134\u0001\u0000\u0000\u0000\u0134\u0136\u0001\u0000\u0000\u0000"+
		"\u0135\u0133\u0001\u0000\u0000\u0000\u0136\u0137\u0005\u0005\u0000\u0000"+
		"\u01371\u0001\u0000\u0000\u0000\u0138\u0139\u0003\u001e\u000f\u0000\u0139"+
		"3\u0001\u0000\u0000\u0000\u013a\u013b\u0003 \u0010\u0000\u013b\u013c\u0005"+
		"\n\u0000\u0000\u013c\u013d\u0003 \u0010\u0000\u013d5\u0001\u0000\u0000"+
		"\u0000\u013e\u013f\u0005\u001d\u0000\u0000\u013f\u0140\u0005\u000b\u0000"+
		"\u0000\u0140\u0141\u00038\u001c\u0000\u0141\u0142\u0005\f\u0000\u0000"+
		"\u0142\u0143\u0005\u001e\u0000\u0000\u0143\u0144\u0003,\u0016\u0000\u0144"+
		"7\u0001\u0000\u0000\u0000\u0145\u014a\u0003.\u0017\u0000\u0146\u0147\u0005"+
		"\u0004\u0000\u0000\u0147\u0149\u0003.\u0017\u0000\u0148\u0146\u0001\u0000"+
		"\u0000\u0000\u0149\u014c\u0001\u0000\u0000\u0000\u014a\u0148\u0001\u0000"+
		"\u0000\u0000\u014a\u014b\u0001\u0000\u0000\u0000\u014b9\u0001\u0000\u0000"+
		"\u0000\u014c\u014a\u0001\u0000\u0000\u0000\u014d\u014e\u0005\u001f\u0000"+
		"\u0000\u014e\u0150\u0003<\u001e\u0000\u014f\u0151\u0005\u0006\u0000\u0000"+
		"\u0150\u014f\u0001\u0000\u0000\u0000\u0150\u0151\u0001\u0000\u0000\u0000"+
		"\u0151\u0152\u0001\u0000\u0000\u0000\u0152\u0153\u0005!\u0000\u0000\u0153"+
		";\u0001\u0000\u0000\u0000\u0154\u0155\u0003\u0010\b\u0000\u0155=\u0001"+
		"\u0000\u0000\u0000\u0156\u015a\u0003@ \u0000\u0157\u0159\u0003@ \u0000"+
		"\u0158\u0157\u0001\u0000\u0000\u0000\u0159\u015c\u0001\u0000\u0000\u0000"+
		"\u015a\u0158\u0001\u0000\u0000\u0000\u015a\u015b\u0001\u0000\u0000\u0000"+
		"\u015b?\u0001\u0000\u0000\u0000\u015c\u015a\u0001\u0000\u0000\u0000\u015d"+
		"\u0160\u0003B!\u0000\u015e\u0160\u0003D\"\u0000\u015f\u015d\u0001\u0000"+
		"\u0000\u0000\u015f\u015e\u0001\u0000\u0000\u0000\u0160\u0161\u0001\u0000"+
		"\u0000\u0000\u0161\u0165\u0005\r\u0000\u0000\u0162\u0163\u0003\u000e\u0007"+
		"\u0000\u0163\u0164\u0005\u0006\u0000\u0000\u0164\u0166\u0001\u0000\u0000"+
		"\u0000\u0165\u0162\u0001\u0000\u0000\u0000\u0165\u0166\u0001\u0000\u0000"+
		"\u0000\u0166\u0168\u0001\u0000\u0000\u0000\u0167\u0169\u0003Z-\u0000\u0168"+
		"\u0167\u0001\u0000\u0000\u0000\u0168\u0169\u0001\u0000\u0000\u0000\u0169"+
		"\u016d\u0001\u0000\u0000\u0000\u016a\u016b\u0003F#\u0000\u016b\u016c\u0005"+
		"\u0006\u0000\u0000\u016c\u016e\u0001\u0000\u0000\u0000\u016d\u016a\u0001"+
		"\u0000\u0000\u0000\u016d\u016e\u0001\u0000\u0000\u0000\u016e\u016f\u0001"+
		"\u0000\u0000\u0000\u016f\u0170\u0005\u000e\u0000\u0000\u0170A\u0001\u0000"+
		"\u0000\u0000\u0171\u0172\u00054\u0000\u0000\u0172\u0173\u0003H$\u0000"+
		"\u0173\u0175\u0005\u0003\u0000\u0000\u0174\u0176\u0003J%\u0000\u0175\u0174"+
		"\u0001\u0000\u0000\u0000\u0175\u0176\u0001\u0000\u0000\u0000\u0176\u0177"+
		"\u0001\u0000\u0000\u0000\u0177\u0178\u0005\u0005\u0000\u0000\u0178C\u0001"+
		"\u0000\u0000\u0000\u0179\u017a\u0003*\u0015\u0000\u017a\u017b\u0003H$"+
		"\u0000\u017b\u017d\u0005\u0003\u0000\u0000\u017c\u017e\u0003J%\u0000\u017d"+
		"\u017c\u0001\u0000\u0000\u0000\u017d\u017e\u0001\u0000\u0000\u0000\u017e"+
		"\u017f\u0001\u0000\u0000\u0000\u017f\u0180\u0005\u0005\u0000\u0000\u0180"+
		"E\u0001\u0000\u0000\u0000\u0181\u0182\u00056\u0000\u0000\u0182\u0183\u0003"+
		"`0\u0000\u0183G\u0001\u0000\u0000\u0000\u0184\u0185\u00057\u0000\u0000"+
		"\u0185I\u0001\u0000\u0000\u0000\u0186\u0187\u0003L&\u0000\u0187K\u0001"+
		"\u0000\u0000\u0000\u0188\u018d\u0003N\'\u0000\u0189\u018a\u0005\u0004"+
		"\u0000\u0000\u018a\u018c\u0003N\'\u0000\u018b\u0189\u0001\u0000\u0000"+
		"\u0000\u018c\u018f\u0001\u0000\u0000\u0000\u018d\u018b\u0001\u0000\u0000"+
		"\u0000\u018d\u018e\u0001\u0000\u0000\u0000\u018eM\u0001\u0000\u0000\u0000"+
		"\u018f\u018d\u0001\u0000\u0000\u0000\u0190\u0192\u0005 \u0000\u0000\u0191"+
		"\u0190\u0001\u0000\u0000\u0000\u0191\u0192\u0001\u0000\u0000\u0000\u0192"+
		"\u0193\u0001\u0000\u0000\u0000\u0193\u0194\u0003*\u0015\u0000\u0194\u0195"+
		"\u0003P(\u0000\u0195O\u0001\u0000\u0000\u0000\u0196\u0197\u0003R)\u0000"+
		"\u0197Q\u0001\u0000\u0000\u0000\u0198\u0199\u00057\u0000\u0000\u0199S"+
		"\u0001\u0000\u0000\u0000\u019a\u01a2\u0003\\.\u0000\u019b\u01a2\u0003"+
		"t:\u0000\u019c\u01a2\u0003v;\u0000\u019d\u01a2\u0003\u0080@\u0000\u019e"+
		"\u01a2\u0003\u0082A\u0000\u019f\u01a2\u0003l6\u0000\u01a0\u01a2\u0003"+
		"X,\u0000\u01a1\u019a\u0001\u0000\u0000\u0000\u01a1\u019b\u0001\u0000\u0000"+
		"\u0000\u01a1\u019c\u0001\u0000\u0000\u0000\u01a1\u019d\u0001\u0000\u0000"+
		"\u0000\u01a1\u019e\u0001\u0000\u0000\u0000\u01a1\u019f\u0001\u0000\u0000"+
		"\u0000\u01a1\u01a0\u0001\u0000\u0000\u0000\u01a2\u01a3\u0001\u0000\u0000"+
		"\u0000\u01a3\u01a4\u0005\u0006\u0000\u0000\u01a4\u01aa\u0001\u0000\u0000"+
		"\u0000\u01a5\u01aa\u0003V+\u0000\u01a6\u01aa\u0003b1\u0000\u01a7\u01aa"+
		"\u0003h4\u0000\u01a8\u01aa\u0003j5\u0000\u01a9\u01a1\u0001\u0000\u0000"+
		"\u0000\u01a9\u01a5\u0001\u0000\u0000\u0000\u01a9\u01a6\u0001\u0000\u0000"+
		"\u0000\u01a9\u01a7\u0001\u0000\u0000\u0000\u01a9\u01a8\u0001\u0000\u0000"+
		"\u0000\u01aaU\u0001\u0000\u0000\u0000\u01ab\u01ac\u0005\r\u0000\u0000"+
		"\u01ac\u01ad\u0003Z-\u0000\u01ad\u01ae\u0005\u000e\u0000\u0000\u01aeW"+
		"\u0001\u0000\u0000\u0000\u01af\u01b0\u0001\u0000\u0000\u0000\u01b0Y\u0001"+
		"\u0000\u0000\u0000\u01b1\u01b5\u0003T*\u0000\u01b2\u01b4\u0003T*\u0000"+
		"\u01b3\u01b2\u0001\u0000\u0000\u0000\u01b4\u01b7\u0001\u0000\u0000\u0000"+
		"\u01b5\u01b3\u0001\u0000\u0000\u0000\u01b5\u01b6\u0001\u0000\u0000\u0000"+
		"\u01b6[\u0001\u0000\u0000\u0000\u01b7\u01b5\u0001\u0000\u0000\u0000\u01b8"+
		"\u01b9\u0003^/\u0000\u01b9\u01ba\u0005\u0007\u0000\u0000\u01ba\u01bb\u0003"+
		"`0\u0000\u01bb]\u0001\u0000\u0000\u0000\u01bc\u01bd\u0003\u008eG\u0000"+
		"\u01bd_\u0001\u0000\u0000\u0000\u01be\u01bf\u0003\u0086C\u0000\u01bfa"+
		"\u0001\u0000\u0000\u0000\u01c0\u01c1\u0005\'\u0000\u0000\u01c1\u01c2\u0005"+
		"\u0003\u0000\u0000\u01c2\u01c3\u0003\u0086C\u0000\u01c3\u01c4\u0005\u0005"+
		"\u0000\u0000\u01c4\u01c7\u0003d2\u0000\u01c5\u01c6\u0005)\u0000\u0000"+
		"\u01c6\u01c8\u0003f3\u0000\u01c7\u01c5\u0001\u0000\u0000\u0000\u01c7\u01c8"+
		"\u0001\u0000\u0000\u0000\u01c8c\u0001\u0000\u0000\u0000\u01c9\u01ca\u0003"+
		"T*\u0000\u01cae\u0001\u0000\u0000\u0000\u01cb\u01cc\u0003T*\u0000\u01cc"+
		"g\u0001\u0000\u0000\u0000\u01cd\u01ce\u0005+\u0000\u0000\u01ce\u01cf\u0005"+
		"\u0003\u0000\u0000\u01cf\u01d0\u0003\u0086C\u0000\u01d0\u01d1\u0005\u0005"+
		"\u0000\u0000\u01d1\u01d2\u0003T*\u0000\u01d2i\u0001\u0000\u0000\u0000"+
		"\u01d3\u01d4\u0005-\u0000\u0000\u01d4\u01d5\u0003\u008eG\u0000\u01d5\u01d6"+
		"\u0005\u000f\u0000\u0000\u01d6\u01d7\u0003\u0086C\u0000\u01d7\u01d8\u0007"+
		"\u0001\u0000\u0000\u01d8\u01d9\u0003\u0086C\u0000\u01d9\u01da\u0005,\u0000"+
		"\u0000\u01da\u01db\u0003T*\u0000\u01dbk\u0001\u0000\u0000\u0000\u01dc"+
		"\u01dd\u0003n7\u0000\u01dd\u01df\u0005\u0003\u0000\u0000\u01de\u01e0\u0003"+
		"p8\u0000\u01df\u01de\u0001\u0000\u0000\u0000\u01df\u01e0\u0001\u0000\u0000"+
		"\u0000\u01e0\u01e1\u0001\u0000\u0000\u0000\u01e1\u01e2\u0005\u0005\u0000"+
		"\u0000\u01e2m\u0001\u0000\u0000\u0000\u01e3\u01e4\u00057\u0000\u0000\u01e4"+
		"o\u0001\u0000\u0000\u0000\u01e5\u01ea\u0003r9\u0000\u01e6\u01e7\u0005"+
		"\u0004\u0000\u0000\u01e7\u01e9\u0003r9\u0000\u01e8\u01e6\u0001\u0000\u0000"+
		"\u0000\u01e9\u01ec\u0001\u0000\u0000\u0000\u01ea\u01e8\u0001\u0000\u0000"+
		"\u0000\u01ea\u01eb\u0001\u0000\u0000\u0000\u01ebq\u0001\u0000\u0000\u0000"+
		"\u01ec\u01ea\u0001\u0000\u0000\u0000\u01ed\u01ee\u0003\u0086C\u0000\u01ee"+
		"s\u0001\u0000\u0000\u0000\u01ef\u01f0\u00050\u0000\u0000\u01f0\u01f1\u0003"+
		"x<\u0000\u01f1u\u0001\u0000\u0000\u0000\u01f2\u01f4\u00051\u0000\u0000"+
		"\u01f3\u01f5\u0003x<\u0000\u01f4\u01f3\u0001\u0000\u0000\u0000\u01f4\u01f5"+
		"\u0001\u0000\u0000\u0000\u01f5w\u0001\u0000\u0000\u0000\u01f6\u01f7\u0005"+
		"\u0010\u0000\u0000\u01f7\u01fc\u0003z=\u0000\u01f8\u01f9\u0005\u0004\u0000"+
		"\u0000\u01f9\u01fb\u0003z=\u0000\u01fa\u01f8\u0001\u0000\u0000\u0000\u01fb"+
		"\u01fe\u0001\u0000\u0000\u0000\u01fc\u01fa\u0001\u0000\u0000\u0000\u01fc"+
		"\u01fd\u0001\u0000\u0000\u0000\u01fdy\u0001\u0000\u0000\u0000\u01fe\u01fc"+
		"\u0001\u0000\u0000\u0000\u01ff\u0202\u0003\u0086C\u0000\u0200\u0201\u0005"+
		"\u0011\u0000\u0000\u0201\u0203\u0003|>\u0000\u0202\u0200\u0001\u0000\u0000"+
		"\u0000\u0202\u0203\u0001\u0000\u0000\u0000\u0203{\u0001\u0000\u0000\u0000"+
		"\u0204\u0206\u0003\"\u0011\u0000\u0205\u0204\u0001\u0000\u0000\u0000\u0205"+
		"\u0206\u0001\u0000\u0000\u0000\u0206\u0207\u0001\u0000\u0000\u0000\u0207"+
		"\u020a\u0003\u00a0P\u0000\u0208\u0209\u0005\u0011\u0000\u0000\u0209\u020b"+
		"\u0003~?\u0000\u020a\u0208\u0001\u0000\u0000\u0000\u020a\u020b\u0001\u0000"+
		"\u0000\u0000\u020b}\u0001\u0000\u0000\u0000\u020c\u020d\u0003\u00a0P\u0000"+
		"\u020d\u007f\u0001\u0000\u0000\u0000\u020e\u020f\u00052\u0000\u0000\u020f"+
		"\u0210\u0003\u0084B\u0000\u0210\u0081\u0001\u0000\u0000\u0000\u0211\u0212"+
		"\u00053\u0000\u0000\u0212\u0213\u0003\u0084B\u0000\u0213\u0083\u0001\u0000"+
		"\u0000\u0000\u0214\u0215\u0005\u0003\u0000\u0000\u0215\u021a\u0003\u008e"+
		"G\u0000\u0216\u0217\u0005\u0004\u0000\u0000\u0217\u0219\u0003\u008eG\u0000"+
		"\u0218\u0216\u0001\u0000\u0000\u0000\u0219\u021c\u0001\u0000\u0000\u0000"+
		"\u021a\u0218\u0001\u0000\u0000\u0000\u021a\u021b\u0001\u0000\u0000\u0000"+
		"\u021b\u021d\u0001\u0000\u0000\u0000\u021c\u021a\u0001\u0000\u0000\u0000"+
		"\u021d\u021e\u0005\u0005\u0000\u0000\u021e\u0085\u0001\u0000\u0000\u0000"+
		"\u021f\u0223\u0003\u0088D\u0000\u0220\u0221\u0003\u00a8T\u0000\u0221\u0222"+
		"\u0003\u0088D\u0000\u0222\u0224\u0001\u0000\u0000\u0000\u0223\u0220\u0001"+
		"\u0000\u0000\u0000\u0223\u0224\u0001\u0000\u0000\u0000\u0224\u0087\u0001"+
		"\u0000\u0000\u0000\u0225\u0227\u0003\"\u0011\u0000\u0226\u0225\u0001\u0000"+
		"\u0000\u0000\u0226\u0227\u0001\u0000\u0000\u0000\u0227\u0228\u0001\u0000"+
		"\u0000\u0000\u0228\u022e\u0003\u008aE\u0000\u0229\u022a\u0003\u00aaU\u0000"+
		"\u022a\u022b\u0003\u008aE\u0000\u022b\u022d\u0001\u0000\u0000\u0000\u022c"+
		"\u0229\u0001\u0000\u0000\u0000\u022d\u0230\u0001\u0000\u0000\u0000\u022e"+
		"\u022c\u0001\u0000\u0000\u0000\u022e\u022f\u0001\u0000\u0000\u0000\u022f"+
		"\u0089\u0001\u0000\u0000\u0000\u0230\u022e\u0001\u0000\u0000\u0000\u0231"+
		"\u0237\u0003\u008cF\u0000\u0232\u0233\u0003\u00acV\u0000\u0233\u0234\u0003"+
		"\u008cF\u0000\u0234\u0236\u0001\u0000\u0000\u0000\u0235\u0232\u0001\u0000"+
		"\u0000\u0000\u0236\u0239\u0001\u0000\u0000\u0000\u0237\u0235\u0001\u0000"+
		"\u0000\u0000\u0237\u0238\u0001\u0000\u0000\u0000\u0238\u008b\u0001\u0000"+
		"\u0000\u0000\u0239\u0237\u0001\u0000\u0000\u0000\u023a\u0246\u0003\u008e"+
		"G\u0000\u023b\u0246\u0003\u009cN\u0000\u023c\u0246\u0003\u00a4R\u0000"+
		"\u023d\u0246\u0003\u00a6S\u0000\u023e\u0246\u0003\u0098L\u0000\u023f\u0240"+
		"\u0005&\u0000\u0000\u0240\u0246\u0003\u008cF\u0000\u0241\u0242\u0005\u0003"+
		"\u0000\u0000\u0242\u0243\u0003\u0086C\u0000\u0243\u0244\u0005\u0005\u0000"+
		"\u0000\u0244\u0246\u0001\u0000\u0000\u0000\u0245\u023a\u0001\u0000\u0000"+
		"\u0000\u0245\u023b\u0001\u0000\u0000\u0000\u0245\u023c\u0001\u0000\u0000"+
		"\u0000\u0245\u023d\u0001\u0000\u0000\u0000\u0245\u023e\u0001\u0000\u0000"+
		"\u0000\u0245\u023f\u0001\u0000\u0000\u0000\u0245\u0241\u0001\u0000\u0000"+
		"\u0000\u0246\u008d\u0001\u0000\u0000\u0000\u0247\u024b\u0003\u0016\u000b"+
		"\u0000\u0248\u024a\u0003\u0090H\u0000\u0249\u0248\u0001\u0000\u0000\u0000"+
		"\u024a\u024d\u0001\u0000\u0000\u0000\u024b\u0249\u0001\u0000\u0000\u0000"+
		"\u024b\u024c\u0001\u0000\u0000\u0000\u024c\u008f\u0001\u0000\u0000\u0000"+
		"\u024d\u024b\u0001\u0000\u0000\u0000\u024e\u024f\u0005\u000b\u0000\u0000"+
		"\u024f\u0250\u0003\u0092I\u0000\u0250\u0251\u0005\f\u0000\u0000\u0251"+
		"\u0255\u0001\u0000\u0000\u0000\u0252\u0253\u0005\u0012\u0000\u0000\u0253"+
		"\u0255\u0003\u0096K\u0000\u0254\u024e\u0001\u0000\u0000\u0000\u0254\u0252"+
		"\u0001\u0000\u0000\u0000\u0255\u0091\u0001\u0000\u0000\u0000\u0256\u025b"+
		"\u0003\u0094J\u0000\u0257\u0258\u0005\u0004\u0000\u0000\u0258\u025a\u0003"+
		"\u0094J\u0000\u0259\u0257\u0001\u0000\u0000\u0000\u025a\u025d\u0001\u0000"+
		"\u0000\u0000\u025b\u0259\u0001\u0000\u0000\u0000\u025b\u025c\u0001\u0000"+
		"\u0000\u0000\u025c\u0093\u0001\u0000\u0000\u0000\u025d\u025b\u0001\u0000"+
		"\u0000\u0000\u025e\u025f\u0003\u0086C\u0000\u025f\u0095\u0001\u0000\u0000"+
		"\u0000\u0260\u0261\u00057\u0000\u0000\u0261\u0097\u0001\u0000\u0000\u0000"+
		"\u0262\u0263\u0003\u009aM\u0000\u0263\u0265\u0005\u0003\u0000\u0000\u0264"+
		"\u0266\u0003p8\u0000\u0265\u0264\u0001\u0000\u0000\u0000\u0265\u0266\u0001"+
		"\u0000\u0000\u0000\u0266\u0267\u0001\u0000\u0000\u0000\u0267\u0268\u0005"+
		"\u0005\u0000\u0000\u0268\u0099\u0001\u0000\u0000\u0000\u0269\u026a\u0005"+
		"7\u0000\u0000\u026a\u009b\u0001\u0000\u0000\u0000\u026b\u026d\u0003\""+
		"\u0011\u0000\u026c\u026b\u0001\u0000\u0000\u0000\u026c\u026d\u0001\u0000"+
		"\u0000\u0000\u026d\u026e\u0001\u0000\u0000\u0000\u026e\u026f\u0003\u009e"+
		"O\u0000\u026f\u009d\u0001\u0000\u0000\u0000\u0270\u0273\u0003\u00a0P\u0000"+
		"\u0271\u0273\u0003\u00a2Q\u0000\u0272\u0270\u0001\u0000\u0000\u0000\u0272"+
		"\u0271\u0001\u0000\u0000\u0000\u0273\u009f\u0001\u0000\u0000\u0000\u0274"+
		"\u0275\u00058\u0000\u0000\u0275\u00a1\u0001\u0000\u0000\u0000\u0276\u0277"+
		"\u00059\u0000\u0000\u0277\u00a3\u0001\u0000\u0000\u0000\u0278\u0279\u0005"+
		"=\u0000\u0000\u0279\u00a5\u0001\u0000\u0000\u0000\u027a\u027b\u0005>\u0000"+
		"\u0000\u027b\u00a7\u0001\u0000\u0000\u0000\u027c\u027d\u0007\u0002\u0000"+
		"\u0000\u027d\u00a9\u0001\u0000\u0000\u0000\u027e\u027f\u0007\u0003\u0000"+
		"\u0000\u027f\u00ab\u0001\u0000\u0000\u0000\u0280\u0281\u0007\u0004\u0000"+
		"\u0000\u0281\u00ad\u0001\u0000\u0000\u00001\u00bc\u00ce\u00d3\u00d8\u00db"+
		"\u00e4\u00ef\u00fc\u0106\u010a\u010e\u011a\u0126\u012b\u0133\u014a\u0150"+
		"\u015a\u015f\u0165\u0168\u016d\u0175\u017d\u018d\u0191\u01a1\u01a9\u01b5"+
		"\u01c7\u01df\u01ea\u01f4\u01fc\u0202\u0205\u020a\u021a\u0223\u0226\u022e"+
		"\u0237\u0245\u024b\u0254\u025b\u0265\u026c\u0272";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}