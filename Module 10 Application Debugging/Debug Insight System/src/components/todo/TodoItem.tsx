import { useEffect, useRef } from 'react'

type Todo = {
  id: number
  title: string
  completed: boolean
}

type Props = {
  todo: Todo
  onToggle: (id: number) => void
}

const TodoItem = ({ todo, onToggle }: Props) => {
  const renderCount = useRef(0)

  useEffect(() => {
    renderCount.current += 1
    console.log(`Render count for ${todo.id}:`, renderCount.current)
  })

  const handleClick = () => {
    console.log('Before toggle:', todo)
    onToggle(todo.id)
    setTimeout(() => {
      console.log('After toggle (possible async state):', todo)
    }, 0)
  }

  return (
    <div
      onClick={handleClick}
      style={{
        padding: 10,
        marginBottom: 6,
        border: '1px solid #ccc',
        cursor: 'pointer',
        background: todo.completed ? '#e0ffe0' : '#fff',
        display: 'flex',
        justifyContent: 'space-between',
        alignItems: 'center'
      }}
    >
      <span
        style={{
          textDecoration: todo.completed ? 'line-through' : 'none'
        }}
      >
        {todo.title}
      </span>

      <small style={{ fontSize: 10 }}>
        renders: {renderCount.current}
      </small>
    </div>
  )
}

export default TodoItem