import java.util.ArrayList;

public class Patio {
    private ArrayList<Trem> trems = new ArrayList<Trem>();

    public void add(Trem t){
        trems.add(t);
    }
    
    @Override
    public String toString(){

        StringBuilder s = new StringBuilder();
        s.append("\nPatio: \n\n");

        for(int i = 0; i < trems.size(); i++){
            s.append(trems.get(i)).append("\n");
        }
        
        return s.toString();
    }
}