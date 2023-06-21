# My githooks
A small collection of custom [git hooks](https://git-scm.com/docs/githooks) and their automatic activation in workspace.

## Structure
This project is for now...
* A minimal gradle project with git hook activation defined in **build.gradle.kts**
* A git hook to check the format of commit messages defined in **.githooks/commit-msg**

## Usage
Load gradle in your IDE or run any task (e.g. `gradlew tasks`) so [.githooks](.githooks) is set as your git hooks directory (entry can be found in [local git config](.git/config)).

Then [commit](https://git-scm.com/docs/git-commit) any change with a message (`-m`) to see how the hook `commit-msg` is working and edit it as needed.