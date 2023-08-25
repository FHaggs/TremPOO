public class Vagao {
    private int id;
    private double capacidadeCarga;
    private Trem trem;

    public Vagao(int id, double capacidadeCarga) {
        this.id = id;
        this.capacidadeCarga = capacidadeCarga;
    }

    public int getId() {
        return id;
    }

    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public Trem getTrem() {
        return trem;
    }

    public void setTrem(Trem trem) {
        this.trem = trem;
    }

    @Override
    public String toString(){
        return "Vagão: " + id + "," + capacidadeCarga;
    }

    
}
