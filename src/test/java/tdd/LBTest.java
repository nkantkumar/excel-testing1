package tdd;

import com.puretech.payment.LB;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LoadBalancerTest {

    private LB loadBalancer;

    @BeforeEach
    void setUp() {
        loadBalancer = new LB();
        loadBalancer.addServer("server1");
        loadBalancer.addServer("server2");
        loadBalancer.addServer("server3");
    }

    @Test
    void testLoadBalancerReturnsServersInRoundRobinOrder() {
        assertEquals("server1", loadBalancer.getNextServer());
        assertEquals("server2", loadBalancer.getNextServer());
        assertEquals("server3", loadBalancer.getNextServer());
        assertEquals("server1", loadBalancer.getNextServer()); // should cycle back
        assertEquals("server2", loadBalancer.getNextServer());
    }

    @Test
    void testLoadBalancerThrowsExceptionWhenNoServersAvailable() {
        LB emptyBalancer = new LB();
        RuntimeException thrown = assertThrows(
                RuntimeException.class,
                () -> emptyBalancer.getNextServer()
        );
        assertTrue(thrown.getMessage().contains("No servers available"));
    }
}
