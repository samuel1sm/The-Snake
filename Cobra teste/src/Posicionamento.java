import java.nio.charset.Charset;
import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.Terminal;
public class Posicionamento {
    static private int cobrax[]=new int[300], cobray[]=new int[300],tamanho=5,x;
    Terminal terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF8"));

    public void getAbrirterminal(){terminal.enterPrivateMode();}
    public void getLigarDesligarCursor(boolean talvez){terminal.setCursorVisible(talvez);}
    public void getParedeBaixa(){
        for (int c=0;c<100;c++){
        terminal.moveCursor(c,30);
        terminal.putCharacter('═');terminal.moveCursor(0,0);
        terminal.putCharacter('╔');
            terminal.moveCursor(80,30);
            terminal.putCharacter('╩');
            terminal.moveCursor(0,80);
            terminal.putCharacter('╚');
            terminal.moveCursor(100,30);
            terminal.putCharacter('╝');
    }}
    public void getParede() {

        for (int c=0;c<100;c++){
            terminal.moveCursor(c,0);
            terminal.putCharacter('═');
        }
        for (int c=0;c<100;c++){
            terminal.moveCursor(c,30);
            terminal.putCharacter('═');
        }
        for (int c=0;c<30;c++){
            terminal.moveCursor(0,c);
            terminal.putCharacter('║');
        }
        for (int c=0;c<30;c++){
            terminal.moveCursor(80,c);
            terminal.putCharacter('║');
        }
        for (int c=0;c<30;c++){
            terminal.moveCursor(100,c);
            terminal.putCharacter('║');
        }
        terminal.moveCursor(0,0);
        terminal.putCharacter('╔');
        terminal.moveCursor(0,80);
        terminal.putCharacter('╚');
        terminal.moveCursor(80,0);
        terminal.putCharacter('╦');
        terminal.moveCursor(80,30);
        terminal.putCharacter('╩');
        terminal.moveCursor(100,0);
        terminal.putCharacter('╗');
        terminal.moveCursor(100,30);
        terminal.putCharacter('╝');
    }

    public void getTempoPalavra(){
        terminal.moveCursor(88,11);
        terminal.putCharacter('T');
        terminal.moveCursor(89,11);
        terminal.putCharacter('E');
        terminal.moveCursor(90,11);
        terminal.putCharacter('M');
        terminal.moveCursor(91,11);
        terminal.putCharacter('P');
        terminal.moveCursor(92,11);
        terminal.putCharacter('O');
        terminal.moveCursor(93,11);
        terminal.putCharacter(':');
        terminal.moveCursor(88,12);
        terminal.putCharacter('0');
        terminal.moveCursor(89,12);
        terminal.putCharacter('0');
        terminal.moveCursor(90,12);
        terminal.putCharacter(':');
        terminal.moveCursor(91,12);
        terminal.putCharacter('1');
        terminal.moveCursor(92,12);
        terminal.putCharacter('5');
    }
    public void getTempoContadorPosicao(char t,int i){
       terminal.moveCursor(91+i,12);
       terminal.putCharacter(t);
   }
    public void getVidaPalavra(){
       terminal.moveCursor(88,16);
       terminal.putCharacter('V');
       terminal.moveCursor(89,16);
       terminal.putCharacter('I');
       terminal.moveCursor(90,16);
       terminal.putCharacter('D');
       terminal.moveCursor(91,16);
       terminal.putCharacter('A');
       terminal.moveCursor(92,16);
       terminal.putCharacter(':');
   }
    public void getAumentoBarravida(int vida){
       for (int i=0;i<vida;i++){
           terminal.moveCursor(87+i,17);
           terminal.putCharacter('♥');
       }
   }
    public void getDimuicaoBarravida(int vida){
            terminal.moveCursor(87+vida,17);
            terminal.putCharacter(' ');
    }

