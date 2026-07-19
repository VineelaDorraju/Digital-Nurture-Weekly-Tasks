type User = {
  name: string
  email: string
}

const UserProfile = ({ user }: { user: User }) => {
  return (
    <div>
      <h2>{user.name}</h2>
      <p>{user.email}</p>
    </div>
  )
}

export default UserProfile