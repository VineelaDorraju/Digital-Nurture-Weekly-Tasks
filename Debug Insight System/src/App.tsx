import { useState, useEffect } from 'react'
import HomePage from './pages/HomePage'
import DebugPage from './pages/DebugPage'
import NotFound from './pages/NotFound'
import ErrorBoundary from './components/common/ErrorBoundary'

type Route = 'home' | 'debug' | '404'

const App = () => {
  const [route, setRoute] = useState<Route>('home')
  const [isReady, setIsReady] = useState(false)

  useEffect(() => {
    const timer = setTimeout(() => setIsReady(true), 300)
    return () => clearTimeout(timer)
  }, [])

  const resolveRoute = (): Route => {
    const path = window.location.pathname
    if (path.includes('debug')) return 'debug'
    if (path === '/' || path === '') return 'home'
    return '404'
  }

  useEffect(() => {
    setRoute(resolveRoute())
    const handler = () => setRoute(resolveRoute())
    window.addEventListener('popstate', handler)
    return () => window.removeEventListener('popstate', handler)
  }, [])

  const navigate = (path: string) => {
    window.history.pushState({}, '', path)
    setRoute(resolveRoute())
  }

  const renderPage = () => {
    if (!isReady) return null
    switch (route) {
      case 'home':
        return <HomePage navigate={navigate} />
      case 'debug':
        return <DebugPage navigate={navigate} />
      default:
        return <NotFound navigate={navigate} />
    }
  }

  return (
    <ErrorBoundary>
      {renderPage()}
    </ErrorBoundary>
  )
}

export default App