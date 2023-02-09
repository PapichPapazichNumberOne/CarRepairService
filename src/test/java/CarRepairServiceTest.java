import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.example.CarRepairService;
import org.junit.jupiter.api.Test;

class CarRepairServiceTest {

    @Test
    void testSelectionOfServices() {
        String input = "1\n2\n0\n100\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        CarRepairService.main(new String[] {});
        String output = out.toString();

        assertTrue(output.contains("Замена масла - $30.0"));
        assertTrue(output.contains("Вращение шины - $40.0"));
        assertTrue(output.contains("Общая стоимость: $70.0"));
        assertTrue(output.contains("Ваша сдача: $30.0"));
    }
}
