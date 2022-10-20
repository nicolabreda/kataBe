package kata;

class FixedSubPacket extends SubPacket {

    public FixedSubPacket(int version, int type) {
        super(version, type);
        //System.out.println("FIXED PACKET");
    }


    @Override
    public int decode(String line, int start) {
        int number = (int) Day16.stringBinToNum(line.substring(start, start + 11));
        int i = start + 11;

        for (int j = 0; j < number; j++) {
            int version = (int) Day16.stringBinToNum(line.substring(i, i + 3));
            int type = (int) Day16.stringBinToNum(line.substring(i + 3, i + 6));
            System.out.println("FIXED " + j + " version  " + version + " type " + type);
            i = i + 6;
            Packet packet;
            if (type == 4) {
                packet = new NumberPacket(version, type, false);
                i = packet.decode(line, i);
            } else {
                int index = (int) Day16.stringBinToNum(line.substring(i, i + 1));
                i = i + 1;
                if (index == 0) {
                    packet = new VariableSubPacket(version, type);
                } else {
                    packet = new FixedSubPacket(version, type);
                }
                i = packet.decode(line, i);
            }
            packets.add(packet);
        }

        return i;
    }


    @Override
    public String encode() {
        String num = super.encode()+"1";

        String numpak = Day16.stringNumToBin(packets.size());
        System.out.println("numpak " +numpak);
        while(numpak.length()!=11){
            numpak = "0"+numpak;
        }

        num += numpak;

        for(Packet p : packets) {
            num += p.encode();
        }

        return num;
    }
}
