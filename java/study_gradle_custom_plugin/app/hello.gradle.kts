class GreetingPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.tasks.register("greeting") {
            doLast {
                println("Hello, World!")
            }
        }
    }
}

apply<GreetingPlugin>()