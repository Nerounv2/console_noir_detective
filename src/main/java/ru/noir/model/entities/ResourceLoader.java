package ru.noir.model.entities;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ResourceLoader {

    private final List<String> names;
    private final List<String> surnames;
    public ResourceLoader() throws IOException {
        this.names = loadNames();
        this.surnames = loadSurNames();

    }

    private ArrayList<String> loadNames() throws IOException {
        List<String> lines= Files.readAllLines(Path.of("src/main/java/ru/noir/model/entities/Names"), StandardCharsets.UTF_8);
        return new ArrayList<>(lines);
    }

    private ArrayList<String> loadSurNames() throws IOException{
        List<String> lines= Files.readAllLines(Path.of("src/main/java/ru/noir/model/entities/Surnames"), StandardCharsets.UTF_8);

        return new ArrayList<>(lines);
    }

    public List<String> getSurnames() {
        return surnames;
    }

    public List<String> getNames() {
        return names;
    }
}
