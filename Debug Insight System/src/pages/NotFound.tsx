import { useEffect } from 'react'

type Props = {
  navigate: (path: string) => void
}

const NotFound = ({ navigate }: Props) => {
  useEffect(() => {
    console.warn('Route not found')
  }, [])

  const goHome = () => {
    navigate('/')
  }

  return (
    <div
      style={{
        height: '100vh',
        display: 'flex',
        flexDirection: 'column',
        justifyContent: 'center',
        alignItems: 'center',
        fontFamily: 'sans-serif'
      }}
    >
      <h1>404</h1>
      <p>Page not found</p>

      <button onClick={goHome}>
        Go Back Home
      </button>
    </div>
  )
}

export default NotFound