import { render, screen } from '@testing-library/react'
import UserList from '../components/userlist'

test('renders multiple users', () => {
  render(<UserList users={[
    {id:1,name:'A'},
    {id:2,name:'B'}
  ]} />)
  expect(screen.getByText('A')).toBeTruthy()
  expect(screen.getByText('B')).toBeTruthy()
})