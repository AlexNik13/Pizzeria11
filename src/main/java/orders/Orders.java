package orders;

import java.util.ArrayList;

public class Orders {
    private ArrayList<Check> checks = new ArrayList<>();

    public Orders() {
    }

    public void addNewCheckFromClient(){
        checks.add(new Check());
    }
}
