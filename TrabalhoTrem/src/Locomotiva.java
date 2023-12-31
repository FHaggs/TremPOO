public class Locomotiva {
    private int id;
    private int capacidadeToneladas;
    private int maxVagoes;
    private Trem trem;

    public Locomotiva(int id, int capacidadeToneladas, int maxVagoes) {
        this.id = id;
        this.capacidadeToneladas = capacidadeToneladas;
        this.maxVagoes = maxVagoes;
    }

    public int getId() {
        return id;
    }

    public int getCapacidadeToneladas() {
        return capacidadeToneladas;
    }

    public int getMaxVagoes() {
        return maxVagoes;
    }

    public Trem getTrem() {
        return trem;
    }
    public void setTrem(Trem t){
        this.trem = t;
    }
    public void sairTrem(){
        this.trem = null;
    }

    @Override
    public String toString(){
        return "Locomotiva: " + id + ", Capacidade: " + capacidadeToneladas;
    }
    
}
