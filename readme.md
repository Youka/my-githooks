# My githooks
A small collection of custom [git hooks](https://git-scm.com/docs/githooks) and their automatic activation in workspace.

## Structure
This project is for now...
* A minimal [gradle](https://gradle.org/) project with git hook activation defined in [build.gradle.kts](build.gradle.kts)
* A minimal [npm](https://www.npmjs.com/) project with git hook activation defined in [scripts/githooks.js](scripts/githooks.js) (triggered by [package.json](package.json))
* A git hook to check the format of commit messages defined in [.githooks/commit-msg](.githooks/commit-msg)

## Usage
* **Gradle:** Load gradle in your IDE or run any task (e.g. `gradlew tasks`)...
* **NPM:** Install dependencies (`npm install`)...

...so [.githooks](.githooks) is set as your git hooks directory (entry can be found in [local git config](.git/config)).

Then [commit](https://git-scm.com/docs/git-commit) any change with a message (`-m`) to see how the hook **commit-msg** is working and edit it as needed.