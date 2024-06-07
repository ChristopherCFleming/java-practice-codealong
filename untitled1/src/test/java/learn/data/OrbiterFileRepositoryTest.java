package learn.data;

import learn.models.Orbiter;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class OrbiterFileRepositoryTest {
    private OrbiterFileRepository repository = new OrbiterFileRepository("./data/orbiters.csv");

    @Test
    void shouldFindFiveOrbiters() {
        List<Orbiter> actual = repository.findAll();
        assertNotNull(actual);
        assertEquals(5, actual.size());
    }

    @Test
    void shouldFindExistingOrbiter(){
        Orbiter A1 = repository.findByID(1);
        assertNotNull(A1);
        assertEquals("A1", A1.getName());
    }

    @Test
    void shouldNotFindExistingOrbiter(){
        Orbiter nope = repository.findByID(1000);
        assertNull(nope);
    }

}