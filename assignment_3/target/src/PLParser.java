// Generated from java-escape by ANTLR 4.11.1

import backend.*;


import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class PLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		NUMERIC=18, STRING=19, BOOLEAN=20, ID=21, COMMENT=22, WHITESPACE=23, DOTS=24;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_printStmt = 2, RULE_assignment = 3, 
		RULE_expression = 4, RULE_loop = 5, RULE_funDef = 6, RULE_params = 7, 
		RULE_argList = 8, RULE_funCall = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "printStmt", "assignment", "expression", "loop", 
			"funDef", "params", "argList", "funCall"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'print'", "'('", "')'", "'let'", "'='", "'+'", "'-'", "'*'", 
			"'/'", "'++'", "'for'", "' in '", "'{'", "'}'", "'function'", "','", 
			null, null, null, null, null, null, "'..'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "NUMERIC", "STRING", "BOOLEAN", "ID", 
			"COMMENT", "WHITESPACE", "DOTS"
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
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }



	public PLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public Expr expr;
		public StatementContext statement;
		public TerminalNode EOF() { return getToken(PLParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			List<Expr> statements = new ArrayList<Expr>();
			setState(24); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(21);
				((ProgramContext)_localctx).statement = statement();
				statements.add(((ProgramContext)_localctx).statement.statementExpr);
				}
				}
				setState(26); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 4001836L) != 0 );
			setState(28);
			match(EOF);
			 ((ProgramContext)_localctx).expr =  new Block(statements); 
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
		public Expr statementExpr;
		public AssignmentContext assignment;
		public ExpressionContext expression;
		public LoopContext loop;
		public FunDefContext funDef;
		public PrintStmtContext printStmt;
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LoopContext loop() {
			return getRuleContext(LoopContext.class,0);
		}
		public FunDefContext funDef() {
			return getRuleContext(FunDefContext.class,0);
		}
		public PrintStmtContext printStmt() {
			return getRuleContext(PrintStmtContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		int _la;
		try {
			setState(53);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(31);
				((StatementContext)_localctx).assignment = assignment();
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(32);
					match(T__0);
					}
				}

				 ((StatementContext)_localctx).statementExpr =  ((StatementContext)_localctx).assignment.var; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(37);
				((StatementContext)_localctx).expression = expression(0);
				setState(38);
				match(T__0);
				 ((StatementContext)_localctx).statementExpr =  ((StatementContext)_localctx).expression.exprValue; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(41);
				((StatementContext)_localctx).loop = loop();
				 ((StatementContext)_localctx).statementExpr =  ((StatementContext)_localctx).loop.loopResult; 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(44);
				((StatementContext)_localctx).funDef = funDef();
				 ((StatementContext)_localctx).statementExpr =  ((StatementContext)_localctx).funDef.funcResult; 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(47);
				((StatementContext)_localctx).printStmt = printStmt();
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(48);
					match(T__0);
					}
				}

				 ((StatementContext)_localctx).statementExpr =  ((StatementContext)_localctx).printStmt.printExpr; 
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
	public static class PrintStmtContext extends ParserRuleContext {
		public Expr printExpr;
		public ExpressionContext expression;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrintStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStmt; }
	}

	public final PrintStmtContext printStmt() throws RecognitionException {
		PrintStmtContext _localctx = new PrintStmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_printStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(T__1);
			setState(56);
			match(T__2);
			setState(57);
			((PrintStmtContext)_localctx).expression = expression(0);
			setState(58);
			match(T__3);
			 ((PrintStmtContext)_localctx).printExpr =  new Print(((PrintStmtContext)_localctx).expression.exprValue); 
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
	public static class AssignmentContext extends ParserRuleContext {
		public Expr var;
		public Token ID;
		public ExpressionContext expression;
		public TerminalNode ID() { return getToken(PLParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(61);
				match(T__4);
				}
			}

			setState(64);
			((AssignmentContext)_localctx).ID = match(ID);
			setState(65);
			match(T__5);
			setState(66);
			((AssignmentContext)_localctx).expression = expression(0);
			((AssignmentContext)_localctx).var =  new Assign((((AssignmentContext)_localctx).ID!=null?((AssignmentContext)_localctx).ID.getText():null),((AssignmentContext)_localctx).expression.exprValue);
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
		public Expr exprValue;
		public ExpressionContext e1;
		public ExpressionContext expression;
		public FunCallContext funCall;
		public Token ID;
		public Token NUMERIC;
		public Token STRING;
		public Token BOOLEAN;
		public ExpressionContext e2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public FunCallContext funCall() {
			return getRuleContext(FunCallContext.class,0);
		}
		public TerminalNode ID() { return getToken(PLParser.ID, 0); }
		public TerminalNode NUMERIC() { return getToken(PLParser.NUMERIC, 0); }
		public TerminalNode STRING() { return getToken(PLParser.STRING, 0); }
		public TerminalNode BOOLEAN() { return getToken(PLParser.BOOLEAN, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(70);
				match(T__2);
				setState(71);
				((ExpressionContext)_localctx).expression = expression(0);
				setState(72);
				match(T__3);
				  ((ExpressionContext)_localctx).exprValue =  ((ExpressionContext)_localctx).expression.exprValue; 
				}
				break;
			case 2:
				{
				setState(75);
				((ExpressionContext)_localctx).funCall = funCall();
				 ((ExpressionContext)_localctx).exprValue =  ((ExpressionContext)_localctx).funCall.funCallExpr; 
				}
				break;
			case 3:
				{
				setState(78);
				((ExpressionContext)_localctx).ID = match(ID);
				 ((ExpressionContext)_localctx).exprValue =  new Deref((((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null)); 
				}
				break;
			case 4:
				{
				setState(80);
				((ExpressionContext)_localctx).NUMERIC = match(NUMERIC);
				((ExpressionContext)_localctx).exprValue =  new IntLiteral((((ExpressionContext)_localctx).NUMERIC!=null?((ExpressionContext)_localctx).NUMERIC.getText():null)); 
				}
				break;
			case 5:
				{
				setState(82);
				((ExpressionContext)_localctx).STRING = match(STRING);
				((ExpressionContext)_localctx).exprValue =  new StringLiteral((((ExpressionContext)_localctx).STRING!=null?((ExpressionContext)_localctx).STRING.getText():null)); 
				}
				break;
			case 6:
				{
				setState(84);
				((ExpressionContext)_localctx).BOOLEAN = match(BOOLEAN);
				((ExpressionContext)_localctx).exprValue =  new BooleanLiteral((((ExpressionContext)_localctx).BOOLEAN!=null?((ExpressionContext)_localctx).BOOLEAN.getText():null)); 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(115);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(113);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(88);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(89);
						match(T__6);
						setState(90);
						((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(11);
						 ((ExpressionContext)_localctx).exprValue =  new Arithmetic(Operator.Add, ((ExpressionContext)_localctx).e1.exprValue, ((ExpressionContext)_localctx).e2.exprValue);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(93);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(94);
						match(T__7);
						setState(95);
						((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(10);
						 ((ExpressionContext)_localctx).exprValue =  new Arithmetic(Operator.Sub, ((ExpressionContext)_localctx).e1.exprValue, ((ExpressionContext)_localctx).e2.exprValue);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(98);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(99);
						match(T__8);
						setState(100);
						((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(9);
						 ((ExpressionContext)_localctx).exprValue =  new Arithmetic(Operator.Mul, ((ExpressionContext)_localctx).e1.exprValue, ((ExpressionContext)_localctx).e2.exprValue);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(103);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(104);
						match(T__9);
						setState(105);
						((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(8);
						 ((ExpressionContext)_localctx).exprValue =  new Arithmetic(Operator.Div, ((ExpressionContext)_localctx).e1.exprValue, ((ExpressionContext)_localctx).e2.exprValue);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(108);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(109);
						match(T__10);
						setState(110);
						((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(7);
						 ((ExpressionContext)_localctx).exprValue =  new Arithmetic(Operator.Concat, ((ExpressionContext)_localctx).e1.exprValue, ((ExpressionContext)_localctx).e2.exprValue);
						}
						break;
					}
					} 
				}
				setState(117);
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
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LoopContext extends ParserRuleContext {
		public Expr loopResult;
		public Token ID;
		public Token val1;
		public Token val2;
		public StatementContext statement;
		public List<StatementContext> body = new ArrayList<StatementContext>();
		public TerminalNode ID() { return getToken(PLParser.ID, 0); }
		public TerminalNode DOTS() { return getToken(PLParser.DOTS, 0); }
		public List<TerminalNode> NUMERIC() { return getTokens(PLParser.NUMERIC); }
		public TerminalNode NUMERIC(int i) {
			return getToken(PLParser.NUMERIC, i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public LoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop; }
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_loop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(T__11);
			setState(119);
			match(T__2);
			setState(120);
			((LoopContext)_localctx).ID = match(ID);
			setState(121);
			match(T__12);
			setState(122);
			((LoopContext)_localctx).val1 = match(NUMERIC);
			setState(123);
			match(DOTS);
			setState(124);
			((LoopContext)_localctx).val2 = match(NUMERIC);
			setState(125);
			match(T__3);
			setState(126);
			match(T__13);
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 4001836L) != 0) {
				{
				{
				setState(127);
				((LoopContext)_localctx).statement = statement();
				((LoopContext)_localctx).body.add(((LoopContext)_localctx).statement);
				}
				}
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(133);
			match(T__14);

			            List<Expr> loopBodyExprs = new ArrayList<>();
			            for (int i = 0; i < ((LoopContext)_localctx).body.size(); i++) {
			                loopBodyExprs.add(((LoopContext)_localctx).body.get(i).statementExpr);
			            }
			            Block loopBody = new Block(loopBodyExprs);

			            ((LoopContext)_localctx).loopResult =  new Loop((((LoopContext)_localctx).ID!=null?((LoopContext)_localctx).ID.getText():null), new IntLiteral((((LoopContext)_localctx).val1!=null?((LoopContext)_localctx).val1.getText():null)), new IntLiteral((((LoopContext)_localctx).val2!=null?((LoopContext)_localctx).val2.getText():null)), loopBody);
			        
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
	public static class FunDefContext extends ParserRuleContext {
		public Expr funcResult;
		public Token ID;
		public ParamsContext params;
		public StatementContext statement;
		public List<StatementContext> body = new ArrayList<StatementContext>();
		public TerminalNode ID() { return getToken(PLParser.ID, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FunDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funDef; }
	}

	public final FunDefContext funDef() throws RecognitionException {
		FunDefContext _localctx = new FunDefContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_funDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(T__15);
			setState(137);
			((FunDefContext)_localctx).ID = match(ID);
			setState(138);
			match(T__2);
			setState(139);
			((FunDefContext)_localctx).params = params();
			setState(140);
			match(T__3);
			setState(141);
			match(T__13);
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 4001836L) != 0) {
				{
				{
				setState(142);
				((FunDefContext)_localctx).statement = statement();
				((FunDefContext)_localctx).body.add(((FunDefContext)_localctx).statement);
				}
				}
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(148);
			match(T__14);

			            List<Expr> bodyExprs = new ArrayList<>();
			            for (int i = 0; i < ((FunDefContext)_localctx).body.size(); i++) {
			                bodyExprs.add(((FunDefContext)_localctx).body.get(i).statementExpr);
			            }
			            ((FunDefContext)_localctx).funcResult =  new Declare((((FunDefContext)_localctx).ID!=null?((FunDefContext)_localctx).ID.getText():null), ((FunDefContext)_localctx).params.paramList, new Block(bodyExprs));
			        
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
	public static class ParamsContext extends ParserRuleContext {
		public List<String> paramList;
		public Token param;
		public Token ID;
		public List<Token> nextParam = new ArrayList<Token>();
		public List<TerminalNode> ID() { return getTokens(PLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PLParser.ID, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			((ParamsContext)_localctx).param = match(ID);
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__16) {
				{
				{
				setState(152);
				match(T__16);
				setState(153);
				((ParamsContext)_localctx).ID = match(ID);
				((ParamsContext)_localctx).nextParam.add(((ParamsContext)_localctx).ID);
				}
				}
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}

			        ((ParamsContext)_localctx).paramList =  new ArrayList<>();
			        _localctx.paramList.add((((ParamsContext)_localctx).param!=null?((ParamsContext)_localctx).param.getText():null));
			        for (Token token : ((ParamsContext)_localctx).nextParam) {
			            _localctx.paramList.add(token.getText());
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
	public static class ArgListContext extends ParserRuleContext {
		public List<Expr> argListExpr;
		public ExpressionContext firstArg;
		public ExpressionContext nextArg;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argList; }
	}

	public final ArgListContext argList() throws RecognitionException {
		ArgListContext _localctx = new ArgListContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_argList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			((ArgListContext)_localctx).firstArg = expression(0);
			 ((ArgListContext)_localctx).argListExpr =  new ArrayList<>(); _localctx.argListExpr.add(((ArgListContext)_localctx).firstArg.exprValue); 
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__16) {
				{
				{
				setState(163);
				match(T__16);
				setState(164);
				((ArgListContext)_localctx).nextArg = expression(0);
				 _localctx.argListExpr.add(((ArgListContext)_localctx).nextArg.exprValue); 
				}
				}
				setState(171);
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
	public static class FunCallContext extends ParserRuleContext {
		public Expr funCallExpr;
		public Token ID;
		public ArgListContext argList;
		public TerminalNode ID() { return getToken(PLParser.ID, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public FunCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funCall; }
	}

	public final FunCallContext funCall() throws RecognitionException {
		FunCallContext _localctx = new FunCallContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_funCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			((FunCallContext)_localctx).ID = match(ID);
			setState(173);
			match(T__2);
			setState(174);
			((FunCallContext)_localctx).argList = argList();
			setState(175);
			match(T__3);
			 ((FunCallContext)_localctx).funCallExpr =  new Invoke((((FunCallContext)_localctx).ID!=null?((FunCallContext)_localctx).ID.getText():null), ((FunCallContext)_localctx).argList.argListExpr); 
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 10);
		case 1:
			return precpred(_ctx, 9);
		case 2:
			return precpred(_ctx, 8);
		case 3:
			return precpred(_ctx, 7);
		case 4:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0018\u00b3\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0004\u0000\u0019\b\u0000\u000b\u0000\f\u0000\u001a\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0003\u0001\"\b\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u00012\b\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u00016\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0003\u0003?\b\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004W\b\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0005\u0004r\b\u0004\n\u0004\f\u0004u\t\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0005\u0005\u0081\b\u0005\n\u0005\f\u0005\u0084"+
		"\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u0090"+
		"\b\u0006\n\u0006\f\u0006\u0093\t\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u009b\b\u0007\n\u0007"+
		"\f\u0007\u009e\t\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0005\b\u00a8\b\b\n\b\f\b\u00ab\t\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0000\u0001\b\n\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0000\u0000\u00be\u0000\u0014\u0001"+
		"\u0000\u0000\u0000\u00025\u0001\u0000\u0000\u0000\u00047\u0001\u0000\u0000"+
		"\u0000\u0006>\u0001\u0000\u0000\u0000\bV\u0001\u0000\u0000\u0000\nv\u0001"+
		"\u0000\u0000\u0000\f\u0088\u0001\u0000\u0000\u0000\u000e\u0097\u0001\u0000"+
		"\u0000\u0000\u0010\u00a1\u0001\u0000\u0000\u0000\u0012\u00ac\u0001\u0000"+
		"\u0000\u0000\u0014\u0018\u0006\u0000\uffff\uffff\u0000\u0015\u0016\u0003"+
		"\u0002\u0001\u0000\u0016\u0017\u0006\u0000\uffff\uffff\u0000\u0017\u0019"+
		"\u0001\u0000\u0000\u0000\u0018\u0015\u0001\u0000\u0000\u0000\u0019\u001a"+
		"\u0001\u0000\u0000\u0000\u001a\u0018\u0001\u0000\u0000\u0000\u001a\u001b"+
		"\u0001\u0000\u0000\u0000\u001b\u001c\u0001\u0000\u0000\u0000\u001c\u001d"+
		"\u0005\u0000\u0000\u0001\u001d\u001e\u0006\u0000\uffff\uffff\u0000\u001e"+
		"\u0001\u0001\u0000\u0000\u0000\u001f!\u0003\u0006\u0003\u0000 \"\u0005"+
		"\u0001\u0000\u0000! \u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000"+
		"\"#\u0001\u0000\u0000\u0000#$\u0006\u0001\uffff\uffff\u0000$6\u0001\u0000"+
		"\u0000\u0000%&\u0003\b\u0004\u0000&\'\u0005\u0001\u0000\u0000\'(\u0006"+
		"\u0001\uffff\uffff\u0000(6\u0001\u0000\u0000\u0000)*\u0003\n\u0005\u0000"+
		"*+\u0006\u0001\uffff\uffff\u0000+6\u0001\u0000\u0000\u0000,-\u0003\f\u0006"+
		"\u0000-.\u0006\u0001\uffff\uffff\u0000.6\u0001\u0000\u0000\u0000/1\u0003"+
		"\u0004\u0002\u000002\u0005\u0001\u0000\u000010\u0001\u0000\u0000\u0000"+
		"12\u0001\u0000\u0000\u000023\u0001\u0000\u0000\u000034\u0006\u0001\uffff"+
		"\uffff\u000046\u0001\u0000\u0000\u00005\u001f\u0001\u0000\u0000\u0000"+
		"5%\u0001\u0000\u0000\u00005)\u0001\u0000\u0000\u00005,\u0001\u0000\u0000"+
		"\u00005/\u0001\u0000\u0000\u00006\u0003\u0001\u0000\u0000\u000078\u0005"+
		"\u0002\u0000\u000089\u0005\u0003\u0000\u00009:\u0003\b\u0004\u0000:;\u0005"+
		"\u0004\u0000\u0000;<\u0006\u0002\uffff\uffff\u0000<\u0005\u0001\u0000"+
		"\u0000\u0000=?\u0005\u0005\u0000\u0000>=\u0001\u0000\u0000\u0000>?\u0001"+
		"\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000@A\u0005\u0015\u0000\u0000"+
		"AB\u0005\u0006\u0000\u0000BC\u0003\b\u0004\u0000CD\u0006\u0003\uffff\uffff"+
		"\u0000D\u0007\u0001\u0000\u0000\u0000EF\u0006\u0004\uffff\uffff\u0000"+
		"FG\u0005\u0003\u0000\u0000GH\u0003\b\u0004\u0000HI\u0005\u0004\u0000\u0000"+
		"IJ\u0006\u0004\uffff\uffff\u0000JW\u0001\u0000\u0000\u0000KL\u0003\u0012"+
		"\t\u0000LM\u0006\u0004\uffff\uffff\u0000MW\u0001\u0000\u0000\u0000NO\u0005"+
		"\u0015\u0000\u0000OW\u0006\u0004\uffff\uffff\u0000PQ\u0005\u0012\u0000"+
		"\u0000QW\u0006\u0004\uffff\uffff\u0000RS\u0005\u0013\u0000\u0000SW\u0006"+
		"\u0004\uffff\uffff\u0000TU\u0005\u0014\u0000\u0000UW\u0006\u0004\uffff"+
		"\uffff\u0000VE\u0001\u0000\u0000\u0000VK\u0001\u0000\u0000\u0000VN\u0001"+
		"\u0000\u0000\u0000VP\u0001\u0000\u0000\u0000VR\u0001\u0000\u0000\u0000"+
		"VT\u0001\u0000\u0000\u0000Ws\u0001\u0000\u0000\u0000XY\n\n\u0000\u0000"+
		"YZ\u0005\u0007\u0000\u0000Z[\u0003\b\u0004\u000b[\\\u0006\u0004\uffff"+
		"\uffff\u0000\\r\u0001\u0000\u0000\u0000]^\n\t\u0000\u0000^_\u0005\b\u0000"+
		"\u0000_`\u0003\b\u0004\n`a\u0006\u0004\uffff\uffff\u0000ar\u0001\u0000"+
		"\u0000\u0000bc\n\b\u0000\u0000cd\u0005\t\u0000\u0000de\u0003\b\u0004\t"+
		"ef\u0006\u0004\uffff\uffff\u0000fr\u0001\u0000\u0000\u0000gh\n\u0007\u0000"+
		"\u0000hi\u0005\n\u0000\u0000ij\u0003\b\u0004\bjk\u0006\u0004\uffff\uffff"+
		"\u0000kr\u0001\u0000\u0000\u0000lm\n\u0006\u0000\u0000mn\u0005\u000b\u0000"+
		"\u0000no\u0003\b\u0004\u0007op\u0006\u0004\uffff\uffff\u0000pr\u0001\u0000"+
		"\u0000\u0000qX\u0001\u0000\u0000\u0000q]\u0001\u0000\u0000\u0000qb\u0001"+
		"\u0000\u0000\u0000qg\u0001\u0000\u0000\u0000ql\u0001\u0000\u0000\u0000"+
		"ru\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000st\u0001\u0000\u0000"+
		"\u0000t\t\u0001\u0000\u0000\u0000us\u0001\u0000\u0000\u0000vw\u0005\f"+
		"\u0000\u0000wx\u0005\u0003\u0000\u0000xy\u0005\u0015\u0000\u0000yz\u0005"+
		"\r\u0000\u0000z{\u0005\u0012\u0000\u0000{|\u0005\u0018\u0000\u0000|}\u0005"+
		"\u0012\u0000\u0000}~\u0005\u0004\u0000\u0000~\u0082\u0005\u000e\u0000"+
		"\u0000\u007f\u0081\u0003\u0002\u0001\u0000\u0080\u007f\u0001\u0000\u0000"+
		"\u0000\u0081\u0084\u0001\u0000\u0000\u0000\u0082\u0080\u0001\u0000\u0000"+
		"\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u0085\u0001\u0000\u0000"+
		"\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0085\u0086\u0005\u000f\u0000"+
		"\u0000\u0086\u0087\u0006\u0005\uffff\uffff\u0000\u0087\u000b\u0001\u0000"+
		"\u0000\u0000\u0088\u0089\u0005\u0010\u0000\u0000\u0089\u008a\u0005\u0015"+
		"\u0000\u0000\u008a\u008b\u0005\u0003\u0000\u0000\u008b\u008c\u0003\u000e"+
		"\u0007\u0000\u008c\u008d\u0005\u0004\u0000\u0000\u008d\u0091\u0005\u000e"+
		"\u0000\u0000\u008e\u0090\u0003\u0002\u0001\u0000\u008f\u008e\u0001\u0000"+
		"\u0000\u0000\u0090\u0093\u0001\u0000\u0000\u0000\u0091\u008f\u0001\u0000"+
		"\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092\u0094\u0001\u0000"+
		"\u0000\u0000\u0093\u0091\u0001\u0000\u0000\u0000\u0094\u0095\u0005\u000f"+
		"\u0000\u0000\u0095\u0096\u0006\u0006\uffff\uffff\u0000\u0096\r\u0001\u0000"+
		"\u0000\u0000\u0097\u009c\u0005\u0015\u0000\u0000\u0098\u0099\u0005\u0011"+
		"\u0000\u0000\u0099\u009b\u0005\u0015\u0000\u0000\u009a\u0098\u0001\u0000"+
		"\u0000\u0000\u009b\u009e\u0001\u0000\u0000\u0000\u009c\u009a\u0001\u0000"+
		"\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000\u009d\u009f\u0001\u0000"+
		"\u0000\u0000\u009e\u009c\u0001\u0000\u0000\u0000\u009f\u00a0\u0006\u0007"+
		"\uffff\uffff\u0000\u00a0\u000f\u0001\u0000\u0000\u0000\u00a1\u00a2\u0003"+
		"\b\u0004\u0000\u00a2\u00a9\u0006\b\uffff\uffff\u0000\u00a3\u00a4\u0005"+
		"\u0011\u0000\u0000\u00a4\u00a5\u0003\b\u0004\u0000\u00a5\u00a6\u0006\b"+
		"\uffff\uffff\u0000\u00a6\u00a8\u0001\u0000\u0000\u0000\u00a7\u00a3\u0001"+
		"\u0000\u0000\u0000\u00a8\u00ab\u0001\u0000\u0000\u0000\u00a9\u00a7\u0001"+
		"\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000\u0000\u0000\u00aa\u0011\u0001"+
		"\u0000\u0000\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000\u00ac\u00ad\u0005"+
		"\u0015\u0000\u0000\u00ad\u00ae\u0005\u0003\u0000\u0000\u00ae\u00af\u0003"+
		"\u0010\b\u0000\u00af\u00b0\u0005\u0004\u0000\u0000\u00b0\u00b1\u0006\t"+
		"\uffff\uffff\u0000\u00b1\u0013\u0001\u0000\u0000\u0000\f\u001a!15>Vqs"+
		"\u0082\u0091\u009c\u00a9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}