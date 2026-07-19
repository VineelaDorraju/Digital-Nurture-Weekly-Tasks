export const Profile = ({ user }: any) => (
  <div>
    {user && user.name && <span>{user.age}</span>}
  </div>
)