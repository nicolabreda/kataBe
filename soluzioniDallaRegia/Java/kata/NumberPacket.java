package kata;

class NumberPacket extends Packet {

    long val;
    boolean toBePadded;

    public NumberPacket(int version, int type) {
        this(version, type, true);
        ////System.out.println("NUMBER PACKET");
    }

    public NumberPacket(int version, int type, boolean toBePadded) {
        super(version, type);
        this.toBePadded = toBePadded;
        ////System.out.println("NUMBER PACKET "+ toBePadded);
    }


    @Override
    public int decode(String line, int start) {
        ////System.out.println(line);
        StringBuilder builder = new StringBuilder();
        int i = start;
        for (; i < line.length(); ) {
            boolean hasNext = line.substring(i, i + 1).equalsIgnoreCase("1");
            ////System.out.println("HAS NEXT = " + hasNext);
            builder.append(line.substring(i + 1, i + 5));
            i = i + 5;
            if (!hasNext) {
                break;
            }
        }
        ////System.out.println("->" + builder.toString());

        val = Day16.stringBinToNum(builder.toString());
        System.out.println("VAL = " + val);

        int resto = (i - start + 6) % 4;
        ////System.out.printf("i=%d , start=%d, num=%d, resto=%d",i,start,(i-start+6), resto);

        if (toBePadded) {
            return i + (resto == 0 ? 0 : 4 - resto);
        } else {
            return i;
        }
    }

    @Override
    public int sumVersion() {
        return version;
    }

    @Override
    public long calculate() {
        return val;
    }

    public String encode(){
        String num = super.encode();

        String vst = Day16.stringNumToBin(val);

       // System.out.println(vst);

        String valNum = "";
        int cont = 0;
        for (int i = vst.length(); i >=0; ) {
            if (i - 4 >0) {
                valNum = ""+cont+vst.substring(i-4, i)+valNum;
                cont = 1;
                i -= 4;
            } else {
                String substring = vst.substring(0, i);
                if(substring.length()==1){
                    substring = "000"+substring;
                }else if(substring.length()==2){
                    substring = "00"+substring;
                }else if(substring.length()==3){
                    substring = "0"+substring;
                }
                valNum = ""+cont+ substring +valNum;
                //num += vst.substring(i);
                break;
            }
        }

        num += valNum;

        return num;
    }


}
