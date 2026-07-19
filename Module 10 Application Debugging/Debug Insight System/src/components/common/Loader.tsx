import { useEffect, useState } from 'react'

type Props = {
  size?: number
  label?: string
}

const Loader = ({ size = 32, label }: Props) => {
  const [dots, setDots] = useState('')

  useEffect(() => {
    const interval = setInterval(() => {
      setDots(prev => (prev.length >= 3 ? '' : prev + '.'))
    }, 400)

    return () => clearInterval(interval)
  }, [])

  return (
    <div
      style={{
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
        justifyContent: 'center',
        padding: 20,
        fontFamily: 'sans-serif'
      }}
    >
      <div
        style={{
          width: size,
          height: size,
          border: '3px solid #ddd',
          borderTop: '3px solid #333',
          borderRadius: '50%',
          animation: 'spin 0.8s linear infinite'
        }}
      />

      {label && (
        <div style={{ marginTop: 10, fontSize: 14 }}>
          {label}{dots}
        </div>
      )}

      <style>
        {`
          @keyframes spin {
            from { transform: rotate(0deg); }
            to { transform: rotate(360deg); }
          }
        `}
      </style>
    </div>
  )
}

export default Loader