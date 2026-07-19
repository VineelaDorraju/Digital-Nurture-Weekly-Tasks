export const apiClient = async (url:string, opts:RequestInit={}) => {
  const res = await fetch(url, opts)
  if(!res.ok) throw new Error('request failed')
  return res.json()
}