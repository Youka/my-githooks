const { execSync } = require('node:child_process')

const WORKSPACE_PATH = '.githooks'

function configure() {
    try {
        execSync(`git config --local core.hooksPath "${WORKSPACE_PATH}"`, { stdio: 'pipe' })
        console.info(`Configured local githooks path: ${WORKSPACE_PATH}`)
    } catch (error) {
        console.error('Githooks path configuration failed:', error.stderr.toString())
    }
}

function check() {
    try {
        const outputMessage = execSync('git config core.hooksPath', { stdio: 'pipe' })
            .toString()
            .trim()
        console.info('Found githooks path:', outputMessage)
        if (outputMessage !== WORKSPACE_PATH) {
            configure()
        }
    } catch (error) {
        const errorMessage = error.stderr.toString()
        if (errorMessage) {
            console.error('Githooks path check failed:', errorMessage)
        } else {
            configure()
        }
    }
}

const isCiEnvironment = Object.entries(process.env)
    .find(([key, _]) => key.toLowerCase() === 'ci')
    ?.[1]
    ?.toLowerCase()
    === 'true'

if (!isCiEnvironment) {
    check()
}