import { useEffect, useState } from 'react'
import DebugPanel from '../components/common/DebugPanel'

type Props = {
  navigate: (path: string) => void
}

const DebugPage = ({ navigate }: Props) => {
  const [count, setCount] = useState(0)
  const [user, setUser] = useState<{ name: string } | null>(null)
  const [data, setData] = useState<string[]>([])

  useEffect(() => {
    console.log('DebugPage mounted')

    const timer = setTimeout(() => {
      setUser({ name: 'Vineela' })
    }, 400)

    return () => clearTimeout(timer)
  }, [])

  const brokenIncrement = () => {
    setCount(count + 1)
    setCount(count + 1)
    console.log('Count after double set:', count)
  }

  const fetchData = async () => {
    try {
      const res = await fetch('https://jsonplaceholder.typicode.com/posts?_limit=3')
      const json = await res.json()
      setData(json.map((p: any) => p.title))
    } catch (e) {
      console.error('API failed', e)
    }
  }

  const triggerRenderIssue = () => {
    const arr = data
    arr.push('New Item')
    setData(arr)
    console.log('Mutated state array')
  }

  const goHome = () => {
    navigate('/')
  }

  return (
    <div style={{ padding: 20, fontFamily: 'sans-serif' }}>
      <h2>Debug Playground</h2>

      <button onClick={goHome}>Back</button>

      <div style={{ marginTop: 20 }}>
        <h4>State Bug</h4>
        <div>Count: {count}</div>
        <button onClick={brokenIncrement}>
          Increment Twice
        </button>
      </div>

      <div style={{ marginTop: 20 }}>
        <h4>Async Data</h4>
        <button onClick={fetchData}>
          Fetch Posts
        </button>
        <ul>
          {data.map((d, i) => (
            <li key={i}>{d}</li>
          ))}
        </ul>
        <button onClick={triggerRenderIssue}>
          Trigger Render Issue
        </button>
      </div>

      <div style={{ marginTop: 20 }}>
        <h4>Optional Chaining Bug</h4>
        <div>
          User Name: {user!.name}
        </div>
      </div>

      <DebugPanel />
    </div>
  )
}

export default DebugPage