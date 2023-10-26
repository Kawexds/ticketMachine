package core;


import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TicketMachine {

    private TicketMachine ticketMachine;

    @Before
    public void setUp() {
        ticketMachine = new TicketMachine(10);  
    }

    @Test
    public void testInserirValidQuantia() {
        ticketMachine.inserir(20);  
        assertEquals(20, ticketMachine.getSaldo());
    }
  
    @Test
    public void testImprimirTicketWithSufficientBalance() {
        ticketMachine.inserir(20);  
        String ticket = ticketMachine.imprimir();
        String resposta = "*****************\n";
        resposta += "*** R$ 20,00 ****\n";
        resposta += "*****************\n";
        assertEquals(resposta, ticket);
        assertEquals(0, ticketMachine.getSaldo());
    }
}
