
function TaskCard({ task, onToggle, onDelete }) {
  return (
    <div className="task-card">
      <div>
        <h3>{task.title}</h3>
        <p>{task.description}</p>
      </div>

      <div className="task-actions">
        <span className={task.completed ? "completed" : "pending"}>
          {task.completed ? "Completed" : "Pending"}
        </span>

        <button onClick={() => onToggle(task.id)}>
          {task.completed ? "Undo" : "Complete"}
        </button>

        <button onClick={() => onDelete(task.id)}>
          Delete
        </button>
      </div>
    </div>
  );
}

export default TaskCard;
