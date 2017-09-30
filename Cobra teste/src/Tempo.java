public class Tempo {
    static private int tempo=15000,auxconttemp,contadorparaotempo=0;
   private char numerodocontador[]=new char[2];

    public static int getContadorparaotempo() {
        return contadorparaotempo;
    }

    public static void setContadorparaotempo(int contadorparaotempo) {
        Tempo.contadorparaotempo += contadorparaotempo;
    }

    public char getContadortempo(int i){
        auxconttemp=tempo/1000;
            String aux=String.valueOf(auxconttemp);
            numerodocontador=aux.toCharArray();
            int tamanho = aux.length();
            if (tamanho != 1)
                return numerodocontador[i];
            else
                return numerodocontador[0];

        }

    public int getTamanhovetor(){
        return numerodocontador.length;
    }

    public static int getTempo() {
        return tempo;
    }

    public static void setTempo(int tempo) {
        Tempo.tempo += tempo;
    }
}
