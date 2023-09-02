import java.util.ArrayList;

public class GaragemLocomotivas {
    
    private ArrayList<Locomotiva> locomotivas = new ArrayList<Locomotiva>();

    public boolean cheio(){
        if(locomotivas.isEmpty()){
            return false;
        }
        return true;
    }

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
        for(int i = 0; i < locomotivas.size(); i++){
            Locomotiva locomotiva = locomotivas.get(i);
            s.append(locomotiva.getId());
            if(i == locomotivas.size() - 1){
                s.append(".");
            } else {
                s.append(", ");
            }
        }
        return s.toString();
    }
}
