import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 *
 * @author Konstantin Krivopustov
 */
class DocPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.configurations {
            chopper
        }

        project.dependencies {
            chopper(group: 'xyz.knstvk', name: 'asciidoc-html-chopper', version: '1.0.1', ext: 'zip')
        }
    }
}
