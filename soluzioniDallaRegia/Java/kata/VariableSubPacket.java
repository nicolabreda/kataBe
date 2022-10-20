package kata;

class VariableSubPacket extends SubPacket {

    public VariableSubPacket(int version, int type) {
        super(version, type);
        ////System.out.println("VARIABLE PACKET");
    }


    @Override
    public int decode(String line, int start) {
        //System.out.println(line);
        int lenth = (int) Day16.stringBinToNum(line.substring(start, start + 15));
        ////System.out.printf("Length %d%n",lenth);
        String sub = line.substring(start + 15, start + 15 + lenth);
        int i = start + 15 + lenth;


        for (int j = 0; j < sub.length(); ) {
            int version = (int) Day16.stringBinToNum(sub.substring(j, j + 3));
            int type = (int) Day16.stringBinToNum(sub.substring(j + 3, j + 6));
            System.out.println("VARIABLE " + j + " version  " + version + " type " + type);
            //System.out.println("\t"+version);
            //System.out.println("\t"+type);
            j = j + 6;
            Packet packet;
            if (type == 4) {
                packet = new NumberPacket(version, type, false);
                j = packet.decode(sub, j);
            } else {
                int index = (int) Day16.stringBinToNum(sub.substring(j, j + 1));
                j = j + 1;
                if (index == 0) {
                    packet = new VariableSubPacket(version, type);
                } else {
                    packet = new FixedSubPacket(version, type);
                }
                j = packet.decode(sub, j);
            }
            packets.add(packet);
        }

        return i;
    }

    @Override
    public String encode() {
        String num = super.encode() + "0";

        String subpak = "";
        for (Packet p : packets) {
            subpak += p.encode();
        }

        String numpak = Day16.stringNumToBin(subpak.length());
        System.out.println("numpak " + numpak);
        while (numpak.length() != 15) {
            numpak = "0" + numpak;
        }

        num += numpak;
        num += subpak;


        return num;
    }

}
