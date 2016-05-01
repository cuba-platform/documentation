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
            chopper('org.apache.commons:commons-lang3:3.4')
        }
    }
}
