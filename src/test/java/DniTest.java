import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class DniTest {

    @Test
    void should_fail_when_dni_longer_than_max_length() {

        Throwable thrown = catchThrowable(() -> {
            Dni dni = new Dni("0123456789");
        });

        assertThat(thrown).isInstanceOf(LengthException.class).hasMessageContaining("Too long");
    }

    @Test
    void should_fail_when_dni_shorter_than_min_length() {
        Throwable thrown = catchThrowable(() -> {
            Dni dni = new Dni("01234567");
        });

        assertThat(thrown).isInstanceOf(LengthException.class).hasMessageContaining("Too short");
    }
}
