package exam;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ServiceRegistryTest {
    @Test
    void SucesfullRegisterTest(){
        ServiceRegistry sr= new ServiceRegistry();
        String address= "http//google.com";



        sr.register(address);


    }
    @Test
    void ExceptionDuringRegisterTest(){
        ServiceRegistry sr= new ServiceRegistry();
        String address= "http//google.com";
        for (int i = 0; i < 10 ; i++) {
            sr.register(address+"/page/"+i);
        }
        assertThrows(IllegalArgumentException.class, () -> sr.register(address));


    }
}
