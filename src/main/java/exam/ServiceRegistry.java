package exam;

import java.util.HashSet;
import java.util.Set;

public class ServiceRegistry {
    Set<String> addressSet = new HashSet();

    public static void main(String[] args) {
        ServiceRegistry sr= new ServiceRegistry();
        String address= "http://xyz.com";
        sr.register(address);
    }


    public void register(String address) {
        if(addressSet.size() >= 10){
            throw new IllegalArgumentException("We can not add more than 10 address");
        }
       addressSet.add(address);

    }

}
