import java.io.IOException
import java.io.InputStream

object GithooksPath {
    private const val WORKSPACE_PATH = ".githooks"

    private fun configure() =
        ProcessBuilder("git", "config", "--local", "core.hooksPath", WORKSPACE_PATH)
            .start()
            .takeIf { it.waitFor() != 0 }
            ?.run(Process::getErrorStream)
            ?.run(InputStream::readBytes)
            ?.run(ByteArray::decodeToString)
            ?.run("Githooks path configuration failed: "::plus)
            ?.run(System.err::println)
            ?: println("Configured local githooks path: $WORKSPACE_PATH")

    fun check() =
        ProcessBuilder("git", "config", "core.hooksPath")
            .start()
            .takeIf { it.waitFor() == 0 }
            ?.run(Process::getInputStream)
            ?.run(InputStream::readBytes)
            ?.run(ByteArray::decodeToString)
            ?.run(String::trim)
            ?.also { println("Found githooks path: $it") }
            ?.takeIf { it == WORKSPACE_PATH }
            ?.let { }   // Reduce return to <Unit>
            ?: this.configure()
}

val isCiEnvironment = System.getenv()
    .entries
    .firstOrNull { (key, _) -> key.equals("ci", true) }
    ?.value
    ?.equals("true", true)
    ?: false

if (!isCiEnvironment) {
    try {
        GithooksPath.check()
    } catch(exception: IOException) {
        System.err.run {
            println("GithooksPath check failed (see stacktrace below):")
            exception.printStackTrace(this)
        }
    }
}