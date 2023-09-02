import java.util.ArrayList;

public class GaragemVagao {
    
    private ArrayList<Vagao> vagoes = new ArrayList<Vagao>();

    public boolean cheio(){
        if(vagoes.isEmpty()){
            return false;
        }
        return true;
    }

    public void add(Vagao v){
        vagoes.add(v);
    }
    public Vagao retiraPorId(int id){
        for(Vagao v: vagoes){
            if(v.getId() == id){
                Vagao aux = v;
                vagoes.remove(v);
                return aux;
            }
        }
        return null;
    }
    @Override
    public String toString(){

        StringBuilder s = new StringBuilder();
        s.append("\n Garagem: \n");

        for(int i = 0; i < vagoes.size(); i++){
            s.append(vagoes.get(i)).append("\n");
        }
        
        return s.toString();
    }
}
