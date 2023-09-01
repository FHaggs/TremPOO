import java.util.ArrayList;

public class GaragemLocomotivas {
    
    private ArrayList<Locomotiva> locomotivas = new ArrayList<Locomotiva>();

    public void add(Locomotiva l){
        locomotivas.add(l);
    }
    public Locomotiva retiraPorId(int id){
        for(Locomotiva locomotiva: locomotivas){
            if(locomotiva.getId() == id){
                Locomotiva aux = locomotiva;
                locomotivas.remove(locomotiva);
                return aux;
            }
        }
        return null;
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("Garagem: \n");
        for(Locomotiva locomotiva: locomotivas){
            s.append(locomotiva.getId()).append(", ");
        }
        return s.toString();
    }
}
