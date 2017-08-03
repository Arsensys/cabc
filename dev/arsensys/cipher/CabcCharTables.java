package dev.arsensys.cipher;

/**
 *
 * @author Arsen_Toor arsensys@gmail.com
 */
public class CabcCharTables {
    
    /*
    Feel free to use your own tables characters order.
    */

    private String[] charTable;
    private final String[] volatil = {"0", "A", "1", "D", "F", "K"};

    public CabcCharTables() {
        charTable = null;
    }

    public String[] getCharTable() {
        return charTable;
    }

    public void setCharTable(int nct) {
        switch (nct) {
            case 1:
                charTable1();
                break;
            case 2:
                charTable2();
                break;
            case 3:
                charTable3();
                break;
            default:
                charTable2();
                break;
        }
    }

    private void charTable1() {
        String[] ct = {
            "H", "|", "J", "*", "z", ",", "K", "(", "M", "$",
            "%", "&", "k", "O", "P", "-", ".", "/", "Q", "R",
            "S", "#", "U", "7", ":", "Y", "<", "W", "X", ";",
            "Z", "[", "r", "]", "^", "_", "E", "F", "G", "!",
            "\"", "T", "a", "}", "c", "d", "e", "f", "'", "L",
            ")", "g", "x", "i", "=", "4", "?", "j", "N", "l",
            "m", "D", "o", "{", "I", "b", "~", "5", "q", "s",
            "\\", "t", "u", "v", "w", "h", "y", "+", "A", "2",
            "C", "n", "@", "0", "1", "B", "3", ">", "p", "6",
            "¡", "V", "8", " ", "9"
        };
        charTable = ct;
    }

    private void charTable2() {
        String[] ct = {
            ";", "U", "c", "H", "0", "@", "g", "!", "*", "M",
            "W", "N", ",", "-", "[", "\\", "_", "h", "b", "Z",
            "S", "}", "i", "6", "k", "3", "(", ":", "$", "v",
            "r", "p", "T", "~", "n", "a", "{", "t", "&", "'",
            "q", "o", "C", "D", "s", "|", "w", "x", "O", "P",
            "Q", "4", "Y", "V", ".", "/", "+", "X", "<", " ",
            "7", "B", "E", "F", ">", "?", "G", "d", "l", "R",
            "I", "J", "]", "^", "A", "8", "9", "=", "5", "j",
            "K", "L", "\"", "#", "f", "e", "1", "2", "u", "%",
            "m", "¡", ")", "y", "z"
        };
        charTable = ct;
    }

    private void charTable3() {
        String[] ct = {
            "N", "2", "Q", "4", "6", "^", "_", "9", "J", "\"",
            "b", "{", "c", "F", "e", "3", ",", "-", "O", ":",
            "<", "f", "h", "i", "j", "&", "C", "$", "%", "'",
            "p", "q", "w", "r", "T", "}", "~", "@", "0", "a",
            "I", "#", "K", "1", "L", "M", "u", "v", "s", "x",
            "D", "y", "z", "A", "d", "B", "t", "E", "G", "!",
            "Y", "(", "7", ")", "*", "5", "R", "+", "S", "U",
            "k", "l", "n", "o", "\\", ";", "g", "=", ">", "?",
            "V", "/", "W", ".", "P", "X", "|", "Z", "m", "]",
            "H", "[", "8", " ", "¡"
        };
        charTable = ct;
    }

    public String getBeanCt(int beanpos, int ct) {
        String str = volatil[beanpos];
        str += volatil[ct];
        return str;
    }

    public int getBeanCtPos(String carac) {
        for (int z = 0; z < volatil.length; z++) {
            if (carac.equals(volatil[z])) {
                return z;
            }
        }
        return 0;
    }
}