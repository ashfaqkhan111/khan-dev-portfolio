import java.util.ArrayList;
import java.util.List;
public class TaskManager {

	private List<Task>tasks;
	
	public TaskManager(){
		tasks = new ArrayList<>();
}

	public void addTask(Task task) {
		tasks.add(task);
}

	public List<Task>getAllTasks(){
		return tasks;
}

	public Task findTaskById(int id){
		for (Task task task : tasks){
		    
		   if (task.getId() == id {
			return task;
}
}
			return null;
}



    
}
