import java.util.ArrayList;

public class GaragemVagao {
    
    private ArrayList<Vagao> vagoes = new ArrayList<Vagao>();

    public void add(Vagao v){
        vagoes.add(v);
    }
    public Vagao retiraPorId(int id){
        for(Vagao vagao: vagoes){
            if(vagao.getId() == id){
                return vagao;
            }
        }
        return null;
    }
}
