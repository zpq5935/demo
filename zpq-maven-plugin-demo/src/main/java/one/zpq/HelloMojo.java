package one.zpq;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = "hello", defaultPhase = LifecyclePhase.CLEAN)
public class HelloMojo extends AbstractMojo {
    @Parameter
    private String name;


    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("hello" + name);
    }
}
