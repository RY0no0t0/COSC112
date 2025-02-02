import java.io.InputStream;

import javax.naming.directory.InvalidAttributeIdentifierException;

import java.io.IOException;

public class Parser {

    public static void main (String[] args) {

        Parser p = new Parser(System.in);
        int    x = 0;
        try {
            x = p.readInt();
        } catch (IOException e) {
            System.out.println("Reading error: " + e);
            return;
        } catch (InvalidIntegerException e) {
            System.out.println("Could not read integer: " + e);
            return;
        }
        System.out.println("x = " + x);
        
    }

    public Parser (InputStream in) {

        _in = in;

    } // Parser ()

    public int readInt () throws IOException, InvalidIntegerException {

        int state = 0;
        int count = 0;
        int negative = 0;
        int x = 0;

        while (true) {
            int i = _in.read();

            if (state == 0) {
                if ((i == -1) || (i == 10)) {
                    throw new InvalidIntegerException();
                }
                int[] results = InitialState(i, x, state);
                x = results[0]; state = results[1];
            }

            else if (state == 3) {
                if ((i == -1) || (i == 10)) {
                    throw new InvalidIntegerException();
                }
                int[] results = NegativeState(i, x, state, negative);
                x = results[0]; state = results[1]; negative = results[2];
            }
            else if (state == 1) {
                if ((i==10) || (i==-1)) {
                    break;
                }
                int[] results = DigitState(i, x, state);
                x = results[0]; state = results[1];
            }
            else if (state ==2) {
                if ((i==10) || (i==-1)) {
                    break;
                }
                WhitespaceState(i);
            }
            else if (state == 4) {
                if (count == 3) {
                    if ((i==10) || (i==-1)) {
                        break;
                    }
                    int[] results = CommaState(i, state, count);
                    count = results[0]; state = results[1];
                } else {
                    if ((i==10) || (i==-1)) {
                        throw new InvalidIntegerException();
                    }
                    int[] results = CommaDigitState(i, x, count);
                    x = results[0]; count = results[1];
                }
            }
        }

        if (negative == 1) {
            x = -x;
        }

        return x;
        
    } // readInt ()

    public int[] InitialState (int i, int x, int state) throws InvalidIntegerException {
        char c = (char)i;
        if (Character.isDigit(c)) {
            x = x*10 + (c-'0');
            state = 1;
        } else if (c == '-') {
            state = 3;
        } else if (!Character.isWhitespace(c)) {
            throw new InvalidIntegerException();
        }
        int [] results = new int[]{x, state};
        return results;
    }

    public int[] NegativeState (int i, int x, int state, int negative) throws InvalidIntegerException {
        char c = (char)i;
        if (Character.isDigit(c)) {
            x = x*10 + (c-'0');
            negative = 1;
            state = 1;
        } else {
            throw new InvalidIntegerException();
        }
        int [] results = new int[]{x, state, negative};
        return results;
    }

    public int[] DigitState (int i, int x, int state) throws InvalidIntegerException {
        char c = (char)i;
        if (x < 1000) {
            if (Character.isDigit(c)) {
                x = x*10 + (c-'0');
            } else if (Character.isWhitespace(c)) {
                state = 2;
            } else if (c == ',') {
                state = 4;
            } else {
                throw new InvalidIntegerException();
            }
        } else {
            if (Character.isDigit(c)) {
                x = x*10 + (c-'0');
            } else if (Character.isWhitespace(c)) {
                state = 2;
            } else {
                throw new InvalidIntegerException();
            }
        }
        int [] results = new int[]{x, state};
        return results;
    }

    public void WhitespaceState (int i) throws InvalidIntegerException {
        char c = (char)i;
        if (!Character.isWhitespace(c)) {
            throw new InvalidIntegerException();
        }
    }

    public int[] CommaState (int i, int state, int count) throws InvalidIntegerException {
        char c = (char)i;
        if (Character.isWhitespace(c)) {
            state = 2;
        } else if (c != ',') {
            throw new InvalidIntegerException();
        }
        count = 0;
        int [] results = new int[]{count, state};
        return results;
    }

    public int[] CommaDigitState (int i, int x, int count) throws InvalidIntegerException {
        char c = (char)i;
        count ++;
        if (Character.isDigit(c)) {
            x = x*10 + (c-'0');
        } else{
            throw new InvalidIntegerException();
        }
        int [] results = new int[]{x, count};
        return results;
    }
    
    private InputStream _in;
    
} // class Parser
