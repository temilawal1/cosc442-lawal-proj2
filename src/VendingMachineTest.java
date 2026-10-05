import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VendingMachineTest {

    VendingMachine machine;
    VendingMachineItem item1;
    VendingMachineItem item2;

    @BeforeEach
    public void setUp() throws Exception {

        machine = new VendingMachine();

        item1 = new VendingMachineItem("oreos", 1.50);
        item2 = new VendingMachineItem("doritos", 2.50);
    }

    @AfterEach
    public void tearDown() {
        item1 = null;
        item2 = null;
    }

    @Test
    public void testAddItem() throws VendingMachineException {

        machine.addItem(item1, "A");
        assertEquals(item1, machine.getItem("A"), "test addItem");

        machine.addItem(item2, "B");
        assertEquals(item2, machine.getItem("B"), "test addItem");

    }

    @Test
    public void testAddItem_OccupiedSlot() {

        machine.addItem(item1, "A"); // partial arrange

        assertThrows(VendingMachineException.class, () -> {
            machine.addItem(item2, "A");
        });

    }

    @Test
    public void testAddItem_InvalidCode() {

        assertThrows(VendingMachineException.class, () -> {
            machine.addItem(item1, "E");
        });
    }

    @Test
    public void testGetItem() throws VendingMachineException {

        machine.addItem(item1, "A");

        assertEquals(item1, machine.getItem("A"), "test getItem");
    }

    @Test
    public void testGetItem_EmptySlot() throws VendingMachineException {

        assertEquals(null, machine.getItem("A"));
    }

    @Test
    public void testRemoveItem() {
        machine.addItem(item1, "A");
        assertEquals(null, machine.removeItem("A"), "test removeItem");
    }

    @Test 
    public void testRemoveItem_EmptySlot() {
        assertThrows(VendingMachineException.class, () -> {
            machine.removeItem("A");
        });
    }

}
