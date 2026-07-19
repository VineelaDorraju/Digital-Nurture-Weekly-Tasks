import { useState } from 'react'

type Props = {
  onAdd: (title: string) => void
}

const TodoForm = ({ onAdd }: Props) => {
  const [value, setValue] = useState('')
  const [touched, setTouched] = useState(false)

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault()

    const trimmed = value.trim()

    if (!trimmed) {
      setTouched(true)
      return
    }

    onAdd(trimmed)
    console.log('Submitted:', trimmed)

    setValue('')
    setTouched(false)
  }

  const isInvalid = touched && value.trim().length === 0

  return (
    <form onSubmit={handleSubmit}>
      <input
        value={value}
        onChange={e => setValue(e.target.value)}
        onBlur={() => setTouched(true)}
        placeholder="Add a task"
        style={{
          width: '100%',
          padding: 8,
          border: isInvalid ? '1px solid red' : '1px solid #ccc'
        }}
      />

      {isInvalid && (
        <div style={{ color: 'red', fontSize: 12 }}>
          Task cannot be empty
        </div>
      )}

      <button
        type="submit"
        style={{ marginTop: 8 }}
      >
        Add
      </button>
    </form>
  )
}

export default TodoForm