public abstract class Command {

    protected TaskList tasks;
    public abstract CommandResult execute();

    public void setTasks(TaskList tasks) {
        this.tasks = tasks;
    }

}
