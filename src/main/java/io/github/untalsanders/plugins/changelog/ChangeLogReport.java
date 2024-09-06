package io.github.untalsanders.plugins.changelog;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * A Maven Plugin that create a file "touch.txt" in project build directory
 */
@Mojo(name = "changelog", defaultPhase = LifecyclePhase.PROCESS_SOURCES)
public class ChangeLogReport extends AbstractMojo {
    /**
     * Location of the file.
     */
    @Parameter(defaultValue = "${project.basedir}", property = "outputDir", required = true)
    private File outputDirectory;

    public void execute() throws MojoExecutionException {
        if (!outputDirectory.exists()) {
            getLog().info("Output directory has been created? " + outputDirectory.mkdirs());
        }

        File changelogFile = new File(outputDirectory, "CHANGELOG.md");

        try (FileWriter w = new FileWriter(changelogFile)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            w.write(LocalDateTime.now().format(formatter));
        } catch (IOException e) {
            throw new MojoExecutionException("Error creating file " + changelogFile, e);
        }
    }
}
