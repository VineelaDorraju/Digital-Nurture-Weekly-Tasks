import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App'

const container = document.getElementById('root') as HTMLElement

const root = ReactDOM.createRoot(container)

const bootstrap = async () => {
  try {
    root.render(
      <React.StrictMode>
        <App />
      </React.StrictMode>
    )
  } catch (err) {
    console.error('Application failed to start', err)
  }
}

bootstrap()