    public static void setTamanho() {
        Posicionamento.tamanho ++;
    }
    public static int getLinha() {
        return cobrax[0];
    }
    public static void setLinha(int coluna) {
        Posicionamento.cobrax[0]= coluna;
    }

    public static int getColuna() { return cobray[0]; }
    public static void setColuna(int linha) {
        Posicionamento.cobray[0] = linha;
    }

    public void setPosicaoComida(int x,int y) {
        terminal.moveCursor(y,x);
        terminal.putCharacter('0');
    }
    public void setPosicaoObstaculo(int x,int y) {
        terminal.moveCursor(y,x);
        terminal.putCharacter('X');
    }

    public void getAlocamento() {
        for (x = tamanho; x > 0; x--) {
            cobray[x] = cobray[x - 1];
            cobrax[x] = cobrax[x - 1];

        }
    }
    public void getMovimento(){
        terminal.moveCursor(cobray[tamanho], cobrax[tamanho]);
        terminal.putCharacter(' ');

        terminal.moveCursor(cobray[0], cobrax[0]);
        terminal.putCharacter('§');

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }}

    public void getTeleporteP(int d) {
        if ((d==2)||(d==3)){
        if (cobray[0] == 80) {
            cobray[0] = 1;
            terminal.moveCursor(cobray[0], cobrax[0]);
            terminal.moveCursor(80, cobrax[0]);
            terminal.putCharacter('║');
        }

        if (cobrax[0] == 29) {
            cobrax[0] = 1;
            terminal.moveCursor(cobray[0], cobrax[0]);
            terminal.moveCursor(cobray[0], 30);
            terminal.putCharacter('═');
        }}
    }
    public void getTeleporteN(int d){
        if((d==0)||(d==1)){
        if(cobray[0] == 0){
            cobray[0]=79;
            terminal.moveCursor(cobray[0], cobrax[0]);
        terminal.moveCursor(0, cobrax[0]);
        terminal.putCharacter('║');}

        if(cobrax[0] == 0){
            cobrax[0]=29;
            terminal.moveCursor(cobray[0], cobrax[0]);
            terminal.moveCursor(cobray[0], 0);
            terminal.putCharacter('═');}
    }}
    public void getLimparTerminal(){
    for (int i=0;i<30;i++)
        for (int b=0;b<100;b++) {
            terminal.moveCursor(b, i);
            terminal.putCharacter(' ');
        }
}
    public void getFimBom(){
        terminal.moveCursor(46,10);
        terminal.putCharacter('P');
        terminal.moveCursor(47,10);
        terminal.putCharacter('A');
        terminal.moveCursor(48,10);
        terminal.putCharacter('R');
        terminal.moveCursor(49,10);
        terminal.putCharacter('A');
        terminal.moveCursor(50,10);
        terminal.putCharacter('B');
        terminal.moveCursor(51,10);
        terminal.putCharacter('É');
        terminal.moveCursor(52,10);
        terminal.putCharacter('N');
        terminal.moveCursor(53,10);
        terminal.putCharacter('S');
    }
    public void getFimRuim(){
        terminal.moveCursor(46,10);
        terminal.putCharacter('Y');
        terminal.moveCursor(47,10);
        terminal.putCharacter('O');
        terminal.moveCursor(48,10);
        terminal.putCharacter('U');
        terminal.moveCursor(49,10);
        terminal.putCharacter(' ');
        terminal.moveCursor(50,10);
        terminal.putCharacter('L');
        terminal.moveCursor(51,10);
        terminal.putCharacter('O');
        terminal.moveCursor(52,10);
        terminal.putCharacter('S');
        terminal.moveCursor(53,10);
        terminal.putCharacter('E');
    }
    public void getDireita(){ cobray[0]++; }
    public void getCima(){
        cobrax[0]--;
    }
    public void getEsquerda(){
        cobray[0]--;
    }
    public void getBaixo(){
        cobrax[0]++;
}}
