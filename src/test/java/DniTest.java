import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class DniTest {

    @Test
    void should_fail_when_dni_longer_than_max_length() {

        Throwable thrown = catchThrowable(() -> {
            new Dni("0123456789");
        });

        assertThat(thrown).isInstanceOf(LengthException.class);
    }

    @Test
    void should_fail_when_dni_shorter_than_min_length() {
        Throwable thrown = catchThrowable(() -> {
            new Dni("01234567");
        });

        assertThat(thrown).isInstanceOf(LengthException.class);
    }

    @Test
    void should_fail_when_dni_ends_with_a_number() {
        Throwable thrown = catchThrowable(() -> {
            new Dni("012345678");
        });

        assertThat(thrown).isInstanceOf(DomainException.class).hasMessageContaining("Ends with number");
    }

    @Test
    void should_fail_when_dni_ends_with_an_invalid_letter() {
        Throwable thrown = catchThrowable(() -> {
            new Dni("01234567I");
        });

        assertThat(thrown).isInstanceOf(DomainException.class).hasMessageContaining("Ends with invalid letter");
    }

    @Test
    void should_fail_when_dni_has_letters_in_the_middle() {
        Throwable thrown = catchThrowable(() -> {
            new Dni("012AB567R");
        });

        assertThat(thrown).isInstanceOf(DomainException.class).hasMessageContaining("Has letters in the middle");
    }

    @Test
    void should_fail_when_dni_starts_with_a_letter_other_than_XYZ() {
        Throwable thrown = catchThrowable(() -> {
            new Dni("A1234567R");
        });

        assertThat(thrown).isInstanceOf(DomainException.class).hasMessageContaining("Starts with invalid letter");
    }

    @Test
    void should_fail_when_invalid_dni() {
        Throwable thrown = catchThrowable(() -> {
            new Dni("00000000S");
        });

        assertThat(thrown).isInstanceOf(InvalidArgumentException.class).hasMessageContaining("Invalid dni");
    }
}
