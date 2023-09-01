public class Vagao {
    private int id;

    private int capacidadeCarga;

    private Trem trem;

    public Vagao(int id, int capacidadeCarga) {
        this.id = id;
        this.capacidadeCarga = capacidadeCarga;
    }

    public int getId() {
        return id;
    }

    public int getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public Trem getTrem() {
        return trem;
    }

    public void setTrem(Trem trem) {
        this.trem = trem;
    }
    public void sairTrem(){
        this.trem = null;
    }



    @Override
    public String toString(){
        return "Vagão: " + id + "," + capacidadeCarga;
    }

    
}
