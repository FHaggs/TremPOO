import java.util.ArrayList;

public class Trem {
    private int id;

    private ArrayList<Locomotiva> locomotivas = new ArrayList<Locomotiva>();
    private ArrayList<Vagao> vagoes = new ArrayList<Vagao>();

    public Trem(int id){
        this.id = id;
    }

    public boolean addLocomotiva(Locomotiva locomotiva){
        if(!vagoes.isEmpty()){
            return false;
        }
        locomotivas.add(locomotiva);
        locomotiva.setTrem(this);
        return true;
    }
    public boolean addVagao(Vagao vagao){
        if(locomotivas.isEmpty()){
            return false;
        }
        
        vagoes.add(vagao);
        vagao.setTrem(this);
        return true;
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

