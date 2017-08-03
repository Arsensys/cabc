package dev.arsensys.cipher;

/**
 *
 * @author Arsen_Toor arsensys@gmail.com
 */
public class CabcAlgorithm {

    private String[] charTable = null;

    /*Allows you to encrypt any String (Based on tables characters)*/
    public String wrapper(String chain) {
        //Get the charecters table number
        short tc = (short) (Math.random() * 3 + 1);
        //Creatra instance of CabcCharTables
        CabcCharTables cct = new CabcCharTables();
        //Set the charecters table number in  CabcCharTablesenvia.
        cct.setCharTable(tc);
        //Get the charecters table
        charTable = cct.getCharTable();
        if (validChain(chain)) {
            int bean = (int) (Math.random() * 4 + 1);
            String cripted = cct.getBeanCt(bean, tc);
            for (int x = 0; x < chain.length(); x++) {
                cripted += recover(String.valueOf(Integer.toHexString(getCharPos(String.valueOf(chain.charAt(x)), bean))));
            }
            return cripted.toUpperCase();
        }
        return "Error";
    }
    /*Checks if the whole String is supported by the tables characters*/

    private boolean validChain(String chain) {
        if (chain == null) {
            return false;
        }

        for (int c = 0; c < chain.length(); c++) {
            if (!exisChar(String.valueOf(chain.charAt(c)))) {
                return false;
            }
        }
        return true;
    }

    private String recover(String value) {
        String[] exe = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        for (short m = 0; m < exe.length; m++) {
            if (value.toUpperCase().equals(exe[m])) {
                return ("0" + value);
            }
        }
        return value;
    }

    private int getCharPos(String charac, int bean) {
        int pos = 1;
        for (short p = 0; p < charTable.length; p++) {
            if (charac.equals(charTable[p])) {
                pos = p + 1;
            }
        }
        return (pos + bean);
    }

    private boolean exisChar(String c) {
        for (short d = 0; d < charTable.length; d++) {
            if (c.equals(charTable[d])) {
                return true;
            }
        }
        return false;
    }

    public String inverseCabc(String hash) {
        String pwd = "";
        if (hash != null && !"".equals(hash.trim()) && !"Error".equals(hash.trim())) {
            try {
                String[] part = new String[(hash.length() / 2)];
                charTable = null;
                CabcCharTables cct = new CabcCharTables();
                int s = 0;
                for (int z = 0; z < (hash.length() / 2); z++) {
                    part[z] = hash.substring(s, (s + 2));
                    s += 2;
                }

                int bean = cct.getBeanCtPos(part[0].substring(0, 1));
                int disp = cct.getBeanCtPos(part[0].substring(1, 2));
                cct.setCharTable(disp);
                charTable = cct.getCharTable();
                int parser;
                for (int x = 1; x < part.length; x++) {
                    parser = Integer.parseInt(part[x], 16);
                    parser = parser - bean;
                    pwd += charTable[parser - 1];
                }
            } catch (Exception ex) {
                pwd = "Error";
            }
        } else {
            pwd = "Error";
        }
        return pwd;
    }

}
