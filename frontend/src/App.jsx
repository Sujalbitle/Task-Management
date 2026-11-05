
import { useState } from 'react';

import Header from './components/Header';
import StatsCard from './components/StatsCard';
import TaskCard from './components/TaskCard';

import './App.css';

function App() {
  const [tasks, setTasks] = useState([
    {
      id: 1,
      title: "Learn React",
      description: "Understand JSX and components.",
      completed: true
    },
    {
      id: 2,
      title: "Connect Spring Boot API",
      description: "Integrate frontend with backend.",
      completed: false
    },
    {
      id: 3,
      title: "Implement Task Management Features",
      description: "Add, edit, delete tasks.",
      completed: false
    },
    {
      id: 4,
      title: "Style the Application",
      description: "Use CSS to make it look good.",
      completed: true
    }
  ]);

  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");

  // Add a new task
  const handleAddTask = (event) => {
    event.preventDefault();

    if (!title.trim() || !description.trim()) {
      alert("Please enter both title and description");
      return;
    }

    const newTask = {
      id: Date.now(),
      title: title,
      description: description,
      completed: false
    };

    setTasks((previousTasks) => [...previousTasks, newTask]);

    setTitle("");
    setDescription("");
  };

  // Mark task as completed or pending
  function handleToggleTask(id) {
    setTasks(previousTasks =>
      previousTasks.map(task =>
        task.id === id
          ? { ...task, completed: !task.completed }
          : task
      )
    );
  }

  // Delete a task
  function handleDeleteTask(id) {
    setTasks(previousTasks =>
      previousTasks.filter(task => task.id !== id)
    );
  }

  // Calculate statistics
  const totalTasks = tasks.length;

  const completedTasks = tasks.filter(
    task => task.completed
  ).length;

  const pendingTasks = totalTasks - completedTasks;

  return (
    <div className="app">
      <Header />

      <section className="stats-container">
        <StatsCard title="Total Tasks" count={totalTasks} />
        <StatsCard title="Completed" count={completedTasks} />
        <StatsCard title="Pending" count={pendingTasks} />
      </section>

      <section className="tasks-section">
        <h2>My Tasks</h2>

        <form onSubmit={handleAddTask} className="task-form">
          <input
            type="text"
            placeholder="Task Title"
            value={title}
            onChange={(event) => setTitle(event.target.value)}
          />

          <input
            type="text"
            placeholder="Task Description"
            value={description}
            onChange={(event) => setDescription(event.target.value)}
          />

          <button type="submit">+ Add Task</button>
        </form>

        {tasks.map((task) => (
          <TaskCard
            key={task.id}
            task={task}
            onToggle={handleToggleTask}
            onDelete={handleDeleteTask}
          />
        ))}
      </section>
    </div>
  );
}

export default App;
