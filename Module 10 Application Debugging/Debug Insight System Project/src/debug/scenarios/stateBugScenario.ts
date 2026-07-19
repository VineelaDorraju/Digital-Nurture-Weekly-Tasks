let state = { count: 0 }

export const increment = () => {
  state.count++   // mutation bug
}