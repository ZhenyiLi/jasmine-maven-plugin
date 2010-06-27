package searls.jasmine;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import searls.jasmine.runner.SpecRunnerHtmlGenerator;

/**
 * @component
 * @goal test
 * @phase test
 */
public class JasmineMojo extends AbstractJasmineMojo {

	public void execute() throws MojoExecutionException, MojoFailureException {
		getLog().info("Executing Jasmine Tests");

		writeSpecRunnerToOutputDirectory();
	}

	private void writeSpecRunnerToOutputDirectory() {
		SpecRunnerHtmlGenerator htmlGenerator = new SpecRunnerHtmlGenerator();
		String html = htmlGenerator.generate(pluginArtifacts);
		try {
			getLog().debug("Writing out Spec Runner HTML " + html + " to directory " + jasmineTargetDir.getAbsolutePath());
			FileUtils.writeStringToFile(new File(jasmineTargetDir,specRunnerHtmlFileName), html);
		} catch (IOException e) {
			new RuntimeException("Failed to write Spec Runner to target directory", e);
		}
	}

}