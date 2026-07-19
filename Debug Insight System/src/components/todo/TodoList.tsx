import { useEffect, useMemo, useState } from 'react'
import TodoItem from './TodoItem'
import TodoForm from './TodoForm'

type Todo = {
  id: number
  title: string
  completed: boolean
}

const TodoList = () => {
  const [todos, setTodos] = useState<Todo[]>([])
  const [query, setQuery] = useState('')
  const [loading, setLoading] = useState(true)

  useEffect(() => {
    const timer = setTimeout(() => {
      setTodos([
        { id: 1, title: 'Learn debugging', completed: false },
        { id: 2, title: 'Fix state issues', completed: true }
      ])
      setLoading(false)
    }, 500)

    return () => clearTimeout(timer)
  }, [])

  const addTodo = (title: string) => {
    const newTodo: Todo = {
      id: Date.now(),
      title,
      completed: false
    }
    setTodos(prev => [newTodo, ...prev])
    console.log('Todo added:', newTodo)
  }

  const toggleTodo = (id: number) => {
    setTodos(prev =>
      prev.map(todo =>
        todo.id === id
          ? { ...todo, completed: !todo.completed }
          : todo
      )
    )
    console.log('Toggled todo id:', id)
  }

  const filteredTodos = useMemo(() => {
    return todos.filter(t =>
      t.title.toLowerCase().includes(query.toLowerCase())
    )
  }, [todos, query])

  if (loading) return <div>Loading todos...</div>

  return (
    <div style={{ maxWidth: 420, margin: '0 auto' }}>
      <h3>Todo Debug Lab</h3>

      <TodoForm onAdd={addTodo} />

      <input
        value={query}
        onChange={e => setQuery(e.target.value)}
        placeholder="search todos"
        style={{ width: '100%', margin: '10px 0' }}
      />

      <div>
        {filteredTodos.map(todo => (
          <TodoItem
            key={todo.id}
            todo={todo}
            onToggle={toggleTodo}
          />
        ))}
      </div>

      {filteredTodos.length === 0 && (
        <div>No matching todos</div>
      )}
    </div>
  )
}

export default TodoList