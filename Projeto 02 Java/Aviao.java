public class Aviao {

    private double combustivel;
    private double distancia;
    private boolean voando = false;

    Aviao(double combustivel, double distancia) {
        setCombustivel(combustivel);
        setDistancia(distancia);
    }

    public double getDistancia() {
        return this.distancia;
    }

    public double getCombustivel() {
        return this.combustivel;
    }

    public boolean isVoando() {
        return this.voando;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public void setCombustivel(double combustivel) {
        this.combustivel = combustivel;
    }


    public String toString() {
        return "Combustível: " + getCombustivel() + "\tDistância: " + getDistancia();
    }

    public void voar() {
        this.voando = true;
    }

    public void pousar() {
        this.voando = false;
    }
}
