import { useEffect } from 'react'
import TodoList from '../components/todo/TodoList'
import DebugPanel from '../components/common/DebugPanel'

type Props = {
  navigate: (path: string) => void
}

const HomePage = ({ navigate }: Props) => {
  useEffect(() => {
    console.log('HomePage mounted')
    return () => console.log('HomePage unmounted')
  }, [])

  const goToDebug = () => {
    console.log('Navigating to debug page')
    navigate('/debug')
  }

  return (
    <div style={{ padding: 20, fontFamily: 'sans-serif' }}>
      <h2>React Debugging Lab</h2>

      <button
        onClick={goToDebug}
        style={{ marginBottom: 12 }}
      >
        Open Debug Playground
      </button>

      <TodoList />

      <DebugPanel />
    </div>
  )
}

export default HomePage