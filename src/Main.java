public class Main {
    public static void main(String[] args) {
        // Create a new museum
        Museum museum = new Museum("National Museum");

        // Create some artifacts
        Artifact artifact1 = new Artifact("Vase", "Ancient Greek vase from 5th century BC");
        Artifact artifact2 = new Artifact("Sculpture", "Roman marble sculpture from 2nd century AD");

        // Add artifacts to the museum
        museum.addArtifact(artifact1);
        museum.addArtifact(artifact2);

        // Get the list of artifacts in the museum
        System.out.println("Artifacts in the museum:");
        for (Artifact artifact : museum.getArtifacts()) {
            System.out.println(artifact.getName() + ": " + artifact.getDescription());
        }

        // Save the state of the museum
        museum.saveState();
        System.out.println("Museum state saved to 'state.csv'.");

        // Restore the state of the museum
        museum.restoreState();
        System.out.println("Museum state restored from 'state.csv'.");
    }
}