import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Museum {
    private String name;
    private List<Artifact> artifacts;

    public Museum(String name) {
        this.name = name;
        this.artifacts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Artifact> getArtifacts() {
        return artifacts;
    }

    public void addArtifact(Artifact artifact) {
        artifacts.add(artifact);
    }

    public void removeArtifact(Artifact artifact) {
        artifacts.remove(artifact);
    }

    public void saveState() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("state.csv"))) {
            for (Artifact artifact : artifacts) {
                writer.write(artifact.getName() + "," + artifact.getDescription() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error saving state: " + e.getMessage());
        }
    }

    public void restoreState() {
        try (BufferedReader reader = new BufferedReader(new FileReader("state.csv"))) {
            String line;
            artifacts.clear(); // Clear the existing artifacts
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                String description = parts[1];
                Artifact artifact = new Artifact(name, description);
                artifacts.add(artifact);
            }
        } catch (IOException e) {
            System.err.println("Error restoring state: " + e.getMessage());
        }
    }
}