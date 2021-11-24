/* wh0parser.java */
/* Generated By:JavaCC: Do not edit this line. wh0parser.java */
package de.prodevmo.w0parser;
import java.io.*;

//import de.prodevmo.*;

public class wh0parser implements wh0parserConstants {
    static wh0parser whi= null;
    public URMBuilder urmbi = null;

    /** Main entry point. */
  public static String parse(FileInputStream _fis_instance, String _urm_output_path) throws Exception {
        if(whi == null){
            whi = new wh0parser(_fis_instance);
        }else{
            ReInit(_fis_instance);
        }

        if(whi.urmbi == null){
            whi.urmbi = new URMBuilder();
        }

        wh0parser.program();

        //WRITE URM PROGRAM TO FILE IF PATH IS GIVEN
        if(_urm_output_path != null){
            whi.urmbi.write_urm_to_file(_urm_output_path);
        }
       return null;
  }

  static final public void program() throws ParseException {Token t;
    t = jj_consume_token(IDENT);
whi.urmbi.set_program_name(t.image);
    jj_consume_token(LEFT_BRACKET_ROUND);
    program_var_in();
    jj_consume_token(SEMICOLON);
    program_var_out();
    jj_consume_token(RIGHT_BRACKET_ROUND);
    jj_consume_token(SEMICOLON);
    jj_consume_token(VAR);
    jj_consume_token(LEFT_BRACKET_ROUND);
    var_help();
    jj_consume_token(RIGHT_BRACKET_ROUND);
    jj_consume_token(SEMICOLON);
    sequence();
}

  static final public void program_var_in() throws ParseException {Token t;
    jj_consume_token(IN);
    t = jj_consume_token(IDENT);
whi.urmbi.reg_reg_in(t.image);
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case COMMA:{
        ;
        break;
        }
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      jj_consume_token(COMMA);
      t = jj_consume_token(IDENT);
whi.urmbi.reg_reg_in(t.image);
    }
}

  static final public void program_var_out() throws ParseException {Token t;
    jj_consume_token(OUT);
    t = jj_consume_token(IDENT);
whi.urmbi.reg_reg_out(t.image);
}

  static final public void var_help() throws ParseException {Token t;
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case IDENT:{
        ;
        break;
        }
      default:
        jj_la1[1] = jj_gen;
        break label_2;
      }
      t = jj_consume_token(IDENT);
whi.urmbi.reg_reg(t.image);
      label_3:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case COMMA:{
          ;
          break;
          }
        default:
          jj_la1[2] = jj_gen;
          break label_3;
        }
        jj_consume_token(COMMA);
        t = jj_consume_token(IDENT);
whi.urmbi.reg_reg(t.image);
      }
    }
}

  static final public void sequence() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case IDENT:{
      variable_assign();
      break;
      }
    case WHILE:{
      while_do();
      break;
      }
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case SEMICOLON:{
      jj_consume_token(SEMICOLON);
      sequence();
      break;
      }
    default:
      jj_la1[4] = jj_gen;
      ;
    }
}

  static final public void variable_assign() throws ParseException {
    jj_consume_token(IDENT);
    jj_consume_token(EQUALS_ASSIGN);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case ZERO:{
      jj_consume_token(ZERO);
      break;
      }
    case IDENT:{
      jj_consume_token(IDENT);
      jj_consume_token(PLUS);
      jj_consume_token(ONE);
      break;
      }
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
}

  static final public void while_do() throws ParseException {
    jj_consume_token(WHILE);
    jj_consume_token(IDENT);
    jj_consume_token(NOTEQUALS);
    jj_consume_token(IDENT);
    jj_consume_token(DO);
    jj_consume_token(BEGIN);
    sequence();
    jj_consume_token(END);
}

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public wh0parserTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[6];
  static private int[] jj_la1_0;
  static {
	   jj_la1_init_0();
	}
	private static void jj_la1_init_0() {
	   jj_la1_0 = new int[] {0x4000,0x20000,0x4000,0x20200,0x2000,0x20040,};
	}

  /** Constructor with InputStream. */
  public wh0parser(java.io.InputStream stream) {
	  this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public wh0parser(java.io.InputStream stream, String encoding) {
	 if (jj_initialized_once) {
	   System.out.println("ERROR: Second call to constructor of static parser.  ");
	   System.out.println("	   You must either use ReInit() or set the JavaCC option STATIC to false");
	   System.out.println("	   during parser generation.");
	   throw new Error();
	 }
	 jj_initialized_once = true;
	 try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source = new wh0parserTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
	  ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public wh0parser(java.io.Reader stream) {
	 if (jj_initialized_once) {
	   System.out.println("ERROR: Second call to constructor of static parser. ");
	   System.out.println("	   You must either use ReInit() or set the JavaCC option STATIC to false");
	   System.out.println("	   during parser generation.");
	   throw new Error();
	 }
	 jj_initialized_once = true;
	 jj_input_stream = new SimpleCharStream(stream, 1, 1);
	 token_source = new wh0parserTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
	if (jj_input_stream == null) {
	   jj_input_stream = new SimpleCharStream(stream, 1, 1);
	} else {
	   jj_input_stream.ReInit(stream, 1, 1);
	}
	if (token_source == null) {
 token_source = new wh0parserTokenManager(jj_input_stream);
	}

	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public wh0parser(wh0parserTokenManager tm) {
	 if (jj_initialized_once) {
	   System.out.println("ERROR: Second call to constructor of static parser. ");
	   System.out.println("	   You must either use ReInit() or set the JavaCC option STATIC to false");
	   System.out.println("	   during parser generation.");
	   throw new Error();
	 }
	 jj_initialized_once = true;
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(wh0parserTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
	 Token oldToken;
	 if ((oldToken = token).next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 if (token.kind == kind) {
	   jj_gen++;
	   return token;
	 }
	 token = oldToken;
	 jj_kind = kind;
	 throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
	 if (token.next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 jj_gen++;
	 return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
	 Token t = token;
	 for (int i = 0; i < index; i++) {
	   if (t.next != null) t = t.next;
	   else t = t.next = token_source.getNextToken();
	 }
	 return t;
  }

  static private int jj_ntk_f() {
	 if ((jj_nt=token.next) == null)
	   return (jj_ntk = (token.next=token_source.getNextToken()).kind);
	 else
	   return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
	 jj_expentries.clear();
	 boolean[] la1tokens = new boolean[22];
	 if (jj_kind >= 0) {
	   la1tokens[jj_kind] = true;
	   jj_kind = -1;
	 }
	 for (int i = 0; i < 6; i++) {
	   if (jj_la1[i] == jj_gen) {
		 for (int j = 0; j < 32; j++) {
		   if ((jj_la1_0[i] & (1<<j)) != 0) {
			 la1tokens[j] = true;
		   }
		 }
	   }
	 }
	 for (int i = 0; i < 22; i++) {
	   if (la1tokens[i]) {
		 jj_expentry = new int[1];
		 jj_expentry[0] = i;
		 jj_expentries.add(jj_expentry);
	   }
	 }
	 int[][] exptokseq = new int[jj_expentries.size()][];
	 for (int i = 0; i < jj_expentries.size(); i++) {
	   exptokseq[i] = jj_expentries.get(i);
	 }
	 return new ParseException(token, exptokseq, tokenImage);
  }

  static private boolean trace_enabled;

/** Trace enabled. */
  static final public boolean trace_enabled() {
	 return trace_enabled;
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
