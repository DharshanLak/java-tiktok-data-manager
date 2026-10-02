package tiktokers;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArrayListMyTikTokManagerTest {

    private MyTikTokManager dir;
    private MyTikTokManager topTen;

    @BeforeEach
    public void setUp() {
        dir = new ArrayListMyTikTokManager();

        topTen = new ArrayListMyTikTokManager();
        topTen.load("src/Top10TikTokers.txt");
    }

    @Test
    public void anEmptyDirectoryHasNoRumpledEater() {
        assertNull(dir.get("@rumpledeater", "Followers"));
    }

    @Test
    public void basicRemove() {
        dir.put("@testuser", "Followers", "1000");

        dir.remove("@testuser", "Followers");

        assertNull(dir.get("@testuser", "Followers"));
    }

    @Test
    public void removeNonExistentEntryEmptyManager() {
        assertThrows(NoSuchElementException.class, () -> {
            dir.remove("@testuser", "Followers");
        });
    }

    @Test
    public void removeNonExistentEntryNonEmptyManager() {
        dir.put("@charlidamelio", "Followers", "137000000");

        assertThrows(NoSuchElementException.class, () -> {
            dir.remove("@testuser", "Followers");
        });
    }

    @Test
    public void topTenContainsBurak() {
        assertNotNull(topTen.get("@cznburak", "Followers"));
    }
}