abstract class ComidaObstacaluloXYVida {
    protected int x[]=new int[300],y[]=new int[300];
    protected boolean keyboa=false;
    protected static int vida=5;

    public int getX() {
        return x[0];
    }

    public void setX(int x) {
        this.x[0] = x;
    }

    public int getY() {
        return y[0];
    }

    public void setY(int y) {
        this.y[0] = y;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        ComidaObstacaluloXYVida.vida = vida;
    }

    public boolean getKeyboa() {
        return keyboa;
    }

    public void setKeyboa(boolean keyboa) {
        this.keyboa = keyboa;
    }
}
