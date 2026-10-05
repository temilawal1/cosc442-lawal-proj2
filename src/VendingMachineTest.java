import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    // checks all valid codes!
    @ParameterizedTest
    @ValueSource(strings = { "A", "B", "C", "D" })
    public void testAddItem_ValidCode(String code) throws VendingMachineException {
        machine.addItem(item1, code);
        assertEquals(item1, machine.getItem(code));
    }

    @Test
    public void testAddItem_InvalidCode() {

        assertThrows(VendingMachineException.class, () -> {
            machine.addItem(item1, "E");
        });
    }

    @Test
    public void testAddItem_OccupiedSlot() {

        machine.addItem(item1, "A"); // partial arrange

        assertThrows(VendingMachineException.class, () -> {
            machine.addItem(item2, "A");
        });

    }

    
    @ParameterizedTest 
    @ValueSource(strings = { "A", "B", "C", "D" })
    public void testGetItem_ValidCode(String code) throws VendingMachineException {

        machine.addItem(item1, code);

        assertEquals(item1, machine.getItem(code), "test getItem");
    }

    @Test
    public void testGetItem_EmptySlot() throws VendingMachineException {

        assertEquals(null, machine.getItem("A"));
    }

    @ParameterizedTest 
    @ValueSource(strings = { "A", "B", "C", "D" })
    public void testRemoveItem_ValidCode(String code) throws VendingMachineException {
        machine.addItem(item1, code);
        assertEquals(item1, machine.removeItem(code), "returns removed item");
        assertEquals(null, machine.getItem(code), "returns null: slot empty");
    }

    @Test
    public void testRemoveItem_EmptySlot() {
        assertThrows(VendingMachineException.class, () -> {
            machine.removeItem("A");
        });
    }

}
