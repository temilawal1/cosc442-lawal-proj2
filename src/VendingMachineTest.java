import static org.junit.jupiter.api.Assertions.assertEquals;
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


    @Test
    public void testAddItem() {

        machine.addItem(item1, "A");
        assertEquals(item1, machine.getItem("A"), "test");

    }

}

/*
 * 
 * import org.junit.jupiter.api.BeforeEach;
 * import org.junit.jupiter.api.Test;
 * import static org.junit.jupiter.api.Assertions.*;
 * 
 * class VendingMachineTest {
 * 
 * private VendingMachine machine;
 * private VendingMachineItem testItem1;
 * private VendingMachineItem testItem2;
 * 
 * @beforeEach
 * void setUp() {
 * // Initialize a clean vending machine before each test
 * machine = new VendingMachine();
 * 
 * // Mocking VendingMachineItem. Adjust the constructor to match your actual
 * class.
 * // Assuming VendingMachineItem constructor looks like: (String name, double
 * price)
 * testItem1 = new VendingMachineItem("Chips", 1.50);
 * testItem2 = new VendingMachineItem("Soda", 2.00);
 * }
 * 
 * /**
 * Test case: Successfully adding an item to an empty slot.
 * 
 * @Test
 * void testAddItemSuccess() throws VendingMachineException {
 * // Act: Add an item to slot A
 * machine.addItem(testItem1, "A");
 * 
 * // Assert: The item should now be in slot A
 * assertEquals(testItem1, machine.getItem("A"),
 * "The item in slot A should match the added item.");
 * }
 * 
 * /**
 * Test case: Successfully adding items to all valid slots (A, B, C, D).
 * 
 * @Test
 * void testAddItemAllValidSlots() throws VendingMachineException {
 * // Act: Add items across all valid codes
 * machine.addItem(testItem1, "A");
 * machine.addItem(testItem2, "B");
 * machine.addItem(testItem1, "C");
 * machine.addItem(testItem2, "D");
 * 
 * // Assert: Verify all slots contain the correct items
 * assertEquals(testItem1, machine.getItem("A"));
 * assertEquals(testItem2, machine.getItem("B"));
 * assertEquals(testItem1, machine.getItem("C"));
 * assertEquals(testItem2, machine.getItem("D"));
 * }
 * /**
 * Test case: Exception thrown when adding an item to a slot that is already
 * occupied.
 * 
 * @Test
 * void testAddItemToAlreadyOccupiedSlotThrowsException() throws
 * VendingMachineException {
 * // Arrange: Place an item into slot B
 * machine.addItem(testItem1, "B");
 * 
 * // Act & Assert: Attempting to put another item in B should throw a
 * VendingMachineException
 * VendingMachineException exception =
 * assertThrows(VendingMachineException.class, () -> {
 * machine.addItem(testItem2, "B");
 * });
 * 
 * // Optional Assert: Verify the expected error message contents
 * assertTrue(exception.getMessage().contains("already occupied"));
 * }
 * 
 * /**
 * Test case: Exception thrown when trying to use an invalid slot code.
 * 
 * @Test
 * void testAddItemInvalidCodeThrowsException() {
 * // Act & Assert: Code "E" does not exist and should throw a
 * VendingMachineException
 * VendingMachineException exception =
 * assertThrows(VendingMachineException.class, () -> {
 * machine.addItem(testItem1, "E");
 * });
 * 
 * // Optional Assert: Verify the expected error message contents
 * assertTrue(exception.getMessage().contains("Invalid code"));
 * }
 * }
 */