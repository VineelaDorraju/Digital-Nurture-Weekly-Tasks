export const fetchUsers = async () => {
  const r = await fetch('/users')
  return r.json()
}
export const createUser = async (u:any) => {
  const r = await fetch('/users',{
    method:'POST',
    body:JSON.stringify(u)
  })
  return r.json()
}