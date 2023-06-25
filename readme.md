# My githooks
A small collection of custom [git hooks](https://git-scm.com/docs/githooks) and their automatic activation in the local workspace.

## Structure
This project is for now...
* A minimal [gradle](https://gradle.org/) project with git hook activation defined in [build.gradle.kts](build.gradle.kts)
* A minimal [npm](https://www.npmjs.com/) project with git hook activation defined in [scripts/githooks.js](scripts/githooks.js) (triggered by [package.json](package.json))
* A git hook to check the format of commit messages defined in [.githooks/commit-msg](.githooks/commit-msg)
* A git hook to check the number of changed files in commits defined in [.githooks/pre-commit](.githooks/pre-commit)
* A git hook to check the project state before pushes defined in [.githooks/pre-push](.githooks/pre-push)

## Usage
* **Gradle:** Load gradle in your IDE or run any task (e.g. `gradlew tasks`)...
* **NPM:** Install dependencies (`npm install`)...
* **_Others_**: Call `git config --local core.hooksPath .githooks` (mention in your _readme_ as part of the project setup)...

...so [.githooks](.githooks) is set as your git hooks directory (entry can be found in [local git config](.git/config)).

[Commit](https://git-scm.com/docs/git-commit) any change with a message (`-m`) to see how hook **commit-msg** is working.  
Commit many changes with _added_ or _modified_ files to see how hook **pre-commit** is working.  
[Push](https://git-scm.com/docs/git-push) commits while your build system (gradle/npm) has a `check` task/script to see how hook **pre-push** is working.

Edit these hook files as needed for your project (e.g. other ticket prefix).