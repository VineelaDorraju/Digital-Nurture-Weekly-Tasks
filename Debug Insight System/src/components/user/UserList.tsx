type User = {
  id: number
  name: string
}

const UserList = ({ users }: { users: User[] }) => {
  return (
    <ul>
      {users.map(u => (
        <li key={u.id}>{u.name}</li>
      ))}
    </ul>
  )
}

export default UserList