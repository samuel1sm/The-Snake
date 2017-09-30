public class Comida extends ComidaObstacaluloXYVida {
    private static int contadorvida=0;
    public static int getContadorvida() {
        return contadorvida;
    }

    public static void setContadorvida(int contadorvida) {
        Comida.contadorvida += contadorvida;
    }
    @Override
    public int getVida() {
        return super.getVida();
    }

    @Override
    public void setVida(int vida) {
        super.vida+=vida;
    }
}
