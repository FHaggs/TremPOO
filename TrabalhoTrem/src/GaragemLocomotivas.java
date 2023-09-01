import java.util.ArrayList;

public class GaragemLocomotivas {
    
    private ArrayList<Locomotiva> locomotivas = new ArrayList<Locomotiva>();

    public void add(Locomotiva l){
        locomotivas.add(l);
    }
    public Locomotiva retiraPorId(int id){
        for(Locomotiva locomotiva: locomotivas){
            if(locomotiva.getId() == id){
                return locomotiva;
            }
        }
        return null;
    }
}
