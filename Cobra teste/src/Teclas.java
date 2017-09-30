import com.googlecode.lanterna.input.Key;
public class Teclas {
    private static int direcao;
    Key tecla;

    public static int getDirecao() {
        return direcao;
    }

    public static void setDirecao(int direcao) {
        Teclas.direcao = direcao;
    }

    public void direcao(){
        if ((tecla.getKind() == Key.Kind.ArrowLeft)&&(direcao!=2))
            direcao = 0;
        if ((tecla.getKind() == Key.Kind.ArrowUp)&&(direcao!=3))
            direcao = 1;
        if ((tecla.getKind() == Key.Kind.ArrowRight)&&(direcao!=0))
            direcao =2;
        if ((tecla.getKind() == Key.Kind.ArrowDown)&&(direcao!=1))
            direcao = 3;

    }
    public boolean fim(){
        if (tecla.getKind() == Key.Kind.Escape)
            return true;
        return false;
    }
    }


