import java.util.ArrayList;

public class Patio {
    private ArrayList<Trem> trems = new ArrayList<Trem>();

    public void add(Trem t){
        trems.add(t);
    }
    
    public boolean cheio(){
        if(trems.isEmpty()){
            return false;
        }
        return true;
    }

    public Trem getTrem(int id){
        for(Trem trem: trems){
            if(trem.getId() == id){
                return trem;
            }
        }
        return null;
    }

    public boolean verificarId(int nova_id){
        for(Trem trem: trems){
            if(trem.getId() == nova_id){
                return false;
            }
        }
        return true;
    }

    public Trem removePorId(int id){
        for(Trem t: trems){
            if(t.getId() == id){
                Trem aux = t;
                trems.remove(t);
                return aux;
            }
        }
        return null;
    }

    @Override
    public String toString(){

        StringBuilder s = new StringBuilder();
        s.append("\nPatio: \n\n");

        if(trems.isEmpty()){
            s.append("O pátio se encontra vazio no momento");
            return s.toString();
        }
        for(int i = 0; i < trems.size(); i++){
            s.append(trems.get(i)).append("\n");
        }
        
        return s.toString();
    }
}