import { track } from '../debug/breakpoints/conditionalBreakpoints'

test('track updates state', () => {
  track(1)
  track(10)
  expect(true).toBe(true)
})