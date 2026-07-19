import { useEffect, useMemo, useState } from 'react'

type Log = {
  id: number
  message: string
  time: string
}

const DebugPanel = () => {
  const [logs, setLogs] = useState<Log[]>([])
  const [visible, setVisible] = useState(true)
  const [filter, setFilter] = useState('')

  useEffect(() => {
    const original = console.log

    console.log = (...args: unknown[]) => {
      const entry: Log = {
        id: Date.now() + Math.random(),
        message: args.map(a => String(a)).join(' '),
        time: new Date().toLocaleTimeString()
      }

      setLogs(prev => [entry, ...prev].slice(0, 20))
      original(...args)
    }

    return () => {
      console.log = original
    }
  }, [])

  const filteredLogs = useMemo(() => {
    return logs.filter(l => l.message.toLowerCase().includes(filter.toLowerCase()))
  }, [logs, filter])

  if (!visible) {
    return (
      <button
        onClick={() => setVisible(true)}
        style={{
          position: 'fixed',
          bottom: 10,
          right: 10
        }}
      >
        Open Debug
      </button>
    )
  }

  return (
    <div
      style={{
        position: 'fixed',
        bottom: 0,
        right: 0,
        width: 320,
        height: 260,
        background: '#111',
        color: '#0f0',
        fontSize: 12,
        padding: 10,
        overflow: 'hidden'
      }}
    >
      <div style={{ display: 'flex', justifyContent: 'space-between' }}>
        <strong>Debug Panel</strong>
        <button onClick={() => setVisible(false)}>x</button>
      </div>

      <input
        value={filter}
        onChange={e => setFilter(e.target.value)}
        placeholder="filter logs"
        style={{
          width: '100%',
          margin: '6px 0',
          fontSize: 12
        }}
      />

      <div
        style={{
          overflowY: 'auto',
          height: '75%'
        }}
      >
        {filteredLogs.map(log => (
          <div key={log.id}>
            [{log.time}] {log.message}
          </div>
        ))}
      </div>

      <button
        onClick={() => setLogs([])}
        style={{ marginTop: 4 }}
      >
        Clear
      </button>
    </div>
  )
}

export default DebugPanel