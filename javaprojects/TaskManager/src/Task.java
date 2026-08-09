import java.time.LocalDate;
import java.time.LocalDateTime;

public class Task {
   private int id;
   private String title;
   private String description;

   private Priority priority;
   private TaskStatus status;

   private LocalDate dueDate;
   private LocalDateTime createdAt;

   public Task (int id, String title, String description, Priority priority, LocalDate dueDate){
		this.id = id;
		this.title = title;
		this.description = description;
		this.priority = priority;
		this.dueDate = dueDate;
		this.status = TaskStatus.PENDING;
		this.createdAt = LocalDateTime.now();
}

  public int getId(){return id;}
  public String getTitle(){return title;}
  public String getDescription(){return description;}
  public Priority getPriority(){return priority;}
  public TaskStatus getStatus(){return status;}
  public LocalDate getDueDate(){return dueDate;}
  public LocalDateTime getCreatedAt(){return createdAt;}

  public void setTitle(String title){this.title = title;}
  public void setDescription(String description){this.description = description;}
  public void setPriority(Priority priority){this.priority = priority;}
  public void setDueDate(LocalDate dueDate){this.dueDate = dueDate;}
  public void complete(){this.status = TaskStatus.COMPLETED;}
  public void cancel(){this.status = TaskStatus.CANCELLED;}
  public void reopen(){this.status = TaskStatus.PENDING;}

	@Override
	public String toString(){
	return "Task{" +
		"id=" + id +
		", title='" + title + '\'' +
		", description='" + description + '\'' +
		", priority='" + priority  +
		", status ='" + status +
		", dueDate ='" + dueDate + 
		", createdAt='" + createdAt +
		'}';
  

}
}
