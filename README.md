# AikHsu Bot

This is a simple tasks record bot named after my friend Aik Hsu. It is able to provide simple *create-read-update-delete* functionality through a GUI interface. The usage instructions are as follows:

## Setting up

Prerequisites: JDK 17

1. Download the latest release (here)[https://github.com/zedonggg/ip/releases]
2. Run using `java -jar Aikhsu.jar`

## Features
Aikhsu provides support for 3 types of tasks using the specified command format as shown below:
1. Todo tasks using the command `todo [name]`
2. Deadline tasks using the command `deadline [name] /by [DD/MM/YYYY] [hh:mm]`
3. Event tasks using the command `event [name] /from [DD/MM/YYYY] [hh:mm] /to [hh:mm]`

Tasks are automatically saved to an `Aikhsu.txt` file in the same directory as the `jar` file.

Other helpful functions:
- `list` : lists out current task
- `mark [number]` : marks the specified task as done
- `unmark [number]` : marks the specified task as not done
- `bye` : exits the program
- `delete [number]` : deletes the specified task
- `find [task]` : searches for all tasks that matches the provided string task name
- `findbydate [DD/MM/YYYY]` : lists all tasks on the given date

Enjoy!

