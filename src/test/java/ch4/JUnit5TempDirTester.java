package ch4;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JUnit5TempDirTester {

    @TempDir
    Path tempDir;

    private static Path createdFile;


    @Test
    public void testTemporaryFolder() throws IOException {
        assertTrue(Files.isDirectory(tempDir));
        createdFile = Files.createFile(
                tempDir.resolve("createdFile.txt") // Создадим файл в этом каталоге и проверим его существование
        );
        assertTrue(createdFile.toFile().exists());
    }

    /**
     * После выполнения тестов мы проверяем, что временный ресурс был удален.
     * Временная папка удаляется после завершения выполнения метода afterAll
     */
    @AfterAll
    public static void afterAll() {
        assertFalse(createdFile.toFile().exists());
    }

}
