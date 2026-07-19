import { useState } from 'react'

export const useApiStatus = () => {
  const [status, setStatus] = useState('idle')

  const run = async (fn:()=>Promise<any>) => {
    setStatus('loading')
    try {
      const res = await fn()
      setStatus('success')
      return res
    } catch {
      setStatus('error')
    }
  }

  return { status, run }
}