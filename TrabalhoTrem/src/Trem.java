import java.util.ArrayList;

public class Trem {
    private int id;

    private int maxVagoes;
    private int maxCapacidade;
    private int pesoAtual;

    private ArrayList<Locomotiva> locomotivas = new ArrayList<Locomotiva>();
    private ArrayList<Vagao> vagoes = new ArrayList<Vagao>();

    public Trem(int id){
        this.id = id;
        maxVagoes = 0;
        maxCapacidade = 0;
        pesoAtual = 0;
    }

    public boolean addLocomotiva(Locomotiva locomotiva){
        if(!vagoes.isEmpty()){
            return false;
        }
        locomotivas.add(locomotiva);
        locomotiva.setTrem(this);

        maxVagoes += locomotiva.getMaxVagoes();
        maxCapacidade += locomotiva.getCapacidadeToneladas();

        if(locomotivas.size() > 2){
            maxVagoes = maxVagoes - (int)(maxVagoes * 0.1);
        }


        return true;
    }
    public boolean addVagao(Vagao vagao){
        if(locomotivas.isEmpty() || vagoes.size() >= maxVagoes || pesoAtual + vagao.getCapacidadeCarga() > maxCapacidade){
            return false;
        }
        
        vagoes.add(vagao);
        vagao.setTrem(this);
        pesoAtual += vagao.getCapacidadeCarga();
        return true;
    }
    public Vagao retiraVagao(){
        if(vagoes.isEmpty()){
            return null;
        }
        Vagao aux = vagoes.get(vagoes.size() - 1);

        pesoAtual -= aux.getCapacidadeCarga();

        vagoes.remove(vagoes.size() - 1);
        return aux;
    }
    public Locomotiva retiraLocomotiva(){
        if(!vagoes.isEmpty() || locomotivas.isEmpty()){
            return null;
        }

        Locomotiva aux = locomotivas.get(locomotivas.size() - 1);

        if(locomotivas.size() > 1){
            maxVagoes = maxVagoes + (int)(maxVagoes * 0.1);
        }
        locomotivas.remove(vagoes.size() - 1);
        maxCapacidade -= aux.getCapacidadeToneladas();
        maxVagoes -= aux.getMaxVagoes();

        return aux;
    }

    public String toString(){

        StringBuilder s = new StringBuilder();

        s.append("Locomotivas: \n");

        for(int i = 0; i < locomotivas.size(); i++){
            s.append(locomotivas.get(i).getId()).append(", ");
        }
        s.append("\nVagões: \n");

        for(int i = 0; i < vagoes.size(); i++){
            s.append(vagoes.get(i).getId()).append(", ");
        }
        s.append("\n");
        return s.toString();
    }
}

