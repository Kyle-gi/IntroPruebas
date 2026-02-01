package util;

import org.junit.jupiter.api.Test;
import org.sergiolozanoprofe.model.OperationType;
import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

    @Test
    void testParseIntValid() {
        assertEquals(5, org.sergiolozanoprofe.util.InputParser.parseInt("5"));
        assertEquals(-3, org.sergiolozanoprofe.util.InputParser.parseInt("-3"));
        assertEquals(0, org.sergiolozanoprofe.util.InputParser.parseInt("0"));
        assertEquals(12345, org.sergiolozanoprofe.util.InputParser.parseInt("12345"));
    }

    @Test
    void testParseIntWithSpaces() {
        assertEquals(5, org.sergiolozanoprofe.util.InputParser.parseInt("  5  "));
        assertEquals(-3, org.sergiolozanoprofe.util.InputParser.parseInt("  -3  "));
    }

    @Test
    void testParseIntInvalid() {
        assertThrows(NumberFormatException.class, () -> {
            org.sergiolozanoprofe.util.InputParser.parseInt("abc");
        });

        assertThrows(NumberFormatException.class, () -> {
            org.sergiolozanoprofe.util.InputParser.parseInt("12.34");
        });
    }

    @Test
    void testParseIntNull() {
        assertThrows(NumberFormatException.class, () -> {
            org.sergiolozanoprofe.util.InputParser.parseInt(null);
        });
    }

    @Test
    void testParseOperationSymbols() {
        assertEquals(OperationType.ADD, org.sergiolozanoprofe.util.InputParser.parseOperation("+"));
        assertEquals(OperationType.SUBTRACT, org.sergiolozanoprofe.util.InputParser.parseOperation("-"));
        assertEquals(OperationType.MULTIPLY, org.sergiolozanoprofe.util.InputParser.parseOperation("*"));
        assertEquals(OperationType.DIVIDE, org.sergiolozanoprofe.util.InputParser.parseOperation("/"));
    }

    @Test
    void testParseOperationEnglishWords() {
        assertEquals(OperationType.ADD, org.sergiolozanoprofe.util.InputParser.parseOperation("add"));
        assertEquals(OperationType.SUBTRACT, org.sergiolozanoprofe.util.InputParser.parseOperation("subtract"));
        assertEquals(OperationType.MULTIPLY, org.sergiolozanoprofe.util.InputParser.parseOperation("multiply"));
        assertEquals(OperationType.DIVIDE, org.sergiolozanoprofe.util.InputParser.parseOperation("divide"));
    }

    @Test
    void testParseOperationSpanishWords() {
        assertEquals(OperationType.ADD, org.sergiolozanoprofe.util.InputParser.parseOperation("suma"));
        assertEquals(OperationType.SUBTRACT, org.sergiolozanoprofe.util.InputParser.parseOperation("resta"));
        assertEquals(OperationType.MULTIPLY, org.sergiolozanoprofe.util.InputParser.parseOperation("multiplicacion"));
        assertEquals(OperationType.DIVIDE, org.sergiolozanoprofe.util.InputParser.parseOperation("division"));
    }

    @Test
    void testParseOperationCaseInsensitive() {
        assertEquals(OperationType.ADD, org.sergiolozanoprofe.util.InputParser.parseOperation("ADD"));
        assertEquals(OperationType.ADD, org.sergiolozanoprofe.util.InputParser.parseOperation("Add"));
        assertEquals(OperationType.ADD, org.sergiolozanoprofe.util.InputParser.parseOperation("sum"));
    }

    @Test
    void testParseOperationInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            org.sergiolozanoprofe.util.InputParser.parseOperation("invalid");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            org.sergiolozanoprofe.util.InputParser.parseOperation("++");
        });
    }

    @Test
    void testParseOperationNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            org.sergiolozanoprofe.util.InputParser.parseOperation(null);
        });
    }
}
