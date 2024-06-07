package learn.data;

import learn.models.Orbiter;
import learn.models.OrbiterType;
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

    @Test
    void shouldFindOneOfEachType(){
        List<Orbiter> modules = repository.findByType(OrbiterType.MODULE);
        assertNotNull(modules);
        assertEquals(1, modules.size());

        List<Orbiter> modulesWithDocks = repository.findByType(OrbiterType.MODULE_WITH_DOCK);
        assertNotNull(modulesWithDocks);
        assertEquals(1, modules.size());

        List<Orbiter> shuttles = repository.findByType(OrbiterType.SHUTTLE);
        assertNotNull(shuttles);
        assertEquals(1, modules.size());

        List<Orbiter> astronauts = repository.findByType(OrbiterType.ASTRONAUT);
        assertNotNull(astronauts);
        assertEquals(1, modules.size());

        List<Orbiter> venusians = repository.findByType(OrbiterType.VENUSIAN);
        assertNotNull(venusians);
        assertEquals(1, modules.size());
    }

}