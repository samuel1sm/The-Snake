
import java.util.Random;

public class TerminalCobra {
    public static void main(String[] args) {
        boolean fim = false;


        Teclas direcoes = new Teclas();
        Random aleatorizador = new Random();
        Posicionamento movimento = new Posicionamento();
        Comida comida[] = new Comida[17];
        Obstaculo obstaculo[] = new Obstaculo[12];
        Tempo tempo = new Tempo();

        movimento.getAbrirterminal();
        movimento.getLigarDesligarCursor(false);

        for (int o = 0; o < 16; o++) {
            comida[o] = new Comida();
            for (int y = 0; y < o; y++) {
                do {
                    comida[o].setY(aleatorizador.nextInt(78) + 1);
                    comida[o].setX(aleatorizador.nextInt(27) + 1);
                } while ((comida[o].getX() == comida[y].getX()) && (comida[o].getY() == comida[y].getY()));
            }
            movimento.setPosicaoComida(comida[o].getX(), comida[o].getY());
            if(0==15)
                o++;
        }


        for (int o = 0; o < 11; o++) {
            obstaculo[o] = new Obstaculo();
            for (int y = 0; y < o; y++) {
                do {
                    obstaculo[o].setY(aleatorizador.nextInt(78) + 1);
                    obstaculo[o].setX(aleatorizador.nextInt(27) + 1);
                } while ((obstaculo[o].getX() == comida[y].getX()) && (obstaculo[o].getY() == comida[y].getY()));
            }
            movimento.setPosicaoObstaculo(obstaculo[o].getX(), obstaculo[o].getY());
            if(0==10)
                o++;
        }

        direcoes.setDirecao(aleatorizador.nextInt(4));
        movimento.setLinha(aleatorizador.nextInt(28) + 1);
        movimento.setColuna(aleatorizador.nextInt(78) + 1);

        movimento.getAumentoBarravida(5);
        movimento.getVidaPalavra();
        movimento.getAlocamento();
        movimento.getParede();
        movimento.getTempoPalavra();
        do {
            direcoes.tecla = movimento.terminal.readInput();

            for (int p = 0; p < 16; p++) {
                if ((comida[p].getY() == movimento.getColuna()) && (comida[p].getX() == movimento.getLinha())) {
                    comida[p].setY(100);
                    comida[p].setX(30);
                    movimento.setTamanho();
                    tempo.setTempo(3000);

                    comida[0].setContadorvida(1);
                    if (comida[0].getContadorvida() % 3 == 0) {
                        comida[0].setVida(1);
                        movimento.getAumentoBarravida(comida[0].getVida());
                    }}}

            for (int p = 0; p < 11; p++) {
                if ((obstaculo[p].getY() == movimento.getColuna()) && (obstaculo[p].getX() == movimento.getLinha())) {
                    obstaculo[p].setY(100);
                    obstaculo[p].setX(30);
                    obstaculo[0].setVida(1);
                    movimento.getDimuicaoBarravida(comida[0].getVida());
                }}

            movimento.getAlocamento();


            if (direcoes.getDirecao() == 3) {
                movimento.getBaixo();
            }
            if (direcoes.getDirecao() == 1) {
                movimento.getCima();
            }


            if (direcoes.getDirecao() == 2) {
                movimento.getDireita();
            }
            if (direcoes.getDirecao() == 0) {
                movimento.getEsquerda();
            }

            movimento.getMovimento();
            movimento.getTeleporteP(direcoes.getDirecao());
            movimento.getTeleporteN(direcoes.getDirecao());
            movimento.getParedeBaixa();
            tempo.setTempo(-100);
            tempo.setContadorparaotempo(100);
            if (tempo.getContadorparaotempo() / 1000 != 0) {
                    for (int i = 0; i < 2; i++) {
                        if(tempo.getTamanhovetor()!=1)
                        movimento.getTempoContadorPosicao(tempo.getContadortempo(i), i);
                        else {
                            movimento.getTempoContadorPosicao(tempo.getContadortempo(i), 1);
                            movimento.getTempoContadorPosicao('0', 0);
                        }
                    }
            }
            if(comida[0].getContadorvida()==15)
                comida[0].setKeyboa(true);
        if (direcoes.tecla != null) {
            direcoes.direcao();
            fim=direcoes.fim();
            }}while((!fim)&&(comida[0].getVida() !=0)&&(tempo.getTempo()!=0)&&(comida[0].getContadorvida()!=15));

            movimento.getLimparTerminal();
            fim=false;

            while (!fim){
                direcoes.tecla = movimento.terminal.readInput();
                if (comida[0].getKeyboa()==true)
                movimento.getFimBom();
                else
                movimento.getFimRuim();
                if (direcoes.tecla != null) {
                    direcoes.direcao();
                    fim=direcoes.fim();}
            }
        System.exit(0);}}


