import { useRef, useEffect } from 'react'
export const useDebug = (v:any) => {
  const prev = useRef(v)
  useEffect(() => {
    if(prev.current !== v) {
      console.log('changed:', prev.current, '->', v)
      prev.current = v
    }
  })
}