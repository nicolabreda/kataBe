package kata;

abstract class Packet {
    int version;
    int type;

    public Packet(int version, int type) {
        this.version = version;
        this.type = type;
    }

    public abstract int decode(String line, int start);

    public abstract int sumVersion();

    public abstract long calculate();

    public String encode() {
        String ver = Day16.stringNumToBin(version);
        if (ver.length() > 3) {
            throw new RuntimeException("Version " + ver + "too long " + ver.length());
        } else {
            if (ver.length() == 1) {
                ver = "00" + ver;
            } else if (ver.length() == 2) {
                ver = "0" + ver;
            }
        }
        String typ = Day16.stringNumToBin(type);
        if (typ.length() > 3) {
            throw new RuntimeException("Version " + typ + "too long " + typ.length());
        } else {
            if (typ.length() == 1) {
                typ = "00" + typ;
            } else if (typ.length() == 2) {
                typ = "0" + typ;
            }
        }
        return ver + typ;
    }

    public String write() {

        String num = encode();

        //System.out.println("00111000000000000110111101000101001010010001001000000000");
        //System.out.println(num);

        String ret = "";
        for (int i = 0; i < num.length(); ) {
            if (i + 4 < num.length()) {
                ret += Day16.decoder.get(num.substring(i, i + 4));
                i += 4;
            } else {
                String v = num.substring(i);
                if (v.length() == 1) {
                    ret += Day16.decoder.get(num.substring(i) + "000");
                } else if (v.length() == 2) {
                    ret += Day16.decoder.get(num.substring(i) + "00");
                } else if (v.length() == 3) {
                    ret += Day16.decoder.get(num.substring(i) + "0");
                } else if (v.length() == 4) {
                    ret += Day16.decoder.get(num.substring(i));
                }

                break;
            }
        }

        return ret;
    }
}
