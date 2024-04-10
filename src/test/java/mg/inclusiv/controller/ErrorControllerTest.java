package mg.inclusiv.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ErrorControllerTest {
    @InjectMocks
    private ErrorController errorController;

    @Mock
    private Model model;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testException() {
        String errorMessage = "Test error message";
        Throwable throwable = new Throwable(errorMessage);

        String result = errorController.exception(throwable, model);

        // Verify that addAttribute method is called with expected parameters
        verify(model, times(1)).addAttribute("errorMessage", errorMessage);
        assertEquals("error", result);
    }

    @Test
    public void testExceptionWithNullThrowable() {
        String result = errorController.exception(null, model);

        // Verify that addAttribute method is called with "Unknown error" message
        verify(model, times(1)).addAttribute("errorMessage", "Unknown error");
        assertEquals("error", result);
    }

}
